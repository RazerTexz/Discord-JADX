package p007b.p225i.p226a.p242c.p257e3.p258b0;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.o, reason: use source file name */
/* JADX INFO: compiled from: LeastRecentlyUsedCacheEvictor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* JADX INFO: renamed from: a */
    public final TreeSet<CacheSpan> f6501a = new TreeSet<>(C2683b.f6437j);

    /* JADX INFO: renamed from: b */
    public long f6502b;

    public LeastRecentlyUsedCacheEvictor(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CacheEvictor
    /* JADX INFO: renamed from: a */
    public void mo2785a(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            m2821f(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: b */
    public void mo2818b(Cache cache, CacheSpan cacheSpan) {
        this.f6501a.remove(cacheSpan);
        this.f6502b -= cacheSpan.f6467l;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: c */
    public void mo2819c(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        this.f6501a.remove(cacheSpan);
        this.f6502b -= cacheSpan.f6467l;
        mo2820d(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: d */
    public void mo2820d(Cache cache, CacheSpan cacheSpan) {
        this.f6501a.add(cacheSpan);
        this.f6502b += cacheSpan.f6467l;
        m2821f(cache, 0L);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CacheEvictor
    /* JADX INFO: renamed from: e */
    public void mo2786e() {
    }

    /* JADX INFO: renamed from: f */
    public final void m2821f(Cache cache, long j) {
        while (this.f6502b + j > 104857600 && !this.f6501a.isEmpty()) {
            cache.mo2829d(this.f6501a.first());
        }
    }
}
