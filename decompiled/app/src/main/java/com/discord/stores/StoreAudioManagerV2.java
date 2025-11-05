package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreAudioManagerV2.kt */
/* loaded from: classes2.dex */
public final class StoreAudioManagerV2 extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final State DEFAULT_STATE;
    private Handler audioManagerHandler;
    private final HandlerThread audioManagerThread;
    private final StoreChannels channelsStore;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private DiscordAudioManager.AudioDevice lastActiveAudioDevice;
    private final ObservationDeck observationDeck;
    private boolean prevMyVideoOn;
    private State state;
    private State stateSnapshot;
    private final StoreStreamRtcConnection streamRtcConnectionStore;
    private final VideoUseDetector videoUseDetector;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: StoreAudioManagerV2.kt */
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEFAULT_STATE$app_productionGoogleRelease$annotations() {
        }

        public final State getDEFAULT_STATE$app_productionGoogleRelease() {
            return StoreAudioManagerV2.access$getDEFAULT_STATE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    public static final /* data */ class State {
        private DiscordAudioManager.DeviceTypes activeAudioDevice;
        private List<DiscordAudioManager.AudioDevice> audioDevices;

        public State() {
            this(null, null, 3, null);
        }

        public State(List<DiscordAudioManager.AudioDevice> list, DiscordAudioManager.DeviceTypes deviceTypes) {
            m.checkNotNullParameter(list, "audioDevices");
            m.checkNotNullParameter(deviceTypes, "activeAudioDevice");
            this.audioDevices = list;
            this.activeAudioDevice = deviceTypes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, DiscordAudioManager.DeviceTypes deviceTypes, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.audioDevices;
            }
            if ((i & 2) != 0) {
                deviceTypes = state.activeAudioDevice;
            }
            return state.copy(list, deviceTypes);
        }

        public final List<DiscordAudioManager.AudioDevice> component1() {
            return this.audioDevices;
        }

        /* renamed from: component2, reason: from getter */
        public final DiscordAudioManager.DeviceTypes getActiveAudioDevice() {
            return this.activeAudioDevice;
        }

        public final State copy(List<DiscordAudioManager.AudioDevice> audioDevices, DiscordAudioManager.DeviceTypes activeAudioDevice) {
            m.checkNotNullParameter(audioDevices, "audioDevices");
            m.checkNotNullParameter(activeAudioDevice, "activeAudioDevice");
            return new State(audioDevices, activeAudioDevice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return m.areEqual(this.audioDevices, state.audioDevices) && m.areEqual(this.activeAudioDevice, state.activeAudioDevice);
        }

        public final DiscordAudioManager.DeviceTypes getActiveAudioDevice() {
            return this.activeAudioDevice;
        }

        public final List<DiscordAudioManager.AudioDevice> getAudioDevices() {
            return this.audioDevices;
        }

        public int hashCode() {
            List<DiscordAudioManager.AudioDevice> list = this.audioDevices;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            DiscordAudioManager.DeviceTypes deviceTypes = this.activeAudioDevice;
            return iHashCode + (deviceTypes != null ? deviceTypes.hashCode() : 0);
        }

        public final void setActiveAudioDevice(DiscordAudioManager.DeviceTypes deviceTypes) {
            m.checkNotNullParameter(deviceTypes, "<set-?>");
            this.activeAudioDevice = deviceTypes;
        }

        public final void setAudioDevices(List<DiscordAudioManager.AudioDevice> list) {
            m.checkNotNullParameter(list, "<set-?>");
            this.audioDevices = list;
        }

        public String toString() {
            StringBuilder sbU = a.U("State(audioDevices=");
            sbU.append(this.audioDevices);
            sbU.append(", activeAudioDevice=");
            sbU.append(this.activeAudioDevice);
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(List list, DiscordAudioManager.DeviceTypes deviceTypes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
                list = DiscordAudioManager.f();
            }
            this(list, (i & 2) != 0 ? DiscordAudioManager.DeviceTypes.INVALID : deviceTypes);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    public static final class VideoUseDetector {
        private final StoreChannels channelsStore;
        private final StoreUser usersStore;
        private final StoreVoiceStates voiceStatesStore;

        public VideoUseDetector(StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUser storeUser) {
            m.checkNotNullParameter(storeChannels, "channelsStore");
            m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
            m.checkNotNullParameter(storeUser, "usersStore");
            this.channelsStore = storeChannels;
            this.voiceStatesStore = storeVoiceStates;
            this.usersStore = storeUser;
        }

        @StoreThread
        private final Map<Long, VoiceState> getVoiceStatesForChannel(long channelId) {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.channelsStore.findChannelByIdInternal$app_productionGoogleRelease(channelId);
            Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
            if (map == null) {
                return h0.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, VoiceState> entry : map.entrySet()) {
                Long channelId2 = entry.getValue().getChannelId();
                if (channelId2 != null && channelId2.longValue() == channelId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }

        @StoreThread
        public final boolean isMyVideoOn(long channelId) {
            VoiceState voiceState = getVoiceStatesForChannel(channelId).get(Long.valueOf(this.usersStore.getMe().getId()));
            if (voiceState == null) {
                return false;
            }
            m.checkNotNullParameter(voiceState, "$this$hasVideo");
            return voiceState.getSelfStream() || voiceState.getSelfVideo();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DiscordAudioManager.DeviceTypes.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[DiscordAudioManager.DeviceTypes.SPEAKERPHONE.ordinal()] = 1;
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager.d().h(true);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager.d().h(false);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {

        /* compiled from: StoreAudioManagerV2.kt */
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02071 extends o implements Function1<List<? extends DiscordAudioManager.AudioDevice>, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02081 extends o implements Function0<Unit> {
                public final /* synthetic */ List $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02081(List list) {
                    super(0);
                    this.$it = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateAudioDevices(StoreAudioManagerV2.this, this.$it);
                }
            }

            public C02071() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DiscordAudioManager.AudioDevice> list) {
                invoke2((List<DiscordAudioManager.AudioDevice>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DiscordAudioManager.AudioDevice> list) {
                m.checkNotNullParameter(list, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C02081(list));
            }
        }

        /* compiled from: StoreAudioManagerV2.kt */
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<DiscordAudioManager.DeviceTypes, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02091 extends o implements Function0<Unit> {
                public final /* synthetic */ DiscordAudioManager.DeviceTypes $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02091(DiscordAudioManager.DeviceTypes deviceTypes) {
                    super(0);
                    this.$it = deviceTypes;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateActiveAudioDevice(StoreAudioManagerV2.this, this.$it);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DiscordAudioManager.DeviceTypes deviceTypes) {
                invoke2(deviceTypes);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DiscordAudioManager.DeviceTypes deviceTypes) {
                m.checkNotNullParameter(deviceTypes, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C02091(deviceTypes));
            }
        }

        /* compiled from: StoreAudioManagerV2.kt */
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function1<Integer, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3$1, reason: invalid class name and collision with other inner class name */
            public static final class C02101 extends o implements Function0<Unit> {
                public final /* synthetic */ int $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02101(int i) {
                    super(0);
                    this.$it = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateCurrentMediaVolume(StoreAudioManagerV2.this, this.$it);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C02101(i));
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            Observable<List<DiscordAudioManager.AudioDevice>> observableR = DiscordAudioManager.d().f2785s.r();
            m.checkNotNullExpressionValue(observableR, "audioDevicesSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02071(), 62, (Object) null);
            Observable<DiscordAudioManager.DeviceTypes> observableR2 = DiscordAudioManager.d().u.r();
            m.checkNotNullExpressionValue(observableR2, "activeAudioDeviceSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR2, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
            Observable<Integer> observableR3 = DiscordAudioManager.d().f2787y.r();
            m.checkNotNullExpressionValue(observableR3, "currentMediaVolumeSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR3, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$observeAudioManagerState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreAudioManagerV2.access$getAudioManagerState(StoreAudioManagerV2.this);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$selectOutputDevice$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $device;

        public AnonymousClass1(DiscordAudioManager.DeviceTypes deviceTypes) {
            this.$device = deviceTypes;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            boolean z2;
            boolean z3;
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            DiscordAudioManager.DeviceTypes deviceTypes = this.$device;
            Objects.requireNonNull(discordAudioManagerD);
            m.checkNotNullParameter(deviceTypes, "deviceType");
            discordAudioManagerD.c();
            if (!discordAudioManagerD.e().f262b) {
                d.f1("DiscordAudioManager", "Can't setDevice, requires MODIFY_AUDIO_SETTINGS.");
                return;
            }
            d.b1("DiscordAudioManager", "setDevice(deviceType=" + deviceTypes + ')');
            synchronized (discordAudioManagerD.i) {
                List<DiscordAudioManager.AudioDevice> list = discordAudioManagerD.r;
                arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DiscordAudioManager.AudioDevice.a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
                }
            }
            DiscordAudioManager.DeviceTypes deviceTypes2 = DiscordAudioManager.DeviceTypes.DEFAULT;
            if (deviceTypes == deviceTypes2) {
                synchronized (discordAudioManagerD.i) {
                    discordAudioManagerD.f2788z = deviceTypes2;
                }
                discordAudioManagerD.a(arrayList);
                return;
            }
            int iOrdinal = deviceTypes.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                z2 = false;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                z2 = true;
            }
            if (z2) {
                synchronized (discordAudioManagerD.i) {
                    z3 = true ^ discordAudioManagerD.r.get(deviceTypes.getValue()).isAvailable;
                }
                if (z3) {
                    return;
                }
                synchronized (discordAudioManagerD.i) {
                    discordAudioManagerD.f2788z = deviceTypes;
                }
                discordAudioManagerD.b(deviceTypes);
            }
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$toggleSpeakerOutput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DiscordAudioManager.DeviceTypes deviceTypesPrevious;
            if (StoreAudioManagerV2.this.getState().getActiveAudioDevice().ordinal() != 2) {
                StoreAudioManagerV2.this.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                return;
            }
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            List<DiscordAudioManager.DeviceTypes> list = DiscordAudioManager.c;
            ListIterator<DiscordAudioManager.DeviceTypes> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    deviceTypesPrevious = null;
                    break;
                }
                deviceTypesPrevious = listIterator.previous();
                DiscordAudioManager.DeviceTypes deviceTypes = deviceTypesPrevious;
                if (deviceTypes != DiscordAudioManager.DeviceTypes.SPEAKERPHONE && StoreAudioManagerV2.this.getState().getAudioDevices().get(deviceTypes.getValue()).isAvailable) {
                    break;
                }
            }
            m.checkNotNull(deviceTypesPrevious);
            StoreAudioManagerV2.this.selectOutputDevice(deviceTypesPrevious);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    /* renamed from: com.discord.stores.StoreAudioManagerV2$updateMediaVolume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ float $ratio;

        public AnonymousClass1(float f) {
            this.$ratio = f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            float f = this.$ratio;
            discordAudioManagerD.c();
            if (f < 0.0f || f > 1.0f) {
                d.f1("DiscordAudioManager", "Unexpected media volume ratio: " + f);
                return;
            }
            try {
                discordAudioManagerD.e.setStreamVolume(3, d0.a0.a.roundToInt(f * discordAudioManagerD.f2786x), 0);
            } catch (SecurityException e) {
                d.f1("DiscordAudioManager", "Failed to set stream volume: " + e);
            }
        }
    }

    static {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DEFAULT_STATE = new State(DiscordAudioManager.f(), DiscordAudioManager.DeviceTypes.EARPIECE);
    }

    public StoreAudioManagerV2(ObservationDeck observationDeck, Dispatcher dispatcher, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreStreamRtcConnection storeStreamRtcConnection, VideoUseDetector videoUseDetector, StoreExperiments storeExperiments) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        m.checkNotNullParameter(videoUseDetector, "videoUseDetector");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.channelsStore = storeChannels;
        this.streamRtcConnectionStore = storeStreamRtcConnection;
        this.videoUseDetector = videoUseDetector;
        this.experimentsStore = storeExperiments;
        State state = new State(null, null, 3, null);
        this.state = state;
        this.stateSnapshot = state;
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.lastActiveAudioDevice = DiscordAudioManager.f2784b;
        this.audioManagerThread = new HandlerThread("AudioManagerThread", -1);
    }

    public static final /* synthetic */ State access$getAudioManagerState(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.getStateSnapshot();
    }

    public static final /* synthetic */ State access$getDEFAULT_STATE$cp() {
        return DEFAULT_STATE;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.dispatcher;
    }

    public static final /* synthetic */ void access$updateActiveAudioDevice(StoreAudioManagerV2 storeAudioManagerV2, DiscordAudioManager.DeviceTypes deviceTypes) {
        storeAudioManagerV2.updateActiveAudioDevice(deviceTypes);
    }

    public static final /* synthetic */ void access$updateAudioDevices(StoreAudioManagerV2 storeAudioManagerV2, List list) {
        storeAudioManagerV2.updateAudioDevices(list);
    }

    public static final /* synthetic */ void access$updateCurrentMediaVolume(StoreAudioManagerV2 storeAudioManagerV2, int i) {
        storeAudioManagerV2.updateCurrentMediaVolume(i);
    }

    /* renamed from: getAudioManagerState, reason: from getter */
    private final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    private final void updateActiveAudioDevice(DiscordAudioManager.DeviceTypes device) {
        State stateCopy$default = State.copy$default(this.state, null, device, 1, null);
        this.state = stateCopy$default;
        if (device != DiscordAudioManager.DeviceTypes.INVALID && device != DiscordAudioManager.DeviceTypes.DEFAULT) {
            this.lastActiveAudioDevice = stateCopy$default.getAudioDevices().get(device.getValue());
        }
        markChanged();
    }

    @StoreThread
    private final void updateAudioDevices(List<DiscordAudioManager.AudioDevice> devices) {
        this.state = State.copy$default(this.state, devices, null, 2, null);
        markChanged();
    }

    private final void updateCurrentMediaVolume(int currentMediaVolumeIndex) {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude((currentMediaVolumeIndex / DiscordAudioManager.d().f2786x) * 300.0f, 300.0f));
    }

    /* renamed from: getLastActiveAudioDevice$app_productionGoogleRelease, reason: from getter */
    public final DiscordAudioManager.AudioDevice getLastActiveAudioDevice() {
        return this.lastActiveAudioDevice;
    }

    /* renamed from: getState$app_productionGoogleRelease, reason: from getter */
    public final State getState() {
        return this.state;
    }

    @StoreThread
    public final void handleRtcConnectionState(RtcConnection.State state) {
        m.checkNotNullParameter(state, "state");
        if (m.areEqual(state, RtcConnection.State.f.a)) {
            Handler handler = this.audioManagerHandler;
            if (handler == null) {
                m.throwUninitializedPropertyAccessException("audioManagerHandler");
            }
            handler.post(AnonymousClass1.INSTANCE);
            return;
        }
        if (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) {
            return;
        }
        Handler handler2 = this.audioManagerHandler;
        if (handler2 == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler2.post(AnonymousClass2.INSTANCE);
    }

    @StoreThread
    public final void handleVoiceStatesUpdated() {
        boolean zIsMyVideoOn = this.videoUseDetector.isMyVideoOn(this.voiceChannelSelectedStore.getSelectedVoiceChannelId());
        if (zIsMyVideoOn == this.prevMyVideoOn) {
            return;
        }
        if (zIsMyVideoOn) {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            synchronized (discordAudioManagerD) {
                if (discordAudioManagerD.r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable) {
                    List<DiscordAudioManager.AudioDevice> list = discordAudioManagerD.r;
                    ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice : list) {
                        arrayList.add(audioDevice.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.a(audioDevice, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManagerD.r = arrayList;
                    discordAudioManagerD.f2785s.k.onNext(arrayList);
                    discordAudioManagerD.l();
                }
            }
        } else {
            DiscordAudioManager discordAudioManager2 = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD2 = DiscordAudioManager.d();
            synchronized (discordAudioManagerD2) {
                if (discordAudioManagerD2.r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable != discordAudioManagerD2.h) {
                    List<DiscordAudioManager.AudioDevice> list2 = discordAudioManagerD2.r;
                    ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list2, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice2 : list2) {
                        arrayList2.add(audioDevice2.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.a(audioDevice2, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.a(audioDevice2, null, discordAudioManagerD2.h, null, null, 13));
                    }
                    discordAudioManagerD2.r = arrayList2;
                    discordAudioManagerD2.f2785s.k.onNext(arrayList2);
                    discordAudioManagerD2.l();
                }
            }
        }
        this.prevMyVideoOn = zIsMyVideoOn;
    }

    public final void init(Application context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
        if (!this.audioManagerThread.isAlive()) {
            this.audioManagerThread.start();
        }
        Handler handler = new Handler(this.audioManagerThread.getLooper());
        this.audioManagerHandler = handler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1());
    }

    public final Observable<State> observeAudioManagerState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void selectOutputDevice(DiscordAudioManager.DeviceTypes device) {
        m.checkNotNullParameter(device, "device");
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1(device));
    }

    public final void setState$app_productionGoogleRelease(State state) {
        m.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        List<DiscordAudioManager.AudioDevice> audioDevices = this.state.getAudioDevices();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(audioDevices, 10));
        Iterator<T> it = audioDevices.iterator();
        while (it.hasNext()) {
            arrayList.add(DiscordAudioManager.AudioDevice.a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
        }
        this.stateSnapshot = this.state.copy(arrayList, this.state.getActiveAudioDevice());
    }

    public final void toggleSpeakerOutput() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void updateMediaVolume(float ratio) {
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1(ratio));
    }
}
