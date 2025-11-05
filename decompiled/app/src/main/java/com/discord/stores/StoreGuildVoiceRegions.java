package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildVoiceRegions.kt */
/* loaded from: classes2.dex */
public final class StoreGuildVoiceRegions extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ? extends List<? extends ModelVoiceRegion>> guildVoiceRegionsSnapshot;
    private final HashMap<Long, State> guildVoiceRegionsState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildVoiceRegions.kt */
    public static abstract class State {

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final /* data */ class Loaded extends State {
            private final List<ModelVoiceRegion> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelVoiceRegion> list) {
                super(null);
                m.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ModelVoiceRegion> component1() {
                return this.data;
            }

            public final Loaded copy(List<? extends ModelVoiceRegion> data) {
                m.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ModelVoiceRegion> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ModelVoiceRegion> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.L(a.U("Loaded(data="), this.data, ")");
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildVoiceRegions.kt */
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02541 extends o implements Function1<List<? extends ModelVoiceRegion>, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02551 extends o implements Function0<Unit> {
                public final /* synthetic */ List $voiceRegions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02551(List list) {
                    super(0);
                    this.$voiceRegions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegions(StoreGuildVoiceRegions.this, anonymousClass1.$guildId, this.$voiceRegions);
                }
            }

            public C02541() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelVoiceRegion> list) {
                invoke2(list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelVoiceRegion> list) {
                m.checkNotNullParameter(list, "voiceRegions");
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new C02551(list));
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02561 extends o implements Function0<Unit> {
                public C02561() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions.this, anonymousClass1.$guildId);
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
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new C02561());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State state = (State) StoreGuildVoiceRegions.access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildVoiceRegions(this.$guildId), false), StoreGuildVoiceRegions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C02541(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$observeGuildVoiceRegions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends ModelVoiceRegion>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelVoiceRegion> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelVoiceRegion> invoke2() {
            return StoreGuildVoiceRegions.this.getGuildVoiceRegions(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.guildVoiceRegionsState;
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegions(StoreGuildVoiceRegions storeGuildVoiceRegions, long j, List list) {
        storeGuildVoiceRegions.handleGuildVoiceRegions(j, list);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchStart(j);
    }

    @StoreThread
    private final void handleGuildVoiceRegions(long guildId, List<? extends ModelVoiceRegion> voiceRegions) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), new State.Loaded(voiceRegions));
        markChanged();
    }

    @StoreThread
    private final void handleGuildVoiceRegionsFetchFailed(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @StoreThread
    private final void handleGuildVoiceRegionsFetchStart(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final List<ModelVoiceRegion> getGuildVoiceRegions(long guildId) {
        List<ModelVoiceRegion> list = (List) this.guildVoiceRegionsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : n.emptyList();
    }

    public final Observable<List<ModelVoiceRegion>> observeGuildVoiceRegions(long guildId) {
        Observable<List<ModelVoiceRegion>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        List<ModelVoiceRegion> listEmptyList;
        super.snapshotData();
        HashMap<Long, State> map = this.guildVoiceRegionsState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, State> entry : map.entrySet()) {
            if (entry.getValue() instanceof State.Loaded) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (!(value instanceof State.Loaded)) {
                value = null;
            }
            State.Loaded loaded = (State.Loaded) value;
            if (loaded == null || (listEmptyList = loaded.getData()) == null) {
                listEmptyList = n.emptyList();
            }
            linkedHashMap2.put(key, listEmptyList);
        }
        this.guildVoiceRegionsSnapshot = linkedHashMap2;
    }

    public StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildVoiceRegionsSnapshot = h0.emptyMap();
        this.guildVoiceRegionsState = new HashMap<>();
    }
}
