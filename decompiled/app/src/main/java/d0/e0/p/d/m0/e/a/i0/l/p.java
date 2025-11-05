package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.p.b;
import d0.t.u;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes3.dex */
public final class p implements b.c<d0.e0.p.d.m0.c.e> {
    public static final p a = new p();

    /* compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends d0.z.d.o implements Function1<c0, d0.e0.p.d.m0.c.e> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(c0 c0Var) {
            return invoke2(c0Var);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.e invoke2(c0 c0Var) {
            d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
                return (d0.e0.p.d.m0.c.e) declarationDescriptor;
            }
            return null;
        }
    }

    @Override // d0.e0.p.d.m0.p.b.c
    public /* bridge */ /* synthetic */ Iterable<? extends d0.e0.p.d.m0.c.e> getNeighbors(d0.e0.p.d.m0.c.e eVar) {
        return getNeighbors2(eVar);
    }

    /* renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<d0.e0.p.d.m0.c.e> getNeighbors2(d0.e0.p.d.m0.c.e eVar) {
        Collection<c0> supertypes = eVar.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return d0.f0.q.asIterable(d0.f0.q.mapNotNull(u.asSequence(supertypes), a.j));
    }
}
