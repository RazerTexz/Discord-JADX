package p007b.p225i.p226a.p242c.p259f3;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: ParsableBitArray.java */
/* renamed from: b.i.a.c.f3.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class ParsableBitArray {

    /* renamed from: a */
    public byte[] f6789a;

    /* renamed from: b */
    public int f6790b;

    /* renamed from: c */
    public int f6791c;

    /* renamed from: d */
    public int f6792d;

    public ParsableBitArray() {
        this.f6789a = Util2.f6713f;
    }

    /* renamed from: a */
    public final void m3061a() {
        int i;
        int i2 = this.f6790b;
        AnimatableValueParser.m426D(i2 >= 0 && (i2 < (i = this.f6792d) || (i2 == i && this.f6791c == 0)));
    }

    /* renamed from: b */
    public int m3062b() {
        return ((this.f6792d - this.f6790b) * 8) - this.f6791c;
    }

    /* renamed from: c */
    public void m3063c() {
        if (this.f6791c == 0) {
            return;
        }
        this.f6791c = 0;
        this.f6790b++;
        m3061a();
    }

    /* renamed from: d */
    public int m3064d() {
        AnimatableValueParser.m426D(this.f6791c == 0);
        return this.f6790b;
    }

    /* renamed from: e */
    public int m3065e() {
        return (this.f6790b * 8) + this.f6791c;
    }

    /* renamed from: f */
    public boolean m3066f() {
        boolean z2 = (this.f6789a[this.f6790b] & (128 >> this.f6791c)) != 0;
        m3072l();
        return z2;
    }

    /* renamed from: g */
    public int m3067g(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.f6791c += i;
        int i3 = 0;
        while (true) {
            i2 = this.f6791c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.f6791c = i4;
            byte[] bArr = this.f6789a;
            int i5 = this.f6790b;
            this.f6790b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.f6789a;
        int i6 = this.f6790b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f6791c = 0;
            this.f6790b = i6 + 1;
        }
        m3061a();
        return i7;
    }

    /* renamed from: h */
    public void m3068h(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.f6789a;
            int i4 = this.f6790b;
            int i5 = i4 + 1;
            this.f6790b = i5;
            byte b2 = bArr2[i4];
            int i6 = this.f6791c;
            bArr[i] = (byte) (b2 << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.f6791c;
        if (i8 + i7 > 8) {
            int i9 = bArr[i3];
            byte[] bArr3 = this.f6789a;
            int i10 = this.f6790b;
            this.f6790b = i10 + 1;
            bArr[i3] = (byte) (i9 | ((bArr3[i10] & 255) << i8));
            this.f6791c = i8 - 8;
        }
        int i11 = this.f6791c + i7;
        this.f6791c = i11;
        byte[] bArr4 = this.f6789a;
        int i12 = this.f6790b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i7))) | bArr[i3]);
        if (i11 == 8) {
            this.f6791c = 0;
            this.f6790b = i12 + 1;
        }
        m3061a();
    }

    /* renamed from: i */
    public void m3069i(byte[] bArr, int i, int i2) {
        AnimatableValueParser.m426D(this.f6791c == 0);
        System.arraycopy(this.f6789a, this.f6790b, bArr, i, i2);
        this.f6790b += i2;
        m3061a();
    }

    /* renamed from: j */
    public void m3070j(byte[] bArr, int i) {
        this.f6789a = bArr;
        this.f6790b = 0;
        this.f6791c = 0;
        this.f6792d = i;
    }

    /* renamed from: k */
    public void m3071k(int i) {
        int i2 = i / 8;
        this.f6790b = i2;
        this.f6791c = i - (i2 * 8);
        m3061a();
    }

    /* renamed from: l */
    public void m3072l() {
        int i = this.f6791c + 1;
        this.f6791c = i;
        if (i == 8) {
            this.f6791c = 0;
            this.f6790b++;
        }
        m3061a();
    }

    /* renamed from: m */
    public void m3073m(int i) {
        int i2 = i / 8;
        int i3 = this.f6790b + i2;
        this.f6790b = i3;
        int i4 = (i - (i2 * 8)) + this.f6791c;
        this.f6791c = i4;
        if (i4 > 7) {
            this.f6790b = i3 + 1;
            this.f6791c = i4 - 8;
        }
        m3061a();
    }

    /* renamed from: n */
    public void m3074n(int i) {
        AnimatableValueParser.m426D(this.f6791c == 0);
        this.f6790b += i;
        m3061a();
    }

    public ParsableBitArray(byte[] bArr) {
        int length = bArr.length;
        this.f6789a = bArr;
        this.f6792d = length;
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.f6789a = bArr;
        this.f6792d = i;
    }
}
