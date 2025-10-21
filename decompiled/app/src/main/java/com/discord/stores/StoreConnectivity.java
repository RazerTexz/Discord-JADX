package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
import com.discord.stores.StoreV2;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.a0.MathJVM;
import d0.d0._Ranges;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: StoreConnectivity.kt */
/* loaded from: classes2.dex */
public final class StoreConnectivity extends StoreV2 {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(StoreConnectivity.class, "state", "getState()Lcom/discord/stores/StoreConnectivity$DelayedState;", 0))};
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long DELAY_EXTENDED = 10000;

    @Deprecated
    public static final long DELAY_INTERVAL = 100;

    @Deprecated
    public static final long DELAY_NOMINAL = 1000;
    private boolean channelMessagesLoading;
    private final Clock clock;
    private NetworkMonitor.State deviceNetworkState;
    private final Dispatcher dispatcher;
    private boolean isReadyPayloadReceived;

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private final StoreV2.MarkChangedDelegate state;
    private long stateTriggeredDelay;
    private Long stateTriggeredTimeMillis;
    private final StoreStream stream;

    /* compiled from: StoreConnectivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreConnectivity.kt */
    public static final /* data */ class DelayedState {
        private final long delay;
        private final State state;

        public DelayedState(State state, long j) {
            Intrinsics3.checkNotNullParameter(state, "state");
            this.state = state;
            this.delay = j;
        }

        public static /* synthetic */ DelayedState copy$default(DelayedState delayedState, State state, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                state = delayedState.state;
            }
            if ((i & 2) != 0) {
                j = delayedState.delay;
            }
            return delayedState.copy(state, j);
        }

        /* renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDelay() {
            return this.delay;
        }

        public final DelayedState copy(State state, long delay) {
            Intrinsics3.checkNotNullParameter(state, "state");
            return new DelayedState(state, delay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DelayedState)) {
                return false;
            }
            DelayedState delayedState = (DelayedState) other;
            return Intrinsics3.areEqual(this.state, delayedState.state) && this.delay == delayedState.delay;
        }

        public final long getDelay() {
            return this.delay;
        }

        public final State getState() {
            return this.state;
        }

        public int hashCode() {
            State state = this.state;
            return b.a(this.delay) + ((state != null ? state.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DelayedState(state=");
            sbU.append(this.state);
            sbU.append(", delay=");
            return outline.C(sbU, this.delay, ")");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ DelayedState(State state, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                StoreConnectivity.access$Companion();
                j = 1000;
            }
            this(state, j);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    public enum State {
        ONLINE,
        OFFLINE,
        OFFLINE_AIRPLANE_MODE,
        CONNECTING
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.ONLINE.ordinal()] = 1;
            iArr[State.OFFLINE.ordinal()] = 2;
            iArr[State.OFFLINE_AIRPLANE_MODE.ordinal()] = 3;
            iArr[State.CONNECTING.ordinal()] = 4;
        }
    }

    /* compiled from: StoreConnectivity.kt */
    /* renamed from: com.discord.stores.StoreConnectivity$handleChannelMessagesLoading$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $channelMessagesLoading;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$channelMessagesLoading = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreConnectivity.access$setChannelMessagesLoading$p(StoreConnectivity.this, this.$channelMessagesLoading);
            StoreConnectivity.access$updateConnectivityState(StoreConnectivity.this);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    /* renamed from: com.discord.stores.StoreConnectivity$handleDeviceNetworkStateUpdated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NetworkMonitor.State $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NetworkMonitor.State state) {
            super(0);
            this.$state = state;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreConnectivity.access$setDeviceNetworkState$p(StoreConnectivity.this, this.$state);
            StoreConnectivity.access$updateConnectivityState(StoreConnectivity.this);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    /* renamed from: com.discord.stores.StoreConnectivity$init$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<NetworkMonitor.State, Unit> {
        public AnonymousClass1(StoreConnectivity storeConnectivity) {
            super(1, storeConnectivity, StoreConnectivity.class, "handleDeviceNetworkStateUpdated", "handleDeviceNetworkStateUpdated(Lcom/discord/utilities/networking/NetworkMonitor$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NetworkMonitor.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NetworkMonitor.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            StoreConnectivity.access$handleDeviceNetworkStateUpdated((StoreConnectivity) this.receiver, state);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    /* renamed from: com.discord.stores.StoreConnectivity$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(StoreConnectivity storeConnectivity) {
            super(1, storeConnectivity, StoreConnectivity.class, "handleChannelMessagesLoading", "handleChannelMessagesLoading(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreConnectivity.access$handleChannelMessagesLoading((StoreConnectivity) this.receiver, z2);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    /* renamed from: com.discord.stores.StoreConnectivity$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<DelayedState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DelayedState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DelayedState invoke() {
            return StoreConnectivity.access$getState$p(StoreConnectivity.this);
        }
    }

    public StoreConnectivity(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.state = new StoreV2.MarkChangedDelegate(new DelayedState(State.CONNECTING, 10000L), null, 2, null);
        this.stateTriggeredDelay = 10000L;
        this.deviceNetworkState = NetworkMonitor.State.OFFLINE;
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public static final /* synthetic */ boolean access$getChannelMessagesLoading$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.channelMessagesLoading;
    }

    public static final /* synthetic */ NetworkMonitor.State access$getDeviceNetworkState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.deviceNetworkState;
    }

    public static final /* synthetic */ DelayedState access$getState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.getState();
    }

    public static final /* synthetic */ void access$handleChannelMessagesLoading(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.handleChannelMessagesLoading(z2);
    }

    public static final /* synthetic */ void access$handleDeviceNetworkStateUpdated(StoreConnectivity storeConnectivity, NetworkMonitor.State state) {
        storeConnectivity.handleDeviceNetworkStateUpdated(state);
    }

    public static final /* synthetic */ void access$setChannelMessagesLoading$p(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.channelMessagesLoading = z2;
    }

    public static final /* synthetic */ void access$setDeviceNetworkState$p(StoreConnectivity storeConnectivity, NetworkMonitor.State state) {
        storeConnectivity.deviceNetworkState = state;
    }

    public static final /* synthetic */ void access$setState$p(StoreConnectivity storeConnectivity, DelayedState delayedState) {
        storeConnectivity.setState(delayedState);
    }

    public static final /* synthetic */ void access$updateConnectivityState(StoreConnectivity storeConnectivity) {
        storeConnectivity.updateConnectivityState();
    }

    private final long getNextStateDelayInitial(DelayedState state, State nextState) {
        int iOrdinal = nextState.ordinal();
        if (iOrdinal == 0) {
            return 1000L;
        }
        boolean z2 = true;
        if (iOrdinal == 1 || iOrdinal == 2) {
            return 1000L;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        State state2 = state.getState();
        if (state2 != State.OFFLINE && state2 != State.OFFLINE_AIRPLANE_MODE) {
            z2 = false;
        }
        return (!z2 || getStateActiveMillis() <= 1000) ? 10000L : 1000L;
    }

    private final DelayedState getState() {
        return (DelayedState) this.state.getValue(this, $$delegatedProperties[0]);
    }

    private final long getStateActiveMillis() {
        Long l = this.stateTriggeredTimeMillis;
        if (l == null) {
            return 0L;
        }
        return this.clock.currentTimeMillis() - l.longValue();
    }

    private final long getStateDelay(long defaultDelay) {
        return _Ranges.coerceAtLeast(MathJVM.roundToInt((defaultDelay - getStateActiveMillis()) / 100) * 100, 0L);
    }

    private final void handleChannelMessagesLoading(boolean channelMessagesLoading) {
        this.dispatcher.schedule(new AnonymousClass1(channelMessagesLoading));
    }

    private final void handleDeviceNetworkStateUpdated(NetworkMonitor.State state) {
        this.dispatcher.schedule(new AnonymousClass1(state));
    }

    private final void setState(DelayedState delayedState) {
        this.state.setValue(this, $$delegatedProperties[0], delayedState);
    }

    private final void updateConnectivityState() {
        NetworkMonitor.State state = this.deviceNetworkState;
        State state2 = state == NetworkMonitor.State.OFFLINE ? State.OFFLINE : state == NetworkMonitor.State.OFFLINE_AIRPLANE_MODE ? State.OFFLINE_AIRPLANE_MODE : (!this.isReadyPayloadReceived || this.channelMessagesLoading) ? State.CONNECTING : State.ONLINE;
        if (getState().getState() != state2 || this.stateTriggeredTimeMillis == null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
            this.stateTriggeredDelay = getNextStateDelayInitial(getState(), state2);
        }
        setState(new DelayedState(state2, getStateDelay(this.stateTriggeredDelay)));
    }

    @Store3
    public final void handleBackgrounded(boolean backgrounded) {
        if (backgrounded) {
            this.stateTriggeredDelay -= getStateActiveMillis();
        }
        if (this.stateTriggeredTimeMillis != null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
        }
        updateConnectivityState();
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.isReadyPayloadReceived = false;
        updateConnectivityState();
    }

    @Store3
    public final void handleConnectionReady(boolean connectionReady) {
        this.isReadyPayloadReceived = connectionReady;
        updateConnectivityState();
    }

    @Store3
    public final void init(NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(networkMonitor.observeState()), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessagesLoader().observeChannelMessagesLoading(), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    public final boolean isConnected() {
        return getState().getState() == State.ONLINE;
    }

    public final Observable<DelayedState> observeState() {
        Observable<DelayedState> observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }
}
