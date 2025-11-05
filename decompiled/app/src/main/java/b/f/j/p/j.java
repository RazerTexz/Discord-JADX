package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;

/* compiled from: BitmapProbeProducer.java */
/* loaded from: classes3.dex */
public class j implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f617b;
    public final b.f.j.c.f c;
    public final b.f.j.c.i d;
    public final w0<CloseableReference<b.f.j.j.c>> e;
    public final b.f.j.c.d<CacheKey> f;
    public final b.f.j.c.d<CacheKey> g;

    /* compiled from: BitmapProbeProducer.java */
    public static class a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public final x0 c;
        public final b.f.j.c.w<CacheKey, PooledByteBuffer> d;
        public final b.f.j.c.f e;
        public final b.f.j.c.f f;
        public final b.f.j.c.i g;
        public final b.f.j.c.d<CacheKey> h;
        public final b.f.j.c.d<CacheKey> i;

        public a(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d<CacheKey> dVar, b.f.j.c.d<CacheKey> dVar2) {
            super(lVar);
            this.c = x0Var;
            this.d = wVar;
            this.e = fVar;
            this.f = fVar2;
            this.g = iVar;
            this.h = dVar;
            this.i = dVar2;
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            try {
                b.f.j.r.b.b();
                if (b.f(i) || closeableReference == null || b.l(i, 8)) {
                    this.f632b.b(closeableReference, i);
                } else {
                    ImageRequest imageRequestE = this.c.e();
                    ((b.f.j.c.n) this.g).b(imageRequestE, this.c.b());
                    String str = (String) this.c.l("origin");
                    if (str != null && str.equals("memory_bitmap")) {
                        Objects.requireNonNull(this.c.g().getExperiments());
                        Objects.requireNonNull(this.c.g().getExperiments());
                    }
                    this.f632b.b(closeableReference, i);
                }
            } finally {
                b.f.j.r.b.b();
            }
        }
    }

    public j(b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d<CacheKey> dVar, b.f.j.c.d<CacheKey> dVar2, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        this.a = wVar;
        this.f617b = fVar;
        this.c = fVar2;
        this.d = iVar;
        this.f = dVar;
        this.g = dVar2;
        this.e = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "BitmapProbeProducer");
            a aVar = new a(lVar, x0Var, this.a, this.f617b, this.c, this.d, this.f, this.g);
            z0VarO.j(x0Var, "BitmapProbeProducer", null);
            b.f.j.r.b.b();
            this.e.b(aVar, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }
}
