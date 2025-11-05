package b.f.m.n;

/* compiled from: NativeLoader.java */
/* loaded from: classes3.dex */
public class a {
    public static b a;

    public static synchronized void a(b bVar) {
        if (!b()) {
            synchronized (a.class) {
                if (a != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                a = bVar;
            }
        }
    }

    public static synchronized boolean b() {
        return a != null;
    }

    public static boolean c(String str) {
        return d(str, 0);
    }

    public static boolean d(String str, int i) {
        b bVar;
        synchronized (a.class) {
            bVar = a;
            if (bVar == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return bVar.a(str, i);
    }
}
