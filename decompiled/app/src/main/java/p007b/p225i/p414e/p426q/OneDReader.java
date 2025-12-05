package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.LuminanceSource;
import p007b.p225i.p414e.Reader;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;
import p007b.p225i.p414e.p418n.HybridBinarizer;

/* compiled from: OneDReader.java */
/* renamed from: b.i.e.q.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class OneDReader implements Reader {
    /* renamed from: d */
    public static float m6996d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    /* renamed from: e */
    public static void m6997e(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = bitArray.f13228k;
        if (i >= i3) {
            throw NotFoundException.f21665l;
        }
        boolean z2 = !bitArray.m6935b(i);
        while (i < i3) {
            if (bitArray.m6935b(i) == z2) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z2 = !z2;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != i3) {
                throw NotFoundException.f21665l;
            }
        }
    }

    /* renamed from: f */
    public static void m6998f(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zM6935b = bitArray.m6935b(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.m6935b(i) != zM6935b) {
                length--;
                zM6935b = !zM6935b;
            }
        }
        if (length >= 0) {
            throw NotFoundException.f21665l;
        }
        m6997e(bitArray, i + 1, iArr);
    }

    @Override // p007b.p225i.p414e.Reader
    /* renamed from: a */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
        try {
            return m6999c(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.f13171a.f13170a.mo6917c()) {
                throw e;
            }
            LuminanceSource luminanceSourceMo6918d = binaryBitmap.f13171a.f13170a.mo6918d();
            Objects.requireNonNull((HybridBinarizer) binaryBitmap.f13171a);
            Result resultM6999c = m6999c(new BinaryBitmap(new HybridBinarizer(luminanceSourceMo6918d)), map);
            Map<ResultMetadataType, Object> map2 = resultM6999c.f21672e;
            int iIntValue = 270;
            if (map2 != null && map2.containsKey(resultMetadataType)) {
                iIntValue = (((Integer) map2.get(resultMetadataType)).intValue() + 270) % 360;
            }
            resultM6999c.m9262b(resultMetadataType, Integer.valueOf(iIntValue));
            ResultPoint[] resultPointArr = resultM6999c.f21670c;
            if (resultPointArr != null) {
                int i = luminanceSourceMo6918d.f13187b;
                for (int i2 = 0; i2 < resultPointArr.length; i2++) {
                    resultPointArr[i2] = new ResultPoint((i - resultPointArr[i2].f13208b) - 1.0f, resultPointArr[i2].f13207a);
                }
            }
            return resultM6999c;
        }
    }

    /* renamed from: b */
    public abstract Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Result m6999c(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        OneDReader oneDReader;
        Map<DecodeHintType, ?> map2;
        int i;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        Map<DecodeHintType, ?> map3 = map;
        LuminanceSource luminanceSource = binaryBitmap2.f13171a.f13170a;
        int i2 = luminanceSource.f13186a;
        int i3 = luminanceSource.f13187b;
        BitArray bitArray = new BitArray(i2);
        int i4 = 1;
        boolean z2 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, i3 >> (z2 ? 8 : 5));
        int i5 = z2 ? i3 : 15;
        int i6 = i3 / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i6;
            if (i10 < 0 || i10 >= i3) {
                break;
            }
            try {
                bitArray = binaryBitmap2.m6914b(i10, bitArray);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        bitArray.m6939i();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                oneDReader = this;
                                map3 = enumMap;
                            } else {
                                oneDReader = this;
                            }
                        }
                    }
                    try {
                        Result resultMo6983b = oneDReader.mo6983b(i10, bitArray, map3);
                        if (i11 == i4) {
                            resultMo6983b.m9262b(ResultMetadataType.ORIENTATION, 180);
                            ResultPoint[] resultPointArr = resultMo6983b.f21670c;
                            if (resultPointArr != null) {
                                float f = i2;
                                map2 = map3;
                                try {
                                    i = i3;
                                    try {
                                        resultPointArr[0] = new ResultPoint((f - resultPointArr[0].f13207a) - 1.0f, resultPointArr[0].f13208b);
                                        try {
                                            resultPointArr[1] = new ResultPoint((f - resultPointArr[1].f13207a) - 1.0f, resultPointArr[1].f13208b);
                                        } catch (ReaderException unused) {
                                            continue;
                                            i11++;
                                            map3 = map2;
                                            i3 = i;
                                            i4 = 1;
                                        }
                                    } catch (ReaderException unused2) {
                                        i11++;
                                        map3 = map2;
                                        i3 = i;
                                        i4 = 1;
                                    }
                                } catch (ReaderException unused3) {
                                    i = i3;
                                    i11++;
                                    map3 = map2;
                                    i3 = i;
                                    i4 = 1;
                                }
                            }
                        }
                        return resultMo6983b;
                    } catch (ReaderException unused4) {
                        map2 = map3;
                    }
                }
            } catch (NotFoundException unused5) {
            }
            binaryBitmap2 = binaryBitmap;
            i7 = i8;
            i3 = i3;
            i4 = 1;
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
    }
}
