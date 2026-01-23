package p007b.p225i.p414e.p434s.p436c;

import com.google.zxing.NotFoundException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX INFO: renamed from: b.i.e.s.c.c, reason: use source file name */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public class Detector4 {

    /* JADX INFO: renamed from: a */
    public final BitMatrix f13568a;

    /* JADX INFO: renamed from: b */
    public ResultPointCallback f13569b;

    public Detector4(BitMatrix bitMatrix) {
        this.f13568a = bitMatrix;
    }

    /* JADX INFO: renamed from: a */
    public final float m7109a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fM7112d = m7112d((int) resultPoint.f13207a, (int) resultPoint.f13208b, (int) resultPoint2.f13207a, (int) resultPoint2.f13208b);
        float fM7112d2 = m7112d((int) resultPoint2.f13207a, (int) resultPoint2.f13208b, (int) resultPoint.f13207a, (int) resultPoint.f13208b);
        return Float.isNaN(fM7112d) ? fM7112d2 / 7.0f : Float.isNaN(fM7112d2) ? fM7112d / 7.0f : (fM7112d + fM7112d2) / 14.0f;
    }

    /* JADX INFO: renamed from: b */
    public final AlignmentPattern m7110b(float f, int i, int i2, float f2) throws NotFoundException {
        AlignmentPattern alignmentPatternM7108c;
        AlignmentPattern alignmentPatternM7108c2;
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f13568a.f13229j - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.f21665l;
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f13568a.f13230k - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw NotFoundException.f21665l;
        }
        AlignmentPatternFinder alignmentPatternFinder = new AlignmentPatternFinder(this.f13568a, iMax, iMax2, iMin, iMin2, f, this.f13569b);
        int i4 = alignmentPatternFinder.f13561c;
        int i5 = alignmentPatternFinder.f13564f;
        int i6 = alignmentPatternFinder.f13563e + i4;
        int i7 = (i5 / 2) + alignmentPatternFinder.f13562d;
        int[] iArr = new int[3];
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i10 = i4;
            while (i10 < i6 && !alignmentPatternFinder.f13559a.m6942f(i10, i9)) {
                i10++;
            }
            int i11 = 0;
            while (i10 < i6) {
                if (!alignmentPatternFinder.f13559a.m6942f(i10, i9)) {
                    if (i11 == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i11 != 2) {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (alignmentPatternFinder.m7107b(iArr) && (alignmentPatternM7108c2 = alignmentPatternFinder.m7108c(iArr, i9, i10)) != null) {
                        return alignmentPatternM7108c2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i11 = 1;
                }
                i10++;
            }
            if (alignmentPatternFinder.m7107b(iArr) && (alignmentPatternM7108c = alignmentPatternFinder.m7108c(iArr, i9, i6)) != null) {
                return alignmentPatternM7108c;
            }
        }
        if (alignmentPatternFinder.f13560b.isEmpty()) {
            throw NotFoundException.f21665l;
        }
        return alignmentPatternFinder.f13560b.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r15 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        return p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4240R(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return Float.NaN;
     */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float m7111c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Detector4 detector4;
        boolean z2;
        boolean z3;
        int i10 = 1;
        boolean z4 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z4) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = (-iAbs) / 2;
        int i12 = i5 < i7 ? 1 : -1;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 + i12;
        int i15 = i5;
        int i16 = i6;
        int i17 = 0;
        while (true) {
            if (i15 == i14) {
                i9 = i14;
                break;
            }
            int i18 = z4 ? i16 : i15;
            int i19 = z4 ? i15 : i16;
            if (i17 == i10) {
                detector4 = this;
                z2 = z4;
                i9 = i14;
                z3 = true;
            } else {
                detector4 = this;
                z2 = z4;
                i9 = i14;
                z3 = false;
            }
            if (z3 == detector4.f13568a.m6942f(i18, i19)) {
                if (i17 == 2) {
                    return C3404f.m4240R(i15, i16, i5, i6);
                }
                i17++;
            }
            i11 += iAbs2;
            if (i11 > 0) {
                if (i16 == i8) {
                    break;
                }
                i16 += i13;
                i11 -= iAbs;
            }
            i15 += i12;
            i14 = i9;
            z4 = z2;
            i10 = 1;
        }
    }

    /* JADX INFO: renamed from: d */
    public final float m7112d(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float fM7111c = m7111c(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = i / (i - i5);
            i5 = 0;
        } else {
            int i7 = this.f13568a.f13229j;
            if (i5 >= i7) {
                float f3 = ((i7 - 1) - i) / (i5 - i);
                int i8 = i7 - 1;
                f = f3;
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f4 = i2;
        int i9 = (int) (f4 - ((i4 - i2) * f));
        if (i9 < 0) {
            f2 = f4 / (i2 - i9);
        } else {
            int i10 = this.f13568a.f13230k;
            if (i9 >= i10) {
                f2 = ((i10 - 1) - i2) / (i9 - i2);
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (m7111c(i, i2, (int) (((i5 - i) * f2) + i), i6) + fM7111c) - 1.0f;
    }
}
