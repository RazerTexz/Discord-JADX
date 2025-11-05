package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import com.discord.widgets.chat.input.gifpicker.GifAdapter;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.GifStaggeredGridItemDecoration;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* compiled from: WidgetGifCategory.kt */
/* loaded from: classes2.dex */
public final class WidgetGifCategory extends AppFragment {
    public static final String ARG_GIF_CATEGORY_ITEM = "GIF_CATEGORY_ITEM";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: expressionTrayViewModel$delegate, reason: from kotlin metadata */
    private final Lazy expressionTrayViewModel;
    private GifAdapter gifAdapter;

    /* renamed from: gifCategoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifCategoryViewModel;
    private Function0<Unit> onGifSelected;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGifCategory.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifCategoryBinding;", 0)};

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifCategoryViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifCategoryViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifCategoryViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGifCategory.access$handleViewState(WidgetGifCategory.this, viewState);
        }
    }

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setUpBackBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetGifCategory.access$handleBack(WidgetGifCategory.this);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setUpBackBehavior$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGifCategory.access$handleBack(WidgetGifCategory.this);
        }
    }

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setUpGifRecycler$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GifAdapterItem.GifItem, Unit> {
        public AnonymousClass1(WidgetGifCategory widgetGifCategory) {
            super(1, widgetGifCategory, WidgetGifCategory.class, "selectGif", "selectGif(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            Intrinsics3.checkNotNullParameter(gifItem, "p1");
            WidgetGifCategory.access$selectGif((WidgetGifCategory) this.receiver, gifItem);
        }
    }

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetGifCategory.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$setWindowInsetsListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewCompat.dispatchApplyWindowInsets(WidgetGifCategory.access$getBinding$p(WidgetGifCategory.this).c, windowInsetsCompat);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetGifCategory() {
        super(R.layout.widget_gif_category);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifCategory2.INSTANCE, null, 2, null);
        this.expressionTrayViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ExpressionTrayViewModel.class), new WidgetGifCategory$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGifCategory3.INSTANCE));
        WidgetGifCategory4 widgetGifCategory4 = new WidgetGifCategory4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.gifCategoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifCategoryViewModel.class), new WidgetGifCategory$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifCategory4));
    }

    public static final /* synthetic */ WidgetGifCategoryBinding access$getBinding$p(WidgetGifCategory widgetGifCategory) {
        return widgetGifCategory.getBinding();
    }

    public static final /* synthetic */ GifCategoryItem access$getGifCategory(WidgetGifCategory widgetGifCategory) {
        return widgetGifCategory.getGifCategory();
    }

    public static final /* synthetic */ void access$handleBack(WidgetGifCategory widgetGifCategory) {
        widgetGifCategory.handleBack();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifCategory widgetGifCategory, GifCategoryViewModel.ViewState viewState) {
        widgetGifCategory.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$selectGif(WidgetGifCategory widgetGifCategory, GifAdapterItem.GifItem gifItem) {
        widgetGifCategory.selectGif(gifItem);
    }

    private final WidgetGifCategoryBinding getBinding() {
        return (WidgetGifCategoryBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ExpressionTrayViewModel getExpressionTrayViewModel() {
        return (ExpressionTrayViewModel) this.expressionTrayViewModel.getValue();
    }

    private final GifCategoryItem getGifCategory() {
        Serializable serializable = requireArguments().getSerializable(ARG_GIF_CATEGORY_ITEM);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.chat.input.gifpicker.GifCategoryItem");
        return (GifCategoryItem) serializable;
    }

    private final GifCategoryViewModel getGifCategoryViewModel() {
        return (GifCategoryViewModel) this.gifCategoryViewModel.getValue();
    }

    private final void handleBack() {
        getExpressionTrayViewModel().clickBack();
    }

    private final void handleViewState(GifCategoryViewModel.ViewState viewState) {
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setVisibility(0);
        GifLoadingView gifLoadingView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(gifLoadingView, "binding.gifCategoryLoadingView");
        gifLoadingView.setVisibility(8);
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
        }
        gifAdapter.setItems(viewState.getGifItems());
    }

    private final void selectGif(GifAdapterItem.GifItem gifItem) {
        getGifCategoryViewModel().selectGif(gifItem);
        Function0<Unit> function0 = this.onGifSelected;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void setUpBackBehavior() {
        setOnBackPressed(new AnonymousClass1(), 0);
        getBinding().e.setOnClickListener(new AnonymousClass2());
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(categoryColumnsCount, 1);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifCategoryGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifCategoryGifRecycler");
        this.gifAdapter = new GifAdapter(this, new AnonymousClass1(this), companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), null, null, 24, null);
        RecyclerView recyclerView4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.gifCategoryGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().c.addItemDecoration(new GifStaggeredGridItemDecoration(iDpToPixels, categoryColumnsCount));
    }

    private final void setUpTitle() throws Resources.NotFoundException {
        String string;
        GifCategoryItem gifCategory = getGifCategory();
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifCategoryTitle");
        if (gifCategory instanceof GifCategoryItem.Standard) {
            string = ((GifCategoryItem.Standard) gifCategory).getGifCategory().getCategoryName();
        } else {
            if (!(gifCategory instanceof GifCategoryItem.Trending)) {
                throw new NoWhenBranchMatchedException();
            }
            string = getResources().getString(R.string.gif_picker_result_type_trending_gifs);
        }
        textView.setText(string);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, AnonymousClass1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2400b, new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifCategoryGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpTitle();
        setUpBackBehavior();
        setUpGifRecycler(iCalculateColumnCount);
        GifLoadingView.updateView$default(getBinding().d, iCalculateColumnCount, 0, 2, null);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getGifCategoryViewModel().observeViewState(), this, null, 2, null), WidgetGifCategory.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
