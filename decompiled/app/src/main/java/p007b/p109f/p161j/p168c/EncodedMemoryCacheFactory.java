package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* compiled from: EncodedMemoryCacheFactory.java */
/* renamed from: b.f.j.c.q, reason: use source file name */
/* loaded from: classes.dex */
public final class EncodedMemoryCacheFactory implements MemoryCacheTracker<CacheKey> {

    /* renamed from: a */
    public final /* synthetic */ ImageCacheStatsTracker f3686a;

    public EncodedMemoryCacheFactory(ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f3686a = imageCacheStatsTracker;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* renamed from: a */
    public void mo1232a(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* renamed from: b */
    public void mo1233b(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* renamed from: c */
    public void mo1234c(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }
}
