package p007b.p225i.p414e.p430r.p431d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX INFO: renamed from: b.i.e.r.d.c, reason: use source file name */
/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BoundingBox {

    /* JADX INFO: renamed from: a */
    public final BitMatrix f13470a;

    /* JADX INFO: renamed from: b */
    public final ResultPoint f13471b;

    /* JADX INFO: renamed from: c */
    public final ResultPoint f13472c;

    /* JADX INFO: renamed from: d */
    public final ResultPoint f13473d;

    /* JADX INFO: renamed from: e */
    public final ResultPoint f13474e;

    /* JADX INFO: renamed from: f */
    public final int f13475f;

    /* JADX INFO: renamed from: g */
    public final int f13476g;

    /* JADX INFO: renamed from: h */
    public final int f13477h;

    /* JADX INFO: renamed from: i */
    public final int f13478i;

    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z2 = resultPoint == null || resultPoint2 == null;
        boolean z3 = resultPoint3 == null || resultPoint4 == null;
        if (z2 && z3) {
            throw NotFoundException.f21665l;
        }
        if (z2) {
            resultPoint = new ResultPoint(0.0f, resultPoint3.f13208b);
            resultPoint2 = new ResultPoint(0.0f, resultPoint4.f13208b);
        } else if (z3) {
            int i = bitMatrix.f13229j;
            resultPoint3 = new ResultPoint(i - 1, resultPoint.f13208b);
            resultPoint4 = new ResultPoint(i - 1, resultPoint2.f13208b);
        }
        this.f13470a = bitMatrix;
        this.f13471b = resultPoint;
        this.f13472c = resultPoint2;
        this.f13473d = resultPoint3;
        this.f13474e = resultPoint4;
        this.f13475f = (int) Math.min(resultPoint.f13207a, resultPoint2.f13207a);
        this.f13476g = (int) Math.max(resultPoint3.f13207a, resultPoint4.f13207a);
        this.f13477h = (int) Math.min(resultPoint.f13208b, resultPoint3.f13208b);
        this.f13478i = (int) Math.max(resultPoint2.f13208b, resultPoint4.f13208b);
    }

    public BoundingBox(BoundingBox boundingBox) {
        this.f13470a = boundingBox.f13470a;
        this.f13471b = boundingBox.f13471b;
        this.f13472c = boundingBox.f13472c;
        this.f13473d = boundingBox.f13473d;
        this.f13474e = boundingBox.f13474e;
        this.f13475f = boundingBox.f13475f;
        this.f13476g = boundingBox.f13476g;
        this.f13477h = boundingBox.f13477h;
        this.f13478i = boundingBox.f13478i;
    }
}
