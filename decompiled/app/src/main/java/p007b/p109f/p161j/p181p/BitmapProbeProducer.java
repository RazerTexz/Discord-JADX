package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;
import p007b.p109f.p161j.p168c.BoundedLinkedHashSet;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: BitmapProbeProducer.java */
/* renamed from: b.f.j.p.j, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapProbeProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* renamed from: a */
    public final MemoryCache<CacheKey, PooledByteBuffer> f4089a;

    /* renamed from: b */
    public final BufferedDiskCache2 f4090b;

    /* renamed from: c */
    public final BufferedDiskCache2 f4091c;

    /* renamed from: d */
    public final CacheKeyFactory f4092d;

    /* renamed from: e */
    public final Producer2<CloseableReference<CloseableImage>> f4093e;

    /* renamed from: f */
    public final BoundedLinkedHashSet<CacheKey> f4094f;

    /* renamed from: g */
    public final BoundedLinkedHashSet<CacheKey> f4095g;

    /* compiled from: BitmapProbeProducer.java */
    /* renamed from: b.f.j.p.j$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c */
        public final ProducerContext f4096c;

        /* renamed from: d */
        public final MemoryCache<CacheKey, PooledByteBuffer> f4097d;

        /* renamed from: e */
        public final BufferedDiskCache2 f4098e;

        /* renamed from: f */
        public final BufferedDiskCache2 f4099f;

        /* renamed from: g */
        public final CacheKeyFactory f4100g;

        /* renamed from: h */
        public final BoundedLinkedHashSet<CacheKey> f4101h;

        /* renamed from: i */
        public final BoundedLinkedHashSet<CacheKey> f4102i;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.f4096c = producerContext;
            this.f4097d = memoryCache;
            this.f4098e = bufferedDiskCache2;
            this.f4099f = bufferedDiskCache22;
            this.f4100g = cacheKeyFactory;
            this.f4101h = boundedLinkedHashSet;
            this.f4102i = boundedLinkedHashSet2;
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            try {
                FrescoSystrace.m1527b();
                if (BaseConsumer.m1420f(i) || closeableReference == null || BaseConsumer.m1421l(i, 8)) {
                    this.f4179b.mo1424b(closeableReference, i);
                } else {
                    ImageRequest imageRequestMo1447e = this.f4096c.mo1447e();
                    ((DefaultCacheKeyFactory) this.f4100g).m1230b(imageRequestMo1447e, this.f4096c.mo1444b());
                    String str = (String) this.f4096c.mo1454l("origin");
                    if (str != null && str.equals("memory_bitmap")) {
                        Objects.requireNonNull(this.f4096c.mo1449g().getExperiments());
                        Objects.requireNonNull(this.f4096c.mo1449g().getExperiments());
                    }
                    this.f4179b.mo1424b(closeableReference, i);
                }
            } finally {
                FrescoSystrace.m1527b();
            }
        }
    }

    public BitmapProbeProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.f4089a = memoryCache;
        this.f4090b = bufferedDiskCache2;
        this.f4091c = bufferedDiskCache22;
        this.f4092d = cacheKeyFactory;
        this.f4094f = boundedLinkedHashSet;
        this.f4095g = boundedLinkedHashSet2;
        this.f4093e = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
            producerListener2Mo1457o.mo1358e(producerContext, "BitmapProbeProducer");
            a aVar = new a(consumer2, producerContext, this.f4089a, this.f4090b, this.f4091c, this.f4092d, this.f4094f, this.f4095g);
            producerListener2Mo1457o.mo1363j(producerContext, "BitmapProbeProducer", null);
            FrescoSystrace.m1527b();
            this.f4093e.mo1417b(aVar, producerContext);
            FrescoSystrace.m1527b();
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
