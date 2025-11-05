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
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.auth.WidgetAuthMfa;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthLogin.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthLogin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLoginBinding;", 0)};
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID = "smartlock_extra_id";
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD = "smartlock_extra_password";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaForgotPasswordLauncher;
    private final ActivityResultLauncher<Intent> captchaLoginLauncher;
    public GoogleSmartLockManager googleSmartLockManager;
    private final LoggingConfig loggingConfig;
    private final ActivityResultLauncher<Intent> phoneVerifyLoginLauncher;
    private final ActivityResultLauncher<Intent> phoneVerifyPasswordLauncher;
    private GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;
    private final ActivityResultLauncher<Intent> undeleteAccountLauncher;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetAuthLogin.access$showEmailSentToast(WidgetAuthLogin.this, this.$login);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() != 70007) {
                ValidationManager validationManagerAccess$getValidationManager$p = WidgetAuthLogin.access$getValidationManager$p(WidgetAuthLogin.this);
                Error.Response response2 = error.getResponse();
                m.checkNotNullExpressionValue(response2, "error.response");
                Map<String, List<String>> messages = response2.getMessages();
                m.checkNotNullExpressionValue(messages, "error.response.messages");
                WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(WidgetAuthLogin.this.requireContext(), WidgetAuthLogin.access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin.this), u.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
                error.setShowErrorToasts(!r0.isEmpty());
                return;
            }
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = WidgetAuthLogin.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p = WidgetAuthLogin.access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin.this);
            String str = this.$login;
            String string = WidgetAuthLogin.this.getString(R.string.password_recovery_verify_phone_title);
            m.checkNotNullExpressionValue(string, "getString(R.string.passw…overy_verify_phone_title)");
            String string2 = WidgetAuthLogin.this.getString(R.string.password_recovery_verify_phone_subtitle);
            m.checkNotNullExpressionValue(string2, "getString(R.string.passw…ry_verify_phone_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p, str, string, string2);
            error.setShowErrorToasts(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelLoginResult, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, Context context) {
            super(1);
            this.$id = str;
            this.$password = str2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            m.checkNotNullParameter(modelLoginResult, "it");
            WidgetAuthLogin.access$onLoginSuccess(WidgetAuthLogin.this, this.$id, this.$password);
            if (!modelLoginResult.getMfa()) {
                AnalyticsTracker.INSTANCE.loginAttempt(true);
                return;
            }
            WidgetAuthMfa.Companion companion = WidgetAuthMfa.INSTANCE;
            Context context = this.$context;
            String ticket = modelLoginResult.getTicket();
            m.checkNotNull(ticket);
            companion.start(context, ticket);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$id = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetAuthLogin.access$handleError(WidgetAuthLogin.this, error, this.$id);
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelInvite, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.loginViewed(modelInvite);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<TextView, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "it");
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.forgotPassword$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {

        /* compiled from: WidgetAuthLogin.kt */
        /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                try {
                    view.getContext().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
                } catch (ActivityNotFoundException unused) {
                    b.a.d.m.g(view.getContext(), R.string.password_manager_open_settings_error, 0, null, 12);
                }
            }
        }

        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(WidgetAuthLogin.this.requireContext()).setTitle(R.string.password_manager).setMessage(R.string.password_manager_info_android).setPositiveButton(R.string.password_manager_open_settings, AnonymousClass1.INSTANCE), R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetAuthLogin.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends o implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(StorePhone storePhone) {
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
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$9, reason: invalid class name */
    public static final class AnonymousClass9 extends o implements Function1<PhoneCountryCode, Unit> {
        public AnonymousClass9() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            m.checkNotNullParameter(phoneCountryCode, "it");
            WidgetAuthLogin.access$getBinding$p(WidgetAuthLogin.this).e.setCountryCode(phoneCountryCode);
        }
    }

    public WidgetAuthLogin() {
        super(R.layout.widget_auth_login);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthLogin$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthLogin$binding$2.INSTANCE, null, 2, null);
        WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
        this.captchaForgotPasswordLauncher = companion.registerForResult(this, new WidgetAuthLogin$captchaForgotPasswordLauncher$1(this));
        this.captchaLoginLauncher = companion.registerForResult(this, new WidgetAuthLogin$captchaLoginLauncher$1(this));
        WidgetAuthPhoneVerify.Companion companion2 = WidgetAuthPhoneVerify.INSTANCE;
        this.phoneVerifyLoginLauncher = companion2.registerForResult(this, new WidgetAuthLogin$phoneVerifyLoginLauncher$1(this));
        this.phoneVerifyPasswordLauncher = companion2.registerForResult(this, new WidgetAuthLogin$phoneVerifyPasswordLauncher$1(this));
        this.undeleteAccountLauncher = WidgetAuthUndeleteAccount.INSTANCE.registerForResult(this, new WidgetAuthLogin$undeleteAccountLauncher$1(this));
        this.validationManager = g.lazy(new WidgetAuthLogin$validationManager$2(this));
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
        String textOrEmpty = getBinding().e.getTextOrEmpty();
        if (textOrEmpty.length() == 0) {
            b.a.d.m.g(getContext(), R.string.login_required, 0, null, 12);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui(StoreStream.INSTANCE.getAuthentication().forgotPassword(textOrEmpty, captchaPayload)), getBinding().h, 0L, 2, null), getContext(), "REST: forgotPassword", (Function1) null, new AnonymousClass1(textOrEmpty), new AnonymousClass2(textOrEmpty), (Function0) null, (Function0) null, 100, (Object) null);
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
        m.checkNotNullExpressionValue(response, "error.response");
        boolean z2 = response.getCode() == 20011;
        boolean z3 = response.getCode() == 20013;
        boolean z4 = response.getCode() == 70007;
        if (response.getCode() == 50035) {
            if (login == null || this.smartLockCredentials == null) {
                return;
            }
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onSmartLockCredentialsFailed();
            GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
            if (googleSmartLockManager2 == null) {
                m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager2.deleteCredentials(login);
            this.smartLockCredentials = null;
            GoogleSmartLockManagerKt.clearSmartLockCredentials(getMostRecentIntent());
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
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            String string = getString(R.string.phone_ip_authorization_title);
            m.checkNotNullExpressionValue(string, "getString(R.string.phone_ip_authorization_title)");
            String string2 = getString(R.string.phone_ip_authorization_subtitle);
            m.checkNotNullExpressionValue(string2, "getString(R.string.phone…p_authorization_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncher, textOrEmpty, string, string2);
            return;
        }
        Error.Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getMessages().isEmpty()) {
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "errorResponse.messages");
        WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(requireContext(), this.captchaLoginLauncher, u.toMutableList((Collection) validationManager.setErrors(messages)), error);
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
        if (savedLogin == null || !(!t.isBlank(savedLogin))) {
            getBinding().e.requestFocus();
        } else {
            getBinding().e.setText(savedLogin);
            getBinding().g.requestFocus();
        }
    }

    private final void login(CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            TextInputLayout textInputLayout = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
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
        if (GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent())) {
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                m.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onLoginWithSmartLockSuccess();
        }
        GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
        if (googleSmartLockManager2 == null) {
            m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        googleSmartLockManager2.saveCredentials(id2, password);
    }

    private final void showEmailSentToast(String email) {
        b.a.d.m.h(getContext(), b.h(requireContext(), R.string.email_verification_instructions_body, new Object[]{email}, null, 4), 0, null, 12);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
        if (googleSmartLockManager == null) {
            m.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        return googleSmartLockManager;
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
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
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.googleSmartLockManager = new GoogleSmartLockManager(fragmentActivityRequireActivity, null, 2, null);
        this.smartLockCredentials = GoogleSmartLockManagerKt.toSmartLockCredentials(getMostRecentIntent());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthLogin.class, AnonymousClass1.INSTANCE);
        loadCachedLogin();
        getBinding().f2232b.setOnClickListener(new AnonymousClass2());
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass3(), 1, null);
        getBinding().d.setOnClickListener(new AnonymousClass4());
        getBinding().f.setOnClickListener(new AnonymousClass5());
        getBinding().c.setOnClickListener(new AnonymousClass6());
        getBinding().e.b(this);
        GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
        if (smartLockCredentials != null) {
            getBinding().e.setText(smartLockCredentials.getId());
            TextInputLayout textInputLayout2 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.authLoginPasswordWrap");
            ViewExtensions.setText(textInputLayout2, smartLockCredentials.getPassword());
            login$default(this, null, false, 3, null);
        }
        StorePhone phone = companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass8(phone), 14, null), this, null, 2, null), WidgetAuthLogin.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass9(), 62, (Object) null);
    }

    public final void setGoogleSmartLockManager(GoogleSmartLockManager googleSmartLockManager) {
        m.checkNotNullParameter(googleSmartLockManager, "<set-?>");
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
            m.checkNotNullExpressionValue(context, "context ?: return");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().login(id2, password, captchaPayload, undelete, GoogleSmartLockManagerKt.hasSmartLockCredentials(getMostRecentIntent()) ? RestAPIParams.AuthLogin.LoginSource.LOGIN_SOURCE_KEYCHAIN_AUTO : null), this, null, 2, null), getBinding().h, 0L, 2, null), context, "REST: login", (Function1) null, new AnonymousClass1(id2, password, context), new AnonymousClass2(id2), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }
}
