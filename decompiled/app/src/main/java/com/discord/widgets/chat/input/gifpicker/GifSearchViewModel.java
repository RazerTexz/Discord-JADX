package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.d0;
import com.discord.R;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.a.r;
import j0.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: GifSearchViewModel.kt */
/* loaded from: classes2.dex */
public final class GifSearchViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* compiled from: GifSearchViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "storeState");
            GifSearchViewModel.access$handleStoreState(GifSearchViewModel.this, storeState);
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeQueryState(Companion companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List list) {
            return companion.observeQueryState(behaviorSubject, storeAnalytics, storeGifPicker, list);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
            return companion.observeStoreState(behaviorSubject, storeAnalytics, storeGifPicker);
        }

        private final Observable<StoreState> observeQueryState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List<String> trendingSearchTerms) {
            Observable<String> observableR = searchSubject.J(a.c()).r();
            Observable<StoreState> observableY = Observable.h0(new r(observableR.j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, a.c()))).u(new GifSearchViewModel$Companion$observeQueryState$1(storeAnalytics)).Y(new GifSearchViewModel$Companion$observeQueryState$2(trendingSearchTerms, storeGifPicker));
            m.checkNotNullExpressionValue(observableY, "searchSubject\n          …          }\n            }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
            Observable observableY = storeGifPicker.observeGifTrendingSearchTerms().Y(new GifSearchViewModel$Companion$observeStoreState$1(searchSubject, storeAnalytics, storeGifPicker));
            m.checkNotNullExpressionValue(observableY, "storeGifPicker.observeGi…fPicker, terms)\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    public static abstract class StoreState {
        private final List<String> trendingSearchTerms;

        /* compiled from: GifSearchViewModel.kt */
        public static final /* data */ class SearchResults extends StoreState {
            private final List<ModelGif> gifs;
            private final String searchQuery;
            private final List<String> suggested;
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResults(List<ModelGif> list, List<String> list2, List<String> list3, String str) {
                super(list3, null);
                m.checkNotNullParameter(list, "gifs");
                m.checkNotNullParameter(list2, "suggested");
                m.checkNotNullParameter(list3, "trending");
                this.gifs = list;
                this.suggested = list2;
                this.trending = list3;
                this.searchQuery = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SearchResults copy$default(SearchResults searchResults, List list, List list2, List list3, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = searchResults.gifs;
                }
                if ((i & 2) != 0) {
                    list2 = searchResults.suggested;
                }
                if ((i & 4) != 0) {
                    list3 = searchResults.trending;
                }
                if ((i & 8) != 0) {
                    str = searchResults.searchQuery;
                }
                return searchResults.copy(list, list2, list3, str);
            }

            public final List<ModelGif> component1() {
                return this.gifs;
            }

            public final List<String> component2() {
                return this.suggested;
            }

            public final List<String> component3() {
                return this.trending;
            }

            /* renamed from: component4, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final SearchResults copy(List<ModelGif> gifs, List<String> suggested, List<String> trending, String searchQuery) {
                m.checkNotNullParameter(gifs, "gifs");
                m.checkNotNullParameter(suggested, "suggested");
                m.checkNotNullParameter(trending, "trending");
                return new SearchResults(gifs, suggested, trending, searchQuery);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchResults)) {
                    return false;
                }
                SearchResults searchResults = (SearchResults) other;
                return m.areEqual(this.gifs, searchResults.gifs) && m.areEqual(this.suggested, searchResults.suggested) && m.areEqual(this.trending, searchResults.trending) && m.areEqual(this.searchQuery, searchResults.searchQuery);
            }

            public final List<ModelGif> getGifs() {
                return this.gifs;
            }

            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final List<String> getSuggested() {
                return this.suggested;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<ModelGif> list = this.gifs;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<String> list2 = this.suggested;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                List<String> list3 = this.trending;
                int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                return iHashCode3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("SearchResults(gifs=");
                sbU.append(this.gifs);
                sbU.append(", suggested=");
                sbU.append(this.suggested);
                sbU.append(", trending=");
                sbU.append(this.trending);
                sbU.append(", searchQuery=");
                return b.d.b.a.a.J(sbU, this.searchQuery, ")");
            }
        }

        /* compiled from: GifSearchViewModel.kt */
        public static final /* data */ class TrendingSearchTermsResults extends StoreState {
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrendingSearchTermsResults(List<String> list) {
                super(list, null);
                m.checkNotNullParameter(list, "trending");
                this.trending = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ TrendingSearchTermsResults copy$default(TrendingSearchTermsResults trendingSearchTermsResults, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = trendingSearchTermsResults.trending;
                }
                return trendingSearchTermsResults.copy(list);
            }

            public final List<String> component1() {
                return this.trending;
            }

            public final TrendingSearchTermsResults copy(List<String> trending) {
                m.checkNotNullParameter(trending, "trending");
                return new TrendingSearchTermsResults(trending);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof TrendingSearchTermsResults) && m.areEqual(this.trending, ((TrendingSearchTermsResults) other).trending);
                }
                return true;
            }

            public final List<String> getTrending() {
                return this.trending;
            }

            public int hashCode() {
                List<String> list = this.trending;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.L(b.d.b.a.a.U("TrendingSearchTermsResults(trending="), this.trending, ")");
            }
        }

        private StoreState(List<String> list) {
            this.trendingSearchTerms = list;
        }

        public final List<String> getTrendingSearchTerms() {
            return this.trendingSearchTerms;
        }

        public /* synthetic */ StoreState(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: GifSearchViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<GifAdapterItem> adapterItems;

            /* renamed from: gifCount$delegate, reason: from kotlin metadata */
            private final Lazy gifCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GifAdapterItem> list) {
                super(null);
                m.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.gifCount = g.lazy(new GifSearchViewModel$ViewState$Loaded$gifCount$2(this));
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<GifAdapterItem> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends GifAdapterItem> adapterItems) {
                m.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<GifAdapterItem> getAdapterItems() {
                return this.adapterItems;
            }

            public final int getGifCount() {
                return ((Number) this.gifCount.getValue()).intValue();
            }

            public int hashCode() {
                List<GifAdapterItem> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.L(b.d.b.a.a.U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* compiled from: GifSearchViewModel.kt */
        public static final class LoadingSearchResults extends ViewState {
            public static final LoadingSearchResults INSTANCE = new LoadingSearchResults();

            private LoadingSearchResults() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifSearchViewModel(Context context, BehaviorSubject behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        if ((i & 2) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectL0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, behaviorSubjectL0, analytics, gifPicker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifSearchViewModel gifSearchViewModel, StoreState storeState) {
        gifSearchViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        List<String> trendingSearchTerms = storeState.getTrendingSearchTerms();
        boolean z2 = storeState instanceof StoreState.SearchResults;
        if (z2) {
            StoreState.SearchResults searchResults = (StoreState.SearchResults) storeState;
            List<ModelGif> gifs = searchResults.getGifs();
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem.GifItem((ModelGif) it.next(), searchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = searchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = searchResults.getSuggested().size() > 0;
            String strN0 = this.searchSubject.n0();
            m.checkNotNullExpressionValue(strN0, "searchSubject.value");
            boolean z5 = strN0.length() > 0;
            arrayList.add(z3 ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults(suggested, R.string.gif_picker_related_search) : (!z5 || z4) ? (z5 && z4) ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_with_related_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.gif_picker_enter_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, R.string.no_gif_search_results_without_related_search));
        } else if (storeState instanceof StoreState.TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(trendingSearchTerms, R.string.gif_picker_enter_search));
        }
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList);
        if (z2) {
            StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, null, false, 28, null);
        }
        updateViewState(loaded);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        m.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager.sendMessage$default(this.messageManager, gifItem.getGif().getTenorGifUrl(), null, null, null, null, false, null, null, null, 510, null);
    }

    public final void setSearchText(String searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        if (!m.areEqual(this.searchSubject.n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(ViewState.LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<StoreState> observable) {
        super(null);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(behaviorSubject, "searchSubject");
        m.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GifSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
