package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.input.gifpicker.GifAdapter;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p000.GifStaggeredGridItemDecoration;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetGifPickerSearch.kt */
/* loaded from: classes2.dex */
public final class WidgetGifPickerSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGifPickerSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifAdapter gifAdapter;

    /* renamed from: gifPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifPickerViewModel;
    private Function0<Unit> onGifSelected;

    /* compiled from: WidgetGifPickerSearch.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$onViewBoundOrOnResume$1 */
    public static final class C78861 extends Lambda implements Function1<GifSearchViewModel.ViewState, Unit> {
        public C78861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifSearchViewModel.ViewState viewState) {
            WidgetGifPickerSearch widgetGifPickerSearch = WidgetGifPickerSearch.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetGifPickerSearch.access$handleViewState(widgetGifPickerSearch, viewState);
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$1 */
    public static final class C78871 extends Lambda implements Function1<GifAdapterItem.GifItem, Unit> {
        public C78871() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
            WidgetGifPickerSearch.access$getGifPickerViewModel$p(WidgetGifPickerSearch.this).selectGif(gifItem);
            Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSearch.access$getOnGifSelected$p(WidgetGifPickerSearch.this);
            if (function0Access$getOnGifSelected$p != null) {
            }
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$2 */
    public static final /* synthetic */ class C78882 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public C78882(SearchInputView searchInputView) {
            super(1, searchInputView, SearchInputView.class, "setText", "setText(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((SearchInputView) this.receiver).setText(str);
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setupSearchBar$1 */
    public static final class C78891 extends Lambda implements Function1<String, Unit> {
        public C78891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetGifPickerSearch.access$getGifPickerViewModel$p(WidgetGifPickerSearch.this).setSearchText(str);
        }
    }

    public WidgetGifPickerSearch() {
        super(C5419R.layout.widget_gif_picker_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifPickerSearch2.INSTANCE, null, 2, null);
        WidgetGifPickerSearch3 widgetGifPickerSearch3 = new WidgetGifPickerSearch3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.gifPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifSearchViewModel.class), new WidgetGifPickerSearch$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifPickerSearch3));
    }

    public static final /* synthetic */ GifSearchViewModel access$getGifPickerViewModel$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.getGifPickerViewModel();
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.onGifSelected;
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifPickerSearch widgetGifPickerSearch, GifSearchViewModel.ViewState viewState) {
        widgetGifPickerSearch.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch, Function0 function0) {
        widgetGifPickerSearch.onGifSelected = function0;
    }

    private final WidgetGifPickerSearchBinding getBinding() {
        return (WidgetGifPickerSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifSearchViewModel getGifPickerViewModel() {
        return (GifSearchViewModel) this.gifPickerViewModel.getValue();
    }

    private final void handleViewState(GifSearchViewModel.ViewState viewState) {
        if (viewState instanceof GifSearchViewModel.ViewState.Loaded) {
            GifAdapter gifAdapter = this.gifAdapter;
            if (gifAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter.setItems(((GifSearchViewModel.ViewState.Loaded) viewState).getAdapterItems());
            AppViewFlipper appViewFlipper = getBinding().f16705d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.gifSearchViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (Intrinsics3.areEqual(viewState, GifSearchViewModel.ViewState.LoadingSearchResults.INSTANCE)) {
            GifAdapter gifAdapter2 = this.gifAdapter;
            if (gifAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter2.clearItems();
            AppViewFlipper appViewFlipper2 = getBinding().f16705d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.gifSearchViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        RecyclerView recyclerView = getBinding().f16703b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(categoryColumnsCount, 1));
        RecyclerView recyclerView2 = getBinding().f16703b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifSearchGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        C78871 c78871 = new C78871();
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f16703b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifSearchGifRecycler");
        this.gifAdapter = new GifAdapter(this, c78871, companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), new C78882(getBinding().f16706e), null, 16, null);
        RecyclerView recyclerView4 = getBinding().f16703b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.gifSearchGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f16703b.addItemDecoration(new GifStaggeredGridItemDecoration(iDpToPixels, categoryColumnsCount));
    }

    private final void setupSearchBar() {
        getBinding().f16706e.m8553a(this, new C78891());
    }

    public final void clearSearchBar() {
        getGifPickerViewModel().setSearchText("");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16703b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpGifRecycler(iCalculateColumnCount);
        setupSearchBar();
        GifLoadingView.updateView$default(getBinding().f16704c, iCalculateColumnCount, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f16706e.binding.f971c.requestFocus();
        Observable<GifSearchViewModel.ViewState> observableM11112r = getGifPickerViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "gifPickerViewModel\n     …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetGifPickerSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78861(), 62, (Object) null);
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
