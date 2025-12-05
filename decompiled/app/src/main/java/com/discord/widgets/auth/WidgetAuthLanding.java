package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetAuthLanding.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthLanding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthLanding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLandingBinding;", 0)};
    private static final int VIEW_INDEX_HAS_INVITE = 1;
    private static final int VIEW_INDEX_NO_INVITE = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$1 */
    public static final class ViewOnClickListenerC71731 implements View.OnClickListener {
        public final /* synthetic */ String $ageGateError;

        public ViewOnClickListenerC71731(String str) {
            this.$ageGateError = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthAgeGated.INSTANCE.start(outline.m885x(view, "it", "it.context"), this.$ageGateError);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$2 */
    public static final class ViewOnClickListenerC71742 implements View.OnClickListener {
        public ViewOnClickListenerC71742() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetAuthLanding.access$onRegisterPressed(widgetAuthLanding, context);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$1 */
    public static final /* synthetic */ class C71751 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.ViewState, Unit> {
        public C71751(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "configureUI", "configureUI(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetAuthLanding.access$configureUI((WidgetAuthLanding) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$2 */
    public static final class ViewOnClickListenerC71762 implements View.OnClickListener {
        public static final ViewOnClickListenerC71762 INSTANCE = new ViewOnClickListenerC71762();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppScreen2.m157e(context, WidgetAuthLogin.class, null, 4);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$3 */
    public static final class ViewOnClickListenerC71773 implements View.OnClickListener {
        public ViewOnClickListenerC71773() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetAuthLanding.access$onRegisterPressed(widgetAuthLanding, context);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C71781 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.Event, Unit> {
        public C71781(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "handleEvent", "handleEvent(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetAuthLanding.access$handleEvent((WidgetAuthLanding) this.receiver, event);
        }
    }

    public WidgetAuthLanding() {
        super(C5419R.layout.widget_auth_landing);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthLanding3.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthLanding2.INSTANCE, null, 2, null);
        WidgetAuthLanding4 widgetAuthLanding4 = new WidgetAuthLanding4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAuthLandingViewModel.class), new WidgetAuthLanding$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetAuthLanding4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel.ViewState viewState) {
        widgetAuthLanding.configureUI(viewState);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel.Event event) {
        widgetAuthLanding.handleEvent(event);
    }

    public static final /* synthetic */ void access$onRegisterPressed(WidgetAuthLanding widgetAuthLanding, Context context) {
        widgetAuthLanding.onRegisterPressed(context);
    }

    private final void configureRegisterButton(String ageGateError) {
        if (ageGateError == null) {
            getBinding().f15678d.setOnClickListener(new ViewOnClickListenerC71742());
            return;
        }
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        HomeConfig homeConfig = (HomeConfig) serializableExtra;
        if (homeConfig != null && homeConfig.getAgeGated()) {
            WidgetAuthAgeGated.INSTANCE.start(requireContext(), ageGateError);
        }
        getBinding().f15678d.setOnClickListener(new ViewOnClickListenerC71731(ageGateError));
    }

    private final void configureUI(WidgetAuthLandingViewModel.ViewState viewState) {
        if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Empty) {
            WidgetAuthLandingBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            binding.f15675a.setBackgroundColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary));
            AppViewFlipper appViewFlipper = getBinding().f15679e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.authLandingSwitchFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().f15679e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.authLandingSwitchFlipper");
            appViewFlipper2.setDisplayedChild(1);
            if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Invite) {
                getBinding().f15676b.configureInvite(((WidgetAuthLandingViewModel.ViewState.Invite) viewState).getInvite());
            } else if (viewState instanceof WidgetAuthLandingViewModel.ViewState.GuildTemplate) {
                getBinding().f15676b.configureGuildTemplate(((WidgetAuthLandingViewModel.ViewState.GuildTemplate) viewState).getGuildTemplate());
            }
        }
        configureRegisterButton(viewState.getAgeGateError());
    }

    private final WidgetAuthLandingBinding getBinding() {
        return (WidgetAuthLandingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAuthLandingViewModel getViewModel() {
        return (WidgetAuthLandingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAuthLandingViewModel.Event event) {
        if (event instanceof WidgetAuthLandingViewModel.Event.SmartLockLogin) {
            GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = ((WidgetAuthLandingViewModel.Event.SmartLockLogin) event).getSmartLockCredentials();
            getViewModel().getGoogleSmartLockManager().getSmartLockRepo().setAttemptToSignInWithSmartLock(false);
            loginWithSmartLock(smartLockCredentials.getId(), smartLockCredentials.getPassword());
        }
    }

    private final void loginWithSmartLock(String id2, String password) {
        Bundle bundle = new Bundle();
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID, id2);
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD, password);
        AppScreen2.m156d(requireContext(), WidgetAuthLogin.class, new Intent().putExtras(bundle));
    }

    private final void onRegisterPressed(Context context) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setRegistering(true);
        companion.getINSTANCE().clear();
        AppScreen2.m157e(context, WidgetAuthRegisterIdentity.class, null, 4);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4009) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71751(this), 62, (Object) null);
        getBinding().f15677c.setOnClickListener(ViewOnClickListenerC71762.INSTANCE);
        getBinding().f15678d.setOnClickListener(new ViewOnClickListenerC71773());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71781(this), 62, (Object) null);
        GrowthTeamFeatures.INSTANCE.imbalancedAndroidSplashNoop();
    }
}
