package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.message.Message;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreSearch;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0879o;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery {
    private static final SearchState SEARCH_STATE_NONE = new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null);
    private SearchState currentSearchState;
    private Subscription querySubscription;
    private final SearchFetcher searchFetcher;
    private final SerializedSubject<SearchState, SearchState> searchStateSubject;

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$1 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63931 extends Lambda implements Function1<ModelSearchResponse, Unit> {
        public final /* synthetic */ boolean $isInitialLoad;
        public final /* synthetic */ SearchQuery $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63931(SearchQuery searchQuery, boolean z2) {
            super(1);
            this.$query = searchQuery;
            this.$isInitialLoad = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSearchResponse modelSearchResponse) {
            invoke2(modelSearchResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSearchResponse modelSearchResponse) {
            Intrinsics3.checkNotNullParameter(modelSearchResponse, "searchResponse");
            StoreSearchQuery.access$handleResponse(StoreSearchQuery.this, this.$query, modelSearchResponse, this.$isInitialLoad);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$2 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63942 extends Lambda implements Function1<Subscription, Unit> {
        public C63942() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreSearchQuery.access$setQuerySubscription$p(StoreSearchQuery.this, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$makeQuery$3 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63953 extends Lambda implements Function1<Error, Unit> {
        public C63953() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreSearchQuery.access$handleError(StoreSearchQuery.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$1 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63961<T, R> implements Func1<String, List<QueryNode>> {
        public final /* synthetic */ SearchStringProvider $searchStringProvider;

        public C63961(SearchStringProvider searchStringProvider) {
            this.$searchStringProvider = searchStringProvider;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
            return call2(str);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<QueryNode> call2(String str) {
            QueryParser queryParser = new QueryParser(this.$searchStringProvider);
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            return Parser.parse$default(queryParser, str, null, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$2 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63972<T1, T2, R> implements Func2<List<QueryNode>, SearchData, SearchQuery> {
        public final /* synthetic */ boolean $includeNsfw;
        public final /* synthetic */ StoreSearch $searchStore;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public C63972(StoreSearch storeSearch, StoreSearch.SearchTarget searchTarget, boolean z2) {
            this.$searchStore = storeSearch;
            this.$searchTarget = searchTarget;
            this.$includeNsfw = z2;
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ SearchQuery call(List<QueryNode> list, SearchData searchData) {
            return call2(list, searchData);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final SearchQuery call2(List<QueryNode> list, SearchData searchData) {
            QueryNode.Companion companion = QueryNode.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(list, "queryNodes");
            Intrinsics3.checkNotNullExpressionValue(searchData, "searchData");
            companion.preprocess(list, searchData);
            this.$searchStore.persistQuery$app_productionGoogleRelease(this.$searchTarget, list);
            return new SearchQuery.Builder().setIncludeNsfw(this.$includeNsfw).buildFrom(list, searchData);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$3 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63983 extends Lambda implements Function1<SearchQuery, Boolean> {
        public static final C63983 INSTANCE = new C63983();

        public C63983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(SearchQuery searchQuery) {
            return Boolean.valueOf(invoke2(searchQuery));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(SearchQuery searchQuery) {
            return searchQuery != null && searchQuery.isValid();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$4 */
    /* JADX INFO: compiled from: StoreSearchQuery.kt */
    public static final class C63994 extends Lambda implements Function1<SearchQuery, Unit> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63994(StoreSearch.SearchTarget searchTarget) {
            super(1);
            this.$searchTarget = searchTarget;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchQuery searchQuery) {
            invoke2(searchQuery);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchQuery searchQuery) {
            if (searchQuery == null) {
                StoreSearchQuery.access$handleError(StoreSearchQuery.this);
            } else {
                StoreSearchQuery.access$performInitialLoad(StoreSearchQuery.this, this.$searchTarget, searchQuery);
            }
        }
    }

    public StoreSearchQuery(SearchFetcher searchFetcher) {
        Intrinsics3.checkNotNullParameter(searchFetcher, "searchFetcher");
        this.searchFetcher = searchFetcher;
        SearchState searchState = SEARCH_STATE_NONE;
        this.searchStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(searchState));
        this.currentSearchState = searchState;
    }

    public static final /* synthetic */ Subscription access$getQuerySubscription$p(StoreSearchQuery storeSearchQuery) {
        return storeSearchQuery.querySubscription;
    }

    public static final /* synthetic */ void access$handleError(StoreSearchQuery storeSearchQuery) {
        storeSearchQuery.handleError();
    }

    public static final /* synthetic */ void access$handleResponse(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, ModelSearchResponse modelSearchResponse, boolean z2) {
        storeSearchQuery.handleResponse(searchQuery, modelSearchResponse, z2);
    }

    public static final /* synthetic */ void access$performInitialLoad(StoreSearchQuery storeSearchQuery, StoreSearch.SearchTarget searchTarget, SearchQuery searchQuery) {
        storeSearchQuery.performInitialLoad(searchTarget, searchQuery);
    }

    public static final /* synthetic */ void access$setQuerySubscription$p(StoreSearchQuery storeSearchQuery, Subscription subscription) {
        storeSearchQuery.querySubscription = subscription;
    }

    private final void handleError() {
        updateAndPublish(new SearchState(QueryFetchState.FAILED, null, null, null, null, false, 0, 126, null));
    }

    private final synchronized void handleResponse(SearchQuery searchQuery, ModelSearchResponse response, boolean isInitialLoad) {
        SearchState searchState;
        int totalResults;
        List arrayList;
        Integer errorCode = response.getErrorCode();
        if (errorCode == null) {
            if (isInitialLoad) {
                totalResults = response.getTotalResults();
                arrayList = new ArrayList();
            } else {
                totalResults = this.currentSearchState.getTotalResults();
                List<Message> hits = this.currentSearchState.getHits();
                if (hits == null || (arrayList = _Collections.toMutableList((Collection) hits)) == null) {
                    arrayList = new ArrayList();
                }
            }
            int i = totalResults;
            List list = arrayList;
            List<com.discord.api.message.Message> hits2 = response.getHits();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(hits2, 10));
            Iterator<T> it = hits2.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Message((com.discord.api.message.Message) it.next()));
            }
            list.addAll(arrayList2);
            searchState = new SearchState(QueryFetchState.COMPLETED, searchQuery, response.getThreads(), response.getMembers(), list, i > list.size(), i);
        } else {
            searchState = errorCode.intValue() == 111000 ? new SearchState(QueryFetchState.INDEXING, searchQuery, null, null, null, false, 0, 124, null) : new SearchState(QueryFetchState.FAILED, searchQuery, null, null, null, false, 0, 124, null);
        }
        updateAndPublish(searchState);
    }

    private final void makeQuery(SearchQuery query, StoreSearch.SearchTarget searchTarget, Long oldestMessageId, boolean isInitialLoad) {
        ObservableExtensionsKt.appSubscribe$default(this.searchFetcher.makeQuery(searchTarget, oldestMessageId, query), (Context) null, "makeQuery", new C63942(), new C63931(query, isInitialLoad), new C63953(), (Function0) null, (Function0) null, 97, (Object) null);
    }

    public static /* synthetic */ void makeQuery$default(StoreSearchQuery storeSearchQuery, SearchQuery searchQuery, StoreSearch.SearchTarget searchTarget, Long l, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        storeSearchQuery.makeQuery(searchQuery, searchTarget, l, z2);
    }

    private final void performInitialLoad(StoreSearch.SearchTarget searchTarget, SearchQuery query) {
        unsubscribe();
        makeQuery$default(this, query, searchTarget, null, false, 12, null);
    }

    private final synchronized void unsubscribe() {
        Subscription subscription = this.querySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    private final synchronized void updateAndPublish(SearchState searchState) {
        this.currentSearchState = searchState;
        this.searchStateSubject.f27653k.onNext(searchState);
    }

    public final void clear() {
        unsubscribe();
        updateAndPublish(SEARCH_STATE_NONE);
    }

    public final Observable<SearchState> getState() {
        Observable<SearchState> observableM11112r = this.searchStateSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "searchStateSubject\n        .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized void loadMore(StoreSearch.SearchTarget searchTarget, long oldestMessageId) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        SearchQuery searchQuery = this.currentSearchState.getSearchQuery();
        if (searchQuery != null) {
            if (this.currentSearchState.getQueryFetchState() != QueryFetchState.COMPLETED) {
                return;
            }
            if (this.currentSearchState.getHasMore()) {
                unsubscribe();
                updateAndPublish(new SearchState(QueryFetchState.LOADING_MORE, searchQuery, this.currentSearchState.getThreads(), this.currentSearchState.getThreadMembers(), this.currentSearchState.getHits(), false, this.currentSearchState.getTotalResults()));
                makeQuery(searchQuery, searchTarget, Long.valueOf(oldestMessageId), false);
            }
        }
    }

    public final void parseAndQuery(StoreSearch searchStore, StoreSearch.SearchTarget searchTarget, String queryString, SearchStringProvider searchStringProvider, boolean includeNsfw) {
        Intrinsics3.checkNotNullParameter(searchStore, "searchStore");
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        unsubscribe();
        if (!(!StringsJVM.isBlank(queryString))) {
            updateAndPublish(new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null));
            return;
        }
        updateAndPublish(new SearchState(QueryFetchState.IN_PROGRESS, null, null, null, null, false, 0, 126, null));
        Observable observableM11100Z = Observable.m11077j0(new ScalarSynchronousObservable(queryString).m11083G(new C63961(searchStringProvider)), searchStore.getStoreSearchData().get(), new C63972(searchStore, searchTarget, includeNsfw)).m11108k(C0879o.m177c(C63983.INSTANCE, null, 1L, TimeUnit.SECONDS)).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "Observable\n            .…   )\n            .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableM11100Z), (Context) null, "parseAndQuery", (Function1) null, new C63994(searchTarget), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
