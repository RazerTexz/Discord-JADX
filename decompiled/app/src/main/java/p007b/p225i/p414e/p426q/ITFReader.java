package p007b.p225i.p414e.p426q;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.h, reason: use source file name */
/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ITFReader extends OneDReader {

    /* JADX INFO: renamed from: a */
    public static final int[] f13373a = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: b */
    public static final int[] f13374b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c */
    public static final int[][] f13375c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: d */
    public static final int[][] f13376d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: e */
    public int f13377e = -1;

    /* JADX INFO: renamed from: g */
    public static int m6993g(int[] iArr) throws NotFoundException {
        int length = f13376d.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fM6996d = OneDReader.m6996d(iArr, f13376d[i2], 0.5f);
            if (fM6996d < f) {
                i = i2;
                f = fM6996d;
            } else if (fM6996d == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: h */
    public static int[] m6994h(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = bitArray.f13228k;
        int i3 = i;
        boolean z2 = false;
        int i4 = 0;
        while (i < i2) {
            if (bitArray.m6935b(i) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (OneDReader.m6996d(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4 = i5;
                }
                iArr2[i4] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        int[] iArrM6994h;
        boolean z2;
        int i2 = bitArray.f13228k;
        int iM6936f = bitArray.m6936f(0);
        if (iM6936f == i2) {
            throw NotFoundException.f21665l;
        }
        int[] iArrM6994h2 = m6994h(bitArray, iM6936f, f13374b);
        this.f13377e = (iArrM6994h2[1] - iArrM6994h2[0]) / 4;
        m6995i(bitArray, iArrM6994h2[0]);
        bitArray.m6939i();
        try {
            int i3 = bitArray.f13228k;
            int iM6936f2 = bitArray.m6936f(0);
            if (iM6936f2 == i3) {
                throw NotFoundException.f21665l;
            }
            try {
                iArrM6994h = m6994h(bitArray, iM6936f2, f13375c[0]);
            } catch (NotFoundException unused) {
                iArrM6994h = m6994h(bitArray, iM6936f2, f13375c[1]);
            }
            m6995i(bitArray, iArrM6994h[0]);
            int i4 = iArrM6994h[0];
            int i5 = bitArray.f13228k;
            iArrM6994h[0] = i5 - iArrM6994h[1];
            iArrM6994h[1] = i5 - i4;
            bitArray.m6939i();
            StringBuilder sb = new StringBuilder(20);
            int i6 = iArrM6994h2[1];
            int i7 = iArrM6994h[0];
            int[] iArr = new int[10];
            int[] iArr2 = new int[5];
            int[] iArr3 = new int[5];
            while (i6 < i7) {
                OneDReader.m6997e(bitArray, i6, iArr);
                for (int i8 = 0; i8 < 5; i8++) {
                    int i9 = i8 * 2;
                    iArr2[i8] = iArr[i9];
                    iArr3[i8] = iArr[i9 + 1];
                }
                sb.append((char) (m6993g(iArr2) + 48));
                sb.append((char) (m6993g(iArr3) + 48));
                for (int i10 = 0; i10 < 10; i10++) {
                    i6 += iArr[i10];
                }
            }
            String string = sb.toString();
            int[] iArr4 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
            if (iArr4 == null) {
                iArr4 = f13373a;
            }
            int length = string.length();
            int length2 = iArr4.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= length2) {
                    z2 = false;
                    break;
                }
                int i13 = iArr4[i11];
                if (length == i13) {
                    z2 = true;
                    break;
                }
                if (i13 > i12) {
                    i12 = i13;
                }
                i11++;
            }
            if (!z2 && length > i12) {
                z2 = true;
            }
            if (!z2) {
                throw FormatException.m9260a();
            }
            float f = i;
            return new Result(string, null, new ResultPoint[]{new ResultPoint(iArrM6994h2[1], f), new ResultPoint(iArrM6994h[0], f)}, BarcodeFormat.ITF);
        } catch (Throwable th) {
            bitArray.m6939i();
            throw th;
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m6995i(BitArray bitArray, int i) throws NotFoundException {
        int i2 = this.f13377e * 10;
        if (i2 >= i) {
            i2 = i;
        }
        while (true) {
            i--;
            if (i2 <= 0 || i < 0 || bitArray.m6935b(i)) {
                break;
            } else {
                i2--;
            }
        }
        if (i2 != 0) {
            throw NotFoundException.f21665l;
        }
    }
}
