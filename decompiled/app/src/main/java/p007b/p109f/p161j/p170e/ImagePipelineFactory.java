package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Objects;
import java.util.Set;
import p007b.p109f.p111b.p113b.FileCache;
import p007b.p109f.p115d.p117b.SerialExecutorService;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p162a.p164b.AnimatedFactory;
import p007b.p109f.p161j.p162a.p164b.AnimatedFactoryProvider;
import p007b.p109f.p161j.p167b.ArtBitmapFactory;
import p007b.p109f.p161j.p168c.BitmapMemoryCacheFactory;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.CountingLruBitmapMemoryCacheFactory;
import p007b.p109f.p161j.p168c.CountingLruBitmapMemoryCacheFactory2;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p168c.EncodedCountingMemoryCacheFactory;
import p007b.p109f.p161j.p168c.EncodedMemoryCacheFactory;
import p007b.p109f.p161j.p168c.ImageCacheStatsTracker;
import p007b.p109f.p161j.p168c.InstrumentedMemoryCache;
import p007b.p109f.p161j.p168c.InstrumentedMemoryCacheBitmapMemoryCacheFactory;
import p007b.p109f.p161j.p168c.LruCountingMemoryCache2;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p168c.NativeMemoryCacheTrimStrategy;
import p007b.p109f.p161j.p168c.NoOpImageCacheStatsTracker;
import p007b.p109f.p161j.p170e.ImagePipelineExperiments;
import p007b.p109f.p161j.p173h.DefaultImageDecoder;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p173h.ProgressiveJpegConfig;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p177l.PoolFactory;
import p007b.p109f.p161j.p179n.ArtDecoder;
import p007b.p109f.p161j.p179n.OreoDecoder;
import p007b.p109f.p161j.p179n.PlatformDecoder;
import p007b.p109f.p161j.p181p.NetworkFetcher2;
import p007b.p109f.p161j.p181p.ThreadHandoffProducerQueue;
import p007b.p109f.p161j.p181p.ThreadHandoffProducerQueueImpl;
import p007b.p109f.p161j.p183r.FrescoSystrace;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;
import p007b.p109f.p161j.p184s.MultiImageTranscoderFactory;

