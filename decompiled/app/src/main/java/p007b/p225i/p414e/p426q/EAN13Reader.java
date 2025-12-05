package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: EAN13Reader.java */
/* renamed from: b.i.e.q.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class EAN13Reader extends UPCEANReader {

    /* renamed from: h */
    public static final int[] f13368h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i */
    public final int[] f13369i = new int[4];

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* renamed from: j */
    public int mo6989j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f13369i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = bitArray.f13228k;
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < i; i4++) {
            int iM7004h = UPCEANReader.m7004h(bitArray, iArr2, i2, UPCEANReader.f13392d);
            sb.append((char) ((iM7004h % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iM7004h >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == f13368h[i6]) {
                sb.insert(0, (char) (i6 + 48));
                int[] iArr3 = UPCEANReader.f13390b;
                int i7 = UPCEANReader.m7005l(bitArray, i2, true, iArr3, new int[iArr3.length])[1];
                for (int i8 = 0; i8 < 6 && i7 < i; i8++) {
                    sb.append((char) (UPCEANReader.m7004h(bitArray, iArr2, i7, UPCEANReader.f13391c) + 48));
                    for (int i9 : iArr2) {
                        i7 += i9;
                    }
                }
                return i7;
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* renamed from: n */
    public BarcodeFormat mo6990n() {
        return BarcodeFormat.EAN_13;
    }
}
