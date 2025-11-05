package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetClaimOutboundPromo.kt */
/* loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo extends AppDialog {
    private static final String ARG_CLAIM_STATUS = "ARG_CLAIM_STATUS";
    private static final int INDEX_FAILURE = 2;
    private static final int INDEX_LOADING = 0;
    private static final int INDEX_SUCCESS = 1;
    private static final String KEY_PROMO_CLAIMED = "KEY_PROMO_CLAIMED";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final MaterialShapeDrawable codeBoxBackground;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetClaimOutboundPromo.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetClaimOutboundPromo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showAndRegisterForClaimResult(ClaimStatus claimStatus, Fragment fragment, Function1<? super ClaimStatus.Claimed, Unit> onPromoClaimed) {
            m.checkNotNullParameter(claimStatus, "claimStatus");
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(onPromoClaimed, "onPromoClaimed");
            if (fragment.getParentFragmentManager().findFragmentByTag("javaClass") != null) {
                return;
            }
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                FragmentKt.setFragmentResultListener(fragment, WidgetClaimOutboundPromo.KEY_PROMO_CLAIMED, new WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2(onPromoClaimed));
            }
            WidgetClaimOutboundPromo widgetClaimOutboundPromo = new WidgetClaimOutboundPromo();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetClaimOutboundPromo.ARG_CLAIM_STATUS, claimStatus);
            widgetClaimOutboundPromo.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetClaimOutboundPromo.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).copyClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).redeemClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).maybeLaterClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).failureCloseClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<ClaimOutboundPromoViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "configureUi", "configureUi(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetClaimOutboundPromo.access$configureUi((WidgetClaimOutboundPromo) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<ClaimOutboundPromoViewModel.Event, Unit> {
        public AnonymousClass2(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetClaimOutboundPromo.access$handleEvent((WidgetClaimOutboundPromo) this.receiver, event);
        }
    }

    public WidgetClaimOutboundPromo() {
        super(R.layout.widget_claim_outbound_promo);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetClaimOutboundPromo$binding$2.INSTANCE, null, 2, null);
        WidgetClaimOutboundPromo$viewModel$2 widgetClaimOutboundPromo$viewModel$2 = new WidgetClaimOutboundPromo$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ClaimOutboundPromoViewModel.class), new WidgetClaimOutboundPromo$appViewModels$$inlined$viewModels$1(new g0(this)), new i0(widgetClaimOutboundPromo$viewModel$2));
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(DimenUtils.dpToPixels(4)).build());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        this.codeBoxBackground = materialShapeDrawable;
    }

    public static final /* synthetic */ void access$configureUi(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel.ViewState viewState) {
        widgetClaimOutboundPromo.configureUi(viewState);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getClaimStatus();
    }

    public static final /* synthetic */ ClaimOutboundPromoViewModel access$getViewModel$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel.Event event) {
        widgetClaimOutboundPromo.handleEvent(event);
    }

    private final void configureUi(ClaimOutboundPromoViewModel.ViewState viewState) {
        View view = getView();
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setOrdering(0);
            autoTransition.setDuration(200L);
            TransitionManager.beginDelayedTransition(viewGroup, autoTransition);
        }
        if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimInProgress) {
            AppViewFlipper appViewFlipper = getBinding().g;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.claimPromoFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ClaimOutboundPromoViewModel.ViewState.Claimed)) {
            if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimFailed) {
                AppViewFlipper appViewFlipper2 = getBinding().g;
                m.checkNotNullExpressionValue(appViewFlipper2, "binding.claimPromoFlipper");
                appViewFlipper2.setMeasureAllChildren(false);
                AppViewFlipper appViewFlipper3 = getBinding().g;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.claimPromoFlipper");
                appViewFlipper3.setDisplayedChild(2);
                setCancelable(true);
                return;
            }
            return;
        }
        TextView textView = getBinding().f2350b;
        m.checkNotNullExpressionValue(textView, "binding.claimPromoBody");
        ClaimOutboundPromoViewModel.ViewState.Claimed claimed = (ClaimOutboundPromoViewModel.ViewState.Claimed) viewState;
        textView.setText(claimed.getClaimedStatus().getBody());
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.claimPromoCode");
        textView2.setText(claimed.getClaimedStatus().getCode());
        AppViewFlipper appViewFlipper4 = getBinding().g;
        m.checkNotNullExpressionValue(appViewFlipper4, "binding.claimPromoFlipper");
        appViewFlipper4.setDisplayedChild(1);
        setCancelable(true);
    }

    private final WidgetClaimOutboundPromoBinding getBinding() {
        return (WidgetClaimOutboundPromoBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ClaimStatus getClaimStatus() {
        Parcelable parcelable = getArgumentsOrDefault().getParcelable(ARG_CLAIM_STATUS);
        m.checkNotNull(parcelable);
        return (ClaimStatus) parcelable;
    }

    private final ClaimOutboundPromoViewModel getViewModel() {
        return (ClaimOutboundPromoViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ClaimOutboundPromoViewModel.Event event) {
        Unit unit;
        if (event instanceof ClaimOutboundPromoViewModel.Event.Claimed) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(KEY_PROMO_CLAIMED, ((ClaimOutboundPromoViewModel.Event.Claimed) event).getClaimedStatus());
            unit = Unit.a;
            FragmentKt.setFragmentResult(this, KEY_PROMO_CLAIMED, bundle);
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.CopyCode) {
            Object systemService = requireContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Promo Code", ((ClaimOutboundPromoViewModel.Event.CopyCode) event).getCode()));
            MaterialButton materialButton = getBinding().e;
            m.checkNotNullExpressionValue(materialButton, "binding.claimPromoCopyButton");
            b.n(materialButton, R.string.copied, new Object[0], null, 4);
            setCodeBoxColor(ContextCompat.getColor(requireContext(), R.color.status_green_600));
            unit = Unit.a;
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, ((ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) event).getUrl(), false, false, null, 28, null);
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof ClaimOutboundPromoViewModel.Event.Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void setCodeBoxColor(@ColorInt int color) {
        this.codeBoxBackground.setStroke(DimenUtils.dpToPixels(1), color);
        getBinding().d.invalidate();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setBackground(getBinding().d, this.codeBoxBackground);
        setCodeBoxColor(ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal));
        getBinding().e.setOnClickListener(new AnonymousClass1());
        getBinding().i.setOnClickListener(new AnonymousClass2());
        getBinding().h.setOnClickListener(new AnonymousClass3());
        getBinding().f.setOnClickListener(new AnonymousClass4());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
