package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.c.t, reason: use source file name */
/* JADX INFO: compiled from: InstrumentedMemoryCacheBitmapMemoryCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class InstrumentedMemoryCacheBitmapMemoryCacheFactory implements MemoryCacheTracker<CacheKey> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ImageCacheStatsTracker f3689a;

    public InstrumentedMemoryCacheBitmapMemoryCacheFactory(ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f3689a = imageCacheStatsTracker;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: a */
    public void mo1232a(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3689a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: b */
    public void mo1233b(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3689a);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCacheTracker
    /* JADX INFO: renamed from: c */
    public void mo1234c(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3689a);
    }
}
