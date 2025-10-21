package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.history.MGPreferenceSearchHistoryCache;
import com.discord.utilities.search.history.SearchHistoryCache;
import com.discord.utilities.search.network.SearchFetcher;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreSearch.kt */
/* loaded from: classes2.dex */
public final class StoreSearch {
    private final Dispatcher dispatcher;
    private final SerializedSubject<DisplayState, DisplayState> displayStateSubject;
    private final SearchHistoryCache historyCache;
    private SearchTarget searchTarget;
    private final SerializedSubject<SearchTarget, SearchTarget> searchTargetSubject;
    private final StoreGuildsNsfw storeGuildsNsfw;
    private final StoreSearchData storeSearchData;
    private final StoreSearchInput storeSearchInput;
    private final StoreSearchQuery storeSearchQuery;
    private final StoreUser storeUser;
    private final StoreStream stream;
    private Subscription subscription;

    /* compiled from: StoreSearch.kt */
    public enum DisplayState {
        SUGGESTIONS,
        RESULTS
    }

    /* compiled from: StoreSearch.kt */
    public static final /* data */ class SearchTarget {
        private final long id;
        private final Type type;

        /* compiled from: StoreSearch.kt */
        public enum Type {
            GUILD,
            CHANNEL
        }

        public SearchTarget(Type type, long j) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.type = type;
            this.id = j;
        }

