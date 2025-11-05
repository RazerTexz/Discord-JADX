package com.discord.utilities.systemlog;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.HistoricalProcessExitReason;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SystemLogReport.kt */
/* loaded from: classes2.dex */
public final class SystemLogReport {
    private static final String CACHE_KEY_LAST_STORED_TOMBSTONE_HASH = "CACHE_KEY_SYSTEM_LOG_STORE_LAST_STORED_TOMBSTONE_HASH";
    public static final SystemLogReport INSTANCE = new SystemLogReport();

    /* compiled from: SystemLogReport.kt */
    /* renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            error.setShouldLog(false);
            error.setShowErrorToasts(false);
            SystemLogReport.access$sendReport(SystemLogReport.INSTANCE, null);
            AppLog.g.i("Checking tombstone error", error.getThrowable());
        }
    }

    /* compiled from: SystemLogReport.kt */
    /* renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<SystemLogUtils.Tombstone, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SystemLogUtils.Tombstone tombstone) {
            invoke2(tombstone);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SystemLogUtils.Tombstone tombstone) {
            Intrinsics3.checkNotNullParameter(tombstone, "crash");
            Iterator it = Strings4.split$default((CharSequence) tombstone.getText(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                AppLog.g.recordBreadcrumb((String) it.next(), "Tombstone");
            }
            AppLog appLog = AppLog.g;
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
        ObservableExtensionsKt.appSubscribe$default(SystemLogUtils.INSTANCE.fetchLastTombstone(), SystemLogReport.class, (Context) null, (Function1) null, AnonymousClass1.INSTANCE, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
    }
}
