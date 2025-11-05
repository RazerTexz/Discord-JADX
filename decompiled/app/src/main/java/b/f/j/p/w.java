package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: EncodedProbeProducer.java */
/* loaded from: classes3.dex */
public class w implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f641b;
    public final b.f.j.c.i c;
    public final w0<b.f.j.j.e> d;
    public final b.f.j.c.d<CacheKey> e;
    public final b.f.j.c.d<CacheKey> f;

    /* compiled from: EncodedProbeProducer.java */
    public static class a extends p<b.f.j.j.e, b.f.j.j.e> {
        public final x0 c;
        public final b.f.j.c.f d;
        public final b.f.j.c.f e;
        public final b.f.j.c.i f;
        public final b.f.j.c.d<CacheKey> g;
        public final b.f.j.c.d<CacheKey> h;

        public a(l<b.f.j.j.e> lVar, x0 x0Var, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d<CacheKey> dVar, b.f.j.c.d<CacheKey> dVar2) {
            super(lVar);
            this.c = x0Var;
            this.d = fVar;
            this.e = fVar2;
            this.f = iVar;
            this.g = dVar;
            this.h = dVar2;
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            try {
                b.f.j.r.b.b();
                if (b.f(i) || eVar == null || b.l(i, 10)) {
                    this.f632b.b(eVar, i);
                } else {
                    eVar.x();
                    if (eVar.l == b.f.i.c.a) {
                        this.f632b.b(eVar, i);
                    } else {
                        ImageRequest imageRequestE = this.c.e();
                        CacheKey cacheKeyB = ((b.f.j.c.n) this.f).b(imageRequestE, this.c.b());
                        this.g.a(cacheKeyB);
                        if ("memory_encoded".equals(this.c.l("origin"))) {
                            if (!this.h.b(cacheKeyB)) {
                                (imageRequestE.f2902b == ImageRequest.b.SMALL ? this.e : this.d).c(cacheKeyB);
                                this.h.a(cacheKeyB);
                            }
                        } else if ("disk".equals(this.c.l("origin"))) {
                            this.h.a(cacheKeyB);
                        }
                        this.f632b.b(eVar, i);
                    }
                }
            } finally {
                b.f.j.r.b.b();
            }
        }
    }

    public w(b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, b.f.j.c.d dVar, b.f.j.c.d dVar2, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f641b = fVar2;
        this.c = iVar;
        this.e = dVar;
        this.f = dVar2;
        this.d = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "EncodedProbeProducer");
            a aVar = new a(lVar, x0Var, this.a, this.f641b, this.c, this.e, this.f);
            z0VarO.j(x0Var, "EncodedProbeProducer", null);
            b.f.j.r.b.b();
            this.d.b(aVar, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }
}
