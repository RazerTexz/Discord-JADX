package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;

/* compiled from: Logger.java */
/* renamed from: b.i.c.m.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Logger3 {

    /* renamed from: a */
    public static final Logger3 f12227a = new Logger3("FirebaseCrashlytics");

    public Logger3(String str) {
    }

    /* renamed from: a */
    public final boolean m6370a(int i) {
        return 4 <= i || Log.isLoggable("FirebaseCrashlytics", i);
    }

    /* renamed from: b */
    public void m6371b(String str) {
        if (m6370a(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    /* renamed from: c */
    public void m6372c(String str, Throwable th) {
        if (m6370a(3)) {
            Log.d("FirebaseCrashlytics", str, th);
        }
    }

    /* renamed from: d */
    public void m6373d(String str) {
        if (m6370a(6)) {
            Log.e("FirebaseCrashlytics", str, null);
        }
    }

    /* renamed from: e */
    public void m6374e(String str, Throwable th) {
        if (m6370a(6)) {
            Log.e("FirebaseCrashlytics", str, th);
        }
    }

    /* renamed from: f */
    public void m6375f(String str) {
        if (m6370a(4)) {
            Log.i("FirebaseCrashlytics", str, null);
        }
    }

    /* renamed from: g */
    public void m6376g(String str) {
        if (m6370a(5)) {
            Log.w("FirebaseCrashlytics", str, null);
        }
    }
}
