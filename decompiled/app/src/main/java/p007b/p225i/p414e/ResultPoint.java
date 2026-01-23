package p007b.p225i.p414e;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.e.k, reason: use source file name */
/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResultPoint {

    /* JADX INFO: renamed from: a */
    public final float f13207a;

    /* JADX INFO: renamed from: b */
    public final float f13208b;

    public ResultPoint(float f, float f2) {
        this.f13207a = f;
        this.f13208b = f2;
    }

    /* JADX INFO: renamed from: a */
    public static float m6922a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return C3404f.m4237Q(resultPoint.f13207a, resultPoint.f13208b, resultPoint2.f13207a, resultPoint2.f13208b);
    }

    /* JADX INFO: renamed from: b */
    public static void m6923b(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fM6922a = m6922a(resultPointArr[0], resultPointArr[1]);
        float fM6922a2 = m6922a(resultPointArr[1], resultPointArr[2]);
        float fM6922a3 = m6922a(resultPointArr[0], resultPointArr[2]);
        if (fM6922a2 >= fM6922a && fM6922a2 >= fM6922a3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fM6922a3 < fM6922a2 || fM6922a3 < fM6922a) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        float f = resultPoint.f13207a;
        float f2 = resultPoint.f13208b;
        if (((resultPoint2.f13208b - f2) * (resultPoint3.f13207a - f)) - ((resultPoint2.f13207a - f) * (resultPoint3.f13208b - f2)) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f13207a == resultPoint.f13207a && this.f13208b == resultPoint.f13208b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f13208b) + (Float.floatToIntBits(this.f13207a) * 31);
    }

    public final String toString() {
        return "(" + this.f13207a + ',' + this.f13208b + ')';
    }
}
