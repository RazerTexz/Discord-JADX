package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.v0;

/* compiled from: RuntimeSourceElementFactory.kt */
/* loaded from: classes3.dex */
public final class m implements d0.e0.p.d.m0.e.a.j0.b {
    public static final m a = new m();

    /* compiled from: RuntimeSourceElementFactory.kt */
    public static final class a implements d0.e0.p.d.m0.e.a.j0.a {

        /* renamed from: b, reason: collision with root package name */
        public final d0.e0.p.d.m0.c.k1.b.n f3288b;

        public a(d0.e0.p.d.m0.c.k1.b.n nVar) {
            d0.z.d.m.checkNotNullParameter(nVar, "javaElement");
            this.f3288b = nVar;
        }

        @Override // d0.e0.p.d.m0.c.u0
        public v0 getContainingFile() {
            v0 v0Var = v0.a;
            d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
            return v0Var;
        }

        @Override // d0.e0.p.d.m0.e.a.j0.a
        public d0.e0.p.d.m0.c.k1.b.n getJavaElement() {
            return this.f3288b;
        }

        public String toString() {
            return a.class.getName() + ": " + getJavaElement();
        }

        @Override // d0.e0.p.d.m0.e.a.j0.a
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.l getJavaElement() {
            return getJavaElement();
        }
    }

    @Override // d0.e0.p.d.m0.e.a.j0.b
    public d0.e0.p.d.m0.e.a.j0.a source(d0.e0.p.d.m0.e.a.k0.l lVar) {
        d0.z.d.m.checkNotNullParameter(lVar, "javaElement");
        return new a((d0.e0.p.d.m0.c.k1.b.n) lVar);
    }
}
