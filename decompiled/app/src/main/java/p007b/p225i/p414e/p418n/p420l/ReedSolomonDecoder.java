package p007b.p225i.p414e.p418n.p420l;

import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.n.l.c, reason: use source file name */
/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReedSolomonDecoder {

    /* JADX INFO: renamed from: a */
    public final GenericGF f13316a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.f13316a = genericGF;
    }

    /* JADX INFO: renamed from: a */
    public void m6968a(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        GenericGFPoly genericGFPoly;
        GenericGFPoly genericGFPoly2;
        int i2 = i;
        GenericGFPoly genericGFPoly3 = new GenericGFPoly(this.f13316a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = true;
        for (int i3 = 0; i3 < i2; i3++) {
            GenericGF genericGF = this.f13316a;
            int iM6963b = genericGFPoly3.m6963b(genericGF.f13307i[genericGF.f13313o + i3]);
            iArr3[(i2 - 1) - i3] = iM6963b;
            if (iM6963b != 0) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        GenericGFPoly genericGFPoly4 = new GenericGFPoly(this.f13316a, iArr3);
        GenericGFPoly genericGFPolyM6959a = this.f13316a.m6959a(i2, 1);
        if (genericGFPolyM6959a.m6965d() >= genericGFPoly4.m6965d()) {
            genericGFPolyM6959a = genericGFPoly4;
            genericGFPoly4 = genericGFPolyM6959a;
        }
        GenericGF genericGF2 = this.f13316a;
        GenericGFPoly genericGFPoly5 = genericGF2.f13309k;
        GenericGFPoly genericGFPoly6 = genericGFPolyM6959a;
        GenericGFPoly genericGFPolyM6962a = genericGFPoly4;
        GenericGFPoly genericGFPoly7 = genericGFPoly6;
        GenericGFPoly genericGFPoly8 = genericGF2.f13310l;
        GenericGFPoly genericGFPoly9 = genericGFPoly5;
        while (genericGFPoly7.m6965d() >= i2 / 2) {
            if (genericGFPoly7.m6966e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly genericGFPolyM6962a2 = this.f13316a.f13309k;
            int iM6960b = this.f13316a.m6960b(genericGFPoly7.m6964c(genericGFPoly7.m6965d()));
            while (genericGFPolyM6962a.m6965d() >= genericGFPoly7.m6965d() && !genericGFPolyM6962a.m6966e()) {
                int iM6965d = genericGFPolyM6962a.m6965d() - genericGFPoly7.m6965d();
                int iM6961c = this.f13316a.m6961c(genericGFPolyM6962a.m6964c(genericGFPolyM6962a.m6965d()), iM6960b);
                genericGFPolyM6962a2 = genericGFPolyM6962a2.m6962a(this.f13316a.m6959a(iM6965d, iM6961c));
                if (iM6965d < 0) {
                    throw new IllegalArgumentException();
                }
                if (iM6961c == 0) {
                    genericGFPoly2 = genericGFPoly7.f13314a.f13309k;
                } else {
                    int length = genericGFPoly7.f13315b.length;
                    int[] iArr4 = new int[iM6965d + length];
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr4[i4] = genericGFPoly7.f13314a.m6961c(genericGFPoly7.f13315b[i4], iM6961c);
                    }
                    genericGFPoly2 = new GenericGFPoly(genericGFPoly7.f13314a, iArr4);
                }
                genericGFPolyM6962a = genericGFPolyM6962a.m6962a(genericGFPoly2);
            }
            if (!genericGFPolyM6962a2.f13314a.equals(genericGFPoly8.f13314a)) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (genericGFPolyM6962a2.m6966e() || genericGFPoly8.m6966e()) {
                genericGFPoly = genericGFPolyM6962a2.f13314a.f13309k;
            } else {
                int[] iArr5 = genericGFPolyM6962a2.f13315b;
                int length2 = iArr5.length;
                int[] iArr6 = genericGFPoly8.f13315b;
                int length3 = iArr6.length;
                int[] iArr7 = new int[(length2 + length3) - 1];
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = iArr5[i5];
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = i5 + i7;
                        iArr7[i8] = iArr7[i8] ^ genericGFPolyM6962a2.f13314a.m6961c(i6, iArr6[i7]);
                        i7++;
                        iArr5 = iArr5;
                    }
                }
                genericGFPoly = new GenericGFPoly(genericGFPolyM6962a2.f13314a, iArr7);
            }
            GenericGFPoly genericGFPolyM6962a3 = genericGFPoly.m6962a(genericGFPoly9);
            if (genericGFPolyM6962a.m6965d() >= genericGFPoly7.m6965d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            genericGFPoly9 = genericGFPoly8;
            genericGFPoly8 = genericGFPolyM6962a3;
            i2 = i;
            GenericGFPoly genericGFPoly10 = genericGFPolyM6962a;
            genericGFPolyM6962a = genericGFPoly7;
            genericGFPoly7 = genericGFPoly10;
        }
        int iM6964c = genericGFPoly8.m6964c(0);
        if (iM6964c == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int iM6960b2 = this.f13316a.m6960b(iM6964c);
        GenericGFPoly[] genericGFPolyArr = {genericGFPoly8.m6967f(iM6960b2), genericGFPoly7.m6967f(iM6960b2)};
        GenericGFPoly genericGFPoly11 = genericGFPolyArr[0];
        GenericGFPoly genericGFPoly12 = genericGFPolyArr[1];
        int iM6965d2 = genericGFPoly11.m6965d();
        if (iM6965d2 == 1) {
            iArr2 = new int[]{genericGFPoly11.m6964c(1)};
        } else {
            int[] iArr8 = new int[iM6965d2];
            int i9 = 0;
            for (int i10 = 1; i10 < this.f13316a.f13311m && i9 < iM6965d2; i10++) {
                if (genericGFPoly11.m6963b(i10) == 0) {
                    iArr8[i9] = this.f13316a.m6960b(i10);
                    i9++;
                }
            }
            if (i9 != iM6965d2) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
            iArr2 = iArr8;
        }
        int length4 = iArr2.length;
        int[] iArr9 = new int[length4];
        for (int i11 = 0; i11 < length4; i11++) {
            int iM6960b3 = this.f13316a.m6960b(iArr2[i11]);
            int iM6961c2 = 1;
            for (int i12 = 0; i12 < length4; i12++) {
                if (i11 != i12) {
                    int iM6961c3 = this.f13316a.m6961c(iArr2[i12], iM6960b3);
                    iM6961c2 = this.f13316a.m6961c(iM6961c2, (iM6961c3 & 1) == 0 ? iM6961c3 | 1 : iM6961c3 & (-2));
                }
            }
            iArr9[i11] = this.f13316a.m6961c(genericGFPoly12.m6963b(iM6960b3), this.f13316a.m6960b(iM6961c2));
            GenericGF genericGF3 = this.f13316a;
            if (genericGF3.f13313o != 0) {
                iArr9[i11] = genericGF3.m6961c(iArr9[i11], iM6960b3);
            }
        }
        for (int i13 = 0; i13 < iArr2.length; i13++) {
            int length5 = iArr.length - 1;
            GenericGF genericGF4 = this.f13316a;
            int i14 = iArr2[i13];
            Objects.requireNonNull(genericGF4);
            if (i14 == 0) {
                throw new IllegalArgumentException();
            }
            int i15 = length5 - genericGF4.f13308j[i14];
            if (i15 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i15] = iArr[i15] ^ iArr9[i13];
        }
    }
}
