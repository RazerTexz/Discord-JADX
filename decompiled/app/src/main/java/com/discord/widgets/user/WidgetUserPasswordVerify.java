package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserPasswordVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_ACTION = "INTENT_EXTRA_ACTION";
    private static final String INTENT_EXTRA_DISCRIMINATOR = "INTENT_EXTRA_DISCRIMINATOR";
    private static final String INTENT_EXTRA_EMAIL = "INTENT_EXTRA_EMAIL";
    private static final String INTENT_EXTRA_EMAIL_TOKEN = "INTENT_EXTRA_EMAIL_TOKEN";
    private static final String INTENT_EXTRA_PHONE_TOKEN = "INTENT_EXTRA_PHONE_TOKEN";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";
    private static final String INTENT_EXTRA_USERNAME = "INTENT_EXTRA_USERNAME";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
        public enum Action {
            UpdateAccountInfo,
            RemovePhoneNumber,
            UpdatePhoneNumber
        }

        private Companion() {
        }

        private final void launch(Context context, ActivityResultLauncher<Intent> launcher, Bundle extras) {
            AnalyticsTracker.openModal$default("Account Settings Password Verification", "", null, 4, null);
            AppScreen2.f524g.m160f(context, launcher, WidgetUserPasswordVerify.class, new Intent().putExtras(extras));
        }

        public static /* synthetic */ void launchUpdateAccountSettings$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, String str, String str2, String str3, String str4, int i, Object obj) {
            companion.launchUpdateAccountSettings(context, activityResultLauncher, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
        }

        public final void launchRemovePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.RemovePhoneNumber);
            launch(context, launcher, bundle);
        }

        public final void launchUpdateAccountSettings(Context context, ActivityResultLauncher<Intent> launcher, String email, String username, String discriminator, String email_token) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdateAccountInfo);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL, email);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_USERNAME, username);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_DISCRIMINATOR, discriminator);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL_TOKEN, email_token);
            launch(context, launcher, bundle);
        }

        public final void launchUpdatePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher, String phoneToken, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phoneToken, "phoneToken");
            Intrinsics3.checkNotNullParameter(source, "source");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdatePhoneNumber);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_PHONE_TOKEN, phoneToken);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            launch(context, launcher, bundle);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserPasswordVerify2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Companion.Action.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[Companion.Action.UpdateAccountInfo.ordinal()] = 1;
            iArr[Companion.Action.RemovePhoneNumber.ordinal()] = 2;
            iArr[Companion.Action.UpdatePhoneNumber.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102201 extends Lambda implements Function1<TextView, Unit> {
        public C102201() {
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
            WidgetUserPasswordVerify.access$saveInfo(WidgetUserPasswordVerify.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class ViewOnClickListenerC102212 implements View.OnClickListener {
        public ViewOnClickListenerC102212() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPasswordVerify.access$saveInfo(WidgetUserPasswordVerify.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$removePhoneNumber$1 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102221<T> implements Action1<Void> {
        public C102221() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$removePhoneNumber$2 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102232<T> implements Action1<Error> {
        public C102232() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updateAccountInfo$1 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102241<T> implements Action1<User> {
        public final /* synthetic */ String $newEmail;
        public final /* synthetic */ String $password;

        public C102241(String str, String str2) {
            this.$newEmail = str;
            this.$password = str2;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(User user) {
            call2(user);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(User user) {
            GoogleSmartLockManager googleSmartLockManager;
            StoreStream.INSTANCE.getAuthentication().setAuthed(user.getToken());
            Context context = WidgetUserPasswordVerify.this.getContext();
            if (context != null && (googleSmartLockManager = GoogleSmartLockManager3.googleSmartLockManager(context)) != null) {
                googleSmartLockManager.updateAccountInfo(this.$newEmail, this.$password);
            }
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updateAccountInfo$2 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102252<T> implements Action1<Error> {
        public C102252() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updatePhoneNumber$1 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102261<T> implements Action1<Void> {
        public C102261() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updatePhoneNumber$2 */
    /* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
    public static final class C102272<T> implements Action1<Error> {
        public C102272() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    public WidgetUserPasswordVerify() {
        super(C5419R.layout.widget_user_password_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPasswordVerify3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.edit_account_password_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetUserPasswordVerify4(this));
    }

    public static final /* synthetic */ void access$finishWithSuccess(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.finishWithSuccess();
    }

    public static final /* synthetic */ WidgetUserPasswordVerifyBinding access$getBinding$p(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        return widgetUserPasswordVerify.getBinding();
    }

    public static final /* synthetic */ boolean access$maybeHandleApiError(WidgetUserPasswordVerify widgetUserPasswordVerify, Error error) {
        return widgetUserPasswordVerify.maybeHandleApiError(error);
    }

    public static final /* synthetic */ void access$saveInfo(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.saveInfo();
    }

    private final void finishWithSuccess() {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppToast.m171i(this, C5419R.string.saved_settings, 0, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    private final WidgetUserPasswordVerifyBinding getBinding() {
        return (WidgetUserPasswordVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final boolean maybeHandleApiError(Error error) {
        if (error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            return false;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        return validationManager.setErrors(messages).isEmpty();
    }

    private final void removePhoneNumber(String password) {
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneDelete(new RestAPIParams.DeletePhone(password)), false, 1, null), this, null, 2, null), getBinding().f18345b, 0L, 2, null).m11108k(C0879o.m181h(new C102221(), getContext(), new C102232()));
    }

    private final void saveInfo() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            TextInputLayout textInputLayout = getBinding().f18346c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_ACTION);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.user.WidgetUserPasswordVerify.Companion.Action");
            int iOrdinal = ((Companion.Action) serializableExtra).ordinal();
            if (iOrdinal == 0) {
                updateAccountInfo(textOrEmpty);
            } else if (iOrdinal == 1) {
                removePhoneNumber(textOrEmpty);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                updatePhoneNumber(textOrEmpty);
            }
        }
    }

    private final void updateAccountInfo(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_USERNAME);
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_DISCRIMINATOR);
        String stringExtra3 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL);
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(new RestAPIParams.UserInfo(null, stringExtra3, getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL_TOKEN), password, null, stringExtra, StoreStream.INSTANCE.getNotifications().getPushToken(), null, stringExtra2, null, null, 1681, null)), false, 1, null), this, null, 2, null), getBinding().f18345b, 0L, 2, null).m11108k(C0879o.m181h(new C102241(stringExtra3, password), getContext(), new C102252()));
    }

    private final void updatePhoneNumber(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_TOKEN);
        Intrinsics3.checkNotNull(stringExtra);
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…TENT_EXTRA_PHONE_TOKEN)!!");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        Intrinsics3.checkNotNull(stringExtra2);
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…TENT_EXTRA_SOURCE_TYPE)!!");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneWithToken(new RestAPIParams.VerificationPhoneCode(stringExtra, password, stringExtra2)), false, 1, null), this, null, 2, null), getBinding().f18345b, 0L, 2, null).m11108k(C0879o.m181h(new C102261(), getContext(), new C102272()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_account_verify_password_title_in_title_case);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f18347d;
        TextInputLayout textInputLayout = getBinding().f18346c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        TextInputLayout textInputLayout2 = getBinding().f18346c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C102201(), 1, null);
        getBinding().f18347d.setOnClickListener(new ViewOnClickListenerC102212());
    }
}
