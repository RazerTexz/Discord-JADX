package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: EAN8Reader.java */
/* renamed from: b.i.e.q.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class EAN8Reader extends UPCEANReader {

    /* renamed from: h */
    public final int[] f13370h = new int[4];

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* renamed from: j */
    public int mo6989j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f13370h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = bitArray.f13228k;
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < i; i3++) {
            sb.append((char) (UPCEANReader.m7004h(bitArray, iArr2, i2, UPCEANReader.f13391c) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int[] iArr3 = UPCEANReader.f13390b;
        int i5 = UPCEANReader.m7005l(bitArray, i2, true, iArr3, new int[iArr3.length])[1];
        for (int i6 = 0; i6 < 4 && i5 < i; i6++) {
            sb.append((char) (UPCEANReader.m7004h(bitArray, iArr2, i5, UPCEANReader.f13391c) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* renamed from: n */
    public BarcodeFormat mo6990n() {
        return BarcodeFormat.EAN_8;
    }
}
