package b.i.a.c.x2.h0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import b.i.a.c.x2.u;

/* compiled from: XingSeeker.java */
/* loaded from: classes3.dex */
public final class i implements g {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1208b;
    public final long c;
    public final long d;
    public final long e;

    @Nullable
    public final long[] f;

    public i(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.a = j;
        this.f1208b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // b.i.a.c.x2.h0.g
    public long a() {
        return this.e;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return this.f != null;
    }

    @Override // b.i.a.c.x2.h0.g
    public long d(long j) {
        long j2 = j - this.a;
        if (!c() || j2 <= this.f1208b) {
            return 0L;
        }
        long[] jArr = this.f;
        b.c.a.a0.d.H(jArr);
        double d = (j2 * 256.0d) / this.d;
        int iE = e0.e(jArr, (long) d, true, true);
        long j3 = this.c;
        long j4 = (iE * j3) / 100;
        long j5 = jArr[iE];
        int i = iE + 1;
        long j6 = (j3 * i) / 100;
        return Math.round((j5 == (iE == 99 ? 256L : jArr[i]) ? 0.0d : (d - j5) / (r0 - j5)) * (j6 - j4)) + j4;
    }

    @Override // b.i.a.c.x2.t
    public t.a h(long j) {
        if (!c()) {
            return new t.a(new u(0L, this.a + this.f1208b));
        }
        long jI = e0.i(j, 0L, this.c);
        double d = (jI * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.f;
                b.c.a.a0.d.H(jArr);
                double d3 = jArr[i];
                d2 = d3 + (((i == 99 ? 256.0d : r3[i + 1]) - d3) * (d - i));
            }
        }
        return new t.a(new u(jI, this.a + e0.i(Math.round((d2 / 256.0d) * this.d), this.f1208b, this.d - 1)));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.c;
    }
}
