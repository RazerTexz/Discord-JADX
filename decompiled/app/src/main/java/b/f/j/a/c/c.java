package b.f.j.a.c;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import b.f.d.d.i;
import b.f.j.c.m;
import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;

/* compiled from: AnimatedFrameCache.java */
/* loaded from: classes2.dex */
public class c {
    public final CacheKey a;

    /* renamed from: b, reason: collision with root package name */
    public final m<CacheKey, b.f.j.j.c> f549b;
    public final LinkedHashSet<CacheKey> d = new LinkedHashSet<>();
    public final m.b<CacheKey> c = new a();

    /* compiled from: AnimatedFrameCache.java */
    public class a implements m.b<CacheKey> {
        public a() {
        }

        public void a(Object obj, boolean z2) {
            CacheKey cacheKey = (CacheKey) obj;
            c cVar = c.this;
            synchronized (cVar) {
                if (z2) {
                    cVar.d.add(cacheKey);
                } else {
                    cVar.d.remove(cacheKey);
                }
            }
        }
    }

    /* compiled from: AnimatedFrameCache.java */
    @VisibleForTesting
    public static class b implements CacheKey {
        public final CacheKey a;

        /* renamed from: b, reason: collision with root package name */
        public final int f550b;

        public b(CacheKey cacheKey, int i) {
            this.a = cacheKey;
            this.f550b = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean a() {
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String b() {
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
            return this.f550b == bVar.f550b && this.a.equals(bVar.a);
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.a.hashCode() * PointerIconCompat.TYPE_ALL_SCROLL) + this.f550b;
        }

        public String toString() {
            i iVarH2 = b.c.a.a0.d.h2(this);
            iVarH2.c("imageCacheKey", this.a);
            iVarH2.a("frameIndex", this.f550b);
            return iVarH2.toString();
        }
    }

    public c(CacheKey cacheKey, m<CacheKey, b.f.j.j.c> mVar) {
        this.a = cacheKey;
        this.f549b = mVar;
    }
}
