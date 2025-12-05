package com.discord.widgets.auth;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.auth.WidgetAuthMfa;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthLogin.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthLogin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLoginBinding;", 0)};
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID = "smartlock_extra_id";
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD = "smartlock_extra_password";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaForgotPasswordLauncher;
    private final ActivityResultLauncher<Intent> captchaLoginLauncher;
    public GoogleSmartLockManager googleSmartLockManager;
    private final AppLogger2 loggingConfig;
    private final ActivityResultLauncher<Intent> phoneVerifyLoginLauncher;
    private final ActivityResultLauncher<Intent> phoneVerifyPasswordLauncher;
    private GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;
    private final ActivityResultLauncher<Intent> undeleteAccountLauncher;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$1 */
    public static final class C71821 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71821(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetAuthLogin.access$showEmailSentToast(WidgetAuthLogin.this, this.$login);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$2 */
    public static final class C71832 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71832(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() != 70007) {
                ValidationManager validationManagerAccess$getValidationManager$p = WidgetAuthLogin.access$getValidationManager$p(WidgetAuthLogin.this);
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                Map<String, List<String>> messages = response2.getMessages();
                Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
                WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(WidgetAuthLogin.this.requireContext(), WidgetAuthLogin.access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin.this), _Collections.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
                error.setShowErrorToasts(!r0.isEmpty());
                return;
            }
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = WidgetAuthLogin.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p = WidgetAuthLogin.access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin.this);
            String str = this.$login;
            String string = WidgetAuthLogin.this.getString(C5419R.string.password_recovery_verify_phone_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.passw…overy_verify_phone_title)");
            String string2 = WidgetAuthLogin.this.getString(C5419R.string.password_recovery_verify_phone_subtitle);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.passw…ry_verify_phone_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p, str, string, string2);
            error.setShowErrorToasts(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$1 */
    public static final class C71841 extends Lambda implements Function1<ModelLoginResult, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71841(String str, String str2, Context context) {
            super(1);
            this.$id = str;
            this.$password = str2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            Intrinsics3.checkNotNullParameter(modelLoginResult, "it");
            WidgetAuthLogin.access$onLoginSuccess(WidgetAuthLogin.this, this.$id, this.$password);
            if (!modelLoginResult.getMfa()) {
                AnalyticsTracker.INSTANCE.loginAttempt(true);
                return;
            }
            WidgetAuthMfa.Companion companion = WidgetAuthMfa.INSTANCE;
            Context context = this.$context;
            String ticket = modelLoginResult.getTicket();
            Intrinsics3.checkNotNull(ticket);
            companion.start(context, ticket);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$2 */
    public static final class C71852 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71852(String str) {
            super(1);
            this.$id = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetAuthLogin.access$handleError(WidgetAuthLogin.this, error, this.$id);
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$1 */
    public static final class C71861 extends Lambda implements Function1<ModelInvite, Unit> {
        public static final C71861 INSTANCE = new C71861();

        public C71861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.loginViewed(modelInvite);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$2 */
    public static final class ViewOnClickListenerC71872 implements View.OnClickListener {
        public ViewOnClickListenerC71872() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$3 */
    public static final class C71883 extends Lambda implements Function1<TextView, Unit> {
        public C71883() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$4 */
    public static final class ViewOnClickListenerC71894 implements View.OnClickListener {
        public ViewOnClickListenerC71894() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.forgotPassword$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5 */
    public static final class ViewOnClickListenerC71905 implements View.OnClickListener {

        /* compiled from: WidgetAuthLogin.kt */
        /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                try {
                    view.getContext().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
                } catch (ActivityNotFoundException unused) {
                    AppToast.m169g(view.getContext(), C5419R.string.password_manager_open_settings_error, 0, null, 12);
                }
            }
        }

        public ViewOnClickListenerC71905() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(WidgetAuthLogin.this.requireContext()).setTitle(C5419R.string.password_manager).setMessage(C5419R.string.password_manager_info_android).setPositiveButton(C5419R.string.password_manager_open_settings, AnonymousClass1.INSTANCE), C5419R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetAuthLogin.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$6 */
    public static final class ViewOnClickListenerC71916 implements View.OnClickListener {
        public ViewOnClickListenerC71916() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$8 */
    public static final class C71928 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71928(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PhoneCountryCode invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$9 */
    public static final class C71939 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public C71939() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            WidgetAuthLogin.access$getBinding$p(WidgetAuthLogin.this).f15684e.setCountryCode(phoneCountryCode);
        }
    }

    public WidgetAuthLogin() {
        super(C5419R.layout.widget_auth_login);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthLogin5.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthLogin2.INSTANCE, null, 2, null);
        WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
        this.captchaForgotPasswordLauncher = companion.registerForResult(this, new WidgetAuthLogin3(this));
        this.captchaLoginLauncher = companion.registerForResult(this, new WidgetAuthLogin4(this));
        WidgetAuthPhoneVerify.Companion companion2 = WidgetAuthPhoneVerify.INSTANCE;
        this.phoneVerifyLoginLauncher = companion2.registerForResult(this, new WidgetAuthLogin6(this));
        this.phoneVerifyPasswordLauncher = companion2.registerForResult(this, new WidgetAuthLogin7(this));
        this.undeleteAccountLauncher = WidgetAuthUndeleteAccount.INSTANCE.registerForResult(this, new WidgetAuthLogin8(this));
        this.validationManager = LazyJVM.lazy(new WidgetAuthLogin9(this));
    }

    public static final /* synthetic */ void access$forgotPassword(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetAuthLogin.forgotPassword(captchaPayload);
    }

    public static final /* synthetic */ WidgetAuthLoginBinding access$getBinding$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.captchaForgotPasswordLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.phoneVerifyPasswordLauncher;
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getValidationManager();
    }

    public static final /* synthetic */ void access$handleError(WidgetAuthLogin widgetAuthLogin, Error error, String str) {
        widgetAuthLogin.handleError(error, str);
    }

    public static final /* synthetic */ void access$onLoginSuccess(WidgetAuthLogin widgetAuthLogin, String str, String str2) {
        widgetAuthLogin.onLoginSuccess(str, str2);
    }

    public static final /* synthetic */ void access$showEmailSentToast(WidgetAuthLogin widgetAuthLogin, String str) {
        widgetAuthLogin.showEmailSentToast(str);
    }

    private final void forgotPassword(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
        if (textOrEmpty.length() == 0) {
            AppToast.m169g(getContext(), C5419R.string.login_required, 0, null, 12);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.m8518ui(StoreStream.INSTANCE.getAuthentication().forgotPassword(textOrEmpty, captchaPayload)), getBinding().f15687h, 0L, 2, null), getContext(), "REST: forgotPassword", (Function1) null, new C71821(textOrEmpty), new C71832(textOrEmpty), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }

    public static /* synthetic */ void forgotPassword$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthLogin.forgotPassword(captchaPayload);
    }

    private final WidgetAuthLoginBinding getBinding() {
        return (WidgetAuthLoginBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error, String login) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        boolean z2 = response.getCode() == 20011;
        boolean z3 = response.getCode() == 20013;
        boolean z4 = response.getCode() == 70007;
        if (response.getCode() == 50035) {
            if (login == null || this.smartLockCredentials == null) {
                return;
            }
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onSmartLockCredentialsFailed();
            GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
            if (googleSmartLockManager2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager2.deleteCredentials(login);
            this.smartLockCredentials = null;
            GoogleSmartLockManager3.clearSmartLockCredentials(getMostRecentIntent());
            return;
        }
        if (z2) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, false);
            return;
        }
        if (z3) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, true);
            return;
        }
        if (z4) {
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.phoneVerifyLoginLauncher;
            String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
            String string = getString(C5419R.string.phone_ip_authorization_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.phone_ip_authorization_title)");
            String string2 = getString(C5419R.string.phone_ip_authorization_subtitle);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.phone…p_authorization_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncher, textOrEmpty, string, string2);
            return;
        }
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getMessages().isEmpty()) {
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "errorResponse.messages");
        WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(requireContext(), this.captchaLoginLauncher, _Collections.toMutableList((Collection) validationManager.setErrors(messages)), error);
        error.setShowErrorToasts(!r13.isEmpty());
    }

    public static /* synthetic */ void handleError$default(WidgetAuthLogin widgetAuthLogin, Error error, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetAuthLogin.handleError(error, str);
    }

    private final void loadCachedLogin() {
        String savedLogin = StoreStream.INSTANCE.getAuthentication().getSavedLogin();
        if (savedLogin == null || !(!StringsJVM.isBlank(savedLogin))) {
            getBinding().f15684e.requestFocus();
        } else {
            getBinding().f15684e.setText(savedLogin);
            getBinding().f15686g.requestFocus();
        }
    }

    private final void login(CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            String textOrEmpty = getBinding().f15684e.getTextOrEmpty();
            TextInputLayout textInputLayout = getBinding().f15686g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
            login(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout), captchaPayload, undelete);
        }
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(captchaPayload, z2);
    }

    private final void onLoginSuccess(String id2, String password) {
        if (GoogleSmartLockManager3.hasSmartLockCredentials(getMostRecentIntent())) {
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onLoginWithSmartLockSuccess();
        }
        GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
        if (googleSmartLockManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        googleSmartLockManager2.saveCredentials(id2, password);
    }

    private final void showEmailSentToast(String email) {
        AppToast.m170h(getContext(), FormatUtils.m216h(requireContext(), C5419R.string.email_verification_instructions_body, new Object[]{email}, null, 4), 0, null, 12);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
        if (googleSmartLockManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        return googleSmartLockManager;
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setRegistering(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.googleSmartLockManager = new GoogleSmartLockManager(fragmentActivityRequireActivity, null, 2, null);
        this.smartLockCredentials = GoogleSmartLockManager3.toSmartLockCredentials(getMostRecentIntent());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthLogin.class, C71861.INSTANCE);
        loadCachedLogin();
        getBinding().f15681b.setOnClickListener(new ViewOnClickListenerC71872());
        TextInputLayout textInputLayout = getBinding().f15686g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C71883(), 1, null);
        getBinding().f15683d.setOnClickListener(new ViewOnClickListenerC71894());
        getBinding().f15685f.setOnClickListener(new ViewOnClickListenerC71905());
        getBinding().f15682c.setOnClickListener(new ViewOnClickListenerC71916());
        getBinding().f15684e.m8600b(this);
        GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
        if (smartLockCredentials != null) {
            getBinding().f15684e.setText(smartLockCredentials.getId());
            TextInputLayout textInputLayout2 = getBinding().f15686g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authLoginPasswordWrap");
            ViewExtensions.setText(textInputLayout2, smartLockCredentials.getPassword());
            login$default(this, null, false, 3, null);
        }
        StorePhone phone = companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new C71928(phone), 14, null), this, null, 2, null), WidgetAuthLogin.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71939(), 62, (Object) null);
    }

    public final void setGoogleSmartLockManager(GoogleSmartLockManager googleSmartLockManager) {
        Intrinsics3.checkNotNullParameter(googleSmartLockManager, "<set-?>");
        this.googleSmartLockManager = googleSmartLockManager;
    }

    public final void setSmartLockCredentials(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
        this.smartLockCredentials = smartLockCredentials;
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(str, str2, captchaPayload, z2);
    }

    private final void login(String id2, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().login(id2, password, captchaPayload, undelete, GoogleSmartLockManager3.hasSmartLockCredentials(getMostRecentIntent()) ? RestAPIParams.AuthLogin.LoginSource.LOGIN_SOURCE_KEYCHAIN_AUTO : null), this, null, 2, null), getBinding().f15687h, 0L, 2, null), context, "REST: login", (Function1) null, new C71841(id2, password, context), new C71852(id2), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }
}
