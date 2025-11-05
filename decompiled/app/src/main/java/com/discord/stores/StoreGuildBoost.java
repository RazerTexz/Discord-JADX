package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildBoost.kt */
/* loaded from: classes2.dex */
public final class StoreGuildBoost extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private State stateSnapshot;

    /* compiled from: StoreGuildBoost.kt */
    public static abstract class State {

        /* compiled from: StoreGuildBoost.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildBoost.kt */
        public static final /* data */ class Loaded extends State {
            private final Map<Long, ModelGuildBoostSlot> boostSlotMap;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, ModelGuildBoostSlot> map) {
                super(null);
                m.checkNotNullParameter(map, "boostSlotMap");
                this.boostSlotMap = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.boostSlotMap;
                }
                return loaded.copy(map);
            }

            public final Map<Long, ModelGuildBoostSlot> component1() {
                return this.boostSlotMap;
            }

            public final Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap) {
                m.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                return new Loaded(boostSlotMap);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.boostSlotMap, ((Loaded) other).boostSlotMap);
                }
                return true;
            }

            public final Loaded filterByGuildId(Long guildId) {
                Map<Long, ModelGuildBoostSlot> map;
                if (guildId == null) {
                    map = this.boostSlotMap;
                } else {
                    Map<Long, ModelGuildBoostSlot> map2 = this.boostSlotMap;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, ModelGuildBoostSlot> entry : map2.entrySet()) {
                        ModelAppliedGuildBoost premiumGuildSubscription = entry.getValue().getPremiumGuildSubscription();
                        if (m.areEqual(premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null, guildId)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    map = linkedHashMap;
                }
                return new Loaded(map);
            }

            public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
                return this.boostSlotMap;
            }

            public int hashCode() {
                Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.M(a.U("Loaded(boostSlotMap="), this.boostSlotMap, ")");
            }
        }

        /* compiled from: StoreGuildBoost.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$1, reason: invalid class name */
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
            StoreGuildBoost.this.handleFetchingState();
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

        /* compiled from: StoreGuildBoost.kt */
        /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2$1, reason: invalid class name */
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
                StoreGuildBoost.this.handleFetchError();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<List<? extends ModelGuildBoostSlot>, Unit> {

        /* compiled from: StoreGuildBoost.kt */
        /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $subscriptionsSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$subscriptionsSlots = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchStateSuccess(this.$subscriptionsSlots);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildBoostSlot> list) {
            invoke2((List<ModelGuildBoostSlot>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGuildBoostSlot> list) {
            m.checkNotNullParameter(list, "subscriptionsSlots");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    /* renamed from: com.discord.stores.StoreGuildBoost$observeGuildBoostState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<State> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            State stateSnapshot = StoreGuildBoost.this.getStateSnapshot();
            return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(this.$guildId) : stateSnapshot;
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    /* renamed from: com.discord.stores.StoreGuildBoost$updateGuildBoostSlot$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ ModelGuildBoostSlot $newSlot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGuildBoostSlot modelGuildBoostSlot) {
            super(0);
            this.$newSlot = modelGuildBoostSlot;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State stateAccess$getState$p = StoreGuildBoost.access$getState$p(StoreGuildBoost.this);
            if (stateAccess$getState$p instanceof State.Loaded) {
                StoreGuildBoost.access$setState$p(StoreGuildBoost.this, new State.Loaded(h0.plus(((State.Loaded) stateAccess$getState$p).getBoostSlotMap(), d0.o.to(Long.valueOf(this.$newSlot.getId()), this.$newSlot))));
                StoreGuildBoost.this.markChanged();
            }
        }
    }

    public StoreGuildBoost(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }

    public static final /* synthetic */ State access$getState$p(StoreGuildBoost storeGuildBoost) {
        return storeGuildBoost.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreGuildBoost storeGuildBoost, State state) {
        storeGuildBoost.state = state;
    }

    public static /* synthetic */ State getGuildBoostsState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.getGuildBoostsState(l);
    }

    public static /* synthetic */ Observable observeGuildBoostState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.observeGuildBoostState(l);
    }

    public final void fetchUserGuildBoostState() {
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getSubscriptionSlots(), false, 1, null), StoreGuildBoost.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final State getGuildBoostsState(Long guildId) {
        State stateSnapshot = getStateSnapshot();
        return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(guildId) : stateSnapshot;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    /* renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleFetchStateSuccess(List<ModelGuildBoostSlot> guildBoostSlots) {
        m.checkNotNullParameter(guildBoostSlots, "guildBoostSlots");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(guildBoostSlots, 10)), 16));
        for (Object obj : guildBoostSlots) {
            linkedHashMap.put(Long.valueOf(((ModelGuildBoostSlot) obj).getId()), obj);
        }
        this.state = new State.Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeGuildBoostState(Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        State loaded = this.state;
        if (!(loaded instanceof State.Loading) && !(loaded instanceof State.Failure)) {
            if (!(loaded instanceof State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = new State.Loaded(h0.toMap(((State.Loaded) loaded).getBoostSlotMap()));
        }
        this.stateSnapshot = loaded;
    }

    public final void updateGuildBoostSlot(ModelGuildBoostSlot newSlot) {
        m.checkNotNullParameter(newSlot, "newSlot");
        this.dispatcher.schedule(new AnonymousClass1(newSlot));
    }
}
