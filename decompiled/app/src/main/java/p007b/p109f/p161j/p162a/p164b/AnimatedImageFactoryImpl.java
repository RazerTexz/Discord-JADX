package p007b.p109f.p161j.p162a.p164b;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import p007b.p109f.p161j.p162a.p163a.AnimatedImage;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResultBuilder;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendProvider;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p175j.CloseableAnimatedImage;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.j.a.b.e, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {

    /* JADX INFO: renamed from: a */
    public static AnimatedImageDecoder f3620a;

    /* JADX INFO: renamed from: b */
    public static AnimatedImageDecoder f3621b;

    /* JADX INFO: renamed from: c */
    public final AnimatedDrawableBackendProvider f3622c;

    /* JADX INFO: renamed from: d */
    public final PlatformBitmapFactory f3623d;

    static {
        AnimatedImageDecoder animatedImageDecoder;
        AnimatedImageDecoder animatedImageDecoder2 = null;
        try {
            animatedImageDecoder = (AnimatedImageDecoder) Class.forName("com.facebook.animated.gif.GifImage").newInstance();
        } catch (Throwable unused) {
            animatedImageDecoder = null;
        }
        f3620a = animatedImageDecoder;
        try {
            animatedImageDecoder2 = (AnimatedImageDecoder) Class.forName("com.facebook.animated.webp.WebPImage").newInstance();
        } catch (Throwable unused2) {
        }
        f3621b = animatedImageDecoder2;
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.f3622c = animatedDrawableBackendProvider;
        this.f3623d = platformBitmapFactory;
    }

    /* JADX INFO: renamed from: a */
    public final CloseableImage m1194a(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        try {
            Objects.requireNonNull(imageDecodeOptions);
            AnimatedImageResultBuilder animatedImageResultBuilder = new AnimatedImageResultBuilder(animatedImage);
            animatedImageResultBuilder.f3614b = CloseableReference.m8636n(null);
            animatedImageResultBuilder.f3616d = 0;
            animatedImageResultBuilder.f3615c = CloseableReference.m8637q(null);
            animatedImageResultBuilder.f3617e = null;
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(animatedImageResultBuilder.m1188a());
            CloseableReference.m8639t(null);
            return closeableAnimatedImage;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            CloseableReference.m8639t(null);
            throw th;
        }
    }
}
