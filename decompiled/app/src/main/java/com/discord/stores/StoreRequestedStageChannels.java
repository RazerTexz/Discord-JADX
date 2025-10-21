package com.discord.stores;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Result3;
import d0.t.Maps6;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* compiled from: StoreRequestedStageChannels.kt */
/* loaded from: classes2.dex */
public final class StoreRequestedStageChannels extends StoreV2 {
    private static final long ENQUEUE_DEBOUNCE_DELAY_MS = 22;
    private final Dispatcher dispatcher;
    private Job enqueuedChannelFetchJob;
    private Set<Long> enqueuedChannelFetches;
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstanceState> requestedStageChannels;
    private Map<Long, StageInstanceState> requestedStageChannelsSnapshot;
    private final RestAPI restAPI;

    /* compiled from: StoreRequestedStageChannels.kt */
    public enum FetchStatus {
        ERROR,
        LOADING,
        LOADED
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    public static final /* data */ class StageInstanceState {
        private final RecommendedStageInstance stageInstance;
        private final FetchStatus status;

        public StageInstanceState(RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus) {
            Intrinsics3.checkNotNullParameter(fetchStatus, "status");
            this.stageInstance = recommendedStageInstance;
            this.status = fetchStatus;
        }

        public static /* synthetic */ StageInstanceState copy$default(StageInstanceState stageInstanceState, RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                recommendedStageInstance = stageInstanceState.stageInstance;
            }
            if ((i & 2) != 0) {
                fetchStatus = stageInstanceState.status;
            }
            return stageInstanceState.copy(recommendedStageInstance, fetchStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        /* renamed from: component2, reason: from getter */
        public final FetchStatus getStatus() {
            return this.status;
        }

        public final StageInstanceState copy(RecommendedStageInstance stageInstance, FetchStatus status) {
            Intrinsics3.checkNotNullParameter(status, "status");
            return new StageInstanceState(stageInstance, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StageInstanceState)) {
                return false;
            }
            StageInstanceState stageInstanceState = (StageInstanceState) other;
            return Intrinsics3.areEqual(this.stageInstance, stageInstanceState.stageInstance) && Intrinsics3.areEqual(this.status, stageInstanceState.status);
        }

        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final FetchStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            RecommendedStageInstance recommendedStageInstance = this.stageInstance;
            int iHashCode = (recommendedStageInstance != null ? recommendedStageInstance.hashCode() : 0) * 31;
            FetchStatus fetchStatus = this.status;
            return iHashCode + (fetchStatus != null ? fetchStatus.hashCode() : 0);
        }

        public final boolean isError() {
            return this.status == FetchStatus.ERROR;
        }

        public final boolean isLoaded() {
            return this.status == FetchStatus.LOADED;
        }

