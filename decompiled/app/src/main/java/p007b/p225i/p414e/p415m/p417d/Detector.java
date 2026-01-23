package p007b.p225i.p414e.p415m.p417d;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p415m.AztecDetectorResult;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DefaultGridSampler;
import p007b.p225i.p414e.p418n.PerspectiveTransform;
import p007b.p225i.p414e.p418n.p419k.WhiteRectangleDetector;
import p007b.p225i.p414e.p418n.p420l.GenericGF;
import p007b.p225i.p414e.p418n.p420l.ReedSolomonDecoder;

/* JADX INFO: renamed from: b.i.e.m.d.a, reason: use source file name */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector {

    /* JADX INFO: renamed from: a */
    public static final int[] f13218a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: b */
    public final BitMatrix f13219b;

    /* JADX INFO: renamed from: c */
    public boolean f13220c;

    /* JADX INFO: renamed from: d */
    public int f13221d;

    /* JADX INFO: renamed from: e */
    public int f13222e;

    /* JADX INFO: renamed from: f */
    public int f13223f;

    /* JADX INFO: renamed from: g */
    public int f13224g;

    /* JADX INFO: renamed from: b.i.e.m.d.a$a */
    /* JADX INFO: compiled from: Detector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f13225a;

        /* JADX INFO: renamed from: b */
        public final int f13226b;

        public a(int i, int i2) {
            this.f13225a = i;
            this.f13226b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f13225a);
            sb.append(' ');
            return outline.m813A(sb, this.f13226b, '>');
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.f13219b = bitMatrix;
    }

    /* JADX INFO: renamed from: b */
    public static ResultPoint[] m6927b(ResultPoint[] resultPointArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float f2 = resultPointArr[0].f13207a - resultPointArr[2].f13207a;
        float f3 = resultPointArr[0].f13208b - resultPointArr[2].f13208b;
        float f4 = (resultPointArr[0].f13207a + resultPointArr[2].f13207a) / 2.0f;
        float f5 = (resultPointArr[0].f13208b + resultPointArr[2].f13208b) / 2.0f;
        float f6 = f2 * f;
        float f7 = f3 * f;
        ResultPoint resultPoint = new ResultPoint(f4 + f6, f5 + f7);
        ResultPoint resultPoint2 = new ResultPoint(f4 - f6, f5 - f7);
        float f8 = resultPointArr[1].f13207a - resultPointArr[3].f13207a;
        float f9 = resultPointArr[1].f13208b - resultPointArr[3].f13208b;
        float f10 = (resultPointArr[1].f13207a + resultPointArr[3].f13207a) / 2.0f;
        float f11 = (resultPointArr[1].f13208b + resultPointArr[3].f13208b) / 2.0f;
        float f12 = f8 * f;
        float f13 = f * f9;
        return new ResultPoint[]{resultPoint, new ResultPoint(f10 + f12, f11 + f13), resultPoint2, new ResultPoint(f10 - f12, f11 - f13)};
    }

    /* JADX INFO: renamed from: a */
    public AztecDetectorResult m6928a(boolean z2) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        int i;
        long j;
        int i2;
        a aVar;
        int i3 = 2;
        int i4 = -1;
        int i5 = 1;
        try {
            BitMatrix bitMatrix = this.f13219b;
            ResultPoint[] resultPointArrM6957b = new WhiteRectangleDetector(bitMatrix, 10, bitMatrix.f13229j / 2, bitMatrix.f13230k / 2).m6957b();
            resultPoint4 = resultPointArrM6957b[0];
            resultPoint3 = resultPointArrM6957b[1];
            resultPoint2 = resultPointArrM6957b[2];
            resultPoint = resultPointArrM6957b[3];
        } catch (NotFoundException unused) {
            BitMatrix bitMatrix2 = this.f13219b;
            int i6 = bitMatrix2.f13229j / 2;
            int i7 = bitMatrix2.f13230k / 2;
            int i8 = i7 - 7;
            int i9 = i6 + 7 + 1;
            int i10 = i9;
            int i11 = i8;
            while (true) {
                i11--;
                if (!m6932f(i10, i11) || this.f13219b.m6942f(i10, i11)) {
                    break;
                }
                i10++;
            }
            int i12 = i10 - 1;
            int i13 = i11 + 1;
            while (m6932f(i12, i13) && !this.f13219b.m6942f(i12, i13)) {
                i12++;
            }
            int i14 = i12 - 1;
            while (m6932f(i14, i13) && !this.f13219b.m6942f(i14, i13)) {
                i13--;
            }
            ResultPoint resultPoint9 = new ResultPoint(i14, i13 + 1);
            int i15 = i7 + 7;
            int i16 = i15;
            while (true) {
                i16++;
                if (!m6932f(i9, i16) || this.f13219b.m6942f(i9, i16)) {
                    break;
                }
                i9++;
            }
            int i17 = i9 - 1;
            int i18 = i16 - 1;
            while (m6932f(i17, i18) && !this.f13219b.m6942f(i17, i18)) {
                i17++;
            }
            int i19 = i17 - 1;
            while (m6932f(i19, i18) && !this.f13219b.m6942f(i19, i18)) {
                i18++;
            }
            ResultPoint resultPoint10 = new ResultPoint(i19, i18 - 1);
            int i20 = i6 - 7;
            int i21 = i20 - 1;
            while (true) {
                i15++;
                if (!m6932f(i21, i15) || this.f13219b.m6942f(i21, i15)) {
                    break;
                }
                i21--;
            }
            int i22 = i21 + 1;
            int i23 = i15 - 1;
            while (m6932f(i22, i23) && !this.f13219b.m6942f(i22, i23)) {
                i22--;
            }
            int i24 = i22 + 1;
            while (m6932f(i24, i23) && !this.f13219b.m6942f(i24, i23)) {
                i23++;
            }
            ResultPoint resultPoint11 = new ResultPoint(i24, i23 - 1);
            do {
                i20--;
                i8--;
                if (!m6932f(i20, i8)) {
                    break;
                }
            } while (!this.f13219b.m6942f(i20, i8));
            int i25 = i20 + 1;
            int i26 = i8 + 1;
            while (m6932f(i25, i26) && !this.f13219b.m6942f(i25, i26)) {
                i25--;
            }
            int i27 = i25 + 1;
            while (m6932f(i27, i26) && !this.f13219b.m6942f(i27, i26)) {
                i26--;
            }
            resultPoint = new ResultPoint(i27, i26 + 1);
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint10;
            resultPoint4 = resultPoint9;
        }
        int iM4265Z0 = C3404f.m4265Z0((((resultPoint4.f13207a + resultPoint.f13207a) + resultPoint3.f13207a) + resultPoint2.f13207a) / 4.0f);
        int iM4265Z02 = C3404f.m4265Z0((((resultPoint4.f13208b + resultPoint.f13208b) + resultPoint3.f13208b) + resultPoint2.f13208b) / 4.0f);
        try {
            ResultPoint[] resultPointArrM6957b2 = new WhiteRectangleDetector(this.f13219b, 15, iM4265Z0, iM4265Z02).m6957b();
            resultPoint6 = resultPointArrM6957b2[0];
            resultPoint8 = resultPointArrM6957b2[1];
            resultPoint7 = resultPointArrM6957b2[2];
            resultPoint5 = resultPointArrM6957b2[3];
        } catch (NotFoundException unused2) {
            int i28 = iM4265Z02 - 7;
            int i29 = iM4265Z0 + 7 + 1;
            int i30 = i29;
            int i31 = i28;
            while (true) {
                i31--;
                if (!m6932f(i30, i31) || this.f13219b.m6942f(i30, i31)) {
                    break;
                }
                i30++;
            }
            int i32 = i30 - 1;
            int i33 = i31 + 1;
            while (m6932f(i32, i33) && !this.f13219b.m6942f(i32, i33)) {
                i32++;
            }
            int i34 = i32 - 1;
            while (m6932f(i34, i33) && !this.f13219b.m6942f(i34, i33)) {
                i33--;
            }
            ResultPoint resultPoint12 = new ResultPoint(i34, i33 + 1);
            int i35 = iM4265Z02 + 7;
            int i36 = i35;
            while (true) {
                i36++;
                if (!m6932f(i29, i36) || this.f13219b.m6942f(i29, i36)) {
                    break;
                }
                i29++;
            }
            int i37 = i29 - 1;
            int i38 = i36 - 1;
            while (m6932f(i37, i38) && !this.f13219b.m6942f(i37, i38)) {
                i37++;
            }
            int i39 = i37 - 1;
            while (m6932f(i39, i38) && !this.f13219b.m6942f(i39, i38)) {
                i38++;
            }
            ResultPoint resultPoint13 = new ResultPoint(i39, i38 - 1);
            int i40 = iM4265Z0 - 7;
            int i41 = i40 - 1;
            while (true) {
                i35++;
                if (!m6932f(i41, i35) || this.f13219b.m6942f(i41, i35)) {
                    break;
                }
                i41--;
            }
            int i42 = i41 + 1;
            int i43 = i35 - 1;
            while (m6932f(i42, i43) && !this.f13219b.m6942f(i42, i43)) {
                i42--;
            }
            int i44 = i42 + 1;
            while (m6932f(i44, i43) && !this.f13219b.m6942f(i44, i43)) {
                i43++;
            }
            ResultPoint resultPoint14 = new ResultPoint(i44, i43 - 1);
            do {
                i40--;
                i28--;
                if (!m6932f(i40, i28)) {
                    break;
                }
            } while (!this.f13219b.m6942f(i40, i28));
            int i45 = i40 + 1;
            int i46 = i28 + 1;
            while (m6932f(i45, i46) && !this.f13219b.m6942f(i45, i46)) {
                i45--;
            }
            int i47 = i45 + 1;
            while (m6932f(i47, i46) && !this.f13219b.m6942f(i47, i46)) {
                i46--;
            }
            resultPoint5 = new ResultPoint(i47, i46 + 1);
            resultPoint6 = resultPoint12;
            resultPoint7 = resultPoint14;
            resultPoint8 = resultPoint13;
        }
        a aVar2 = new a(C3404f.m4265Z0((((resultPoint6.f13207a + resultPoint5.f13207a) + resultPoint8.f13207a) + resultPoint7.f13207a) / 4.0f), C3404f.m4265Z0((((resultPoint6.f13208b + resultPoint5.f13208b) + resultPoint8.f13208b) + resultPoint7.f13208b) / 4.0f));
        this.f13223f = 1;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z3 = true;
        while (this.f13223f < 9) {
            a aVarM6931e = m6931e(aVar2, z3, i5, i4);
            a aVarM6931e2 = m6931e(aVar3, z3, i5, i5);
            a aVarM6931e3 = m6931e(aVar4, z3, i4, i5);
            a aVarM6931e4 = m6931e(aVar5, z3, i4, i4);
            if (this.f13223f > i3) {
                double dM4240R = (C3404f.m4240R(aVarM6931e4.f13225a, aVarM6931e4.f13226b, aVarM6931e.f13225a, aVarM6931e.f13226b) * this.f13223f) / (C3404f.m4240R(aVar5.f13225a, aVar5.f13226b, aVar2.f13225a, aVar2.f13226b) * (this.f13223f + i3));
                if (dM4240R < 0.75d || dM4240R > 1.25d) {
                    break;
                }
                a aVar6 = new a(aVarM6931e.f13225a - 3, aVarM6931e.f13226b + 3);
                a aVar7 = new a(aVarM6931e2.f13225a - 3, aVarM6931e2.f13226b - 3);
                a aVar8 = new a(aVarM6931e3.f13225a + 3, aVarM6931e3.f13226b - 3);
                aVar = aVarM6931e;
                a aVar9 = new a(aVarM6931e4.f13225a + 3, aVarM6931e4.f13226b + 3);
                int iM6929c = m6929c(aVar9, aVar6);
                if (!(iM6929c != 0 && m6929c(aVar6, aVar7) == iM6929c && m6929c(aVar7, aVar8) == iM6929c && m6929c(aVar8, aVar9) == iM6929c)) {
                    break;
                }
            } else {
                aVar = aVarM6931e;
            }
            z3 = !z3;
            this.f13223f++;
            aVar5 = aVarM6931e4;
            aVar3 = aVarM6931e2;
            aVar4 = aVarM6931e3;
            aVar2 = aVar;
            i3 = 2;
            i4 = -1;
            i5 = 1;
        }
        int i48 = this.f13223f;
        if (i48 != 5 && i48 != 7) {
            throw NotFoundException.f21665l;
        }
        this.f13220c = i48 == 5;
        int i49 = i48 * 2;
        ResultPoint[] resultPointArrM6927b = m6927b(new ResultPoint[]{new ResultPoint(aVar2.f13225a + 0.5f, aVar2.f13226b - 0.5f), new ResultPoint(aVar3.f13225a + 0.5f, aVar3.f13226b + 0.5f), new ResultPoint(aVar4.f13225a - 0.5f, aVar4.f13226b + 0.5f), new ResultPoint(aVar5.f13225a - 0.5f, aVar5.f13226b - 0.5f)}, i49 - 3, i49);
        if (z2) {
            ResultPoint resultPoint15 = resultPointArrM6927b[0];
            resultPointArrM6927b[0] = resultPointArrM6927b[2];
            resultPointArrM6927b[2] = resultPoint15;
        }
        if (!m6933g(resultPointArrM6927b[0]) || !m6933g(resultPointArrM6927b[1]) || !m6933g(resultPointArrM6927b[2]) || !m6933g(resultPointArrM6927b[3])) {
            throw NotFoundException.f21665l;
        }
        int i50 = this.f13223f * 2;
        int[] iArr = {m6934h(resultPointArrM6927b[0], resultPointArrM6927b[1], i50), m6934h(resultPointArrM6927b[1], resultPointArrM6927b[2], i50), m6934h(resultPointArrM6927b[2], resultPointArrM6927b[3], i50), m6934h(resultPointArrM6927b[3], resultPointArrM6927b[0], i50)};
        int i51 = 0;
        for (int i52 = 0; i52 < 4; i52++) {
            int i53 = iArr[i52];
            i51 = (i51 << 3) + ((i53 >> (i50 - 2)) << 1) + (i53 & 1);
        }
        int i54 = ((i51 & 1) << 11) + (i51 >> 1);
        for (int i55 = 0; i55 < 4; i55++) {
            if (Integer.bitCount(f13218a[i55] ^ i54) <= 2) {
                this.f13224g = i55;
                long j2 = 0;
                for (int i56 = 0; i56 < 4; i56++) {
                    int i57 = iArr[(this.f13224g + i56) % 4];
                    if (this.f13220c) {
                        j = j2 << 7;
                        i2 = (i57 >> 1) & Opcodes.LAND;
                    } else {
                        j = j2 << 10;
                        i2 = ((i57 >> 1) & 31) + ((i57 >> 2) & 992);
                    }
                    j2 = j + ((long) i2);
                }
                int i58 = 7;
                if (this.f13220c) {
                    i = 2;
                } else {
                    i = 4;
                    i58 = 10;
                }
                int i59 = i58 - i;
                int[] iArr2 = new int[i58];
                while (true) {
                    i58--;
                    if (i58 < 0) {
                        try {
                            break;
                        } catch (ReedSolomonException unused3) {
                            throw NotFoundException.f21665l;
                        }
                    }
                    iArr2[i58] = ((int) j2) & 15;
                    j2 >>= 4;
                }
                new ReedSolomonDecoder(GenericGF.f13302d).m6968a(iArr2, i59);
                int i60 = 0;
                for (int i61 = 0; i61 < i; i61++) {
                    i60 = (i60 << 4) + iArr2[i61];
                }
                if (this.f13220c) {
                    this.f13221d = (i60 >> 6) + 1;
                    this.f13222e = (i60 & 63) + 1;
                } else {
                    this.f13221d = (i60 >> 11) + 1;
                    this.f13222e = (i60 & 2047) + 1;
                }
                BitMatrix bitMatrix3 = this.f13219b;
                int i62 = this.f13224g;
                ResultPoint resultPoint16 = resultPointArrM6927b[i62 % 4];
                ResultPoint resultPoint17 = resultPointArrM6927b[(i62 + 1) % 4];
                ResultPoint resultPoint18 = resultPointArrM6927b[(i62 + 2) % 4];
                ResultPoint resultPoint19 = resultPointArrM6927b[(i62 + 3) % 4];
                DefaultGridSampler defaultGridSampler = DefaultGridSampler.f13274a;
                int iM6930d = m6930d();
                float f = iM6930d / 2.0f;
                float f2 = this.f13223f;
                float f3 = f - f2;
                float f4 = f + f2;
                return new AztecDetectorResult(defaultGridSampler.m6951a(bitMatrix3, iM6930d, iM6930d, PerspectiveTransform.m6954a(f3, f3, f4, f3, f4, f4, f3, f4, resultPoint16.f13207a, resultPoint16.f13208b, resultPoint17.f13207a, resultPoint17.f13208b, resultPoint18.f13207a, resultPoint18.f13208b, resultPoint19.f13207a, resultPoint19.f13208b)), m6927b(resultPointArrM6927b, this.f13223f * 2, m6930d()), this.f13220c, this.f13222e, this.f13221d);
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: c */
    public final int m6929c(a aVar, a aVar2) {
        float fM4240R = C3404f.m4240R(aVar.f13225a, aVar.f13226b, aVar2.f13225a, aVar2.f13226b);
        int i = aVar2.f13225a;
        int i2 = aVar.f13225a;
        float f = (i - i2) / fM4240R;
        int i3 = aVar2.f13226b;
        int i4 = aVar.f13226b;
        float f2 = (i3 - i4) / fM4240R;
        float f3 = i2;
        float f4 = i4;
        boolean zM6942f = this.f13219b.m6942f(i2, i4);
        int iCeil = (int) Math.ceil(fM4240R);
        int i5 = 0;
        for (int i6 = 0; i6 < iCeil; i6++) {
            f3 += f;
            f4 += f2;
            if (this.f13219b.m6942f(C3404f.m4265Z0(f3), C3404f.m4265Z0(f4)) != zM6942f) {
                i5++;
            }
        }
        float f5 = i5 / fM4240R;
        if (f5 <= 0.1f || f5 >= 0.9f) {
            return (f5 <= 0.1f) == zM6942f ? 1 : -1;
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m6930d() {
        if (this.f13220c) {
            return (this.f13221d * 4) + 11;
        }
        int i = this.f13221d;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    /* JADX INFO: renamed from: e */
    public final a m6931e(a aVar, boolean z2, int i, int i2) {
        int i3 = aVar.f13225a + i;
        int i4 = aVar.f13226b;
        while (true) {
            i4 += i2;
            if (!m6932f(i3, i4) || this.f13219b.m6942f(i3, i4) != z2) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (m6932f(i5, i6) && this.f13219b.m6942f(i5, i6) == z2) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (m6932f(i7, i6) && this.f13219b.m6942f(i7, i6) == z2) {
            i6 += i2;
        }
        return new a(i7, i6 - i2);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m6932f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        BitMatrix bitMatrix = this.f13219b;
        return i < bitMatrix.f13229j && i2 > 0 && i2 < bitMatrix.f13230k;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m6933g(ResultPoint resultPoint) {
        return m6932f(C3404f.m4265Z0(resultPoint.f13207a), C3404f.m4265Z0(resultPoint.f13208b));
    }

    /* JADX INFO: renamed from: h */
    public final int m6934h(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float fM4237Q = C3404f.m4237Q(resultPoint.f13207a, resultPoint.f13208b, resultPoint2.f13207a, resultPoint2.f13208b);
        float f = fM4237Q / i;
        float f2 = resultPoint.f13207a;
        float f3 = resultPoint.f13208b;
        float f4 = ((resultPoint2.f13207a - f2) * f) / fM4237Q;
        float f5 = ((resultPoint2.f13208b - f3) * f) / fM4237Q;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f6 = i3;
            if (this.f13219b.m6942f(C3404f.m4265Z0((f6 * f4) + f2), C3404f.m4265Z0((f6 * f5) + f3))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
