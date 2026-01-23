package p007b.p225i.p414e.p418n;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.Binarizer;
import p007b.p225i.p414e.LuminanceSource;

/* JADX INFO: renamed from: b.i.e.n.h, reason: use source file name */
/* JADX INFO: compiled from: HybridBinarizer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HybridBinarizer extends Binarizer {

    /* JADX INFO: renamed from: b */
    public static final byte[] f13277b = new byte[0];

    /* JADX INFO: renamed from: c */
    public byte[] f13278c;

    /* JADX INFO: renamed from: d */
    public final int[] f13279d;

    /* JADX INFO: renamed from: e */
    public BitMatrix f13280e;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.f13278c = f13277b;
        this.f13279d = new int[32];
    }

    /* JADX INFO: renamed from: a */
    public static int m6952a(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 <= i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i3 - i5 <= length / 16) {
            throw NotFoundException.f21665l;
        }
        int i11 = i3 - 1;
        int i12 = i11;
        int i13 = -1;
        while (i11 > i5) {
            int i14 = i11 - i5;
            int i15 = (i2 - iArr[i11]) * (i3 - i11) * i14 * i14;
            if (i15 > i13) {
                i12 = i11;
                i13 = i15;
            }
            i11--;
        }
        return i12 << 3;
    }

    /* JADX INFO: renamed from: b */
    public final void m6953b(int i) {
        if (this.f13278c.length < i) {
            this.f13278c = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f13279d[i2] = 0;
        }
    }
}
