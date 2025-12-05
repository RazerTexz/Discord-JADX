package p007b.p109f.p115d.p128m;

import java.io.UnsupportedEncodingException;

/* compiled from: WebpSupportStatus.java */
/* renamed from: b.f.d.m.c, reason: use source file name */
/* loaded from: classes.dex */
public class WebpSupportStatus {

    /* renamed from: a */
    public static WebpBitmapFactory f3139a = null;

    /* renamed from: b */
    public static boolean f3140b = false;

    /* renamed from: c */
    public static final byte[] f3141c = m1013a("RIFF");

    /* renamed from: d */
    public static final byte[] f3142d = m1013a("WEBP");

    /* renamed from: e */
    public static final byte[] f3143e = m1013a("VP8 ");

    /* renamed from: f */
    public static final byte[] f3144f = m1013a("VP8L");

    /* renamed from: g */
    public static final byte[] f3145g = m1013a("VP8X");

    /* renamed from: a */
    public static byte[] m1013a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    /* renamed from: b */
    public static boolean m1014b(byte[] bArr, int i, int i2) {
        return i2 >= 20 && m1016d(bArr, i, f3141c) && m1016d(bArr, i + 8, f3142d);
    }

    /* renamed from: c */
    public static WebpBitmapFactory m1015c() {
        if (f3140b) {
            return f3139a;
        }
        WebpBitmapFactory webpBitmapFactory = null;
        try {
            webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        f3140b = true;
        return webpBitmapFactory;
    }

    /* renamed from: d */
    public static boolean m1016d(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
