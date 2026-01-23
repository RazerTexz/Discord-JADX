package p007b.p109f.p161j.p162a.p165c;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.j.a.c.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatedFrameCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedFrameCache {

    /* JADX INFO: renamed from: a */
    public final CacheKey f3634a;

    /* JADX INFO: renamed from: b */
    public final CountingMemoryCache<CacheKey, CloseableImage> f3635b;

    /* JADX INFO: renamed from: d */
    public final LinkedHashSet<CacheKey> f3637d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c */
    public final CountingMemoryCache.b<CacheKey> f3636c = new a();

    /* JADX INFO: renamed from: b.f.j.a.c.c$a */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    public class a implements CountingMemoryCache.b<CacheKey> {
        public a() {
        }

        /* JADX INFO: renamed from: a */
        public void m1201a(Object obj, boolean z2) {
            CacheKey cacheKey = (CacheKey) obj;
            AnimatedFrameCache animatedFrameCache = AnimatedFrameCache.this;
            synchronized (animatedFrameCache) {
                if (z2) {
                    animatedFrameCache.f3637d.add(cacheKey);
                } else {
                    animatedFrameCache.f3637d.remove(cacheKey);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.a.c.c$b */
    /* JADX INFO: compiled from: AnimatedFrameCache.java */
    @VisibleForTesting
    public static class b implements CacheKey {

        /* JADX INFO: renamed from: a */
        public final CacheKey f3639a;

        /* JADX INFO: renamed from: b */
        public final int f3640b;

        public b(CacheKey cacheKey, int i) {
            this.f3639a = cacheKey;
            this.f3640b = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        /* JADX INFO: renamed from: a */
        public boolean mo929a() {
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        /* JADX INFO: renamed from: b */
        public String mo930b() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3640b == bVar.f3640b && this.f3639a.equals(bVar.f3639a);
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.f3639a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f3640b;
        }

        public String toString() {
            Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
            objects2M526h2.m971c("imageCacheKey", this.f3639a);
            objects2M526h2.m969a("frameIndex", this.f3640b);
            return objects2M526h2.toString();
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.f3634a = cacheKey;
        this.f3635b = countingMemoryCache;
    }
}
