package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.message.Message;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreSearch;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreSearchQuery.kt */
/* loaded from: classes2.dex */
public final class StoreSearchQuery {
    private static final SearchState SEARCH_STATE_NONE = new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null);
    private SearchState currentSearchState;
    private Subscription querySubscription;
    private final SearchFetcher searchFetcher;
    private final SerializedSubject<SearchState, SearchState> searchStateSubject;

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelSearchResponse, Unit> {
        public final /* synthetic */ boolean $isInitialLoad;
        public final /* synthetic */ SearchQuery $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SearchQuery searchQuery, boolean z2) {
            super(1);
            this.$query = searchQuery;
            this.$isInitialLoad = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSearchResponse modelSearchResponse) {
            invoke2(modelSearchResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSearchResponse modelSearchResponse) {
            m.checkNotNullParameter(modelSearchResponse, "searchResponse");
            StoreSearchQuery.access$handleResponse(StoreSearchQuery.this, this.$query, modelSearchResponse, this.$isInitialLoad);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreSearchQuery.access$setQuerySubscription$p(StoreSearchQuery.this, subscription);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$makeQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            StoreSearchQuery.access$handleError(StoreSearchQuery.this);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<String, List<QueryNode>> {
        public final /* synthetic */ SearchStringProvider $searchStringProvider;

        public AnonymousClass1(SearchStringProvider searchStringProvider) {
            this.$searchStringProvider = searchStringProvider;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<QueryNode> call2(String str) {
            QueryParser queryParser = new QueryParser(this.$searchStringProvider);
            m.checkNotNullExpressionValue(str, "it");
            return Parser.parse$default(queryParser, str, null, null, 4, null);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<QueryNode>, SearchData, SearchQuery> {
        public final /* synthetic */ boolean $includeNsfw;
        public final /* synthetic */ StoreSearch $searchStore;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass2(StoreSearch storeSearch, StoreSearch.SearchTarget searchTarget, boolean z2) {
            this.$searchStore = storeSearch;
            this.$searchTarget = searchTarget;
            this.$includeNsfw = z2;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ SearchQuery call(List<QueryNode> list, SearchData searchData) {
            return call2(list, searchData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SearchQuery call2(List<QueryNode> list, SearchData searchData) {
            QueryNode.Companion companion = QueryNode.INSTANCE;
            m.checkNotNullExpressionValue(list, "queryNodes");
            m.checkNotNullExpressionValue(searchData, "searchData");
            companion.preprocess(list, searchData);
            this.$searchStore.persistQuery$app_productionGoogleRelease(this.$searchTarget, list);
            return new SearchQuery.Builder().setIncludeNsfw(this.$includeNsfw).buildFrom(list, searchData);
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<SearchQuery, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(SearchQuery searchQuery) {
            return Boolean.valueOf(invoke2(searchQuery));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(SearchQuery searchQuery) {
            return searchQuery != null && searchQuery.isValid();
        }
    }

    /* compiled from: StoreSearchQuery.kt */
    /* renamed from: com.discord.stores.StoreSearchQuery$parseAndQuery$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<SearchQuery, Unit> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(StoreSearch.SearchTarget searchTarget) {
            super(1);
            this.$searchTarget = searchTarget;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchQuery searchQuery) {
            invoke2(searchQuery);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchQuery searchQuery) {
            if (searchQuery == null) {
                StoreSearchQuery.access$handleError(StoreSearchQuery.this);
            } else {
                StoreSearchQuery.access$performInitialLoad(StoreSearchQuery.this, this.$searchTarget, searchQuery);
            }
        }
    }

    public StoreSearchQuery(SearchFetcher searchFetcher) {
        m.checkNotNullParameter(searchFetcher, "searchFetcher");
        this.searchFetcher = searchFetcher;
        SearchState searchState = SEARCH_STATE_NONE;
        this.searchStateSubject = new SerializedSubject<>(BehaviorSubject.l0(searchState));
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
                if (hits == null || (arrayList = u.toMutableList((Collection) hits)) == null) {
                    arrayList = new ArrayList();
                }
            }
            int i = totalResults;
            List list = arrayList;
            List<com.discord.api.message.Message> hits2 = response.getHits();
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(hits2, 10));
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
        ObservableExtensionsKt.appSubscribe$default(this.searchFetcher.makeQuery(searchTarget, oldestMessageId, query), (Context) null, "makeQuery", new AnonymousClass2(), new AnonymousClass1(query, isInitialLoad), new AnonymousClass3(), (Function0) null, (Function0) null, 97, (Object) null);
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
        this.searchStateSubject.k.onNext(searchState);
    }

    public final void clear() {
        unsubscribe();
        updateAndPublish(SEARCH_STATE_NONE);
    }

    public final Observable<SearchState> getState() {
        Observable<SearchState> observableR = this.searchStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "searchStateSubject\n        .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void loadMore(StoreSearch.SearchTarget searchTarget, long oldestMessageId) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
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
        m.checkNotNullParameter(searchStore, "searchStore");
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(queryString, "queryString");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        unsubscribe();
        if (!(!t.isBlank(queryString))) {
            updateAndPublish(new SearchState(QueryFetchState.NONE, null, null, null, null, false, 0, 126, null));
            return;
        }
        updateAndPublish(new SearchState(QueryFetchState.IN_PROGRESS, null, null, null, null, false, 0, 126, null));
        Observable observableZ = Observable.j0(new k(queryString).G(new AnonymousClass1(searchStringProvider)), searchStore.getStoreSearchData().get(), new AnonymousClass2(searchStore, searchTarget, includeNsfw)).k(b.a.d.o.c(AnonymousClass3.INSTANCE, null, 1L, TimeUnit.SECONDS)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable\n            .…   )\n            .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableZ), (Context) null, "parseAndQuery", (Function1) null, new AnonymousClass4(searchTarget), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
