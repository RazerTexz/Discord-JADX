package p007b.p225i.p414e.p418n.p420l;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: GenericGF.java */
/* renamed from: b.i.e.n.l.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class GenericGF {

    /* renamed from: a */
    public static final GenericGF f13299a = new GenericGF(4201, 4096, 1);

    /* renamed from: b */
    public static final GenericGF f13300b = new GenericGF(1033, 1024, 1);

    /* renamed from: c */
    public static final GenericGF f13301c;

    /* renamed from: d */
    public static final GenericGF f13302d;

    /* renamed from: e */
    public static final GenericGF f13303e;

    /* renamed from: f */
    public static final GenericGF f13304f;

    /* renamed from: g */
    public static final GenericGF f13305g;

    /* renamed from: h */
    public static final GenericGF f13306h;

    /* renamed from: i */
    public final int[] f13307i;

    /* renamed from: j */
    public final int[] f13308j;

    /* renamed from: k */
    public final GenericGFPoly f13309k;

    /* renamed from: l */
    public final GenericGFPoly f13310l;

    /* renamed from: m */
    public final int f13311m;

    /* renamed from: n */
    public final int f13312n;

    /* renamed from: o */
    public final int f13313o;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        f13301c = genericGF;
        f13302d = new GenericGF(19, 16, 1);
        f13303e = new GenericGF(285, 256, 0);
        GenericGF genericGF2 = new GenericGF(301, 256, 1);
        f13304f = genericGF2;
        f13305g = genericGF2;
        f13306h = genericGF;
    }

    public GenericGF(int i, int i2, int i3) {
        this.f13312n = i;
        this.f13311m = i2;
        this.f13313o = i3;
        this.f13307i = new int[i2];
        this.f13308j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f13307i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f13308j[this.f13307i[i6]] = i6;
        }
        this.f13309k = new GenericGFPoly(this, new int[]{0});
        this.f13310l = new GenericGFPoly(this, new int[]{1});
    }

    /* renamed from: a */
    public GenericGFPoly m6959a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f13309k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new GenericGFPoly(this, iArr);
    }

    /* renamed from: b */
    public int m6960b(int i) {
        if (i != 0) {
            return this.f13307i[(this.f13311m - this.f13308j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: c */
    public int m6961c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f13307i;
        int[] iArr2 = this.f13308j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f13311m - 1)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f13312n));
        sb.append(',');
        return outline.m813A(sb, this.f13311m, ')');
    }
}
