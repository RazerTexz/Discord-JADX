package com.discord.widgets.settings.account;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountChangePassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAccountChangePassword.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountChangePassword.access$saveNewPassword(WidgetSettingsAccountChangePassword.this, this.$meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordNewPasswordInput");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountChangePassword.this.getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountChangePassword.access$configureUI(WidgetSettingsAccountChangePassword.this, meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountChangePassword.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$saveNewPassword$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<User> {
        public final /* synthetic */ String $newPasswordText;

        public AnonymousClass1(String str) {
            this.$newPasswordText = str;
        }

        @Override // rx.functions.Action1
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
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$saveNewPassword$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetSettingsAccountChangePassword.this.getBinding().e.setIsLoading(false);
            WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword = WidgetSettingsAccountChangePassword.this;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            WidgetSettingsAccountChangePassword.access$handleError(widgetSettingsAccountChangePassword, error);
        }
    }

    public WidgetSettingsAccountChangePassword() {
        super(R.layout.widget_settings_account_change_password);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountChangePassword2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.change_password_new_password_input);
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
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.changePasswordTwoFactorTitle");
        textView.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        if (meUser.getMfaEnabled()) {
            ValidationManager validationManager = getValidationManager();
            TextInputLayout textInputLayout2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordTwoFactor");
            validationManager.addInput(new Input.TextInputLayoutInput(MFA_FIELD, textInputLayout2, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.two_fa_token_required)));
        } else {
            getValidationManager().removeInput(MFA_FIELD);
        }
        getBinding().e.setOnClickListener(new AnonymousClass1(meUser));
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
                TextInputLayout textInputLayout = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordTwoFactor");
                textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            } else {
                textOrEmpty = null;
            }
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordCurrentPasswordInput");
            String textOrEmpty2 = ViewExtensions.getTextOrEmpty(textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordNewPasswordInput");
            String textOrEmpty3 = ViewExtensions.getTextOrEmpty(textInputLayout3);
            RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, textOrEmpty2, textOrEmpty3, null, StoreStream.INSTANCE.getNotifications().getPushToken(), textOrEmpty, null, null, null, 1831, null);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            getBinding().e.setIsLoading(true);
            ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(userInfo), false, 1, null), this, null, 2, null), getBinding().h, 0L, 2, null).k(o.h(new AnonymousClass1(textOrEmpty3), requireContext(), new AnonymousClass2()));
        }
    }

    public final WidgetSettingsAccountChangePasswordBinding getBinding() {
        return (WidgetSettingsAccountChangePasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void onChangePasswordSuccess() {
        AppToast.i(this, R.string.saved_settings, 0, 4);
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
        getBinding().e.setIsLoading(false);
        getBinding().e.setText(getText(R.string.change_password));
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass2());
        TextInputLayout textInputLayout3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.changePasswordTwoFactor");
        ViewExtensions.addBindedTextWatcher(textInputLayout3, this, new AnonymousClass3());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
