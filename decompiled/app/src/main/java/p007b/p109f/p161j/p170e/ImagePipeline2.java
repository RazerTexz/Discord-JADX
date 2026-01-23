package p007b.p109f.p161j.p170e;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p114c.CallerContextVerifier;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p171f.CloseableProducerToDataSourceAdapter;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p176k.ForwardingRequestListener;
import p007b.p109f.p161j.p176k.ForwardingRequestListener2;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p181p.InternalRequestListener;
import p007b.p109f.p161j.p181p.Producer2;
import p007b.p109f.p161j.p181p.SettableProducerContext;
import p007b.p109f.p161j.p181p.ThreadHandoffProducerQueue;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.e.h, reason: use source file name */
/* JADX INFO: compiled from: ImagePipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipeline2 {

    /* JADX INFO: renamed from: a */
    public final ProducerSequenceFactory f3733a;

    /* JADX INFO: renamed from: b */
    public final RequestListener f3734b;

    /* JADX INFO: renamed from: c */
    public final RequestListener2 f3735c;

    /* JADX INFO: renamed from: d */
    public final Supplier<Boolean> f3736d;

    /* JADX INFO: renamed from: e */
    public final MemoryCache<CacheKey, CloseableImage> f3737e;

    /* JADX INFO: renamed from: f */
    public final MemoryCache<CacheKey, PooledByteBuffer> f3738f;

    /* JADX INFO: renamed from: g */
    public final CacheKeyFactory f3739g;

    /* JADX INFO: renamed from: h */
    public final Supplier<Boolean> f3740h;

    /* JADX INFO: renamed from: i */
    public AtomicLong f3741i = new AtomicLong();

    /* JADX INFO: renamed from: j */
    public final Supplier<Boolean> f3742j = null;

    /* JADX INFO: renamed from: k */
    public final CallerContextVerifier f3743k;

    /* JADX INFO: renamed from: l */
    public final ImagePipelineConfigInterface f3744l;

    static {
        new CancellationException("Prefetching is not enabled");
    }

    public ImagePipeline2(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Set<RequestListener2> set2, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, CallerContextVerifier callerContextVerifier, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.f3733a = producerSequenceFactory;
        this.f3734b = new ForwardingRequestListener(set);
        this.f3735c = new ForwardingRequestListener2(set2);
        this.f3736d = supplier;
        this.f3737e = memoryCache;
        this.f3738f = memoryCache2;
        this.f3739g = cacheKeyFactory;
        this.f3740h = supplier2;
        this.f3743k = callerContextVerifier;
        this.f3744l = imagePipelineConfigInterface;
    }

    /* JADX INFO: renamed from: a */
    public DataSource<CloseableReference<CloseableImage>> m1262a(ImageRequest imageRequest, Object obj, ImageRequest.EnumC10667c enumC10667c, RequestListener requestListener, String str) {
        try {
            return m1263b(this.f3733a.m1307c(imageRequest), imageRequest, enumC10667c, obj, requestListener, str);
        } catch (Exception e) {
            return AnimatableValueParser.m457N0(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final <T> DataSource<CloseableReference<T>> m1263b(Producer2<CloseableReference<T>> producer2, ImageRequest imageRequest, ImageRequest.EnumC10667c enumC10667c, Object obj, RequestListener requestListener, String str) {
        ForwardingRequestListener forwardingRequestListener;
        RequestListener forwardingRequestListener2;
        FrescoSystrace.m1527b();
        if (requestListener == null) {
            RequestListener requestListener2 = imageRequest.f19602t;
            if (requestListener2 == null) {
                forwardingRequestListener2 = this.f3734b;
            } else {
                forwardingRequestListener = new ForwardingRequestListener(this.f3734b, requestListener2);
                forwardingRequestListener2 = forwardingRequestListener;
            }
        } else {
            RequestListener requestListener3 = imageRequest.f19602t;
            if (requestListener3 == null) {
                forwardingRequestListener2 = new ForwardingRequestListener(this.f3734b, requestListener);
            } else {
                forwardingRequestListener = new ForwardingRequestListener(this.f3734b, requestListener, requestListener3);
                forwardingRequestListener2 = forwardingRequestListener;
            }
        }
        InternalRequestListener internalRequestListener = new InternalRequestListener(forwardingRequestListener2, this.f3735c);
        CallerContextVerifier callerContextVerifier = this.f3743k;
        if (callerContextVerifier != null) {
            callerContextVerifier.m963a(obj, false);
        }
        try {
            SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, String.valueOf(this.f3741i.getAndIncrement()), str, internalRequestListener, obj, ImageRequest.EnumC10667c.m8721f(imageRequest.f19596n, enumC10667c), false, imageRequest.f19588f || !UriUtil.m1009e(imageRequest.f19585c), imageRequest.f19595m, this.f3744l);
            FrescoSystrace.m1527b();
            CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer2, settableProducerContext, internalRequestListener);
            FrescoSystrace.m1527b();
            return closeableProducerToDataSourceAdapter;
        } catch (Exception e) {
            return AnimatableValueParser.m457N0(e);
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
