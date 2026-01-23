package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            companion.launch(context, activityResultLauncher, str);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String email) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL, email);
            AppScreen2.f524g.m160f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetSettingsAccountEmailEditConfirm2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97631 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetSettingsAccountEmailEditConfirm.access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
            }
        }

        public C97631() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onResend", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97641 extends Lambda implements Function1<TextView, Unit> {
        public C97641() {
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
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class ViewOnClickListenerC97652 implements View.OnClickListener {
        public ViewOnClickListenerC97652() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97661 extends Lambda implements Function1<MeUser, Unit> {
        public C97661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountEmailEditConfirm.access$configureUI(WidgetSettingsAccountEmailEditConfirm.this, meUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$resendVerificationCode$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97671<T> implements Action1<Void> {
        public C97671() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r5) {
            AppToast.m169g(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), C5419R.string.user_settings_account_change_email_confirm_code_sent, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    public static final class C97681<T> implements Action1<ModelEmailChangeConfirm> {
        public C97681() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            call2(modelEmailChangeConfirm);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(WidgetUserPasswordVerify.INSTANCE, WidgetSettingsAccountEmailEditConfirm.this.requireContext(), WidgetSettingsAccountEmailEditConfirm.access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm.this), WidgetSettingsAccountEmailEditConfirm.this.getMostRecentIntent().getStringExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL), null, null, modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null, 24, null);
        }
    }

    public WidgetSettingsAccountEmailEditConfirm() {
        super(C5419R.layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm3.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm, MeUser meUser) {
        widgetSettingsAccountEmailEditConfirm.configureUI(meUser);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        return widgetSettingsAccountEmailEditConfirm.passwordVerifyLauncher;
    }

    public static final /* synthetic */ void access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.resendVerificationCode();
    }

    public static final /* synthetic */ void access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.submitVerificationCode();
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().f17843d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        FormatUtils.m222n(textView, C5419R.string.user_settings_account_change_email_confirm_description, new Object[]{meUser.getEmail()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().f17844e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.user_settings_account_change_email_confirm_resend, new Object[0], new C97631());
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null).m11108k(C0879o.m183j(new C97671(), requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().f17842c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmailVerifyCode(new RestAPIParams.UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f17841b, 0L, 2, null).m11108k(C0879o.m183j(new C97681(), requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_account_change_email_confirm_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17842c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C97641(), 1, null);
        getBinding().f17845f.setOnClickListener(new ViewOnClickListenerC97652());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEditConfirm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97661(), 62, (Object) null);
    }
}
