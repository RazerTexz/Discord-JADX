package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import com.discord.C5419R;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageManager messageManager;
    private final BehaviorSubject<String> searchSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$1 */
    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static final class C78711 extends Lambda implements Function1<StoreState, Unit> {
        public C78711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GifSearchViewModel.access$handleStoreState(GifSearchViewModel.this, storeState);
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
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
            Observable<String> observableM11112r = searchSubject.m11084J(Schedulers2.m10875c()).m11112r();
            Observable<StoreState> observableM11099Y = Observable.m11074h0(new OnSubscribeLift(observableM11112r.f27640j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, Schedulers2.m10875c()))).m11115u(new GifSearchViewModel2(storeAnalytics)).m11099Y(new GifSearchViewModel3(trendingSearchTerms, storeGifPicker));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "searchSubject\n          …          }\n            }");
            return observableM11099Y;
        }

        private final Observable<StoreState> observeStoreState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
            Observable observableM11099Y = storeGifPicker.observeGifTrendingSearchTerms().m11099Y(new GifSearchViewModel4(searchSubject, storeAnalytics, storeGifPicker));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeGifPicker.observeGi…fPicker, terms)\n        }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static abstract class StoreState {
        private final List<String> trendingSearchTerms;

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class SearchResults extends StoreState {
            private final List<ModelGif> gifs;
            private final String searchQuery;
            private final List<String> suggested;
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResults(List<ModelGif> list, List<String> list2, List<String> list3, String str) {
                super(list3, null);
                Intrinsics3.checkNotNullParameter(list, "gifs");
                Intrinsics3.checkNotNullParameter(list2, "suggested");
                Intrinsics3.checkNotNullParameter(list3, "trending");
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

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final SearchResults copy(List<ModelGif> gifs, List<String> suggested, List<String> trending, String searchQuery) {
                Intrinsics3.checkNotNullParameter(gifs, "gifs");
                Intrinsics3.checkNotNullParameter(suggested, "suggested");
                Intrinsics3.checkNotNullParameter(trending, "trending");
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
                return Intrinsics3.areEqual(this.gifs, searchResults.gifs) && Intrinsics3.areEqual(this.suggested, searchResults.suggested) && Intrinsics3.areEqual(this.trending, searchResults.trending) && Intrinsics3.areEqual(this.searchQuery, searchResults.searchQuery);
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
                StringBuilder sbM833U = outline.m833U("SearchResults(gifs=");
                sbM833U.append(this.gifs);
                sbM833U.append(", suggested=");
                sbM833U.append(this.suggested);
                sbM833U.append(", trending=");
                sbM833U.append(this.trending);
                sbM833U.append(", searchQuery=");
                return outline.m822J(sbM833U, this.searchQuery, ")");
            }
        }

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class TrendingSearchTermsResults extends StoreState {
            private final List<String> trending;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TrendingSearchTermsResults(List<String> list) {
                super(list, null);
                Intrinsics3.checkNotNullParameter(list, "trending");
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
                Intrinsics3.checkNotNullParameter(trending, "trending");
                return new TrendingSearchTermsResults(trending);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof TrendingSearchTermsResults) && Intrinsics3.areEqual(this.trending, ((TrendingSearchTermsResults) other).trending);
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
                return outline.m824L(outline.m833U("TrendingSearchTermsResults(trending="), this.trending, ")");
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

    /* JADX INFO: compiled from: GifSearchViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<GifAdapterItem> adapterItems;

            /* JADX INFO: renamed from: gifCount$delegate, reason: from kotlin metadata */
            private final Lazy gifCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends GifAdapterItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.gifCount = LazyJVM.lazy(new GifSearchViewModel5(this));
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
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
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
                return outline.m824L(outline.m833U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* JADX INFO: compiled from: GifSearchViewModel.kt */
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
        BehaviorSubject behaviorSubjectM11130l0;
        if ((i & 2) != 0) {
            behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectM11130l0 = behaviorSubject;
        }
        StoreGifPicker gifPicker = (i & 4) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        StoreAnalytics analytics = (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        this(context, behaviorSubjectM11130l0, gifPicker, analytics, (i & 16) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, behaviorSubjectM11130l0, analytics, gifPicker) : observable);
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
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(gifs, 10));
            Iterator<T> it = gifs.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GifAdapterItem.GifItem((ModelGif) it.next(), searchResults.getSearchQuery()));
            }
            arrayList.addAll(arrayList2);
            List<String> suggested = searchResults.getSuggested();
            boolean z3 = arrayList.size() > 0;
            boolean z4 = searchResults.getSuggested().size() > 0;
            String strM11132n0 = this.searchSubject.m11132n0();
            Intrinsics3.checkNotNullExpressionValue(strM11132n0, "searchSubject.value");
            boolean z5 = strM11132n0.length() > 0;
            arrayList.add(z3 ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults(suggested, C5419R.string.gif_picker_related_search) : (!z5 || z4) ? (z5 && z4) ? new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.no_gif_search_results_with_related_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.gif_picker_enter_search) : new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(suggested, C5419R.string.no_gif_search_results_without_related_search));
        } else if (storeState instanceof StoreState.TrendingSearchTermsResults) {
            arrayList.add(new GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults(trendingSearchTerms, C5419R.string.gif_picker_enter_search));
        }
        ViewState.Loaded loaded = new ViewState.Loaded(arrayList);
        if (z2) {
            StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, loaded.getGifCount(), null, null, false, 28, null);
        }
        updateViewState(loaded);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
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
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        if (!Intrinsics3.areEqual(this.searchSubject.m11132n0(), searchText)) {
            if (searchText.length() > 0) {
                updateViewState(ViewState.LoadingSearchResults.INSTANCE);
            }
        }
        this.searchSubject.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel(Context context, BehaviorSubject<String> behaviorSubject, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, MessageManager messageManager, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchSubject");
        Intrinsics3.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        this.messageManager = messageManager;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GifSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78711(), 62, (Object) null);
    }
}
