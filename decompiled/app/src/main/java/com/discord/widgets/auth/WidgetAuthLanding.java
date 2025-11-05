package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthLanding.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthLanding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthLanding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLandingBinding;", 0)};
    private static final int VIEW_INDEX_HAS_INVITE = 1;
    private static final int VIEW_INDEX_NO_INVITE = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $ageGateError;

        public AnonymousClass1(String str) {
            this.$ageGateError = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthAgeGated.INSTANCE.start(outline.x(view, "it", "it.context"), this.$ageGateError);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$configureRegisterButton$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
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
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "configureUI", "configureUI(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetAuthLanding.access$configureUI((WidgetAuthLanding) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppScreen2.e(context, WidgetAuthLogin.class, null, 4);
        }
    }

    /* compiled from: WidgetAuthLanding.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
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
    /* renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetAuthLandingViewModel.Event, Unit> {
        public AnonymousClass1(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "handleEvent", "handleEvent(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetAuthLanding.access$handleEvent((WidgetAuthLanding) this.receiver, event);
        }
    }

    public WidgetAuthLanding() {
        super(R.layout.widget_auth_landing);
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
            getBinding().d.setOnClickListener(new AnonymousClass2());
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
        getBinding().d.setOnClickListener(new AnonymousClass1(ageGateError));
    }

    private final void configureUI(WidgetAuthLandingViewModel.ViewState viewState) {
        if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Empty) {
            WidgetAuthLandingBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            binding.a.setBackgroundColor(ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary));
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.authLandingSwitchFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.authLandingSwitchFlipper");
            appViewFlipper2.setDisplayedChild(1);
            if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Invite) {
                getBinding().f2231b.configureInvite(((WidgetAuthLandingViewModel.ViewState.Invite) viewState).getInvite());
            } else if (viewState instanceof WidgetAuthLandingViewModel.ViewState.GuildTemplate) {
                getBinding().f2231b.configureGuildTemplate(((WidgetAuthLandingViewModel.ViewState.GuildTemplate) viewState).getGuildTemplate());
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
        AppScreen2.d(requireContext(), WidgetAuthLogin.class, new Intent().putExtras(bundle));
    }

    private final void onRegisterPressed(Context context) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setRegistering(true);
        companion.getINSTANCE().clear();
        AppScreen2.e(context, WidgetAuthRegisterIdentity.class, null, 4);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        getBinding().c.setOnClickListener(AnonymousClass2.INSTANCE);
        getBinding().d.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        GrowthTeamFeatures.INSTANCE.imbalancedAndroidSplashNoop();
    }
}
