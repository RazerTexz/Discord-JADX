package p007b.p225i.p414e.p434s.p435b;

import com.google.zxing.FormatException;
import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX INFO: renamed from: b.i.e.s.b.a, reason: use source file name */
/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BitMatrixParser3 {

    /* JADX INFO: renamed from: a */
    public final BitMatrix f13510a;

    /* JADX INFO: renamed from: b */
    public Version3 f13511b;

    /* JADX INFO: renamed from: c */
    public FormatInformation f13512c;

    /* JADX INFO: renamed from: d */
    public boolean f13513d;

    public BitMatrixParser3(BitMatrix bitMatrix) throws FormatException {
        int i = bitMatrix.f13230k;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.m9260a();
        }
        this.f13510a = bitMatrix;
    }

    /* JADX INFO: renamed from: a */
    public final int m7084a(int i, int i2, int i3) {
        return this.f13513d ? this.f13510a.m6942f(i2, i) : this.f13510a.m6942f(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: renamed from: b */
    public void m7085b() {
        int i = 0;
        while (i < this.f13510a.f13229j) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                BitMatrix bitMatrix = this.f13510a;
                if (i3 < bitMatrix.f13230k) {
                    if (bitMatrix.m6942f(i, i3) != this.f13510a.m6942f(i3, i)) {
                        this.f13510a.m6941b(i3, i);
                        this.f13510a.m6941b(i, i3);
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: c */
    public FormatInformation m7086c() throws FormatException {
        FormatInformation formatInformation = this.f13512c;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iM7084a = 0;
        int iM7084a2 = 0;
        for (int i = 0; i < 6; i++) {
            iM7084a2 = m7084a(i, 8, iM7084a2);
        }
        int iM7084a3 = m7084a(8, 7, m7084a(8, 8, m7084a(7, 8, iM7084a2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iM7084a3 = m7084a(8, i2, iM7084a3);
        }
        int i3 = this.f13510a.f13230k;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iM7084a = m7084a(8, i5, iM7084a);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iM7084a = m7084a(i6, 8, iM7084a);
        }
        FormatInformation formatInformationM7099a = FormatInformation.m7099a(iM7084a3, iM7084a);
        if (formatInformationM7099a == null) {
            formatInformationM7099a = FormatInformation.m7099a(iM7084a3 ^ 21522, iM7084a ^ 21522);
        }
        this.f13512c = formatInformationM7099a;
        if (formatInformationM7099a != null) {
            return formatInformationM7099a;
        }
        throw FormatException.m9260a();
    }

    /* JADX INFO: renamed from: d */
    public Version3 m7087d() throws FormatException {
        Version3 version3 = this.f13511b;
        if (version3 != null) {
            return version3;
        }
        int i = this.f13510a.f13230k;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return Version3.m7104d(i2);
        }
        int i3 = i - 11;
        int iM7084a = 0;
        int iM7084a2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iM7084a2 = m7084a(i5, i4, iM7084a2);
            }
        }
        Version3 version3M7103b = Version3.m7103b(iM7084a2);
        if (version3M7103b != null && version3M7103b.m7105c() == i) {
            this.f13511b = version3M7103b;
            return version3M7103b;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iM7084a = m7084a(i6, i7, iM7084a);
            }
        }
        Version3 version3M7103b2 = Version3.m7103b(iM7084a);
        if (version3M7103b2 == null || version3M7103b2.m7105c() != i) {
            throw FormatException.m9260a();
        }
        this.f13511b = version3M7103b2;
        return version3M7103b2;
    }

    /* JADX INFO: renamed from: e */
    public void m7088e() {
        if (this.f13512c == null) {
            return;
        }
        DataMask dataMask = DataMask.values()[this.f13512c.f13535c];
        BitMatrix bitMatrix = this.f13510a;
        dataMask.m7090g(bitMatrix, bitMatrix.f13230k);
    }
}
