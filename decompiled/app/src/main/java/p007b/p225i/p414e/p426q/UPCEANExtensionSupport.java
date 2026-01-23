package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.EnumMap;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.o, reason: use source file name */
/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCEANExtensionSupport {

    /* JADX INFO: renamed from: a */
    public static final int[] f13386a = {1, 1, 2};

    /* JADX INFO: renamed from: b */
    public final UPCEANExtension2Support f13387b = new UPCEANExtension2Support();

    /* JADX INFO: renamed from: c */
    public final UPCEANExtension5Support f13388c = new UPCEANExtension5Support();

    /* JADX INFO: renamed from: a */
    public Result m7003a(int i, BitArray bitArray, int i2) throws NotFoundException {
        EnumMap enumMap;
        int[] iArr = f13386a;
        int[] iArrM7005l = UPCEANReader.m7005l(bitArray, i2, false, iArr, new int[iArr.length]);
        try {
            return this.f13388c.m7002a(i, bitArray, iArrM7005l);
        } catch (ReaderException unused) {
            UPCEANExtension2Support uPCEANExtension2Support = this.f13387b;
            StringBuilder sb = uPCEANExtension2Support.f13382b;
            sb.setLength(0);
            int[] iArr2 = uPCEANExtension2Support.f13381a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i3 = bitArray.f13228k;
            int iM6937g = iArrM7005l[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && iM6937g < i3; i5++) {
                int iM7004h = UPCEANReader.m7004h(bitArray, iArr2, iM6937g, UPCEANReader.f13392d);
                sb.append((char) ((iM7004h % 10) + 48));
                for (int i6 : iArr2) {
                    iM6937g += i6;
                }
                if (iM7004h >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    iM6937g = bitArray.m6937g(bitArray.m6936f(iM6937g));
                }
            }
            if (sb.length() != 2) {
                throw NotFoundException.f21665l;
            }
            if (Integer.parseInt(sb.toString()) % 4 != i4) {
                throw NotFoundException.f21665l;
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(ResultMetadataType.class);
                enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(string));
            }
            float f = i;
            Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArrM7005l[0] + iArrM7005l[1]) / 2.0f, f), new ResultPoint(iM6937g, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                result.m9261a(enumMap);
            }
            return result;
        }
    }
}
