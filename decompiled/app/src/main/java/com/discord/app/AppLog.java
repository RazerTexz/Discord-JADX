package com.discord.app;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.systemlog.SystemLogReport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.webrtc.Logging;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0._Strings;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p654q.ReplaySubject;
import p658rx.subjects.SerializedSubject;

/* compiled from: AppLog.kt */
/* loaded from: classes.dex */
public final class AppLog extends Logger {

    /* renamed from: b, reason: from kotlin metadata */
    public static boolean initCalled;

    /* renamed from: c, reason: from kotlin metadata */
    public static SharedPreferences cache;

    /* renamed from: e, reason: from kotlin metadata */
    public static boolean hasReportedTombstone;

    /* renamed from: g */
    public static final AppLog f14950g = new AppLog();

    /* renamed from: a, reason: from kotlin metadata */
    public static int minLoggingPriority = 99;

    /* renamed from: d, reason: from kotlin metadata */
    public static final SerializedSubject<LoggedItem, LoggedItem> logsSubject = new SerializedSubject<>(new ReplaySubject(new ReplaySubject.d(new ReplaySubject.c(5000))));

    /* renamed from: f, reason: from kotlin metadata */
    public static final String[] PACKAGE_MARKERS = {BuildConfig.APPLICATION_ID, "co.discord"};

