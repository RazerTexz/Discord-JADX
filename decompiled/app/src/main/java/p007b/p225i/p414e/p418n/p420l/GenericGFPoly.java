package p007b.p225i.p414e.p418n.p420l;

import java.util.Objects;

/* compiled from: GenericGFPoly.java */
/* renamed from: b.i.e.n.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class GenericGFPoly {

    /* renamed from: a */
    public final GenericGF f13314a;

    /* renamed from: b */
    public final int[] f13315b;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f13314a = genericGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f13315b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f13315b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f13315b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    /* renamed from: a */
    public GenericGFPoly m6962a(GenericGFPoly genericGFPoly) {
        if (!this.f13314a.equals(genericGFPoly.f13314a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (m6966e()) {
            return genericGFPoly;
        }
        if (genericGFPoly.m6966e()) {
            return this;
        }
        int[] iArr = this.f13315b;
        int[] iArr2 = genericGFPoly.f13315b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = iArr2[i - length] ^ iArr[i];
        }
        return new GenericGFPoly(this.f13314a, iArr3);
    }

    /* renamed from: b */
    public int m6963b(int i) {
        if (i == 0) {
            return m6964c(0);
        }
        if (i != 1) {
            int[] iArr = this.f13315b;
            int iM6961c = iArr[0];
            int length = iArr.length;
            for (int i2 = 1; i2 < length; i2++) {
                iM6961c = this.f13314a.m6961c(i, iM6961c) ^ this.f13315b[i2];
            }
            return iM6961c;
        }
        int i3 = 0;
        for (int i4 : this.f13315b) {
            GenericGF genericGF = GenericGF.f13299a;
            i3 ^= i4;
        }
        return i3;
    }

    /* renamed from: c */
    public int m6964c(int i) {
        return this.f13315b[(r0.length - 1) - i];
    }

    /* renamed from: d */
    public int m6965d() {
        return this.f13315b.length - 1;
    }

    /* renamed from: e */
    public boolean m6966e() {
        return this.f13315b[0] == 0;
    }

    /* renamed from: f */
    public GenericGFPoly m6967f(int i) {
        if (i == 0) {
            return this.f13314a.f13309k;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f13315b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f13314a.m6961c(this.f13315b[i2], i);
        }
        return new GenericGFPoly(this.f13314a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m6965d() * 8);
        for (int iM6965d = m6965d(); iM6965d >= 0; iM6965d--) {
            int iM6964c = m6964c(iM6965d);
            if (iM6964c != 0) {
                if (iM6964c < 0) {
                    sb.append(" - ");
                    iM6964c = -iM6964c;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM6965d == 0 || iM6964c != 1) {
                    GenericGF genericGF = this.f13314a;
                    Objects.requireNonNull(genericGF);
                    if (iM6964c == 0) {
                        throw new IllegalArgumentException();
                    }
                    int i = genericGF.f13308j[iM6964c];
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iM6965d != 0) {
                    if (iM6965d == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM6965d);
                    }
                }
            }
        }
        return sb.toString();
    }
}
