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

/* JADX INFO: renamed from: b.f.j.e.k, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineConfigInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface ImagePipelineConfigInterface {
    /* JADX INFO: renamed from: A */
    Supplier<MemoryCacheParams> mo1264A();

    /* JADX INFO: renamed from: B */
    ImageDecoder2 mo1265B();

    /* JADX INFO: renamed from: C */
    Supplier<MemoryCacheParams> mo1266C();

    /* JADX INFO: renamed from: D */
    ExecutorSupplier mo1267D();

    /* JADX INFO: renamed from: a */
    PoolFactory mo1268a();

    /* JADX INFO: renamed from: b */
    Set<RequestListener2> mo1269b();

    /* JADX INFO: renamed from: c */
    int mo1270c();

    /* JADX INFO: renamed from: d */
    Supplier<Boolean> mo1271d();

    /* JADX INFO: renamed from: e */
    FileCacheFactory mo1272e();

    /* JADX INFO: renamed from: f */
    NoOpCloseableReferenceLeakTracker mo1273f();

    /* JADX INFO: renamed from: g */
    BitmapMemoryCacheFactory mo1274g();

    Context getContext();

    ImagePipelineExperiments getExperiments();

    /* JADX INFO: renamed from: h */
    NetworkFetcher2 mo1275h();

    /* JADX INFO: renamed from: i */
    MemoryCache<CacheKey, PooledByteBuffer> mo1276i();

    /* JADX INFO: renamed from: j */
    DiskCacheConfig mo1277j();

    /* JADX INFO: renamed from: k */
    Set<RequestListener> mo1278k();

    /* JADX INFO: renamed from: l */
    CacheKeyFactory mo1279l();

    /* JADX INFO: renamed from: m */
    boolean mo1280m();

    /* JADX INFO: renamed from: n */
    MemoryCache.a mo1281n();

    /* JADX INFO: renamed from: o */
    ProgressiveJpegConfig mo1282o();

    /* JADX INFO: renamed from: p */
    DiskCacheConfig mo1283p();

    /* JADX INFO: renamed from: q */
    ImageCacheStatsTracker mo1284q();

    /* JADX INFO: renamed from: r */
    CountingMemoryCache.b<CacheKey> mo1285r();

    /* JADX INFO: renamed from: s */
    boolean mo1286s();

    /* JADX INFO: renamed from: t */
    SerialExecutorService mo1287t();

    /* JADX INFO: renamed from: u */
    Integer mo1288u();

    /* JADX INFO: renamed from: v */
    ImageTranscoderFactory mo1289v();

    /* JADX INFO: renamed from: w */
    MemoryTrimmableRegistry mo1290w();

    /* JADX INFO: renamed from: x */
    ImageDecoderConfig mo1291x();

    /* JADX INFO: renamed from: y */
    boolean mo1292y();

    /* JADX INFO: renamed from: z */
    CallerContextVerifier mo1293z();
}
