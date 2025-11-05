package com.discord.rtcconnection.audio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.annotation.MainThread;
import b.a.q.k0.f;
import b.a.q.k0.h;
import b.a.q.k0.i;
import b.a.q.l0.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import com.discord.rtcconnection.enums.ScoAudioState;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.g;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: DiscordAudioManager.kt */
/* loaded from: classes.dex */
public final class DiscordAudioManager {
    public static final Lazy a = g.lazy(d.j);

    /* renamed from: b, reason: collision with root package name */
    public static final AudioDevice f2784b = new AudioDevice(null, false, null, null, 15);
    public static final List<DeviceTypes> c = n.listOf((Object[]) new DeviceTypes[]{DeviceTypes.EARPIECE, DeviceTypes.SPEAKERPHONE, DeviceTypes.BLUETOOTH_HEADSET, DeviceTypes.WIRED_HEADSET});
    public static final DiscordAudioManager d = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final AudioManager e;
    public final BluetoothManager f;
    public final Lazy g;
    public final boolean h;
    public final Object i;
    public final long j;
    public final ContentResolver k;
    public final b.a.q.k0.c l;
    public final b.a.q.k0.a m;
    public BluetoothHeadset n;
    public BluetoothScoState o;
    public AudioManager.OnAudioFocusChangeListener p;
    public AudioFocusRequest q;
    public List<AudioDevice> r;

    /* renamed from: s, reason: collision with root package name */
    public final SerializedSubject<List<AudioDevice>, List<AudioDevice>> f2785s;
    public DeviceTypes t;
    public final SerializedSubject<DeviceTypes, DeviceTypes> u;
    public ContentObserver v;
    public int w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2786x;

    /* renamed from: y, reason: collision with root package name */
    public final SerializedSubject<Integer, Integer> f2787y;

    /* renamed from: z, reason: collision with root package name */
    public DeviceTypes f2788z;

