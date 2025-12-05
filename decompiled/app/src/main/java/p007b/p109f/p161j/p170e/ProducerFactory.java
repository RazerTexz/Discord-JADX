package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p168c.BoundedLinkedHashSet;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p173h.ProgressiveJpegConfig;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p181p.Producer2;
import p007b.p109f.p161j.p181p.ResizeAndRotateProducer;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;

/* compiled from: ProducerFactory.java */
/* renamed from: b.f.j.e.p, reason: use source file name */
/* loaded from: classes.dex */
public class ProducerFactory {

    /* renamed from: a */
    public ContentResolver f3815a;

    /* renamed from: b */
    public Resources f3816b;

    /* renamed from: c */
    public AssetManager f3817c;

    /* renamed from: d */
    public final ByteArrayPool f3818d;

    /* renamed from: e */
    public final ImageDecoder2 f3819e;

    /* renamed from: f */
    public final ProgressiveJpegConfig f3820f;

    /* renamed from: g */
    public final boolean f3821g;

    /* renamed from: h */
    public final boolean f3822h;

    /* renamed from: i */
    public final boolean f3823i;

    /* renamed from: j */
    public final ExecutorSupplier f3824j;

    /* renamed from: k */
    public final PooledByteBufferFactory f3825k;

    /* renamed from: l */
    public final BufferedDiskCache2 f3826l;

    /* renamed from: m */
    public final BufferedDiskCache2 f3827m;

    /* renamed from: n */
    public final MemoryCache<CacheKey, PooledByteBuffer> f3828n;

    /* renamed from: o */
    public final MemoryCache<CacheKey, CloseableImage> f3829o;

    /* renamed from: p */
    public final CacheKeyFactory f3830p;

    /* renamed from: q */
    public final BoundedLinkedHashSet<CacheKey> f3831q;

    /* renamed from: r */
    public final BoundedLinkedHashSet<CacheKey> f3832r;

    /* renamed from: s */
    public final PlatformBitmapFactory f3833s;

    /* renamed from: t */
    public final int f3834t;

    /* renamed from: u */
    public final int f3835u;

    /* renamed from: v */
    public boolean f3836v;

    /* renamed from: w */
    public final CloseableReferenceFactory f3837w;

    /* renamed from: x */
    public final int f3838x;

    /* renamed from: y */
    public final boolean f3839y;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder2 imageDecoder2, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z5, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z6, int i4) {
        this.f3815a = context.getApplicationContext().getContentResolver();
        this.f3816b = context.getApplicationContext().getResources();
        this.f3817c = context.getApplicationContext().getAssets();
        this.f3818d = byteArrayPool;
        this.f3819e = imageDecoder2;
        this.f3820f = progressiveJpegConfig;
        this.f3821g = z2;
        this.f3822h = z3;
        this.f3823i = z4;
        this.f3824j = executorSupplier;
        this.f3825k = pooledByteBufferFactory;
        this.f3829o = memoryCache;
        this.f3828n = memoryCache2;
        this.f3826l = bufferedDiskCache2;
        this.f3827m = bufferedDiskCache22;
        this.f3830p = cacheKeyFactory;
        this.f3833s = platformBitmapFactory;
        this.f3831q = new BoundedLinkedHashSet<>(i4);
        this.f3832r = new BoundedLinkedHashSet<>(i4);
        this.f3834t = i;
        this.f3835u = i2;
        this.f3836v = z5;
        this.f3838x = i3;
        this.f3837w = closeableReferenceFactory;
        this.f3839y = z6;
    }

    /* renamed from: a */
    public ResizeAndRotateProducer m1304a(Producer2<EncodedImage2> producer2, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
        return new ResizeAndRotateProducer(this.f3824j.mo1256c(), this.f3825k, producer2, z2, imageTranscoderFactory);
    }
}
