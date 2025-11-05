package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.b.q.f;
import d0.e0.p.d.m0.b.q.o;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.i0;
import d0.e0.p.d.m0.c.i1.y;
import d0.e0.p.d.m0.l.b.k;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RuntimeModuleData.kt */
/* loaded from: classes3.dex */
public final class k {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.l.b.j f3287b;
    public final d0.e0.p.d.m0.c.k1.a.a c;

    /* compiled from: RuntimeModuleData.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final k create(ClassLoader classLoader) {
            d0.z.d.m.checkNotNullParameter(classLoader, "classLoader");
            d0.e0.p.d.m0.m.f fVar = new d0.e0.p.d.m0.m.f("RuntimeModuleData");
            d0.e0.p.d.m0.b.q.f fVar2 = new d0.e0.p.d.m0.b.q.f(fVar, f.a.FROM_DEPENDENCIES);
            d0.e0.p.d.m0.g.e eVarSpecial = d0.e0.p.d.m0.g.e.special("<runtime module for " + classLoader + '>');
            d0.z.d.m.checkNotNullExpressionValue(eVarSpecial, "special(\"<runtime module for $classLoader>\")");
            y yVar = new y(eVarSpecial, fVar, fVar2, null, null, null, 56, null);
            fVar2.setBuiltInsModule(yVar);
            fVar2.initialize(yVar, true);
            g gVar = new g(classLoader);
            d0.e0.p.d.m0.e.b.f fVar3 = new d0.e0.p.d.m0.e.b.f();
            d0.e0.p.d.m0.e.a.i0.j jVar = new d0.e0.p.d.m0.e.a.i0.j();
            d0 d0Var = new d0(fVar, yVar);
            d0.e0.p.d.m0.e.a.i0.f fVarMakeLazyJavaPackageFragmentFromClassLoaderProvider$default = l.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader, yVar, fVar, d0Var, gVar, fVar3, jVar, null, 128, null);
            d0.e0.p.d.m0.e.b.e eVarMakeDeserializationComponentsForJava = l.makeDeserializationComponentsForJava(yVar, fVar, d0Var, fVarMakeLazyJavaPackageFragmentFromClassLoaderProvider$default, gVar, fVar3);
            fVar3.setComponents(eVarMakeDeserializationComponentsForJava);
            d0.e0.p.d.m0.e.a.g0.g gVar2 = d0.e0.p.d.m0.e.a.g0.g.a;
            d0.z.d.m.checkNotNullExpressionValue(gVar2, "EMPTY");
            d0.e0.p.d.m0.k.y.b bVar = new d0.e0.p.d.m0.k.y.b(fVarMakeLazyJavaPackageFragmentFromClassLoaderProvider$default, gVar2);
            jVar.setResolver(bVar);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            d0.z.d.m.checkNotNullExpressionValue(classLoader2, "stdlibClassLoader");
            o oVar = new o(fVar, new g(classLoader2), yVar, d0Var, fVar2.getCustomizer(), fVar2.getCustomizer(), k.a.a, d0.e0.p.d.m0.n.l1.l.f3529b.getDefault(), new d0.e0.p.d.m0.k.z.b(fVar, d0.t.n.emptyList()));
            yVar.setDependencies(yVar);
            yVar.initialize(new d0.e0.p.d.m0.c.i1.j(d0.t.n.listOf((Object[]) new i0[]{bVar.getPackageFragmentProvider(), oVar})));
            return new k(eVarMakeDeserializationComponentsForJava.getComponents(), new d0.e0.p.d.m0.c.k1.a.a(fVar3, gVar), null);
        }
    }

    public k(d0.e0.p.d.m0.l.b.j jVar, d0.e0.p.d.m0.c.k1.a.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3287b = jVar;
        this.c = aVar;
    }

    public final d0.e0.p.d.m0.l.b.j getDeserialization() {
        return this.f3287b;
    }

    public final c0 getModule() {
        return this.f3287b.getModuleDescriptor();
    }

    public final d0.e0.p.d.m0.c.k1.a.a getPackagePartScopeCache() {
        return this.c;
    }
}
