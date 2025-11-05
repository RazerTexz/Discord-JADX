package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.k.f;

/* compiled from: FieldOverridabilityCondition.kt */
/* loaded from: classes3.dex */
public final class r implements d0.e0.p.d.m0.k.f {
    @Override // d0.e0.p.d.m0.k.f
    public f.a getContract() {
        return f.a.BOTH;
    }

    @Override // d0.e0.p.d.m0.k.f
    public f.b isOverridable(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar) {
        f.b bVar = f.b.UNKNOWN;
        d0.z.d.m.checkNotNullParameter(aVar, "superDescriptor");
        d0.z.d.m.checkNotNullParameter(aVar2, "subDescriptor");
        if (!(aVar2 instanceof n0) || !(aVar instanceof n0)) {
            return bVar;
        }
        n0 n0Var = (n0) aVar2;
        n0 n0Var2 = (n0) aVar;
        return !d0.z.d.m.areEqual(n0Var.getName(), n0Var2.getName()) ? bVar : (d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var) && d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var2)) ? f.b.OVERRIDABLE : (d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var) || d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var2)) ? f.b.INCOMPATIBLE : bVar;
    }
}
