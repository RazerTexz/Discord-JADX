package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.Observable;

/* compiled from: WidgetAuthPhoneVerify.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE = "INTENT_EXTRA_PHONE";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";
    private static final int RESULT_BACK_TO_EMAIL = 2;
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private final LoggingConfig loggingConfig;
    private String phone;

    /* compiled from: WidgetAuthPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(launcher, "launcher");
            m.checkNotNullParameter(phone, "phone");
            m.checkNotNullParameter(title, "title");
            m.checkNotNullParameter(subtitle, "subtitle");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, phone);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, title);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, subtitle);
            j.g.f(context, launcher, WidgetAuthPhoneVerify.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Result, Unit> callback) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthPhoneVerify$Companion$registerForResult$1(callback));
            m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    public static abstract class Result {

        /* compiled from: WidgetAuthPhoneVerify.kt */
        public static final class Cancelled extends Result {
            public static final Cancelled INSTANCE = new Cancelled();

            private Cancelled() {
                super(null);
            }
        }

        /* compiled from: WidgetAuthPhoneVerify.kt */
        public static final /* data */ class Token extends Result {
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Token(String str) {
                super(null);
                m.checkNotNullParameter(str, "token");
                this.token = str;
            }

            public static /* synthetic */ Token copy$default(Token token, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = token.token;
                }
                return token.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final Token copy(String token) {
                m.checkNotNullParameter(token, "token");
                return new Token(token);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Token) && m.areEqual(this.token, ((Token) other).token);
                }
                return true;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                String str = this.token;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.J(a.U("Token(token="), this.token, ")");
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return invoke2(modelPhoneVerificationToken);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ModelPhoneVerificationToken, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            invoke2(modelPhoneVerificationToken);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            m.checkNotNullParameter(modelPhoneVerificationToken, "it");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.RESULT_EXTRA_TOKEN, modelPhoneVerificationToken.getToken());
            AppActivity appActivity = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(-1, intent);
            }
            AppActivity appActivity2 = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Phone Verification", "response_error", d0.t.m.listOf(ModelAuditLogEntry.CHANGE_KEY_CODE));
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "it");
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$evaluateCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthPhoneVerify widgetAuthPhoneVerify = WidgetAuthPhoneVerify.this;
            WidgetAuthPhoneVerify.access$evaluateCode(widgetAuthPhoneVerify, WidgetAuthPhoneVerify.access$getBinding$p(widgetAuthPhoneVerify).c.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetAuthPhoneVerify.access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$resendCode(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$bailoutToEmail(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetAuthPhoneVerify.access$evaluateCode(WidgetAuthPhoneVerify.this, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function1<String, Unit> {
        public AnonymousClass4(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$inputCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    public WidgetAuthPhoneVerify() {
        super(R.layout.widget_auth_phone_verify);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthPhoneVerify$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$bailoutToEmail(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.bailoutToEmail();
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthPhoneVerifyBinding access$getBinding$p(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        return widgetAuthPhoneVerify.getBinding();
    }

    public static final /* synthetic */ void access$inputCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.inputCode(str);
    }

    public static final /* synthetic */ void access$resendCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.resendCode();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.tryPasteCodeFromClipboard();
    }

    private final void bailoutToEmail() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(2);
        }
        AppTransitionActivity.j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_close_out);
        }
        AppActivity appActivity3 = getAppActivity();
        if (appActivity3 != null) {
            appActivity3.finish();
        }
    }

    private final void evaluateCode(String code) {
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "submitted", null, 4, null);
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams.VerificationCode(str, code)), AnonymousClass1.INSTANCE), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().c.setOnCodeEntered(AnonymousClass1.INSTANCE);
            getBinding().c.setCode(code);
            getBinding().c.setOnCodeEntered(new AnonymousClass2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams.VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        m.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        m.checkNotNullParameter(menu, "menu");
        m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SmsListener.INSTANCE.stopSmsListener();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        j0.l.e.k kVar = new j0.l.e.k(Unit.a);
        m.checkNotNullExpressionValue(kVar, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(kVar, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.phone = stringExtra;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "viewed", null, 4, null);
        CharSequence charSequenceExtra = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_TITLE);
        if (charSequenceExtra == null) {
            charSequenceExtra = "";
        }
        m.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        m.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!m.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f;
            m.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!m.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().d.setOnClickListener(new AnonymousClass1());
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f2235b;
            m.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f2235b.setOnClickListener(new AnonymousClass2());
        }
        getBinding().c.setOnCodeEntered(new AnonymousClass3());
        registerForContextMenu(getBinding().c);
        SmsListener.INSTANCE.startSmsListener(new AnonymousClass4(this));
    }
}
