package b.g.a.b.r;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CharsToNameCanonicalizer.java */
/* loaded from: classes3.dex */
public final class b {

    /* compiled from: CharsToNameCanonicalizer.java */
    public static final class a {
    }

    /* compiled from: CharsToNameCanonicalizer.java */
    /* renamed from: b.g.a.b.r.b$b, reason: collision with other inner class name */
    public static final class C0082b {
        public C0082b(int i, int i2, String[] strArr, a[] aVarArr) {
        }
    }

    public b(int i) {
        new AtomicReference(new C0082b(0, 0, new String[64], new a[32]));
    }

    public static b a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new b((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }
}