    /* compiled from: DiscordAudioManager.kt */
    public static final /* data */ class AudioDevice {

        /* renamed from: a, reason: from kotlin metadata */
        public final DeviceTypes type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isAvailable;

        /* renamed from: c, reason: from kotlin metadata */
        public final String id;

        /* renamed from: d, reason: from kotlin metadata */
        public final String name;

        public AudioDevice() {
            this(null, false, null, null, 15);
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2) {
            m.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = str;
            this.name = str2;
        }

        public static AudioDevice a(AudioDevice audioDevice, DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
            DeviceTypes deviceTypes2 = (i & 1) != 0 ? audioDevice.type : null;
            if ((i & 2) != 0) {
                z2 = audioDevice.isAvailable;
            }
            if ((i & 4) != 0) {
                str = audioDevice.id;
            }
            if ((i & 8) != 0) {
                str2 = audioDevice.name;
            }
            Objects.requireNonNull(audioDevice);
            m.checkNotNullParameter(deviceTypes2, "type");
            return new AudioDevice(deviceTypes2, z2, str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioDevice)) {
                return false;
            }
            AudioDevice audioDevice = (AudioDevice) other;
            return m.areEqual(this.type, audioDevice.type) && this.isAvailable == audioDevice.isAvailable && m.areEqual(this.id, audioDevice.id) && m.areEqual(this.name, audioDevice.name);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            DeviceTypes deviceTypes = this.type;
            int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
            boolean z2 = this.isAvailable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            String str = this.id;
            int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("AudioDevice(type=");
            sbU.append(this.type);
            sbU.append(", isAvailable=");
            sbU.append(this.isAvailable);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", name=");
            return b.d.b.a.a.J(sbU, this.name, ")");
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
            deviceTypes = (i & 1) != 0 ? DeviceTypes.INVALID : deviceTypes;
            z2 = (i & 2) != 0 ? false : z2;
            int i2 = i & 4;
            int i3 = i & 8;
            m.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = null;
            this.name = null;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public enum BluetoothScoState {
        INVALID(-1),
        OFF(0),
        ON(1),
        TURNING_ON(2),
        TURNING_OFF(3);

        private final int value;

        BluetoothScoState(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public enum DeviceTypes {
        DEFAULT(-2),
        INVALID(-1),
        SPEAKERPHONE(0),
        WIRED_HEADSET(1),
        EARPIECE(2),
        BLUETOOTH_HEADSET(3);

        private final int value;

        DeviceTypes(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            b.a.q.k0.a aVar = discordAudioManager.m;
            Objects.requireNonNull(aVar);
            ThreadUtils.checkIsOnMainThread();
            boolean profileProxy = false;
            List listListOf = n.listOf((Object[]) new AudioManagerBroadcastAction[]{AudioManagerBroadcastAction.HeadsetPlug, AudioManagerBroadcastAction.ScoAudioStateUpdated});
            b.c.a.a0.d.b1("AudioManagerBroadcastReceiver", "registering for broadcasts with actions: " + listListOf);
            IntentFilter intentFilter = new IntentFilter();
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(((AudioManagerBroadcastAction) it.next()).getAction());
            }
            aVar.f261b.registerReceiver(aVar, intentFilter);
            b.a.q.k0.c cVar = discordAudioManager.l;
            Objects.requireNonNull(cVar);
            ThreadUtils.checkIsOnMainThread();
            if (!cVar.l) {
                StringBuilder sbU = b.d.b.a.a.U("registering for broadcasts with actions: ");
                Set<BluetoothBroadcastAction> set = b.a.q.k0.c.j;
                sbU.append(set);
                b.c.a.a0.d.b1("BluetoothBroadcastReceiver", sbU.toString());
                IntentFilter intentFilter2 = new IntentFilter();
                Iterator<T> it2 = set.iterator();
                while (it2.hasNext()) {
                    intentFilter2.addAction(((BluetoothBroadcastAction) it2.next()).getAction());
                }
                cVar.n.registerReceiver(cVar, intentFilter2);
                b.a.q.k0.d dVar = b.a.q.k0.d.c;
                Lazy lazy = b.a.q.k0.d.a;
                if (((String) lazy.getValue()) != null) {
                    Context context = cVar.n;
                    m.checkNotNullParameter(context, "context");
                    m.checkNotNullParameter(cVar, "receiver");
                    try {
                        String str = (String) lazy.getValue();
                        if (str != null) {
                            context.registerReceiver(cVar, new IntentFilter(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
                try {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        profileProxy = defaultAdapter.getProfileProxy(cVar.n, cVar, 1);
                    }
                } catch (SecurityException e) {
                    b.c.a.a0.d.f1("BluetoothBroadcastReceiver", "failed to get BluetoothHeadset profile: " + e);
                }
                if (profileProxy) {
                    b.c.a.a0.d.b1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy");
                } else {
                    b.c.a.a0.d.c1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy failed", null);
                }
                cVar.l = true;
            }
            b.a.q.k0.e eVar = new b.a.q.k0.e(discordAudioManager);
            synchronized (discordAudioManager.i) {
                discordAudioManager.p = eVar;
            }
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public final class b implements h {
        public b() {
        }

        @Override // b.a.q.k0.h
        public void a(Context context, boolean z2) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.h
        @MainThread
        public void b(Context context, ScoAudioState.b bVar) {
            boolean z2;
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(bVar, "scoAudioStateUpdate");
            int iOrdinal = bVar.a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                b.c.a.a0.d.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + bVar);
                DiscordAudioManager.this.j();
                return;
            }
            b.c.a.a0.d.b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + bVar);
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            BluetoothScoState bluetoothScoState = discordAudioManager.o;
            discordAudioManager.k();
            int iOrdinal2 = bluetoothScoState.ordinal();
            if (iOrdinal2 == 2) {
                synchronized (DiscordAudioManager.this.i) {
                    z2 = DiscordAudioManager.this.D;
                }
                if (z2) {
                    b.c.a.a0.d.b1("DiscordAudioManager", "SCO off detected directly from ON. Refreshing Bluetooth device");
                    DiscordAudioManager.this.j();
                    DiscordAudioManager.this.l();
                    return;
                }
                return;
            }
            if (iOrdinal2 != 3) {
                return;
            }
            StringBuilder sbU = b.d.b.a.a.U("Unable to turn on SCO. Clearing Bluetooth device. mode: ");
            sbU.append(DiscordAudioManager.this.e.getMode());
            b.c.a.a0.d.b1("DiscordAudioManager", sbU.toString());
            synchronized (DiscordAudioManager.this.i) {
                DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager2.r;
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, false, null, null, 1));
                }
                discordAudioManager2.r = arrayList;
                discordAudioManager2.f2785s.k.onNext(arrayList);
            }
            DiscordAudioManager discordAudioManager3 = DiscordAudioManager.this;
            discordAudioManager3.a(discordAudioManager3.r);
        }

        @Override // b.a.q.k0.h
        public void c(Context context) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.h
        public void d(Context context, boolean z2) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(context, "context");
        }

        @Override // b.a.q.k0.h
        @MainThread
        public void e(Context context, b.a.q.l0.a aVar) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(aVar, "wiredHeadsetState");
            b.c.a.a0.d.b1("DiscordAudioManager", "[onWiredHeadsetPlug] wiredHeadsetState = " + aVar);
            if (m.areEqual(aVar, a.b.a)) {
                synchronized (DiscordAudioManager.this.i) {
                    DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                    List<AudioDevice> list = discordAudioManager.r;
                    ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                    for (AudioDevice audioDevice : list) {
                        int iOrdinal = audioDevice.type.ordinal();
                        arrayList.add(iOrdinal != 3 ? iOrdinal != 4 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, DiscordAudioManager.this.h, null, null, 13) : AudioDevice.a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManager.r = arrayList;
                    discordAudioManager.f2785s.k.onNext(arrayList);
                }
            } else if (aVar instanceof a.C0041a) {
                synchronized (DiscordAudioManager.this.i) {
                    DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                    List<AudioDevice> list2 = discordAudioManager2.r;
                    ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list2, 10));
                    for (AudioDevice audioDevice2 : list2) {
                        int iOrdinal2 = audioDevice2.type.ordinal();
                        arrayList2.add(iOrdinal2 != 3 ? iOrdinal2 != 4 ? AudioDevice.a(audioDevice2, null, false, null, null, 15) : AudioDevice.a(audioDevice2, null, false, null, null, 13) : AudioDevice.a(audioDevice2, null, true, null, null, 13));
                    }
                    discordAudioManager2.r = arrayList2;
                    discordAudioManager2.f2785s.k.onNext(arrayList2);
                }
            }
            DiscordAudioManager.this.l();
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public final class c implements i {
        public c() {
        }

        @Override // b.a.q.k0.i
        @MainThread
        public void a(Context context, BluetoothHeadsetAudioState.b bVar) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(bVar, "audioState");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bVar.a;
            if (bluetoothHeadsetAudioState == null) {
                bluetoothHeadsetAudioState = BluetoothHeadsetAudioState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = bVar.c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetAudioStateChanged] state: ");
            sb.append(bluetoothHeadsetAudioState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            b.c.a.a0.d.b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothHeadsetAudioState.ordinal();
            if (iOrdinal == 0) {
                DiscordAudioManager.this.l();
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            synchronized (DiscordAudioManager.this.i) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager.r;
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, true, bluetoothDevice != null ? bluetoothDevice.getAddress() : null, bluetoothDevice != null ? bluetoothDevice.getName() : null, 1));
                }
                discordAudioManager.r = arrayList;
                discordAudioManager.f2785s.k.onNext(arrayList);
            }
        }

        @Override // b.a.q.k0.i
        @MainThread
        public void b(BluetoothDevice bluetoothDevice) {
            b.a.q.k0.d dVar = b.a.q.k0.d.c;
            if (!(((String) b.a.q.k0.d.a.getValue()) != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (bluetoothDevice != null) {
                DiscordAudioManager.this.l();
            }
        }

        @Override // b.a.q.k0.i
        @MainThread
        public void c(BluetoothHeadset bluetoothHeadset) {
            DiscordAudioManager.this.n = bluetoothHeadset;
        }

        @Override // b.a.q.k0.i
        @MainThread
        public void d(Context context, BluetoothProfileConnectionState.b bVar) {
            ArrayList arrayList;
            DiscordAudioManager discordAudioManager;
            DeviceTypes deviceTypes;
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(bVar, "connectionState");
            BluetoothProfileConnectionState bluetoothProfileConnectionState = bVar.f2791b;
            if (bluetoothProfileConnectionState == null) {
                bluetoothProfileConnectionState = BluetoothProfileConnectionState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = bVar.c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetConnectionStateChanged] state: ");
            sb.append(bluetoothProfileConnectionState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            b.c.a.a0.d.b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothProfileConnectionState.ordinal();
            if (iOrdinal == 0) {
                synchronized (DiscordAudioManager.this.i) {
                    List<AudioDevice> list = DiscordAudioManager.this.r;
                    arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AudioDevice.a((AudioDevice) it.next(), null, false, null, null, 15));
                    }
                }
                DeviceTypes deviceTypes2 = DeviceTypes.BLUETOOTH_HEADSET;
                if (((AudioDevice) arrayList.get(deviceTypes2.getValue())).id != null) {
                    if (m.areEqual(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, ((AudioDevice) arrayList.get(deviceTypes2.getValue())).id)) {
                        DiscordAudioManager.this.l();
                        return;
                    }
                    return;
                }
                return;
            }
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    synchronized (DiscordAudioManager.this.i) {
                        discordAudioManager = DiscordAudioManager.this;
                        deviceTypes = discordAudioManager.t;
                    }
                    if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
                        discordAudioManager.g();
                        return;
                    } else {
                        discordAudioManager.l();
                        return;
                    }
                }
                if (iOrdinal != 3) {
                    return;
                }
            }
            b.c.a.a0.d.b1("DiscordAudioManager", "[onHeadsetConnectionStateChanged] " + bluetoothProfileConnectionState + "...");
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class d extends d0.z.d.o implements Function0<DiscordAudioManager> {
        public static final d j = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public DiscordAudioManager invoke() {
            return new DiscordAudioManager(ApplicationProvider.INSTANCE.get());
        }
    }

    /* compiled from: DiscordAudioManager.kt */
    public static final class e extends d0.z.d.o implements Function0<b.a.q.k0.b> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public b.a.q.k0.b invoke() {
            return new b.a.q.k0.b(this.$context);
        }
    }

    public DiscordAudioManager(Context context) {
        AudioDevice audioDeviceA;
        m.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.e = (AudioManager) systemService;
        Object systemService2 = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f = (BluetoothManager) systemService2;
        this.g = g.lazy(new e(context));
        this.h = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        this.i = this;
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        this.j = threadCurrentThread.getId();
        ContentResolver contentResolver = context.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        this.k = contentResolver;
        this.l = new b.a.q.k0.c(context, new c());
        this.m = new b.a.q.k0.a(context, new b());
        new Handler(Looper.getMainLooper()).post(new a());
        this.o = BluetoothScoState.INVALID;
        List<AudioDevice> listListOf = n.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
        ArrayList arrayList = new ArrayList();
        for (AudioDevice audioDevice : listListOf) {
            int iOrdinal = audioDevice.type.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                audioDeviceA = null;
            } else if (iOrdinal == 2) {
                audioDeviceA = AudioDevice.a(audioDevice, null, true, null, null, 13);
            } else if (iOrdinal == 3) {
                audioDeviceA = AudioDevice.a(audioDevice, null, this.e.isWiredHeadsetOn(), null, null, 13);
            } else if (iOrdinal == 4) {
                audioDeviceA = AudioDevice.a(audioDevice, null, this.h, null, null, 13);
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                audioDeviceA = AudioDevice.a(audioDevice, null, false, null, null, 15);
            }
            if (audioDeviceA != null) {
                arrayList.add(audioDeviceA);
            }
        }
        this.r = arrayList;
        this.f2785s = new SerializedSubject<>(BehaviorSubject.l0(arrayList));
        DeviceTypes deviceTypes = DeviceTypes.INVALID;
        this.t = deviceTypes;
        this.u = new SerializedSubject<>(BehaviorSubject.l0(deviceTypes));
        this.f2786x = this.e.getStreamMaxVolume(3);
        this.f2787y = new SerializedSubject<>(BehaviorSubject.l0(Integer.valueOf(this.w)));
        this.f2788z = DeviceTypes.DEFAULT;
    }

    public static final DiscordAudioManager d() {
        return (DiscordAudioManager) a.getValue();
    }

    public static final List<AudioDevice> f() {
        return n.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
    }

    public final void a(List<AudioDevice> list) {
        DeviceTypes deviceTypesPrevious;
        DeviceTypes deviceTypes;
        synchronized (this.i) {
            List<DeviceTypes> list2 = c;
            ListIterator<DeviceTypes> listIterator = list2.listIterator(list2.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    deviceTypesPrevious = null;
                    break;
                } else {
                    deviceTypesPrevious = listIterator.previous();
                    if (list.get(deviceTypesPrevious.getValue()).isAvailable) {
                        break;
                    }
                }
            }
            deviceTypes = deviceTypesPrevious;
            if (deviceTypes == null) {
                deviceTypes = DeviceTypes.SPEAKERPHONE;
            }
        }
        b.c.a.a0.d.b1("DiscordAudioManager", "Default device to activate: " + deviceTypes);
        b(deviceTypes);
    }

    public final void b(DeviceTypes deviceTypes) {
        boolean z2;
        synchronized (this.i) {
            z2 = !this.D;
        }
        if (z2) {
            b.c.a.a0.d.f1("DiscordAudioManager", "Unable to activate audio output outside Discord-requested communication mode");
            return;
        }
        if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
            j();
        } else {
            k();
        }
        boolean z3 = deviceTypes == DeviceTypes.SPEAKERPHONE;
        if (this.e.isSpeakerphoneOn() != z3) {
            this.e.setSpeakerphoneOn(z3);
        }
        synchronized (this.i) {
            this.t = deviceTypes;
            this.u.k.onNext(deviceTypes);
        }
        b.c.a.a0.d.b1("DiscordAudioManager", "Activated device: " + deviceTypes);
    }

    public final void c() {
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != this.j) {
            throw new IllegalStateException("Method was not called from a valid thread");
        }
    }

    public final b.a.q.k0.b e() {
        return (b.a.q.k0.b) this.g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        List<BluetoothDevice> listEmptyList;
        Object next;
        BluetoothDevice bluetoothDevice;
        boolean z2;
        if (!e().d) {
            b.c.a.a0.d.f1("DiscordAudioManager", "refreshBluetoothHeadset() requires BLUETOOTH permission");
            return;
        }
        BluetoothHeadset bluetoothHeadset = this.n;
        if (bluetoothHeadset == null || (listEmptyList = bluetoothHeadset.getConnectedDevices()) == null) {
            listEmptyList = n.emptyList();
        }
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) next;
            BluetoothHeadset bluetoothHeadset2 = this.n;
            if (bluetoothHeadset2 != null ? bluetoothHeadset2.isAudioConnected(bluetoothDevice2) : false) {
                break;
            }
        }
        BluetoothDevice bluetoothDevice3 = (BluetoothDevice) next;
        BluetoothHeadset bluetoothHeadset3 = this.n;
        if (bluetoothHeadset3 != null) {
            b.a.q.k0.d dVar = b.a.q.k0.d.c;
            m.checkNotNullParameter(bluetoothHeadset3, "headsetProfile");
            try {
                Method method = (Method) b.a.q.k0.d.f263b.getValue();
                Object objInvoke = method != null ? method.invoke(bluetoothHeadset3, new Object[0]) : null;
                if (!(objInvoke instanceof BluetoothDevice)) {
                    objInvoke = null;
                }
                bluetoothDevice = (BluetoothDevice) objInvoke;
            } catch (Throwable unused) {
            }
        } else {
            bluetoothDevice = null;
        }
        if (bluetoothDevice3 == null) {
            bluetoothDevice3 = bluetoothDevice;
        }
        if (e().d) {
            BluetoothAdapter adapter = this.f.getAdapter();
            if (adapter != null) {
                int profileConnectionState = adapter.getProfileConnectionState(1);
                if (adapter.isEnabled() && profileConnectionState == 2) {
                    z2 = true;
                }
            }
            synchronized (this.i) {
                List<AudioDevice> list = this.r;
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.a(audioDevice, null, false, null, null, 15) : AudioDevice.a(audioDevice, null, (this.D && this.t == DeviceTypes.BLUETOOTH_HEADSET) ? bluetoothDevice3 != null : z2, bluetoothDevice3 != null ? bluetoothDevice3.getAddress() : null, bluetoothDevice3 != null ? bluetoothDevice3.getName() : null, 1));
                }
                this.r = arrayList;
                this.f2785s.k.onNext(arrayList);
            }
            return;
        }
        b.c.a.a0.d.f1("DiscordAudioManager", "hasBluetoothHeadset() requires BLUETOOTH permission");
        z2 = false;
        synchronized (this.i) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(boolean z2) {
        AudioFocusRequest audioFocusRequest;
        c();
        if (!e().f262b) {
            b.c.a.a0.d.f1("DiscordAudioManager", "MODIFY_AUDIO_SETTINGS is missing. Client will run with reduced functionality");
            return;
        }
        boolean z3 = false;
        if (z2) {
            Looper looperMyLooper = Looper.myLooper();
            f fVar = new f(this, looperMyLooper != null ? new Handler(looperMyLooper) : null);
            this.k.registerContentObserver(Settings.System.CONTENT_URI, true, fVar);
            this.v = fVar;
            this.A = this.e.isSpeakerphoneOn();
            this.B = this.e.isMicrophoneMute();
            this.C = this.e.isBluetoothScoOn();
            i(true);
            synchronized (this.i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.p;
                if (onAudioFocusChangeListener != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        AudioFocusRequest.Builder builder = new AudioFocusRequest.Builder(1);
                        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                        builder2.setUsage(2);
                        builder2.setContentType(1);
                        builder.setAcceptsDelayedFocusGain(true);
                        Looper looperMyLooper2 = Looper.myLooper();
                        m.checkNotNull(looperMyLooper2);
                        builder.setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(looperMyLooper2));
                        builder.setAudioAttributes(builder2.build());
                        AudioFocusRequest audioFocusRequestBuild = builder.build();
                        this.q = audioFocusRequestBuild;
                        if (this.e.requestAudioFocus(audioFocusRequestBuild) == 1) {
                            z3 = true;
                        }
                        if (z3) {
                            b.c.a.a0.d.f1("DiscordAudioManager", "Unable to requestAudioFocus()");
                        } else {
                            b.c.a.a0.d.b1("DiscordAudioManager", "Successful requestAudioFocus()");
                        }
                    } else {
                        if (this.e.requestAudioFocus(onAudioFocusChangeListener, 0, 1) == 1) {
                        }
                        if (z3) {
                        }
                    }
                }
            }
            l();
            return;
        }
        ContentObserver contentObserver = this.v;
        if (contentObserver != null) {
            this.k.unregisterContentObserver(contentObserver);
        }
        this.v = null;
        b(DeviceTypes.INVALID);
        synchronized (this.i) {
            this.f2788z = DeviceTypes.DEFAULT;
        }
        i(false);
        if (Build.VERSION.SDK_INT >= 26) {
            synchronized (this.i) {
                audioFocusRequest = this.q;
            }
            if (audioFocusRequest != null && this.e.abandonAudioFocusRequest(audioFocusRequest) == 1) {
                z3 = true;
            }
            if (z3) {
                b.c.a.a0.d.f1("DiscordAudioManager", "Unable to releaseAudioFocus()");
            } else {
                b.c.a.a0.d.b1("DiscordAudioManager", "Successful releaseAudioFocus()");
            }
        } else {
            synchronized (this.i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2 = this.p;
                if (onAudioFocusChangeListener2 != null) {
                    if (this.e.abandonAudioFocus(onAudioFocusChangeListener2) == 1) {
                    }
                    if (z3) {
                    }
                }
            }
        }
        boolean z4 = this.B;
        if (this.e.isMicrophoneMute() != z4) {
            this.e.setMicrophoneMute(z4);
        }
        boolean z5 = this.A;
        if (this.e.isSpeakerphoneOn() != z5) {
            this.e.setSpeakerphoneOn(z5);
        }
        if (this.C) {
            j();
        }
    }

    public final void i(boolean z2) {
        try {
            this.e.setMode(z2 ? 3 : 0);
        } catch (SecurityException unused) {
        }
        synchronized (this.i) {
            this.D = z2;
        }
    }

    public final synchronized void j() {
        BluetoothScoState bluetoothScoState;
        BluetoothScoState bluetoothScoState2 = this.o;
        BluetoothScoState bluetoothScoState3 = BluetoothScoState.ON;
        if (bluetoothScoState2 != bluetoothScoState3 && bluetoothScoState2 != (bluetoothScoState = BluetoothScoState.TURNING_ON)) {
            if (this.e.isBluetoothScoOn()) {
                this.o = bluetoothScoState3;
            } else {
                this.o = bluetoothScoState;
                this.e.startBluetoothSco();
            }
        }
    }

    public final synchronized void k() {
        BluetoothScoState bluetoothScoState = this.o;
        if (bluetoothScoState == BluetoothScoState.ON || bluetoothScoState == BluetoothScoState.TURNING_ON) {
            if (!this.e.isBluetoothScoOn()) {
                this.o = BluetoothScoState.OFF;
            } else {
                this.o = BluetoothScoState.TURNING_OFF;
                this.e.stopBluetoothSco();
            }
        }
    }

    public final void l() {
        DeviceTypes deviceTypes;
        ArrayList arrayList;
        synchronized (this.i) {
            deviceTypes = this.f2788z;
        }
        g();
        synchronized (this.i) {
            List<AudioDevice> list = this.r;
            arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AudioDevice.a((AudioDevice) it.next(), null, false, null, null, 15));
            }
        }
        if (deviceTypes == DeviceTypes.DEFAULT || !arrayList.get(deviceTypes.getValue()).isAvailable) {
            a(arrayList);
        } else {
            b(deviceTypes);
        }
    }
}
