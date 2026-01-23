package com.discord.widgets.auth;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.auth.RegisterResponse;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthRegisterAccountInformationBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthRegisterAccountInformation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterAccountInformationBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> birthdayLauncher;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private boolean isConsentRequired;
    private final AppLogger2 loggingConfig;
    private boolean shouldShowAgeGate;
    private boolean shouldValidateInputs;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$configureUI$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72201 extends Lambda implements Function1<TextView, Unit> {
        public C72201() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetAuthRegisterAccountInformation.register$default(WidgetAuthRegisterAccountInformation.this, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$configureUI$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class ViewOnClickListenerC72212 implements View.OnClickListener {
        public ViewOnClickListenerC72212() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthRegisterAccountInformation.register$default(WidgetAuthRegisterAccountInformation.this, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72221 extends Lambda implements Function1<Editable, Unit> {
        public C72221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            RegistrationFlowRepo instance = RegistrationFlowRepo.INSTANCE.getINSTANCE();
            TextInputLayout textInputLayout = WidgetAuthRegisterAccountInformation.access$getBinding$p(WidgetAuthRegisterAccountInformation.this).f15706e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
            instance.setUsername(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72232 extends Lambda implements Function1<Editable, Unit> {
        public C72232() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            RegistrationFlowRepo instance = RegistrationFlowRepo.INSTANCE.getINSTANCE();
            TextInputLayout textInputLayout = WidgetAuthRegisterAccountInformation.access$getBinding$p(WidgetAuthRegisterAccountInformation.this).f15705d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationPasswordWrap");
            instance.setPassword(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$register$1 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72241 extends Lambda implements Function1<RegisterResponse, Unit> {
        public static final C72241 INSTANCE = new C72241();

        public C72241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RegisterResponse registerResponse) {
            invoke2(registerResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RegisterResponse registerResponse) {
            Intrinsics3.checkNotNullParameter(registerResponse, "it");
            AnalyticsTracker.INSTANCE.registered(true);
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Information", "success", null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$register$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72252 extends Lambda implements Function1<Error, Unit> {
        public C72252() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            AnalyticsTracker.INSTANCE.registered(false);
            WidgetAuthRegisterAccountInformation.access$getBinding$p(WidgetAuthRegisterAccountInformation.this).f15704c.setIsLoading(false);
            WidgetAuthRegisterAccountInformation.access$handleError(WidgetAuthRegisterAccountInformation.this, error);
        }
    }

    public WidgetAuthRegisterAccountInformation() {
        super(C5419R.layout.widget_auth_register_account_information);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthRegisterAccountInformation5.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthRegisterAccountInformation2.INSTANCE, null, 2, null);
        this.shouldValidateInputs = true;
        this.shouldShowAgeGate = true;
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetAuthRegisterAccountInformation4(this));
        this.birthdayLauncher = WidgetAuthBirthday.INSTANCE.registerForResult(this, new WidgetAuthRegisterAccountInformation3(this));
        this.validationManager = LazyJVM.lazy(new WidgetAuthRegisterAccountInformation6(this));
    }

    public static final /* synthetic */ WidgetAuthRegisterAccountInformationBinding access$getBinding$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        return widgetAuthRegisterAccountInformation.getBinding();
    }

    public static final /* synthetic */ void access$handleError(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, Error error) {
        widgetAuthRegisterAccountInformation.handleError(error);
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        return widgetAuthRegisterAccountInformation.isConsentRequired;
    }

    public static final /* synthetic */ void access$register(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetAuthRegisterAccountInformation.register(captchaPayload);
    }

    public static final /* synthetic */ void access$setConsentRequired$p(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, boolean z2) {
        widgetAuthRegisterAccountInformation.isConsentRequired = z2;
    }

    private final void configureUI() {
        getBinding().f15706e.requestFocus();
        if (this.isConsentRequired) {
            TextInputLayout textInputLayout = getBinding().f15705d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationPasswordWrap");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setImeOptions(6);
            }
        } else {
            TextInputLayout textInputLayout2 = getBinding().f15705d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
            ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C72201(), 1, null);
        }
        getBinding().f15704c.setOnClickListener(new ViewOnClickListenerC72212());
        if (RegistrationFlowRepo.INSTANCE.getINSTANCE().getBirthday() == null && this.shouldShowAgeGate) {
            getBinding().f15704c.setText(getText(C5419R.string.next));
        } else {
            getBinding().f15704c.setText(getText(C5419R.string.register));
        }
    }

    private final WidgetAuthRegisterAccountInformationBinding getBinding() {
        return (WidgetAuthRegisterAccountInformationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        if (messages.containsKey(BirthdayHelper.DATE_OF_BIRTH_KEY)) {
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Information", "response_error", CollectionsJVM.listOf(BirthdayHelper.DATE_OF_BIRTH_KEY));
            error.setShowErrorToasts(false);
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages2 = response2.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages2, "error.response.messages");
            List<String> listEmptyList = messages2.get(BirthdayHelper.DATE_OF_BIRTH_KEY);
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            Intrinsics3.checkNotNullExpressionValue(listEmptyList, "error.response.messages\n…IRTH_KEY) { emptyList() }");
            StoreStream.INSTANCE.getAuthentication().setAgeGateError(_Collections.joinToString$default(listEmptyList, "\n", null, null, 0, null, null, 62, null));
            AppScreen2.m154b(requireContext(), false, new Intent().putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(null, null, true, 3, null)));
            return;
        }
        Error.Response response3 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
        if (response3.getMessages().isEmpty()) {
            RegistrationFlowRepo instance = RegistrationFlowRepo.INSTANCE.getINSTANCE();
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "error.response");
            instance.trackTransition("Register", "response_error", Collections2.listOf((Object[]) new String[]{"connection_error", error.getType().toString(), String.valueOf(response4.getCode())}));
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response5 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response5, "error.response");
        Map<String, List<String>> messages3 = response5.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages3, "error.response.messages");
        List<String> mutableList = _Collections.toMutableList((Collection) validationManager.setErrors(messages3));
        Error.Response response6 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response6, "error.response");
        List<String> mutableList2 = _Collections.toMutableList((Collection) response6.getMessages().keySet());
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo instance2 = companion.getINSTANCE();
        Error.Response response7 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response7, "error.response");
        instance2.setErrors(response7.getMessages());
        WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(requireContext(), this.captchaLauncher, mutableList, error);
        if (mutableList.contains(NotificationCompat.CATEGORY_EMAIL)) {
            requireActivity().onBackPressed();
            mutableList.remove(NotificationCompat.CATEGORY_EMAIL);
            mutableList2.remove(NotificationCompat.CATEGORY_EMAIL);
        }
        companion.getINSTANCE().trackTransition("Account Information", "response_error", mutableList2);
        error.setShowErrorToasts(!mutableList.isEmpty());
    }

    private final boolean isConsented() {
        if (this.isConsentRequired) {
            MaterialCheckBox materialCheckBox = getBinding().f15707f;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
            if (!materialCheckBox.isChecked()) {
                return false;
            }
        }
        return true;
    }

    private final void register(CaptchaHelper.CaptchaPayload captchaPayload) {
        if (this.shouldValidateInputs && !ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Information", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        if (companion.getINSTANCE().getBirthday() == null && this.shouldShowAgeGate) {
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Information", "success", null, 4, null);
            AnalyticsTracker.openModal$default("Enter Your Birthday", "Register", null, 4, null);
            WidgetAuthBirthday.INSTANCE.launch(requireContext(), this.birthdayLauncher);
            return;
        }
        String uTCDateTime = companion.getINSTANCE().getBirthday() != null ? TimeUtils.toUTCDateTime(companion.getINSTANCE().getBirthday(), TimeUtils.UTCFormat.SHORT) : null;
        getBinding().f15704c.setIsLoading(true);
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        TextInputLayout textInputLayout = getBinding().f15706e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        String email = companion.getINSTANCE().getEmail();
        String phoneToken = companion.getINSTANCE().getPhoneToken();
        TextInputLayout textInputLayout2 = getBinding().f15705d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(authentication.register(textOrEmpty, email, phoneToken, ViewExtensions.getTextOrEmpty(textInputLayout2), captchaPayload, isConsented(), uTCDateTime), this, null, 2, null), WidgetAuthRegisterAccountInformation.class, getContext(), (Function1) null, new C72252(), (Function0) null, (Function0) null, C72241.INSTANCE, 52, (Object) null);
    }

    public static /* synthetic */ void register$default(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthRegisterAccountInformation.register(captchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Information", "submitted", null, 4, null);
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        Experiment userExperiment = companion2.getExperiments().getUserExperiment("2021-01_android_registration_flow", true);
        this.shouldValidateInputs = (userExperiment == null || userExperiment.getBucket() != 1) && (userExperiment == null || userExperiment.getBucket() != 3);
        boolean z2 = (userExperiment == null || userExperiment.getBucket() != 2) && (userExperiment == null || userExperiment.getBucket() != 3);
        this.shouldShowAgeGate = z2;
        if (!z2) {
            this.isConsentRequired = companion2.getAuthentication().isConsentRequired();
        } else {
            this.isConsentRequired = false;
            LinkifiedTextView linkifiedTextView = getBinding().f15703b;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
            linkifiedTextView.setVisibility(8);
        }
        MaterialCheckBox materialCheckBox = getBinding().f15707f;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f15703b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.authPolicyLinks");
        FormatUtils.m222n(linkifiedTextView2, this.isConsentRequired ? C5419R.string.terms_privacy_opt_in : C5419R.string.terms_privacy, new Object[]{getString(C5419R.string.terms_of_service_url), getString(C5419R.string.privacy_policy_url)}, null, 4);
        getBinding().f15704c.setIsLoading(false);
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Information", "viewed", null, 4, null);
        TextInputLayout textInputLayout = getBinding().f15706e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        ViewExtensions.setText(textInputLayout, companion.getINSTANCE().getUsername());
        TextInputLayout textInputLayout2 = getBinding().f15705d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        ViewExtensions.setText(textInputLayout2, companion.getINSTANCE().getPassword());
        TextInputLayout textInputLayout3 = getBinding().f15706e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.authRegisterAccountInformationUsernameWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new C72221());
        TextInputLayout textInputLayout4 = getBinding().f15705d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.authRegisterAccountInformationPasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout4, this, new C72232());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Map<String, List<String>> errors = RegistrationFlowRepo.INSTANCE.getINSTANCE().getErrors();
        if (errors != null) {
            getValidationManager().setErrors(errors);
            Set<String> setKeySet = errors.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str = (String) next;
                if (!Intrinsics3.areEqual(str, "username") && !Intrinsics3.areEqual(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD)) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = _Collections.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Information", "response_error", list);
            }
        }
        configureUI();
    }
}
