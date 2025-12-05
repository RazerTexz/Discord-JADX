package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p177l.BitmapCounter;
import p007b.p109f.p161j.p177l.BitmapCounterProvider;
import p007b.p109f.p161j.p178m.ImagePipelineNativeLoader;
import p007b.p109f.p161j.p179n.PlatformDecoder;
import p007b.p109f.p186k.BitmapUtil;
import p007b.p109f.p190m.DoNotOptimize;
import p007b.p109f.p190m.p191n.NativeLoader;

@DoNotStrip
/* loaded from: classes3.dex */
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {

    /* renamed from: a */
    public static final byte[] f19566a;

    /* renamed from: b */
    public final BitmapCounter f19567b;

    @DoNotOptimize
    public static class OreoUtils {
        private OreoUtils() {
        }
    }

    static {
        List<String> list = ImagePipelineNativeLoader.f3980a;
        NativeLoader.m1589c("imagepipeline");
        f19566a = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DalvikPurgeableDecoder() {
        if (BitmapCounterProvider.f3925c == null) {
            synchronized (BitmapCounterProvider.class) {
                if (BitmapCounterProvider.f3925c == null) {
                    BitmapCounterProvider.f3925c = new BitmapCounter(BitmapCounterProvider.f3924b, BitmapCounterProvider.f3923a);
                }
            }
        }
        this.f19567b = BitmapCounterProvider.f3925c;
    }

    @VisibleForTesting
    /* renamed from: e */
    public static boolean m8709e(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        return i >= 2 && pooledByteBufferM8642u.mo1395h(i + (-2)) == -1 && pooledByteBufferM8642u.mo1395h(i - 1) == -39;
    }

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // p007b.p109f.p161j.p179n.PlatformDecoder
    /* renamed from: a */
    public CloseableReference<Bitmap> mo1414a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        int i = encodedImage2.f3898q;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage2.m1340c();
        Objects.requireNonNull(closeableReferenceM1340c);
        try {
            return m8712f(mo8710c(closeableReferenceM1340c, options));
        } finally {
            closeableReferenceM1340c.close();
        }
    }

    @Override // p007b.p109f.p161j.p179n.PlatformDecoder
    /* renamed from: b */
    public CloseableReference<Bitmap> mo1415b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        int i2 = encodedImage2.f3898q;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage2.m1340c();
        Objects.requireNonNull(closeableReferenceM1340c);
        try {
            return m8712f(mo8711d(closeableReferenceM1340c, i, options));
        } finally {
            closeableReferenceM1340c.close();
        }
    }

    /* renamed from: c */
    public abstract Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options);

    /* renamed from: d */
    public abstract Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options);

    /* renamed from: f */
    public CloseableReference<Bitmap> m8712f(Bitmap bitmap) throws Throwable {
        boolean z2;
        int i;
        long j;
        int i2;
        Objects.requireNonNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            BitmapCounter bitmapCounter = this.f19567b;
            synchronized (bitmapCounter) {
                int iM1541d = BitmapUtil.m1541d(bitmap);
                int i3 = bitmapCounter.f3917a;
                if (i3 < bitmapCounter.f3919c) {
                    long j2 = bitmapCounter.f3918b + iM1541d;
                    if (j2 > bitmapCounter.f3920d) {
                        z2 = false;
                    } else {
                        bitmapCounter.f3917a = i3 + 1;
                        bitmapCounter.f3918b = j2;
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return CloseableReference.m8633D(bitmap, this.f19567b.f3921e);
            }
            int iM1541d2 = BitmapUtil.m1541d(bitmap);
            bitmap.recycle();
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(iM1541d2);
            BitmapCounter bitmapCounter2 = this.f19567b;
            synchronized (bitmapCounter2) {
                i = bitmapCounter2.f3917a;
            }
            objArr[1] = Integer.valueOf(i);
            BitmapCounter bitmapCounter3 = this.f19567b;
            synchronized (bitmapCounter3) {
                j = bitmapCounter3.f3918b;
            }
            objArr[2] = Long.valueOf(j);
            BitmapCounter bitmapCounter4 = this.f19567b;
            synchronized (bitmapCounter4) {
                i2 = bitmapCounter4.f3919c;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.f19567b.m1372b());
            throw new TooManyBitmapsException(String.format(locale, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", objArr));
        } catch (Exception e) {
            bitmap.recycle();
            Throwables.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
