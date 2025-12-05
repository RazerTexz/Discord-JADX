package p007b.p225i.p414e.p430r.p431d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p430r.PDF417Common;
import p007b.p225i.p414e.p430r.p431d.p432k.ErrorCorrection;

/* compiled from: PDF417ScanningDecoder.java */
/* renamed from: b.i.e.r.d.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class PDF417ScanningDecoder {

    /* renamed from: a */
    public static final ErrorCorrection f13495a = new ErrorCorrection();

    /* renamed from: a */
    public static BoundingBox m7061a(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] iArr;
        int i;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        BarcodeMetadata barcodeMetadataM7059c = detectionResultRowIndicatorColumn.m7059c();
        if (barcodeMetadataM7059c == null) {
            iArr = null;
        } else {
            BoundingBox boundingBox = detectionResultRowIndicatorColumn.f13491a;
            boolean z2 = detectionResultRowIndicatorColumn.f13493c;
            ResultPoint resultPoint5 = z2 ? boundingBox.f13471b : boundingBox.f13473d;
            ResultPoint resultPoint6 = z2 ? boundingBox.f13472c : boundingBox.f13474e;
            int iM7058b = detectionResultRowIndicatorColumn.m7058b((int) resultPoint6.f13208b);
            Codeword[] codewordArr = detectionResultRowIndicatorColumn.f13492b;
            int i2 = -1;
            int i3 = 0;
            int iMax = 1;
            for (int iM7058b2 = detectionResultRowIndicatorColumn.m7058b((int) resultPoint5.f13208b); iM7058b2 < iM7058b; iM7058b2++) {
                if (codewordArr[iM7058b2] != null) {
                    Codeword codeword = codewordArr[iM7058b2];
                    codeword.m7051b();
                    int i4 = codeword.f13483e;
                    int i5 = i4 - i2;
                    if (i5 == 0) {
                        i3++;
                    } else {
                        if (i5 == 1) {
                            iMax = Math.max(iMax, i3);
                            i2 = codeword.f13483e;
                        } else if (i4 >= barcodeMetadataM7059c.f13468e) {
                            codewordArr[iM7058b2] = null;
                        } else {
                            i2 = i4;
                        }
                        i3 = 1;
                    }
                }
            }
            int i6 = barcodeMetadataM7059c.f13468e;
            iArr = new int[i6];
            for (Codeword codeword2 : detectionResultRowIndicatorColumn.f13492b) {
                if (codeword2 != null && (i = codeword2.f13483e) < i6) {
                    iArr[i] = iArr[i] + 1;
                }
            }
        }
        if (iArr == null) {
            return null;
        }
        int iMax2 = -1;
        for (int i7 : iArr) {
            iMax2 = Math.max(iMax2, i7);
        }
        int i8 = 0;
        for (int i9 : iArr) {
            i8 += iMax2 - i9;
            if (i9 > 0) {
                break;
            }
        }
        Codeword[] codewordArr2 = detectionResultRowIndicatorColumn.f13492b;
        for (int i10 = 0; i8 > 0 && codewordArr2[i10] == null; i10++) {
            i8--;
        }
        int i11 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            i11 += iMax2 - iArr[length];
            if (iArr[length] > 0) {
                break;
            }
        }
        for (int length2 = codewordArr2.length - 1; i11 > 0 && codewordArr2[length2] == null; length2--) {
            i11--;
        }
        BoundingBox boundingBox2 = detectionResultRowIndicatorColumn.f13491a;
        boolean z3 = detectionResultRowIndicatorColumn.f13493c;
        ResultPoint resultPoint7 = boundingBox2.f13471b;
        ResultPoint resultPoint8 = boundingBox2.f13472c;
        ResultPoint resultPoint9 = boundingBox2.f13473d;
        ResultPoint resultPoint10 = boundingBox2.f13474e;
        if (i8 <= 0) {
            resultPoint = resultPoint7;
            resultPoint2 = resultPoint9;
        } else {
            ResultPoint resultPoint11 = z3 ? resultPoint7 : resultPoint9;
            ResultPoint resultPoint12 = new ResultPoint(resultPoint11.f13207a, ((int) resultPoint11.f13208b) - i8 >= 0 ? r10 : 0);
            if (z3) {
                resultPoint7 = resultPoint12;
                resultPoint = resultPoint7;
                resultPoint2 = resultPoint9;
            } else {
                resultPoint = resultPoint7;
                resultPoint2 = resultPoint12;
            }
        }
        if (i11 <= 0) {
            resultPoint3 = resultPoint8;
            resultPoint4 = resultPoint10;
        } else {
            ResultPoint resultPoint13 = z3 ? resultPoint8 : resultPoint10;
            int i12 = ((int) resultPoint13.f13208b) + i11;
            int i13 = boundingBox2.f13470a.f13230k;
            if (i12 >= i13) {
                i12 = i13 - 1;
            }
            ResultPoint resultPoint14 = new ResultPoint(resultPoint13.f13207a, i12);
            if (z3) {
                resultPoint8 = resultPoint14;
                resultPoint3 = resultPoint8;
                resultPoint4 = resultPoint10;
            } else {
                resultPoint4 = resultPoint14;
                resultPoint3 = resultPoint8;
            }
        }
        return new BoundingBox(boundingBox2.f13470a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:173:0x03db
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:177:0x03f2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:178:0x03f5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03c4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0294 -> B:113:0x0295). Please report as a decompilation issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static p007b.p225i.p414e.p418n.DecoderResult m7062b(int[] r25, int r26, int[] r27) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p414e.p430r.p431d.PDF417ScanningDecoder.m7062b(int[], int, int[]):b.i.e.n.e");
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Codeword m7063c(BitMatrix bitMatrix, int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i;
        int i9 = z2 ? -1 : 1;
        boolean z3 = z2;
        int i10 = i3;
        int i11 = 0;
        loop0: while (true) {
            if (i11 >= 2) {
                break;
            }
            while (true) {
                if (z3) {
                    if (i10 >= i8) {
                        if (z3 == bitMatrix.m6942f(i10, i4)) {
                            if (Math.abs(i3 - i10) > 2) {
                                i10 = i3;
                                break loop0;
                            }
                            i10 += i9;
                        }
                    }
                } else if (i10 < i2) {
                }
            }
            i9 = -i9;
            z3 = !z3;
            i11++;
        }
        int[] iArr = new int[8];
        int i12 = z2 ? 1 : -1;
        boolean z4 = z2;
        int i13 = i10;
        int i14 = 0;
        while (true) {
            if (!z2) {
                if (i13 < i8) {
                    break;
                }
            } else {
                if (i13 >= i2) {
                    break;
                }
                if (i14 >= 8) {
                    break;
                }
                if (bitMatrix.m6942f(i13, i4) == z4) {
                    iArr[i14] = iArr[i14] + 1;
                    i13 += i12;
                } else {
                    i14++;
                    z4 = !z4;
                }
            }
        }
        if (i14 != 8) {
            if (z2) {
                i8 = i2;
            }
            if (i13 != i8 || i14 != 7) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int iM4297h1 = C3404f.m4297h1(iArr);
        if (z2) {
            i7 = i10 + iM4297h1;
        } else {
            for (int i15 = 0; i15 < iArr.length / 2; i15++) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[(iArr.length - 1) - i15];
                iArr[(iArr.length - 1) - i15] = i16;
            }
            int i17 = i10;
            i10 -= iM4297h1;
            i7 = i17;
        }
        if (!(i5 + (-2) <= iM4297h1 && iM4297h1 <= i6 + 2)) {
            return null;
        }
        float[][] fArr = PDF417CodewordDecoder.f13494a;
        float fM4297h1 = C3404f.m4297h1(iArr);
        int[] iArr2 = new int[8];
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < 17; i20++) {
            if (iArr[i18] + i19 <= ((i20 * fM4297h1) / 17.0f) + (fM4297h1 / 34.0f)) {
                i19 += iArr[i18];
                i18++;
            }
            iArr2[i18] = iArr2[i18] + 1;
        }
        long j = 0;
        for (int i21 = 0; i21 < 8; i21++) {
            for (int i22 = 0; i22 < iArr2[i21]; i22++) {
                j = (j << 1) | (i21 % 2 == 0 ? 1 : 0);
            }
        }
        int i23 = (int) j;
        if (PDF417Common.m7044a(i23) == -1) {
            i23 = -1;
        }
        if (i23 == -1) {
            int iM4297h12 = C3404f.m4297h1(iArr);
            float[] fArr2 = new float[8];
            if (iM4297h12 > 1) {
                for (int i24 = 0; i24 < 8; i24++) {
                    fArr2[i24] = iArr[i24] / iM4297h12;
                }
            }
            float f = Float.MAX_VALUE;
            int i25 = -1;
            int i26 = 0;
            while (true) {
                float[][] fArr3 = PDF417CodewordDecoder.f13494a;
                if (i26 >= fArr3.length) {
                    break;
                }
                float f2 = 0.0f;
                float[] fArr4 = fArr3[i26];
                for (int i27 = 0; i27 < 8; i27++) {
                    float f3 = fArr4[i27] - fArr2[i27];
                    f2 += f3 * f3;
                    if (f2 >= f) {
                        break;
                    }
                }
                if (f2 < f) {
                    i25 = PDF417Common.f13461b[i26];
                    f = f2;
                }
                i26++;
            }
            i23 = i25;
        }
        int iM7044a = PDF417Common.m7044a(i23);
        if (iM7044a == -1) {
            return null;
        }
        int[] iArr3 = new int[8];
        int i28 = i23;
        int i29 = 7;
        int i30 = 0;
        while (true) {
            int i31 = i28 & 1;
            if (i31 != i30) {
                i29--;
                if (i29 < 0) {
                    return new Codeword(i10, i7, ((((iArr3[0] - iArr3[2]) + iArr3[4]) - iArr3[6]) + 9) % 9, iM7044a);
                }
                i30 = i31;
            }
            iArr3[i29] = iArr3[i29] + 1;
            i28 >>= 1;
        }
    }

    /* renamed from: d */
    public static DetectionResultRowIndicatorColumn m7064d(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z2, int i, int i2) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) resultPoint.f13207a;
            for (int i6 = (int) resultPoint.f13208b; i6 <= boundingBox.f13478i && i6 >= boundingBox.f13477h; i6 += i4) {
                Codeword codewordM7063c = m7063c(bitMatrix, 0, bitMatrix.f13229j, z2, i5, i6, i, i2);
                if (codewordM7063c != null) {
                    detectionResultRowIndicatorColumn.f13492b[i6 - detectionResultRowIndicatorColumn.f13491a.f13477h] = codewordM7063c;
                    i5 = z2 ? codewordM7063c.f13479a : codewordM7063c.f13480b;
                }
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    /* renamed from: e */
    public static boolean m7065e(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.f13490d + 1;
    }
}
