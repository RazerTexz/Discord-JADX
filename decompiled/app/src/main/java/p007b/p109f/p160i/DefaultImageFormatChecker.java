package p007b.p109f.p160i;

import androidx.exifinterface.media.ExifInterface;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p128m.WebpSupportStatus;
import p007b.p109f.p160i.ImageFormat;

/* compiled from: DefaultImageFormatChecker.java */
/* renamed from: b.f.i.a, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultImageFormatChecker implements ImageFormat.a {

    /* renamed from: a */
    public static final byte[] f3569a;

    /* renamed from: b */
    public static final int f3570b;

    /* renamed from: c */
    public static final byte[] f3571c;

    /* renamed from: d */
    public static final int f3572d;

    /* renamed from: e */
    public static final byte[] f3573e = AnimatableValueParser.m511e("GIF87a");

    /* renamed from: f */
    public static final byte[] f3574f = AnimatableValueParser.m511e("GIF89a");

    /* renamed from: g */
    public static final byte[] f3575g;

    /* renamed from: h */
    public static final int f3576h;

    /* renamed from: i */
    public static final byte[] f3577i;

    /* renamed from: j */
    public static final int f3578j;

    /* renamed from: k */
    public static final byte[] f3579k;

    /* renamed from: l */
    public static final byte[][] f3580l;

    /* renamed from: m */
    public static final byte[] f3581m;

    /* renamed from: n */
    public static final byte[] f3582n;

    /* renamed from: o */
    public static final int f3583o;

    /* renamed from: p */
    public final int f3584p;

    static {
        byte[] bArr = {-1, -40, -1};
        f3569a = bArr;
        f3570b = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f3571c = bArr2;
        f3572d = bArr2.length;
        byte[] bArrM511e = AnimatableValueParser.m511e("BM");
        f3575g = bArrM511e;
        f3576h = bArrM511e.length;
        byte[] bArr3 = {0, 0, 1, 0};
        f3577i = bArr3;
        f3578j = bArr3.length;
        f3579k = AnimatableValueParser.m511e("ftyp");
        f3580l = new byte[][]{AnimatableValueParser.m511e("heic"), AnimatableValueParser.m511e("heix"), AnimatableValueParser.m511e("hevc"), AnimatableValueParser.m511e("hevx"), AnimatableValueParser.m511e("mif1"), AnimatableValueParser.m511e("msf1")};
        byte[] bArr4 = {73, 73, ExifInterface.START_CODE, 0};
        f3581m = bArr4;
        f3582n = new byte[]{77, 77, 0, ExifInterface.START_CODE};
        f3583o = bArr4.length;
    }

    public DefaultImageFormatChecker() {
        int[] iArr = {21, 20, f3570b, f3572d, 6, f3576h, f3578j, 12};
        AnimatableValueParser.m527i(Boolean.TRUE);
        int i = iArr[0];
        for (int i2 = 1; i2 < 8; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        this.f3584p = i;
    }

    /* renamed from: c */
    public static ImageFormat m1169c(byte[] bArr, int i) {
        boolean z2 = false;
        AnimatableValueParser.m527i(Boolean.valueOf(WebpSupportStatus.m1014b(bArr, 0, i)));
        if (WebpSupportStatus.m1016d(bArr, 12, WebpSupportStatus.f3143e)) {
            return DefaultImageFormats.f3590f;
        }
        if (WebpSupportStatus.m1016d(bArr, 12, WebpSupportStatus.f3144f)) {
            return DefaultImageFormats.f3591g;
        }
        if (!(i >= 21 && WebpSupportStatus.m1016d(bArr, 12, WebpSupportStatus.f3145g))) {
            return ImageFormat.f3597a;
        }
        byte[] bArr2 = WebpSupportStatus.f3145g;
        if (WebpSupportStatus.m1016d(bArr, 12, bArr2) && ((bArr[20] & 2) == 2)) {
            return DefaultImageFormats.f3594j;
        }
        boolean zM1016d = WebpSupportStatus.m1016d(bArr, 12, bArr2);
        boolean z3 = (bArr[20] & 16) == 16;
        if (zM1016d && z3) {
            z2 = true;
        }
        return z2 ? DefaultImageFormats.f3593i : DefaultImageFormats.f3592h;
    }

    @Override // p007b.p109f.p160i.ImageFormat.a
    /* renamed from: a */
    public int mo1170a() {
        return this.f3584p;
    }

    @Override // p007b.p109f.p160i.ImageFormat.a
    /* renamed from: b */
    public final ImageFormat mo1171b(byte[] bArr, int i) {
        boolean z2;
        boolean z3 = false;
        if (WebpSupportStatus.m1014b(bArr, 0, i)) {
            return m1169c(bArr, i);
        }
        byte[] bArr2 = f3569a;
        if (i >= bArr2.length && AnimatableValueParser.m442I0(bArr, bArr2, 0)) {
            return DefaultImageFormats.f3585a;
        }
        byte[] bArr3 = f3571c;
        if (i >= bArr3.length && AnimatableValueParser.m442I0(bArr, bArr3, 0)) {
            return DefaultImageFormats.f3586b;
        }
        if (i >= 6 && (AnimatableValueParser.m442I0(bArr, f3573e, 0) || AnimatableValueParser.m442I0(bArr, f3574f, 0))) {
            return DefaultImageFormats.f3587c;
        }
        byte[] bArr4 = f3575g;
        if (i < bArr4.length ? false : AnimatableValueParser.m442I0(bArr, bArr4, 0)) {
            return DefaultImageFormats.f3588d;
        }
        byte[] bArr5 = f3577i;
        if (i < bArr5.length ? false : AnimatableValueParser.m442I0(bArr, bArr5, 0)) {
            return DefaultImageFormats.f3589e;
        }
        if (i >= 12 && bArr[3] >= 8 && AnimatableValueParser.m442I0(bArr, f3579k, 4)) {
            for (byte[] bArr6 : f3580l) {
                if (AnimatableValueParser.m442I0(bArr, bArr6, 8)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (z2) {
            return DefaultImageFormats.f3595k;
        }
        if (i >= f3583o && (AnimatableValueParser.m442I0(bArr, f3581m, 0) || AnimatableValueParser.m442I0(bArr, f3582n, 0))) {
            z3 = true;
        }
        return z3 ? DefaultImageFormats.f3596l : ImageFormat.f3597a;
    }
}
