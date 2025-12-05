package p007b.p109f.p161j.p175j;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResult;

/* compiled from: CloseableAnimatedImage.java */
/* renamed from: b.f.j.j.a, reason: use source file name */
/* loaded from: classes.dex */
public class CloseableAnimatedImage extends CloseableImage {

    /* renamed from: l */
    public AnimatedImageResult f3882l;

    /* renamed from: m */
    public boolean f3883m = true;

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this.f3882l = animatedImageResult;
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    /* renamed from: c */
    public synchronized int mo1330c() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.f3882l;
        return animatedImageResult == null ? 0 : animatedImageResult.f3609a.mo1184j();
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.f3882l;
            if (animatedImageResult == null) {
                return;
            }
            this.f3882l = null;
            synchronized (animatedImageResult) {
                CloseableReference<Bitmap> closeableReference = animatedImageResult.f3610b;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                animatedImageResult.f3610b = null;
                CloseableReference.m8639t(animatedImageResult.f3611c);
                animatedImageResult.f3611c = null;
            }
        }
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    /* renamed from: d */
    public boolean mo1331d() {
        return this.f3883m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.f3882l;
        return animatedImageResult == null ? 0 : animatedImageResult.f3609a.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        AnimatedImageResult animatedImageResult;
        animatedImageResult = this.f3882l;
        return animatedImageResult == null ? 0 : animatedImageResult.f3609a.getWidth();
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    public synchronized boolean isClosed() {
        return this.f3882l == null;
    }
}
