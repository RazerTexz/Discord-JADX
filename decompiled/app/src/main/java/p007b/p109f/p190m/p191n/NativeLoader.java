package p007b.p109f.p190m.p191n;

/* compiled from: NativeLoader.java */
/* renamed from: b.f.m.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public class NativeLoader {

    /* renamed from: a */
    public static NativeLoaderDelegate f4358a;

    /* renamed from: a */
    public static synchronized void m1587a(NativeLoaderDelegate nativeLoaderDelegate) {
        if (!m1588b()) {
            synchronized (NativeLoader.class) {
                if (f4358a != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                f4358a = nativeLoaderDelegate;
            }
        }
    }

    /* renamed from: b */
    public static synchronized boolean m1588b() {
        return f4358a != null;
    }

    /* renamed from: c */
    public static boolean m1589c(String str) {
        return m1590d(str, 0);
    }

    /* renamed from: d */
    public static boolean m1590d(String str, int i) {
        NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (NativeLoader.class) {
            nativeLoaderDelegate = f4358a;
            if (nativeLoaderDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.mo1578a(str, i);
    }
}