        public static /* synthetic */ SearchTarget copy$default(SearchTarget searchTarget, Type type, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                type = searchTarget.type;
            }
            if ((i & 2) != 0) {
                j = searchTarget.id;
            }
            return searchTarget.copy(type, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        public final SearchTarget copy(Type type, long id2) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new SearchTarget(type, id2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchTarget)) {
                return false;
            }
            SearchTarget searchTarget = (SearchTarget) other;
            return Intrinsics3.areEqual(this.type, searchTarget.type) && this.id == searchTarget.id;
        }

        public final long getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            return b.a(this.id) + ((type != null ? type.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SearchTarget(type=");
            sbU.append(this.type);
            sbU.append(", id=");
            return outline.C(sbU, this.id, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$getHistory$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<SearchTarget, Observable<? extends Collection<? extends List<? extends QueryNode>>>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends List<? extends QueryNode>>> call(SearchTarget searchTarget) {
            return call2(searchTarget);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Collection<List<QueryNode>>> call2(SearchTarget searchTarget) {
            return searchTarget != null ? StoreSearch.access$getHistoryCache$p(StoreSearch.this).getHistory(searchTarget) : new ScalarSynchronousObservable(Collections2.emptyList());
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<SearchState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(SearchState searchState) {
            return call2(searchState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(SearchState searchState) {
            return Boolean.valueOf(searchState.getQueryFetchState() != QueryFetchState.NONE);
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<SearchState, DisplayState> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DisplayState call(SearchState searchState) {
            return call2(searchState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DisplayState call2(SearchState searchState) {
            return DisplayState.RESULTS;
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<List<? extends QueryNode>, DisplayState> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DisplayState call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DisplayState call2(List<? extends QueryNode> list) {
            return DisplayState.SUGGESTIONS;
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass4(StoreSearch storeSearch) {
            super(1, storeSearch, StoreSearch.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            StoreSearch.access$handleSubscription((StoreSearch) this.receiver, subscription);
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<DisplayState, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisplayState displayState) {
            invoke2(displayState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisplayState displayState) {
            if (displayState != DisplayState.RESULTS) {
                StoreSearch.this.getStoreSearchQuery().clear();
            }
            StoreSearch storeSearch = StoreSearch.this;
            Intrinsics3.checkNotNullExpressionValue(displayState, "it");
            StoreSearch.access$onStateChanged(storeSearch, displayState);
        }
    }

    /* compiled from: StoreSearch.kt */
    /* renamed from: com.discord.stores.StoreSearch$init$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<SearchState, Unit> {

        /* compiled from: StoreSearch.kt */
        /* renamed from: com.discord.stores.StoreSearch$init$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ SearchState $searchState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SearchState searchState) {
                super(0);
                this.$searchState = searchState;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSearch.access$getStream$p(StoreSearch.this).handleSearchFinish(this.$searchState);
            }
        }

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchState searchState) {
            invoke2(searchState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchState searchState) {
            Intrinsics3.checkNotNullParameter(searchState, "searchState");
            StoreSearch.access$getDispatcher$p(StoreSearch.this).schedule(new AnonymousClass1(searchState));
        }
    }

    public StoreSearch(StoreSearchData storeSearchData, StoreSearchInput storeSearchInput, StoreSearchQuery storeSearchQuery, StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, SearchHistoryCache searchHistoryCache) {
        Intrinsics3.checkNotNullParameter(storeSearchData, "storeSearchData");
        Intrinsics3.checkNotNullParameter(storeSearchInput, "storeSearchInput");
        Intrinsics3.checkNotNullParameter(storeSearchQuery, "storeSearchQuery");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(searchHistoryCache, "historyCache");
        this.storeSearchData = storeSearchData;
        this.storeSearchInput = storeSearchInput;
        this.storeSearchQuery = storeSearchQuery;
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.storeGuildsNsfw = storeGuildsNsfw;
        this.storeUser = storeUser;
        this.historyCache = searchHistoryCache;
        this.displayStateSubject = new SerializedSubject<>(BehaviorSubject.l0(DisplayState.SUGGESTIONS));
        this.searchTargetSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSearch storeSearch) {
        return storeSearch.dispatcher;
    }

    public static final /* synthetic */ SearchHistoryCache access$getHistoryCache$p(StoreSearch storeSearch) {
        return storeSearch.historyCache;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreSearch storeSearch) {
        return storeSearch.stream;
    }

    public static final /* synthetic */ void access$handleSubscription(StoreSearch storeSearch, Subscription subscription) {
        storeSearch.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$onStateChanged(StoreSearch storeSearch, DisplayState displayState) {
        storeSearch.onStateChanged(displayState);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    private final boolean includeNsfw(SearchTarget searchTarget) {
        if (this.storeUser.getMeSnapshot().getNsfwAllowance() == NsfwAllowance.DISALLOWED) {
            return false;
        }
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            return this.storeGuildsNsfw.isGuildNsfwGateAgreed(searchTarget.getId());
        }
        if (iOrdinal == 1) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final synchronized void init(SearchTarget searchTarget, SearchStringProvider searchStringProvider) {
        if (Intrinsics3.areEqual(this.searchTarget, searchTarget)) {
            return;
        }
        updateTarget(searchTarget);
        this.storeSearchData.init(searchTarget);
        this.storeSearchInput.init(searchStringProvider);
        Observable observableI = Observable.I(this.storeSearchQuery.getState().y(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE), this.storeSearchInput.getCurrentParsedInput().G(AnonymousClass3.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .merg…splayState.SUGGESTIONS })");
        ObservableExtensionsKt.appSubscribe$default(observableI, getClass(), (Context) null, new AnonymousClass4(this), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 58, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.storeSearchQuery.getState(), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(), 62, (Object) null);
    }

    private final void onStateChanged(DisplayState displayState) {
        this.displayStateSubject.k.onNext(displayState);
    }

    private final synchronized void updateTarget(SearchTarget searchTarget) {
        this.searchTarget = searchTarget;
        this.searchTargetSubject.k.onNext(searchTarget);
    }

    public final synchronized void clear() {
        updateTarget(null);
        handleSubscription(null);
        onStateChanged(DisplayState.SUGGESTIONS);
        this.storeSearchQuery.clear();
        this.storeSearchInput.clear();
        this.storeSearchData.clear();
    }

    public final void clearHistory() {
        SearchHistoryCache searchHistoryCache = this.historyCache;
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            searchHistoryCache.clear(searchTarget);
        }
    }

    public final Observable<DisplayState> getDisplayState() {
        Observable<DisplayState> observableR = ObservableExtensionsKt.computationLatest(this.displayStateSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "displayStateSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Collection<List<QueryNode>>> getHistory() {
        Observable observableY = this.searchTargetSubject.Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "searchTargetSubject\n    …())\n          }\n        }");
        return observableY;
    }

    public final StoreSearchData getStoreSearchData() {
        return this.storeSearchData;
    }

    public final StoreSearchInput getStoreSearchInput() {
        return this.storeSearchInput;
    }

    public final StoreSearchQuery getStoreSearchQuery() {
        return this.storeSearchQuery;
    }

    public final void initForChannel(long channelId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.CHANNEL, channelId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(null);
    }

    public final void initForGuild(long guildId, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        init(new SearchTarget(SearchTarget.Type.GUILD, guildId), searchStringProvider);
        SearchSuggestionEngine.INSTANCE.setTargetGuildId(Long.valueOf(guildId));
    }

    public final void loadInitial(String queryString, SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.parseAndQuery(this, searchTarget, queryString, searchStringProvider, includeNsfw(searchTarget));
        }
    }

    public final void loadMore(long oldestMessageId) {
        SearchTarget searchTarget = this.searchTarget;
        if (searchTarget != null) {
            this.storeSearchQuery.loadMore(searchTarget, oldestMessageId);
        }
    }

    public final void persistQuery$app_productionGoogleRelease(SearchTarget searchTarget, List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        this.historyCache.persistQuery(searchTarget, query);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreSearch(StoreStream storeStream, Dispatcher dispatcher, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, ObservationDeck observationDeck, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        this(new StoreSearchData(observationDeck, storeChannels, storeUser, storeGuilds), new StoreSearchInput(), new StoreSearchQuery(new SearchFetcher()), storeStream, dispatcher, storeGuildsNsfw, storeUser, new MGPreferenceSearchHistoryCache());
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuildsNsfw, "storeGuildsNsfw");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
    }
}
