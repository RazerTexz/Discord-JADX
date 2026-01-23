package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.p, reason: use source file name */
/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UPCEANReader extends OneDReader {

    /* JADX INFO: renamed from: a */
    public static final int[] f13389a = {1, 1, 1};

    /* JADX INFO: renamed from: b */
    public static final int[] f13390b = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: c */
    public static final int[][] f13391c;

    /* JADX INFO: renamed from: d */
    public static final int[][] f13392d;

    /* JADX INFO: renamed from: e */
    public final StringBuilder f13393e = new StringBuilder(20);

    /* JADX INFO: renamed from: f */
    public final UPCEANExtensionSupport f13394f = new UPCEANExtensionSupport();

    /* JADX INFO: renamed from: g */
    public final EANManufacturerOrgSupport f13395g = new EANManufacturerOrgSupport();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f13391c = iArr;
        int[][] iArr2 = new int[20][];
        f13392d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f13391c[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            f13392d[i] = iArr4;
        }
    }

    /* JADX INFO: renamed from: h */
    public static int m7004h(BitArray bitArray, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        OneDReader.m6997e(bitArray, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fM6996d = OneDReader.m6996d(iArr, iArr2[i3], 0.7f);
            if (fM6996d < f) {
                i2 = i3;
                f = fM6996d;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: l */
    public static int[] m7005l(BitArray bitArray, int i, boolean z2, int[] iArr, int[] iArr2) throws NotFoundException {
        int i2 = bitArray.f13228k;
        int iM6937g = z2 ? bitArray.m6937g(i) : bitArray.m6936f(i);
        int length = iArr.length;
        boolean z3 = z2;
        int i3 = 0;
        int i4 = iM6937g;
        while (iM6937g < i2) {
            if (bitArray.m6935b(iM6937g) != z3) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (OneDReader.m6996d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iM6937g};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3 = i5;
                }
                iArr2[i3] = 1;
                z3 = !z3;
            }
            iM6937g++;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: m */
    public static int[] m7006m(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[f13389a.length];
        int[] iArrM7005l = null;
        boolean zM6938h = false;
        int i = 0;
        while (!zM6938h) {
            int[] iArr2 = f13389a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrM7005l = m7005l(bitArray, i, false, iArr2, iArr);
            int i2 = iArrM7005l[0];
            int i3 = iArrM7005l[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zM6938h = bitArray.m6938h(i4, i2, false);
            }
            i = i3;
        }
        return iArrM7005l;
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return mo7001k(i, bitArray, m7006m(bitArray), map);
    }

    /* JADX INFO: renamed from: g */
    public boolean mo7007g(String str) throws FormatException {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        int iDigit = Character.digit(str.charAt(i), 10);
        CharSequence charSequenceSubSequence = str.subSequence(0, i);
        int length2 = charSequenceSubSequence.length();
        int i2 = 0;
        for (int i3 = length2 - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequenceSubSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.m9260a();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        while (true) {
            length2 -= 2;
            if (length2 < 0) {
                return (1000 - i4) % 10 == iDigit;
            }
            int iCharAt2 = charSequenceSubSequence.charAt(length2) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                break;
            }
            i4 += iCharAt2;
        }
        throw FormatException.m9260a();
    }

    /* JADX INFO: renamed from: i */
    public int[] mo7008i(BitArray bitArray, int i) throws NotFoundException {
        int[] iArr = f13389a;
        return m7005l(bitArray, i, false, iArr, new int[iArr.length]);
    }

    /* JADX INFO: renamed from: j */
    public abstract int mo6989j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException;

    /* JADX INFO: renamed from: k */
    public Result mo7001k(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        boolean z2;
        String str = null;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (resultPointCallback != null) {
            resultPointCallback.m6924a(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f13393e;
        sb.setLength(0);
        int iMo6989j = mo6989j(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.m6924a(new ResultPoint(iMo6989j, i));
        }
        int[] iArrMo7008i = mo7008i(bitArray, iMo6989j);
        if (resultPointCallback != null) {
            resultPointCallback.m6924a(new ResultPoint((iArrMo7008i[0] + iArrMo7008i[1]) / 2.0f, i));
        }
        int i2 = iArrMo7008i[1];
        int i3 = (i2 - iArrMo7008i[0]) + i2;
        if (i3 >= bitArray.f13228k || !bitArray.m6938h(i2, i3, false)) {
            throw NotFoundException.f21665l;
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.m9260a();
        }
        if (!mo7007g(string)) {
            throw ChecksumException.m9259a();
        }
        BarcodeFormat barcodeFormatMo6990n = mo6990n();
        float f = i;
        Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArr[1] + iArr[0]) / 2.0f, f), new ResultPoint((iArrMo7008i[1] + iArrMo7008i[0]) / 2.0f, f)}, barcodeFormatMo6990n);
        try {
            Result resultM7003a = this.f13394f.m7003a(i, bitArray, iArrMo7008i[1]);
            result.m9262b(ResultMetadataType.UPC_EAN_EXTENSION, resultM7003a.f21668a);
            result.m9261a(resultM7003a.f21672e);
            ResultPoint[] resultPointArr = resultM7003a.f21670c;
            ResultPoint[] resultPointArr2 = result.f21670c;
            if (resultPointArr2 == null) {
                result.f21670c = resultPointArr;
            } else if (resultPointArr != null && resultPointArr.length > 0) {
                ResultPoint[] resultPointArr3 = new ResultPoint[resultPointArr2.length + resultPointArr.length];
                System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
                System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
                result.f21670c = resultPointArr3;
            }
            length = resultM7003a.f21668a.length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z2 = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (!z2) {
                throw NotFoundException.f21665l;
            }
        }
        if (barcodeFormatMo6990n == BarcodeFormat.EAN_13 || barcodeFormatMo6990n == BarcodeFormat.UPC_A) {
            EANManufacturerOrgSupport eANManufacturerOrgSupport = this.f13395g;
            eANManufacturerOrgSupport.m6992b();
            int i5 = Integer.parseInt(string.substring(0, 3));
            int size = eANManufacturerOrgSupport.f13371a.size();
            int i6 = 0;
            while (true) {
                if (i6 < size) {
                    int[] iArr3 = eANManufacturerOrgSupport.f13371a.get(i6);
                    int i7 = iArr3[0];
                    if (i5 < i7) {
                        break;
                    }
                    if (iArr3.length != 1) {
                        i7 = iArr3[1];
                    }
                    if (i5 <= i7) {
                        str = eANManufacturerOrgSupport.f13372b.get(i6);
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
            if (str != null) {
                result.m9262b(ResultMetadataType.POSSIBLE_COUNTRY, str);
            }
        }
        return result;
    }

    /* JADX INFO: renamed from: n */
    public abstract BarcodeFormat mo6990n();
}