/* compiled from: ImagePipelineFactory.java */
/* renamed from: b.f.j.e.m, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePipelineFactory {

    /* renamed from: a */
    public static ImagePipelineFactory f3788a;

    /* renamed from: b */
    public final ThreadHandoffProducerQueue f3789b;

    /* renamed from: c */
    public final ImagePipelineConfigInterface f3790c;

    /* renamed from: d */
    public final CloseableReferenceFactory f3791d;

    /* renamed from: e */
    public CountingMemoryCache<CacheKey, CloseableImage> f3792e;

    /* renamed from: f */
    public InstrumentedMemoryCache<CacheKey, CloseableImage> f3793f;

    /* renamed from: g */
    public CountingMemoryCache<CacheKey, PooledByteBuffer> f3794g;

    /* renamed from: h */
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> f3795h;

    /* renamed from: i */
    public BufferedDiskCache2 f3796i;

    /* renamed from: j */
    public FileCache f3797j;

    /* renamed from: k */
    public ImageDecoder2 f3798k;

    /* renamed from: l */
    public ImagePipeline2 f3799l;

    /* renamed from: m */
    public ImageTranscoderFactory f3800m;

    /* renamed from: n */
    public ProducerFactory f3801n;

    /* renamed from: o */
    public ProducerSequenceFactory f3802o;

    /* renamed from: p */
    public BufferedDiskCache2 f3803p;

    /* renamed from: q */
    public FileCache f3804q;

    /* renamed from: r */
    public PlatformBitmapFactory f3805r;

    /* renamed from: s */
    public PlatformDecoder f3806s;

    /* renamed from: t */
    public AnimatedFactory f3807t;

    public ImagePipelineFactory(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        FrescoSystrace.m1527b();
        Objects.requireNonNull(imagePipelineConfigInterface);
        this.f3790c = imagePipelineConfigInterface;
        Objects.requireNonNull(imagePipelineConfigInterface.getExperiments());
        this.f3789b = new ThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.mo1267D().mo1255b());
        Objects.requireNonNull(imagePipelineConfigInterface.getExperiments());
        CloseableReference.f19439k = 0;
        this.f3791d = new CloseableReferenceFactory(imagePipelineConfigInterface.mo1273f());
        FrescoSystrace.m1527b();
    }

    /* renamed from: j */
    public static synchronized void m1294j(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        if (f3788a != null) {
            FLog.m983k(ImagePipelineFactory.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
        }
        f3788a = new ImagePipelineFactory(imagePipelineConfigInterface);
    }

    /* renamed from: a */
    public final ImagePipeline2 m1295a() throws SecurityException {
        ImageDecoder2 imageDecoder2Mo1191c;
        ImageDecoder2 imageDecoder2Mo1190b;
        if (Build.VERSION.SDK_INT >= 24) {
            Objects.requireNonNull(this.f3790c.getExperiments());
        }
        if (this.f3802o == null) {
            ContentResolver contentResolver = this.f3790c.getContext().getApplicationContext().getContentResolver();
            if (this.f3801n == null) {
                ImagePipelineExperiments.d dVar = this.f3790c.getExperiments().f3779b;
                Context context = this.f3790c.getContext();
                ByteArrayPool byteArrayPoolM1410e = this.f3790c.mo1268a().m1410e();
                if (this.f3798k == null) {
                    if (this.f3790c.mo1265B() != null) {
                        this.f3798k = this.f3790c.mo1265B();
                    } else {
                        AnimatedFactory animatedFactoryM1296b = m1296b();
                        if (animatedFactoryM1296b != null) {
                            imageDecoder2Mo1190b = animatedFactoryM1296b.mo1190b();
                            imageDecoder2Mo1191c = animatedFactoryM1296b.mo1191c();
                        } else {
                            imageDecoder2Mo1191c = null;
                            imageDecoder2Mo1190b = null;
                        }
                        if (this.f3790c.mo1291x() != null) {
                            m1302h();
                            Objects.requireNonNull(this.f3790c.mo1291x());
                            throw null;
                        }
                        this.f3798k = new DefaultImageDecoder(imageDecoder2Mo1190b, imageDecoder2Mo1191c, m1302h());
                    }
                }
                ImageDecoder2 imageDecoder2 = this.f3798k;
                ProgressiveJpegConfig progressiveJpegConfigMo1282o = this.f3790c.mo1282o();
                boolean zMo1286s = this.f3790c.mo1286s();
                boolean zMo1280m = this.f3790c.mo1280m();
                Objects.requireNonNull(this.f3790c.getExperiments());
                ExecutorSupplier executorSupplierMo1267D = this.f3790c.mo1267D();
                PooledByteBufferFactory pooledByteBufferFactoryM1408c = this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c());
                this.f3790c.mo1268a().m1409d();
                InstrumentedMemoryCache<CacheKey, CloseableImage> instrumentedMemoryCacheM1298d = m1298d();
                InstrumentedMemoryCache<CacheKey, PooledByteBuffer> instrumentedMemoryCacheM1299e = m1299e();
                BufferedDiskCache2 bufferedDiskCache2M1300f = m1300f();
                BufferedDiskCache2 bufferedDiskCache2M1303i = m1303i();
                CacheKeyFactory cacheKeyFactoryMo1279l = this.f3790c.mo1279l();
                PlatformBitmapFactory platformBitmapFactoryM1301g = m1301g();
                Objects.requireNonNull(this.f3790c.getExperiments());
                Objects.requireNonNull(this.f3790c.getExperiments());
                Objects.requireNonNull(this.f3790c.getExperiments());
                int i = this.f3790c.getExperiments().f3778a;
                CloseableReferenceFactory closeableReferenceFactory = this.f3791d;
                Objects.requireNonNull(this.f3790c.getExperiments());
                int i2 = this.f3790c.getExperiments().f3784g;
                Objects.requireNonNull((ImagePipelineExperiments.c) dVar);
                this.f3801n = new ProducerFactory(context, byteArrayPoolM1410e, imageDecoder2, progressiveJpegConfigMo1282o, zMo1286s, zMo1280m, false, executorSupplierMo1267D, pooledByteBufferFactoryM1408c, instrumentedMemoryCacheM1298d, instrumentedMemoryCacheM1299e, bufferedDiskCache2M1300f, bufferedDiskCache2M1303i, cacheKeyFactoryMo1279l, platformBitmapFactoryM1301g, 0, 0, false, i, closeableReferenceFactory, false, i2);
            }
            ProducerFactory producerFactory = this.f3801n;
            NetworkFetcher2 networkFetcher2Mo1275h = this.f3790c.mo1275h();
            boolean zMo1280m2 = this.f3790c.mo1280m();
            Objects.requireNonNull(this.f3790c.getExperiments());
            ThreadHandoffProducerQueue threadHandoffProducerQueue = this.f3789b;
            boolean zMo1286s2 = this.f3790c.mo1286s();
            Objects.requireNonNull(this.f3790c.getExperiments());
            boolean zMo1292y = this.f3790c.mo1292y();
            if (this.f3800m == null) {
                if (this.f3790c.mo1289v() == null && this.f3790c.mo1288u() == null) {
                    Objects.requireNonNull(this.f3790c.getExperiments());
                }
                int i3 = this.f3790c.getExperiments().f3778a;
                Objects.requireNonNull(this.f3790c.getExperiments());
                this.f3800m = new MultiImageTranscoderFactory(i3, false, this.f3790c.mo1289v(), this.f3790c.mo1288u(), this.f3790c.getExperiments().f3783f);
            }
            ImageTranscoderFactory imageTranscoderFactory = this.f3800m;
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            this.f3802o = new ProducerSequenceFactory(contentResolver, producerFactory, networkFetcher2Mo1275h, zMo1280m2, false, threadHandoffProducerQueue, zMo1286s2, false, false, zMo1292y, imageTranscoderFactory, false, false, false);
        }
        ProducerSequenceFactory producerSequenceFactory = this.f3802o;
        Set<RequestListener> setMo1278k = this.f3790c.mo1278k();
        Set<RequestListener2> setMo1269b = this.f3790c.mo1269b();
        Supplier<Boolean> supplierMo1271d = this.f3790c.mo1271d();
        InstrumentedMemoryCache<CacheKey, CloseableImage> instrumentedMemoryCacheM1298d2 = m1298d();
        InstrumentedMemoryCache<CacheKey, PooledByteBuffer> instrumentedMemoryCacheM1299e2 = m1299e();
        BufferedDiskCache2 bufferedDiskCache2M1300f2 = m1300f();
        BufferedDiskCache2 bufferedDiskCache2M1303i2 = m1303i();
        CacheKeyFactory cacheKeyFactoryMo1279l2 = this.f3790c.mo1279l();
        ThreadHandoffProducerQueue threadHandoffProducerQueue2 = this.f3789b;
        Supplier<Boolean> supplier = this.f3790c.getExperiments().f3781d;
        Objects.requireNonNull(this.f3790c.getExperiments());
        return new ImagePipeline2(producerSequenceFactory, setMo1278k, setMo1269b, supplierMo1271d, instrumentedMemoryCacheM1298d2, instrumentedMemoryCacheM1299e2, bufferedDiskCache2M1300f2, bufferedDiskCache2M1303i2, cacheKeyFactoryMo1279l2, threadHandoffProducerQueue2, supplier, null, this.f3790c.mo1293z(), this.f3790c);
    }

    /* renamed from: b */
    public final AnimatedFactory m1296b() {
        if (this.f3807t == null) {
            PlatformBitmapFactory platformBitmapFactoryM1301g = m1301g();
            ExecutorSupplier executorSupplierMo1267D = this.f3790c.mo1267D();
            CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCacheM1297c = m1297c();
            boolean z2 = this.f3790c.getExperiments().f3780c;
            SerialExecutorService serialExecutorServiceMo1287t = this.f3790c.mo1287t();
            if (!AnimatedFactoryProvider.f3618a) {
                try {
                    AnimatedFactoryProvider.f3619b = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE, SerialExecutorService.class).newInstance(platformBitmapFactoryM1301g, executorSupplierMo1267D, countingMemoryCacheM1297c, Boolean.valueOf(z2), serialExecutorServiceMo1287t);
                } catch (Throwable unused) {
                }
                if (AnimatedFactoryProvider.f3619b != null) {
                    AnimatedFactoryProvider.f3618a = true;
                }
            }
            this.f3807t = AnimatedFactoryProvider.f3619b;
        }
        return this.f3807t;
    }

    /* renamed from: c */
    public CountingMemoryCache<CacheKey, CloseableImage> m1297c() {
        if (this.f3792e == null) {
            BitmapMemoryCacheFactory bitmapMemoryCacheFactoryMo1274g = this.f3790c.mo1274g();
            Supplier<MemoryCacheParams> supplierMo1264A = this.f3790c.mo1264A();
            MemoryTrimmableRegistry memoryTrimmableRegistryMo1290w = this.f3790c.mo1290w();
            MemoryCache.a aVarMo1281n = this.f3790c.mo1281n();
            Objects.requireNonNull(this.f3790c.getExperiments());
            Objects.requireNonNull(this.f3790c.getExperiments());
            CountingMemoryCache.b<CacheKey> bVarMo1285r = this.f3790c.mo1285r();
            CountingLruBitmapMemoryCacheFactory2 countingLruBitmapMemoryCacheFactory2 = (CountingLruBitmapMemoryCacheFactory2) bitmapMemoryCacheFactoryMo1274g;
            Objects.requireNonNull(countingLruBitmapMemoryCacheFactory2);
            LruCountingMemoryCache2 lruCountingMemoryCache2 = new LruCountingMemoryCache2(new CountingLruBitmapMemoryCacheFactory(countingLruBitmapMemoryCacheFactory2), aVarMo1281n, supplierMo1264A, bVarMo1285r, false, false);
            memoryTrimmableRegistryMo1290w.mo989a(lruCountingMemoryCache2);
            this.f3792e = lruCountingMemoryCache2;
        }
        return this.f3792e;
    }

    /* renamed from: d */
    public InstrumentedMemoryCache<CacheKey, CloseableImage> m1298d() {
        if (this.f3793f == null) {
            CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCacheM1297c = m1297c();
            ImageCacheStatsTracker imageCacheStatsTrackerMo1284q = this.f3790c.mo1284q();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) imageCacheStatsTrackerMo1284q);
            this.f3793f = new InstrumentedMemoryCache<>(countingMemoryCacheM1297c, new InstrumentedMemoryCacheBitmapMemoryCacheFactory(imageCacheStatsTrackerMo1284q));
        }
        return this.f3793f;
    }

    /* renamed from: e */
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> m1299e() {
        MemoryCache<CacheKey, PooledByteBuffer> memoryCacheMo1276i;
        if (this.f3795h == null) {
            if (this.f3790c.mo1276i() != null) {
                memoryCacheMo1276i = this.f3790c.mo1276i();
            } else {
                if (this.f3794g == null) {
                    Supplier<MemoryCacheParams> supplierMo1266C = this.f3790c.mo1266C();
                    MemoryTrimmableRegistry memoryTrimmableRegistryMo1290w = this.f3790c.mo1290w();
                    LruCountingMemoryCache2 lruCountingMemoryCache2 = new LruCountingMemoryCache2(new EncodedCountingMemoryCacheFactory(), new NativeMemoryCacheTrimStrategy(), supplierMo1266C, null, false, false);
                    memoryTrimmableRegistryMo1290w.mo989a(lruCountingMemoryCache2);
                    this.f3794g = lruCountingMemoryCache2;
                }
                memoryCacheMo1276i = this.f3794g;
            }
            ImageCacheStatsTracker imageCacheStatsTrackerMo1284q = this.f3790c.mo1284q();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) imageCacheStatsTrackerMo1284q);
            this.f3795h = new InstrumentedMemoryCache<>(memoryCacheMo1276i, new EncodedMemoryCacheFactory(imageCacheStatsTrackerMo1284q));
        }
        return this.f3795h;
    }

    /* renamed from: f */
    public BufferedDiskCache2 m1300f() {
        if (this.f3796i == null) {
            if (this.f3797j == null) {
                this.f3797j = ((DiskStorageCacheFactory) this.f3790c.mo1272e()).m1261a(this.f3790c.mo1277j());
            }
            this.f3796i = new BufferedDiskCache2(this.f3797j, this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c()), this.f3790c.mo1268a().m1409d(), this.f3790c.mo1267D().mo1258e(), this.f3790c.mo1267D().mo1257d(), this.f3790c.mo1284q());
        }
        return this.f3796i;
    }

    /* renamed from: g */
    public PlatformBitmapFactory m1301g() {
        if (this.f3805r == null) {
            PoolFactory poolFactoryMo1268a = this.f3790c.mo1268a();
            m1302h();
            this.f3805r = new ArtBitmapFactory(poolFactoryMo1268a.m1406a(), this.f3791d);
        }
        return this.f3805r;
    }

    /* renamed from: h */
    public PlatformDecoder m1302h() {
        PlatformDecoder artDecoder;
        if (this.f3806s == null) {
            PoolFactory poolFactoryMo1268a = this.f3790c.mo1268a();
            Objects.requireNonNull(this.f3790c.getExperiments());
            if (Build.VERSION.SDK_INT >= 26) {
                int iM1407b = poolFactoryMo1268a.m1407b();
                artDecoder = new OreoDecoder(poolFactoryMo1268a.m1406a(), iM1407b, new Pools.SynchronizedPool(iM1407b));
            } else {
                int iM1407b2 = poolFactoryMo1268a.m1407b();
                artDecoder = new ArtDecoder(poolFactoryMo1268a.m1406a(), iM1407b2, new Pools.SynchronizedPool(iM1407b2));
            }
            this.f3806s = artDecoder;
        }
        return this.f3806s;
    }

    /* renamed from: i */
    public final BufferedDiskCache2 m1303i() {
        if (this.f3803p == null) {
            if (this.f3804q == null) {
                this.f3804q = ((DiskStorageCacheFactory) this.f3790c.mo1272e()).m1261a(this.f3790c.mo1283p());
            }
            this.f3803p = new BufferedDiskCache2(this.f3804q, this.f3790c.mo1268a().m1408c(this.f3790c.mo1270c()), this.f3790c.mo1268a().m1409d(), this.f3790c.mo1267D().mo1258e(), this.f3790c.mo1267D().mo1257d(), this.f3790c.mo1284q());
        }
        return this.f3803p;
    }
}
