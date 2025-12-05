package p007b.p109f.p161j.p170e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p109f.p114c.CallerContextVerifier;
import p007b.p109f.p115d.p117b.SerialExecutorService;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p115d.p122g.NoOpMemoryTrimmableRegistry;
import p007b.p109f.p161j.p168c.BitmapMemoryCacheFactory;
import p007b.p109f.p161j.p168c.BitmapMemoryCacheTrimStrategy;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.CountingLruBitmapMemoryCacheFactory2;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultEncodedMemoryCacheParamsSupplier;
import p007b.p109f.p161j.p168c.ImageCacheStatsTracker;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p168c.NoOpImageCacheStatsTracker;
import p007b.p109f.p161j.p170e.ImagePipelineExperiments;
import p007b.p109f.p161j.p172g.NoOpCloseableReferenceLeakTracker;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p173h.ImageDecoderConfig;
import p007b.p109f.p161j.p173h.ProgressiveJpegConfig;
import p007b.p109f.p161j.p173h.SimpleProgressiveJpegConfig;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p177l.PoolConfig;
import p007b.p109f.p161j.p177l.PoolFactory;
import p007b.p109f.p161j.p181p.HttpUrlConnectionNetworkFetcher;
import p007b.p109f.p161j.p181p.NetworkFetcher2;
import p007b.p109f.p161j.p183r.FrescoSystrace;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;

