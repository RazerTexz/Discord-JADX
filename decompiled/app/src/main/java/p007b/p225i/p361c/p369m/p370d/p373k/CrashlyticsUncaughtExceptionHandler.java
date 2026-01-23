package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;

/* JADX INFO: renamed from: b.i.c.m.d.k.p0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    public final a f12365a;

    /* JADX INFO: renamed from: b */
    public final SettingsDataProvider f12366b;

    /* JADX INFO: renamed from: c */
    public final Thread.UncaughtExceptionHandler f12367c;

    /* JADX INFO: renamed from: d */
    public final AtomicBoolean f12368d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b.i.c.m.d.k.p0$a */
    /* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
    public interface a {
    }

    public CrashlyticsUncaughtExceptionHandler(a aVar, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f12365a = aVar;
        this.f12366b = settingsDataProvider;
        this.f12367c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f12368d.set(true);
        try {
            try {
                if (thread == null) {
                    Logger3.f12227a.m6373d("Could not handle uncaught exception; null thread");
                } else if (th == null) {
                    Logger3.f12227a.m6373d("Could not handle uncaught exception; null throwable");
                } else {
                    ((C4611b0) this.f12365a).m6395a(this.f12366b, thread, th);
                }
                Logger3.f12227a.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
            } catch (Exception e) {
                Logger3 logger3 = Logger3.f12227a;
                if (logger3.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", e);
                }
                logger3.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
            }
            this.f12367c.uncaughtException(thread, th);
            this.f12368d.set(false);
        } catch (Throwable th2) {
            Logger3.f12227a.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.f12367c.uncaughtException(thread, th);
            this.f12368d.set(false);
            throw th2;
        }
    }
}
