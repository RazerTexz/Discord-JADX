package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.d.b.c;
import d0.e0.p.d.m0.e.a.g0.f;
import d0.e0.p.d.m0.e.a.i0.c;
import d0.e0.p.d.m0.e.a.t;
import d0.e0.p.d.m0.e.b.v;
import d0.e0.p.d.m0.l.b.k;
import d0.e0.p.d.m0.m.o;

/* compiled from: RuntimeModuleData.kt */
/* loaded from: classes3.dex */
public final class l {
    public static final d0.e0.p.d.m0.e.b.e makeDeserializationComponentsForJava(c0 c0Var, o oVar, d0 d0Var, d0.e0.p.d.m0.e.a.i0.f fVar, d0.e0.p.d.m0.e.b.n nVar, d0.e0.p.d.m0.e.b.f fVar2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(fVar, "lazyJavaPackageFragmentProvider");
        d0.z.d.m.checkNotNullParameter(nVar, "reflectKotlinClassFinder");
        d0.z.d.m.checkNotNullParameter(fVar2, "deserializedDescriptorResolver");
        return new d0.e0.p.d.m0.e.b.e(oVar, c0Var, k.a.a, new d0.e0.p.d.m0.e.b.g(nVar, fVar2), new d0.e0.p.d.m0.e.b.c(c0Var, d0Var, oVar, nVar), fVar, d0Var, j.f3286b, c.a.a, d0.e0.p.d.m0.l.b.i.a.getDEFAULT(), d0.e0.p.d.m0.n.l1.l.f3529b.getDefault());
    }

    public static final d0.e0.p.d.m0.e.a.i0.f makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, c0 c0Var, o oVar, d0 d0Var, d0.e0.p.d.m0.e.b.n nVar, d0.e0.p.d.m0.e.b.f fVar, d0.e0.p.d.m0.e.a.i0.i iVar, v vVar) {
        d0.z.d.m.checkNotNullParameter(classLoader, "classLoader");
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(nVar, "reflectKotlinClassFinder");
        d0.z.d.m.checkNotNullParameter(fVar, "deserializedDescriptorResolver");
        d0.z.d.m.checkNotNullParameter(iVar, "singleModuleClassResolver");
        d0.z.d.m.checkNotNullParameter(vVar, "packagePartProvider");
        d0.e0.p.d.m0.p.e eVar = d0.e0.p.d.m0.p.e.f3563b;
        d0.e0.p.d.m0.e.a.c cVar = new d0.e0.p.d.m0.e.a.c(oVar, eVar);
        d dVar = new d(classLoader);
        d0.e0.p.d.m0.e.a.g0.j jVar = d0.e0.p.d.m0.e.a.g0.j.a;
        d0.z.d.m.checkNotNullExpressionValue(jVar, "DO_NOTHING");
        j jVar2 = j.f3286b;
        d0.e0.p.d.m0.e.a.g0.g gVar = d0.e0.p.d.m0.e.a.g0.g.a;
        d0.z.d.m.checkNotNullExpressionValue(gVar, "EMPTY");
        f.a aVar = f.a.a;
        d0.e0.p.d.m0.k.z.b bVar = new d0.e0.p.d.m0.k.z.b(oVar, d0.t.n.emptyList());
        m mVar = m.a;
        x0.a aVar2 = x0.a.a;
        c.a aVar3 = c.a.a;
        d0.e0.p.d.m0.b.j jVar3 = new d0.e0.p.d.m0.b.j(c0Var, d0Var);
        c.a aVar4 = c.a.a;
        return new d0.e0.p.d.m0.e.a.i0.f(new d0.e0.p.d.m0.e.a.i0.b(oVar, dVar, nVar, fVar, jVar, jVar2, gVar, aVar, bVar, mVar, iVar, vVar, aVar2, aVar3, c0Var, jVar3, cVar, new d0.e0.p.d.m0.e.a.l0.l(cVar, eVar, new d0.e0.p.d.m0.e.a.l0.d(aVar4)), t.a.a, aVar4, d0.e0.p.d.m0.n.l1.l.f3529b.getDefault(), eVar));
    }

    public static /* synthetic */ d0.e0.p.d.m0.e.a.i0.f makeLazyJavaPackageFragmentFromClassLoaderProvider$default(ClassLoader classLoader, c0 c0Var, o oVar, d0 d0Var, d0.e0.p.d.m0.e.b.n nVar, d0.e0.p.d.m0.e.b.f fVar, d0.e0.p.d.m0.e.a.i0.i iVar, v vVar, int i, Object obj) {
        return makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, c0Var, oVar, d0Var, nVar, fVar, iVar, (i & 128) != 0 ? v.a.a : vVar);
    }
}
