package com.discord.utilities.captcha;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.stores.StoreStream;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.hcaptcha.sdk.HCaptcha$1;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaSize;
import com.hcaptcha.sdk.HCaptchaTheme;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3363k;
import p007b.p225i.p226a.p288f.p299e.p304k.C3379s;
import p007b.p225i.p226a.p288f.p299e.p304k.C3385v;
import p007b.p225i.p226a.p288f.p313h.p328o.C3962i;
import p007b.p225i.p226a.p288f.p313h.p328o.C3963j;
import p007b.p225i.p226a.p288f.p313h.p328o.C3965l;
import p007b.p225i.p226a.p288f.p336k.C4327a;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4359d;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p437j.p438a.C5065a;
import p007b.p437j.p438a.C5067c;
import p007b.p437j.p438a.p439f.InterfaceC5070a;
import p007b.p437j.p438a.p439f.InterfaceC5072c;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: CaptchaHelper.kt */
/* loaded from: classes2.dex */
public final class CaptchaHelper {
    public static final String CAPTCHA_KEY = "captcha_key";
    private static final String FAILED_CAPTCHA_EXPIRED = "expired";
    private static final String FAILED_DEVICE_UNSUPPORTED = "unsupported_device";
    private static final String FAILED_MISSING_DEPS = "missing_dependencies";
    public static final CaptchaHelper INSTANCE = new CaptchaHelper();
    private static final String RECAPTCHA_SITE_KEY = "6Lff5jIUAAAAAImNXvYYPv2VW2En3Dexy4oX2o4s";
    private static String captchaRqtoken;
    private static String captchaToken;

    /* compiled from: CaptchaHelper.kt */
    public static final /* data */ class CaptchaPayload {
        private final String captchaKey;
        private final String captchaRqtoken;

        public CaptchaPayload(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "captchaKey");
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }

