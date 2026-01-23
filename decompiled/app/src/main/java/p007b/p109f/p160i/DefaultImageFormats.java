package p007b.p109f.p160i;

import com.discord.utilities.icon.IconUtils;

/* JADX INFO: renamed from: b.f.i.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultImageFormats.java */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultImageFormats {

    /* JADX INFO: renamed from: a */
    public static final ImageFormat f3585a = new ImageFormat("JPEG", "jpeg");

    /* JADX INFO: renamed from: b */
    public static final ImageFormat f3586b = new ImageFormat("PNG", "png");

    /* JADX INFO: renamed from: c */
    public static final ImageFormat f3587c = new ImageFormat("GIF", IconUtils.ANIMATED_IMAGE_EXTENSION);

    /* JADX INFO: renamed from: d */
    public static final ImageFormat f3588d = new ImageFormat("BMP", "bmp");

    /* JADX INFO: renamed from: e */
    public static final ImageFormat f3589e = new ImageFormat("ICO", "ico");

    /* JADX INFO: renamed from: f */
    public static final ImageFormat f3590f = new ImageFormat("WEBP_SIMPLE", "webp");

    /* JADX INFO: renamed from: g */
    public static final ImageFormat f3591g = new ImageFormat("WEBP_LOSSLESS", "webp");

    /* JADX INFO: renamed from: h */
    public static final ImageFormat f3592h = new ImageFormat("WEBP_EXTENDED", "webp");

    /* JADX INFO: renamed from: i */
    public static final ImageFormat f3593i = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");

    /* JADX INFO: renamed from: j */
    public static final ImageFormat f3594j = new ImageFormat("WEBP_ANIMATED", "webp");

    /* JADX INFO: renamed from: k */
    public static final ImageFormat f3595k = new ImageFormat("HEIF", "heif");

    /* JADX INFO: renamed from: l */
    public static final ImageFormat f3596l = new ImageFormat("DNG", "dng");

    /* JADX INFO: renamed from: a */
    public static boolean m1172a(ImageFormat imageFormat) {
        return imageFormat == f3590f || imageFormat == f3591g || imageFormat == f3592h || imageFormat == f3593i;
    }
}
