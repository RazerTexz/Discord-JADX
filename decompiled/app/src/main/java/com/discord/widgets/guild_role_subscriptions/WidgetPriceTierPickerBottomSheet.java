package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.y.DividerDecoration2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int PRICE_TIER_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_PRICE_TIER = "RESULT_EXTRA_PRICE_TIER";
    private WidgetPriceTierPickerBottomSheet2 adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Function1<Integer, Unit> itemClickListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPriceTierPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Fragment fragment, String requestKey) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = new WidgetPriceTierPickerBottomSheet();
            widgetPriceTierPickerBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to(WidgetPriceTierPickerBottomSheet.ARG_REQUEST_KEY, requestKey)));
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetPriceTierPickerBottomSheet.show(parentFragmentManager, WidgetPriceTierPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function1<? super Integer, Unit> onPriceTierSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onPriceTierSelected, "onPriceTierSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetPriceTierPickerBottomSheet4(requestKey, onPriceTierSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<PriceTierPickerBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
            WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = WidgetPriceTierPickerBottomSheet.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetPriceTierPickerBottomSheet.access$configureUI(widgetPriceTierPickerBottomSheet, viewState);
        }
    }

    public WidgetPriceTierPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPriceTierPickerBottomSheet5.INSTANCE, null, 2, null);
        WidgetPriceTierPickerBottomSheet7 widgetPriceTierPickerBottomSheet7 = WidgetPriceTierPickerBottomSheet7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PriceTierPickerBottomSheetViewModel.class), new WidgetPriceTierPickerBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetPriceTierPickerBottomSheet7));
        this.itemClickListener = new WidgetPriceTierPickerBottomSheet6(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet, PriceTierPickerBottomSheetViewModel.ViewState viewState) {
        widgetPriceTierPickerBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        return widgetPriceTierPickerBottomSheet.getArgumentsOrDefault();
    }

    private final void configureUI(PriceTierPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2513b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.priceTierPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            if (!(viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Loaded)) {
                if (viewState instanceof PriceTierPickerBottomSheetViewModel.ViewState.Failed) {
                    AppToast.g(requireContext(), R.string.default_failure_to_perform_action_message, 0, null, 12);
                    dismiss();
                    return;
                }
                return;
            }
            AppViewFlipper appViewFlipper2 = getBinding().f2513b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.priceTierPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetPriceTierPickerBottomSheet2 widgetPriceTierPickerBottomSheet2 = this.adapter;
            if (widgetPriceTierPickerBottomSheet2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetPriceTierPickerBottomSheet2.setItems(((PriceTierPickerBottomSheetViewModel.ViewState.Loaded) viewState).getPriceTiers());
        }
    }

    private final WidgetPriceTierPickerBottomSheetBinding getBinding() {
        return (WidgetPriceTierPickerBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PriceTierPickerBottomSheetViewModel getViewModel() {
        return (PriceTierPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Observable<PriceTierPickerBottomSheetViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetPriceTierPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_price_tier_picker_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetPriceTierPickerBottomSheet2(this.itemClickListener);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.priceTierPickerRecycler");
        WidgetPriceTierPickerBottomSheet2 widgetPriceTierPickerBottomSheet2 = this.adapter;
        if (widgetPriceTierPickerBottomSheet2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetPriceTierPickerBottomSheet2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding);
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().c.addItemDecoration(new DividerDecoration2(contextRequireContext, 1, 0, dimensionPixelSize, dimensionPixelSize, 4));
    }
}
