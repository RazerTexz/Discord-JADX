package p007b.p225i.p414e.p421o;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.Reader;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p421o.p422b.Decoder3;
import p007b.p225i.p414e.p421o.p423c.Detector2;

/* compiled from: DataMatrixReader.java */
/* renamed from: b.i.e.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class DataMatrixReader implements Reader {

    /* renamed from: a */
    public static final ResultPoint[] f13317a = new ResultPoint[0];

    /* renamed from: b */
    public final Decoder3 f13318b = new Decoder3();

    @Override // p007b.p225i.p414e.Reader
    /* renamed from: a */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        BitMatrix bitMatrixM6976d;
        ResultPoint[] resultPointArr;
        DecoderResult decoderResultM6973a;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            Detector2 detector2 = new Detector2(binaryBitmap.m6913a());
            ResultPoint[] resultPointArrM6957b = detector2.f13343b.m6957b();
            ResultPoint resultPoint = resultPointArrM6957b[0];
            ResultPoint resultPoint2 = resultPointArrM6957b[1];
            ResultPoint resultPoint3 = resultPointArrM6957b[2];
            ResultPoint resultPoint4 = resultPointArrM6957b[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(detector2.m6978e(resultPoint, resultPoint2));
            arrayList.add(detector2.m6978e(resultPoint, resultPoint3));
            arrayList.add(detector2.m6978e(resultPoint2, resultPoint4));
            arrayList.add(detector2.m6978e(resultPoint3, resultPoint4));
            Collections.sort(arrayList, new Detector2.c(null));
            Detector2.b bVar = (Detector2.b) arrayList.get(0);
            Detector2.b bVar2 = (Detector2.b) arrayList.get(1);
            HashMap map2 = new HashMap();
            Detector2.m6975b(map2, bVar.f13344a);
            Detector2.m6975b(map2, bVar.f13345b);
            Detector2.m6975b(map2, bVar2.f13344a);
            Detector2.m6975b(map2, bVar2.f13345b);
            ResultPoint resultPoint5 = null;
            ResultPoint resultPoint6 = null;
            ResultPoint resultPoint7 = null;
            for (Map.Entry entry : map2.entrySet()) {
                ResultPoint resultPoint8 = (ResultPoint) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    resultPoint6 = resultPoint8;
                } else if (resultPoint5 == null) {
                    resultPoint5 = resultPoint8;
                } else {
                    resultPoint7 = resultPoint8;
                }
            }
            if (resultPoint5 == null || resultPoint6 == null || resultPoint7 == null) {
                throw NotFoundException.f21665l;
            }
            ResultPoint[] resultPointArr2 = {resultPoint5, resultPoint6, resultPoint7};
            ResultPoint.m6923b(resultPointArr2);
            ResultPoint resultPoint9 = resultPointArr2[0];
            ResultPoint resultPoint10 = resultPointArr2[1];
            ResultPoint resultPoint11 = resultPointArr2[2];
            if (map2.containsKey(resultPoint)) {
                resultPoint = !map2.containsKey(resultPoint2) ? resultPoint2 : !map2.containsKey(resultPoint3) ? resultPoint3 : resultPoint4;
            }
            int i = detector2.m6978e(resultPoint11, resultPoint).f13346c;
            int i2 = detector2.m6978e(resultPoint9, resultPoint).f13346c;
            if ((i & 1) == 1) {
                i++;
            }
            int i3 = i + 2;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                float fM6974a = Detector2.m6974a(resultPoint10, resultPoint9) / i3;
                int iM6974a = Detector2.m6974a(resultPoint11, resultPoint);
                float f = resultPoint.f13207a;
                float f2 = iM6974a;
                float f3 = (f - resultPoint11.f13207a) / f2;
                float f4 = resultPoint.f13208b;
                ResultPoint resultPoint12 = new ResultPoint((f3 * fM6974a) + f, (fM6974a * ((f4 - resultPoint11.f13208b) / f2)) + f4);
                float fM6974a2 = Detector2.m6974a(resultPoint10, resultPoint11) / i4;
                int iM6974a2 = Detector2.m6974a(resultPoint9, resultPoint);
                float f5 = resultPoint.f13207a;
                float f6 = iM6974a2;
                float f7 = (f5 - resultPoint9.f13207a) / f6;
                float f8 = resultPoint.f13208b;
                ResultPoint resultPoint13 = new ResultPoint((f7 * fM6974a2) + f5, (fM6974a2 * ((f8 - resultPoint9.f13208b) / f6)) + f8);
                if (detector2.m6977c(resultPoint12)) {
                    if (!detector2.m6977c(resultPoint13) || Math.abs(i4 - detector2.m6978e(resultPoint9, resultPoint12).f13346c) + Math.abs(i3 - detector2.m6978e(resultPoint11, resultPoint12).f13346c) <= Math.abs(i4 - detector2.m6978e(resultPoint9, resultPoint13).f13346c) + Math.abs(i3 - detector2.m6978e(resultPoint11, resultPoint13).f13346c)) {
                        resultPoint13 = resultPoint12;
                    }
                } else if (!detector2.m6977c(resultPoint13)) {
                    resultPoint13 = null;
                }
                if (resultPoint13 != null) {
                    resultPoint = resultPoint13;
                }
                int i5 = detector2.m6978e(resultPoint11, resultPoint).f13346c;
                int i6 = detector2.m6978e(resultPoint9, resultPoint).f13346c;
                if ((i5 & 1) == 1) {
                    i5++;
                }
                int i7 = i5;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                bitMatrixM6976d = Detector2.m6976d(detector2.f13342a, resultPoint11, resultPoint10, resultPoint9, resultPoint, i7, i6);
            } else {
                float fMin = Math.min(i4, i3);
                float fM6974a3 = Detector2.m6974a(resultPoint10, resultPoint9) / fMin;
                int iM6974a3 = Detector2.m6974a(resultPoint11, resultPoint);
                float f9 = resultPoint.f13207a;
                float f10 = iM6974a3;
                float f11 = (f9 - resultPoint11.f13207a) / f10;
                float f12 = resultPoint.f13208b;
                ResultPoint resultPoint14 = new ResultPoint((f11 * fM6974a3) + f9, (fM6974a3 * ((f12 - resultPoint11.f13208b) / f10)) + f12);
                float fM6974a4 = Detector2.m6974a(resultPoint10, resultPoint11) / fMin;
                int iM6974a4 = Detector2.m6974a(resultPoint9, resultPoint);
                float f13 = resultPoint.f13207a;
                float f14 = iM6974a4;
                float f15 = (f13 - resultPoint9.f13207a) / f14;
                float f16 = resultPoint.f13208b;
                ResultPoint resultPoint15 = new ResultPoint((f15 * fM6974a4) + f13, (fM6974a4 * ((f16 - resultPoint9.f13208b) / f14)) + f16);
                if (detector2.m6977c(resultPoint14)) {
                    if (!detector2.m6977c(resultPoint15) || Math.abs(detector2.m6978e(resultPoint11, resultPoint14).f13346c - detector2.m6978e(resultPoint9, resultPoint14).f13346c) <= Math.abs(detector2.m6978e(resultPoint11, resultPoint15).f13346c - detector2.m6978e(resultPoint9, resultPoint15).f13346c)) {
                        resultPoint15 = resultPoint14;
                    }
                } else if (!detector2.m6977c(resultPoint15)) {
                    resultPoint15 = null;
                }
                if (resultPoint15 != null) {
                    resultPoint = resultPoint15;
                }
                int iMax = Math.max(detector2.m6978e(resultPoint11, resultPoint).f13346c, detector2.m6978e(resultPoint9, resultPoint).f13346c) + 1;
                if ((iMax & 1) == 1) {
                    iMax++;
                }
                int i8 = iMax;
                bitMatrixM6976d = Detector2.m6976d(detector2.f13342a, resultPoint11, resultPoint10, resultPoint9, resultPoint, i8, i8);
            }
            resultPointArr = new ResultPoint[]{resultPoint11, resultPoint10, resultPoint9, resultPoint};
            decoderResultM6973a = this.f13318b.m6973a(bitMatrixM6976d);
        } else {
            BitMatrix bitMatrixM6913a = binaryBitmap.m6913a();
            int[] iArrM6945i = bitMatrixM6913a.m6945i();
            int[] iArrM6943g = bitMatrixM6913a.m6943g();
            if (iArrM6945i == null || iArrM6943g == null) {
                throw NotFoundException.f21665l;
            }
            int i9 = bitMatrixM6913a.f13229j;
            int i10 = iArrM6945i[0];
            int i11 = iArrM6945i[1];
            while (i10 < i9 && bitMatrixM6913a.m6942f(i10, i11)) {
                i10++;
            }
            if (i10 == i9) {
                throw NotFoundException.f21665l;
            }
            int i12 = i10 - iArrM6945i[0];
            if (i12 == 0) {
                throw NotFoundException.f21665l;
            }
            int i13 = iArrM6945i[1];
            int i14 = iArrM6943g[1];
            int i15 = iArrM6945i[0];
            int i16 = ((iArrM6943g[0] - i15) + 1) / i12;
            int i17 = ((i14 - i13) + 1) / i12;
            if (i16 <= 0 || i17 <= 0) {
                throw NotFoundException.f21665l;
            }
            int i18 = i12 / 2;
            int i19 = i13 + i18;
            int i20 = i15 + i18;
            BitMatrix bitMatrix = new BitMatrix(i16, i17);
            for (int i21 = 0; i21 < i17; i21++) {
                int i22 = (i21 * i12) + i19;
                for (int i23 = 0; i23 < i16; i23++) {
                    if (bitMatrixM6913a.m6942f((i23 * i12) + i20, i22)) {
                        bitMatrix.m6946j(i23, i21);
                    }
                }
            }
            decoderResultM6973a = this.f13318b.m6973a(bitMatrix);
            resultPointArr = f13317a;
        }
        Result result = new Result(decoderResultM6973a.f13268c, decoderResultM6973a.f13266a, resultPointArr, BarcodeFormat.DATA_MATRIX);
        List<byte[]> list = decoderResultM6973a.f13269d;
        if (list != null) {
            result.m9262b(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = decoderResultM6973a.f13270e;
        if (str != null) {
            result.m9262b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
    }
}
