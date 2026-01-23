package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuthViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetRemoteAuth.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REMOTE_AUTH_FINGERPRINT = "REMOTE_AUTH_FINGERPRINT";
    private static final int VIEW_LOADED = 0;
    private static final int VIEW_LOADING = 2;
    private static final int VIEW_NOT_FOUND = 1;
    private static final int VIEW_SUCCEEDED = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String fingerprint) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fingerprint, "fingerprint");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetRemoteAuth.EXTRA_REMOTE_AUTH_FINGERPRINT, fingerprint);
            AppScreen2.m156d(context, WidgetRemoteAuth.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class ViewOnClickListenerC72591 implements View.OnClickListener {
        public ViewOnClickListenerC72591() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$2 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class ViewOnClickListenerC72602 implements View.OnClickListener {
        public ViewOnClickListenerC72602() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$3 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class ViewOnClickListenerC72613 implements View.OnClickListener {
        public ViewOnClickListenerC72613() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).remoteLogin();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$4 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class ViewOnClickListenerC72624 implements View.OnClickListener {
        public ViewOnClickListenerC72624() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).cancelLogin();
            WidgetRemoteAuth.this.requireActivity().finish();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$configureUI$5 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class C72635 implements CompoundButton.OnCheckedChangeListener {
        public C72635() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            WidgetRemoteAuth.access$getViewModel$p(WidgetRemoteAuth.this).toggleTemporary(!z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuth$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuth.kt */
    public static final class C72641 extends Lambda implements Function1<WidgetRemoteAuthViewModel.ViewState, Unit> {
        public C72641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetRemoteAuthViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetRemoteAuthViewModel.ViewState viewState) {
            WidgetRemoteAuth widgetRemoteAuth = WidgetRemoteAuth.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetRemoteAuth.access$configureUI(widgetRemoteAuth, viewState);
        }
    }

    public WidgetRemoteAuth() {
        super(C5419R.layout.widget_remote_auth);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetRemoteAuth2.INSTANCE, null, 2, null);
        WidgetRemoteAuth3 widgetRemoteAuth3 = new WidgetRemoteAuth3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetRemoteAuthViewModel.class), new WidgetRemoteAuth$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetRemoteAuth3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetRemoteAuth widgetRemoteAuth, WidgetRemoteAuthViewModel.ViewState viewState) {
        widgetRemoteAuth.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetRemoteAuthViewModel access$getViewModel$p(WidgetRemoteAuth widgetRemoteAuth) {
        return widgetRemoteAuth.getViewModel();
    }

    private final void configureUI(WidgetRemoteAuthViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().f17410e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.remoteAuthViewFlipper");
            appViewFlipper.setDisplayedChild(2);
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Failed.INSTANCE)) {
            AppViewFlipper appViewFlipper2 = getBinding().f17410e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.remoteAuthViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            getBinding().f17408c.f1327b.setOnClickListener(new ViewOnClickListenerC72591());
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetRemoteAuthViewModel.ViewState.Succeeded.INSTANCE)) {
            AppViewFlipper appViewFlipper3 = getBinding().f17410e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.remoteAuthViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
            getBinding().f17407b.f1387b.setOnClickListener(new ViewOnClickListenerC72602());
            return;
        }
        if (viewState instanceof WidgetRemoteAuthViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper4 = getBinding().f17410e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.remoteAuthViewFlipper");
            appViewFlipper4.setDisplayedChild(0);
            if (((WidgetRemoteAuthViewModel.ViewState.Loaded) viewState).getLoginAllowed()) {
                MaterialButton materialButton = getBinding().f17409d.f1360c;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton.setEnabled(true);
                getBinding().f17409d.f1360c.setOnClickListener(new ViewOnClickListenerC72613());
            } else {
                MaterialButton materialButton2 = getBinding().f17409d.f1360c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.pendingLogin.remoteAuthLoginButton");
                materialButton2.setEnabled(false);
            }
            getBinding().f17409d.f1359b.setOnClickListener(new ViewOnClickListenerC72624());
            getBinding().f17409d.f1361d.setOnCheckedChangeListener(null);
            SwitchMaterial switchMaterial = getBinding().f17409d.f1361d;
            Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.pendingLogin.remoteAuthTemporarySwitch");
            switchMaterial.setChecked(!r5.isTemporary());
            getBinding().f17409d.f1361d.setOnCheckedChangeListener(new C72635());
        }
    }

    private final WidgetRemoteAuthBinding getBinding() {
        return (WidgetRemoteAuthBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetRemoteAuthViewModel getViewModel() {
        return (WidgetRemoteAuthViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<WidgetRemoteAuthViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetRemoteAuth.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C72641(), 60, (Object) null);
    }
}
