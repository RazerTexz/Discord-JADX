package p007b.p195g.p196a.p198b.p202r;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CharsToNameCanonicalizer.java */
/* renamed from: b.g.a.b.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class CharsToNameCanonicalizer {

    /* compiled from: CharsToNameCanonicalizer.java */
    /* renamed from: b.g.a.b.r.b$a */
    public static final class a {
    }

    /* compiled from: CharsToNameCanonicalizer.java */
    /* renamed from: b.g.a.b.r.b$b */
    public static final class b {
        public b(int i, int i2, String[] strArr, a[] aVarArr) {
        }
    }

    public CharsToNameCanonicalizer(int i) {
        new AtomicReference(new b(0, 0, new String[64], new a[32]));
    }

    /* renamed from: a */
    public static CharsToNameCanonicalizer m1726a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new CharsToNameCanonicalizer((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }
}
