package p007b.p225i.p226a.p242c.p267x2;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.r, reason: use source file name */
/* JADX INFO: compiled from: IndexSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a */
    public final long[] f8988a;

    /* JADX INFO: renamed from: b */
    public final long[] f8989b;

    /* JADX INFO: renamed from: c */
    public final long f8990c;

    /* JADX INFO: renamed from: d */
    public final boolean f8991d;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j) {
        AnimatableValueParser.m531j(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z2 = length > 0;
        this.f8991d = z2;
        if (!z2 || jArr2[0] <= 0) {
            this.f8988a = jArr;
            this.f8989b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.f8988a = jArr3;
            long[] jArr4 = new long[i];
            this.f8989b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f8990c = j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return this.f8991d;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: h */
    public SeekMap.a mo3620h(long j) {
        if (!this.f8991d) {
            return new SeekMap.a(SeekPoint.f8997a);
        }
        int iM2997e = Util2.m2997e(this.f8989b, j, true, true);
        long[] jArr = this.f8989b;
        long j2 = jArr[iM2997e];
        long[] jArr2 = this.f8988a;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[iM2997e]);
        if (j2 == j || iM2997e == jArr.length - 1) {
            return new SeekMap.a(seekPoint);
        }
        int i = iM2997e + 1;
        return new SeekMap.a(seekPoint, new SeekPoint(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8990c;
    }
}
