package p007b.p225i.p414e.p434s;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.Reader;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p418n.DefaultGridSampler;
import p007b.p225i.p414e.p418n.PerspectiveTransform;
import p007b.p225i.p414e.p434s.p435b.Decoder5;
import p007b.p225i.p414e.p434s.p435b.QRCodeDecoderMetaData;
import p007b.p225i.p414e.p434s.p435b.Version3;
import p007b.p225i.p414e.p434s.p436c.AlignmentPattern;
import p007b.p225i.p414e.p434s.p436c.Detector4;
import p007b.p225i.p414e.p434s.p436c.FinderPattern2;
import p007b.p225i.p414e.p434s.p436c.FinderPatternFinder;
import p007b.p225i.p414e.p434s.p436c.FinderPatternInfo;

/* JADX INFO: renamed from: b.i.e.s.a, reason: use source file name */
/* JADX INFO: compiled from: QRCodeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class QRCodeReader implements Reader {

    /* JADX INFO: renamed from: a */
    public static final ResultPoint[] f13508a = new ResultPoint[0];

    /* JADX INFO: renamed from: b */
    public final Decoder5 f13509b = new Decoder5();

    /* JADX WARN: Removed duplicated region for block: B:116:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c7  */
    @Override // p007b.p225i.p414e.Reader
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i;
        AlignmentPattern alignmentPatternM7110b;
        float f;
        float f2;
        float f3;
        DecoderResult decoderResultM7097a;
        ResultPoint[] resultPointArr;
        int i2;
        int i3;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            BitMatrix bitMatrixM6913a = binaryBitmap.m6913a();
            Detector4 detector4 = new Detector4(bitMatrixM6913a);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            detector4.f13569b = resultPointCallback;
            FinderPatternFinder finderPatternFinder = new FinderPatternFinder(bitMatrixM6913a, resultPointCallback);
            boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
            int i4 = bitMatrixM6913a.f13230k;
            int i5 = bitMatrixM6913a.f13229j;
            int i6 = (i4 * 3) / 388;
            if (i6 < 3 || z2) {
                i6 = 3;
            }
            int[] iArr = new int[5];
            int i7 = i6 - 1;
            boolean zM7118f = false;
            while (true) {
                int i8 = 4;
                if (i7 >= i4 || zM7118f) {
                    break;
                }
                finderPatternFinder.m7115b(iArr);
                int i9 = 0;
                int i10 = 0;
                while (i9 < i5) {
                    if (finderPatternFinder.f13572a.m6942f(i9, i7)) {
                        if ((i10 & 1) == 1) {
                            i10++;
                        }
                        iArr[i10] = iArr[i10] + 1;
                    } else if ((i10 & 1) != 0) {
                        iArr[i10] = iArr[i10] + 1;
                    } else if (i10 != i8) {
                        i10++;
                        iArr[i10] = iArr[i10] + 1;
                    } else if (FinderPatternFinder.m7114c(iArr) && finderPatternFinder.m7117e(iArr, i7, i9)) {
                        if (finderPatternFinder.f13574c) {
                            zM7118f = finderPatternFinder.m7118f();
                        } else if (finderPatternFinder.f13573b.size() <= 1) {
                            i2 = 2;
                            i3 = 0;
                            if (i3 > iArr[i2]) {
                                i7 += (i3 - iArr[i2]) - i2;
                                i9 = i5 - 1;
                            }
                        } else {
                            FinderPattern2 finderPattern2 = null;
                            for (FinderPattern2 finderPattern22 : finderPatternFinder.f13573b) {
                                if (finderPattern22.f13571d >= 2) {
                                    if (finderPattern2 != null) {
                                        finderPatternFinder.f13574c = true;
                                        int iAbs = (int) (Math.abs(finderPattern2.f13207a - finderPattern22.f13207a) - Math.abs(finderPattern2.f13208b - finderPattern22.f13208b));
                                        i2 = 2;
                                        i3 = iAbs / 2;
                                        break;
                                    }
                                    finderPattern2 = finderPattern22;
                                }
                            }
                            i2 = 2;
                            i3 = 0;
                            if (i3 > iArr[i2]) {
                            }
                        }
                        finderPatternFinder.m7115b(iArr);
                        i6 = 2;
                        i10 = 0;
                    } else {
                        finderPatternFinder.m7119g(iArr);
                        i10 = 3;
                    }
                    i9++;
                    i8 = 4;
                }
                if (FinderPatternFinder.m7114c(iArr) && finderPatternFinder.m7117e(iArr, i7, i5)) {
                    i6 = iArr[0];
                    if (finderPatternFinder.f13574c) {
                        zM7118f = finderPatternFinder.m7118f();
                    }
                }
                i7 += i6;
            }
            int size = finderPatternFinder.f13573b.size();
            if (size < 3) {
                throw NotFoundException.f21665l;
            }
            float f4 = 0.0f;
            if (size > 3) {
                Iterator<FinderPattern2> it = finderPatternFinder.f13573b.iterator();
                float f5 = 0.0f;
                float f6 = 0.0f;
                while (it.hasNext()) {
                    float f7 = it.next().f13570c;
                    f5 += f7;
                    f6 += f7 * f7;
                }
                float f8 = f5 / size;
                float fSqrt = (float) Math.sqrt((f6 / r3) - (f8 * f8));
                Collections.sort(finderPatternFinder.f13573b, new FinderPatternFinder.c(f8, null));
                float fMax = Math.max(0.2f * f8, fSqrt);
                int i11 = 0;
                while (i11 < finderPatternFinder.f13573b.size() && finderPatternFinder.f13573b.size() > 3) {
                    if (Math.abs(finderPatternFinder.f13573b.get(i11).f13570c - f8) > fMax) {
                        finderPatternFinder.f13573b.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (finderPatternFinder.f13573b.size() > 3) {
                Iterator<FinderPattern2> it2 = finderPatternFinder.f13573b.iterator();
                while (it2.hasNext()) {
                    f4 += it2.next().f13570c;
                }
                Collections.sort(finderPatternFinder.f13573b, new FinderPatternFinder.b(f4 / finderPatternFinder.f13573b.size(), null));
                List<FinderPattern2> list = finderPatternFinder.f13573b;
                i = 3;
                list.subList(3, list.size()).clear();
            } else {
                i = 3;
            }
            FinderPattern2[] finderPattern2Arr = new FinderPattern2[i];
            finderPattern2Arr[0] = finderPatternFinder.f13573b.get(0);
            finderPattern2Arr[1] = finderPatternFinder.f13573b.get(1);
            finderPattern2Arr[2] = finderPatternFinder.f13573b.get(2);
            ResultPoint.m6923b(finderPattern2Arr);
            FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPattern2Arr);
            FinderPattern2 finderPattern23 = finderPatternInfo.f13578b;
            FinderPattern2 finderPattern24 = finderPatternInfo.f13579c;
            FinderPattern2 finderPattern25 = finderPatternInfo.f13577a;
            float fM7109a = (detector4.m7109a(finderPattern23, finderPattern25) + detector4.m7109a(finderPattern23, finderPattern24)) / 2.0f;
            if (fM7109a < 1.0f) {
                throw NotFoundException.f21665l;
            }
            int iM4265Z0 = ((C3404f.m4265Z0(C3404f.m4237Q(finderPattern23.f13207a, finderPattern23.f13208b, finderPattern25.f13207a, finderPattern25.f13208b) / fM7109a) + C3404f.m4265Z0(C3404f.m4237Q(finderPattern23.f13207a, finderPattern23.f13208b, finderPattern24.f13207a, finderPattern24.f13208b) / fM7109a)) / 2) + 7;
            int i12 = iM4265Z0 & 3;
            if (i12 == 0) {
                iM4265Z0++;
            } else if (i12 == 2) {
                iM4265Z0--;
            } else if (i12 == 3) {
                throw NotFoundException.f21665l;
            }
            int[] iArr2 = Version3.f13548a;
            if (iM4265Z0 % 4 != 1) {
                throw FormatException.m9260a();
            }
            try {
                Version3 version3M7104d = Version3.m7104d((iM4265Z0 - 17) / 4);
                int iM7105c = version3M7104d.m7105c() - 7;
                if (version3M7104d.f13551d.length > 0) {
                    float f9 = finderPattern24.f13207a;
                    float f10 = finderPattern23.f13207a;
                    float f11 = (f9 - f10) + finderPattern25.f13207a;
                    float f12 = finderPattern24.f13208b;
                    float f13 = finderPattern23.f13208b;
                    float f14 = (f12 - f13) + finderPattern25.f13208b;
                    float f15 = 1.0f - (3.0f / iM7105c);
                    int iM839a = (int) outline.m839a(f11, f10, f15, f10);
                    int iM839a2 = (int) outline.m839a(f14, f13, f15, f13);
                    for (int i13 = 4; i13 <= 16; i13 <<= 1) {
                        try {
                            alignmentPatternM7110b = detector4.m7110b(fM7109a, iM839a, iM839a2, i13);
                            break;
                        } catch (NotFoundException unused) {
                        }
                    }
                    alignmentPatternM7110b = null;
                    float f16 = iM4265Z0 - 3.5f;
                    if (alignmentPatternM7110b == null) {
                        f = alignmentPatternM7110b.f13207a;
                        f2 = alignmentPatternM7110b.f13208b;
                        f3 = f16 - 3.0f;
                    } else {
                        f = (finderPattern24.f13207a - finderPattern23.f13207a) + finderPattern25.f13207a;
                        f2 = (finderPattern24.f13208b - finderPattern23.f13208b) + finderPattern25.f13208b;
                        f3 = f16;
                    }
                    BitMatrix bitMatrixM6951a = DefaultGridSampler.f13274a.m6951a(detector4.f13568a, iM4265Z0, iM4265Z0, PerspectiveTransform.m6954a(3.5f, 3.5f, f16, 3.5f, f3, f3, 3.5f, f16, finderPattern23.f13207a, finderPattern23.f13208b, finderPattern24.f13207a, finderPattern24.f13208b, f, f2, finderPattern25.f13207a, finderPattern25.f13208b));
                    ResultPoint[] resultPointArr2 = alignmentPatternM7110b != null ? new ResultPoint[]{finderPattern25, finderPattern23, finderPattern24} : new ResultPoint[]{finderPattern25, finderPattern23, finderPattern24, alignmentPatternM7110b};
                    decoderResultM7097a = this.f13509b.m7097a(bitMatrixM6951a, map);
                    resultPointArr = resultPointArr2;
                } else {
                    alignmentPatternM7110b = null;
                    float f162 = iM4265Z0 - 3.5f;
                    if (alignmentPatternM7110b == null) {
                    }
                    BitMatrix bitMatrixM6951a2 = DefaultGridSampler.f13274a.m6951a(detector4.f13568a, iM4265Z0, iM4265Z0, PerspectiveTransform.m6954a(3.5f, 3.5f, f162, 3.5f, f3, f3, 3.5f, f162, finderPattern23.f13207a, finderPattern23.f13208b, finderPattern24.f13207a, finderPattern24.f13208b, f, f2, finderPattern25.f13207a, finderPattern25.f13208b));
                    if (alignmentPatternM7110b != null) {
                    }
                    decoderResultM7097a = this.f13509b.m7097a(bitMatrixM6951a2, map);
                    resultPointArr = resultPointArr2;
                }
            } catch (IllegalArgumentException unused2) {
                throw FormatException.m9260a();
            }
        } else {
            BitMatrix bitMatrixM6913a2 = binaryBitmap.m6913a();
            int[] iArrM6945i = bitMatrixM6913a2.m6945i();
            int[] iArrM6943g = bitMatrixM6913a2.m6943g();
            if (iArrM6945i == null || iArrM6943g == null) {
                throw NotFoundException.f21665l;
            }
            int i14 = bitMatrixM6913a2.f13230k;
            int i15 = bitMatrixM6913a2.f13229j;
            int i16 = iArrM6945i[0];
            int i17 = iArrM6945i[1];
            boolean z3 = true;
            int i18 = 0;
            while (i16 < i15 && i17 < i14) {
                if (z3 != bitMatrixM6913a2.m6942f(i16, i17)) {
                    i18++;
                    if (i18 == 5) {
                        break;
                    }
                    z3 = !z3;
                }
                i16++;
                i17++;
            }
            if (i16 == i15 || i17 == i14) {
                throw NotFoundException.f21665l;
            }
            float f17 = (i16 - iArrM6945i[0]) / 7.0f;
            int i19 = iArrM6945i[1];
            int i20 = iArrM6943g[1];
            int i21 = iArrM6945i[0];
            int i22 = iArrM6943g[0];
            if (i21 >= i22 || i19 >= i20) {
                throw NotFoundException.f21665l;
            }
            int i23 = i20 - i19;
            if (i23 != i22 - i21 && (i22 = i21 + i23) >= bitMatrixM6913a2.f13229j) {
                throw NotFoundException.f21665l;
            }
            int iRound = Math.round(((i22 - i21) + 1) / f17);
            int iRound2 = Math.round((i23 + 1) / f17);
            if (iRound <= 0 || iRound2 <= 0) {
                throw NotFoundException.f21665l;
            }
            if (iRound2 != iRound) {
                throw NotFoundException.f21665l;
            }
            int i24 = (int) (f17 / 2.0f);
            int i25 = i19 + i24;
            int i26 = i21 + i24;
            int i27 = (((int) ((iRound - 1) * f17)) + i26) - i22;
            if (i27 > 0) {
                if (i27 > i24) {
                    throw NotFoundException.f21665l;
                }
                i26 -= i27;
            }
            int i28 = (((int) ((iRound2 - 1) * f17)) + i25) - i20;
            if (i28 > 0) {
                if (i28 > i24) {
                    throw NotFoundException.f21665l;
                }
                i25 -= i28;
            }
            BitMatrix bitMatrix = new BitMatrix(iRound, iRound2);
            for (int i29 = 0; i29 < iRound2; i29++) {
                int i30 = ((int) (i29 * f17)) + i25;
                for (int i31 = 0; i31 < iRound; i31++) {
                    if (bitMatrixM6913a2.m6942f(((int) (i31 * f17)) + i26, i30)) {
                        bitMatrix.m6946j(i31, i29);
                    }
                }
            }
            decoderResultM7097a = this.f13509b.m7097a(bitMatrix, map);
            resultPointArr = f13508a;
        }
        Object obj = decoderResultM7097a.f13271f;
        if ((obj instanceof QRCodeDecoderMetaData) && ((QRCodeDecoderMetaData) obj).f13547a && resultPointArr.length >= 3) {
            ResultPoint resultPoint = resultPointArr[0];
            resultPointArr[0] = resultPointArr[2];
            resultPointArr[2] = resultPoint;
        }
        Result result = new Result(decoderResultM7097a.f13268c, decoderResultM7097a.f13266a, resultPointArr, BarcodeFormat.QR_CODE);
        List<byte[]> list2 = decoderResultM7097a.f13269d;
        if (list2 != null) {
            result.m9262b(ResultMetadataType.BYTE_SEGMENTS, list2);
        }
        String str = decoderResultM7097a.f13270e;
        if (str != null) {
            result.m9262b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        if (decoderResultM7097a.f13272g >= 0 && decoderResultM7097a.f13273h >= 0) {
            result.m9262b(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResultM7097a.f13273h));
            result.m9262b(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResultM7097a.f13272g));
        }
        return result;
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
    }
}
