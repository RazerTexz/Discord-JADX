package p007b.p225i.p414e.p421o.p422b;

import com.google.zxing.FormatException;
import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX INFO: renamed from: b.i.e.o.b.a, reason: use source file name */
/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BitMatrixParser {

    /* JADX INFO: renamed from: a */
    public final BitMatrix f13319a;

    /* JADX INFO: renamed from: b */
    public final BitMatrix f13320b;

    /* JADX INFO: renamed from: c */
    public final Version2 f13321c;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int i;
        int i2 = bitMatrix.f13230k;
        if (i2 < 8 || i2 > 144 || (i2 & 1) != 0) {
            throw FormatException.m9260a();
        }
        int i3 = bitMatrix.f13229j;
        Version2[] version2Arr = Version2.f13330a;
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw FormatException.m9260a();
        }
        for (Version2 version2 : Version2.f13330a) {
            int i4 = version2.f13332c;
            if (i4 == i2 && (i = version2.f13333d) == i3) {
                this.f13321c = version2;
                if (bitMatrix.f13230k != i4) {
                    throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
                }
                int i5 = version2.f13334e;
                int i6 = version2.f13335f;
                int i7 = i4 / i5;
                int i8 = i / i6;
                BitMatrix bitMatrix2 = new BitMatrix(i8 * i6, i7 * i5);
                for (int i9 = 0; i9 < i7; i9++) {
                    int i10 = i9 * i5;
                    for (int i11 = 0; i11 < i8; i11++) {
                        int i12 = i11 * i6;
                        for (int i13 = 0; i13 < i5; i13++) {
                            int i14 = ((i5 + 2) * i9) + 1 + i13;
                            int i15 = i10 + i13;
                            for (int i16 = 0; i16 < i6; i16++) {
                                if (bitMatrix.m6942f(((i6 + 2) * i11) + 1 + i16, i14)) {
                                    bitMatrix2.m6946j(i12 + i16, i15);
                                }
                            }
                        }
                    }
                }
                this.f13319a = bitMatrix2;
                this.f13320b = new BitMatrix(bitMatrix2.f13229j, bitMatrix2.f13230k);
                return;
            }
        }
        throw FormatException.m9260a();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6969a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f13320b.m6946j(i2, i);
        return this.f13319a.m6942f(i2, i);
    }

    /* JADX INFO: renamed from: b */
    public final int m6970b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (m6969a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (m6969a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (m6969a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (m6969a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m6969a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (m6969a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (m6969a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return m6969a(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
