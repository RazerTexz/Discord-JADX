package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.stores.StoreSearch;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeDefer;
import p637j0.p642l.p643a.OnSubscribeRedo6;
import p637j0.p642l.p645c.TrampolineScheduler;
import p637j0.p642l.p647e.InternalObservableUtils;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* compiled from: SearchFetcher.kt */
/* loaded from: classes2.dex */
public class SearchFetcher {
    private AtomicInteger indexingRetryCount = new AtomicInteger(0);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[StoreSearch.SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$1 */
    public static final class C69041 extends Lambda implements Function1<AtomicInteger, Integer> {
        public static final C69041 INSTANCE = new C69041();

        public C69041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(AtomicInteger atomicInteger) {
            return invoke2(atomicInteger);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Integer invoke2(AtomicInteger atomicInteger) {
            Intrinsics3.checkNotNullParameter(atomicInteger, "$this$getNullIfZero");
            int i = atomicInteger.get();
            if (i != 0) {
                return Integer.valueOf(i);
            }
            return null;
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$2 */
    public static final class C69052<R> implements Func0<Observable<Integer>> {
        public C69052() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Observable<Integer> call() {
            return new ScalarSynchronousObservable(C69041.INSTANCE.invoke2(SearchFetcher.access$getIndexingRetryCount$p(SearchFetcher.this)));
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$getRestObservable$3 */
    public static final class C69063<T, R> implements Func1<Integer, Observable<? extends ModelSearchResponse>> {
        public final /* synthetic */ Long $oldestMessageId;
        public final /* synthetic */ Map $queryParams;
        public final /* synthetic */ SearchQuery $searchQuery;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public C69063(StoreSearch.SearchTarget searchTarget, Long l, Map map, SearchQuery searchQuery) {
            this.$searchTarget = searchTarget;
            this.$oldestMessageId = l;
            this.$queryParams = map;
            this.$searchQuery = searchQuery;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModelSearchResponse> call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelSearchResponse> call2(Integer num) {
            int iOrdinal = this.$searchTarget.getType().ordinal();
            if (iOrdinal == 0) {
                return RestAPI.INSTANCE.getApi().searchGuildMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
            }
            if (iOrdinal == 1) {
                return RestAPI.INSTANCE.getApi().searchChannelMessages(this.$searchTarget.getId(), this.$oldestMessageId, (List) this.$queryParams.get("author_id"), (List) this.$queryParams.get("mentions"), (List) this.$queryParams.get("has"), (List) this.$queryParams.get("content"), num, Boolean.valueOf(this.$searchQuery.getIncludeNsfw()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$1 */
    public static final class C69071<T> implements Action1<ModelSearchResponse> {
        public final /* synthetic */ AtomicLong $resubscribeDelayMillis;

        public C69071(AtomicLong atomicLong) {
            this.$resubscribeDelayMillis = atomicLong;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelSearchResponse modelSearchResponse) {
            call2(modelSearchResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelSearchResponse modelSearchResponse) {
            SearchFetcher searchFetcher = SearchFetcher.this;
            Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "searchResponse");
            if (SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse)) {
                this.$resubscribeDelayMillis.set(modelSearchResponse.getRetryMillis());
                SearchFetcher.access$getIndexingRetryCount$p(SearchFetcher.this).incrementAndGet();
            }
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$2 */
    public static final class C69082<T, R> implements Func1<Observable<? extends Void>, Observable<?>> {
        public final /* synthetic */ AtomicLong $resubscribeDelayMillis;

        /* compiled from: SearchFetcher.kt */
        /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Void, Observable<? extends Long>> {
            public AnonymousClass1() {
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Long> call(Void r1) {
                return call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Long> call2(Void r3) {
                return Observable.m11068d0(C69082.this.$resubscribeDelayMillis.get(), TimeUnit.MILLISECONDS);
            }
        }

        public C69082(AtomicLong atomicLong) {
            this.$resubscribeDelayMillis = atomicLong;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Void> observable) {
            return call2(observable);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Void> observable) {
            return observable.m11082A(new AnonymousClass1());
        }
    }

    /* compiled from: SearchFetcher.kt */
    /* renamed from: com.discord.utilities.search.network.SearchFetcher$makeQuery$3 */
    public static final class C69093<T, R> implements Func1<ModelSearchResponse, Boolean> {
        public C69093() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(ModelSearchResponse modelSearchResponse) {
            return call2(modelSearchResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ModelSearchResponse modelSearchResponse) {
            SearchFetcher searchFetcher = SearchFetcher.this;
            Intrinsics3.checkNotNullExpressionValue(modelSearchResponse, "it");
            return Boolean.valueOf(!SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse));
        }
    }

    public static final /* synthetic */ AtomicInteger access$getIndexingRetryCount$p(SearchFetcher searchFetcher) {
        return searchFetcher.indexingRetryCount;
    }

    public static final /* synthetic */ boolean access$isIndexing(SearchFetcher searchFetcher, ModelSearchResponse modelSearchResponse) {
        return searchFetcher.isIndexing(modelSearchResponse);
    }

    public static final /* synthetic */ void access$setIndexingRetryCount$p(SearchFetcher searchFetcher, AtomicInteger atomicInteger) {
        searchFetcher.indexingRetryCount = atomicInteger;
    }

    private final Observable<ModelSearchResponse> getRestObservable(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        C69041 c69041 = C69041.INSTANCE;
        Observable observableM11082A = Observable.m11074h0(new OnSubscribeDefer(new C69052())).m11082A(new C69063(searchTarget, oldestMessageId, searchQuery.getParams(), searchQuery));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "Observable\n        .defe…  )\n          }\n        }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM11082A, false, 1, null);
    }

    private final boolean isIndexing(ModelSearchResponse modelSearchResponse) {
        Integer errorCode = modelSearchResponse.getErrorCode();
        return errorCode != null && errorCode.intValue() == 111000;
    }

    public Observable<ModelSearchResponse> makeQuery(StoreSearch.SearchTarget searchTarget, Long oldestMessageId, SearchQuery searchQuery) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        AtomicLong atomicLong = new AtomicLong();
        Observable<ModelSearchResponse> observableM11115u = getRestObservable(searchTarget, oldestMessageId, searchQuery).m11115u(new C69071(atomicLong));
        InternalObservableUtils.c cVar = new InternalObservableUtils.c(new C69082(atomicLong));
        AtomicReference<Schedulers2> atomicReference = Schedulers2.f27393a;
        Observable<ModelSearchResponse> observableM11103b0 = Observable.m11074h0(new OnSubscribeRedo6(observableM11115u, cVar, false, true, TrampolineScheduler.f27250a)).m11103b0(new C69093());
        Intrinsics3.checkNotNullExpressionValue(observableM11103b0, "getRestObservable(search…ntil { !it.isIndexing() }");
        return observableM11103b0;
    }
}