        public final boolean isLoading() {
            return this.status == FetchStatus.LOADING;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StageInstanceState(stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(", status=");
            sbU.append(this.status);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @DebugMetadata(c = "com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1", f = "StoreRequestedStageChannels.kt", l = {60}, m = "invokeSuspend")
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreRequestedStageChannels.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (f.P(StoreRequestedStageChannels.ENQUEUE_DEBOUNCE_DELAY_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            Set<Long> setAccess$getEnqueuedChannelFetches$p = StoreRequestedStageChannels.access$getEnqueuedChannelFetches$p(StoreRequestedStageChannels.this);
            StoreRequestedStageChannels.access$setEnqueuedChannelFetches$p(StoreRequestedStageChannels.this, new LinkedHashSet());
            StoreRequestedStageChannels.this.fetchStageChannels(setAccess$getEnqueuedChannelFetches$p);
            return Unit.a;
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Set $channelIds;

        /* compiled from: StoreRequestedStageChannels.kt */
        /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01661 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* compiled from: StoreRequestedStageChannels.kt */
            /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01671 extends Lambda implements Function0<Unit> {
                public C01671() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C01661 c01661 = C01661.this;
                    StoreRequestedStageChannels.access$updateStatus(StoreRequestedStageChannels.this, c01661.$channelIdsToRequest, FetchStatus.ERROR);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01661(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreRequestedStageChannels.access$getDispatcher$p(StoreRequestedStageChannels.this).schedule(new C01671());
            }
        }

        /* compiled from: StoreRequestedStageChannels.kt */
        /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends RecommendedStageInstance>, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* compiled from: StoreRequestedStageChannels.kt */
            /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01681 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $stageInstances;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01681(List list) {
                    super(0);
                    this.$stageInstances = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreRequestedStageChannels.access$onLoaded(StoreRequestedStageChannels.this, anonymousClass2.$channelIdsToRequest, this.$stageInstances);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RecommendedStageInstance> list) {
                invoke2((List<RecommendedStageInstance>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RecommendedStageInstance> list) {
                Intrinsics3.checkNotNullParameter(list, "stageInstances");
                StoreRequestedStageChannels.access$getDispatcher$p(StoreRequestedStageChannels.this).schedule(new C01681(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set set) {
            super(0);
            this.$channelIds = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set set = this.$channelIds;
            ArrayList arrayList = new ArrayList();
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Set<Long> set2 = _Collections.toSet(arrayList);
                    StoreRequestedStageChannels.access$updateStatus(StoreRequestedStageChannels.this, set2, FetchStatus.LOADING);
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreRequestedStageChannels.access$getRestAPI$p(StoreRequestedStageChannels.this).getStageInstancesForChannels(set2), false, 1, null), StoreRequestedStageChannels.this.getClass(), (Context) null, (Function1) null, new C01661(set2), (Function0) null, (Function0) null, new AnonymousClass2(set2), 54, (Object) null);
                    return;
                } else {
                    Object next = it.next();
                    StageInstanceState stageInstanceState = (StageInstanceState) StoreRequestedStageChannels.access$getRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels.this).get(Long.valueOf(((Number) next).longValue()));
                    if (stageInstanceState == null || !stageInstanceState.isLoading()) {
                        arrayList.add(next);
                    }
                }
            }
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$observeRequestedStageChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends StageInstanceState>, StageInstanceState> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ StageInstanceState call(Map<Long, ? extends StageInstanceState> map) {
            return call2((Map<Long, StageInstanceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StageInstanceState call2(Map<Long, StageInstanceState> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$observeRequestedStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageInstanceState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageInstanceState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageInstanceState> invoke2() {
            return StoreRequestedStageChannels.this.getRequestedInstanceStatesByChannel();
        }
    }

    public /* synthetic */ StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.dispatcher;
    }

    public static final /* synthetic */ Set access$getEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.enqueuedChannelFetches;
    }

    public static final /* synthetic */ Map access$getRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.requestedStageChannelsSnapshot;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.restAPI;
    }

    public static final /* synthetic */ void access$onLoaded(StoreRequestedStageChannels storeRequestedStageChannels, Set set, List list) {
        storeRequestedStageChannels.onLoaded(set, list);
    }

    public static final /* synthetic */ void access$setEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels, Set set) {
        storeRequestedStageChannels.enqueuedChannelFetches = set;
    }

    public static final /* synthetic */ void access$setRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels, Map map) {
        storeRequestedStageChannels.requestedStageChannelsSnapshot = map;
    }

    public static final /* synthetic */ void access$updateStatus(StoreRequestedStageChannels storeRequestedStageChannels, Set set, FetchStatus fetchStatus) {
        storeRequestedStageChannels.updateStatus(set, fetchStatus);
    }

    @Store3
    private final void onLoaded(Set<Long> channelIds, List<RecommendedStageInstance> stageInstances) {
        Set mutableSet = _Collections.toMutableSet(channelIds);
        for (RecommendedStageInstance recommendedStageInstance : stageInstances) {
            this.requestedStageChannels.put(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()), new StageInstanceState(recommendedStageInstance, FetchStatus.LOADED));
            mutableSet.remove(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()));
        }
        Iterator it = mutableSet.iterator();
        while (it.hasNext()) {
            this.requestedStageChannels.put(Long.valueOf(((Number) it.next()).longValue()), new StageInstanceState(null, FetchStatus.LOADED));
        }
        markChanged();
    }

    @Store3
    private final void updateStatus(Set<Long> channelIds, FetchStatus status) {
        Iterator<T> it = channelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            StageInstanceState stageInstanceState = this.requestedStageChannels.get(Long.valueOf(jLongValue));
            this.requestedStageChannels.put(Long.valueOf(jLongValue), new StageInstanceState(stageInstanceState != null ? stageInstanceState.getStageInstance() : null, status));
        }
        markChanged();
    }

    @MainThread
    public final void enqueueStageChannelFetch(long channelId) {
        StageInstanceState stageInstanceState = this.requestedStageChannelsSnapshot.get(Long.valueOf(channelId));
        if (stageInstanceState == null || stageInstanceState.isError()) {
            this.enqueuedChannelFetches.add(Long.valueOf(channelId));
            Job job = this.enqueuedChannelFetchJob;
            if (job == null || !job.a()) {
                CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                this.enqueuedChannelFetchJob = f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(null), 2, null);
            }
        }
    }

    public final void fetchStageChannels(Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        this.dispatcher.schedule(new AnonymousClass1(channelIds));
    }

    public final Map<Long, StageInstanceState> getRequestedInstanceStatesByChannel() {
        return this.requestedStageChannelsSnapshot;
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        RecommendedStageInstance stageInstance;
        StageInstanceState stageInstanceState = getRequestedInstanceStatesByChannel().get(Long.valueOf(channelId));
        if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
            return null;
        }
        return stageInstance.getInstance();
    }

    public final Observable<StageInstanceState> observeRequestedStageChannel(long channelId) {
        Observable observableG = observeRequestedStageChannels().G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeRequestedStageCha…s().map { it[channelId] }");
        return observableG;
    }

    public final Observable<Map<Long, StageInstanceState>> observeRequestedStageChannels() {
        Observable<Map<Long, StageInstanceState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.requestedStageChannelsSnapshot = Maps6.toMap(this.requestedStageChannels);
    }

    public StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.requestedStageChannels = new LinkedHashMap();
        this.requestedStageChannelsSnapshot = Maps6.emptyMap();
        this.enqueuedChannelFetches = new LinkedHashSet();
    }
}
