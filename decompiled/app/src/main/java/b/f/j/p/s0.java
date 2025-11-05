package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* loaded from: classes3.dex */
public class s0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.w<CacheKey, b.f.j.j.c> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f637b;
    public final w0<CloseableReference<b.f.j.j.c>> c;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    public static class a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public final CacheKey c;
        public final boolean d;
        public final b.f.j.c.w<CacheKey, b.f.j.j.c> e;
        public final boolean f;

        public a(l<CloseableReference<b.f.j.j.c>> lVar, CacheKey cacheKey, boolean z2, b.f.j.c.w<CacheKey, b.f.j.j.c> wVar, boolean z3) {
            super(lVar);
            this.c = cacheKey;
            this.d = z2;
            this.e = wVar;
            this.f = z3;
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            CloseableReference<b.f.j.j.c> closeableReference = (CloseableReference) obj;
            if (closeableReference == null) {
                if (b.e(i)) {
                    this.f632b.b(null, i);
                }
            } else if (!b.f(i) || this.d) {
                CloseableReference<b.f.j.j.c> closeableReferenceA = this.f ? this.e.a(this.c, closeableReference) : null;
                try {
                    this.f632b.a(1.0f);
                    l<O> lVar = this.f632b;
                    if (closeableReferenceA != null) {
                        closeableReference = closeableReferenceA;
                    }
                    lVar.b(closeableReference, i);
                } finally {
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                }
            }
        }
    }

    public s0(b.f.j.c.w<CacheKey, b.f.j.j.c> wVar, b.f.j.c.i iVar, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        this.a = wVar;
        this.f637b = iVar;
        this.c = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        Object objB = x0Var.b();
        b.f.j.q.b bVar = imageRequestE.f2903s;
        if (bVar == null || bVar.getPostprocessorCacheKey() == null) {
            this.c.b(lVar, x0Var);
            return;
        }
        z0VarO.e(x0Var, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey cacheKeyC = ((b.f.j.c.n) this.f637b).c(imageRequestE, objB);
        CloseableReference<b.f.j.j.c> closeableReference = x0Var.e().b(1) ? this.a.get(cacheKeyC) : null;
        if (closeableReference == null) {
            a aVar = new a(lVar, cacheKeyC, bVar instanceof b.f.j.q.c, this.a, x0Var.e().b(2));
            z0VarO.j(x0Var, "PostprocessedBitmapMemoryCacheProducer", z0VarO.g(x0Var, "PostprocessedBitmapMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "false") : null);
            this.c.b(aVar, x0Var);
        } else {
            z0VarO.j(x0Var, "PostprocessedBitmapMemoryCacheProducer", z0VarO.g(x0Var, "PostprocessedBitmapMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "true") : null);
            z0VarO.c(x0Var, "PostprocessedBitmapMemoryCacheProducer", true);
            x0Var.i("memory_bitmap", "postprocessed");
            lVar.a(1.0f);
            lVar.b(closeableReference, 1);
            closeableReference.close();
        }
    }
}
