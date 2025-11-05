package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
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
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL, email);
            j.g.f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetSettingsAccountEmailEditConfirm$Companion$registerForResult$1(callback));
            m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
        /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04551 extends o implements Function1<View, Unit> {
            public C04551() {
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
                WidgetSettingsAccountEmailEditConfirm.access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onResend", new C04551());
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<TextView, Unit> {
        public AnonymousClass1() {
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
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<MeUser, Unit> {
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
            m.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountEmailEditConfirm.access$configureUI(WidgetSettingsAccountEmailEditConfirm.this, meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$resendVerificationCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r5) {
            b.a.d.m.g(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), R.string.user_settings_account_change_email_confirm_code_sent, 0, null, 12);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelEmailChangeConfirm> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            call2(modelEmailChangeConfirm);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(WidgetUserPasswordVerify.INSTANCE, WidgetSettingsAccountEmailEditConfirm.this.requireContext(), WidgetSettingsAccountEmailEditConfirm.access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm.this), WidgetSettingsAccountEmailEditConfirm.this.getMostRecentIntent().getStringExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL), null, null, modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null, 24, null);
        }
    }

    public WidgetSettingsAccountEmailEditConfirm() {
        super(R.layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1(this));
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
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        b.n(textView, R.string.user_settings_account_change_email_confirm_description, new Object[]{meUser.getEmail()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        b.m(linkifiedTextView, R.string.user_settings_account_change_email_confirm_resend, new Object[0], new AnonymousClass1());
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null).k(b.a.d.o.j(new AnonymousClass1(), requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmailVerifyCode(new RestAPIParams.UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f2600b, 0L, 2, null).k(b.a.d.o.j(new AnonymousClass1(), requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_change_email_confirm_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().f.setOnClickListener(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEditConfirm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
