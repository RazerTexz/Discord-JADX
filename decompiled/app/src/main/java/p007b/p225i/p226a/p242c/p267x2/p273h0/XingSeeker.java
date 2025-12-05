package p007b.p225i.p226a.p242c.p267x2.p273h0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* compiled from: XingSeeker.java */
/* renamed from: b.i.a.c.x2.h0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class XingSeeker implements Seeker {

    /* renamed from: a */
    public final long f8340a;

    /* renamed from: b */
    public final int f8341b;

    /* renamed from: c */
    public final long f8342c;

    /* renamed from: d */
    public final long f8343d;

    /* renamed from: e */
    public final long f8344e;

    /* renamed from: f */
    @Nullable
    public final long[] f8345f;

    public XingSeeker(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.f8340a = j;
        this.f8341b = i;
        this.f8342c = j2;
        this.f8345f = jArr;
        this.f8343d = j3;
        this.f8344e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: a */
    public long mo3689a() {
        return this.f8344e;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return this.f8345f != null;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: d */
    public long mo3690d(long j) {
        long j2 = j - this.f8340a;
        if (!mo3619c() || j2 <= this.f8341b) {
            return 0L;
        }
        long[] jArr = this.f8345f;
        AnimatableValueParser.m438H(jArr);
        double d = (j2 * 256.0d) / this.f8343d;
        int iM2997e = Util2.m2997e(jArr, (long) d, true, true);
        long j3 = this.f8342c;
        long j4 = (iM2997e * j3) / 100;
        long j5 = jArr[iM2997e];
        int i = iM2997e + 1;
        long j6 = (j3 * i) / 100;
        return Math.round((j5 == (iM2997e == 99 ? 256L : jArr[i]) ? 0.0d : (d - j5) / (r0 - j5)) * (j6 - j4)) + j4;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        if (!mo3619c()) {
            return new SeekMap.a(new SeekPoint(0L, this.f8340a + this.f8341b));
        }
        long jM3001i = Util2.m3001i(j, 0L, this.f8342c);
        double d = (jM3001i * 100.0d) / this.f8342c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.f8345f;
                AnimatableValueParser.m438H(jArr);
                double d3 = jArr[i];
                d2 = d3 + (((i == 99 ? 256.0d : r3[i + 1]) - d3) * (d - i));
            }
        }
        return new SeekMap.a(new SeekPoint(jM3001i, this.f8340a + Util2.m3001i(Math.round((d2 / 256.0d) * this.f8343d), this.f8341b, this.f8343d - 1)));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8342c;
    }
}
