package p007b.p085c.p086a.p089b0;

import android.util.Log;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.LottieLogger;

/* compiled from: Logger.java */
/* renamed from: b.c.a.b0.c, reason: use source file name */
/* loaded from: classes.dex */
public class Logger2 {

    /* renamed from: a */
    public static LottieLogger f2296a = new LogcatLogger2();

    /* renamed from: a */
    public static void m639a(String str) {
        Objects.requireNonNull((LogcatLogger2) f2296a);
    }

    /* renamed from: b */
    public static void m640b(String str) {
        Objects.requireNonNull((LogcatLogger2) f2296a);
        Set<String> set = LogcatLogger2.f2295a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        set.add(str);
    }

    /* renamed from: c */
    public static void m641c(String str, Throwable th) {
        Objects.requireNonNull((LogcatLogger2) f2296a);
        Set<String> set = LogcatLogger2.f2295a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }
}
