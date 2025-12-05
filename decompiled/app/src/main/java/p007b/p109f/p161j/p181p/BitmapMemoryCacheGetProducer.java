package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;

/* compiled from: BitmapMemoryCacheGetProducer.java */
/* renamed from: b.f.j.p.f, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        super(memoryCache, cacheKeyFactory, producer2);
    }

    @Override // p007b.p109f.p161j.p181p.BitmapMemoryCacheProducer
    /* renamed from: c */
    public String mo1471c() {
        return "pipe_ui";
    }

    @Override // p007b.p109f.p161j.p181p.BitmapMemoryCacheProducer
    /* renamed from: d */
    public String mo1472d() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // p007b.p109f.p161j.p181p.BitmapMemoryCacheProducer
    /* renamed from: e */
    public Consumer2<CloseableReference<CloseableImage>> mo1473e(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2) {
        return consumer2;
    }
}
