package com.discord.utilities.auth;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GoogleSmartLockRepo.kt */
/* loaded from: classes2.dex */
public final class GoogleSmartLockRepo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GoogleSmartLockRepo2.INSTANCE);
    private boolean disableAutoLogin;
    private String pendingIdChange;
    private PublishSubject<GoogleSmartLockManager.SmartLockCredentials> smartLockLogin;
    private GoogleSmartLockRepo3 smartLockLoginAttempt;

    /* compiled from: GoogleSmartLockRepo.kt */
    /* renamed from: com.discord.utilities.auth.GoogleSmartLockRepo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                return;
            }
            GoogleSmartLockRepo.this.setDisableAutoLogin(true);
        }
    }

    /* compiled from: GoogleSmartLockRepo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GoogleSmartLockRepo getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GoogleSmartLockRepo.access$getINSTANCE$cp();
            Companion companion = GoogleSmartLockRepo.INSTANCE;
            return (GoogleSmartLockRepo) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GoogleSmartLockRepo() {
        this(null, 1, null);
    }

    public GoogleSmartLockRepo(StoreAuthentication storeAuthentication) {
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuth");
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.smartLockLogin = publishSubjectK0;
        this.smartLockLoginAttempt = new GoogleSmartLockRepo3(false, false, 3, null);
        ObservableExtensionsKt.appSubscribe$default(storeAuthentication.getPreLogoutSignal$app_productionGoogleRelease(), GoogleSmartLockRepo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean getDisableAutoLogin() {
        return this.disableAutoLogin;
    }

    public final String getPendingIdChange() {
        return this.pendingIdChange;
    }

    public final GoogleSmartLockRepo3 getSmartLockLoginAttempt() {
        return this.smartLockLoginAttempt;
    }

    public final Observable<GoogleSmartLockManager.SmartLockCredentials> getSmartLockLoginObservable() {
        return this.smartLockLogin;
    }

    public final void onLoginWithSmartLockSuccess() {
        if (this.smartLockLoginAttempt.getSignedInWithoutError()) {
            if (this.smartLockLoginAttempt.getUsedAutomaticCredentials()) {
                AnalyticsTracker.INSTANCE.smartLockAutoLogin();
            } else {
                AnalyticsTracker.INSTANCE.smartLockLogin();
            }
        }
    }

    public final void onSmartLockCredentialsFailed() {
        this.smartLockLoginAttempt = GoogleSmartLockRepo3.copy$default(this.smartLockLoginAttempt, false, false, 1, null);
        AnalyticsTracker.INSTANCE.smartLockLoginCredentialsFailed();
    }

    public final void setAttemptToSignInWithSmartLock(boolean usedAutomaticCredentials) {
        this.smartLockLoginAttempt = new GoogleSmartLockRepo3(usedAutomaticCredentials, false, 2, null);
    }

    public final void setDisableAutoLogin(boolean z2) {
        this.disableAutoLogin = z2;
    }

    public final void setPendingIdChange(String str) {
        this.pendingIdChange = str;
    }

    public final void setSmartLockLogin(String id2, String password) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubject = this.smartLockLogin;
        publishSubject.k.onNext(new GoogleSmartLockManager.SmartLockCredentials(id2, password));
    }

    public final void setSmartLockLoginAttempt(GoogleSmartLockRepo3 googleSmartLockRepo3) {
        Intrinsics3.checkNotNullParameter(googleSmartLockRepo3, "<set-?>");
        this.smartLockLoginAttempt = googleSmartLockRepo3;
    }

    public /* synthetic */ GoogleSmartLockRepo(StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication);
    }
}
