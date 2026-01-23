package p007b.p109f.p161j.p179n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.platform.PreverificationHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p125j.LimitedInputStream;
import p007b.p109f.p115d.p125j.TailAppendingInputStream;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p167b.SimpleBitmapReleaser;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p177l.BitmapPool;

/* JADX INFO: renamed from: b.f.j.n.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(11)
public abstract class DefaultDecoder implements PlatformDecoder {

    /* JADX INFO: renamed from: a */
    public static final byte[] f3982a = {-1, ExifInterface.MARKER_EOI};

    /* JADX INFO: renamed from: b */
    public final BitmapPool f3983b;

    /* JADX INFO: renamed from: c */
    public final PreverificationHelper f3984c;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> f3985d;

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.f3984c = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.f3983b = bitmapPool;
        this.f3985d = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.f3985d.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX INFO: renamed from: e */
    public static BitmapFactory.Options m1413e(EncodedImage2 encodedImage2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage2.f3898q;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage2.m1342e(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    @Override // p007b.p109f.p161j.p179n.PlatformDecoder
    /* JADX INFO: renamed from: a */
    public CloseableReference<Bitmap> mo1414a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options optionsM1413e = m1413e(encodedImage2, config);
        boolean z2 = optionsM1413e.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            InputStream inputStreamM1342e = encodedImage2.m1342e();
            Objects.requireNonNull(inputStreamM1342e);
            return m1416c(inputStreamM1342e, optionsM1413e, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z2) {
                return mo1414a(encodedImage2, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // p007b.p109f.p161j.p179n.PlatformDecoder
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableReference<Bitmap> mo1415b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        boolean z2;
        ImageFormat imageFormat = encodedImage2.f3893l;
        if ((imageFormat == DefaultImageFormats.f3585a || imageFormat == DefaultImageFormats.f3596l) && encodedImage2.f3892k == null) {
            Objects.requireNonNull(encodedImage2.f3891j);
            PooledByteBuffer pooledByteBufferM8642u = encodedImage2.f3891j.m8642u();
            z2 = pooledByteBufferM8642u.mo1395h(i + (-2)) == -1 && pooledByteBufferM8642u.mo1395h(i + (-1)) == -39;
        }
        BitmapFactory.Options optionsM1413e = m1413e(encodedImage2, config);
        InputStream inputStreamM1342e = encodedImage2.m1342e();
        Objects.requireNonNull(inputStreamM1342e);
        if (encodedImage2.m1344n() > i) {
            inputStreamM1342e = new LimitedInputStream(inputStreamM1342e, i);
        }
        if (!z2) {
            inputStreamM1342e = new TailAppendingInputStream(inputStreamM1342e, f3982a);
        }
        boolean z3 = optionsM1413e.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                return m1416c(inputStreamM1342e, optionsM1413e, rect, colorSpace);
            } finally {
                try {
                    inputStreamM1342e.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (RuntimeException e2) {
            if (!z3) {
                throw e2;
            }
            CloseableReference<Bitmap> closeableReferenceMo1415b = mo1415b(encodedImage2, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            try {
                inputStreamM1342e.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return closeableReferenceMo1415b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: all -> 0x00c8, RuntimeException -> 0x00ca, IllegalArgumentException -> 0x00d3, TryCatch #8 {IllegalArgumentException -> 0x00d3, RuntimeException -> 0x00ca, blocks: (B:29:0x006b, B:34:0x0082, B:49:0x00a5, B:41:0x0096, B:45:0x009e, B:46:0x00a1), top: B:80:0x006b, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[Catch: all -> 0x00c8, RuntimeException -> 0x00ca, IllegalArgumentException -> 0x00d3, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00d3, RuntimeException -> 0x00ca, blocks: (B:29:0x006b, B:34:0x0082, B:49:0x00a5, B:41:0x0096, B:45:0x009e, B:46:0x00a1), top: B:80:0x006b, outer: #5 }] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CloseableReference<Bitmap> m1416c(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap bitmapDecodeStream;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        PreverificationHelper preverificationHelper;
        int iWidth = options.outWidth;
        int iHeight = options.outHeight;
        if (rect != null) {
            iWidth = rect.width() / options.inSampleSize;
            iHeight = rect.height() / options.inSampleSize;
        }
        int i = Build.VERSION.SDK_INT;
        boolean z2 = i >= 26 && (preverificationHelper = this.f3984c) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder = null;
        if (rect == null && z2) {
            options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z2) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = this.f3983b.get(mo1412d(iWidth, iHeight, options));
            Objects.requireNonNull(bitmap, "BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        if (i >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        ByteBuffer byteBufferAcquire = this.f3985d.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                options.inTempStorage = byteBufferAcquire.array();
                if (rect == null || bitmap == null) {
                    bitmapDecodeStream = null;
                } else {
                    try {
                        bitmap.reconfigure(iWidth, iHeight, options.inPreferredConfig);
                        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                        try {
                            try {
                                bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                                bitmapRegionDecoderNewInstance.recycle();
                            } catch (IOException unused) {
                                FLog.m975c(DefaultDecoder.class, "Could not decode region %s, decoding full bitmap instead.", rect);
                                if (bitmapRegionDecoderNewInstance != null) {
                                    bitmapRegionDecoderNewInstance.recycle();
                                }
                                bitmapDecodeStream = null;
                                if (bitmapDecodeStream == null) {
                                }
                                this.f3985d.release(byteBufferAcquire);
                                if (bitmap != null) {
                                }
                                return CloseableReference.m8633D(bitmapDecodeStream, this.f3983b);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bitmapRegionDecoder = bitmapRegionDecoderNewInstance;
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        bitmapRegionDecoderNewInstance = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bitmapRegionDecoder != null) {
                        }
                        throw th;
                    }
                }
                if (bitmapDecodeStream == null) {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                }
                this.f3985d.release(byteBufferAcquire);
                if (bitmap != null || bitmap == bitmapDecodeStream) {
                    return CloseableReference.m8633D(bitmapDecodeStream, this.f3983b);
                }
                this.f3983b.release(bitmap);
                bitmapDecodeStream.recycle();
                throw new IllegalStateException();
            } catch (Throwable th3) {
                this.f3985d.release(byteBufferAcquire);
                throw th3;
            }
        } catch (IllegalArgumentException e) {
            if (bitmap != null) {
                this.f3983b.release(bitmap);
            }
            try {
                inputStream.reset();
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream);
                if (bitmapDecodeStream2 == null) {
                    throw e;
                }
                CloseableReference<Bitmap> closeableReferenceM8633D = CloseableReference.m8633D(bitmapDecodeStream2, SimpleBitmapReleaser.m1207a());
                this.f3985d.release(byteBufferAcquire);
                return closeableReferenceM8633D;
            } catch (IOException unused3) {
                throw e;
            }
        } catch (RuntimeException e2) {
            if (bitmap != null) {
                this.f3983b.release(bitmap);
            }
            throw e2;
        }
    }

    /* JADX INFO: renamed from: d */
    public abstract int mo1412d(int i, int i2, BitmapFactory.Options options);
}
