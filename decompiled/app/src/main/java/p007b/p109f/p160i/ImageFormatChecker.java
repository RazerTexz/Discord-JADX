package p007b.p109f.p160i;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p160i.ImageFormat;

/* JADX INFO: renamed from: b.f.i.d, reason: use source file name */
/* JADX INFO: compiled from: ImageFormatChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageFormatChecker {

    /* JADX INFO: renamed from: a */
    public static ImageFormatChecker f3599a;

    /* JADX INFO: renamed from: b */
    public int f3600b;

    /* JADX INFO: renamed from: c */
    public List<ImageFormat.a> f3601c;

    /* JADX INFO: renamed from: d */
    public final DefaultImageFormatChecker f3602d = new DefaultImageFormatChecker();

    public ImageFormatChecker() {
        m1176d();
    }

    /* JADX INFO: renamed from: a */
    public static ImageFormat m1173a(InputStream inputStream) throws IOException {
        int iM421B1;
        ImageFormatChecker imageFormatCheckerM1175c = m1175c();
        Objects.requireNonNull(imageFormatCheckerM1175c);
        Objects.requireNonNull(inputStream);
        int i = imageFormatCheckerM1175c.f3600b;
        byte[] bArr = new byte[i];
        AnimatableValueParser.m527i(Boolean.valueOf(i >= i));
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                iM421B1 = AnimatableValueParser.m421B1(inputStream, bArr, 0, i);
            } finally {
                inputStream.reset();
            }
        } else {
            iM421B1 = AnimatableValueParser.m421B1(inputStream, bArr, 0, i);
        }
        ImageFormat imageFormatMo1171b = imageFormatCheckerM1175c.f3602d.mo1171b(bArr, iM421B1);
        if (imageFormatMo1171b != ImageFormat.f3597a) {
            return imageFormatMo1171b;
        }
        List<ImageFormat.a> list = imageFormatCheckerM1175c.f3601c;
        if (list != null) {
            Iterator<ImageFormat.a> it = list.iterator();
            while (it.hasNext()) {
                ImageFormat imageFormatMo1171b2 = it.next().mo1171b(bArr, iM421B1);
                if (imageFormatMo1171b2 != null && imageFormatMo1171b2 != ImageFormat.f3597a) {
                    return imageFormatMo1171b2;
                }
            }
        }
        return ImageFormat.f3597a;
    }

    /* JADX INFO: renamed from: b */
    public static ImageFormat m1174b(InputStream inputStream) {
        try {
            return m1173a(inputStream);
        } catch (IOException e) {
            Throwables.m972a(e);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized ImageFormatChecker m1175c() {
        if (f3599a == null) {
            f3599a = new ImageFormatChecker();
        }
        return f3599a;
    }

    /* JADX INFO: renamed from: d */
    public final void m1176d() {
        this.f3600b = this.f3602d.f3584p;
        List<ImageFormat.a> list = this.f3601c;
        if (list != null) {
            Iterator<ImageFormat.a> it = list.iterator();
            while (it.hasNext()) {
                this.f3600b = Math.max(this.f3600b, it.next().mo1170a());
            }
        }
    }
}
