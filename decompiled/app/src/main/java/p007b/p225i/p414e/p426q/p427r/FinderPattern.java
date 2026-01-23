package p007b.p225i.p414e.p426q.p427r;

import p007b.p225i.p414e.ResultPoint;

/* JADX INFO: renamed from: b.i.e.q.r.c, reason: use source file name */
/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FinderPattern {

    /* JADX INFO: renamed from: a */
    public final int f13407a;

    /* JADX INFO: renamed from: b */
    public final int[] f13408b;

    /* JADX INFO: renamed from: c */
    public final ResultPoint[] f13409c;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.f13407a = i;
        this.f13408b = iArr;
        float f = i4;
        this.f13409c = new ResultPoint[]{new ResultPoint(i2, f), new ResultPoint(i3, f)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.f13407a == ((FinderPattern) obj).f13407a;
    }

    public int hashCode() {
        return this.f13407a;
    }
}
