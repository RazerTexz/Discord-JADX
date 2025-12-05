package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* compiled from: WidgetUserEmailUpdate.kt */
/* loaded from: classes.dex */
public final class WidgetUserEmailUpdate extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserEmailUpdate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetUserEmailUpdate.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void launch$default(Companion companion, Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher activityResultLauncher, int i, Object obj) {
            if ((i & 4) != 0) {
                activityResultLauncher = null;
            }
            companion.launch(context, mode, activityResultLauncher);
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true);
            if (launcher != null) {
                AppScreen2.f524g.m160f(context, launcher, WidgetUserEmailUpdate.class, launchIntent);
            } else {
                AppScreen2.m156d(context, WidgetUserEmailUpdate.class, launchIntent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserEmailUpdate2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$1 */
    public static final class C102531 extends Lambda implements Function1<Editable, Unit> {
        public C102531() {
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
            WidgetUserEmailUpdate.access$handleTextChanged(WidgetUserEmailUpdate.this);
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$2 */
    public static final class C102542 extends Lambda implements Function1<Editable, Unit> {
        public C102542() {
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
            WidgetUserEmailUpdate.access$handleTextChanged(WidgetUserEmailUpdate.this);
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$3 */
    public static final class ViewOnClickListenerC102553 implements View.OnClickListener {

        /* compiled from: WidgetUserEmailUpdate.kt */
        /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<User> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(User user) {
                call2(user);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(User user) {
                WidgetUserEmailUpdate.access$onEmailUpdated(WidgetUserEmailUpdate.this);
            }
        }

        public ViewOnClickListenerC102553() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            RestAPIParams.UserInfo.Companion companion = RestAPIParams.UserInfo.INSTANCE;
            TextInputLayout textInputLayout = WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).f18327c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            TextInputLayout textInputLayout2 = WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).f18328d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.patchUser(companion.createForEmail(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout2))), false, 1, null), WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).f18329e, 0L, 2, null), WidgetUserEmailUpdate.this, null, 2, null).m11108k(C0879o.m182i(new AnonymousClass1(), WidgetUserEmailUpdate.this));
        }
    }

    public WidgetUserEmailUpdate() {
        super(C5419R.layout.widget_user_email_update);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserEmailUpdate3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetUserEmailUpdateBinding access$getBinding$p(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        return widgetUserEmailUpdate.getBinding();
    }

    public static final /* synthetic */ void access$handleTextChanged(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.handleTextChanged();
    }

    public static final /* synthetic */ void access$onEmailUpdated(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.onEmailUpdated();
    }

    private final WidgetUserEmailUpdateBinding getBinding() {
        return (WidgetUserEmailUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleTextChanged() {
        boolean z2;
        TextInputLayout textInputLayout = getBinding().f18328d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangePassword");
        if (ViewExtensions.getTextOrEmpty(textInputLayout).length() >= 3) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            TextInputLayout textInputLayout2 = getBinding().f18327c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangeEmail");
            z2 = pattern.matcher(ViewExtensions.getTextOrEmpty(textInputLayout2)).matches();
        }
        MaterialButton materialButton = getBinding().f18326b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.alertVerifyEmailChange");
        materialButton.setEnabled(z2);
    }

    private final void onEmailUpdated() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(-1);
        }
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.finish();
        }
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f18327c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C102531());
        TextInputLayout textInputLayout2 = getBinding().f18328d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C102542());
        getBinding().f18326b.setOnClickListener(new ViewOnClickListenerC102553());
    }
}
