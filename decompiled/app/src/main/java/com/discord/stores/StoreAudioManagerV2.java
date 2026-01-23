package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.PerceptualVolumeUtils;
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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p508a0.MathJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2 extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
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

    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final /* data */ class State {
        private DiscordAudioManager.DeviceTypes activeAudioDevice;
        private List<DiscordAudioManager.AudioDevice> audioDevices;

        public State() {
            this(null, null, 3, null);
        }

        public State(List<DiscordAudioManager.AudioDevice> list, DiscordAudioManager.DeviceTypes deviceTypes) {
            Intrinsics3.checkNotNullParameter(list, "audioDevices");
            Intrinsics3.checkNotNullParameter(deviceTypes, "activeAudioDevice");
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

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DiscordAudioManager.DeviceTypes getActiveAudioDevice() {
            return this.activeAudioDevice;
        }

        public final State copy(List<DiscordAudioManager.AudioDevice> audioDevices, DiscordAudioManager.DeviceTypes activeAudioDevice) {
            Intrinsics3.checkNotNullParameter(audioDevices, "audioDevices");
            Intrinsics3.checkNotNullParameter(activeAudioDevice, "activeAudioDevice");
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
            return Intrinsics3.areEqual(this.audioDevices, state.audioDevices) && Intrinsics3.areEqual(this.activeAudioDevice, state.activeAudioDevice);
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
            Intrinsics3.checkNotNullParameter(deviceTypes, "<set-?>");
            this.activeAudioDevice = deviceTypes;
        }

        public final void setAudioDevices(List<DiscordAudioManager.AudioDevice> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.audioDevices = list;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("State(audioDevices=");
            sbM833U.append(this.audioDevices);
            sbM833U.append(", activeAudioDevice=");
            sbM833U.append(this.activeAudioDevice);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(List list, DiscordAudioManager.DeviceTypes deviceTypes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
                list = DiscordAudioManager.m8482f();
            }
            this(list, (i & 2) != 0 ? DiscordAudioManager.DeviceTypes.INVALID : deviceTypes);
        }
    }

    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class VideoUseDetector {
        private final StoreChannels channelsStore;
        private final StoreUser usersStore;
        private final StoreVoiceStates voiceStatesStore;

        public VideoUseDetector(StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUser storeUser) {
            Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
            Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
            Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
            this.channelsStore = storeChannels;
            this.voiceStatesStore = storeVoiceStates;
            this.usersStore = storeUser;
        }

        @Store3
        private final Map<Long, VoiceState> getVoiceStatesForChannel(long channelId) {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.channelsStore.findChannelByIdInternal$app_productionGoogleRelease(channelId);
            Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
            if (map == null) {
                return Maps6.emptyMap();
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

        @Store3
        public final boolean isMyVideoOn(long channelId) {
            VoiceState voiceState = getVoiceStatesForChannel(channelId).get(Long.valueOf(this.usersStore.getMe().getId()));
            if (voiceState == null) {
                return false;
            }
            Intrinsics3.checkNotNullParameter(voiceState, "$this$hasVideo");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class RunnableC57521 implements Runnable {
        public static final RunnableC57521 INSTANCE = new RunnableC57521();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            DiscordAudioManager.m8481d().m8488h(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$2 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class RunnableC57532 implements Runnable {
        public static final RunnableC57532 INSTANCE = new RunnableC57532();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            DiscordAudioManager.m8481d().m8488h(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class RunnableC57541 implements Runnable {

        /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends DiscordAudioManager.AudioDevice>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
            public static final class C132491 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132491(List list) {
                    super(0);
                    this.$it = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateAudioDevices(StoreAudioManagerV2.this, this.$it);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DiscordAudioManager.AudioDevice> list) {
                invoke2((List<DiscordAudioManager.AudioDevice>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DiscordAudioManager.AudioDevice> list) {
                Intrinsics3.checkNotNullParameter(list, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C132491(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<DiscordAudioManager.DeviceTypes, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ DiscordAudioManager.DeviceTypes $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DiscordAudioManager.DeviceTypes deviceTypes) {
                    super(0);
                    this.$it = deviceTypes;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DiscordAudioManager.DeviceTypes deviceTypes) {
                Intrinsics3.checkNotNullParameter(deviceTypes, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new AnonymousClass1(deviceTypes));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ int $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(int i) {
                    super(0);
                    this.$it = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new AnonymousClass1(i));
            }
        }

        public RunnableC57541() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            Observable<List<DiscordAudioManager.AudioDevice>> observableM11112r = DiscordAudioManager.m8481d().f18848s.m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "audioDevicesSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableM11112r, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
            Observable<DiscordAudioManager.DeviceTypes> observableM11112r2 = DiscordAudioManager.m8481d().f18850u.m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r2, "activeAudioDeviceSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableM11112r2, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
            Observable<Integer> observableM11112r3 = DiscordAudioManager.m8481d().f18854y.m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r3, "currentMediaVolumeSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableM11112r3, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$observeAudioManagerState$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class C57551 extends Lambda implements Function0<State> {
        public C57551() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$selectOutputDevice$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class RunnableC57561 implements Runnable {
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $device;

        public RunnableC57561(DiscordAudioManager.DeviceTypes deviceTypes) {
            this.$device = deviceTypes;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            boolean z2;
            boolean z3;
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            DiscordAudioManager discordAudioManagerM8481d = DiscordAudioManager.m8481d();
            DiscordAudioManager.DeviceTypes deviceTypes = this.$device;
            Objects.requireNonNull(discordAudioManagerM8481d);
            Intrinsics3.checkNotNullParameter(deviceTypes, "deviceType");
            discordAudioManagerM8481d.m8485c();
            if (!discordAudioManagerM8481d.m8486e().f1644b) {
                AnimatableValueParser.m517f1("DiscordAudioManager", "Can't setDevice, requires MODIFY_AUDIO_SETTINGS.");
                return;
            }
            AnimatableValueParser.m501b1("DiscordAudioManager", "setDevice(deviceType=" + deviceTypes + ')');
            synchronized (discordAudioManagerM8481d.f18838i) {
                List<DiscordAudioManager.AudioDevice> list = discordAudioManagerM8481d.f18847r;
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DiscordAudioManager.AudioDevice.m8493a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
                }
            }
            DiscordAudioManager.DeviceTypes deviceTypes2 = DiscordAudioManager.DeviceTypes.DEFAULT;
            if (deviceTypes == deviceTypes2) {
                synchronized (discordAudioManagerM8481d.f18838i) {
                    discordAudioManagerM8481d.f18855z = deviceTypes2;
                }
                discordAudioManagerM8481d.m8483a(arrayList);
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
                synchronized (discordAudioManagerM8481d.f18838i) {
                    z3 = true ^ discordAudioManagerM8481d.f18847r.get(deviceTypes.getValue()).isAvailable;
                }
                if (z3) {
                    return;
                }
                synchronized (discordAudioManagerM8481d.f18838i) {
                    discordAudioManagerM8481d.f18855z = deviceTypes;
                }
                discordAudioManagerM8481d.m8484b(deviceTypes);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$toggleSpeakerOutput$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class C57571 extends Lambda implements Function0<Unit> {
        public C57571() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            DiscordAudioManager.DeviceTypes deviceTypesPrevious;
            if (StoreAudioManagerV2.this.getState().getActiveAudioDevice().ordinal() != 2) {
                StoreAudioManagerV2.this.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                return;
            }
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            List<DiscordAudioManager.DeviceTypes> list = DiscordAudioManager.f18828c;
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
            Intrinsics3.checkNotNull(deviceTypesPrevious);
            StoreAudioManagerV2.this.selectOutputDevice(deviceTypesPrevious);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAudioManagerV2$updateMediaVolume$1 */
    /* JADX INFO: compiled from: StoreAudioManagerV2.kt */
    public static final class RunnableC57581 implements Runnable {
        public final /* synthetic */ float $ratio;

        public RunnableC57581(float f) {
            this.$ratio = f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            DiscordAudioManager discordAudioManagerM8481d = DiscordAudioManager.m8481d();
            float f = this.$ratio;
            discordAudioManagerM8481d.m8485c();
            if (f < 0.0f || f > 1.0f) {
                AnimatableValueParser.m517f1("DiscordAudioManager", "Unexpected media volume ratio: " + f);
                return;
            }
            try {
                discordAudioManagerM8481d.f18834e.setStreamVolume(3, MathJVM.roundToInt(f * discordAudioManagerM8481d.f18853x), 0);
            } catch (SecurityException e) {
                AnimatableValueParser.m517f1("DiscordAudioManager", "Failed to set stream volume: " + e);
            }
        }
    }

    static {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
        DEFAULT_STATE = new State(DiscordAudioManager.m8482f(), DiscordAudioManager.DeviceTypes.EARPIECE);
    }

    public StoreAudioManagerV2(ObservationDeck observationDeck, Dispatcher dispatcher, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreStreamRtcConnection storeStreamRtcConnection, VideoUseDetector videoUseDetector, StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        Intrinsics3.checkNotNullParameter(videoUseDetector, "videoUseDetector");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
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
        DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
        this.lastActiveAudioDevice = DiscordAudioManager.f18827b;
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

    /* JADX INFO: renamed from: getAudioManagerState, reason: from getter */
    private final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @Store3
    private final void updateActiveAudioDevice(DiscordAudioManager.DeviceTypes device) {
        State stateCopy$default = State.copy$default(this.state, null, device, 1, null);
        this.state = stateCopy$default;
        if (device != DiscordAudioManager.DeviceTypes.INVALID && device != DiscordAudioManager.DeviceTypes.DEFAULT) {
            this.lastActiveAudioDevice = stateCopy$default.getAudioDevices().get(device.getValue());
        }
        markChanged();
    }

    @Store3
    private final void updateAudioDevices(List<DiscordAudioManager.AudioDevice> devices) {
        this.state = State.copy$default(this.state, devices, null, 2, null);
        markChanged();
    }

    private final void updateCurrentMediaVolume(int currentMediaVolumeIndex) {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
        this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude((currentMediaVolumeIndex / DiscordAudioManager.m8481d().f18853x) * 300.0f, 300.0f));
    }

    /* JADX INFO: renamed from: getLastActiveAudioDevice$app_productionGoogleRelease, reason: from getter */
    public final DiscordAudioManager.AudioDevice getLastActiveAudioDevice() {
        return this.lastActiveAudioDevice;
    }

    /* JADX INFO: renamed from: getState$app_productionGoogleRelease, reason: from getter */
    public final State getState() {
        return this.state;
    }

    @Store3
    public final void handleRtcConnectionState(RtcConnection.State state) {
        Intrinsics3.checkNotNullParameter(state, "state");
        if (Intrinsics3.areEqual(state, RtcConnection.State.C5612f.f18814a)) {
            Handler handler = this.audioManagerHandler;
            if (handler == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
            }
            handler.post(RunnableC57521.INSTANCE);
            return;
        }
        if (!(state instanceof RtcConnection.State.C5610d) || ((RtcConnection.State.C5610d) state).f18812a) {
            return;
        }
        Handler handler2 = this.audioManagerHandler;
        if (handler2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler2.post(RunnableC57532.INSTANCE);
    }

    @Store3
    public final void handleVoiceStatesUpdated() {
        boolean zIsMyVideoOn = this.videoUseDetector.isMyVideoOn(this.voiceChannelSelectedStore.getSelectedVoiceChannelId());
        if (zIsMyVideoOn == this.prevMyVideoOn) {
            return;
        }
        if (zIsMyVideoOn) {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.f18829d;
            DiscordAudioManager discordAudioManagerM8481d = DiscordAudioManager.m8481d();
            synchronized (discordAudioManagerM8481d) {
                if (discordAudioManagerM8481d.f18847r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable) {
                    List<DiscordAudioManager.AudioDevice> list = discordAudioManagerM8481d.f18847r;
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice : list) {
                        arrayList.add(audioDevice.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.m8493a(audioDevice, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.m8493a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManagerM8481d.f18847r = arrayList;
                    discordAudioManagerM8481d.f18848s.f27653k.onNext(arrayList);
                    discordAudioManagerM8481d.m8492l();
                }
            }
        } else {
            DiscordAudioManager discordAudioManager2 = DiscordAudioManager.f18829d;
            DiscordAudioManager discordAudioManagerM8481d2 = DiscordAudioManager.m8481d();
            synchronized (discordAudioManagerM8481d2) {
                if (discordAudioManagerM8481d2.f18847r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable != discordAudioManagerM8481d2.f18837h) {
                    List<DiscordAudioManager.AudioDevice> list2 = discordAudioManagerM8481d2.f18847r;
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice2 : list2) {
                        arrayList2.add(audioDevice2.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.m8493a(audioDevice2, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.m8493a(audioDevice2, null, discordAudioManagerM8481d2.f18837h, null, null, 13));
                    }
                    discordAudioManagerM8481d2.f18847r = arrayList2;
                    discordAudioManagerM8481d2.f18848s.f27653k.onNext(arrayList2);
                    discordAudioManagerM8481d2.m8492l();
                }
            }
        }
        this.prevMyVideoOn = zIsMyVideoOn;
    }

    public final void init(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
        if (!this.audioManagerThread.isAlive()) {
            this.audioManagerThread.start();
        }
        Handler handler = new Handler(this.audioManagerThread.getLooper());
        this.audioManagerHandler = handler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new RunnableC57541());
    }

    public final Observable<State> observeAudioManagerState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57551(), 14, null);
    }

    public final void selectOutputDevice(DiscordAudioManager.DeviceTypes device) {
        Intrinsics3.checkNotNullParameter(device, "device");
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new RunnableC57561(device));
    }

    public final void setState$app_productionGoogleRelease(State state) {
        Intrinsics3.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        List<DiscordAudioManager.AudioDevice> audioDevices = this.state.getAudioDevices();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(audioDevices, 10));
        Iterator<T> it = audioDevices.iterator();
        while (it.hasNext()) {
            arrayList.add(DiscordAudioManager.AudioDevice.m8493a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
        }
        this.stateSnapshot = this.state.copy(arrayList, this.state.getActiveAudioDevice());
    }

    public final void toggleSpeakerOutput() {
        this.dispatcher.schedule(new C57571());
    }

    public final void updateMediaVolume(float ratio) {
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new RunnableC57581(ratio));
    }
}
