package b.f.j.p;

import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: BranchOnSeparateImagesProducer.java */
/* loaded from: classes3.dex */
public class k implements w0<b.f.j.j.e> {
    public final w0<b.f.j.j.e> a;

    /* renamed from: b, reason: collision with root package name */
    public final w0<b.f.j.j.e> f620b;

    /* compiled from: BranchOnSeparateImagesProducer.java */
    public class b extends p<b.f.j.j.e, b.f.j.j.e> {
        public x0 c;

        public b(l lVar, x0 x0Var, a aVar) {
            super(lVar);
            this.c = x0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            k.this.f620b.b(this.f632b, this.c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            ImageRequest imageRequestE = this.c.e();
            boolean zE = b.f.j.p.b.e(i);
            boolean zT0 = b.c.a.a0.d.T0(eVar, imageRequestE.j);
            if (eVar != null && (zT0 || imageRequestE.g)) {
                if (zE && zT0) {
                    this.f632b.b(eVar, i);
                } else {
                    this.f632b.b(eVar, i & (-2));
                }
            }
            if (!zE || zT0 || imageRequestE.h) {
                return;
            }
            if (eVar != null) {
                eVar.close();
            }
            k.this.f620b.b(this.f632b, this.c);
        }
    }

    public k(w0<b.f.j.j.e> w0Var, w0<b.f.j.j.e> w0Var2) {
        this.a = w0Var;
        this.f620b = w0Var2;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        this.a.b(new b(lVar, x0Var, null), x0Var);
    }
}
