package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p355b.p356a.Charsets;

/* compiled from: ParsableByteArray.java */
/* renamed from: b.i.a.c.f3.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class ParsableByteArray {

    /* renamed from: a */
    public byte[] f6793a;

    /* renamed from: b */
    public int f6794b;

    /* renamed from: c */
    public int f6795c;

    public ParsableByteArray() {
        this.f6793a = Util2.f6713f;
    }

    /* renamed from: A */
    public void m3075A(int i) {
        byte[] bArr = this.f6793a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        m3077C(bArr, i);
    }

    /* renamed from: B */
    public void m3076B(byte[] bArr) {
        int length = bArr.length;
        this.f6793a = bArr;
        this.f6795c = length;
        this.f6794b = 0;
    }

    /* renamed from: C */
    public void m3077C(byte[] bArr, int i) {
        this.f6793a = bArr;
        this.f6795c = i;
        this.f6794b = 0;
    }

    /* renamed from: D */
    public void m3078D(int i) {
        AnimatableValueParser.m531j(i >= 0 && i <= this.f6793a.length);
        this.f6795c = i;
    }

    /* renamed from: E */
    public void m3079E(int i) {
        AnimatableValueParser.m531j(i >= 0 && i <= this.f6795c);
        this.f6794b = i;
    }

    /* renamed from: F */
    public void m3080F(int i) {
        m3079E(this.f6794b + i);
    }

    /* renamed from: a */
    public int m3081a() {
        return this.f6795c - this.f6794b;
    }

    /* renamed from: b */
    public void m3082b(int i) {
        byte[] bArr = this.f6793a;
        if (i > bArr.length) {
            this.f6793a = Arrays.copyOf(bArr, i);
        }
    }

    /* renamed from: c */
    public int m3083c() {
        return this.f6793a[this.f6794b] & 255;
    }

    /* renamed from: d */
    public void m3084d(ParsableBitArray parsableBitArray, int i) {
        m3085e(parsableBitArray.f6789a, 0, i);
        parsableBitArray.m3071k(0);
    }

    /* renamed from: e */
    public void m3085e(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6793a, this.f6794b, bArr, i, i2);
        this.f6794b += i2;
    }

    /* renamed from: f */
    public int m3086f() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 16);
        int i6 = i4 + 1;
        this.f6794b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f6794b = i6 + 1;
        return (bArr[i6] & 255) | i7;
    }

    @Nullable
    /* renamed from: g */
    public String m3087g() {
        if (m3081a() == 0) {
            return null;
        }
        int i = this.f6794b;
        while (i < this.f6795c) {
            byte b2 = this.f6793a[i];
            int i2 = Util2.f6708a;
            if (b2 == 10 || b2 == 13) {
                break;
            }
            i++;
        }
        int i3 = this.f6794b;
        if (i - i3 >= 3) {
            byte[] bArr = this.f6793a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f6794b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f6793a;
        int i4 = this.f6794b;
        String strM3005m = Util2.m3005m(bArr2, i4, i - i4);
        this.f6794b = i;
        int i5 = this.f6795c;
        if (i == i5) {
            return strM3005m;
        }
        byte[] bArr3 = this.f6793a;
        if (bArr3[i] == 13) {
            int i6 = i + 1;
            this.f6794b = i6;
            if (i6 == i5) {
                return strM3005m;
            }
        }
        int i7 = this.f6794b;
        if (bArr3[i7] == 10) {
            this.f6794b = i7 + 1;
        }
        return strM3005m;
    }

    /* renamed from: h */
    public int m3088h() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        int i6 = i4 + 1;
        this.f6794b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f6794b = i6 + 1;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    /* renamed from: i */
    public short m3089i() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        this.f6794b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    /* renamed from: j */
    public long m3090j() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b + 1;
        this.f6794b = i;
        long j = bArr[r1] & 255;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((bArr[i] & 255) << 8) | ((bArr[i2] & 255) << 16);
        this.f6794b = i3 + 1;
        return j2 | ((bArr[i3] & 255) << 24);
    }

    /* renamed from: k */
    public int m3091k() {
        int iM3088h = m3088h();
        if (iM3088h >= 0) {
            return iM3088h;
        }
        throw new IllegalStateException(outline.m851g(29, "Top bit not zero: ", iM3088h));
    }

    /* renamed from: l */
    public int m3092l() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        this.f6794b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    /* renamed from: m */
    public long m3093m() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b + 1;
        this.f6794b = i;
        long j = (bArr[r1] & 255) << 56;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((bArr[i] & 255) << 48) | ((bArr[i2] & 255) << 40);
        int i4 = i3 + 1;
        this.f6794b = i4;
        long j3 = j2 | ((bArr[i3] & 255) << 32);
        int i5 = i4 + 1;
        this.f6794b = i5;
        long j4 = j3 | ((bArr[i4] & 255) << 24);
        int i6 = i5 + 1;
        this.f6794b = i6;
        long j5 = j4 | ((bArr[i5] & 255) << 16);
        int i7 = i6 + 1;
        this.f6794b = i7;
        long j6 = j5 | ((bArr[i6] & 255) << 8);
        this.f6794b = i7 + 1;
        return j6 | (bArr[i7] & 255);
    }

    @Nullable
    /* renamed from: n */
    public String m3094n() {
        if (m3081a() == 0) {
            return null;
        }
        int i = this.f6794b;
        while (i < this.f6795c && this.f6793a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f6793a;
        int i2 = this.f6794b;
        String strM3005m = Util2.m3005m(bArr, i2, i - i2);
        this.f6794b = i;
        if (i < this.f6795c) {
            this.f6794b = i + 1;
        }
        return strM3005m;
    }

    /* renamed from: o */
    public String m3095o(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f6794b;
        int i3 = (i2 + i) - 1;
        String strM3005m = Util2.m3005m(this.f6793a, i2, (i3 >= this.f6795c || this.f6793a[i3] != 0) ? i : i - 1);
        this.f6794b += i;
        return strM3005m;
    }

    /* renamed from: p */
    public short m3096p() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f6794b = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    /* renamed from: q */
    public String m3097q(int i) {
        return m3098r(i, Charsets.f11945c);
    }

    /* renamed from: r */
    public String m3098r(int i, Charset charset) {
        String str = new String(this.f6793a, this.f6794b, i, charset);
        this.f6794b += i;
        return str;
    }

    /* renamed from: s */
    public int m3099s() {
        return (m3100t() << 21) | (m3100t() << 14) | (m3100t() << 7) | m3100t();
    }

    /* renamed from: t */
    public int m3100t() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        this.f6794b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: u */
    public long m3101u() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b + 1;
        this.f6794b = i;
        long j = (bArr[r1] & 255) << 24;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((bArr[i] & 255) << 16) | ((bArr[i2] & 255) << 8);
        this.f6794b = i3 + 1;
        return j2 | (bArr[i3] & 255);
    }

    /* renamed from: v */
    public int m3102v() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        this.f6794b = i4 + 1;
        return (bArr[i4] & 255) | i5;
    }

    /* renamed from: w */
    public int m3103w() {
        int iM3086f = m3086f();
        if (iM3086f >= 0) {
            return iM3086f;
        }
        throw new IllegalStateException(outline.m851g(29, "Top bit not zero: ", iM3086f));
    }

    /* renamed from: x */
    public long m3104x() {
        long jM3093m = m3093m();
        if (jM3093m >= 0) {
            return jM3093m;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jM3093m);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: y */
    public int m3105y() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f6794b = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    /* renamed from: z */
    public long m3106z() {
        int i;
        int i2;
        long j = this.f6793a[this.f6794b];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        for (i = 1; i < i2; i++) {
            if ((this.f6793a[this.f6794b + i] & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | (r3 & 63);
        }
        this.f6794b += i2;
        return j;
    }

    public ParsableByteArray(int i) {
        this.f6793a = new byte[i];
        this.f6795c = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f6793a = bArr;
        this.f6795c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.f6793a = bArr;
        this.f6795c = i;
    }
}
