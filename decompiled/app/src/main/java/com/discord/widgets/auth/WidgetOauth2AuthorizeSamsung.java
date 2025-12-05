package com.discord.widgets.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.PointerIconCompat;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.samsung.SamsungConnect3;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p048r.SamsungConnect;
import p007b.p008a.p048r.SamsungConnect2;
import p007b.p008a.p048r.SamsungConnectActivity2;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p579g0.Strings4;
import p507d0.p579g0._Strings;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.OkHttpClient;
import p658rx.Observable;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.MainCoroutineDispatcher;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung extends WidgetOauth2Authorize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQ_CODE_SAMSUNG = 5459;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private String samsungAuthCode;
    private final ActivityResultLauncher<Intent> samsungConnectLauncher;
    private final ActivityResultLauncher<Intent> samsungDisclaimerLauncher;

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$createSAStateId(Companion companion) {
            return companion.createSAStateId();
        }

        public static final /* synthetic */ void access$logI(Companion companion, String str) {
            companion.logI(str);
        }

        private final String createSAStateId() {
            StringBuilder sbM833U = outline.m833U("SA");
            sbM833U.append(UUID.randomUUID());
            return _Strings.take(sbM833U.toString(), 115);
        }

        private final void logI(String message) {
            AppLog appLog = AppLog.f14950g;
            appLog.m8360c(message, "Samsung", null, new WidgetOauth2AuthorizeSamsung2(appLog));
        }

        private final void logW(String message, Throwable throwable) {
            AppLog appLog = AppLog.f14950g;
            appLog.m8360c(message, "Samsung", throwable, new WidgetOauth2AuthorizeSamsung3(appLog));
        }

        public static /* synthetic */ void logW$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            companion.logW(str, th);
        }

        public final Observable<Void> getForSamsung(WidgetOauth2Authorize.OAuth2Authorize oAuth2Authorize, String str) {
            Intrinsics3.checkNotNullParameter(oAuth2Authorize, "$this$getForSamsung");
            Intrinsics3.checkNotNullParameter(str, "accountUri");
            return RestAPI.INSTANCE.getApi().getOauth2SamsungAuthorize(String.valueOf(oAuth2Authorize.getClientId()), oAuth2Authorize.getState(), oAuth2Authorize.getResponseType(), str, oAuth2Authorize.getPrompt(), oAuth2Authorize.getScope());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$1 */
    public static final class C72521 extends Lambda implements Function1<Error, Unit> {
        public C72521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "POST /authorize: error " + error);
            String bodyText = error.getBodyText();
            if (bodyText == null || !Strings4.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) {
                return;
            }
            WidgetAuthCaptcha.INSTANCE.launch(WidgetOauth2AuthorizeSamsung.this.requireContext(), WidgetOauth2AuthorizeSamsung.this.getCaptchaLauncher(), CaptchaErrorBody.INSTANCE.createFromError(error));
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2 */
    public static final class C72532 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
        @DebugMetadata(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {157}, m10087m = "invokeSuspend")
        /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ RestAPIParams.OAuth2Authorize.ResponsePost $it;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestAPIParams.OAuth2Authorize.ResponsePost responsePost, Continuation continuation) {
                super(2, continuation);
                this.$it = responsePost;
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return C72532.this.new AnonymousClass1(this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung = WidgetOauth2AuthorizeSamsung.this;
                    String location = this.$it.getLocation();
                    String str = C72532.this.$samsungAuthCode;
                    this.label = 1;
                    if (widgetOauth2AuthorizeSamsung.samsungCallbackHandshake(location, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72532(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            invoke2(responsePost);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            Intrinsics3.checkNotNullParameter(responsePost, "it");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "POST /authorize success");
            C3404f.m4211H0(CoroutineScope2.f27919j, Dispatchers.f27867b, null, new AnonymousClass1(responsePost, null), 2, null);
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$configureUI$1 */
    public static final class ViewOnClickListenerC72541 implements View.OnClickListener {
        public ViewOnClickListenerC72541() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            Intrinsics3.checkNotNullParameter(context, "context");
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
            Intrinsics3.checkNotNullExpressionValue(accountsByType, "accountManager.getAccoun…yType(SA_ACCOUNT_SERVICE)");
            if (!(!(accountsByType.length == 0))) {
                Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "Not Logged into Samsung Account");
            }
            try {
                ActivityResultLauncher activityResultLauncherAccess$getSamsungDisclaimerLauncher$p = WidgetOauth2AuthorizeSamsung.access$getSamsungDisclaimerLauncher$p(WidgetOauth2AuthorizeSamsung.this);
                Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_NEW_THIRD_PARTY_INTEGRATION_WITH_SAMSUNG_ACCOUNT");
                intent.putExtra("client_id", "97t47j218f");
                intent.putExtra("progress_theme", ModelUserSettings.THEME_DARK);
                activityResultLauncherAccess$getSamsungDisclaimerLauncher$p.launch(intent);
            } catch (ActivityNotFoundException unused) {
                AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {Opcodes.RETURN, Opcodes.NEWARRAY, Opcodes.CHECKCAST}, m10087m = "samsungCallbackHandshake")
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 */
    public static final class C72551 extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C72551(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetOauth2AuthorizeSamsung.this.samsungCallbackHandshake(null, null, this);
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2 */
    public static final class C72562 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C72562(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetOauth2AuthorizeSamsung.this.new C72562(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72562) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            AppToast.m171i(WidgetOauth2AuthorizeSamsung.this, C5419R.string.authorized, 0, 4);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity == null) {
                return null;
            }
            appActivity.finish();
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1 */
    public static final class C72571 extends Lambda implements Function1<Error, Unit> {
        public C72571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "error");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "GET /authorize: error " + error);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2 */
    public static final class C72582 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72582(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetOauth2AuthorizeSamsung.access$authorizeForSamsung(WidgetOauth2AuthorizeSamsung.this, this.$samsungAuthCode, null);
        }
    }

    public WidgetOauth2AuthorizeSamsung() {
        WidgetOauth2AuthorizeSamsung5 widgetOauth2AuthorizeSamsung5 = new WidgetOauth2AuthorizeSamsung5(this);
        Intrinsics3.checkNotNullParameter(this, "fragment");
        Intrinsics3.checkNotNullParameter(widgetOauth2AuthorizeSamsung5, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SamsungConnectActivity2(widgetOauth2AuthorizeSamsung5));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        this.samsungConnectLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetOauth2AuthorizeSamsung6(this));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…inish()\n        }\n      }");
        this.samsungDisclaimerLauncher = activityResultLauncherRegisterForActivityResult2;
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2AuthorizeSamsung4(this));
    }

    public static final /* synthetic */ void access$authorizeForSamsung(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetOauth2AuthorizeSamsung.authorizeForSamsung(str, captchaPayload);
    }

    public static final /* synthetic */ String access$getSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungAuthCode;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungConnectLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungConnectLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungDisclaimerLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungDisclaimerLauncher;
    }

    public static final /* synthetic */ void access$handleConnectActivityFailure(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity.Result.Failure failure) {
        widgetOauth2AuthorizeSamsung.handleConnectActivityFailure(failure);
    }

    public static final /* synthetic */ void access$handleConnectActivitySuccess(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity.Result.Success success) {
        widgetOauth2AuthorizeSamsung.handleConnectActivitySuccess(success);
    }

    public static final /* synthetic */ void access$setSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str) {
        widgetOauth2AuthorizeSamsung.samsungAuthCode = str;
    }

    private final void authorizeForSamsung(String samsungAuthCode, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, (Context) null, (Function1) null, new C72521(), (Function0) null, (Function0) null, new C72532(samsungAuthCode), 54, (Object) null);
    }

    private final void handleConnectActivityFailure(SamsungConnectActivity.Result.Failure result) {
        if (!result.isRetryAllowed || result.attemptCount >= 2) {
            return;
        }
        Companion.logW$default(INSTANCE, "Retrying SA connection.\nBecause sometimes it just doesn't bind the first time.", null, 2, null);
        SamsungConnectActivity.m8504b(requireContext(), this.samsungConnectLauncher, result.attemptCount);
    }

    private final void handleConnectActivitySuccess(SamsungConnectActivity.Result.Success result) {
        String str = result.authCode;
        this.samsungAuthCode = str;
        startSamsungAccountLink(result.serverUrl, str);
    }

    private final void startSamsungAccountLink(String saUrl, String samsungAuthCode) {
        String str;
        Intrinsics3.checkNotNullParameter(saUrl, "authServerUrl");
        String strTake = _Strings.take(saUrl, 2);
        int iHashCode = strTake.hashCode();
        if (iHashCode != 3179) {
            if (iHashCode == 3248) {
                strTake.equals("eu");
            } else if (iHashCode == 3742 && strTake.equals("us")) {
                str = "https://us.account.samsung.com";
            }
        } else {
            str = strTake.equals("cn") ? "https://account.samsung.cn" : "https://account.samsung.com";
        }
        Companion companion = INSTANCE;
        Companion.access$logI(companion, "GET /authorize " + str);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(companion.getForSamsung(getOauth2ViewModel().getOauthAuthorize(), str), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, requireContext(), (Function1) null, new C72571(), (Function0) null, (Function0) null, new C72582(samsungAuthCode), 52, (Object) null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.configureUI(data);
        getBinding().f17335g.setOnClickListener(new ViewOnClickListenerC72541());
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public WidgetOauth2Authorize.OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        Intrinsics3.checkNotNullParameter(requestUrl, "requestUrl");
        WidgetOauth2Authorize.OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize = super.createOauthAuthorize(requestUrl);
        String state = oAuth2AuthorizeCreateOauthAuthorize.getState();
        if (state == null) {
            state = Companion.access$createSAStateId(INSTANCE);
        }
        return WidgetOauth2Authorize.OAuth2Authorize.copy$default(oAuth2AuthorizeCreateOauthAuthorize, 0L, state, null, "https://discord.com/api/v6/oauth2/samsung/authorize/callback", null, null, null, null, null, null, PointerIconCompat.TYPE_ALL_SCROLL, null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object samsungCallbackHandshake(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        C72551 c72551;
        String str3;
        OkHttpClient okHttpClient;
        WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung;
        String queryParameter;
        MainCoroutineDispatcher mainCoroutineDispatcher;
        C72562 c72562;
        if (continuation instanceof C72551) {
            c72551 = (C72551) continuation;
            int i = c72551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c72551.label = i - Integer.MIN_VALUE;
            } else {
                c72551 = new C72551(continuation);
            }
        }
        Object objM4197C1 = c72551.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c72551.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objM4197C1);
            OkHttpClient.a aVar = new OkHttpClient.a();
            aVar.f26036h = false;
            OkHttpClient okHttpClient2 = new OkHttpClient(aVar);
            Companion.access$logI(INSTANCE, "GET /callback");
            c72551.L$0 = this;
            c72551.L$1 = str2;
            c72551.L$2 = okHttpClient2;
            c72551.label = 1;
            Object objM4197C12 = C3404f.m4197C1(Dispatchers.f27867b, new SamsungConnect(str, okHttpClient2, null), c72551);
            if (objM4197C12 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str2;
            okHttpClient = okHttpClient2;
            objM4197C1 = objM4197C12;
            widgetOauth2AuthorizeSamsung = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(objM4197C1);
                    return Unit.f27425a;
                }
                widgetOauth2AuthorizeSamsung = (WidgetOauth2AuthorizeSamsung) c72551.L$0;
                Result3.throwOnFailure(objM4197C1);
                Companion.access$logI(INSTANCE, "POST /callback success " + ((Uri) objM4197C1));
                CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
                mainCoroutineDispatcher = MainDispatchers.f27700b;
                c72562 = widgetOauth2AuthorizeSamsung.new C72562(null);
                c72551.L$0 = null;
                c72551.label = 3;
                if (C3404f.m4197C1(mainCoroutineDispatcher, c72562, c72551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.f27425a;
            }
            OkHttpClient okHttpClient3 = (OkHttpClient) c72551.L$2;
            String str4 = (String) c72551.L$1;
            WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung2 = (WidgetOauth2AuthorizeSamsung) c72551.L$0;
            Result3.throwOnFailure(objM4197C1);
            okHttpClient = okHttpClient3;
            str3 = str4;
            widgetOauth2AuthorizeSamsung = widgetOauth2AuthorizeSamsung2;
        }
        Uri uri = (Uri) objM4197C1;
        if (uri == null || (queryParameter = uri.getQueryParameter("redirect_uri")) == null) {
            throw new SamsungConnect3("no_redirect_uri", "no redirect uri returned from GET/callback");
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "getCallbackUri?.getQuery…m GET/callback\"\n        )");
        Companion.access$logI(INSTANCE, "POST /callback " + queryParameter);
        String state = widgetOauth2AuthorizeSamsung.getOauth2ViewModel().getOauthAuthorize().getState();
        Intrinsics3.checkNotNull(state);
        c72551.L$0 = widgetOauth2AuthorizeSamsung;
        c72551.L$1 = null;
        c72551.L$2 = null;
        c72551.label = 2;
        objM4197C1 = C3404f.m4197C1(Dispatchers.f27867b, new SamsungConnect2(state, str3, queryParameter, okHttpClient, null), c72551);
        if (objM4197C1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        Companion.access$logI(INSTANCE, "POST /callback success " + ((Uri) objM4197C1));
        CoroutineDispatcher coroutineDispatcher2 = Dispatchers.f27866a;
        mainCoroutineDispatcher = MainDispatchers.f27700b;
        c72562 = widgetOauth2AuthorizeSamsung.new C72562(null);
        c72551.L$0 = null;
        c72551.label = 3;
        if (C3404f.m4197C1(mainCoroutineDispatcher, c72562, c72551) == coroutine_suspended) {
        }
        return Unit.f27425a;
    }
}
