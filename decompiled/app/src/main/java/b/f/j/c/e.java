package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BufferedDiskCache.java */
/* loaded from: classes.dex */
public class e implements Callable<b.f.j.j.e> {
    public final /* synthetic */ AtomicBoolean j;
    public final /* synthetic */ CacheKey k;
    public final /* synthetic */ f l;

    public e(f fVar, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.l = fVar;
        this.j = atomicBoolean;
        this.k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public b.f.j.j.e call() throws Exception {
        PooledByteBuffer pooledByteBufferA;
        try {
            if (this.j.get()) {
                throw new CancellationException();
            }
            b.f.j.j.e eVarA = this.l.f.a(this.k);
            if (eVarA != null) {
                this.k.b();
                int i = b.f.d.e.a.a;
                Objects.requireNonNull((z) this.l.g);
            } else {
                this.k.b();
                int i2 = b.f.d.e.a.a;
                Objects.requireNonNull((z) this.l.g);
                eVarA = null;
                try {
                    pooledByteBufferA = f.a(this.l, this.k);
                } catch (Exception unused) {
                }
                if (pooledByteBufferA == null) {
                    return eVarA;
                }
                CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferA);
                try {
                    eVarA = new b.f.j.j.e(closeableReferenceA);
                } finally {
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                }
            }
            if (!Thread.interrupted()) {
                return eVarA;
            }
            b.f.d.e.a.i(f.class, "Host thread was interrupted, decreasing reference count");
            eVarA.close();
            throw new InterruptedException();
        } catch (Throwable th) {
            throw th;
        }
    }
}
