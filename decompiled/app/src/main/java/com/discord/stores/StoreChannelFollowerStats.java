package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreChannelFollowerStats.kt */
/* loaded from: classes2.dex */
public final class StoreChannelFollowerStats extends StoreV2 {
    private static final int STALE_TIME_DIFF_MS = 3600000;
    private final Map<Long, ChannelFollowerStatData> channelFollowerStatsState;
    private Map<Long, ChannelFollowerStatData> channelFollowerStatsStateSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreChannelFollowerStats.kt */
    public static final /* data */ class ChannelFollowerStatData {
        private final ModelChannelFollowerStats data;
        private final FetchState fetchState;

        public ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats) {
            m.checkNotNullParameter(fetchState, "fetchState");
            m.checkNotNullParameter(modelChannelFollowerStats, "data");
            this.fetchState = fetchState;
            this.data = modelChannelFollowerStats;
        }

        public static /* synthetic */ ChannelFollowerStatData copy$default(ChannelFollowerStatData channelFollowerStatData, FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchState = channelFollowerStatData.fetchState;
            }
            if ((i & 2) != 0) {
                modelChannelFollowerStats = channelFollowerStatData.data;
            }
            return channelFollowerStatData.copy(fetchState, modelChannelFollowerStats);
        }

        /* renamed from: component1, reason: from getter */
        public final FetchState getFetchState() {
            return this.fetchState;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final ChannelFollowerStatData copy(FetchState fetchState, ModelChannelFollowerStats data) {
            m.checkNotNullParameter(fetchState, "fetchState");
            m.checkNotNullParameter(data, "data");
            return new ChannelFollowerStatData(fetchState, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelFollowerStatData)) {
                return false;
            }
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) other;
            return m.areEqual(this.fetchState, channelFollowerStatData.fetchState) && m.areEqual(this.data, channelFollowerStatData.data);
        }

        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final FetchState getFetchState() {
            return this.fetchState;
        }

        public int hashCode() {
            FetchState fetchState = this.fetchState;
            int iHashCode = (fetchState != null ? fetchState.hashCode() : 0) * 31;
            ModelChannelFollowerStats modelChannelFollowerStats = this.data;
            return iHashCode + (modelChannelFollowerStats != null ? modelChannelFollowerStats.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ChannelFollowerStatData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fetchState, (i & 2) != 0 ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : modelChannelFollowerStats);
        }
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    public enum FetchState {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreChannelFollowerStats.kt */
        /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02201 extends o implements Function1<ModelChannelFollowerStatsDto, Unit> {

            /* compiled from: StoreChannelFollowerStats.kt */
            /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02211 extends o implements Function0<Unit> {
                public final /* synthetic */ ModelChannelFollowerStatsDto $channelFollowerStats;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02211(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                    super(0);
                    this.$channelFollowerStats = modelChannelFollowerStatsDto;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchSuccess(StoreChannelFollowerStats.this, anonymousClass1.$channelId, ModelChannelFollowerStats.INSTANCE.fromResponse(this.$channelFollowerStats));
                }
            }

            public C02201() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                invoke2(modelChannelFollowerStatsDto);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                StoreChannelFollowerStats.access$getDispatcher$p(StoreChannelFollowerStats.this).schedule(new C02211(modelChannelFollowerStatsDto));
            }
        }

        /* compiled from: StoreChannelFollowerStats.kt */
        /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreChannelFollowerStats.kt */
            /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02221 extends o implements Function0<Unit> {
                public C02221() {
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
                    StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchFailed(StoreChannelFollowerStats.this, anonymousClass1.$channelId);
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
                StoreChannelFollowerStats.access$getDispatcher$p(StoreChannelFollowerStats.this).schedule(new C02221());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2 = StoreChannelFollowerStats.access$isExisting(StoreChannelFollowerStats.this, this.$channelId) && !StoreChannelFollowerStats.access$isStale(StoreChannelFollowerStats.this, this.$channelId);
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsState$p(StoreChannelFollowerStats.this).get(Long.valueOf(this.$channelId));
            boolean z3 = (channelFollowerStatData != null ? channelFollowerStatData.getFetchState() : null) == FetchState.FETCHING;
            if (z2 || z3) {
                return;
            }
            StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchStart(StoreChannelFollowerStats.this, this.$channelId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelFollowerStats(this.$channelId), false, 1, null), StoreChannelFollowerStats.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C02201(), 54, (Object) null);
        }
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    /* renamed from: com.discord.stores.StoreChannelFollowerStats$observeChannelFollowerStats$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<ModelChannelFollowerStats> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelChannelFollowerStats invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelChannelFollowerStats invoke() {
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats.this).get(Long.valueOf(this.$channelId));
            if (channelFollowerStatData != null) {
                return channelFollowerStatData.getData();
            }
            return null;
        }
    }

    public StoreChannelFollowerStats(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.channelFollowerStatsState = new HashMap();
        this.channelFollowerStatsStateSnapshot = new HashMap();
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsState$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsState;
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsStateSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.dispatcher;
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchFailed(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchStart(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchStart(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchSuccess(StoreChannelFollowerStats storeChannelFollowerStats, long j, ModelChannelFollowerStats modelChannelFollowerStats) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchSuccess(j, modelChannelFollowerStats);
    }

    public static final /* synthetic */ boolean access$isExisting(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isExisting(j);
    }

    public static final /* synthetic */ boolean access$isStale(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isStale(j);
    }

    public static final /* synthetic */ void access$setChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats, Map map) {
        storeChannelFollowerStats.channelFollowerStatsStateSnapshot = map;
    }

    @StoreThread
    private final void fetchIfNonexistingOrStale(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchFailed(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FAILED, null, 2, null));
        markChanged();
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchStart(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FETCHING, null, 2, null));
        markChanged();
    }

    @StoreThread
    private final void handleChannelFollowerStatsFetchSuccess(long channelId, ModelChannelFollowerStats channelFollowerStats) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.SUCCEEDED, channelFollowerStats));
        markChanged();
    }

    @StoreThread
    private final boolean isExisting(long channelId) {
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return (channelFollowerStatData == null || channelFollowerStatData.getFetchState() == FetchState.FAILED) ? false : true;
    }

    @StoreThread
    private final boolean isStale(long channelId) {
        ModelChannelFollowerStats data;
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return ((channelFollowerStatData == null || (data = channelFollowerStatData.getData()) == null) ? 0L : data.getLastFetched() + ((long) 3600000)) <= ClockFactory.get().currentTimeMillis();
    }

    public final void fetchChannelFollowerStats(long channelId) {
        fetchIfNonexistingOrStale(channelId);
    }

    public final Observable<ModelChannelFollowerStats> observeChannelFollowerStats(long channelId) {
        Observable<ModelChannelFollowerStats> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.channelFollowerStatsStateSnapshot = new HashMap(this.channelFollowerStatsState);
    }
}
