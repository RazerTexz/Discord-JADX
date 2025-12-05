package p007b.p225i.p226a.p242c.p259f3;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: NalUnitUtil.java */
/* renamed from: b.i.a.c.f3.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class NalUnitUtil {

    /* renamed from: a */
    public static final byte[] f6753a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final float[] f6754b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    public static final Object f6755c = new Object();

    /* renamed from: d */
    public static int[] f6756d = new int[10];

    /* compiled from: NalUnitUtil.java */
    /* renamed from: b.i.a.c.f3.u$a */
    public static final class a {

        /* renamed from: a */
        public final int f6757a;

        /* renamed from: b */
        public final boolean f6758b;

        /* renamed from: c */
        public final int f6759c;

        /* renamed from: d */
        public final int f6760d;

        /* renamed from: e */
        public final int[] f6761e;

        /* renamed from: f */
        public final int f6762f;

        /* renamed from: g */
        public final int f6763g;

        /* renamed from: h */
        public final int f6764h;

        /* renamed from: i */
        public final float f6765i;

        public a(int i, boolean z2, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f) {
            this.f6757a = i;
            this.f6758b = z2;
            this.f6759c = i2;
            this.f6760d = i3;
            this.f6761e = iArr;
            this.f6762f = i4;
            this.f6763g = i6;
            this.f6764h = i7;
            this.f6765i = f;
        }
    }

    /* compiled from: NalUnitUtil.java */
    /* renamed from: b.i.a.c.f3.u$b */
    public static final class b {

        /* renamed from: a */
        public final int f6766a;

        /* renamed from: b */
        public final int f6767b;

        /* renamed from: c */
        public final boolean f6768c;

        public b(int i, int i2, boolean z2) {
            this.f6766a = i;
            this.f6767b = i2;
            this.f6768c = z2;
        }
    }

    /* compiled from: NalUnitUtil.java */
    /* renamed from: b.i.a.c.f3.u$c */
    public static final class c {

        /* renamed from: a */
        public final int f6769a;

        /* renamed from: b */
        public final int f6770b;

        /* renamed from: c */
        public final int f6771c;

        /* renamed from: d */
        public final int f6772d;

        /* renamed from: e */
        public final int f6773e;

        /* renamed from: f */
        public final int f6774f;

        /* renamed from: g */
        public final float f6775g;

        /* renamed from: h */
        public final boolean f6776h;

        /* renamed from: i */
        public final boolean f6777i;

        /* renamed from: j */
        public final int f6778j;

        /* renamed from: k */
        public final int f6779k;

        /* renamed from: l */
        public final int f6780l;

        /* renamed from: m */
        public final boolean f6781m;

        public c(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z2, boolean z3, int i7, int i8, int i9, boolean z4) {
            this.f6769a = i;
            this.f6770b = i2;
            this.f6771c = i3;
            this.f6772d = i4;
            this.f6773e = i5;
            this.f6774f = i6;
            this.f6775g = f;
            this.f6776h = z2;
            this.f6777i = z3;
            this.f6778j = i7;
            this.f6779k = i8;
            this.f6780l = i9;
            this.f6781m = z4;
        }
    }

    /* renamed from: a */
    public static void m3054a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    /* renamed from: b */
    public static int m3055b(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        AnimatableValueParser.m426D(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    /* renamed from: c */
    public static a m3056c(byte[] bArr, int i, int i2) {
        int i3 = 2;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i + 2, i2);
        parsableNalUnitBitArray.m3116j(4);
        int iM3111e = parsableNalUnitBitArray.m3111e(3);
        parsableNalUnitBitArray.m3115i();
        int iM3111e2 = parsableNalUnitBitArray.m3111e(2);
        boolean zM3110d = parsableNalUnitBitArray.m3110d();
        int iM3111e3 = parsableNalUnitBitArray.m3111e(5);
        int i4 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            if (parsableNalUnitBitArray.m3110d()) {
                i4 |= 1 << i5;
            }
        }
        int i6 = 6;
        int[] iArr = new int[6];
        for (int i7 = 0; i7 < 6; i7++) {
            iArr[i7] = parsableNalUnitBitArray.m3111e(8);
        }
        int iM3111e4 = parsableNalUnitBitArray.m3111e(8);
        int i8 = 0;
        for (int i9 = 0; i9 < iM3111e; i9++) {
            if (parsableNalUnitBitArray.m3110d()) {
                i8 += 89;
            }
            if (parsableNalUnitBitArray.m3110d()) {
                i8 += 8;
            }
        }
        parsableNalUnitBitArray.m3116j(i8);
        if (iM3111e > 0) {
            parsableNalUnitBitArray.m3116j((8 - iM3111e) * 2);
        }
        int iM3112f = parsableNalUnitBitArray.m3112f();
        int iM3112f2 = parsableNalUnitBitArray.m3112f();
        if (iM3112f2 == 3) {
            parsableNalUnitBitArray.m3115i();
        }
        int iM3112f3 = parsableNalUnitBitArray.m3112f();
        int iM3112f4 = parsableNalUnitBitArray.m3112f();
        if (parsableNalUnitBitArray.m3110d()) {
            int iM3112f5 = parsableNalUnitBitArray.m3112f();
            int iM3112f6 = parsableNalUnitBitArray.m3112f();
            int iM3112f7 = parsableNalUnitBitArray.m3112f();
            int iM3112f8 = parsableNalUnitBitArray.m3112f();
            iM3112f3 -= (iM3112f5 + iM3112f6) * ((iM3112f2 == 1 || iM3112f2 == 2) ? 2 : 1);
            iM3112f4 -= (iM3112f7 + iM3112f8) * (iM3112f2 == 1 ? 2 : 1);
        }
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        int iM3112f9 = parsableNalUnitBitArray.m3112f();
        for (int i10 = parsableNalUnitBitArray.m3110d() ? 0 : iM3111e; i10 <= iM3111e; i10++) {
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3112f();
        }
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3112f();
        if (parsableNalUnitBitArray.m3110d() && parsableNalUnitBitArray.m3110d()) {
            int i11 = 0;
            int i12 = 4;
            while (i11 < i12) {
                int i13 = 0;
                while (i13 < i6) {
                    if (parsableNalUnitBitArray.m3110d()) {
                        int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                        if (i11 > 1) {
                            parsableNalUnitBitArray.m3113g();
                        }
                        for (int i14 = 0; i14 < iMin; i14++) {
                            parsableNalUnitBitArray.m3113g();
                        }
                    } else {
                        parsableNalUnitBitArray.m3112f();
                    }
                    i13 += i11 == 3 ? 3 : 1;
                    i6 = 6;
                }
                i11++;
                i12 = 4;
                i6 = 6;
                i3 = 2;
            }
        }
        parsableNalUnitBitArray.m3116j(i3);
        if (parsableNalUnitBitArray.m3110d()) {
            parsableNalUnitBitArray.m3116j(8);
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3115i();
        }
        int iM3112f10 = parsableNalUnitBitArray.m3112f();
        boolean zM3110d2 = false;
        int i15 = 0;
        for (int i16 = 0; i16 < iM3112f10; i16++) {
            if (i16 != 0) {
                zM3110d2 = parsableNalUnitBitArray.m3110d();
            }
            if (zM3110d2) {
                parsableNalUnitBitArray.m3115i();
                parsableNalUnitBitArray.m3112f();
                for (int i17 = 0; i17 <= i15; i17++) {
                    if (parsableNalUnitBitArray.m3110d()) {
                        parsableNalUnitBitArray.m3115i();
                    }
                }
            } else {
                int iM3112f11 = parsableNalUnitBitArray.m3112f();
                int iM3112f12 = parsableNalUnitBitArray.m3112f();
                int i18 = iM3112f11 + iM3112f12;
                for (int i19 = 0; i19 < iM3112f11; i19++) {
                    parsableNalUnitBitArray.m3112f();
                    parsableNalUnitBitArray.m3115i();
                }
                for (int i20 = 0; i20 < iM3112f12; i20++) {
                    parsableNalUnitBitArray.m3112f();
                    parsableNalUnitBitArray.m3115i();
                }
                i15 = i18;
            }
        }
        if (parsableNalUnitBitArray.m3110d()) {
            for (int i21 = 0; i21 < parsableNalUnitBitArray.m3112f(); i21++) {
                parsableNalUnitBitArray.m3116j(iM3112f9 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.m3116j(2);
        float f = 1.0f;
        if (parsableNalUnitBitArray.m3110d()) {
            if (parsableNalUnitBitArray.m3110d()) {
                int iM3111e5 = parsableNalUnitBitArray.m3111e(8);
                if (iM3111e5 == 255) {
                    int iM3111e6 = parsableNalUnitBitArray.m3111e(16);
                    int iM3111e7 = parsableNalUnitBitArray.m3111e(16);
                    if (iM3111e6 != 0 && iM3111e7 != 0) {
                        f = iM3111e6 / iM3111e7;
                    }
                } else {
                    float[] fArr = f6754b;
                    if (iM3111e5 < fArr.length) {
                        f = fArr[iM3111e5];
                    } else {
                        outline.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e5, "NalUnitUtil");
                    }
                }
            }
            if (parsableNalUnitBitArray.m3110d()) {
                parsableNalUnitBitArray.m3115i();
            }
            if (parsableNalUnitBitArray.m3110d()) {
                parsableNalUnitBitArray.m3116j(4);
                if (parsableNalUnitBitArray.m3110d()) {
                    parsableNalUnitBitArray.m3116j(24);
                }
            }
            if (parsableNalUnitBitArray.m3110d()) {
                parsableNalUnitBitArray.m3112f();
                parsableNalUnitBitArray.m3112f();
            }
            parsableNalUnitBitArray.m3115i();
            if (parsableNalUnitBitArray.m3110d()) {
                iM3112f4 *= 2;
            }
        }
        return new a(iM3111e2, zM3110d, iM3111e3, i4, iArr, iM3111e4, iM3112f, iM3112f3, iM3112f4, f);
    }

    /* renamed from: d */
    public static b m3057d(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i + 1, i2);
        int iM3112f = parsableNalUnitBitArray.m3112f();
        int iM3112f2 = parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3115i();
        return new b(iM3112f, iM3112f2, parsableNalUnitBitArray.m3110d());
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017d  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c m3058e(byte[] bArr, int i, int i2) {
        int iM3112f;
        boolean z2;
        int i3;
        int iM3112f2;
        boolean z3;
        int i4;
        boolean zM3110d;
        int i5;
        float f;
        int i6;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i + 1, i2);
        int iM3111e = parsableNalUnitBitArray.m3111e(8);
        int iM3111e2 = parsableNalUnitBitArray.m3111e(8);
        int iM3111e3 = parsableNalUnitBitArray.m3111e(8);
        int iM3112f3 = parsableNalUnitBitArray.m3112f();
        if (iM3111e == 100 || iM3111e == 110 || iM3111e == 122 || iM3111e == 244 || iM3111e == 44 || iM3111e == 83 || iM3111e == 86 || iM3111e == 118 || iM3111e == 128 || iM3111e == 138) {
            iM3112f = parsableNalUnitBitArray.m3112f();
            boolean zM3110d2 = iM3112f == 3 ? parsableNalUnitBitArray.m3110d() : false;
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3112f();
            parsableNalUnitBitArray.m3115i();
            if (parsableNalUnitBitArray.m3110d()) {
                int i7 = iM3112f != 3 ? 8 : 12;
                int i8 = 0;
                while (i8 < i7) {
                    if (parsableNalUnitBitArray.m3110d()) {
                        int i9 = i8 < 6 ? 16 : 64;
                        int iM3113g = 8;
                        int i10 = 8;
                        for (int i11 = 0; i11 < i9; i11++) {
                            if (iM3113g != 0) {
                                iM3113g = ((parsableNalUnitBitArray.m3113g() + i10) + 256) % 256;
                            }
                            if (iM3113g != 0) {
                                i10 = iM3113g;
                            }
                        }
                    }
                    i8++;
                }
            }
            z2 = zM3110d2;
        } else {
            iM3112f = 1;
            z2 = false;
        }
        int iM3112f4 = parsableNalUnitBitArray.m3112f() + 4;
        int iM3112f5 = parsableNalUnitBitArray.m3112f();
        if (iM3112f5 == 0) {
            iM3112f2 = parsableNalUnitBitArray.m3112f() + 4;
            i3 = iM3112f5;
        } else {
            if (iM3112f5 == 1) {
                boolean zM3110d3 = parsableNalUnitBitArray.m3110d();
                parsableNalUnitBitArray.m3113g();
                parsableNalUnitBitArray.m3113g();
                long jM3112f = parsableNalUnitBitArray.m3112f();
                i3 = iM3112f5;
                for (int i12 = 0; i12 < jM3112f; i12++) {
                    parsableNalUnitBitArray.m3112f();
                }
                z3 = zM3110d3;
                i4 = 0;
                parsableNalUnitBitArray.m3112f();
                parsableNalUnitBitArray.m3115i();
                int iM3112f6 = parsableNalUnitBitArray.m3112f() + 1;
                int iM3112f7 = parsableNalUnitBitArray.m3112f() + 1;
                zM3110d = parsableNalUnitBitArray.m3110d();
                int i13 = 2 - (zM3110d ? 1 : 0);
                int i14 = iM3112f7 * i13;
                if (!zM3110d) {
                    parsableNalUnitBitArray.m3115i();
                }
                parsableNalUnitBitArray.m3115i();
                int i15 = iM3112f6 * 16;
                int i16 = i14 * 16;
                if (parsableNalUnitBitArray.m3110d()) {
                    i5 = i4;
                } else {
                    int iM3112f8 = parsableNalUnitBitArray.m3112f();
                    int iM3112f9 = parsableNalUnitBitArray.m3112f();
                    int iM3112f10 = parsableNalUnitBitArray.m3112f();
                    int iM3112f11 = parsableNalUnitBitArray.m3112f();
                    if (iM3112f == 0) {
                        i6 = 1;
                        i5 = i4;
                    } else {
                        i5 = i4;
                        int i17 = iM3112f == 3 ? 1 : 2;
                        i13 *= iM3112f == 1 ? 2 : 1;
                        i6 = i17;
                    }
                    i15 -= (iM3112f8 + iM3112f9) * i6;
                    i16 -= (iM3112f10 + iM3112f11) * i13;
                }
                int i18 = i15;
                int i19 = i16;
                if (parsableNalUnitBitArray.m3110d() || !parsableNalUnitBitArray.m3110d()) {
                    f = 1.0f;
                } else {
                    int iM3111e4 = parsableNalUnitBitArray.m3111e(8);
                    if (iM3111e4 == 255) {
                        int iM3111e5 = parsableNalUnitBitArray.m3111e(16);
                        int iM3111e6 = parsableNalUnitBitArray.m3111e(16);
                        if (iM3111e5 != 0 && iM3111e6 != 0) {
                            f = iM3111e5 / iM3111e6;
                        }
                    } else {
                        float[] fArr = f6754b;
                        if (iM3111e4 < fArr.length) {
                            f = fArr[iM3111e4];
                        } else {
                            outline.m852g0(46, "Unexpected aspect_ratio_idc value: ", iM3111e4, "NalUnitUtil");
                            f = 1.0f;
                        }
                    }
                }
                return new c(iM3111e, iM3111e2, iM3111e3, iM3112f3, i18, i19, f, z2, zM3110d, iM3112f4, i3, i5, z3);
            }
            i3 = iM3112f5;
            iM3112f2 = 0;
        }
        i4 = iM3112f2;
        z3 = false;
        parsableNalUnitBitArray.m3112f();
        parsableNalUnitBitArray.m3115i();
        int iM3112f62 = parsableNalUnitBitArray.m3112f() + 1;
        int iM3112f72 = parsableNalUnitBitArray.m3112f() + 1;
        zM3110d = parsableNalUnitBitArray.m3110d();
        int i132 = 2 - (zM3110d ? 1 : 0);
        int i142 = iM3112f72 * i132;
        if (!zM3110d) {
        }
        parsableNalUnitBitArray.m3115i();
        int i152 = iM3112f62 * 16;
        int i162 = i142 * 16;
        if (parsableNalUnitBitArray.m3110d()) {
        }
        int i182 = i152;
        int i192 = i162;
        if (parsableNalUnitBitArray.m3110d()) {
            f = 1.0f;
        }
        return new c(iM3111e, iM3111e2, iM3111e3, iM3112f3, i182, i192, f, z2, zM3110d, iM3112f4, i3, i5, z3);
    }

    /* renamed from: f */
    public static int m3059f(byte[] bArr, int i) {
        int i2;
        synchronized (f6755c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    }
                    i3++;
                }
                if (i3 < i) {
                    int[] iArr = f6756d;
                    if (iArr.length <= i4) {
                        f6756d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f6756d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f6756d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }
}
