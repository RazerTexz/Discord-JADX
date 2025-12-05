package p007b.p225i.p414e.p430r.p431d.p432k;

/* compiled from: ModulusGF.java */
/* renamed from: b.i.e.r.d.k.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ModulusGF {

    /* renamed from: a */
    public static final ModulusGF f13497a = new ModulusGF(929, 3);

    /* renamed from: b */
    public final int[] f13498b;

    /* renamed from: c */
    public final int[] f13499c;

    /* renamed from: d */
    public final ModulusPoly f13500d;

    /* renamed from: e */
    public final ModulusPoly f13501e;

    public ModulusGF(int i, int i2) {
        this.f13498b = new int[i];
        this.f13499c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f13498b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f13499c[this.f13498b[i5]] = i5;
        }
        this.f13500d = new ModulusPoly(this, new int[]{0});
        this.f13501e = new ModulusPoly(this, new int[]{1});
    }

    /* renamed from: a */
    public int m7066a(int i, int i2) {
        return (i + i2) % 929;
    }

    /* renamed from: b */
    public ModulusPoly m7067b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f13500d;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new ModulusPoly(this, iArr);
    }

    /* renamed from: c */
    public int m7068c(int i) {
        if (i != 0) {
            return this.f13498b[(929 - this.f13499c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* renamed from: d */
    public int m7069d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f13498b;
        int[] iArr2 = this.f13499c;
        return iArr[(iArr2[i] + iArr2[i2]) % 928];
    }

    /* renamed from: e */
    public int m7070e(int i, int i2) {
        return ((i + 929) - i2) % 929;
    }
}
