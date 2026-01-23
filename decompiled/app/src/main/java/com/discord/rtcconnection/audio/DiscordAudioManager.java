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
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import com.discord.rtcconnection.enums.ScoAudioState;
import com.discord.utilities.lifecycle.ApplicationProvider;
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
import p007b.p008a.p041q.p042k0.AudioManagerBroadcastReceiver;
import p007b.p008a.p041q.p042k0.AudioPermissions;
import p007b.p008a.p041q.p042k0.BluetoothBroadcastReceiver;
import p007b.p008a.p041q.p042k0.BluetoothHeadsetPrivateApi;
import p007b.p008a.p041q.p042k0.DiscordAudioManager2;
import p007b.p008a.p041q.p042k0.DiscordAudioManager3;
import p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener;
import p007b.p008a.p041q.p042k0.OnBluetoothBroadcastListener;
import p007b.p008a.p041q.p043l0.WiredHeadsetState;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager {

    /* JADX INFO: renamed from: a */
    public static final Lazy f18826a = LazyJVM.lazy(C5623d.f18864j);

    /* JADX INFO: renamed from: b */
    public static final AudioDevice f18827b = new AudioDevice(null, false, null, null, 15);

    /* JADX INFO: renamed from: c */
    public static final List<DeviceTypes> f18828c = Collections2.listOf((Object[]) new DeviceTypes[]{DeviceTypes.EARPIECE, DeviceTypes.SPEAKERPHONE, DeviceTypes.BLUETOOTH_HEADSET, DeviceTypes.WIRED_HEADSET});

    /* JADX INFO: renamed from: d */
    public static final DiscordAudioManager f18829d = null;

    /* JADX INFO: renamed from: A */
    public boolean f18830A;

    /* JADX INFO: renamed from: B */
    public boolean f18831B;

    /* JADX INFO: renamed from: C */
    public boolean f18832C;

    /* JADX INFO: renamed from: D */
    public boolean f18833D;

    /* JADX INFO: renamed from: e */
    public final AudioManager f18834e;

    /* JADX INFO: renamed from: f */
    public final BluetoothManager f18835f;

    /* JADX INFO: renamed from: g */
    public final Lazy f18836g;

    /* JADX INFO: renamed from: h */
    public final boolean f18837h;

    /* JADX INFO: renamed from: i */
    public final Object f18838i;

    /* JADX INFO: renamed from: j */
    public final long f18839j;

    /* JADX INFO: renamed from: k */
    public final ContentResolver f18840k;

    /* JADX INFO: renamed from: l */
    public final BluetoothBroadcastReceiver f18841l;

    /* JADX INFO: renamed from: m */
    public final AudioManagerBroadcastReceiver f18842m;

    /* JADX INFO: renamed from: n */
    public BluetoothHeadset f18843n;

    /* JADX INFO: renamed from: o */
    public BluetoothScoState f18844o;

    /* JADX INFO: renamed from: p */
    public AudioManager.OnAudioFocusChangeListener f18845p;

    /* JADX INFO: renamed from: q */
    public AudioFocusRequest f18846q;

    /* JADX INFO: renamed from: r */
    public List<AudioDevice> f18847r;

    /* JADX INFO: renamed from: s */
    public final SerializedSubject<List<AudioDevice>, List<AudioDevice>> f18848s;

    /* JADX INFO: renamed from: t */
    public DeviceTypes f18849t;

    /* JADX INFO: renamed from: u */
    public final SerializedSubject<DeviceTypes, DeviceTypes> f18850u;

    /* JADX INFO: renamed from: v */
    public ContentObserver f18851v;

    /* JADX INFO: renamed from: w */
    public int f18852w;

    /* JADX INFO: renamed from: x */
    public final int f18853x;

    /* JADX INFO: renamed from: y */
    public final SerializedSubject<Integer, Integer> f18854y;

    /* JADX INFO: renamed from: z */
    public DeviceTypes f18855z;

    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public static final /* data */ class AudioDevice {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final DeviceTypes type;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final boolean isAvailable;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final String id;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final String name;

        public AudioDevice() {
            this(null, false, null, null, 15);
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2) {
            Intrinsics3.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = str;
            this.name = str2;
        }

        /* JADX INFO: renamed from: a */
        public static AudioDevice m8493a(AudioDevice audioDevice, DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
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
            Intrinsics3.checkNotNullParameter(deviceTypes2, "type");
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
            return Intrinsics3.areEqual(this.type, audioDevice.type) && this.isAvailable == audioDevice.isAvailable && Intrinsics3.areEqual(this.id, audioDevice.id) && Intrinsics3.areEqual(this.name, audioDevice.name);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            DeviceTypes deviceTypes = this.type;
            int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
            boolean z2 = this.isAvailable;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            String str = this.id;
            int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("AudioDevice(type=");
            sbM833U.append(this.type);
            sbM833U.append(", isAvailable=");
            sbM833U.append(this.isAvailable);
            sbM833U.append(", id=");
            sbM833U.append(this.id);
            sbM833U.append(", name=");
            return outline.m822J(sbM833U, this.name, ")");
        }

        public AudioDevice(DeviceTypes deviceTypes, boolean z2, String str, String str2, int i) {
            deviceTypes = (i & 1) != 0 ? DeviceTypes.INVALID : deviceTypes;
            z2 = (i & 2) != 0 ? false : z2;
            int i2 = i & 4;
            int i3 = i & 8;
            Intrinsics3.checkNotNullParameter(deviceTypes, "type");
            this.type = deviceTypes;
            this.isAvailable = z2;
            this.id = null;
            this.name = null;
        }
    }

    /* JADX INFO: compiled from: DiscordAudioManager.kt */
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

    /* JADX INFO: compiled from: DiscordAudioManager.kt */
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

    /* JADX INFO: renamed from: com.discord.rtcconnection.audio.DiscordAudioManager$a */
    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public static final class RunnableC5620a implements Runnable {
        public RunnableC5620a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            AudioManagerBroadcastReceiver audioManagerBroadcastReceiver = discordAudioManager.f18842m;
            Objects.requireNonNull(audioManagerBroadcastReceiver);
            ThreadUtils.checkIsOnMainThread();
            boolean profileProxy = false;
            List listListOf = Collections2.listOf((Object[]) new AudioManagerBroadcastAction[]{AudioManagerBroadcastAction.HeadsetPlug, AudioManagerBroadcastAction.ScoAudioStateUpdated});
            AnimatableValueParser.m501b1("AudioManagerBroadcastReceiver", "registering for broadcasts with actions: " + listListOf);
            IntentFilter intentFilter = new IntentFilter();
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(((AudioManagerBroadcastAction) it.next()).getAction());
            }
            audioManagerBroadcastReceiver.f1641b.registerReceiver(audioManagerBroadcastReceiver, intentFilter);
            BluetoothBroadcastReceiver bluetoothBroadcastReceiver = discordAudioManager.f18841l;
            Objects.requireNonNull(bluetoothBroadcastReceiver);
            ThreadUtils.checkIsOnMainThread();
            if (!bluetoothBroadcastReceiver.f1649l) {
                StringBuilder sbM833U = outline.m833U("registering for broadcasts with actions: ");
                Set<BluetoothBroadcastAction> set = BluetoothBroadcastReceiver.f1647j;
                sbM833U.append(set);
                AnimatableValueParser.m501b1("BluetoothBroadcastReceiver", sbM833U.toString());
                IntentFilter intentFilter2 = new IntentFilter();
                Iterator<T> it2 = set.iterator();
                while (it2.hasNext()) {
                    intentFilter2.addAction(((BluetoothBroadcastAction) it2.next()).getAction());
                }
                bluetoothBroadcastReceiver.f1651n.registerReceiver(bluetoothBroadcastReceiver, intentFilter2);
                BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.f1655c;
                Lazy lazy = BluetoothHeadsetPrivateApi.f1653a;
                if (((String) lazy.getValue()) != null) {
                    Context context = bluetoothBroadcastReceiver.f1651n;
                    Intrinsics3.checkNotNullParameter(context, "context");
                    Intrinsics3.checkNotNullParameter(bluetoothBroadcastReceiver, "receiver");
                    try {
                        String str = (String) lazy.getValue();
                        if (str != null) {
                            context.registerReceiver(bluetoothBroadcastReceiver, new IntentFilter(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
                try {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        profileProxy = defaultAdapter.getProfileProxy(bluetoothBroadcastReceiver.f1651n, bluetoothBroadcastReceiver, 1);
                    }
                } catch (SecurityException e) {
                    AnimatableValueParser.m517f1("BluetoothBroadcastReceiver", "failed to get BluetoothHeadset profile: " + e);
                }
                if (profileProxy) {
                    AnimatableValueParser.m501b1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy");
                } else {
                    AnimatableValueParser.m505c1("BluetoothBroadcastReceiver", "listening for HeadsetProfile proxy failed", null);
                }
                bluetoothBroadcastReceiver.f1649l = true;
            }
            DiscordAudioManager2 discordAudioManager2 = new DiscordAudioManager2(discordAudioManager);
            synchronized (discordAudioManager.f18838i) {
                discordAudioManager.f18845p = discordAudioManager2;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.audio.DiscordAudioManager$b */
    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public final class C5621b implements OnAudioManagerBroadcastListener {
        public C5621b() {
        }

        @Override // p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener
        /* JADX INFO: renamed from: a */
        public void mo281a(Context context, boolean z2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: b */
        public void mo282b(Context context, ScoAudioState.C5637b c5637b) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(c5637b, "scoAudioStateUpdate");
            int iOrdinal = c5637b.f18874a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                AnimatableValueParser.m501b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + c5637b);
                DiscordAudioManager.this.m8490j();
                return;
            }
            AnimatableValueParser.m501b1("DiscordAudioManager", "[onScoAudioStateUpdate] scoAudioStateUpdate = " + c5637b);
            DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
            BluetoothScoState bluetoothScoState = discordAudioManager.f18844o;
            discordAudioManager.m8491k();
            int iOrdinal2 = bluetoothScoState.ordinal();
            if (iOrdinal2 == 2) {
                synchronized (DiscordAudioManager.this.f18838i) {
                    z2 = DiscordAudioManager.this.f18833D;
                }
                if (z2) {
                    AnimatableValueParser.m501b1("DiscordAudioManager", "SCO off detected directly from ON. Refreshing Bluetooth device");
                    DiscordAudioManager.this.m8490j();
                    DiscordAudioManager.this.m8492l();
                    return;
                }
                return;
            }
            if (iOrdinal2 != 3) {
                return;
            }
            StringBuilder sbM833U = outline.m833U("Unable to turn on SCO. Clearing Bluetooth device. mode: ");
            sbM833U.append(DiscordAudioManager.this.f18834e.getMode());
            AnimatableValueParser.m501b1("DiscordAudioManager", sbM833U.toString());
            synchronized (DiscordAudioManager.this.f18838i) {
                DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager2.f18847r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.m8493a(audioDevice, null, false, null, null, 15) : AudioDevice.m8493a(audioDevice, null, false, null, null, 1));
                }
                discordAudioManager2.f18847r = arrayList;
                discordAudioManager2.f18848s.f27653k.onNext(arrayList);
            }
            DiscordAudioManager discordAudioManager3 = DiscordAudioManager.this;
            discordAudioManager3.m8483a(discordAudioManager3.f18847r);
        }

        @Override // p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener
        /* JADX INFO: renamed from: c */
        public void mo283c(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener
        /* JADX INFO: renamed from: d */
        public void mo284d(Context context, boolean z2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(context, "context");
        }

        @Override // p007b.p008a.p041q.p042k0.OnAudioManagerBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: e */
        public void mo285e(Context context, WiredHeadsetState wiredHeadsetState) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(wiredHeadsetState, "wiredHeadsetState");
            AnimatableValueParser.m501b1("DiscordAudioManager", "[onWiredHeadsetPlug] wiredHeadsetState = " + wiredHeadsetState);
            if (Intrinsics3.areEqual(wiredHeadsetState, WiredHeadsetState.b.f1669a)) {
                synchronized (DiscordAudioManager.this.f18838i) {
                    DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                    List<AudioDevice> list = discordAudioManager.f18847r;
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    for (AudioDevice audioDevice : list) {
                        int iOrdinal = audioDevice.type.ordinal();
                        arrayList.add(iOrdinal != 3 ? iOrdinal != 4 ? AudioDevice.m8493a(audioDevice, null, false, null, null, 15) : AudioDevice.m8493a(audioDevice, null, DiscordAudioManager.this.f18837h, null, null, 13) : AudioDevice.m8493a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManager.f18847r = arrayList;
                    discordAudioManager.f18848s.f27653k.onNext(arrayList);
                }
            } else if (wiredHeadsetState instanceof WiredHeadsetState.a) {
                synchronized (DiscordAudioManager.this.f18838i) {
                    DiscordAudioManager discordAudioManager2 = DiscordAudioManager.this;
                    List<AudioDevice> list2 = discordAudioManager2.f18847r;
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                    for (AudioDevice audioDevice2 : list2) {
                        int iOrdinal2 = audioDevice2.type.ordinal();
                        arrayList2.add(iOrdinal2 != 3 ? iOrdinal2 != 4 ? AudioDevice.m8493a(audioDevice2, null, false, null, null, 15) : AudioDevice.m8493a(audioDevice2, null, false, null, null, 13) : AudioDevice.m8493a(audioDevice2, null, true, null, null, 13));
                    }
                    discordAudioManager2.f18847r = arrayList2;
                    discordAudioManager2.f18848s.f27653k.onNext(arrayList2);
                }
            }
            DiscordAudioManager.this.m8492l();
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.audio.DiscordAudioManager$c */
    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public final class C5622c implements OnBluetoothBroadcastListener {
        public C5622c() {
        }

        @Override // p007b.p008a.p041q.p042k0.OnBluetoothBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: a */
        public void mo286a(Context context, BluetoothHeadsetAudioState.C5633b c5633b) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(c5633b, "audioState");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = c5633b.f18868a;
            if (bluetoothHeadsetAudioState == null) {
                bluetoothHeadsetAudioState = BluetoothHeadsetAudioState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = c5633b.f18870c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetAudioStateChanged] state: ");
            sb.append(bluetoothHeadsetAudioState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            AnimatableValueParser.m501b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothHeadsetAudioState.ordinal();
            if (iOrdinal == 0) {
                DiscordAudioManager.this.m8492l();
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            synchronized (DiscordAudioManager.this.f18838i) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.this;
                List<AudioDevice> list = discordAudioManager.f18847r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.m8493a(audioDevice, null, false, null, null, 15) : AudioDevice.m8493a(audioDevice, null, true, bluetoothDevice != null ? bluetoothDevice.getAddress() : null, bluetoothDevice != null ? bluetoothDevice.getName() : null, 1));
                }
                discordAudioManager.f18847r = arrayList;
                discordAudioManager.f18848s.f27653k.onNext(arrayList);
            }
        }

        @Override // p007b.p008a.p041q.p042k0.OnBluetoothBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: b */
        public void mo287b(BluetoothDevice bluetoothDevice) {
            BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.f1655c;
            if (!(((String) BluetoothHeadsetPrivateApi.f1653a.getValue()) != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (bluetoothDevice != null) {
                DiscordAudioManager.this.m8492l();
            }
        }

        @Override // p007b.p008a.p041q.p042k0.OnBluetoothBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: c */
        public void mo288c(BluetoothHeadset bluetoothHeadset) {
            DiscordAudioManager.this.f18843n = bluetoothHeadset;
        }

        @Override // p007b.p008a.p041q.p042k0.OnBluetoothBroadcastListener
        @MainThread
        /* JADX INFO: renamed from: d */
        public void mo289d(Context context, BluetoothProfileConnectionState.C5635b c5635b) {
            ArrayList arrayList;
            DiscordAudioManager discordAudioManager;
            DeviceTypes deviceTypes;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(c5635b, "connectionState");
            BluetoothProfileConnectionState bluetoothProfileConnectionState = c5635b.f18872b;
            if (bluetoothProfileConnectionState == null) {
                bluetoothProfileConnectionState = BluetoothProfileConnectionState.Disconnected;
            }
            BluetoothDevice bluetoothDevice = c5635b.f18873c;
            StringBuilder sb = new StringBuilder();
            sb.append("[onHeadsetConnectionStateChanged] state: ");
            sb.append(bluetoothProfileConnectionState);
            sb.append(", device: ");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : null);
            AnimatableValueParser.m501b1("DiscordAudioManager", sb.toString());
            int iOrdinal = bluetoothProfileConnectionState.ordinal();
            if (iOrdinal == 0) {
                synchronized (DiscordAudioManager.this.f18838i) {
                    List<AudioDevice> list = DiscordAudioManager.this.f18847r;
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AudioDevice.m8493a((AudioDevice) it.next(), null, false, null, null, 15));
                    }
                }
                DeviceTypes deviceTypes2 = DeviceTypes.BLUETOOTH_HEADSET;
                if (((AudioDevice) arrayList.get(deviceTypes2.getValue())).id != null) {
                    if (Intrinsics3.areEqual(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, ((AudioDevice) arrayList.get(deviceTypes2.getValue())).id)) {
                        DiscordAudioManager.this.m8492l();
                        return;
                    }
                    return;
                }
                return;
            }
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    synchronized (DiscordAudioManager.this.f18838i) {
                        discordAudioManager = DiscordAudioManager.this;
                        deviceTypes = discordAudioManager.f18849t;
                    }
                    if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
                        discordAudioManager.m8487g();
                        return;
                    } else {
                        discordAudioManager.m8492l();
                        return;
                    }
                }
                if (iOrdinal != 3) {
                    return;
                }
            }
            AnimatableValueParser.m501b1("DiscordAudioManager", "[onHeadsetConnectionStateChanged] " + bluetoothProfileConnectionState + "...");
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.audio.DiscordAudioManager$d */
    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public static final class C5623d extends Lambda implements Function0<DiscordAudioManager> {

        /* JADX INFO: renamed from: j */
        public static final C5623d f18864j = new C5623d();

        public C5623d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public DiscordAudioManager invoke() {
            return new DiscordAudioManager(ApplicationProvider.INSTANCE.get());
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.audio.DiscordAudioManager$e */
    /* JADX INFO: compiled from: DiscordAudioManager.kt */
    public static final class C5624e extends Lambda implements Function0<AudioPermissions> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5624e(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public AudioPermissions invoke() {
            return new AudioPermissions(this.$context);
        }
    }

    public DiscordAudioManager(Context context) {
        AudioDevice audioDeviceM8493a;
        Intrinsics3.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f18834e = (AudioManager) systemService;
        Object systemService2 = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f18835f = (BluetoothManager) systemService2;
        this.f18836g = LazyJVM.lazy(new C5624e(context));
        this.f18837h = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        this.f18838i = this;
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        this.f18839j = threadCurrentThread.getId();
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        this.f18840k = contentResolver;
        this.f18841l = new BluetoothBroadcastReceiver(context, new C5622c());
        this.f18842m = new AudioManagerBroadcastReceiver(context, new C5621b());
        new Handler(Looper.getMainLooper()).post(new RunnableC5620a());
        this.f18844o = BluetoothScoState.INVALID;
        List<AudioDevice> listListOf = Collections2.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
        ArrayList arrayList = new ArrayList();
        for (AudioDevice audioDevice : listListOf) {
            int iOrdinal = audioDevice.type.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                audioDeviceM8493a = null;
            } else if (iOrdinal == 2) {
                audioDeviceM8493a = AudioDevice.m8493a(audioDevice, null, true, null, null, 13);
            } else if (iOrdinal == 3) {
                audioDeviceM8493a = AudioDevice.m8493a(audioDevice, null, this.f18834e.isWiredHeadsetOn(), null, null, 13);
            } else if (iOrdinal == 4) {
                audioDeviceM8493a = AudioDevice.m8493a(audioDevice, null, this.f18837h, null, null, 13);
            } else {
                if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                audioDeviceM8493a = AudioDevice.m8493a(audioDevice, null, false, null, null, 15);
            }
            if (audioDeviceM8493a != null) {
                arrayList.add(audioDeviceM8493a);
            }
        }
        this.f18847r = arrayList;
        this.f18848s = new SerializedSubject<>(BehaviorSubject.m11130l0(arrayList));
        DeviceTypes deviceTypes = DeviceTypes.INVALID;
        this.f18849t = deviceTypes;
        this.f18850u = new SerializedSubject<>(BehaviorSubject.m11130l0(deviceTypes));
        this.f18853x = this.f18834e.getStreamMaxVolume(3);
        this.f18854y = new SerializedSubject<>(BehaviorSubject.m11130l0(Integer.valueOf(this.f18852w)));
        this.f18855z = DeviceTypes.DEFAULT;
    }

    /* JADX INFO: renamed from: d */
    public static final DiscordAudioManager m8481d() {
        return (DiscordAudioManager) f18826a.getValue();
    }

    /* JADX INFO: renamed from: f */
    public static final List<AudioDevice> m8482f() {
        return Collections2.listOf((Object[]) new AudioDevice[]{new AudioDevice(DeviceTypes.SPEAKERPHONE, false, null, null, 14), new AudioDevice(DeviceTypes.WIRED_HEADSET, false, null, null, 14), new AudioDevice(DeviceTypes.EARPIECE, false, null, null, 14), new AudioDevice(DeviceTypes.BLUETOOTH_HEADSET, false, null, null, 14)});
    }

    /* JADX INFO: renamed from: a */
    public final void m8483a(List<AudioDevice> list) {
        DeviceTypes deviceTypesPrevious;
        DeviceTypes deviceTypes;
        synchronized (this.f18838i) {
            List<DeviceTypes> list2 = f18828c;
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
        AnimatableValueParser.m501b1("DiscordAudioManager", "Default device to activate: " + deviceTypes);
        m8484b(deviceTypes);
    }

    /* JADX INFO: renamed from: b */
    public final void m8484b(DeviceTypes deviceTypes) {
        boolean z2;
        synchronized (this.f18838i) {
            z2 = !this.f18833D;
        }
        if (z2) {
            AnimatableValueParser.m517f1("DiscordAudioManager", "Unable to activate audio output outside Discord-requested communication mode");
            return;
        }
        if (deviceTypes == DeviceTypes.BLUETOOTH_HEADSET) {
            m8490j();
        } else {
            m8491k();
        }
        boolean z3 = deviceTypes == DeviceTypes.SPEAKERPHONE;
        if (this.f18834e.isSpeakerphoneOn() != z3) {
            this.f18834e.setSpeakerphoneOn(z3);
        }
        synchronized (this.f18838i) {
            this.f18849t = deviceTypes;
            this.f18850u.f27653k.onNext(deviceTypes);
        }
        AnimatableValueParser.m501b1("DiscordAudioManager", "Activated device: " + deviceTypes);
    }

    /* JADX INFO: renamed from: c */
    public final void m8485c() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != this.f18839j) {
            throw new IllegalStateException("Method was not called from a valid thread");
        }
    }

    /* JADX INFO: renamed from: e */
    public final AudioPermissions m8486e() {
        return (AudioPermissions) this.f18836g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8487g() {
        List<BluetoothDevice> listEmptyList;
        Object next;
        BluetoothDevice bluetoothDevice;
        boolean z2;
        if (!m8486e().f1646d) {
            AnimatableValueParser.m517f1("DiscordAudioManager", "refreshBluetoothHeadset() requires BLUETOOTH permission");
            return;
        }
        BluetoothHeadset bluetoothHeadset = this.f18843n;
        if (bluetoothHeadset == null || (listEmptyList = bluetoothHeadset.getConnectedDevices()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) next;
            BluetoothHeadset bluetoothHeadset2 = this.f18843n;
            if (bluetoothHeadset2 != null ? bluetoothHeadset2.isAudioConnected(bluetoothDevice2) : false) {
                break;
            }
        }
        BluetoothDevice bluetoothDevice3 = (BluetoothDevice) next;
        BluetoothHeadset bluetoothHeadset3 = this.f18843n;
        if (bluetoothHeadset3 != null) {
            BluetoothHeadsetPrivateApi bluetoothHeadsetPrivateApi = BluetoothHeadsetPrivateApi.f1655c;
            Intrinsics3.checkNotNullParameter(bluetoothHeadset3, "headsetProfile");
            try {
                Method method = (Method) BluetoothHeadsetPrivateApi.f1654b.getValue();
                Object objInvoke = method != null ? method.invoke(bluetoothHeadset3, new Object[0]) : null;
                if (!(objInvoke instanceof BluetoothDevice)) {
                    objInvoke = null;
                }
                bluetoothDevice = (BluetoothDevice) objInvoke;
            } catch (Throwable unused) {
                bluetoothDevice = null;
            }
        } else {
            bluetoothDevice = null;
        }
        if (bluetoothDevice3 == null) {
            bluetoothDevice3 = bluetoothDevice;
        }
        if (m8486e().f1646d) {
            BluetoothAdapter adapter = this.f18835f.getAdapter();
            if (adapter != null) {
                int profileConnectionState = adapter.getProfileConnectionState(1);
                if (adapter.isEnabled() && profileConnectionState == 2) {
                    z2 = true;
                }
            }
            synchronized (this.f18838i) {
                List<AudioDevice> list = this.f18847r;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                for (AudioDevice audioDevice : list) {
                    arrayList.add(audioDevice.type.ordinal() != 5 ? AudioDevice.m8493a(audioDevice, null, false, null, null, 15) : AudioDevice.m8493a(audioDevice, null, (this.f18833D && this.f18849t == DeviceTypes.BLUETOOTH_HEADSET) ? bluetoothDevice3 != null : z2, bluetoothDevice3 != null ? bluetoothDevice3.getAddress() : null, bluetoothDevice3 != null ? bluetoothDevice3.getName() : null, 1));
                }
                this.f18847r = arrayList;
                this.f18848s.f27653k.onNext(arrayList);
            }
            return;
        }
        AnimatableValueParser.m517f1("DiscordAudioManager", "hasBluetoothHeadset() requires BLUETOOTH permission");
        z2 = false;
        synchronized (this.f18838i) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8488h(boolean z2) {
        AudioFocusRequest audioFocusRequest;
        m8485c();
        if (!m8486e().f1644b) {
            AnimatableValueParser.m517f1("DiscordAudioManager", "MODIFY_AUDIO_SETTINGS is missing. Client will run with reduced functionality");
            return;
        }
        boolean z3 = false;
        if (z2) {
            Looper looperMyLooper = Looper.myLooper();
            DiscordAudioManager3 discordAudioManager3 = new DiscordAudioManager3(this, looperMyLooper != null ? new Handler(looperMyLooper) : null);
            this.f18840k.registerContentObserver(Settings.System.CONTENT_URI, true, discordAudioManager3);
            this.f18851v = discordAudioManager3;
            this.f18830A = this.f18834e.isSpeakerphoneOn();
            this.f18831B = this.f18834e.isMicrophoneMute();
            this.f18832C = this.f18834e.isBluetoothScoOn();
            m8489i(true);
            synchronized (this.f18838i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f18845p;
                if (onAudioFocusChangeListener != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        AudioFocusRequest.Builder builder = new AudioFocusRequest.Builder(1);
                        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                        builder2.setUsage(2);
                        builder2.setContentType(1);
                        builder.setAcceptsDelayedFocusGain(true);
                        Looper looperMyLooper2 = Looper.myLooper();
                        Intrinsics3.checkNotNull(looperMyLooper2);
                        builder.setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(looperMyLooper2));
                        builder.setAudioAttributes(builder2.build());
                        AudioFocusRequest audioFocusRequestBuild = builder.build();
                        this.f18846q = audioFocusRequestBuild;
                        if (this.f18834e.requestAudioFocus(audioFocusRequestBuild) == 1) {
                            z3 = true;
                        }
                        if (z3) {
                            AnimatableValueParser.m517f1("DiscordAudioManager", "Unable to requestAudioFocus()");
                        } else {
                            AnimatableValueParser.m501b1("DiscordAudioManager", "Successful requestAudioFocus()");
                        }
                    } else {
                        if (this.f18834e.requestAudioFocus(onAudioFocusChangeListener, 0, 1) == 1) {
                        }
                        if (z3) {
                        }
                    }
                }
            }
            m8492l();
            return;
        }
        ContentObserver contentObserver = this.f18851v;
        if (contentObserver != null) {
            this.f18840k.unregisterContentObserver(contentObserver);
        }
        this.f18851v = null;
        m8484b(DeviceTypes.INVALID);
        synchronized (this.f18838i) {
            this.f18855z = DeviceTypes.DEFAULT;
        }
        m8489i(false);
        if (Build.VERSION.SDK_INT >= 26) {
            synchronized (this.f18838i) {
                audioFocusRequest = this.f18846q;
            }
            if (audioFocusRequest != null && this.f18834e.abandonAudioFocusRequest(audioFocusRequest) == 1) {
                z3 = true;
            }
            if (z3) {
                AnimatableValueParser.m517f1("DiscordAudioManager", "Unable to releaseAudioFocus()");
            } else {
                AnimatableValueParser.m501b1("DiscordAudioManager", "Successful releaseAudioFocus()");
            }
        } else {
            synchronized (this.f18838i) {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2 = this.f18845p;
                if (onAudioFocusChangeListener2 != null) {
                    if (this.f18834e.abandonAudioFocus(onAudioFocusChangeListener2) == 1) {
                    }
                    if (z3) {
                    }
                }
            }
        }
        boolean z4 = this.f18831B;
        if (this.f18834e.isMicrophoneMute() != z4) {
            this.f18834e.setMicrophoneMute(z4);
        }
        boolean z5 = this.f18830A;
        if (this.f18834e.isSpeakerphoneOn() != z5) {
            this.f18834e.setSpeakerphoneOn(z5);
        }
        if (this.f18832C) {
            m8490j();
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m8489i(boolean z2) {
        try {
            this.f18834e.setMode(z2 ? 3 : 0);
        } catch (SecurityException unused) {
        }
        synchronized (this.f18838i) {
            this.f18833D = z2;
        }
    }

    /* JADX INFO: renamed from: j */
    public final synchronized void m8490j() {
        BluetoothScoState bluetoothScoState;
        BluetoothScoState bluetoothScoState2 = this.f18844o;
        BluetoothScoState bluetoothScoState3 = BluetoothScoState.ON;
        if (bluetoothScoState2 != bluetoothScoState3 && bluetoothScoState2 != (bluetoothScoState = BluetoothScoState.TURNING_ON)) {
            if (this.f18834e.isBluetoothScoOn()) {
                this.f18844o = bluetoothScoState3;
            } else {
                this.f18844o = bluetoothScoState;
                this.f18834e.startBluetoothSco();
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public final synchronized void m8491k() {
        BluetoothScoState bluetoothScoState = this.f18844o;
        if (bluetoothScoState == BluetoothScoState.ON || bluetoothScoState == BluetoothScoState.TURNING_ON) {
            if (!this.f18834e.isBluetoothScoOn()) {
                this.f18844o = BluetoothScoState.OFF;
            } else {
                this.f18844o = BluetoothScoState.TURNING_OFF;
                this.f18834e.stopBluetoothSco();
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m8492l() {
        DeviceTypes deviceTypes;
        ArrayList arrayList;
        synchronized (this.f18838i) {
            deviceTypes = this.f18855z;
        }
        m8487g();
        synchronized (this.f18838i) {
            List<AudioDevice> list = this.f18847r;
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AudioDevice.m8493a((AudioDevice) it.next(), null, false, null, null, 15));
            }
        }
        if (deviceTypes == DeviceTypes.DEFAULT || !arrayList.get(deviceTypes.getValue()).isAvailable) {
            m8483a(arrayList);
        } else {
            m8484b(deviceTypes);
        }
    }
}
