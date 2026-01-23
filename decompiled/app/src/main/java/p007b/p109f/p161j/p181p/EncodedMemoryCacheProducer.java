package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.p.v, reason: use source file name */
/* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EncodedMemoryCacheProducer implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final MemoryCache<CacheKey, PooledByteBuffer> f4238a;

    /* JADX INFO: renamed from: b */
    public final CacheKeyFactory f4239b;

    /* JADX INFO: renamed from: c */
    public final Producer2<EncodedImage2> f4240c;

    /* JADX INFO: renamed from: b.f.j.p.v$a */
    /* JADX INFO: compiled from: EncodedMemoryCacheProducer.java */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public final MemoryCache<CacheKey, PooledByteBuffer> f4241c;

        /* JADX INFO: renamed from: d */
        public final CacheKey f4242d;

        /* JADX INFO: renamed from: e */
        public final boolean f4243e;

        /* JADX INFO: renamed from: f */
        public final boolean f4244f;

        public a(Consumer2<EncodedImage2> consumer2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z2, boolean z3) {
            super(consumer2);
            this.f4241c = memoryCache;
            this.f4242d = cacheKey;
            this.f4243e = z2;
            this.f4244f = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0065 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x0002, B:6:0x000d, B:8:0x0015, B:11:0x001f, B:19:0x0036, B:22:0x0043, B:24:0x0052, B:26:0x0057, B:27:0x005a, B:29:0x005c, B:30:0x005f, B:32:0x0061, B:33:0x0064, B:34:0x0065, B:35:0x006b, B:14:0x0026, B:16:0x002a, B:18:0x002e, B:23:0x0046, B:21:0x003b), top: B:43:0x0002, inners: #0, #2, #3 }] */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            try {
                FrescoSystrace.m1527b();
                if (BaseConsumer.m1420f(i) || encodedImage2 == null || BaseConsumer.m1421l(i, 10)) {
                    this.f4179b.mo1424b(encodedImage2, i);
                } else {
                    encodedImage2.m1347x();
                    if (encodedImage2.f3893l == ImageFormat.f3597a) {
                        this.f4179b.mo1424b(encodedImage2, i);
                    } else {
                        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage2.m1340c();
                        if (closeableReferenceM1340c != null) {
                            CloseableReference<PooledByteBuffer> closeableReferenceMo1235a = null;
                            try {
                                if (this.f4244f && this.f4243e) {
                                    closeableReferenceMo1235a = this.f4241c.mo1235a(this.f4242d, closeableReferenceM1340c);
                                }
                                if (closeableReferenceMo1235a != null) {
                                    try {
                                        EncodedImage2 encodedImage22 = new EncodedImage2(closeableReferenceMo1235a);
                                        encodedImage22.m1339b(encodedImage2);
                                        try {
                                            this.f4179b.mo1423a(1.0f);
                                            this.f4179b.mo1424b(encodedImage22, i);
                                            encodedImage22.close();
                                        } catch (Throwable th) {
                                            encodedImage22.close();
                                            throw th;
                                        }
                                    } finally {
                                        closeableReferenceMo1235a.close();
                                    }
                                } else {
                                    this.f4179b.mo1424b(encodedImage2, i);
                                }
                            } finally {
                                closeableReferenceM1340c.close();
                            }
                        }
                    }
                }
            } finally {
                FrescoSystrace.m1527b();
            }
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.f4238a = memoryCache;
        this.f4239b = cacheKeyFactory;
        this.f4240c = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
            producerListener2Mo1457o.mo1358e(producerContext, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyM1230b = ((DefaultCacheKeyFactory) this.f4239b).m1230b(producerContext.mo1447e(), producerContext.mo1444b());
            CloseableReference<PooledByteBuffer> closeableReference = producerContext.mo1447e().m8720b(4) ? this.f4238a.get(cacheKeyM1230b) : null;
            try {
                if (closeableReference != null) {
                    EncodedImage2 encodedImage2 = new EncodedImage2(closeableReference);
                    try {
                        producerListener2Mo1457o.mo1363j(producerContext, "EncodedMemoryCacheProducer", producerListener2Mo1457o.mo1360g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.m967of("cached_value_found", "true") : null);
                        producerListener2Mo1457o.mo1356c(producerContext, "EncodedMemoryCacheProducer", true);
                        producerContext.mo1456n("memory_encoded");
                        consumer2.mo1423a(1.0f);
                        consumer2.mo1424b(encodedImage2, 1);
                        closeableReference.close();
                        return;
                    } finally {
                        encodedImage2.close();
                    }
                }
                if (producerContext.mo1459q().m8722g() >= ImageRequest.EnumC10667c.ENCODED_MEMORY_CACHE.m8722g()) {
                    producerListener2Mo1457o.mo1363j(producerContext, "EncodedMemoryCacheProducer", producerListener2Mo1457o.mo1360g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.m967of("cached_value_found", "false") : null);
                    producerListener2Mo1457o.mo1356c(producerContext, "EncodedMemoryCacheProducer", false);
                    producerContext.mo1451i("memory_encoded", "nil-result");
                    consumer2.mo1424b(null, 1);
                    return;
                }
                a aVar = new a(consumer2, this.f4238a, cacheKeyM1230b, producerContext.mo1447e().m8720b(8), producerContext.mo1449g().getExperiments().f3782e);
                producerListener2Mo1457o.mo1363j(producerContext, "EncodedMemoryCacheProducer", producerListener2Mo1457o.mo1360g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.m967of("cached_value_found", "false") : null);
                this.f4240c.mo1417b(aVar, producerContext);
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            } finally {
                Class<CloseableReference> cls2 = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
