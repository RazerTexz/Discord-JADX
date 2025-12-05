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
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetAuthPhoneVerify.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};

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
    private final AppLogger2 loggingConfig;
    private String phone;

    /* compiled from: WidgetAuthPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phone, "phone");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, phone);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, title);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, subtitle);
            AppScreen2.f524g.m160f(context, launcher, WidgetAuthPhoneVerify.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Result, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthPhoneVerify2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
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
                Intrinsics3.checkNotNullParameter(str, "token");
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
                Intrinsics3.checkNotNullParameter(token, "token");
                return new Token(token);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Token) && Intrinsics3.areEqual(this.token, ((Token) other).token);
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
                return outline.m822J(outline.m833U("Token(token="), this.token, ")");
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$1 */
    public static final class C72071 extends Lambda implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadata2> {
        public static final C72071 INSTANCE = new C72071();

        public C72071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return invoke2(modelPhoneVerificationToken);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$2 */
    public static final class C72082 extends Lambda implements Function1<ModelPhoneVerificationToken, Unit> {
        public C72082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            invoke2(modelPhoneVerificationToken);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            Intrinsics3.checkNotNullParameter(modelPhoneVerificationToken, "it");
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
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$3 */
    public static final class C72093 extends Lambda implements Function1<Error, Unit> {
        public C72093() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Phone Verification", "response_error", CollectionsJVM.listOf(ModelAuditLogEntry.CHANGE_KEY_CODE));
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).f15697c.m8538b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$1 */
    public static final class C72101 extends Lambda implements Function1<String, Unit> {
        public static final C72101 INSTANCE = new C72101();

        public C72101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$2 */
    public static final /* synthetic */ class C72112 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public C72112(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$evaluateCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$3 */
    public static final class C72123 extends Lambda implements Function1<Long, Unit> {
        public C72123() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthPhoneVerify widgetAuthPhoneVerify = WidgetAuthPhoneVerify.this;
            WidgetAuthPhoneVerify.access$evaluateCode(widgetAuthPhoneVerify, WidgetAuthPhoneVerify.access$getBinding$p(widgetAuthPhoneVerify).f15697c.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onResume$1 */
    public static final class C72131 extends Lambda implements Function1<Unit, Unit> {
        public C72131() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetAuthPhoneVerify.access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$1 */
    public static final class ViewOnClickListenerC72141 implements View.OnClickListener {
        public ViewOnClickListenerC72141() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$resendCode(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$2 */
    public static final class ViewOnClickListenerC72152 implements View.OnClickListener {
        public ViewOnClickListenerC72152() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$bailoutToEmail(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$3 */
    public static final class C72163 extends Lambda implements Function1<String, Unit> {
        public C72163() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetAuthPhoneVerify.access$evaluateCode(WidgetAuthPhoneVerify.this, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$4 */
    public static final /* synthetic */ class C72174 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public C72174(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$inputCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$1 */
    public static final class C72181 extends Lambda implements Function1<Void, Unit> {
        public C72181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).f15697c.m8538b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$2 */
    public static final class C72192 extends Lambda implements Function1<Error, Unit> {
        public C72192() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).f15697c.m8538b();
        }
    }

    public WidgetAuthPhoneVerify() {
        super(C5419R.layout.widget_auth_phone_verify);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthPhoneVerify4.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthPhoneVerify3.INSTANCE, null, 2, null);
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
        AppTransitionActivity.f14963j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_close_out);
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
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams.VerificationCode(str, code)), C72071.INSTANCE), false, 1, null), this, null, 2, null), getBinding().f15701g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new C72093(), (Function0) null, (Function0) null, new C72082(), 52, (Object) null);
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().f15697c.setOnCodeEntered(C72101.INSTANCE);
            getBinding().f15697c.setCode(code);
            getBinding().f15697c.setOnCodeEntered(new C72112(this));
            Observable<Long> observableM11068d0 = Observable.m11068d0(500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C72123(), 62, (Object) null);
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams.VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().f15701g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new C72192(), (Function0) null, (Function0) null, new C72181(), 52, (Object) null);
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                Intrinsics3.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item.getItemId() != C5419R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics3.checkNotNullParameter(menu, "menu");
        Intrinsics3.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(C5419R.menu.menu_code_verification, menu);
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
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.f27425a);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C72131(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!Intrinsics3.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f15700f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!Intrinsics3.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().f15699e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().f15698d.setOnClickListener(new ViewOnClickListenerC72141());
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f15696b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f15696b.setOnClickListener(new ViewOnClickListenerC72152());
        }
        getBinding().f15697c.setOnCodeEntered(new C72163());
        registerForContextMenu(getBinding().f15697c);
        SmsListener.INSTANCE.startSmsListener(new C72174(this));
    }
}
