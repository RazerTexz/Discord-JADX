package com.discord.stores;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.d.b.a.a;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionAuthorizeIp;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionForgotPassword;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogin;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLoginMfa;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogout;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegister;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.RequiredAction;
import com.discord.api.channel.Channel;
import com.discord.api.fingerprint.FingerprintResponse;
import com.discord.app.AppLog;
import com.discord.models.authentication.AuthState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelLocationMetadata;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.authentication.AuthStateCache;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.t;
import d0.t.n0;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreAuthentication.kt */
/* loaded from: classes2.dex */
public final class StoreAuthentication extends Store {
    private static final String CACHE_KEY_FINGERPRINT = "STORE_AUTHED_FINGERPRINT";
    private static final String CACHE_KEY_LOGIN = "STORE_AUTHED_LOGIN";
    private static final String CACHE_KEY_TOKEN_RNA = "token";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHARED_PREFS_NAME_RNA = "CacheStore";
    private Boolean _isConsentRequired;
    private BehaviorSubject<String> ageGateError;
    private AuthState authState;
    private final AuthStateCache authStateCache;
    private final SerializedSubject<AuthState, AuthState> authStateSubject;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private final SerializedSubject<String, String> fingerprintSubject;
    private Subscription isConsentRequiredSubscription;
    private final SerializedSubject<Uri, Uri> oauthUriSubject;
    private String savedLogin;
    private final StoreStream storeStream;
    private final PublishSubject<Boolean> userInitiatedAuthEventSubject;

    /* compiled from: StoreAuthentication.kt */
    public static final /* data */ class AuthRequestParams {
        private final String guildTemplateCode;
        private final StoreInviteSettings.InviteCode inviteCode;

        public AuthRequestParams(StoreInviteSettings.InviteCode inviteCode, String str) {
            this.inviteCode = inviteCode;
            this.guildTemplateCode = str;
        }

        public static /* synthetic */ AuthRequestParams copy$default(AuthRequestParams authRequestParams, StoreInviteSettings.InviteCode inviteCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inviteCode = authRequestParams.inviteCode;
            }
            if ((i & 2) != 0) {
                str = authRequestParams.guildTemplateCode;
            }
            return authRequestParams.copy(inviteCode, str);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final AuthRequestParams copy(StoreInviteSettings.InviteCode inviteCode, String guildTemplateCode) {
            return new AuthRequestParams(inviteCode, guildTemplateCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthRequestParams)) {
                return false;
            }
            AuthRequestParams authRequestParams = (AuthRequestParams) other;
            return m.areEqual(this.inviteCode, authRequestParams.inviteCode) && m.areEqual(this.guildTemplateCode, authRequestParams.guildTemplateCode);
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        public int hashCode() {
            StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
            int iHashCode = (inviteCode != null ? inviteCode.hashCode() : 0) * 31;
            String str = this.guildTemplateCode;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("AuthRequestParams(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            return a.J(sbU, this.guildTemplateCode, ")");
        }
    }

    /* compiled from: StoreAuthentication.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getDeviceEmail(Companion companion, Context context) {
            return companion.getDeviceEmail(context);
        }

        public static final /* synthetic */ String access$getRnaAuthToken(Companion companion, Context context) {
            return companion.getRnaAuthToken(context);
        }

