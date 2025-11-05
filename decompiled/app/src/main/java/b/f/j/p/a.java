package b.f.j.p;

/* compiled from: AddImageTransformMetaDataProducer.java */
/* loaded from: classes3.dex */
public class a implements w0<b.f.j.j.e> {
    public final w0<b.f.j.j.e> a;

    /* compiled from: AddImageTransformMetaDataProducer.java */
    public static class b extends p<b.f.j.j.e, b.f.j.j.e> {
        public b(l lVar, C0073a c0073a) {
            super(lVar);
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            if (eVar == null) {
                this.f632b.b(null, i);
                return;
            }
            if (!b.f.j.j.e.s(eVar)) {
                eVar.q();
            }
            this.f632b.b(eVar, i);
        }
    }

    public a(w0<b.f.j.j.e> w0Var) {
        this.a = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        this.a.b(new b(lVar, null), x0Var);
    }
}