    /* compiled from: AppLog.kt */
    public static final /* data */ class LoggedItem implements MGRecyclerDataPayload {

        /* renamed from: j, reason: from kotlin metadata */
        public final String key;

        /* renamed from: k, reason: from kotlin metadata */
        public final int priority;

        /* renamed from: l, reason: from kotlin metadata */
        public final String message;

        /* renamed from: m, reason: from kotlin metadata */
        public final Throwable throwable;

        public LoggedItem(int i, String str, Throwable th) {
            Intrinsics3.checkNotNullParameter(str, "message");
            this.priority = i;
            this.message = str;
            this.throwable = th;
            String string = UUID.randomUUID().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
            this.key = string;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedItem)) {
                return false;
            }
            LoggedItem loggedItem = (LoggedItem) other;
            return this.priority == loggedItem.priority && Intrinsics3.areEqual(this.message, loggedItem.message) && Intrinsics3.areEqual(this.throwable, loggedItem.throwable);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return 0;
        }

        public int hashCode() {
            int i = this.priority * 31;
            String str = this.message;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Throwable th = this.throwable;
            return iHashCode + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("LoggedItem(priority=");
            sbM833U.append(this.priority);
            sbM833U.append(", message=");
            sbM833U.append(this.message);
            sbM833U.append(", throwable=");
            sbM833U.append(this.throwable);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: AppLog.kt */
    /* renamed from: com.discord.app.AppLog$a */
    public static final class C5452a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ int $priority;
        public final /* synthetic */ Throwable $throwable;

        /* compiled from: AppLog.kt */
        /* renamed from: com.discord.app.AppLog$a$a */
        public static final class a extends Lambda implements Function2<String, Integer, Unit> {
            public a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(String str, int i) {
                Intrinsics3.checkNotNullParameter(str, "message");
                Iterator<T> it = _Strings.chunked(str, i).iterator();
                while (it.hasNext()) {
                    Log.println(C5452a.this.$priority, AppLog.f14950g.getDefaultTag(), (String) it.next());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5452a(int i, Map map, Throwable th) {
            super(1);
            this.$priority = i;
            this.$metadata = map;
            this.$throwable = th;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set setEntrySet;
            String strJoinToString$default;
            Intrinsics3.checkNotNullParameter(str, "message");
            a aVar = new a();
            aVar.invoke(str, 1000);
            Map map = this.$metadata;
            if (map != null && (setEntrySet = map.entrySet()) != null && (strJoinToString$default = _Collections.joinToString$default(setEntrySet, "\n\t", null, null, 0, null, null, 62, null)) != null) {
                aVar.invoke("Metadata: " + strJoinToString$default, Integer.MAX_VALUE);
            }
            String stackTraceString = Log.getStackTraceString(this.$throwable);
            Intrinsics3.checkNotNullExpressionValue(stackTraceString, "Log.getStackTraceString(throwable)");
            aVar.invoke(stackTraceString, 1000);
        }
    }

    /* compiled from: AppLog.kt */
    /* renamed from: com.discord.app.AppLog$b */
    public static final class C5453b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ Throwable $throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5453b(Throwable th, Map map) {
            super(1);
            this.$throwable = th;
            this.$metadata = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set<Map.Entry> setEntrySet;
            Intrinsics3.checkNotNullParameter(str, "message");
            try {
                if (this.$throwable != null) {
                    AppLog.f14950g.recordBreadcrumb("Message " + str, "Error");
                }
                Map map = this.$metadata;
                if (map != null && (setEntrySet = map.entrySet()) != null) {
                    for (Map.Entry entry : setEntrySet) {
                        AppLog.f14950g.recordBreadcrumb("Metadata: " + ((String) entry.getKey()) + ", " + ((String) entry.getValue()), "Error");
                    }
                }
                Exception exc = new Exception(str, this.$throwable);
                AppLog appLog = AppLog.f14950g;
                StackTraceElement[] stackTrace = exc.getStackTrace();
                Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                exc.setStackTrace(AppLog.m8356a(appLog, stackTrace, str));
                Throwable cause = exc.getCause();
                if (cause != null) {
                    StackTraceElement[] stackTrace2 = cause.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace2, "cause.stackTrace");
                    cause.setStackTrace(AppLog.m8356a(appLog, stackTrace2, str));
                }
                FirebaseCrashlytics.getInstance().recordException(exc);
            } catch (Exception e) {
                AppLog.f14950g.mo8370w("Unable to notify error logging.", e);
            }
            if (this.$throwable != null) {
                try {
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.$throwable.getClass().toString());
                    sb.append(":\n");
                    StackTraceElement[] stackTrace3 = this.$throwable.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace3, "throwable.stackTrace");
                    sb.append(_Arrays.joinToString$default(stackTrace3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    analyticsTracker.appExceptionThrown(sb.toString());
                } catch (Exception e2) {
                    AppLog.f14950g.mo8370w("Unable to report to analytics.", e2);
                }
            }
        }
    }

    /* compiled from: AppLog.kt */
    /* renamed from: com.discord.app.AppLog$c */
    public static final /* synthetic */ class C5454c extends FunctionReferenceImpl implements Function2<String, Throwable, Unit> {
        public C5454c(AppLog appLog) {
            super(2, appLog, AppLog.class, "v", "v(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Throwable th) {
            String str2 = str;
            Intrinsics3.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).mo8368v(str2, th);
            return Unit.f27425a;
        }
    }

    public AppLog() {
        super("Discord");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final StackTraceElement[] m8356a(AppLog appLog, StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        boolean z2;
        String className;
        Objects.requireNonNull(appLog);
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className2 = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            boolean z3 = Strings4.contains$default((CharSequence) className2, (CharSequence) "MediaEngineLegacy", false, 2, (Object) null) && Intrinsics3.areEqual(stackTraceElement.getMethodName(), "e");
            String className3 = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className3, "stackTraceElement.className");
            String name = Logger.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "Logger::class.java.name");
            if (!Strings4.contains$default((CharSequence) className3, (CharSequence) name, false, 2, (Object) null)) {
                String className4 = stackTraceElement.getClassName();
                Intrinsics3.checkNotNullExpressionValue(className4, "stackTraceElement.className");
                String name2 = Logging.class.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "Logging::class.java.name");
                if (!Strings4.contains$default((CharSequence) className4, (CharSequence) name2, false, 2, (Object) null)) {
                    String className5 = stackTraceElement.getClassName();
                    Intrinsics3.checkNotNullExpressionValue(className5, "stackTraceElement.className");
                    String name3 = AppLog.class.getName();
                    Intrinsics3.checkNotNullExpressionValue(name3, "AppLog::class.java.name");
                    boolean z4 = Strings4.contains$default((CharSequence) className5, (CharSequence) name3, false, 2, (Object) null);
                    if ((z4 || z3) ? false : true) {
                        break;
                    }
                    i2++;
                }
            }
        }
        int length2 = stackTraceElementArr.length - i2;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length2];
        System.arraycopy(stackTraceElementArr, i2, stackTraceElementArr2, 0, length2);
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTraceElementArr2[i3];
            String[] strArr = PACKAGE_MARKERS;
            int length3 = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z2 = false;
                    break;
                }
                if ((stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null || !Strings4.contains$default((CharSequence) className, (CharSequence) strArr[i4], false, 2, (Object) null)) ? false : true) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (z2) {
                i = i3;
                break;
            }
            i3++;
        }
        int i5 = i > 0 ? i : 0;
        StackTraceElement stackTraceElement3 = stackTraceElementArr2[i5];
        stackTraceElementArr2[i5] = stackTraceElement3 != null ? new StackTraceElement(stackTraceElement3.getClassName(), stackTraceElement3.getMethodName(), outline.m886y(stackTraceElement3.getFileName(), ", ", str), stackTraceElement3.getLineNumber()) : null;
        return stackTraceElementArr2;
    }

    /* renamed from: g */
    public static final void m8357g(Long userId, String userLogin, String username) {
        String strValueOf;
        if (initCalled) {
            SharedPreferences sharedPreferences = cache;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
                if (userId != null) {
                    userId.longValue();
                    editorEdit.putString("LOG_CACHE_KEY_USER_ID", String.valueOf(userId));
                }
                if (userLogin != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_LOGIN", userLogin);
                }
                if (username != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_NAME", username);
                }
                editorEdit.apply();
            }
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (userId == null || (strValueOf = String.valueOf(userId.longValue())) == null) {
                strValueOf = "";
            }
            firebaseCrashlytics.setUserId(strValueOf);
            if (userLogin != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userLogin", userLogin);
            }
            if (username != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userName", username);
            }
            if (userId == null || hasReportedTombstone) {
                return;
            }
            hasReportedTombstone = true;
            SystemLogReport.INSTANCE.reportLastCrash();
        }
    }

    /* renamed from: b */
    public final void m8359b(String str, int i, Throwable th, Map<String, String> map) {
        if (i < minLoggingPriority) {
            return;
        }
        C5452a c5452a = new C5452a(i, map, th);
        logsSubject.f27653k.onNext(new LoggedItem(i, str, th));
        C5453b c5453b = new C5453b(th, map);
        if (i == 6) {
            c5453b.invoke2(str);
        }
        c5452a.invoke2(str);
    }

    /* renamed from: c */
    public final void m8360c(String message, String category, Throwable throwable, Function2<? super String, ? super Throwable, Unit> loggingFn) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        Intrinsics3.checkNotNullParameter(loggingFn, "loggingFn");
        if (initCalled) {
            String str = '[' + category + "]: " + message;
            loggingFn.invoke("Breadcrumb, " + str, throwable);
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: d */
    public void mo8361d(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        mo8362d(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: e */
    public void mo8364e(String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(message, "message");
        m8359b(message, 6, throwable, metadata);
    }

    /* renamed from: f */
    public final void m8365f(String from, String to) {
        Intrinsics3.checkNotNullParameter(from, "from");
        Intrinsics3.checkNotNullParameter(to, "to");
        recordBreadcrumb("Navigation [" + from + "] > [" + to + ']', NotificationCompat.CATEGORY_NAVIGATION);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: i */
    public void mo8366i(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        mo8367i(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void recordBreadcrumb(String message, String category) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        m8360c(message, category, null, new C5454c(this));
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: v */
    public void mo8368v(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        m8359b(message, 2, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: w */
    public void mo8369w(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        mo8370w(tag + " -> " + message, throwable);
    }

    /* renamed from: i */
    public static final void m8358i(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        f14950g.mo8367i(message, null);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: d */
    public void mo8362d(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        m8359b(message, 3, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: e */
    public void mo8363e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        mo8364e(tag + " -> " + message, throwable, metadata);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: w */
    public void mo8370w(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        m8359b(message, 5, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    /* renamed from: i */
    public void mo8367i(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        m8359b(message, 4, throwable, null);
    }
}
