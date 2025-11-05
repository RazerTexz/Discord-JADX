package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreRtcRegion.kt */
/* loaded from: classes2.dex */
public final class StoreRtcRegion {
    private static final int LATENCY_TEST_CACHE_TTL_MS = 86400000;
    private static final int MAX_LATENCY_TEST_CONN_OPEN_JITTER_MS = 30000;
    private static final int MIN_LATENCY_TEST_CONN_OPEN_JITTER_MS = 1000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private RtcLatencyTestResult lastTestResult;
    private final Persister<RtcLatencyTestResult> lastTestResultCache;
    private final RestAPI restAPI;
    private final StoreExperiments storeExperiments;
    private final StoreMediaEngine storeMediaEngine;

    /* compiled from: StoreRtcRegion.kt */
    /* renamed from: com.discord.stores.StoreRtcRegion$fetchRtcLatencyTestRegionsIps$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends ModelRtcLatencyRegion>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelRtcLatencyRegion> list) {
            invoke2((List<ModelRtcLatencyRegion>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelRtcLatencyRegion> list) {
            m.checkNotNullParameter(list, "it");
            StoreRtcRegion.access$maybePerformLatencyTest(StoreRtcRegion.this, list);
        }
    }

    /* compiled from: StoreRtcRegion.kt */
    /* renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $regionsWithIps;

        /* compiled from: StoreRtcRegion.kt */
        /* renamed from: com.discord.stores.StoreRtcRegion$maybePerformLatencyTest$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02901 extends o implements Function1<List<? extends String>, Unit> {
            public final /* synthetic */ List $newGeoRankedRegions;
            public final /* synthetic */ long $timeNowMs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02901(List list, long j) {
                super(1);
                this.$newGeoRankedRegions = list;
                this.$timeNowMs = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                m.checkNotNullParameter(list, "latencyRankedRegions");
                AppLog.i("RTC region latency test ranking is " + list);
                StoreRtcRegion.access$updateLastTestResult(StoreRtcRegion.this, new RtcLatencyTestResult(list, this.$newGeoRankedRegions, this.$timeNowMs));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$regionsWithIps = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$regionsWithIps;
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ModelRtcLatencyRegion) it.next()).getRegion());
            }
            long jCurrentTimeMillis = StoreRtcRegion.access$getClock$p(StoreRtcRegion.this).currentTimeMillis();
            if (StoreRtcRegion.access$shouldPerformLatencyTest(StoreRtcRegion.this, arrayList, jCurrentTimeMillis)) {
                StoreRtcRegion.access$getStoreMediaEngine$p(StoreRtcRegion.this).getRankedRtcRegions(this.$regionsWithIps, new C02901(arrayList, jCurrentTimeMillis));
                return;
            }
            StringBuilder sbU = a.U("RTC region latency test cached preferred region is ");
            sbU.append(StoreRtcRegion.this.getPreferredRegion());
            AppLog.i(sbU.toString());
        }
    }

    public StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeMediaEngine = storeMediaEngine;
        this.storeExperiments = storeExperiments;
        this.restAPI = restAPI;
        this.lastTestResultCache = new Persister<>("CACHE_KEY_LATENCY_TEST_RESULT", new RtcLatencyTestResult(null, null, 0L, 7, null));
        this.lastTestResult = new RtcLatencyTestResult(null, null, 0L, 7, null);
    }

    public static final /* synthetic */ void access$fetchRtcLatencyTestRegionsIps(StoreRtcRegion storeRtcRegion) {
        storeRtcRegion.fetchRtcLatencyTestRegionsIps();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreRtcRegion storeRtcRegion) {
        return storeRtcRegion.clock;
    }

    public static final /* synthetic */ StoreMediaEngine access$getStoreMediaEngine$p(StoreRtcRegion storeRtcRegion) {
        return storeRtcRegion.storeMediaEngine;
    }

    public static final /* synthetic */ void access$maybePerformLatencyTest(StoreRtcRegion storeRtcRegion, List list) {
        storeRtcRegion.maybePerformLatencyTest(list);
    }

    public static final /* synthetic */ boolean access$shouldPerformLatencyTest(StoreRtcRegion storeRtcRegion, List list, long j) {
        return storeRtcRegion.shouldPerformLatencyTest(list, j);
    }

    public static final /* synthetic */ void access$updateLastTestResult(StoreRtcRegion storeRtcRegion, RtcLatencyTestResult rtcLatencyTestResult) {
        storeRtcRegion.updateLastTestResult(rtcLatencyTestResult);
    }

    private final boolean areStringListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        Iterator<T> it = list1.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!m.areEqual(list2.get(i), (String) it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    private final void fetchRtcLatencyTestRegionsIps() {
        if (this.storeMediaEngine.hasNativeEngineEverInitialized()) {
            ObservableExtensionsKt.appSubscribe$default(this.restAPI.getRtcLatencyTestRegionsIps(), StoreRtcRegion.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    private final void maybePerformLatencyTest(List<ModelRtcLatencyRegion> regionsWithIps) {
        this.dispatcher.schedule(new AnonymousClass1(regionsWithIps));
    }

    private final boolean shouldPerformLatencyTest(List<String> newGeoRankedRegions, long timeNowMs) {
        return this.lastTestResult.getLatencyRankedRegions().isEmpty() || !areStringListsEqual(newGeoRankedRegions, this.lastTestResult.getGeoRankedRegions()) || timeNowMs - this.lastTestResult.getLastTestTimestampMs() >= ((long) LATENCY_TEST_CACHE_TTL_MS);
    }

    private final void updateLastTestResult(RtcLatencyTestResult lastTestResult) {
        this.lastTestResult = lastTestResult;
        this.lastTestResultCache.set(lastTestResult, true);
    }

    @StoreThread
    public final String getPreferredRegion() {
        if (!this.lastTestResult.getLatencyRankedRegions().isEmpty()) {
            return this.lastTestResult.getLatencyRankedRegions().get(0);
        }
        return null;
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease() {
        Observable<Long> observableD0 = Observable.d0(new Random().nextInt(29000) + 1000, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable.timer(fetchJi…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, StoreRtcRegion.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcRegion$handleConnectionOpen$1(this), 62, (Object) null);
    }

    public final void init() {
        this.lastTestResult = this.lastTestResultCache.get();
    }

    @StoreThread
    public final boolean shouldIncludePreferredRegion(Long guildId) {
        return getPreferredRegion() != null;
    }

    public /* synthetic */ StoreRtcRegion(Dispatcher dispatcher, Clock clock, StoreMediaEngine storeMediaEngine, StoreExperiments storeExperiments, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeMediaEngine, storeExperiments, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }
}
