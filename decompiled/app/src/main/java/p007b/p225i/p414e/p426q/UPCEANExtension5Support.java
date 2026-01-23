package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.EnumMap;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.n, reason: use source file name */
/* JADX INFO: compiled from: UPCEANExtension5Support.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCEANExtension5Support {

    /* JADX INFO: renamed from: a */
    public static final int[] f13383a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: b */
    public final int[] f13384b = new int[4];

    /* JADX INFO: renamed from: c */
    public final StringBuilder f13385c = new StringBuilder();

    /* JADX WARN: Removed duplicated region for block: B:67:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result m7002a(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        EnumMap enumMap;
        String str;
        String str2;
        StringBuilder sb = this.f13385c;
        sb.setLength(0);
        int[] iArr2 = this.f13384b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = bitArray.f13228k;
        int iM6937g = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && iM6937g < i2; i4++) {
            int iM7004h = UPCEANReader.m7004h(bitArray, iArr2, iM6937g, UPCEANReader.f13392d);
            sb.append((char) ((iM7004h % 10) + 48));
            for (int i5 : iArr2) {
                iM6937g += i5;
            }
            if (iM7004h >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                iM6937g = bitArray.m6937g(bitArray.m6936f(iM6937g));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.f21665l;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == f13383a[i6]) {
                int length = sb.toString().length();
                int iCharAt = 0;
                for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
                    iCharAt += r4.charAt(i7) - '0';
                }
                int iCharAt2 = iCharAt * 3;
                for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
                    iCharAt2 += r4.charAt(i8) - '0';
                }
                if ((iCharAt2 * 3) % 10 != i6) {
                    throw NotFoundException.f21665l;
                }
                String string = sb.toString();
                if (string.length() == 5) {
                    char cCharAt = string.charAt(0);
                    if (cCharAt == '0') {
                        str = "£";
                    } else if (cCharAt != '5') {
                        if (cCharAt == '9') {
                            switch (string) {
                                case "90000":
                                    str2 = null;
                                    break;
                                case "99990":
                                    str2 = "Used";
                                    break;
                                case "99991":
                                    str2 = "0.00";
                                    break;
                            }
                            if (str2 != null) {
                                enumMap = null;
                            } else {
                                enumMap = new EnumMap(ResultMetadataType.class);
                                enumMap.put(ResultMetadataType.SUGGESTED_PRICE, str2);
                            }
                        }
                        str = "";
                    } else {
                        str = "$";
                    }
                    int i9 = Integer.parseInt(string.substring(1));
                    String strValueOf = String.valueOf(i9 / 100);
                    int i10 = i9 % 100;
                    str2 = str + strValueOf + '.' + (i10 < 10 ? "0".concat(String.valueOf(i10)) : String.valueOf(i10));
                    if (str2 != null) {
                    }
                }
                float f = i;
                Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f), new ResultPoint(iM6937g, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
                if (enumMap != null) {
                    result.m9261a(enumMap);
                }
                return result;
            }
        }
        throw NotFoundException.f21665l;
    }
}
