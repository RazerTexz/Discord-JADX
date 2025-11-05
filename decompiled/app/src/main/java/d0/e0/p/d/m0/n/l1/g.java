package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes3.dex */
public abstract class g {

    /* compiled from: KotlinTypeRefiner.kt */
    public static final class a extends g {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.n.l1.g
        public d0.e0.p.d.m0.c.e findClassAcrossModuleDependencies(d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            return null;
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public <S extends d0.e0.p.d.m0.k.a0.i> S getOrPutScopeForClass(d0.e0.p.d.m0.c.e eVar, Function0<? extends S> function0) {
            d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
            d0.z.d.m.checkNotNullParameter(function0, "compute");
            return function0.invoke();
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public boolean isRefinementNeededForModule(c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
            return false;
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public boolean isRefinementNeededForTypeConstructor(u0 u0Var) {
            d0.z.d.m.checkNotNullParameter(u0Var, "typeConstructor");
            return false;
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public d0.e0.p.d.m0.c.e refineDescriptor(d0.e0.p.d.m0.c.m mVar) {
            d0.z.d.m.checkNotNullParameter(mVar, "descriptor");
            return null;
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h refineDescriptor(d0.e0.p.d.m0.c.m mVar) {
            return refineDescriptor(mVar);
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public Collection<d0.e0.p.d.m0.n.c0> refineSupertypes(d0.e0.p.d.m0.c.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
            Collection<d0.e0.p.d.m0.n.c0> supertypes = eVar.getTypeConstructor().getSupertypes();
            d0.z.d.m.checkNotNullExpressionValue(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // d0.e0.p.d.m0.n.l1.g
        public d0.e0.p.d.m0.n.c0 refineType(d0.e0.p.d.m0.n.c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "type");
            return c0Var;
        }
    }

    public abstract d0.e0.p.d.m0.c.e findClassAcrossModuleDependencies(d0.e0.p.d.m0.g.a aVar);

    public abstract <S extends d0.e0.p.d.m0.k.a0.i> S getOrPutScopeForClass(d0.e0.p.d.m0.c.e eVar, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(c0 c0Var);

    public abstract boolean isRefinementNeededForTypeConstructor(u0 u0Var);

    public abstract d0.e0.p.d.m0.c.h refineDescriptor(d0.e0.p.d.m0.c.m mVar);

    public abstract Collection<d0.e0.p.d.m0.n.c0> refineSupertypes(d0.e0.p.d.m0.c.e eVar);

    public abstract d0.e0.p.d.m0.n.c0 refineType(d0.e0.p.d.m0.n.c0 c0Var);
}