/* compiled from: ImagePipelineConfig.java */
/* renamed from: b.f.j.e.j, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePipelineConfig2 implements ImagePipelineConfigInterface {

    /* renamed from: a */
    public static b f3745a = new b(null);

    /* renamed from: b */
    public final Supplier<MemoryCacheParams> f3746b;

    /* renamed from: c */
    public final MemoryCache.a f3747c;

    /* renamed from: d */
    public final CacheKeyFactory f3748d;

    /* renamed from: e */
    public final Context f3749e;

    /* renamed from: f */
    public final boolean f3750f;

    /* renamed from: g */
    public final FileCacheFactory f3751g;

    /* renamed from: h */
    public final Supplier<MemoryCacheParams> f3752h;

    /* renamed from: i */
    public final ExecutorSupplier f3753i;

    /* renamed from: j */
    public final ImageCacheStatsTracker f3754j;

    /* renamed from: k */
    public final Supplier<Boolean> f3755k;

    /* renamed from: l */
    public final DiskCacheConfig f3756l;

    /* renamed from: m */
    public final MemoryTrimmableRegistry f3757m;

    /* renamed from: n */
    public final NetworkFetcher2 f3758n;

    /* renamed from: o */
    public final int f3759o;

    /* renamed from: p */
    public final PoolFactory f3760p;

    /* renamed from: q */
    public final ProgressiveJpegConfig f3761q;

    /* renamed from: r */
    public final Set<RequestListener> f3762r;

    /* renamed from: s */
    public final Set<RequestListener2> f3763s;

    /* renamed from: t */
    public final boolean f3764t;

    /* renamed from: u */
    public final DiskCacheConfig f3765u;

    /* renamed from: v */
    public final ImagePipelineExperiments f3766v;

    /* renamed from: w */
    public final boolean f3767w;

    /* renamed from: x */
    public final NoOpCloseableReferenceLeakTracker f3768x;

    /* renamed from: y */
    public final BitmapMemoryCacheFactory f3769y;

    /* compiled from: ImagePipelineConfig.java */
    /* renamed from: b.f.j.e.j$a */
    public static class a {

        /* renamed from: a */
        public Supplier<MemoryCacheParams> f3770a;

        /* renamed from: b */
        public final Context f3771b;

        /* renamed from: d */
        public DiskCacheConfig f3773d;

        /* renamed from: e */
        public DiskCacheConfig f3774e;

        /* renamed from: c */
        public boolean f3772c = false;

        /* renamed from: f */
        public final ImagePipelineExperiments.b f3775f = new ImagePipelineExperiments.b(this);

        /* renamed from: g */
        public boolean f3776g = true;

        /* renamed from: h */
        public NoOpCloseableReferenceLeakTracker f3777h = new NoOpCloseableReferenceLeakTracker();

        public a(Context context, ImagePipelineConfig imagePipelineConfig) {
            Objects.requireNonNull(context);
            this.f3771b = context;
        }
    }

    /* compiled from: ImagePipelineConfig.java */
    /* renamed from: b.f.j.e.j$b */
    public static class b {
        public b(ImagePipelineConfig imagePipelineConfig) {
        }
    }

    public ImagePipelineConfig2(a aVar, ImagePipelineConfig imagePipelineConfig) {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        FrescoSystrace.m1527b();
        this.f3766v = new ImagePipelineExperiments(aVar.f3775f, null);
        Supplier<MemoryCacheParams> defaultBitmapMemoryCacheParamsSupplier = aVar.f3770a;
        if (defaultBitmapMemoryCacheParamsSupplier == null) {
            Object systemService = aVar.f3771b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Objects.requireNonNull(systemService);
            defaultBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
        }
        this.f3746b = defaultBitmapMemoryCacheParamsSupplier;
        this.f3747c = new BitmapMemoryCacheTrimStrategy();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        synchronized (DefaultCacheKeyFactory.class) {
            if (DefaultCacheKeyFactory.f3684a == null) {
                DefaultCacheKeyFactory.f3684a = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = DefaultCacheKeyFactory.f3684a;
        }
        this.f3748d = defaultCacheKeyFactory;
        Context context = aVar.f3771b;
        Objects.requireNonNull(context);
        this.f3749e = context;
        this.f3751g = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
        this.f3750f = aVar.f3772c;
        this.f3752h = new DefaultEncodedMemoryCacheParamsSupplier();
        synchronized (NoOpImageCacheStatsTracker.class) {
            if (NoOpImageCacheStatsTracker.f3703a == null) {
                NoOpImageCacheStatsTracker.f3703a = new NoOpImageCacheStatsTracker();
            }
            noOpImageCacheStatsTracker = NoOpImageCacheStatsTracker.f3703a;
        }
        this.f3754j = noOpImageCacheStatsTracker;
        this.f3755k = new ImagePipelineConfig(this);
        DiskCacheConfig diskCacheConfig = aVar.f3773d;
        if (diskCacheConfig == null) {
            Context context2 = aVar.f3771b;
            try {
                FrescoSystrace.m1527b();
                diskCacheConfig = new DiskCacheConfig(new DiskCacheConfig.C10634b(context2, null));
                FrescoSystrace.m1527b();
            } finally {
                FrescoSystrace.m1527b();
            }
        }
        this.f3756l = diskCacheConfig;
        this.f3757m = NoOpMemoryTrimmableRegistry.m990b();
        this.f3759o = 30000;
        FrescoSystrace.m1527b();
        this.f3758n = new HttpUrlConnectionNetworkFetcher(30000);
        FrescoSystrace.m1527b();
        PoolFactory poolFactory = new PoolFactory(new PoolConfig(new PoolConfig.b(null), null));
        this.f3760p = poolFactory;
        this.f3761q = new SimpleProgressiveJpegConfig();
        this.f3762r = new HashSet();
        this.f3763s = new HashSet();
        this.f3764t = true;
        DiskCacheConfig diskCacheConfig2 = aVar.f3774e;
        this.f3765u = diskCacheConfig2 != null ? diskCacheConfig2 : diskCacheConfig;
        this.f3753i = new DefaultExecutorSupplier(poolFactory.m1407b());
        this.f3767w = aVar.f3776g;
        this.f3768x = aVar.f3777h;
        this.f3769y = new CountingLruBitmapMemoryCacheFactory2();
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: A */
    public Supplier<MemoryCacheParams> mo1264A() {
        return this.f3746b;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: B */
    public ImageDecoder2 mo1265B() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: C */
    public Supplier<MemoryCacheParams> mo1266C() {
        return this.f3752h;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: D */
    public ExecutorSupplier mo1267D() {
        return this.f3753i;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: a */
    public PoolFactory mo1268a() {
        return this.f3760p;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: b */
    public Set<RequestListener2> mo1269b() {
        return Collections.unmodifiableSet(this.f3763s);
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: c */
    public int mo1270c() {
        return 0;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: d */
    public Supplier<Boolean> mo1271d() {
        return this.f3755k;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: e */
    public FileCacheFactory mo1272e() {
        return this.f3751g;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: f */
    public NoOpCloseableReferenceLeakTracker mo1273f() {
        return this.f3768x;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: g */
    public BitmapMemoryCacheFactory mo1274g() {
        return this.f3769y;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    public Context getContext() {
        return this.f3749e;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    public ImagePipelineExperiments getExperiments() {
        return this.f3766v;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: h */
    public NetworkFetcher2 mo1275h() {
        return this.f3758n;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: i */
    public MemoryCache<CacheKey, PooledByteBuffer> mo1276i() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: j */
    public DiskCacheConfig mo1277j() {
        return this.f3756l;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: k */
    public Set<RequestListener> mo1278k() {
        return Collections.unmodifiableSet(this.f3762r);
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: l */
    public CacheKeyFactory mo1279l() {
        return this.f3748d;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: m */
    public boolean mo1280m() {
        return this.f3764t;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: n */
    public MemoryCache.a mo1281n() {
        return this.f3747c;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: o */
    public ProgressiveJpegConfig mo1282o() {
        return this.f3761q;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: p */
    public DiskCacheConfig mo1283p() {
        return this.f3765u;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: q */
    public ImageCacheStatsTracker mo1284q() {
        return this.f3754j;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: r */
    public CountingMemoryCache.b<CacheKey> mo1285r() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: s */
    public boolean mo1286s() {
        return this.f3750f;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: t */
    public SerialExecutorService mo1287t() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: u */
    public Integer mo1288u() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: v */
    public ImageTranscoderFactory mo1289v() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: w */
    public MemoryTrimmableRegistry mo1290w() {
        return this.f3757m;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: x */
    public ImageDecoderConfig mo1291x() {
        return null;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: y */
    public boolean mo1292y() {
        return this.f3767w;
    }

    @Override // p007b.p109f.p161j.p170e.ImagePipelineConfigInterface
    /* renamed from: z */
    public CallerContextVerifier mo1293z() {
        return null;
    }
}