        @SuppressLint({"MissingPermission"})
        private final String getDeviceEmail(Context context) {
            Account account;
            if (ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS") != 0) {
                return null;
            }
            AccountManager accountManager = AccountManager.get(context);
            m.checkNotNullExpressionValue(accountManager, "AccountManager.get(context)");
            Account[] accounts = accountManager.getAccounts();
            m.checkNotNullExpressionValue(accounts, "AccountManager.get(context).accounts");
            int length = accounts.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    account = null;
                    break;
                }
                account = accounts[i];
                if (Patterns.EMAIL_ADDRESS.matcher(account.type).matches()) {
                    break;
                }
                i++;
            }
            if (account != null) {
                return account.name;
            }
            return null;
        }

        private final String getRnaAuthToken(Context context) {
            String string = context.getSharedPreferences(StoreAuthentication.SHARED_PREFS_NAME_RNA, 0).getString(StoreAuthentication.CACHE_KEY_TOKEN_RNA, null);
            if (string != null) {
                return t.replace$default(string, "\"", "", false, 4, (Object) null);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$authMFA$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
            return invoke2(modelLoginResult);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(ModelLoginResult modelLoginResult) {
            return new TrackNetworkActionUserLoginMfa();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$authMFA$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelLoginResult> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelLoginResult modelLoginResult) {
            call2(modelLoginResult);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelLoginResult modelLoginResult) {
            StoreAuthentication storeAuthentication = StoreAuthentication.this;
            m.checkNotNullExpressionValue(modelLoginResult, "loginResult");
            StoreAuthentication.access$dispatchLogin(storeAuthentication, modelLoginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$authorizeIP$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(Void r1) {
            return new TrackNetworkActionAuthorizeIp();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$dispatchLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ ModelLoginResult $loginResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelLoginResult modelLoginResult) {
            super(0);
            this.$loginResult = modelLoginResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.access$getStoreStream$p(StoreAuthentication.this).handleLoginResult(this.$loginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$forgotPassword$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(Void r1) {
            return new TrackNetworkActionForgotPassword();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<String, Observable<? extends String>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: StoreAuthentication.kt */
        /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<FingerprintResponse, String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ String call(FingerprintResponse fingerprintResponse) {
                return call2(fingerprintResponse);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(FingerprintResponse fingerprintResponse) {
                return fingerprintResponse.getFingerprint();
            }
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends String> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends String> call2(String str) {
            return str != null ? new k(str) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthFingerprint(new RestAPIParams.EmptyBody()), false, 1, null).G(AnonymousClass2.INSTANCE);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<String> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            StoreAuthentication.this.setFingerprint(str, false);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$getShouldShowAgeGate$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<MeUser, String, Channel, StoreNavigation.AgeGate> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ StoreNavigation.AgeGate call(MeUser meUser, String str, Channel channel) {
            return call2(meUser, str, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreNavigation.AgeGate call2(MeUser meUser, String str, Channel channel) {
            long uTCDate = TimeUtils.parseUTCDate("2021-02-05T12:00:00+0000");
            if (!meUser.getHasBirthday() && (meUser.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH > uTCDate) {
                return StoreNavigation.AgeGate.REGISTER_AGE_GATE;
            }
            if (str != null || meUser.getHasBirthday() || channel == null || !channel.getNsfw()) {
                return null;
            }
            return StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE;
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Context context = this.$context;
            m.checkNotNullExpressionValue(bool, "isLoggedIn");
            context.sendBroadcast(new Intent(bool.booleanValue() ? "com.discord.broadcast.LOGGED_IN" : "com.discord.broadcast.LOGGED_OUT"));
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$login$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<String, Observable<? extends ModelLoginResult>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ String $login;
        public final /* synthetic */ String $loginSource;
        public final /* synthetic */ String $password;
        public final /* synthetic */ boolean $undelete;

        /* compiled from: StoreAuthentication.kt */
        /* renamed from: com.discord.stores.StoreAuthentication$login$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02111 extends o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
            public static final C02111 INSTANCE = new C02111();

            public C02111() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
                return invoke2(modelLoginResult);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadataReceiver invoke2(ModelLoginResult modelLoginResult) {
                Observable<T> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getInviteSettings().getInvite(), 250L, false, 2, null).M(StoreAuthentication$login$1$1$invite$1.INSTANCE);
                ModelInvite modelInvite = (ModelInvite) new j0.m.a(observableM).a(observableM.z());
                return new TrackNetworkActionUserLogin(modelInvite != null ? modelInvite.code : null, null, 2);
            }
        }

        public AnonymousClass1(String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3) {
            this.$login = str;
            this.$password = str2;
            this.$captchaPayload = captchaPayload;
            this.$undelete = z2;
            this.$loginSource = str3;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends ModelLoginResult> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelLoginResult> call2(String str) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            String str2 = this.$login;
            String str3 = this.$password;
            CaptchaHelper.CaptchaPayload captchaPayload = this.$captchaPayload;
            String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
            CaptchaHelper.CaptchaPayload captchaPayload2 = this.$captchaPayload;
            return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(api.postAuthLogin(new RestAPIParams.AuthLogin(str2, str3, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null, Boolean.valueOf(this.$undelete), this.$loginSource)), false, 1, null), C02111.INSTANCE);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$login$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelLoginResult> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelLoginResult modelLoginResult) {
            call2(modelLoginResult);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelLoginResult modelLoginResult) {
            if (modelLoginResult.getMfa()) {
                return;
            }
            StoreAuthentication storeAuthentication = StoreAuthentication.this;
            m.checkNotNullExpressionValue(modelLoginResult, "loginResult");
            StoreAuthentication.access$dispatchLogin(storeAuthentication, modelLoginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$logout$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(Void r1) {
            return new TrackNetworkActionUserLogout();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$logout$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Void, Observable<? extends String>> {
        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends String> call(Void r1) {
            return call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends String> call2(Void r1) {
            return StoreAuthentication.access$getFingerprintSnapshotOrGenerate(StoreAuthentication.this);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$logout$3, reason: invalid class name */
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
            StoreStream.INSTANCE.getNux().clearNux();
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, null);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$logout$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Error, Unit> {
        public AnonymousClass4() {
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
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, null);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$onPasswordChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$token = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set<RequiredAction> setEmptySet;
            AuthState authState = StoreAuthentication.this.getAuthState();
            if (authState == null || (setEmptySet = authState.getRequiredActions()) == null) {
                setEmptySet = n0.emptySet();
            }
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, AuthState.INSTANCE.from(this.$token, o0.minus(setEmptySet, RequiredAction.UPDATE_PASSWORD)));
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$register$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<String, Observable<? extends RegisterResponse>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ boolean $consent;
        public final /* synthetic */ String $dateOfBirth;
        public final /* synthetic */ String $email;
        public final /* synthetic */ String $password;
        public final /* synthetic */ String $phoneToken;
        public final /* synthetic */ String $username;

        /* compiled from: StoreAuthentication.kt */
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C02121 extends d0.z.d.k implements Function2<StoreInviteSettings.InviteCode, String, AuthRequestParams> {
            public static final C02121 INSTANCE = new C02121();

            public C02121() {
                super(2, AuthRequestParams.class, "<init>", "<init>(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AuthRequestParams invoke(StoreInviteSettings.InviteCode inviteCode, String str) {
                return invoke2(inviteCode, str);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AuthRequestParams invoke2(StoreInviteSettings.InviteCode inviteCode, String str) {
                return new AuthRequestParams(inviteCode, str);
            }
        }

        /* compiled from: StoreAuthentication.kt */
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<AuthRequestParams, Observable<? extends RegisterResponse>> {
            public final /* synthetic */ String $fingerprint;

            /* compiled from: StoreAuthentication.kt */
            /* renamed from: com.discord.stores.StoreAuthentication$register$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02131 extends o implements Function1<RegisterResponse, TrackNetworkMetadataReceiver> {
                public final /* synthetic */ String $inviteCode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02131(String str) {
                    super(1);
                    this.$inviteCode = str;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(RegisterResponse registerResponse) {
                    return invoke2(registerResponse);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TrackNetworkMetadataReceiver invoke2(RegisterResponse registerResponse) {
                    return new TrackNetworkActionUserRegister(this.$inviteCode, Boolean.valueOf(AnonymousClass1.this.$consent), Boolean.FALSE);
                }
            }

            public AnonymousClass2(String str) {
                this.$fingerprint = str;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(AuthRequestParams authRequestParams) {
                return call2(authRequestParams);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends RegisterResponse> call2(AuthRequestParams authRequestParams) {
                StoreInviteSettings.InviteCode inviteCode = authRequestParams.getInviteCode();
                String inviteCode2 = inviteCode != null ? inviteCode.getInviteCode() : null;
                if (inviteCode2 == null || inviteCode2.length() == 0) {
                    StoreStream.INSTANCE.getNux().setPostRegister(true);
                } else {
                    StoreStream.INSTANCE.getNux().setPostRegisterWithInvite(true);
                }
                RestAPI api = RestAPI.INSTANCE.getApi();
                String str = this.$fingerprint;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                String str2 = anonymousClass1.$username;
                String str3 = anonymousClass1.$email;
                String str4 = anonymousClass1.$phoneToken;
                String str5 = anonymousClass1.$password;
                CaptchaHelper.CaptchaPayload captchaPayload = anonymousClass1.$captchaPayload;
                String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload2 = AnonymousClass1.this.$captchaPayload;
                String captchaRqtoken = captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null;
                String guildTemplateCode = authRequestParams.getGuildTemplateCode();
                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                return RestCallStateKt.logNetworkAction(api.postAuthRegister(new RestAPIParams.AuthRegister(str, str2, str3, str4, str5, captchaKey, captchaRqtoken, inviteCode2, guildTemplateCode, anonymousClass12.$consent, anonymousClass12.$dateOfBirth)), new C02131(inviteCode2));
            }
        }

        /* compiled from: StoreAuthentication.kt */
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T> implements Action1<RegisterResponse> {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(RegisterResponse registerResponse) {
                call2(registerResponse);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(RegisterResponse registerResponse) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getUserSettingsSystem().setIsSyncThemeEnabled(false);
                StoreAuthentication.this.setFingerprint(null, true);
                StoreAuthentication.access$publishAuthState(StoreAuthentication.this, new AuthState(registerResponse.getToken(), n0.emptySet()));
                AnalyticsTracker.INSTANCE.appFirstLogin();
                companion.getNotifications().setEnabledInApp(true, false);
                companion.getNux().setFirstOpen(true);
            }
        }

        public AnonymousClass1(String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5) {
            this.$username = str;
            this.$email = str2;
            this.$phoneToken = str3;
            this.$password = str4;
            this.$captchaPayload = captchaPayload;
            this.$consent = z2;
            this.$dateOfBirth = str5;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends RegisterResponse> call2(String str) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreInviteSettings.InviteCode> inviteCode = companion.getInviteSettings().getInviteCode();
            Observable<String> observableObserveDynamicLinkGuildTemplateCode = companion.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
            C02121 c02121 = C02121.INSTANCE;
            Object storeAuthentication$sam$rx_functions_Func2$0 = c02121;
            if (c02121 != null) {
                storeAuthentication$sam$rx_functions_Func2$0 = new StoreAuthentication$sam$rx_functions_Func2$0(c02121);
            }
            Observable observableJ = Observable.j(inviteCode, observableObserveDynamicLinkGuildTemplateCode, (Func2) storeAuthentication$sam$rx_functions_Func2$0);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…RequestParams\n          )");
            Observable<R> observableA = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 500L, false, 2, null).A(new AnonymousClass2(str));
            m.checkNotNullExpressionValue(observableA, "Observable.combineLatest…        }\n              }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), 0L, false, 3, null).u(new AnonymousClass3());
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelLocationMetadata, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLocationMetadata modelLocationMetadata) {
            invoke2(modelLocationMetadata);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLocationMetadata modelLocationMetadata) {
            m.checkNotNullParameter(modelLocationMetadata, "it");
            StoreAuthentication.access$setConsentRequired$p(StoreAuthentication.this, modelLocationMetadata.getConsentRequired());
            String countryCode = modelLocationMetadata.getCountryCode();
            if (countryCode != null) {
                StoreStream.INSTANCE.getPhone().updateDefaultCountryCode(countryCode);
            }
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$2, reason: invalid class name */
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
            StoreAuthentication.access$setConsentRequired$p(StoreAuthentication.this, true);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "consentSubscription");
            StoreAuthentication.access$setConsentRequiredSubscription$p(StoreAuthentication.this, subscription);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    /* renamed from: com.discord.stores.StoreAuthentication$setAgeGateError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$error = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.handleAgeGateError(this.$error);
        }
    }

    public StoreAuthentication(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userInitiatedAuthEventSubject = PublishSubject.k0();
        this.fingerprintSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.authStateSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        BehaviorSubject<String> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.ageGateError = behaviorSubjectK0;
        this.oauthUriSubject = new SerializedSubject<>(BehaviorSubject.l0(Uri.EMPTY));
        this.authStateCache = new AuthStateCache(getPrefs());
    }

    public static final /* synthetic */ void access$dispatchLogin(StoreAuthentication storeAuthentication, ModelLoginResult modelLoginResult) {
        storeAuthentication.dispatchLogin(modelLoginResult);
    }

    public static final /* synthetic */ AuthState access$getAuthState$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.authState;
    }

    public static final /* synthetic */ Observable access$getFingerprintSnapshotOrGenerate(StoreAuthentication storeAuthentication) {
        return storeAuthentication.getFingerprintSnapshotOrGenerate();
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.storeStream;
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequired();
    }

    public static final /* synthetic */ Subscription access$isConsentRequiredSubscription$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequiredSubscription;
    }

    public static final /* synthetic */ void access$publishAuthState(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.publishAuthState(authState);
    }

    public static final /* synthetic */ void access$setAuthState$p(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.authState = authState;
    }

    public static final /* synthetic */ void access$setConsentRequired$p(StoreAuthentication storeAuthentication, boolean z2) {
        storeAuthentication.setConsentRequired(z2);
    }

    public static final /* synthetic */ void access$setConsentRequiredSubscription$p(StoreAuthentication storeAuthentication, Subscription subscription) {
        storeAuthentication.isConsentRequiredSubscription = subscription;
    }

    private final void dispatchLogin(ModelLoginResult loginResult) {
        this.dispatcher.schedule(new AnonymousClass1(loginResult));
    }

    private final Observable<String> getFingerprintSnapshotOrGenerate() {
        Observable<String> observableU = this.fingerprintSubject.Z(1).Y(AnonymousClass1.INSTANCE).u(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableU, "fingerprintSubject\n     …int(fingerprint, false) }");
        return observableU;
    }

    private final Set<RequiredAction> getRequiredActionsFromLoginResponse(ModelLoginResult loginResult) {
        Set<RequiredAction> set;
        List<RequiredAction> requiredActions = loginResult.getRequiredActions();
        return (requiredActions == null || (set = u.toSet(requiredActions)) == null) ? n0.emptySet() : set;
    }

    public static /* synthetic */ Observable login$default(StoreAuthentication storeAuthentication, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return storeAuthentication.login(str, str2, captchaPayload, z2, str3);
    }

    private final void publishAuthState(AuthState authState) {
        this.authStateSubject.k.onNext(authState);
    }

    public static /* synthetic */ Observable register$default(StoreAuthentication storeAuthentication, String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5, int i, Object obj) {
        return storeAuthentication.register(str, str2, str3, str4, captchaPayload, z2, (i & 64) != 0 ? null : str5);
    }

    private final synchronized void resetIsConsentRequired() {
        this._isConsentRequired = null;
        Subscription subscription = this.isConsentRequiredSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.isConsentRequiredSubscription = null;
    }

    private final synchronized void setConsentRequired(boolean z2) {
        this._isConsentRequired = Boolean.valueOf(z2);
    }

    private final void setSavedLogin(String str) {
        this.savedLogin = str;
        AppLog.g(null, str, null);
        getPrefsSessionDurable().edit().putString(CACHE_KEY_LOGIN, str).apply();
    }

    public final Observable<ModelLoginResult> authMFA(String code, String ticket) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        m.checkNotNullParameter(ticket, "ticket");
        Observable<ModelLoginResult> observableU = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().postMFACode(new RestAPIParams.MFALogin(ticket, code)), AnonymousClass1.INSTANCE), false, 1, null).u(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableU, "RestAPI\n        .api\n   …in(loginResult)\n        }");
        return observableU;
    }

    public final Observable<Void> authorizeIP(String token) {
        m.checkNotNullParameter(token, CACHE_KEY_TOKEN_RNA);
        return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeIP(new RestAPIParams.AuthorizeIP(token)), false, 1, null), AnonymousClass1.INSTANCE);
    }

    public final Observable<Void> forgotPassword(String login, CaptchaHelper.CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(login, "login");
        return ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().forgotPassword(new RestAPIParams.ForgotPassword(login, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), AnonymousClass1.INSTANCE), false, 1, null);
    }

    public final Observable<String> getAgeGateError() {
        Observable<String> observableR = this.ageGateError.r();
        m.checkNotNullExpressionValue(observableR, "ageGateError.distinctUntilChanged()");
        return observableR;
    }

    /* renamed from: getAuthState$app_productionGoogleRelease, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    public final Observable<String> getAuthedToken$app_productionGoogleRelease() {
        Observable observableG = this.authStateSubject.r().G(StoreAuthentication$getAuthedToken$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "authStateSubject.distinc…anged().map { it?.token }");
        return observableG;
    }

    public final Observable<String> getFingerPrint$app_productionGoogleRelease() {
        Observable<String> observableR = this.fingerprintSubject.r();
        m.checkNotNullExpressionValue(observableR, "fingerprintSubject.distinctUntilChanged()");
        return observableR;
    }

    /* renamed from: getFingerprint$app_productionGoogleRelease, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final Observable<Uri> getOAuthUriObservable() {
        Observable<Uri> observableR = this.oauthUriSubject.r();
        m.checkNotNullExpressionValue(observableR, "oauthUriSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getPreLogoutSignal$app_productionGoogleRelease() {
        Observable<Boolean> observableY = this.userInitiatedAuthEventSubject.y(StoreAuthentication$getPreLogoutSignal$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "userInitiatedAuthEventSu…LoggedIn -> !isLoggedIn }");
        return observableY;
    }

    public final String getSavedLogin() {
        return this.savedLogin;
    }

    public final Observable<StoreNavigation.AgeGate> getShouldShowAgeGate() {
        Observable<StoreNavigation.AgeGate> observableR = Observable.i(this.storeStream.getUsers().observeMe(true), this.storeStream.getAuthentication().getAgeGateError(), this.storeStream.getChannelsSelected().observeSelectedChannel(), AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleAgeGateError(String error) {
        this.ageGateError.onNext(error);
    }

    @StoreThread
    public final void handleAuthState$app_productionGoogleRelease(AuthState authState) {
        this.authState = authState;
        this.authStateCache.cacheAuthState(authState);
        if (authState == null) {
            Persister.INSTANCE.reset();
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.clear();
            editorEdit.apply();
        }
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        m.checkNotNullParameter(loginResult, "loginResult");
        setFingerprint(null, true);
        publishAuthState(AuthState.INSTANCE.from(loginResult.getToken(), getRequiredActionsFromLoginResponse(loginResult)));
        if (loginResult.getToken() != null) {
            setAgeGateError(null);
            AnalyticsTracker.INSTANCE.appFirstLogin();
        }
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.TRUE);
        StoreStream.INSTANCE.getNux().setFirstOpen(true);
    }

    @StoreThread
    public final void handlePreLogout$app_productionGoogleRelease() {
        resetIsConsentRequired();
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public synchronized void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        String string = getPrefsSessionDurable().getString(CACHE_KEY_FINGERPRINT, null);
        if (string != null) {
            setFingerprint(string, false);
        }
        AuthState cachedAuthState = this.authStateCache.getCachedAuthState();
        if (cachedAuthState == null) {
            cachedAuthState = AuthState.INSTANCE.from(Companion.access$getRnaAuthToken(INSTANCE, context), n0.emptySet());
        }
        if (AuthState.INSTANCE.isUpdatePasswordRequired(cachedAuthState)) {
            logout();
        } else {
            this.authState = cachedAuthState;
            publishAuthState(cachedAuthState);
        }
        handleAgeGateError(null);
        setSavedLogin(getPrefsSessionDurable().getString(CACHE_KEY_LOGIN, Companion.access$getDeviceEmail(INSTANCE, context)));
        Observable<Boolean> observableR = this.userInitiatedAuthEventSubject.r();
        m.checkNotNullExpressionValue(observableR, "userInitiatedAuthEventSu…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableR)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(context), 62, (Object) null);
    }

    public final boolean isAuthed() {
        return this.authState != null;
    }

    public final synchronized boolean isConsentRequired() {
        Boolean bool;
        bool = this._isConsentRequired;
        return bool != null ? bool.booleanValue() : true;
    }

    public final Observable<ModelLoginResult> login(String login, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete, String loginSource) {
        m.checkNotNullParameter(login, "login");
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(login);
        Observable<ModelLoginResult> observableU = getFingerprintSnapshotOrGenerate().A(new AnonymousClass1(login, password, captchaPayload, undelete, loginSource)).u(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableU, "getFingerprintSnapshotOr…lt)\n          }\n        }");
        return observableU;
    }

    public final void logout() {
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.FALSE);
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().logout(new RestAPIParams.UserDevices(StoreStream.INSTANCE.getNotifications().getPushToken())), AnonymousClass1.INSTANCE), false, 1, null).A(new AnonymousClass2());
        m.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …intSnapshotOrGenerate() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), (Context) null, "logout", (Function1) null, new AnonymousClass3(), new AnonymousClass4(), (Function0) null, (Function0) null, 101, (Object) null);
    }

    public final Observable<Boolean> observeIsAuthed$app_productionGoogleRelease() {
        Observable observableG = m8getAuthState$app_productionGoogleRelease().G(StoreAuthentication$observeIsAuthed$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getAuthState()\n      .ma…te -> authState != null }");
        return observableG;
    }

    public final void onPasswordChanged(String token) {
        this.dispatcher.schedule(new AnonymousClass1(token));
    }

    public final Observable<RegisterResponse> register(String username, String email, String phoneToken, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean consent, String dateOfBirth) {
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(email);
        Observable observableA = getFingerprintSnapshotOrGenerate().A(new AnonymousClass1(username, email, phoneToken, password, captchaPayload, consent, dateOfBirth));
        m.checkNotNullExpressionValue(observableA, "getFingerprintSnapshotOr…              }\n        }");
        return observableA;
    }

    public final synchronized void requestConsentRequired() {
        if (this._isConsentRequired != null) {
            return;
        }
        resetIsConsentRequired();
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getLocationMetadata(), false, 1, null);
        Class<?> cls = getClass();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn$default, cls, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }

    public final void setAgeGateError(String error) {
        this.dispatcher.schedule(new AnonymousClass1(error));
    }

    public final void setAuthed(String authToken) {
        publishAuthState(AuthState.INSTANCE.from(authToken, n0.emptySet()));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0007 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void setFingerprint(String fingerprint, boolean force) {
        if (!force) {
            if (this.fingerprint == null) {
                getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
                this.fingerprint = fingerprint;
                this.fingerprintSubject.k.onNext(fingerprint);
                if (fingerprint != null) {
                    FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
                }
            }
            if (this.fingerprint != null && (!m.areEqual(r3, fingerprint)) && fingerprint != null) {
                String str = this.fingerprint;
                m.checkNotNull(str);
                AnalyticsTracker.externalFingerprintDropped(str, fingerprint);
            }
        }
    }

    public final void setOAuthUriSubject(Uri uri) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.oauthUriSubject.k.onNext(uri);
    }

    /* renamed from: getAuthState$app_productionGoogleRelease, reason: collision with other method in class */
    public final Observable<AuthState> m8getAuthState$app_productionGoogleRelease() {
        Observable<AuthState> observableR = this.authStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "authStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
