package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: DiskCacheWriteProducer.java */
/* loaded from: classes3.dex */
public class t implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f638b;
    public final b.f.j.c.i c;
    public final w0<b.f.j.j.e> d;

    /* compiled from: DiskCacheWriteProducer.java */
    public static class b extends p<b.f.j.j.e, b.f.j.j.e> {
        public final x0 c;
        public final b.f.j.c.f d;
        public final b.f.j.c.f e;
        public final b.f.j.c.i f;

        public b(l lVar, x0 x0Var, b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, a aVar) {
            super(lVar);
            this.c = x0Var;
            this.d = fVar;
            this.e = fVar2;
            this.f = iVar;
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            this.c.o().e(this.c, "DiskCacheWriteProducer");
            if (!b.f.j.p.b.f(i) && eVar != null && !b.f.j.p.b.l(i, 10)) {
                eVar.x();
                if (eVar.l != b.f.i.c.a) {
                    ImageRequest imageRequestE = this.c.e();
                    CacheKey cacheKeyB = ((b.f.j.c.n) this.f).b(imageRequestE, this.c.b());
                    if (imageRequestE.f2902b == ImageRequest.b.SMALL) {
                        this.e.f(cacheKeyB, eVar);
                    } else {
                        this.d.f(cacheKeyB, eVar);
                    }
                    this.c.o().j(this.c, "DiskCacheWriteProducer", null);
                    this.f632b.b(eVar, i);
                    return;
                }
            }
            this.c.o().j(this.c, "DiskCacheWriteProducer", null);
            this.f632b.b(eVar, i);
        }
    }

    public t(b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f638b = fVar2;
        this.c = iVar;
        this.d = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        if (x0Var.q().g() >= ImageRequest.c.DISK_CACHE.g()) {
            x0Var.i("disk", "nil-result_write");
            lVar.b(null, 1);
        } else {
            if (x0Var.e().b(32)) {
                lVar = new b(lVar, x0Var, this.a, this.f638b, this.c, null);
            }
            this.d.b(lVar, x0Var);
        }
    }
}
