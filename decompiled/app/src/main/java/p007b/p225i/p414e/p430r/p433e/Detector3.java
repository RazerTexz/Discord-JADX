package p007b.p225i.p414e.p430r.p433e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;

/* compiled from: Detector.java */
/* renamed from: b.i.e.r.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Detector3 {

    /* renamed from: a */
    public static final int[] f13504a = {0, 4, 1, 5};

    /* renamed from: b */
    public static final int[] f13505b = {6, 2, 7, 3};

    /* renamed from: c */
    public static final int[] f13506c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d */
    public static final int[] f13507d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r12 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r1 = r7.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r1.hasNext() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        r2 = (p007b.p225i.p414e.ResultPoint[]) r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r2[1] == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r10 = (int) java.lang.Math.max(r10, r2[1].f13208b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r2[3] == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        r10 = java.lang.Math.max(r10, (int) r2[3].f13208b);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<ResultPoint[]> m7080a(boolean z2, BitMatrix bitMatrix) {
        int i;
        int i2;
        float f;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                int i4 = bitMatrix.f13230k;
                if (iMax >= i4) {
                    break loop0;
                }
                int i5 = bitMatrix.f13229j;
                ResultPoint[] resultPointArr = new ResultPoint[8];
                ResultPoint[] resultPointArrM7082c = m7082c(bitMatrix, i4, i5, iMax, i3, f13506c);
                int[] iArr = f13504a;
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    resultPointArr[iArr[i6]] = resultPointArrM7082c[i6];
                }
                if (resultPointArr[4] != null) {
                    i2 = (int) resultPointArr[4].f13207a;
                    i = (int) resultPointArr[4].f13208b;
                } else {
                    i = iMax;
                    i2 = i3;
                }
                ResultPoint[] resultPointArrM7082c2 = m7082c(bitMatrix, i4, i5, i, i2, f13507d);
                int[] iArr2 = f13505b;
                for (int i7 = 0; i7 < iArr2.length; i7++) {
                    resultPointArr[iArr2[i7]] = resultPointArrM7082c2[i7];
                }
                if (resultPointArr[0] == null && resultPointArr[3] == null) {
                    break;
                }
                arrayList.add(resultPointArr);
                if (!z2) {
                    break loop0;
                }
                if (resultPointArr[2] != null) {
                    i3 = (int) resultPointArr[2].f13207a;
                    f = resultPointArr[2].f13208b;
                } else {
                    i3 = (int) resultPointArr[4].f13207a;
                    f = resultPointArr[4].f13208b;
                }
                iMax = (int) f;
                z3 = true;
            }
            iMax += 5;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static int[] m7081b(BitMatrix bitMatrix, int i, int i2, int i3, boolean z2, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.m6942f(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z3 = z2;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (bitMatrix.m6942f(i, i2) != z3) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (m7083d(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6 = i8;
                }
                iArr2[i6] = 1;
                z3 = !z3;
            }
            i++;
        }
        if (i6 != length - 1 || m7083d(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    /* renamed from: c */
    public static ResultPoint[] m7082c(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z2 = false;
                break;
            }
            int[] iArrM7081b = m7081b(bitMatrix, i4, i8, i2, false, iArr, iArr2);
            if (iArrM7081b != null) {
                int i9 = i8;
                int[] iArr3 = iArrM7081b;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i7 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] iArrM7081b2 = m7081b(bitMatrix, i4, i11, i2, false, iArr, iArr2);
                    if (iArrM7081b2 == null) {
                        i7 = i11 + 1;
                        break;
                    }
                    iArr3 = iArrM7081b2;
                    i10 = i11;
                }
                float f = i7;
                resultPointArr[0] = new ResultPoint(iArr3[0], f);
                resultPointArr[1] = new ResultPoint(iArr3[1], f);
                i8 = i7;
                z2 = true;
            } else {
                i8 += 5;
            }
        }
        int i12 = i8 + 1;
        if (z2) {
            int[] iArr4 = {(int) resultPointArr[0].f13207a, (int) resultPointArr[1].f13207a};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i) {
                    i5 = i14;
                    i6 = i13;
                    break;
                }
                i5 = i14;
                i6 = i13;
                int[] iArrM7081b3 = m7081b(bitMatrix, iArr4[0], i13, i2, false, iArr, iArr2);
                if (iArrM7081b3 != null && Math.abs(iArr4[0] - iArrM7081b3[0]) < 5 && Math.abs(iArr4[1] - iArrM7081b3[1]) < 5) {
                    iArr4 = iArrM7081b3;
                    i14 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i14 = i5 + 1;
                }
                i13 = i6 + 1;
            }
            i12 = i6 - (i5 + 1);
            float f2 = i12;
            resultPointArr[2] = new ResultPoint(iArr4[0], f2);
            resultPointArr[3] = new ResultPoint(iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    /* renamed from: d */
    public static float m7083d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
