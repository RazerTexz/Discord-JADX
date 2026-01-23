package com.discord.utilities.systemlog;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.HistoricalProcessExitReason;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: SystemLogReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogReport {
    private static final String CACHE_KEY_LAST_STORED_TOMBSTONE_HASH = "CACHE_KEY_SYSTEM_LOG_STORE_LAST_STORED_TOMBSTONE_HASH";
    public static final SystemLogReport INSTANCE = new SystemLogReport();

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$1 */
    /* JADX INFO: compiled from: SystemLogReport.kt */
    public static final class C69341 extends Lambda implements Function1<Error, Unit> {
        public static final C69341 INSTANCE = new C69341();

        public C69341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            error.setShouldLog(false);
            error.setShowErrorToasts(false);
            SystemLogReport.access$sendReport(SystemLogReport.INSTANCE, null);
            AppLog.f14950g.mo8367i("Checking tombstone error", error.getThrowable());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$2 */
    /* JADX INFO: compiled from: SystemLogReport.kt */
    public static final class C69352 extends Lambda implements Function1<SystemLogUtils.Tombstone, Unit> {
        public static final C69352 INSTANCE = new C69352();

        public C69352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SystemLogUtils.Tombstone tombstone) {
            invoke2(tombstone);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SystemLogUtils.Tombstone tombstone) {
            Intrinsics3.checkNotNullParameter(tombstone, "crash");
            Iterator it = Strings4.split$default((CharSequence) tombstone.getText(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                AppLog.f14950g.recordBreadcrumb((String) it.next(), "Tombstone");
            }
            AppLog appLog = AppLog.f14950g;
            appLog.recordBreadcrumb(tombstone.getGroupHash(), "Tombstone-Hash");
            SystemLogReport systemLogReport = SystemLogReport.INSTANCE;
            boolean zAccess$checkHashChanged = SystemLogReport.access$checkHashChanged(systemLogReport, tombstone.getTextHash());
            if (zAccess$checkHashChanged) {
                Logger.e$default(appLog, "Tombstone", null, null, 6, null);
            }
            if (!zAccess$checkHashChanged) {
                tombstone = null;
            }
            SystemLogReport.access$sendReport(systemLogReport, tombstone);
        }
    }

    private SystemLogReport() {
    }

    public static final /* synthetic */ boolean access$checkHashChanged(SystemLogReport systemLogReport, String str) {
        return systemLogReport.checkHashChanged(str);
    }

    public static final /* synthetic */ void access$sendReport(SystemLogReport systemLogReport, SystemLogUtils.Tombstone tombstone) {
        systemLogReport.sendReport(tombstone);
    }

    private final boolean checkHashChanged(String hash) {
        if (Intrinsics3.areEqual(getPrefsSessionDurable().getString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, null), hash)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, hash);
        editorEdit.apply();
        return true;
    }

    private final SharedPreferences getPrefsSessionDurable() {
        return SharedPreferencesProvider.INSTANCE.getPrefsSessionDurable();
    }

    private final void sendReport(SystemLogUtils.Tombstone tombstone) {
        boolean zDidCrashOnPreviousExecution = FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution();
        HistoricalProcessExitReason.Reason lastReason = HistoricalProcessExitReason.INSTANCE.getLastReason();
        AnalyticsTracker.INSTANCE.appNativeCrash(zDidCrashOnPreviousExecution, lastReason != null ? lastReason.getReason() : null, lastReason != null ? lastReason.getReason() : null, tombstone != null ? tombstone.getGroupHash() : null, tombstone != null ? tombstone.getCause() : null);
    }

    public final void reportLastCrash() {
        ObservableExtensionsKt.appSubscribe$default(SystemLogUtils.INSTANCE.fetchLastTombstone(), SystemLogReport.class, (Context) null, (Function1) null, C69341.INSTANCE, (Function0) null, (Function0) null, C69352.INSTANCE, 54, (Object) null);
    }
}
