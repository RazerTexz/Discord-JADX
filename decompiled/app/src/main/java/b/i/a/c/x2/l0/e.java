package b.i.a.c.x2.l0;

import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import b.i.a.c.x2.u;

/* compiled from: WavSeekMap.java */
/* loaded from: classes3.dex */
public final class e implements t {
    public final c a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1290b;
    public final long c;
    public final long d;
    public final long e;

    public e(c cVar, int i, long j, long j2) {
        this.a = cVar;
        this.f1290b = i;
        this.c = j;
        long j3 = (j2 - j) / cVar.d;
        this.d = j3;
        this.e = b(j3);
    }

    public final long b(long j) {
        return e0.F(j * this.f1290b, 1000000L, this.a.c);
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.t
    public t.a h(long j) {
        long jI = e0.i((this.a.c * j) / (this.f1290b * 1000000), 0L, this.d - 1);
        long j2 = (this.a.d * jI) + this.c;
        long jB = b(jI);
        u uVar = new u(jB, j2);
        if (jB >= j || jI == this.d - 1) {
            return new t.a(uVar);
        }
        long j3 = jI + 1;
        return new t.a(uVar, new u(b(j3), (this.a.d * j3) + this.c));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.e;
    }
}
