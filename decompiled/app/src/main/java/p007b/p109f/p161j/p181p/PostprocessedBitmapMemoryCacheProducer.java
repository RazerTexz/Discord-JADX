package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p182q.Postprocessor;
import p007b.p109f.p161j.p182q.RepeatedPostprocessor;

/* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* renamed from: b.f.j.p.s0, reason: use source file name */
/* loaded from: classes3.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* renamed from: a */
    public final MemoryCache<CacheKey, CloseableImage> f4206a;

    /* renamed from: b */
    public final CacheKeyFactory f4207b;

    /* renamed from: c */
    public final Producer2<CloseableReference<CloseableImage>> f4208c;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    /* renamed from: b.f.j.p.s0$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c */
        public final CacheKey f4209c;

        /* renamed from: d */
        public final boolean f4210d;

        /* renamed from: e */
        public final MemoryCache<CacheKey, CloseableImage> f4211e;

        /* renamed from: f */
        public final boolean f4212f;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z3) {
            super(consumer2);
            this.f4209c = cacheKey;
            this.f4210d = z2;
            this.f4211e = memoryCache;
            this.f4212f = z3;
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference<CloseableImage> closeableReference = (CloseableReference) obj;
            if (closeableReference == null) {
                if (BaseConsumer.m1419e(i)) {
                    this.f4179b.mo1424b(null, i);
                }
            } else if (!BaseConsumer.m1420f(i) || this.f4210d) {
                CloseableReference<CloseableImage> closeableReferenceMo1235a = this.f4212f ? this.f4211e.mo1235a(this.f4209c, closeableReference) : null;
                try {
                    this.f4179b.mo1423a(1.0f);
                    Consumer2<O> consumer2 = this.f4179b;
                    if (closeableReferenceMo1235a != null) {
                        closeableReference = closeableReferenceMo1235a;
                    }
                    consumer2.mo1424b(closeableReference, i);
                } finally {
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    if (closeableReferenceMo1235a != null) {
                        closeableReferenceMo1235a.close();
                    }
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.f4206a = memoryCache;
        this.f4207b = cacheKeyFactory;
        this.f4208c = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        Object objMo1444b = producerContext.mo1444b();
        Postprocessor postprocessor = imageRequestMo1447e.f19601s;
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.f4208c.mo1417b(consumer2, producerContext);
            return;
        }
        producerListener2Mo1457o.mo1358e(producerContext, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey cacheKeyM1231c = ((DefaultCacheKeyFactory) this.f4207b).m1231c(imageRequestMo1447e, objMo1444b);
        CloseableReference<CloseableImage> closeableReference = producerContext.mo1447e().m8720b(1) ? this.f4206a.get(cacheKeyM1231c) : null;
        if (closeableReference == null) {
            a aVar = new a(consumer2, cacheKeyM1231c, postprocessor instanceof RepeatedPostprocessor, this.f4206a, producerContext.mo1447e().m8720b(2));
            producerListener2Mo1457o.mo1363j(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2Mo1457o.mo1360g(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.m967of("cached_value_found", "false") : null);
            this.f4208c.mo1417b(aVar, producerContext);
        } else {
            producerListener2Mo1457o.mo1363j(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2Mo1457o.mo1360g(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.m967of("cached_value_found", "true") : null);
            producerListener2Mo1457o.mo1356c(producerContext, "PostprocessedBitmapMemoryCacheProducer", true);
            producerContext.mo1451i("memory_bitmap", "postprocessed");
            consumer2.mo1423a(1.0f);
            consumer2.mo1424b(closeableReference, 1);
            closeableReference.close();
        }
    }
}
