package com.discord.widgets.settings.account;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* compiled from: WidgetSettingsAccountChangePassword.kt */
/* loaded from: classes2.dex */
public class WidgetSettingsAccountChangePassword extends AppFragment {
    public static final String CURRENT_PASSWORD_FIELD = "password";
    public static final String MFA_FIELD = "mfa";
    public static final String NEW_PASSWORD_FIELD = "new_password";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GoogleSmartLockManager googleSmartLockManager;
    private final StatefulViews state;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAccountChangePassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsAccountChangePassword.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$configureUI$1 */
    public static final class ViewOnClickListenerC97421 implements View.OnClickListener {
        public final /* synthetic */ MeUser $meUser;

        public ViewOnClickListenerC97421(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountChangePassword.access$saveNewPassword(WidgetSettingsAccountChangePassword.this, this.$meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$1 */
    public static final class C97431 extends Lambda implements Function1<Editable, Unit> {
        public C97431() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17820c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$2 */
    public static final class C97442 extends Lambda implements Function1<Editable, Unit> {
        public C97442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17821d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordNewPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$3 */
    public static final class C97453 extends Lambda implements Function1<Editable, Unit> {
        public C97453() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f17823f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBoundOrOnResume$1 */
    public static final class C97461 extends Lambda implements Function1<MeUser, Unit> {
        public C97461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountChangePassword.access$configureUI(WidgetSettingsAccountChangePassword.this, meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$saveNewPassword$1 */
    public static final class C97471<T> implements Action1<User> {
        public final /* synthetic */ String $newPasswordText;

        public C97471(String str) {
            this.$newPasswordText = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(User user) {
            call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(User user) {
            GoogleSmartLockManager googleSmartLockManager;
            Context context = WidgetSettingsAccountChangePassword.this.getContext();
            if (context != null && (googleSmartLockManager = GoogleSmartLockManager3.googleSmartLockManager(context)) != null) {
                googleSmartLockManager.updateAccountInfo(null, this.$newPasswordText);
            }
            StoreStream.INSTANCE.getAuthentication().onPasswordChanged(user.getToken());
            WidgetSettingsAccountChangePassword.this.onChangePasswordSuccess();
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$saveNewPassword$2 */
    public static final class C97482<T> implements Action1<Error> {
        public C97482() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetSettingsAccountChangePassword.this.getBinding().f17822e.setIsLoading(false);
            WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword = WidgetSettingsAccountChangePassword.this;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            WidgetSettingsAccountChangePassword.access$handleError(widgetSettingsAccountChangePassword, error);
        }
    }

    public WidgetSettingsAccountChangePassword() {
        super(C5419R.layout.widget_settings_account_change_password);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountChangePassword2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.change_password_new_password_input);
        this.validationManager = LazyJVM.lazy(new WidgetSettingsAccountChangePassword3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, MeUser meUser) {
        widgetSettingsAccountChangePassword.configureUI(meUser);
    }

    public static final /* synthetic */ void access$handleError(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, Error error) {
        widgetSettingsAccountChangePassword.handleError(error);
    }

    public static final /* synthetic */ void access$saveNewPassword(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, MeUser meUser) {
        widgetSettingsAccountChangePassword.saveNewPassword(meUser);
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().f17824g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.changePasswordTwoFactorTitle");
        textView.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f17823f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        if (meUser.getMfaEnabled()) {
            ValidationManager validationManager = getValidationManager();
            TextInputLayout textInputLayout2 = getBinding().f17823f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordTwoFactor");
            validationManager.addInput(new Input.TextInputLayoutInput(MFA_FIELD, textInputLayout2, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.two_fa_token_required)));
        } else {
            getValidationManager().removeInput(MFA_FIELD);
        }
        getBinding().f17822e.setOnClickListener(new ViewOnClickListenerC97421(meUser));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error) {
        ValidationManager validationManager = getValidationManager();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        int size = validationManager.setErrors(messages).size();
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        error.setShowErrorToasts(!(size < response2.getMessages().size()));
    }

    private final void saveNewPassword(MeUser meUser) {
        String textOrEmpty;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            if (meUser.getMfaEnabled()) {
                TextInputLayout textInputLayout = getBinding().f17823f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
                textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            } else {
                textOrEmpty = null;
            }
            TextInputLayout textInputLayout2 = getBinding().f17820c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordCurrentPasswordInput");
            String textOrEmpty2 = ViewExtensions.getTextOrEmpty(textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().f17821d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordNewPasswordInput");
            String textOrEmpty3 = ViewExtensions.getTextOrEmpty(textInputLayout3);
            RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, textOrEmpty2, textOrEmpty3, null, StoreStream.INSTANCE.getNotifications().getPushToken(), textOrEmpty, null, null, null, 1831, null);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            getBinding().f17822e.setIsLoading(true);
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(userInfo), false, 1, null), this, null, 2, null), getBinding().f17825h, 0L, 2, null).m11108k(C0879o.m181h(new C97471(textOrEmpty3), requireContext(), new C97482()));
        }
    }

    public final WidgetSettingsAccountChangePasswordBinding getBinding() {
        return (WidgetSettingsAccountChangePasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void onChangePasswordSuccess() {
        AppToast.m171i(this, C5419R.string.saved_settings, 0, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        this.googleSmartLockManager = new GoogleSmartLockManager(context, null, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        getBinding().f17822e.setIsLoading(false);
        getBinding().f17822e.setText(getText(C5419R.string.change_password));
        TextInputLayout textInputLayout = getBinding().f17820c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C97431());
        TextInputLayout textInputLayout2 = getBinding().f17821d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C97442());
        TextInputLayout textInputLayout3 = getBinding().f17823f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordTwoFactor");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new C97453());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97461(), 62, (Object) null);
    }
}
