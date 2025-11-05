package b.i.c.m.d.k;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* loaded from: classes3.dex */
public class p0 implements Thread.UncaughtExceptionHandler {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.s.d f1692b;
    public final Thread.UncaughtExceptionHandler c;
    public final AtomicBoolean d = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    public interface a {
    }

    public p0(a aVar, b.i.c.m.d.s.d dVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = aVar;
        this.f1692b = dVar;
        this.c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.d.set(true);
        try {
            try {
                if (thread == null) {
                    b.i.c.m.d.b.a.d("Could not handle uncaught exception; null thread");
                } else if (th == null) {
                    b.i.c.m.d.b.a.d("Could not handle uncaught exception; null throwable");
                } else {
                    ((b0) this.a).a(this.f1692b, thread, th);
                }
                b.i.c.m.d.b.a.b("Crashlytics completed exception processing. Invoking default exception handler.");
            } catch (Exception e) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                if (bVar.a(6)) {
                    Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", e);
                }
                bVar.b("Crashlytics completed exception processing. Invoking default exception handler.");
            }
            this.c.uncaughtException(thread, th);
            this.d.set(false);
        } catch (Throwable th2) {
            b.i.c.m.d.b.a.b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.c.uncaughtException(thread, th);
            this.d.set(false);
            throw th2;
        }
    }
}
