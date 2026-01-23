package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;
import p007b.p109f.p161j.p175j.QualityInfo;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.p.h, reason: use source file name */
/* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a */
    public final MemoryCache<CacheKey, CloseableImage> f4067a;

    /* JADX INFO: renamed from: b */
    public final CacheKeyFactory f4068b;

    /* JADX INFO: renamed from: c */
    public final Producer2<CloseableReference<CloseableImage>> f4069c;

    /* JADX INFO: renamed from: b.f.j.p.h$a */
    /* JADX INFO: compiled from: BitmapMemoryCacheProducer.java */
    public class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ CacheKey f4070c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ boolean f4071d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, CacheKey cacheKey, boolean z2) {
            super(consumer2);
            this.f4070c = cacheKey;
            this.f4071d = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0078 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[Catch: all -> 0x00a9, TRY_ENTER, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo1320i(Object obj, int i) {
            CloseableReference<CloseableImage> closeableReferenceMo1235a;
            CloseableReference<CloseableImage> closeableReference;
            CloseableReference<CloseableImage> closeableReference2 = (CloseableReference) obj;
            try {
                FrescoSystrace.m1527b();
                boolean zM1419e = BaseConsumer.m1419e(i);
                if (closeableReference2 == null) {
                    if (zM1419e) {
                        this.f4179b.mo1424b(null, i);
                    }
                } else if (closeableReference2.m8642u().mo1331d() || BaseConsumer.m1422m(i, 8)) {
                    this.f4179b.mo1424b(closeableReference2, i);
                } else if (zM1419e || (closeableReference = BitmapMemoryCacheProducer.this.f4067a.get(this.f4070c)) == null) {
                    closeableReferenceMo1235a = this.f4071d ? BitmapMemoryCacheProducer.this.f4067a.mo1235a(this.f4070c, closeableReference2) : null;
                    if (zM1419e) {
                        try {
                            this.f4179b.mo1423a(1.0f);
                        } catch (Throwable th) {
                            if (closeableReferenceMo1235a != null) {
                                closeableReferenceMo1235a.close();
                            }
                            throw th;
                        }
                    }
                    Consumer2<O> consumer2 = this.f4179b;
                    if (closeableReferenceMo1235a != null) {
                        closeableReference2 = closeableReferenceMo1235a;
                    }
                    consumer2.mo1424b(closeableReference2, i);
                    if (closeableReferenceMo1235a != null) {
                        closeableReferenceMo1235a.close();
                    }
                } else {
                    try {
                        QualityInfo qualityInfoMo1334b = closeableReference2.m8642u().mo1334b();
                        QualityInfo qualityInfoMo1334b2 = closeableReference.m8642u().mo1334b();
                        if (((ImmutableQualityInfo) qualityInfoMo1334b2).f3911d || ((ImmutableQualityInfo) qualityInfoMo1334b2).f3909b >= ((ImmutableQualityInfo) qualityInfoMo1334b).f3909b) {
                            this.f4179b.mo1424b(closeableReference, i);
                            closeableReference.close();
                        } else {
                            if (this.f4071d) {
                            }
                            if (zM1419e) {
                            }
                            Consumer2<O> consumer22 = this.f4179b;
                            if (closeableReferenceMo1235a != null) {
                            }
                            consumer22.mo1424b(closeableReference2, i);
                            if (closeableReferenceMo1235a != null) {
                            }
                        }
                    } finally {
                        closeableReference.close();
                    }
                }
            } finally {
                FrescoSystrace.m1527b();
            }
        }
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.f4067a = memoryCache;
        this.f4068b = cacheKeyFactory;
        this.f4069c = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
            producerListener2Mo1457o.mo1358e(producerContext, mo1472d());
            CacheKey cacheKeyM1229a = ((DefaultCacheKeyFactory) this.f4068b).m1229a(producerContext.mo1447e(), producerContext.mo1444b());
            CloseableReference<CloseableImage> closeableReference = producerContext.mo1447e().m8720b(1) ? this.f4067a.get(cacheKeyM1229a) : null;
            if (closeableReference != null) {
                producerContext.mo1452j(closeableReference.m8642u().mo1333a());
                boolean z2 = ((ImmutableQualityInfo) closeableReference.m8642u().mo1334b()).f3911d;
                if (z2) {
                    producerListener2Mo1457o.mo1363j(producerContext, mo1472d(), producerListener2Mo1457o.mo1360g(producerContext, mo1472d()) ? ImmutableMap.m967of("cached_value_found", "true") : null);
                    producerListener2Mo1457o.mo1356c(producerContext, mo1472d(), true);
                    producerContext.mo1451i("memory_bitmap", mo1471c());
                    consumer2.mo1423a(1.0f);
                }
                consumer2.mo1424b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (producerContext.mo1459q().m8722g() >= ImageRequest.EnumC10667c.BITMAP_MEMORY_CACHE.m8722g()) {
                producerListener2Mo1457o.mo1363j(producerContext, mo1472d(), producerListener2Mo1457o.mo1360g(producerContext, mo1472d()) ? ImmutableMap.m967of("cached_value_found", "false") : null);
                producerListener2Mo1457o.mo1356c(producerContext, mo1472d(), false);
                producerContext.mo1451i("memory_bitmap", mo1471c());
                consumer2.mo1424b(null, 1);
                return;
            }
            Consumer2<CloseableReference<CloseableImage>> consumer2Mo1473e = mo1473e(consumer2, cacheKeyM1229a, producerContext.mo1447e().m8720b(2));
            producerListener2Mo1457o.mo1363j(producerContext, mo1472d(), producerListener2Mo1457o.mo1360g(producerContext, mo1472d()) ? ImmutableMap.m967of("cached_value_found", "false") : null);
            FrescoSystrace.m1527b();
            this.f4069c.mo1417b(consumer2Mo1473e, producerContext);
            FrescoSystrace.m1527b();
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX INFO: renamed from: c */
    public String mo1471c() {
        return "pipe_bg";
    }

    /* JADX INFO: renamed from: d */
    public String mo1472d() {
        return "BitmapMemoryCacheProducer";
    }

    /* JADX INFO: renamed from: e */
    public Consumer2<CloseableReference<CloseableImage>> mo1473e(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2) {
        return new a(consumer2, cacheKey, z2);
    }
}
