package com.discord.utilities.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import b.d.b.a.a;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InstallReferrer.kt */
/* loaded from: classes2.dex */
public final class InstallReferrer {
    private static final String CACHE_KEY_HAS_EXECUTED = "CACHE_KEY_HAS_EXECUTED";
    private static final String CACHE_KEY_HAS_EXECUTED_ATTEMPTS = "CACHE_KEY_HAS_EXECUTED_ATTEMPTS";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(InstallReferrer$Companion$INSTANCE$2.INSTANCE);
    private static final int MAX_ATTEMPTS = 10;
    private final Context context;
    private final Logger logger;
    private InstallReferrerClient referrerClient;

    /* renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;

    /* compiled from: InstallReferrer.kt */
    public static final class Companion {
        private Companion() {
        }

        private final InstallReferrer getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = InstallReferrer.access$getINSTANCE$cp();
            Companion companion = InstallReferrer.INSTANCE;
            return (InstallReferrer) lazyAccess$getINSTANCE$cp.getValue();
        }

        public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
            m.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
            getINSTANCE().init(onReceivedInstallReferrer);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: InstallReferrer.kt */
    /* renamed from: com.discord.utilities.analytics.InstallReferrer$createReferrerStateListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InstallReferrerStateListener {
        public final /* synthetic */ Function1 $onReceivedInstallReferrer;

        public AnonymousClass1(Function1 function1) {
            this.$onReceivedInstallReferrer = function1;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
            Logger.d$default(InstallReferrer.access$getLogger$p(InstallReferrer.this), "Install referrer service disconnected.", null, 2, null);
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int responseCode) {
            if (responseCode != 0) {
                InstallReferrer.access$setFetchInstallReferrerFailed(InstallReferrer.this, null);
            } else {
                try {
                    Function1 function1 = this.$onReceivedInstallReferrer;
                    ReferrerDetails installReferrer = InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).getInstallReferrer();
                    m.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    m.checkNotNullExpressionValue(installReferrer2, "referrerClient.installReferrer.installReferrer");
                    function1.invoke(installReferrer2);
                    InstallReferrer.access$setFetchInstallReferrerSuccessful(InstallReferrer.this);
                } catch (Exception e) {
                    InstallReferrer.access$setFetchInstallReferrerFailed(InstallReferrer.this, e);
                }
            }
            try {
                InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).endConnection();
            } catch (Exception e2) {
                InstallReferrer.access$getLogger$p(InstallReferrer.this).i("Unable to end connection, likely already dead.", e2);
            }
        }
    }

    private InstallReferrer(Logger logger, Context context) {
        this.logger = logger;
        this.context = context;
        this.sharedPreferences = g.lazy(InstallReferrer$sharedPreferences$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ Logger access$getLogger$p(InstallReferrer installReferrer) {
        return installReferrer.logger;
    }

    public static final /* synthetic */ InstallReferrerClient access$getReferrerClient$p(InstallReferrer installReferrer) {
        InstallReferrerClient installReferrerClient = installReferrer.referrerClient;
        if (installReferrerClient == null) {
            m.throwUninitializedPropertyAccessException("referrerClient");
        }
        return installReferrerClient;
    }

    public static final /* synthetic */ void access$setFetchInstallReferrerFailed(InstallReferrer installReferrer, Exception exc) {
        installReferrer.setFetchInstallReferrerFailed(exc);
    }

    public static final /* synthetic */ void access$setFetchInstallReferrerSuccessful(InstallReferrer installReferrer) throws RemoteException {
        installReferrer.setFetchInstallReferrerSuccessful();
    }

    public static final /* synthetic */ void access$setReferrerClient$p(InstallReferrer installReferrer, InstallReferrerClient installReferrerClient) {
        installReferrer.referrerClient = installReferrerClient;
    }

    private final AnonymousClass1 createReferrerStateListener(Function1<? super String, Unit> onReceivedInstallReferrer) {
        return new AnonymousClass1(onReceivedInstallReferrer);
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences.getValue();
    }

    private final void setFetchInstallReferrerFailed(Exception e) {
        int i = SharedPreferencesProvider.INSTANCE.get().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0);
        this.logger.i("Unable to resolve referrer details, " + i + " attempt.", e);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, i + 1);
        editorEdit.apply();
    }

    private final void setFetchInstallReferrerSuccessful() throws RemoteException {
        InstallReferrerClient installReferrerClient = this.referrerClient;
        if (installReferrerClient == null) {
            m.throwUninitializedPropertyAccessException("referrerClient");
        }
        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
        m.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
        Logger.i$default(this.logger, a.w("Retrieved install referrer, ", installReferrer.getInstallReferrer()), null, 2, null);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(CACHE_KEY_HAS_EXECUTED, true);
        editorEdit.apply();
    }

    private final boolean shouldFetchInstallReferrer() {
        return !getSharedPreferences().getBoolean(CACHE_KEY_HAS_EXECUTED, false) && getSharedPreferences().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0) < 10;
    }

    public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
        m.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
        if (shouldFetchInstallReferrer()) {
            try {
                InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.context).build();
                m.checkNotNullExpressionValue(installReferrerClientBuild, "InstallReferrerClient.newBuilder(context).build()");
                this.referrerClient = installReferrerClientBuild;
                if (installReferrerClientBuild == null) {
                    try {
                        m.throwUninitializedPropertyAccessException("referrerClient");
                    } catch (Exception e) {
                        this.logger.i("Unable to start connection to referrer client.", e);
                        return;
                    }
                }
                installReferrerClientBuild.startConnection(createReferrerStateListener(onReceivedInstallReferrer));
            } catch (Exception e2) {
                this.logger.i("Unable to initialize referrer client.", e2);
            }
        }
    }

    public /* synthetic */ InstallReferrer(Logger logger, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LoggingProvider.INSTANCE.get() : logger, (i & 2) != 0 ? ApplicationProvider.INSTANCE.get() : context);
    }
}
