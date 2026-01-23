package p007b.p109f.p161j.p175j;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p109f.p115d.p123h.HasBitmap;
import p007b.p109f.p115d.p123h.ResourceReleaser;
import p007b.p109f.p186k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.j.d, reason: use source file name */
/* JADX INFO: compiled from: CloseableStaticBitmap.java */
/* JADX INFO: loaded from: classes.dex */
public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {

    /* JADX INFO: renamed from: l */
    public CloseableReference<Bitmap> f3886l;

    /* JADX INFO: renamed from: m */
    public volatile Bitmap f3887m;

    /* JADX INFO: renamed from: n */
    public final QualityInfo f3888n;

    /* JADX INFO: renamed from: o */
    public final int f3889o;

    /* JADX INFO: renamed from: p */
    public final int f3890p;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this.f3887m = bitmap;
        Bitmap bitmap2 = this.f3887m;
        Objects.requireNonNull(resourceReleaser);
        this.f3886l = CloseableReference.m8633D(bitmap2, resourceReleaser);
        this.f3888n = qualityInfo;
        this.f3889o = i;
        this.f3890p = 0;
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    /* JADX INFO: renamed from: b */
    public QualityInfo mo1334b() {
        return this.f3888n;
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    /* JADX INFO: renamed from: c */
    public int mo1330c() {
        return BitmapUtil.m1541d(this.f3887m);
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<Bitmap> closeableReference;
        synchronized (this) {
            closeableReference = this.f3886l;
            this.f3886l = null;
            this.f3887m = null;
        }
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    @Override // p007b.p109f.p161j.p175j.CloseableBitmap
    /* JADX INFO: renamed from: f */
    public Bitmap mo1332f() {
        return this.f3887m;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int i;
        if (this.f3889o % 180 != 0 || (i = this.f3890p) == 5 || i == 7) {
            Bitmap bitmap = this.f3887m;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        Bitmap bitmap2 = this.f3887m;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int i;
        if (this.f3889o % 180 != 0 || (i = this.f3890p) == 5 || i == 7) {
            Bitmap bitmap = this.f3887m;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        Bitmap bitmap2 = this.f3887m;
        if (bitmap2 == null) {
            return 0;
        }
        return bitmap2.getWidth();
    }

    @Override // p007b.p109f.p161j.p175j.CloseableImage
    public synchronized boolean isClosed() {
        return this.f3886l == null;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        CloseableReference<Bitmap> closeableReferenceM8641f = closeableReference.m8641f();
        Objects.requireNonNull(closeableReferenceM8641f);
        this.f3886l = closeableReferenceM8641f;
        this.f3887m = closeableReferenceM8641f.m8642u();
        this.f3888n = qualityInfo;
        this.f3889o = i;
        this.f3890p = i2;
    }
}
