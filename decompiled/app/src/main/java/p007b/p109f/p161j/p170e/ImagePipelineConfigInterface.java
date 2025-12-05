package p007b.p109f.p161j.p170e;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Set;
import p007b.p109f.p114c.CallerContextVerifier;
import p007b.p109f.p115d.p117b.SerialExecutorService;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p161j.p168c.BitmapMemoryCacheFactory;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p168c.ImageCacheStatsTracker;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p172g.NoOpCloseableReferenceLeakTracker;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p173h.ImageDecoderConfig;
import p007b.p109f.p161j.p173h.ProgressiveJpegConfig;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p177l.PoolFactory;
import p007b.p109f.p161j.p181p.NetworkFetcher2;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;

/* compiled from: ImagePipelineConfigInterface.java */
/* renamed from: b.f.j.e.k, reason: use source file name */
/* loaded from: classes.dex */
public interface ImagePipelineConfigInterface {
    /* renamed from: A */
    Supplier<MemoryCacheParams> mo1264A();

    /* renamed from: B */
    ImageDecoder2 mo1265B();

    /* renamed from: C */
    Supplier<MemoryCacheParams> mo1266C();

    /* renamed from: D */
    ExecutorSupplier mo1267D();

    /* renamed from: a */
    PoolFactory mo1268a();

    /* renamed from: b */
    Set<RequestListener2> mo1269b();

    /* renamed from: c */
    int mo1270c();

    /* renamed from: d */
    Supplier<Boolean> mo1271d();

    /* renamed from: e */
    FileCacheFactory mo1272e();

    /* renamed from: f */
    NoOpCloseableReferenceLeakTracker mo1273f();

    /* renamed from: g */
    BitmapMemoryCacheFactory mo1274g();

    Context getContext();

    ImagePipelineExperiments getExperiments();

    /* renamed from: h */
    NetworkFetcher2 mo1275h();

    /* renamed from: i */
    MemoryCache<CacheKey, PooledByteBuffer> mo1276i();

    /* renamed from: j */
    DiskCacheConfig mo1277j();

    /* renamed from: k */
    Set<RequestListener> mo1278k();

    /* renamed from: l */
    CacheKeyFactory mo1279l();

    /* renamed from: m */
    boolean mo1280m();

    /* renamed from: n */
    MemoryCache.a mo1281n();

    /* renamed from: o */
    ProgressiveJpegConfig mo1282o();

    /* renamed from: p */
    DiskCacheConfig mo1283p();

    /* renamed from: q */
    ImageCacheStatsTracker mo1284q();

    /* renamed from: r */
    CountingMemoryCache.b<CacheKey> mo1285r();

    /* renamed from: s */
    boolean mo1286s();

    /* renamed from: t */
    SerialExecutorService mo1287t();

    /* renamed from: u */
    Integer mo1288u();

    /* renamed from: v */
    ImageTranscoderFactory mo1289v();

    /* renamed from: w */
    MemoryTrimmableRegistry mo1290w();

    /* renamed from: x */
    ImageDecoderConfig mo1291x();

    /* renamed from: y */
    boolean mo1292y();

    /* renamed from: z */
    CallerContextVerifier mo1293z();
}
