package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.c.q, reason: use source file name */
/* JADX INFO: compiled from: EncodedMemoryCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class EncodedMemoryCacheFactory implements MemoryCacheTracker<CacheKey> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ImageCacheStatsTracker f3686a;

    public EncodedMemoryCacheFactory(ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f3686a = imageCacheStatsTracker;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: a */
    public void mo1232a(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: b */
    public void mo1233b(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: c */
    public void mo1234c(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3686a);
    }
}
