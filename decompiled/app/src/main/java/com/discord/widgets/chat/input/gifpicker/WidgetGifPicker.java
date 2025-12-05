package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifPickerBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.GridColumnSpaceItemDecoration;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.gifpicker.GifPickerViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGifPicker.kt */
/* loaded from: classes2.dex */
public final class WidgetGifPicker extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGifPicker.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifCategoryAdapter categoryAdapter;
    private Function1<? super GifCategoryItem, Unit> onSelectGifCategory;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGifPicker.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$onViewBoundOrOnResume$1 */
    public static final class C78821 extends Lambda implements Function1<GifPickerViewModel.ViewState, Unit> {
        public C78821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifPickerViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifPickerViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGifPicker.access$handleViewState(WidgetGifPicker.this, viewState);
        }
    }

    /* compiled from: WidgetGifPicker.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$setWindowInsetsListeners$1 */
    public static final class C78831 implements OnApplyWindowInsetsListener {
        public static final C78831 INSTANCE = new C78831();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetGifPicker.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$setWindowInsetsListeners$2 */
    public static final class C78842 implements OnApplyWindowInsetsListener {
        public static final C78842 INSTANCE = new C78842();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetGifPicker.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$setWindowInsetsListeners$3 */
    public static final class C78853 implements OnApplyWindowInsetsListener {
        public C78853() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.access$getBinding$p(WidgetGifPicker.this).f16699b, windowInsetsCompat);
            ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.access$getBinding$p(WidgetGifPicker.this).f16701d, windowInsetsCompat);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetGifPicker() {
        super(C5419R.layout.widget_gif_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifPicker2.INSTANCE, null, 2, null);
        WidgetGifPicker3 widgetGifPicker3 = WidgetGifPicker3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifPickerViewModel.class), new WidgetGifPicker$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifPicker3));
    }

    public static final /* synthetic */ WidgetGifPickerBinding access$getBinding$p(WidgetGifPicker widgetGifPicker) {
        return widgetGifPicker.getBinding();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifPicker widgetGifPicker, GifPickerViewModel.ViewState viewState) {
        widgetGifPicker.handleViewState(viewState);
    }

    private final WidgetGifPickerBinding getBinding() {
        return (WidgetGifPickerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifPickerViewModel getViewModel() {
        return (GifPickerViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(GifPickerViewModel.ViewState viewState) {
        RecyclerView recyclerView = getBinding().f16699b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setVisibility(viewState.getIsLoaded() ? 0 : 8);
        GifLoadingView gifLoadingView = getBinding().f16701d;
        Intrinsics3.checkNotNullExpressionValue(gifLoadingView, "binding.gifPickerLoadingView");
        gifLoadingView.setVisibility(viewState.getIsLoaded() ^ true ? 0 : 8);
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        gifCategoryAdapter.setItems(viewState.getGifCategoryItems());
    }

    private final void setUpCategoryRecycler() {
        RecyclerView recyclerView = getBinding().f16699b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifPickerCategoryRecycler");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecyclerView recyclerView2 = getBinding().f16699b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifPickerCategoryRecycler");
        recyclerView2.setItemAnimator(null);
        this.categoryAdapter = new GifCategoryAdapter(this, this.onSelectGifCategory, null, 4, null);
        RecyclerView recyclerView3 = getBinding().f16699b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifPickerCategoryRecycler");
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        recyclerView3.setAdapter(gifCategoryAdapter);
        getBinding().f16699b.addItemDecoration(new GridColumnSpaceItemDecoration(DimenUtils.dpToPixels(8), 2));
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16699b, C78831.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16701d, C78842.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f16700c, new C78853());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpCategoryRecycler();
        setWindowInsetsListeners();
        GifLoadingView.updateView$default(getBinding().f16701d, 2, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGifPicker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C78821(), 62, (Object) null);
    }

    public final void scrollToTop() {
        GifCategoryAdapter gifCategoryAdapter = this.categoryAdapter;
        if (gifCategoryAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("categoryAdapter");
        }
        if (gifCategoryAdapter.getPageSize() > 0) {
            getBinding().f16699b.scrollToPosition(0);
        }
    }

    public final void setOnSelectGifCategory(Function1<? super GifCategoryItem, Unit> onGifCategorySelected) {
        Intrinsics3.checkNotNullParameter(onGifCategorySelected, "onGifCategorySelected");
        this.onSelectGifCategory = onGifCategorySelected;
    }
}
