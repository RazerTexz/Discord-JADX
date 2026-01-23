package p007b.p225i.p414e.p430r;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.Reader;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p430r.p431d.BarcodeMetadata;
import p007b.p225i.p414e.p430r.p431d.BarcodeValue;
import p007b.p225i.p414e.p430r.p431d.BoundingBox;
import p007b.p225i.p414e.p430r.p431d.Codeword;
import p007b.p225i.p414e.p430r.p431d.DetectionResult;
import p007b.p225i.p414e.p430r.p431d.DetectionResultColumn;
import p007b.p225i.p414e.p430r.p431d.DetectionResultRowIndicatorColumn;
import p007b.p225i.p414e.p430r.p431d.PDF417ScanningDecoder;
import p007b.p225i.p414e.p430r.p431d.p432k.ErrorCorrection;
import p007b.p225i.p414e.p430r.p433e.Detector3;

/* JADX INFO: renamed from: b.i.e.r.b, reason: use source file name */
/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PDF417Reader implements Reader {
    /* JADX INFO: renamed from: b */
    public static int m7046b(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.f13207a - resultPoint2.f13207a);
    }

    /* JADX INFO: renamed from: c */
    public static int m7047c(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.f13207a - resultPoint2.f13207a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:325:0x064c, code lost:
    
        r3 = new com.google.zxing.Result(r2.f13268c, r2.f13266a, r4, p007b.p225i.p414e.BarcodeFormat.PDF_417);
        r3.m9262b(p007b.p225i.p414e.ResultMetadataType.ERROR_CORRECTION_LEVEL, r2.f13270e);
        r2 = (p007b.p225i.p414e.p430r.PDF417ResultMetadata) r2.f13271f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0662, code lost:
    
        if (r2 == null) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0664, code lost:
    
        r3.m9262b(p007b.p225i.p414e.ResultMetadataType.PDF417_EXTRA_METADATA, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0669, code lost:
    
        r0.add(r3);
        r3 = r25;
        r2 = 0;
        r5 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a2  */
    @Override // p007b.p225i.p414e.Reader
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        BoundingBox boundingBox;
        DetectionResult detectionResult;
        int i;
        boolean z2;
        int i2;
        Iterator<ResultPoint[]> it;
        BoundingBox boundingBox2;
        int i3;
        Iterator<ResultPoint[]> it2;
        int i4;
        Codeword codeword;
        int i5;
        int i6;
        int i7;
        DetectionResultColumn detectionResultColumn;
        int i8;
        int i9;
        int i10;
        BoundingBox boundingBox3;
        int i11;
        int i12;
        BoundingBox boundingBox4;
        BarcodeMetadata barcodeMetadataM7059c;
        BarcodeMetadata barcodeMetadataM7059c2;
        ArrayList arrayList = new ArrayList();
        BitMatrix bitMatrixM6913a = binaryBitmap.m6913a();
        char c = 0;
        List<ResultPoint[]> listM7080a = Detector3.m7080a(false, bitMatrixM6913a);
        int i13 = 2;
        if (((ArrayList) listM7080a).isEmpty()) {
            int i14 = bitMatrixM6913a.f13229j;
            int i15 = bitMatrixM6913a.f13230k;
            BitMatrix bitMatrix = new BitMatrix(i14, i15, bitMatrixM6913a.f13231l, (int[]) bitMatrixM6913a.f13232m.clone());
            BitArray bitArray = new BitArray(i14);
            BitArray bitArray2 = new BitArray(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                bitArray = bitMatrix.m6944h(i16, bitArray);
                int i17 = (i15 - 1) - i16;
                bitArray2 = bitMatrix.m6944h(i17, bitArray2);
                bitArray.m6939i();
                bitArray2.m6939i();
                int[] iArr = bitArray2.f13227j;
                int[] iArr2 = bitMatrix.f13232m;
                int i18 = bitMatrix.f13231l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = bitArray.f13227j;
                int[] iArr4 = bitMatrix.f13232m;
                int i19 = bitMatrix.f13231l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listM7080a = Detector3.m7080a(false, bitMatrix);
            bitMatrixM6913a = bitMatrix;
        }
        Iterator<ResultPoint[]> it3 = listM7080a.iterator();
        while (it3.hasNext()) {
            ResultPoint[] next = it3.next();
            ResultPoint resultPoint = next[4];
            ResultPoint resultPoint2 = next[5];
            ResultPoint resultPoint3 = next[6];
            ResultPoint resultPoint4 = next[7];
            int iMin = Math.min(Math.min(m7047c(next[c], next[4]), (m7047c(next[6], next[i13]) * 17) / 18), Math.min(m7047c(next[1], next[5]), (m7047c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(m7046b(next[c], next[4]), (m7046b(next[6], next[i13]) * 17) / 18), Math.max(m7046b(next[1], next[5]), (m7046b(next[7], next[3]) * 17) / 18));
            ErrorCorrection errorCorrection = PDF417ScanningDecoder.f13495a;
            BoundingBox boundingBox5 = new BoundingBox(bitMatrixM6913a, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            DetectionResult detectionResult2 = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnM7064d = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnM7064d2 = null;
            int i20 = 0;
            while (i20 < i13) {
                if (resultPoint != null) {
                    i12 = i20;
                    boundingBox4 = boundingBox5;
                    detectionResultRowIndicatorColumnM7064d = PDF417ScanningDecoder.m7064d(bitMatrixM6913a, boundingBox5, resultPoint, true, iMin, iMax);
                } else {
                    i12 = i20;
                    boundingBox4 = boundingBox5;
                }
                DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumnM7064d;
                if (resultPoint3 != null) {
                    detectionResultRowIndicatorColumnM7064d2 = PDF417ScanningDecoder.m7064d(bitMatrixM6913a, boundingBox4, resultPoint3, false, iMin, iMax);
                }
                if (detectionResultRowIndicatorColumn != null || detectionResultRowIndicatorColumnM7064d2 != null) {
                    if (detectionResultRowIndicatorColumn == null || (barcodeMetadataM7059c = detectionResultRowIndicatorColumn.m7059c()) == null) {
                        barcodeMetadataM7059c = detectionResultRowIndicatorColumnM7064d2 == null ? null : detectionResultRowIndicatorColumnM7064d2.m7059c();
                        if (barcodeMetadataM7059c != null) {
                            detectionResult2 = null;
                        } else {
                            BoundingBox boundingBoxM7061a = PDF417ScanningDecoder.m7061a(detectionResultRowIndicatorColumn);
                            BoundingBox boundingBoxM7061a2 = PDF417ScanningDecoder.m7061a(detectionResultRowIndicatorColumnM7064d2);
                            if (boundingBoxM7061a == null) {
                                boundingBoxM7061a = boundingBoxM7061a2;
                            } else if (boundingBoxM7061a2 != null) {
                                boundingBoxM7061a = new BoundingBox(boundingBoxM7061a.f13470a, boundingBoxM7061a.f13471b, boundingBoxM7061a.f13472c, boundingBoxM7061a2.f13473d, boundingBoxM7061a2.f13474e);
                            }
                            detectionResult2 = new DetectionResult(barcodeMetadataM7059c, boundingBoxM7061a);
                        }
                        if (detectionResult2 != null) {
                            throw NotFoundException.f21665l;
                        }
                        if (i12 != 0 || (boundingBox5 = detectionResult2.f13489c) == null) {
                            boundingBox = boundingBox4;
                            detectionResult2.f13489c = boundingBox;
                            detectionResult = detectionResult2;
                            detectionResultRowIndicatorColumnM7064d = detectionResultRowIndicatorColumn;
                            break;
                        }
                        boundingBox = boundingBox4;
                        if (boundingBox5.f13477h >= boundingBox.f13477h && boundingBox5.f13478i <= boundingBox.f13478i) {
                            detectionResult2.f13489c = boundingBox;
                            detectionResult = detectionResult2;
                            detectionResultRowIndicatorColumnM7064d = detectionResultRowIndicatorColumn;
                            break;
                        }
                        i20 = i12 + 1;
                        detectionResultRowIndicatorColumnM7064d = detectionResultRowIndicatorColumn;
                        i13 = 2;
                    } else {
                        if (detectionResultRowIndicatorColumnM7064d2 != null && (barcodeMetadataM7059c2 = detectionResultRowIndicatorColumnM7064d2.m7059c()) != null && barcodeMetadataM7059c.f13464a != barcodeMetadataM7059c2.f13464a && barcodeMetadataM7059c.f13465b != barcodeMetadataM7059c2.f13465b && barcodeMetadataM7059c.f13468e != barcodeMetadataM7059c2.f13468e) {
                        }
                        if (barcodeMetadataM7059c != null) {
                        }
                        if (detectionResult2 != null) {
                        }
                    }
                }
            }
            boundingBox = boundingBox5;
            detectionResult = detectionResult2;
            int i21 = detectionResult.f13490d + 1;
            DetectionResultColumn[] detectionResultColumnArr = detectionResult.f13488b;
            detectionResultColumnArr[c] = detectionResultRowIndicatorColumnM7064d;
            detectionResultColumnArr[i21] = detectionResultRowIndicatorColumnM7064d2;
            boolean z3 = detectionResultRowIndicatorColumnM7064d != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (detectionResult.f13488b[i24] == null) {
                    DetectionResultColumn detectionResultRowIndicatorColumn2 = (i24 == 0 || i24 == i21) ? new DetectionResultRowIndicatorColumn(boundingBox, i24 == 0) : new DetectionResultColumn(boundingBox);
                    detectionResult.f13488b[i24] = detectionResultRowIndicatorColumn2;
                    int i25 = boundingBox.f13477h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= boundingBox.f13478i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (PDF417ScanningDecoder.m7065e(detectionResult, i29)) {
                            it2 = it3;
                            DetectionResultColumn detectionResultColumn2 = detectionResult.f13488b[i29];
                            i4 = iMax2;
                            codeword = detectionResultColumn2.f13492b[i25 - detectionResultColumn2.f13491a.f13477h];
                        } else {
                            it2 = it3;
                            i4 = iMax2;
                            codeword = null;
                        }
                        if (codeword != null) {
                            i6 = z3 ? codeword.f13480b : codeword.f13479a;
                        } else {
                            Codeword codewordM7057a = detectionResult.f13488b[i24].m7057a(i25);
                            if (codewordM7057a != null) {
                                i6 = z3 ? codewordM7057a.f13479a : codewordM7057a.f13480b;
                            } else {
                                if (PDF417ScanningDecoder.m7065e(detectionResult, i29)) {
                                    codewordM7057a = detectionResult.f13488b[i29].m7057a(i25);
                                }
                                if (codewordM7057a != null) {
                                    i6 = z3 ? codewordM7057a.f13480b : codewordM7057a.f13479a;
                                } else {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (PDF417ScanningDecoder.m7065e(detectionResult, i32)) {
                                            Codeword[] codewordArr = detectionResult.f13488b[i32].f13492b;
                                            int length = codewordArr.length;
                                            i5 = i25;
                                            int i33 = 0;
                                            while (i33 < length) {
                                                int i34 = length;
                                                Codeword codeword2 = codewordArr[i33];
                                                if (codeword2 != null) {
                                                    i6 = ((codeword2.f13480b - codeword2.f13479a) * i28 * i31) + (z3 ? codeword2.f13480b : codeword2.f13479a);
                                                } else {
                                                    i33++;
                                                    length = i34;
                                                }
                                            }
                                            i31++;
                                            i30 = i32;
                                            i25 = i5;
                                        } else {
                                            i5 = i25;
                                            i6 = z3 ? detectionResult.f13489c.f13475f : detectionResult.f13489c.f13476g;
                                        }
                                    }
                                    if (i6 < 0 && i6 <= boundingBox.f13476g) {
                                        i11 = i6;
                                    } else if (i27 == -1) {
                                        i11 = i27;
                                    } else {
                                        i7 = i26;
                                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                                        i8 = i24;
                                        i9 = i21;
                                        iMax2 = i4;
                                        i10 = i5;
                                        boundingBox3 = boundingBox;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                    int i35 = i4;
                                    i10 = i5;
                                    int i36 = i26;
                                    boundingBox3 = boundingBox;
                                    i8 = i24;
                                    detectionResultColumn = detectionResultRowIndicatorColumn2;
                                    i9 = i21;
                                    Codeword codewordM7063c = PDF417ScanningDecoder.m7063c(bitMatrixM6913a, boundingBox.f13475f, boundingBox.f13476g, z3, i11, i10, i36, i35);
                                    if (codewordM7063c != null) {
                                        detectionResultColumn.f13492b[i10 - detectionResultColumn.f13491a.f13477h] = codewordM7063c;
                                        int iMin2 = Math.min(i36, codewordM7063c.f13480b - codewordM7063c.f13479a);
                                        iMax2 = Math.max(i35, codewordM7063c.f13480b - codewordM7063c.f13479a);
                                        i26 = iMin2;
                                        i27 = i11;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    } else {
                                        iMax2 = i35;
                                        i7 = i36;
                                        i26 = i7;
                                        i25 = i10 + 1;
                                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                        it3 = it2;
                                        boundingBox = boundingBox3;
                                        i24 = i8;
                                        i21 = i9;
                                    }
                                }
                            }
                        }
                        i5 = i25;
                        if (i6 < 0) {
                            if (i27 == -1) {
                            }
                        }
                        i25 = i10 + 1;
                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                        it3 = it2;
                        boundingBox = boundingBox3;
                        i24 = i8;
                        i21 = i9;
                    }
                    it = it3;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it3;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                }
                i23++;
                it3 = it;
                boundingBox = boundingBox2;
                i21 = i3;
            }
            Iterator<ResultPoint[]> it4 = it3;
            BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.f13487a.f13468e, detectionResult.f13490d + 2);
            for (int i37 = 0; i37 < barcodeValueArr.length; i37++) {
                for (int i38 = 0; i38 < barcodeValueArr[i37].length; i38++) {
                    barcodeValueArr[i37][i38] = new BarcodeValue();
                }
            }
            char c2 = 0;
            detectionResult.m7056a(detectionResult.f13488b[0]);
            int i39 = 1;
            detectionResult.m7056a(detectionResult.f13488b[detectionResult.f13490d + 1]);
            int i40 = 928;
            while (true) {
                DetectionResultColumn[] detectionResultColumnArr2 = detectionResult.f13488b;
                if (detectionResultColumnArr2[c2] != null) {
                    int i41 = detectionResult.f13490d + i39;
                    if (detectionResultColumnArr2[i41] != null) {
                        Codeword[] codewordArr2 = detectionResultColumnArr2[c2].f13492b;
                        Codeword[] codewordArr3 = detectionResultColumnArr2[i41].f13492b;
                        for (int i42 = 0; i42 < codewordArr2.length; i42++) {
                            if (codewordArr2[i42] != null && codewordArr3[i42] != null && codewordArr2[i42].f13483e == codewordArr3[i42].f13483e) {
                                for (int i43 = 1; i43 <= detectionResult.f13490d; i43++) {
                                    Codeword codeword3 = detectionResult.f13488b[i43].f13492b[i42];
                                    if (codeword3 != null) {
                                        codeword3.f13483e = codewordArr2[i42].f13483e;
                                        if (!codeword3.m7050a()) {
                                            detectionResult.f13488b[i43].f13492b[i42] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                DetectionResultColumn[] detectionResultColumnArr3 = detectionResult.f13488b;
                int i44 = 0;
                if (detectionResultColumnArr3[0] != null) {
                    Codeword[] codewordArr4 = detectionResultColumnArr3[0].f13492b;
                    int i45 = 0;
                    for (int i46 = 0; i46 < codewordArr4.length; i46++) {
                        if (codewordArr4[i46] != null) {
                            int i47 = codewordArr4[i46].f13483e;
                            int i48 = i45;
                            int iM7055b = 0;
                            for (int i49 = 1; i49 < detectionResult.f13490d + 1 && iM7055b < 2; i49++) {
                                Codeword codeword4 = detectionResult.f13488b[i49].f13492b[i46];
                                if (codeword4 != null) {
                                    iM7055b = DetectionResult.m7055b(i47, iM7055b, codeword4);
                                    if (!codeword4.m7050a()) {
                                        i48++;
                                    }
                                }
                            }
                            i45 = i48;
                        }
                    }
                    i44 = i45;
                }
                DetectionResultColumn[] detectionResultColumnArr4 = detectionResult.f13488b;
                int i50 = detectionResult.f13490d + 1;
                if (detectionResultColumnArr4[i50] == null) {
                    i = 0;
                } else {
                    Codeword[] codewordArr5 = detectionResultColumnArr4[i50].f13492b;
                    i = 0;
                    for (int i51 = 0; i51 < codewordArr5.length; i51++) {
                        if (codewordArr5[i51] != null) {
                            int i52 = codewordArr5[i51].f13483e;
                            int i53 = i;
                            int iM7055b2 = 0;
                            for (int i54 = detectionResult.f13490d + 1; i54 > 0 && iM7055b2 < 2; i54--) {
                                Codeword codeword5 = detectionResult.f13488b[i54].f13492b[i51];
                                if (codeword5 != null) {
                                    iM7055b2 = DetectionResult.m7055b(i52, iM7055b2, codeword5);
                                    if (!codeword5.m7050a()) {
                                        i53++;
                                    }
                                }
                            }
                            i = i53;
                        }
                    }
                }
                int i55 = i44 + i;
                if (i55 == 0) {
                    i55 = 0;
                } else {
                    for (int i56 = 1; i56 < detectionResult.f13490d + 1; i56++) {
                        Codeword[] codewordArr6 = detectionResult.f13488b[i56].f13492b;
                        for (int i57 = 0; i57 < codewordArr6.length; i57++) {
                            if (codewordArr6[i57] != null && !codewordArr6[i57].m7050a()) {
                                Codeword codeword6 = codewordArr6[i57];
                                DetectionResultColumn[] detectionResultColumnArr5 = detectionResult.f13488b;
                                Codeword[] codewordArr7 = detectionResultColumnArr5[i56 - 1].f13492b;
                                int i58 = i56 + 1;
                                Codeword[] codewordArr8 = detectionResultColumnArr5[i58] != null ? detectionResultColumnArr5[i58].f13492b : codewordArr7;
                                Codeword[] codewordArr9 = new Codeword[14];
                                codewordArr9[2] = codewordArr7[i57];
                                codewordArr9[3] = codewordArr8[i57];
                                if (i57 > 0) {
                                    int i59 = i57 - 1;
                                    codewordArr9[0] = codewordArr6[i59];
                                    codewordArr9[4] = codewordArr7[i59];
                                    codewordArr9[5] = codewordArr8[i59];
                                }
                                if (i57 > 1) {
                                    int i60 = i57 - 2;
                                    codewordArr9[8] = codewordArr6[i60];
                                    codewordArr9[10] = codewordArr7[i60];
                                    codewordArr9[11] = codewordArr8[i60];
                                }
                                if (i57 < codewordArr6.length - 1) {
                                    int i61 = i57 + 1;
                                    codewordArr9[1] = codewordArr6[i61];
                                    codewordArr9[6] = codewordArr7[i61];
                                    codewordArr9[7] = codewordArr8[i61];
                                }
                                if (i57 < codewordArr6.length - 2) {
                                    int i62 = i57 + 2;
                                    codewordArr9[9] = codewordArr6[i62];
                                    codewordArr9[12] = codewordArr7[i62];
                                    codewordArr9[13] = codewordArr8[i62];
                                }
                                int i63 = 0;
                                for (int i64 = 14; i63 < i64; i64 = 14) {
                                    Codeword codeword7 = codewordArr9[i63];
                                    if (codeword7 != null && codeword7.m7050a() && codeword7.f13481c == codeword6.f13481c) {
                                        codeword6.f13483e = codeword7.f13483e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i63++;
                                }
                            }
                        }
                    }
                }
                if (i55 <= 0 || i55 >= i40) {
                    break;
                }
                i40 = i55;
                c2 = 0;
                i39 = 1;
            }
            int i65 = 0;
            for (DetectionResultColumn detectionResultColumn3 : detectionResult.f13488b) {
                if (detectionResultColumn3 != null) {
                    for (Codeword codeword8 : detectionResultColumn3.f13492b) {
                        if (codeword8 != null && (i2 = codeword8.f13483e) >= 0 && i2 < barcodeValueArr.length) {
                            barcodeValueArr[i2][i65].m7049b(codeword8.f13482d);
                        }
                    }
                }
                i65++;
            }
            BarcodeValue barcodeValue = barcodeValueArr[0][1];
            int[] iArrM7048a = barcodeValue.m7048a();
            int i66 = detectionResult.f13490d;
            BarcodeMetadata barcodeMetadata = detectionResult.f13487a;
            int i67 = (i66 * barcodeMetadata.f13468e) - (2 << barcodeMetadata.f13465b);
            if (iArrM7048a.length == 0) {
                if (i67 <= 0 || i67 > 928) {
                    throw NotFoundException.f21665l;
                }
                barcodeValue.m7049b(i67);
            } else if (iArrM7048a[0] != i67) {
                barcodeValue.m7049b(i67);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[detectionResult.f13487a.f13468e * detectionResult.f13490d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i68 = 0; i68 < detectionResult.f13487a.f13468e; i68++) {
                int i69 = 0;
                while (i69 < detectionResult.f13490d) {
                    int i70 = i69 + 1;
                    int[] iArrM7048a2 = barcodeValueArr[i68][i70].m7048a();
                    int i71 = (detectionResult.f13490d * i68) + i69;
                    if (iArrM7048a2.length == 0) {
                        arrayList2.add(Integer.valueOf(i71));
                    } else if (iArrM7048a2.length == 1) {
                        iArr5[i71] = iArrM7048a2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i71));
                        arrayList3.add(iArrM7048a2);
                    }
                    i69 = i70;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i72 = 0; i72 < size; i72++) {
                iArr6[i72] = (int[]) arrayList3.get(i72);
            }
            int i73 = detectionResult.f13487a.f13465b;
            int[] iArrM7045b = PDF417Common.m7045b(arrayList2);
            int[] iArrM7045b2 = PDF417Common.m7045b(arrayList4);
            int length2 = iArrM7045b2.length;
            int[] iArr7 = new int[length2];
            int i74 = 100;
            while (true) {
                int i75 = i74 - 1;
                if (i74 <= 0) {
                    throw ChecksumException.m9259a();
                }
                for (int i76 = 0; i76 < length2; i76++) {
                    iArr5[iArrM7045b2[i76]] = iArr6[i76][iArr7[i76]];
                }
                try {
                    DecoderResult decoderResultM7062b = PDF417ScanningDecoder.m7062b(iArr5, i73, iArrM7045b);
                    break;
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.m9259a();
                    }
                    int i77 = 0;
                    while (true) {
                        if (i77 >= length2) {
                            break;
                        }
                        if (iArr7[i77] < iArr6[i77].length - 1) {
                            iArr7[i77] = iArr7[i77] + 1;
                            break;
                        }
                        iArr7[i77] = 0;
                        if (i77 == length2 - 1) {
                            throw ChecksumException.m9259a();
                        }
                        i77++;
                    }
                    i74 = i75;
                }
            }
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.f21665l;
        }
        return resultArr[0];
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
    }
}
