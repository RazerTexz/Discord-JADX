package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;
import p007b.p109f.p111b.p113b.DiskStorageCache;

/* JADX INFO: renamed from: b.f.j.c.g, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache3 implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CacheKey f3671j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BufferedDiskCache2 f3672k;

    public BufferedDiskCache3(BufferedDiskCache2 bufferedDiskCache2, Object obj, CacheKey cacheKey) {
        this.f3672k = bufferedDiskCache2;
        this.f3671j = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.f3672k.f3666f.m1210c(this.f3671j);
            ((DiskStorageCache) this.f3672k.f3661a).m954f(this.f3671j);
            return null;
        } finally {
        }
    }
}
