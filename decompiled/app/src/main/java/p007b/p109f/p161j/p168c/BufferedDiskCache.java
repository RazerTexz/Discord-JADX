package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.c.e, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache implements Callable<EncodedImage2> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicBoolean f3658j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CacheKey f3659k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BufferedDiskCache2 f3660l;

    public BufferedDiskCache(BufferedDiskCache2 bufferedDiskCache2, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.f3660l = bufferedDiskCache2;
        this.f3658j = atomicBoolean;
        this.f3659k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public EncodedImage2 call() throws Exception {
        PooledByteBuffer pooledByteBufferM1215a;
        try {
            if (this.f3658j.get()) {
                throw new CancellationException();
            }
            EncodedImage2 encodedImage2M1208a = this.f3660l.f3666f.m1208a(this.f3659k);
            if (encodedImage2M1208a != null) {
                this.f3659k.mo930b();
                int i = FLog.f3102a;
                Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3660l.f3667g);
            } else {
                this.f3659k.mo930b();
                int i2 = FLog.f3102a;
                Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3660l.f3667g);
                encodedImage2M1208a = null;
                try {
                    pooledByteBufferM1215a = BufferedDiskCache2.m1215a(this.f3660l, this.f3659k);
                } catch (Exception unused) {
                }
                if (pooledByteBufferM1215a == null) {
                    return encodedImage2M1208a;
                }
                CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(pooledByteBufferM1215a);
                try {
                    encodedImage2M1208a = new EncodedImage2(closeableReferenceM8632A);
                } finally {
                    if (closeableReferenceM8632A != null) {
                        closeableReferenceM8632A.close();
                    }
                }
            }
            if (!Thread.interrupted()) {
                return encodedImage2M1208a;
            }
            FLog.m981i(BufferedDiskCache2.class, "Host thread was interrupted, decreasing reference count");
            encodedImage2M1208a.close();
            throw new InterruptedException();
        } catch (Throwable th) {
            throw th;
        }
    }
}
