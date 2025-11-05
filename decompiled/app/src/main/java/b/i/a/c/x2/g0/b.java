package b.i.a.c.x2.g0;

import b.i.a.c.x2.i;
import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: DefaultEbmlReader.java */
/* loaded from: classes3.dex */
public final class b implements d {
    public final byte[] a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<C0103b> f1183b = new ArrayDeque<>();
    public final g c = new g();
    public c d;
    public int e;
    public int f;
    public long g;

    /* compiled from: DefaultEbmlReader.java */
    /* renamed from: b.i.a.c.x2.g0.b$b, reason: collision with other inner class name */
    public static final class C0103b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1184b;

        public C0103b(int i, long j, a aVar) {
            this.a = i;
            this.f1184b = j;
        }
    }

    public final long a(i iVar, int i) throws IOException {
        iVar.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }
}
