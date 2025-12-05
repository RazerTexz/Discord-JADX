package p007b.p225i.p226a.p242c.p267x2.p273h0;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;

/* compiled from: VbriSeeker.java */
/* renamed from: b.i.a.c.x2.h0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class VbriSeeker implements Seeker {

    /* renamed from: a */
    public final long[] f8336a;

    /* renamed from: b */
    public final long[] f8337b;

    /* renamed from: c */
    public final long f8338c;

    /* renamed from: d */
    public final long f8339d;

    public VbriSeeker(long[] jArr, long[] jArr2, long j, long j2) {
        this.f8336a = jArr;
        this.f8337b = jArr2;
        this.f8338c = j;
        this.f8339d = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: a */
    public long mo3689a() {
        return this.f8339d;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: d */
    public long mo3690d(long j) {
        return this.f8336a[Util2.m2997e(this.f8337b, j, true, true)];
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        int iM2997e = Util2.m2997e(this.f8336a, j, true, true);
        long[] jArr = this.f8336a;
        long j2 = jArr[iM2997e];
        long[] jArr2 = this.f8337b;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[iM2997e]);
        if (j2 >= j || iM2997e == jArr.length - 1) {
            return new SeekMap.a(seekPoint);
        }
        int i = iM2997e + 1;
        return new SeekMap.a(seekPoint, new SeekPoint(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8338c;
    }
}