        public static /* synthetic */ CaptchaPayload copy$default(CaptchaPayload captchaPayload, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = captchaPayload.captchaKey;
            }
            if ((i & 2) != 0) {
                str2 = captchaPayload.captchaRqtoken;
            }
            return captchaPayload.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final CaptchaPayload copy(String captchaKey, String captchaRqtoken) {
            Intrinsics3.checkNotNullParameter(captchaKey, "captchaKey");
            return new CaptchaPayload(captchaKey, captchaRqtoken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptchaPayload)) {
                return false;
            }
            CaptchaPayload captchaPayload = (CaptchaPayload) other;
            return Intrinsics3.areEqual(this.captchaKey, captchaPayload.captchaKey) && Intrinsics3.areEqual(this.captchaRqtoken, captchaPayload.captchaRqtoken);
        }

        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public int hashCode() {
            String str = this.captchaKey;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.captchaRqtoken;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("CaptchaPayload(captchaKey=");
            sbM833U.append(this.captchaKey);
            sbM833U.append(", captchaRqtoken=");
            return outline.m822J(sbM833U, this.captchaRqtoken, ")");
        }

        public /* synthetic */ CaptchaPayload(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    /* compiled from: CaptchaHelper.kt */
    public static abstract class CaptchaRequest {

        /* compiled from: CaptchaHelper.kt */
        public static final /* data */ class HCaptcha extends CaptchaRequest {
            private final Activity activity;
            private final String rqdata;
            private final String siteKey;

            public /* synthetic */ HCaptcha(String str, Activity activity, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, activity, (i & 4) != 0 ? null : str2);
            }

            public static /* synthetic */ HCaptcha copy$default(HCaptcha hCaptcha, String str, Activity activity, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hCaptcha.siteKey;
                }
                if ((i & 2) != 0) {
                    activity = hCaptcha.activity;
                }
                if ((i & 4) != 0) {
                    str2 = hCaptcha.rqdata;
                }
                return hCaptcha.copy(str, activity, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getSiteKey() {
                return this.siteKey;
            }

            /* renamed from: component2, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            /* renamed from: component3, reason: from getter */
            public final String getRqdata() {
                return this.rqdata;
            }

            public final HCaptcha copy(String siteKey, Activity activity, String rqdata) {
                Intrinsics3.checkNotNullParameter(siteKey, "siteKey");
                Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                return new HCaptcha(siteKey, activity, rqdata);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HCaptcha)) {
                    return false;
                }
                HCaptcha hCaptcha = (HCaptcha) other;
                return Intrinsics3.areEqual(this.siteKey, hCaptcha.siteKey) && Intrinsics3.areEqual(this.activity, hCaptcha.activity) && Intrinsics3.areEqual(this.rqdata, hCaptcha.rqdata);
            }

            public final Activity getActivity() {
                return this.activity;
            }

            public final String getRqdata() {
                return this.rqdata;
            }

            public final String getSiteKey() {
                return this.siteKey;
            }

            public int hashCode() {
                String str = this.siteKey;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Activity activity = this.activity;
                int iHashCode2 = (iHashCode + (activity != null ? activity.hashCode() : 0)) * 31;
                String str2 = this.rqdata;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("HCaptcha(siteKey=");
                sbM833U.append(this.siteKey);
                sbM833U.append(", activity=");
                sbM833U.append(this.activity);
                sbM833U.append(", rqdata=");
                return outline.m822J(sbM833U, this.rqdata, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HCaptcha(String str, Activity activity, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "siteKey");
                Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                this.siteKey = str;
                this.activity = activity;
                this.rqdata = str2;
            }
        }

        /* compiled from: CaptchaHelper.kt */
        public static final /* data */ class ReCaptcha extends CaptchaRequest {
            private final Activity activity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReCaptcha(Activity activity) {
                super(null);
                Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                this.activity = activity;
            }

            public static /* synthetic */ ReCaptcha copy$default(ReCaptcha reCaptcha, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = reCaptcha.activity;
                }
                return reCaptcha.copy(activity);
            }

            /* renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final ReCaptcha copy(Activity activity) {
                Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                return new ReCaptcha(activity);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReCaptcha) && Intrinsics3.areEqual(this.activity, ((ReCaptcha) other).activity);
                }
                return true;
            }

            public final Activity getActivity() {
                return this.activity;
            }

            public int hashCode() {
                Activity activity = this.activity;
                if (activity != null) {
                    return activity.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ReCaptcha(activity=");
                sbM833U.append(this.activity);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private CaptchaRequest() {
        }

        public /* synthetic */ CaptchaRequest(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CaptchaHelper.kt */
    public static final /* data */ class Failure extends Throwable {
        private final int errorStringId;
        private final String reasonCode;

        public Failure(int i, String str) {
            Intrinsics3.checkNotNullParameter(str, "reasonCode");
            this.errorStringId = i;
            this.reasonCode = str;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failure.errorStringId;
            }
            if ((i2 & 2) != 0) {
                str = failure.reasonCode;
            }
            return failure.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorStringId() {
            return this.errorStringId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final Failure copy(int errorStringId, String reasonCode) {
            Intrinsics3.checkNotNullParameter(reasonCode, "reasonCode");
            return new Failure(errorStringId, reasonCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return this.errorStringId == failure.errorStringId && Intrinsics3.areEqual(this.reasonCode, failure.reasonCode);
        }

        public final int getErrorStringId() {
            return this.errorStringId;
        }

        public final String getReasonCode() {
            return this.reasonCode;
        }

        public int hashCode() {
            int i = this.errorStringId * 31;
            String str = this.reasonCode;
            return i + (str != null ? str.hashCode() : 0);
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sbM833U = outline.m833U("Failure(errorStringId=");
            sbM833U.append(this.errorStringId);
            sbM833U.append(", reasonCode=");
            return outline.m822J(sbM833U, this.reasonCode, ")");
        }
    }

    /* compiled from: CaptchaHelper.kt */
    /* renamed from: com.discord.utilities.captcha.CaptchaHelper$ensurePlayServicesAvailable$1 */
    public static final class C67131<TResult> implements InterfaceC4361e<Void> {
        public final /* synthetic */ Function0 $onReady;

        public C67131(Function0 function0) {
            this.$onReady = function0;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
        public /* bridge */ /* synthetic */ void onSuccess(Void r1) {
            onSuccess2(r1);
        }

        /* renamed from: onSuccess, reason: avoid collision after fix types in other method */
        public final void onSuccess2(Void r1) {
            this.$onReady.invoke();
        }
    }

    /* compiled from: CaptchaHelper.kt */
    /* renamed from: com.discord.utilities.captcha.CaptchaHelper$ensurePlayServicesAvailable$2 */
    public static final class C67142 implements InterfaceC4359d {
        public final /* synthetic */ Function1 $errorHandler;

        public C67142(Function1 function1) {
            this.$errorHandler = function1;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
        public final void onFailure(Exception exc) {
            this.$errorHandler.invoke(new Failure(C5419R.string.captcha_failed_play_services, CaptchaHelper.FAILED_MISSING_DEPS));
        }
    }

    /* compiled from: CaptchaHelper.kt */
    /* renamed from: com.discord.utilities.captcha.CaptchaHelper$showCaptcha$1 */
    public static final class C67151<TResult> implements InterfaceC4361e<SafetyNetApi.RecaptchaTokenResponse> {
        public final /* synthetic */ Function1 $onSuccess;

        public C67151(Function1 function1) {
            this.$onSuccess = function1;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
        public /* bridge */ /* synthetic */ void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
            onSuccess2(recaptchaTokenResponse);
        }

        /* renamed from: onSuccess, reason: avoid collision after fix types in other method */
        public final void onSuccess2(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
            Intrinsics3.checkNotNullExpressionValue(recaptchaTokenResponse, "it");
            String strMo5438C = ((SafetyNetApi.InterfaceC10813a) recaptchaTokenResponse.f9340a).mo5438C();
            Intrinsics3.checkNotNullExpressionValue(strMo5438C, "userResponseToken");
            if (strMo5438C.length() == 0) {
                return;
            }
            this.$onSuccess.invoke("android:" + strMo5438C);
        }
    }

    /* compiled from: CaptchaHelper.kt */
    /* renamed from: com.discord.utilities.captcha.CaptchaHelper$showCaptcha$2 */
    public static final class C67162 implements InterfaceC4359d {
        public final /* synthetic */ Function1 $errorHandler;

        public C67162(Function1 function1) {
            this.$errorHandler = function1;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
        public final void onFailure(Exception exc) {
            this.$errorHandler.invoke(new Failure(C5419R.string.captcha_failed, CaptchaHelper.FAILED_CAPTCHA_EXPIRED));
        }
    }

    /* compiled from: CaptchaHelper.kt */
    /* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1 */
    public static final class C67171<T> implements Action1<Emitter<String>> {
        public final /* synthetic */ CaptchaRequest $captchaRequest;

        /* compiled from: CaptchaHelper.kt */
        /* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$1, reason: invalid class name */
        public static final class AnonymousClass1<TResult> implements InterfaceC5072c<HCaptchaTokenResponse> {
            public final /* synthetic */ Emitter $emitter;

            public AnonymousClass1(Emitter emitter) {
                this.$emitter = emitter;
            }

            @Override // p007b.p437j.p438a.p439f.InterfaceC5072c
            public /* bridge */ /* synthetic */ void onSuccess(HCaptchaTokenResponse hCaptchaTokenResponse) {
                onSuccess2(hCaptchaTokenResponse);
            }

            /* renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public final void onSuccess2(HCaptchaTokenResponse hCaptchaTokenResponse) {
                Emitter emitter = this.$emitter;
                Intrinsics3.checkNotNullExpressionValue(hCaptchaTokenResponse, "hCaptchaTokenResponse");
                emitter.onNext(hCaptchaTokenResponse.f21692a);
                this.$emitter.onCompleted();
            }
        }

        /* compiled from: CaptchaHelper.kt */
        /* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements InterfaceC5070a {
            public final /* synthetic */ Emitter $emitter;
            public final /* synthetic */ Function1 $errorHandler;

            public AnonymousClass2(Emitter emitter, Function1 function1) {
                this.$emitter = emitter;
                this.$errorHandler = function1;
            }

            @Override // p007b.p437j.p438a.p439f.InterfaceC5070a
            public final void onFailure(HCaptchaException hCaptchaException) {
                Intrinsics3.checkNotNullExpressionValue(hCaptchaException, "hCaptchaException");
                if (hCaptchaException.m9265a() == HCaptchaError.CHALLENGE_CLOSED) {
                    this.$emitter.onCompleted();
                    return;
                }
                String strName = hCaptchaException.m9265a().name();
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                this.$errorHandler.invoke(new Failure(C5419R.string.captcha_failed, lowerCase));
            }
        }

        /* compiled from: CaptchaHelper.kt */
        /* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Activity $activity;
            public final /* synthetic */ Emitter $emitter;
            public final /* synthetic */ Function1 $errorHandler;

            /* compiled from: CaptchaHelper.kt */
            /* renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$3$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics3.checkNotNullParameter(str, "token");
                    AnonymousClass3.this.$emitter.onNext(str);
                    AnonymousClass3.this.$emitter.onCompleted();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(Activity activity, Emitter emitter, Function1 function1) {
                super(0);
                this.$activity = activity;
                this.$emitter = emitter;
                this.$errorHandler = function1;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
                Activity activity = this.$activity;
                C3266a.g<C3965l> gVar = C4327a.f11443a;
                SafetyNetClient safetyNetClient = new SafetyNetClient(activity);
                Intrinsics3.checkNotNullExpressionValue(safetyNetClient, "SafetyNet\n              …     .getClient(activity)");
                CaptchaHelper.access$showCaptcha(captchaHelper, safetyNetClient, new AnonymousClass1(), this.$errorHandler);
            }
        }

        public C67171(CaptchaRequest captchaRequest) {
            this.$captchaRequest = captchaRequest;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<String> emitter) throws PackageManager.NameNotFoundException {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<String> emitter) throws PackageManager.NameNotFoundException {
            CaptchaHelper3 captchaHelper3 = new CaptchaHelper3(emitter);
            CaptchaRequest captchaRequest = this.$captchaRequest;
            if (!(captchaRequest instanceof CaptchaRequest.HCaptcha)) {
                if (captchaRequest instanceof CaptchaRequest.ReCaptcha) {
                    Activity activity = ((CaptchaRequest.ReCaptcha) captchaRequest).getActivity();
                    CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
                    Object obj = GoogleApiAvailability.f20480c;
                    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f20481d;
                    Intrinsics3.checkNotNullExpressionValue(googleApiAvailability, "GoogleApiAvailability\n              .getInstance()");
                    CaptchaHelper.access$ensurePlayServicesAvailable(captchaHelper, googleApiAvailability, activity, new AnonymousClass3(activity, emitter, captchaHelper3), captchaHelper3);
                    return;
                }
                return;
            }
            Activity activity2 = ((CaptchaRequest.HCaptcha) captchaRequest).getActivity();
            HCaptchaConfig.C11151a c11151aBuilder = HCaptchaConfig.builder();
            String siteKey = ((CaptchaRequest.HCaptcha) this.$captchaRequest).getSiteKey();
            Objects.requireNonNull(c11151aBuilder);
            Objects.requireNonNull(siteKey, "siteKey is marked non-null but is null");
            c11151aBuilder.f21674a = siteKey;
            c11151aBuilder.f21687n = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
            c11151aBuilder.f21686m = true;
            if (((CaptchaRequest.HCaptcha) this.$captchaRequest).getRqdata() != null) {
                c11151aBuilder.f21679f = ((CaptchaRequest.HCaptcha) this.$captchaRequest).getRqdata();
            }
            Boolean boolAccess$000 = c11151aBuilder.f21676c;
            if (!c11151aBuilder.f21675b) {
                boolAccess$000 = HCaptchaConfig.access$000();
            }
            Boolean bool = boolAccess$000;
            Boolean boolAccess$100 = c11151aBuilder.f21678e;
            if (!c11151aBuilder.f21677d) {
                boolAccess$100 = HCaptchaConfig.access$100();
            }
            Boolean bool2 = boolAccess$100;
            String strAccess$200 = c11151aBuilder.f21681h;
            if (!c11151aBuilder.f21680g) {
                strAccess$200 = HCaptchaConfig.access$200();
            }
            String str = strAccess$200;
            String strAccess$300 = c11151aBuilder.f21687n;
            if (!c11151aBuilder.f21686m) {
                strAccess$300 = HCaptchaConfig.access$300();
            }
            String str2 = strAccess$300;
            HCaptchaSize hCaptchaSizeAccess$400 = c11151aBuilder.f21689p;
            if (!c11151aBuilder.f21688o) {
                hCaptchaSizeAccess$400 = HCaptchaConfig.access$400();
            }
            HCaptchaSize hCaptchaSize = hCaptchaSizeAccess$400;
            HCaptchaTheme hCaptchaThemeAccess$500 = c11151aBuilder.f21691r;
            if (!c11151aBuilder.f21690q) {
                hCaptchaThemeAccess$500 = HCaptchaConfig.access$500();
            }
            HCaptchaConfig hCaptchaConfig = new HCaptchaConfig(c11151aBuilder.f21674a, bool, bool2, c11151aBuilder.f21679f, str, c11151aBuilder.f21682i, c11151aBuilder.f21683j, c11151aBuilder.f21684k, c11151aBuilder.f21685l, str2, hCaptchaSize, hCaptchaThemeAccess$500);
            C5065a c5065a = new C5065a(activity2);
            HCaptcha$1 hCaptcha$1 = new HCaptcha$1(c5065a);
            String str3 = C5067c.f13582j;
            Bundle bundle = new Bundle();
            bundle.putSerializable("hCaptchaConfig", hCaptchaConfig);
            bundle.putParcelable("hCaptchaDialogListener", hCaptcha$1);
            C5067c c5067c = new C5067c();
            c5067c.setArguments(bundle);
            c5067c.show(c5065a.f13580e, C5067c.f13582j);
            c5065a.f13596c.add(new AnonymousClass1(emitter));
            c5065a.m7120a();
            c5065a.f13597d.add(new AnonymousClass2(emitter, captchaHelper3));
            c5065a.m7120a();
        }
    }

    private CaptchaHelper() {
    }

    public static final /* synthetic */ void access$ensurePlayServicesAvailable(CaptchaHelper captchaHelper, GoogleApiAvailability googleApiAvailability, Activity activity, Function0 function0, Function1 function1) throws PackageManager.NameNotFoundException {
        captchaHelper.ensurePlayServicesAvailable(googleApiAvailability, activity, function0, function1);
    }

    public static final /* synthetic */ void access$showCaptcha(CaptchaHelper captchaHelper, SafetyNetClient safetyNetClient, Function1 function1, Function1 function12) {
        captchaHelper.showCaptcha(safetyNetClient, function1, function12);
    }

    private final void ensurePlayServicesAvailable(GoogleApiAvailability googleApiAvailability, Activity activity, Function0<Unit> function0, Function1<? super Failure, Unit> function1) throws PackageManager.NameNotFoundException {
        int iM9024c = googleApiAvailability.m9024c(activity);
        if (iM9024c == 0 || !googleApiAvailability.m9025d(iM9024c)) {
            if (iM9024c == 0) {
                function0.invoke();
                return;
            } else {
                function1.invoke(new Failure(C5419R.string.captcha_failed_unsupported, FAILED_DEVICE_UNSUPPORTED));
                return;
            }
        }
        Task<Void> taskM9026e = googleApiAvailability.m9026e(activity);
        C67131 c67131 = new C67131(function0);
        C4358c0 c4358c0 = (C4358c0) taskM9026e;
        Objects.requireNonNull(c4358c0);
        Executor executor = C4363g.f11479a;
        c4358c0.mo6012g(executor, c67131);
        c4358c0.mo6010e(executor, new C67142(function1));
        Intrinsics3.checkNotNullExpressionValue(c4358c0, "makeGooglePlayServicesAv…ISSING_DEPS))\n          }");
    }

    private final void showCaptcha(SafetyNetClient safetyNetClient, Function1<? super String, Unit> function1, Function1<? super Failure, Unit> function12) {
        Objects.requireNonNull(safetyNetClient);
        SafetyNetApi safetyNetApi = C4327a.f11446d;
        AbstractC3268c abstractC3268c = safetyNetClient.f9332g;
        Objects.requireNonNull((C3962i) safetyNetApi);
        if (TextUtils.isEmpty(RECAPTCHA_SITE_KEY)) {
            throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
        }
        AbstractC3284d abstractC3284dMo4048a = abstractC3268c.mo4048a(new C3963j(abstractC3268c, RECAPTCHA_SITE_KEY));
        C3385v c3385v = new C3385v(new SafetyNetApi.RecaptchaTokenResponse());
        C3363k.b bVar = C3363k.f9531a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        abstractC3284dMo4048a.mo4051c(new C3379s(abstractC3284dMo4048a, taskCompletionSource, c3385v, bVar));
        Task task = taskCompletionSource.f20845a;
        C67151 c67151 = new C67151(function1);
        Objects.requireNonNull(task);
        Executor executor = C4363g.f11479a;
        task.mo6012g(executor, c67151);
        task.mo6010e(executor, new C67162(function12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showCaptchaHelpDialog$default(CaptchaHelper captchaHelper, AppActivity appActivity, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        captchaHelper.showCaptchaHelpDialog(appActivity, function0);
    }

    public final String getCaptchaRqtoken() {
        return captchaRqtoken;
    }

    public final String getCaptchaToken() {
        return captchaToken;
    }

    public final void setCaptchaRqtoken(String str) {
        captchaRqtoken = str;
    }

    public final void setCaptchaToken(String str) {
        captchaToken = str;
    }

    public final void showCaptchaHelpDialog(AppActivity activity, Function0<Unit> onOpenBrowser) {
        FragmentManager supportFragmentManager;
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(activity).setTitle(C5419R.string.captcha_problems).setMessage(C5419R.string.captcha_problems_info).setPositiveButton(C5419R.string.captcha_open_browser, new CaptchaHelper2(activity, onOpenBrowser)), C5419R.string.cancel, (Function1) null, 2, (Object) null);
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "it");
        negativeButton$default.show(supportFragmentManager);
    }

    public final Observable<String> tryShowCaptcha(CaptchaRequest captchaRequest) {
        Intrinsics3.checkNotNullParameter(captchaRequest, "captchaRequest");
        Observable<String> observableM11080o = Observable.m11080o(new C67171(captchaRequest), Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableM11080o;
    }
}
