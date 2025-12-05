package com.discord.widgets.search.suggestions;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.FilterSuggestion;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.utilities.search.suggestion.entries.RecentQuerySuggestion;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetSearchSuggestions.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSearchSuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0)};
    private WidgetSearchSuggestionsAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SearchStringProvider searchStringProvider;

    /* compiled from: WidgetSearchSuggestions.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<QueryNode> query;
        private final List<SearchSuggestion> suggestionEntries;
        private final List<MGRecyclerDataPayload> suggestionItems;

        /* compiled from: WidgetSearchSuggestions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(SearchStringProvider searchStringProvider) {
                Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getSearch().getStoreSearchData().get(), companion.getSearch().getStoreSearchInput().getCurrentParsedInput(), companion.getSearch().getHistory(), new WidgetSearchSuggestions2(searchStringProvider));
                Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…gestionEntries)\n        }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…().distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SearchSuggestion.Category.values();
                int[] iArr = new int[7];
                $EnumSwitchMapping$0 = iArr;
                iArr[SearchSuggestion.Category.FILTER.ordinal()] = 1;
                iArr[SearchSuggestion.Category.FROM_USER.ordinal()] = 2;
                iArr[SearchSuggestion.Category.MENTIONS_USER.ordinal()] = 3;
                iArr[SearchSuggestion.Category.IN_CHANNEL.ordinal()] = 4;
                iArr[SearchSuggestion.Category.HAS.ordinal()] = 5;
                iArr[SearchSuggestion.Category.RECENT_QUERY.ordinal()] = 6;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<QueryNode> list, List<? extends SearchSuggestion> list2) {
            Intrinsics3.checkNotNullParameter(list, "query");
            Intrinsics3.checkNotNullParameter(list2, "suggestionEntries");
            this.query = list;
            this.suggestionEntries = list2;
            this.suggestionItems = new ArrayList();
            SearchSuggestion.Category category = null;
            for (SearchSuggestion searchSuggestion : list2) {
                SearchSuggestion.Category category2 = searchSuggestion.getCategory();
                if (category == null || category2 != category) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHeaderItem(category2));
                    category = category2;
                }
                int iOrdinal = category2.ordinal();
                if (iOrdinal == 0) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getFilterItem((FilterSuggestion) searchSuggestion));
                } else if (iOrdinal == 1 || iOrdinal == 2) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getUserItem((UserSuggestion) searchSuggestion));
                } else if (iOrdinal == 3) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getHasItem((HasSuggestion) searchSuggestion));
                } else if (iOrdinal == 5) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getInChannelItem((ChannelSuggestion) searchSuggestion));
                } else if (iOrdinal == 6) {
                    this.suggestionItems.add(WidgetSearchSuggestionsAdapter.INSTANCE.getRecentQueryItem((RecentQuerySuggestion) searchSuggestion));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.query;
            }
            if ((i & 2) != 0) {
                list2 = model.suggestionEntries;
            }
            return model.copy(list, list2);
        }

        public final List<QueryNode> component1() {
            return this.query;
        }

        public final List<SearchSuggestion> component2() {
            return this.suggestionEntries;
        }

        public final Model copy(List<QueryNode> query, List<? extends SearchSuggestion> suggestionEntries) {
            Intrinsics3.checkNotNullParameter(query, "query");
            Intrinsics3.checkNotNullParameter(suggestionEntries, "suggestionEntries");
            return new Model(query, suggestionEntries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.query, model.query) && Intrinsics3.areEqual(this.suggestionEntries, model.suggestionEntries);
        }

        public final List<QueryNode> getQuery() {
            return this.query;
        }

        public final List<SearchSuggestion> getSuggestionEntries() {
            return this.suggestionEntries;
        }

        public final List<MGRecyclerDataPayload> getSuggestionItems() {
            return this.suggestionItems;
        }

        public int hashCode() {
            List<QueryNode> list = this.query;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<SearchSuggestion> list2 = this.suggestionEntries;
            return iHashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(query=");
            sbM833U.append(this.query);
            sbM833U.append(", suggestionEntries=");
            return outline.m824L(sbM833U, this.suggestionEntries, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserSuggestion.TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[UserSuggestion.TargetType.FROM.ordinal()] = 1;
            iArr[UserSuggestion.TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$1 */
    public static final class C91361 extends Lambda implements Function1<FilterType, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91361(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
            invoke2(filterType);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FilterType filterType) {
            Intrinsics3.checkNotNullParameter(filterType, "filterType");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onFilterClicked(filterType, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$2 */
    public static final class C91372 extends Lambda implements Function1<UserSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91372(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
            invoke2(userSuggestion);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSuggestion userSuggestion) {
            Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
            int iOrdinal = userSuggestion.getTargetType().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                StoreStream.INSTANCE.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            } else {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getSearch().getStoreSearchInput().onFromUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getFromFilterString(), this.$model.getQuery());
                companion.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getMentionsFilterString(), this.$model.getQuery());
            }
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$3 */
    public static final class C91383 extends Lambda implements Function1<ChannelSuggestion, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91383(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
            invoke2(channelSuggestion);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelSuggestion channelSuggestion) {
            Intrinsics3.checkNotNullParameter(channelSuggestion, "channelSuggestion");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onInChannelClicked(channelSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getInFilterString(), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$4 */
    public static final class C91394 extends Lambda implements Function1<HasNode2, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91394(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HasNode2 hasNode2) {
            invoke2(hasNode2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HasNode2 hasNode2) {
            Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onHasClicked(hasNode2, WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this).getHasFilterString(), hasNode2.getLocalizedInputText(WidgetSearchSuggestions.access$getSearchStringProvider$p(WidgetSearchSuggestions.this)), this.$model.getQuery());
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$5 */
    public static final class C91405 extends Lambda implements Function1<List<? extends QueryNode>, Unit> {
        public static final C91405 INSTANCE = new C91405();

        public C91405() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullParameter(list, "queryNodes");
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().onQueryClicked(list);
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$configureUI$6 */
    public static final class C91416 extends Lambda implements Function0<Unit> {
        public static final C91416 INSTANCE = new C91416();

        public C91416() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getSearch().clearHistory();
        }
    }

    /* compiled from: WidgetSearchSuggestions.kt */
    /* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$onViewBoundOrOnResume$1 */
    public static final class C91421 extends Lambda implements Function1<Model, Unit> {
        public C91421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "model");
            WidgetSearchSuggestions.access$configureUI(WidgetSearchSuggestions.this, model);
        }
    }

    public WidgetSearchSuggestions() {
        super(C5419R.layout.widget_search_suggestions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchSuggestions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearchSuggestions widgetSearchSuggestions, Model model) {
        widgetSearchSuggestions.configureUI(model);
    }

    public static final /* synthetic */ SearchStringProvider access$getSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions) {
        SearchStringProvider searchStringProvider = widgetSearchSuggestions.searchStringProvider;
        if (searchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        return searchStringProvider;
    }

    public static final /* synthetic */ void access$setSearchStringProvider$p(WidgetSearchSuggestions widgetSearchSuggestions, SearchStringProvider searchStringProvider) {
        widgetSearchSuggestions.searchStringProvider = searchStringProvider;
    }

    private final void configureUI(Model model) {
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter = this.adapter;
        if (widgetSearchSuggestionsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter.setData(model.getSuggestionItems());
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter2 = this.adapter;
        if (widgetSearchSuggestionsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter2.setOnFilterClicked(new C91361(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter3 = this.adapter;
        if (widgetSearchSuggestionsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter3.setOnUserClicked(new C91372(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter4 = this.adapter;
        if (widgetSearchSuggestionsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter4.setOnChannelClicked(new C91383(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter5 = this.adapter;
        if (widgetSearchSuggestionsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter5.setOnHasClicked(new C91394(model));
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter6 = this.adapter;
        if (widgetSearchSuggestionsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter6.setOnRecentQueryClicked(C91405.INSTANCE);
        WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter7 = this.adapter;
        if (widgetSearchSuggestionsAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSearchSuggestionsAdapter7.setOnClearHistoryClicked(C91416.INSTANCE);
    }

    private final WidgetSearchSuggestionsBinding getBinding() {
        return (WidgetSearchSuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17431b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchSuggestionsRecycler");
        this.adapter = (WidgetSearchSuggestionsAdapter) companion.configure(new WidgetSearchSuggestionsAdapter(recyclerView));
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView2 = getBinding().f17431b;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.searchSuggestionsRecycler");
            recyclerView2.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ContextSearchStringProvider contextSearchStringProvider = new ContextSearchStringProvider(requireContext());
        this.searchStringProvider = contextSearchStringProvider;
        Model.Companion companion = Model.INSTANCE;
        if (contextSearchStringProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("searchStringProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(contextSearchStringProvider), this, null, 2, null), WidgetSearchSuggestions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91421(), 62, (Object) null);
    }
}
