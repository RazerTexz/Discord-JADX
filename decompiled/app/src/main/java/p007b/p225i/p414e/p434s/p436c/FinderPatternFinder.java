package p007b.p225i.p414e.p434s.p436c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX INFO: renamed from: b.i.e.s.c.e, reason: use source file name */
/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class FinderPatternFinder {

    /* JADX INFO: renamed from: a */
    public final BitMatrix f13572a;

    /* JADX INFO: renamed from: c */
    public boolean f13574c;

    /* JADX INFO: renamed from: e */
    public final ResultPointCallback f13576e;

    /* JADX INFO: renamed from: b */
    public final List<FinderPattern2> f13573b = new ArrayList();

    /* JADX INFO: renamed from: d */
    public final int[] f13575d = new int[5];

    /* JADX INFO: renamed from: b.i.e.s.c.e$b */
    /* JADX INFO: compiled from: FinderPatternFinder.java */
    public static final class b implements Serializable, Comparator<FinderPattern2> {
        private final float average;

        public b(float f, a aVar) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern2 finderPattern2, FinderPattern2 finderPattern22) {
            FinderPattern2 finderPattern23 = finderPattern2;
            FinderPattern2 finderPattern24 = finderPattern22;
            int iCompare = Integer.compare(finderPattern24.f13571d, finderPattern23.f13571d);
            return iCompare == 0 ? Float.compare(Math.abs(finderPattern23.f13570c - this.average), Math.abs(finderPattern24.f13570c - this.average)) : iCompare;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.c.e$c */
    /* JADX INFO: compiled from: FinderPatternFinder.java */
    public static final class c implements Serializable, Comparator<FinderPattern2> {
        private final float average;

        public c(float f, a aVar) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern2 finderPattern2, FinderPattern2 finderPattern22) {
            return Float.compare(Math.abs(finderPattern22.f13570c - this.average), Math.abs(finderPattern2.f13570c - this.average));
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.f13572a = bitMatrix;
        this.f13576e = resultPointCallback;
    }

    /* JADX INFO: renamed from: a */
    public static float m7113a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m7114c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    /* JADX INFO: renamed from: b */
    public final void m7115b(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    /* JADX INFO: renamed from: d */
    public final int[] m7116d() {
        m7115b(this.f13575d);
        return this.f13575d;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0346 A[LOOP:19: B:201:0x02e1->B:215:0x0346, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m7117e(int[] iArr, int i, int i2) {
        float fM7113a;
        float fM7113a2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        int i6 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iM7113a = (int) m7113a(iArr, i2);
        int i7 = iArr[2];
        BitMatrix bitMatrix = this.f13572a;
        int i8 = bitMatrix.f13230k;
        int[] iArrM7116d = m7116d();
        int i9 = i;
        while (i9 >= 0 && bitMatrix.m6942f(iM7113a, i9)) {
            iArrM7116d[2] = iArrM7116d[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            fM7113a = Float.NaN;
        } else {
            while (i9 >= 0 && !bitMatrix.m6942f(iM7113a, i9) && iArrM7116d[1] <= i7) {
                iArrM7116d[1] = iArrM7116d[1] + 1;
                i9--;
            }
            if (i9 >= 0 && iArrM7116d[1] <= i7) {
                while (i9 >= 0 && bitMatrix.m6942f(iM7113a, i9) && iArrM7116d[0] <= i7) {
                    iArrM7116d[0] = iArrM7116d[0] + 1;
                    i9--;
                }
                if (iArrM7116d[0] <= i7) {
                    int i10 = i + 1;
                    while (i10 < i8 && bitMatrix.m6942f(iM7113a, i10)) {
                        iArrM7116d[2] = iArrM7116d[2] + 1;
                        i10++;
                    }
                    if (i10 != i8) {
                        while (i10 < i8 && !bitMatrix.m6942f(iM7113a, i10) && iArrM7116d[3] < i7) {
                            iArrM7116d[3] = iArrM7116d[3] + 1;
                            i10++;
                        }
                        if (i10 != i8 && iArrM7116d[3] < i7) {
                            while (i10 < i8 && bitMatrix.m6942f(iM7113a, i10) && iArrM7116d[4] < i7) {
                                iArrM7116d[4] = iArrM7116d[4] + 1;
                                i10++;
                            }
                            if (iArrM7116d[4] < i7 && Math.abs(((((iArrM7116d[0] + iArrM7116d[1]) + iArrM7116d[2]) + iArrM7116d[3]) + iArrM7116d[4]) - i6) * 5 < i6 * 2 && m7114c(iArrM7116d)) {
                                fM7113a = m7113a(iArrM7116d, i10);
                            }
                        }
                    }
                }
            }
        }
        if (Float.isNaN(fM7113a)) {
            return false;
        }
        int i11 = (int) fM7113a;
        int i12 = iArr[2];
        BitMatrix bitMatrix2 = this.f13572a;
        int i13 = bitMatrix2.f13229j;
        int[] iArrM7116d2 = m7116d();
        int i14 = iM7113a;
        while (i14 >= 0 && bitMatrix2.m6942f(i14, i11)) {
            iArrM7116d2[2] = iArrM7116d2[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            fM7113a2 = Float.NaN;
        } else {
            while (i14 >= 0 && !bitMatrix2.m6942f(i14, i11) && iArrM7116d2[1] <= i12) {
                iArrM7116d2[1] = iArrM7116d2[1] + 1;
                i14--;
            }
            if (i14 >= 0 && iArrM7116d2[1] <= i12) {
                while (i14 >= 0 && bitMatrix2.m6942f(i14, i11) && iArrM7116d2[0] <= i12) {
                    iArrM7116d2[0] = iArrM7116d2[0] + 1;
                    i14--;
                }
                if (iArrM7116d2[0] <= i12) {
                    int i15 = iM7113a + 1;
                    while (i15 < i13 && bitMatrix2.m6942f(i15, i11)) {
                        iArrM7116d2[2] = iArrM7116d2[2] + 1;
                        i15++;
                    }
                    if (i15 != i13) {
                        while (i15 < i13 && !bitMatrix2.m6942f(i15, i11) && iArrM7116d2[3] < i12) {
                            iArrM7116d2[3] = iArrM7116d2[3] + 1;
                            i15++;
                        }
                        if (i15 != i13 && iArrM7116d2[3] < i12) {
                            while (i15 < i13 && bitMatrix2.m6942f(i15, i11) && iArrM7116d2[4] < i12) {
                                iArrM7116d2[4] = iArrM7116d2[4] + 1;
                                i15++;
                            }
                            if (iArrM7116d2[4] < i12 && Math.abs(((((iArrM7116d2[0] + iArrM7116d2[1]) + iArrM7116d2[2]) + iArrM7116d2[3]) + iArrM7116d2[4]) - i6) * 5 < i6 && m7114c(iArrM7116d2)) {
                                fM7113a2 = m7113a(iArrM7116d2, i15);
                            }
                        }
                    }
                }
            }
        }
        if (Float.isNaN(fM7113a2)) {
            return false;
        }
        int i16 = (int) fM7113a2;
        int[] iArrM7116d3 = m7116d();
        int i17 = 0;
        while (i11 >= i17 && i16 >= i17 && this.f13572a.m6942f(i16 - i17, i11 - i17)) {
            iArrM7116d3[2] = iArrM7116d3[2] + 1;
            i17++;
        }
        if (iArrM7116d3[2] == 0) {
            z2 = false;
        } else {
            while (i11 >= i17 && i16 >= i17 && !this.f13572a.m6942f(i16 - i17, i11 - i17)) {
                iArrM7116d3[1] = iArrM7116d3[1] + 1;
                i17++;
            }
            if (iArrM7116d3[1] != 0) {
                while (i11 >= i17 && i16 >= i17 && this.f13572a.m6942f(i16 - i17, i11 - i17)) {
                    iArrM7116d3[0] = iArrM7116d3[0] + 1;
                    i17++;
                }
                if (iArrM7116d3[0] != 0) {
                    BitMatrix bitMatrix3 = this.f13572a;
                    int i18 = bitMatrix3.f13230k;
                    int i19 = bitMatrix3.f13229j;
                    int i20 = 1;
                    while (true) {
                        int i21 = i11 + i20;
                        if (i21 >= i18 || (i5 = i16 + i20) >= i19 || !this.f13572a.m6942f(i5, i21)) {
                            break;
                        }
                        iArrM7116d3[2] = iArrM7116d3[2] + 1;
                        i20++;
                    }
                    while (true) {
                        int i22 = i11 + i20;
                        if (i22 >= i18 || (i4 = i16 + i20) >= i19 || this.f13572a.m6942f(i4, i22)) {
                            break;
                        }
                        iArrM7116d3[3] = iArrM7116d3[3] + 1;
                        i20++;
                    }
                    if (iArrM7116d3[3] != 0) {
                        while (true) {
                            int i23 = i11 + i20;
                            if (i23 >= i18 || (i3 = i16 + i20) >= i19 || !this.f13572a.m6942f(i3, i23)) {
                                break;
                            }
                            iArrM7116d3[4] = iArrM7116d3[4] + 1;
                            i20++;
                        }
                        if (iArrM7116d3[4] != 0) {
                            int i24 = 0;
                            int i25 = 0;
                            while (true) {
                                if (i24 < 5) {
                                    int i26 = iArrM7116d3[i24];
                                    if (i26 == 0) {
                                        break;
                                    }
                                    i25 += i26;
                                    i24++;
                                } else {
                                    if (i25 < 7) {
                                        break;
                                    }
                                    float f = i25 / 7.0f;
                                    float f2 = f / 1.333f;
                                    if (Math.abs(f - iArrM7116d3[0]) >= f2 || Math.abs(f - iArrM7116d3[1]) >= f2 || Math.abs((f * 3.0f) - iArrM7116d3[2]) >= 3.0f * f2 || Math.abs(f - iArrM7116d3[3]) >= f2 || Math.abs(f - iArrM7116d3[4]) >= f2) {
                                        break;
                                    }
                                    z2 = true;
                                }
                            }
                            z2 = false;
                        }
                    }
                }
            }
        }
        if (!z2) {
            return false;
        }
        float f3 = i6 / 7.0f;
        int i27 = 0;
        while (true) {
            if (i27 >= this.f13573b.size()) {
                z3 = false;
                break;
            }
            FinderPattern2 finderPattern2 = this.f13573b.get(i27);
            if (Math.abs(fM7113a - finderPattern2.f13208b) > f3 || Math.abs(fM7113a2 - finderPattern2.f13207a) > f3) {
                z4 = false;
                if (!z4) {
                    List<FinderPattern2> list = this.f13573b;
                    int i28 = finderPattern2.f13571d;
                    int i29 = i28 + 1;
                    float f4 = i28;
                    float f5 = i29;
                    list.set(i27, new FinderPattern2(((finderPattern2.f13207a * f4) + fM7113a2) / f5, ((finderPattern2.f13208b * f4) + fM7113a) / f5, ((f4 * finderPattern2.f13570c) + f3) / f5, i29));
                    z3 = true;
                    break;
                }
                i27++;
            } else {
                float fAbs = Math.abs(f3 - finderPattern2.f13570c);
                if (fAbs <= 1.0f || fAbs <= finderPattern2.f13570c) {
                    z4 = true;
                }
                if (!z4) {
                }
            }
        }
        if (!z3) {
            FinderPattern2 finderPattern22 = new FinderPattern2(fM7113a2, fM7113a, f3);
            this.f13573b.add(finderPattern22);
            ResultPointCallback resultPointCallback = this.f13576e;
            if (resultPointCallback != null) {
                resultPointCallback.m6924a(finderPattern22);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m7118f() {
        int size = this.f13573b.size();
        float fAbs = 0.0f;
        int i = 0;
        float f = 0.0f;
        for (FinderPattern2 finderPattern2 : this.f13573b) {
            if (finderPattern2.f13571d >= 2) {
                i++;
                f += finderPattern2.f13570c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f2 = f / size;
        Iterator<FinderPattern2> it = this.f13573b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().f13570c - f2);
        }
        return fAbs <= f * 0.05f;
    }

    /* JADX INFO: renamed from: g */
    public final void m7119g(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
