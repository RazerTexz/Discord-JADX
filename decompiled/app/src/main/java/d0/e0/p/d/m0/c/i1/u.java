package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.n.z0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModuleAwareClassDescriptor.kt */
/* loaded from: classes3.dex */
public abstract class u implements d0.e0.p.d.m0.c.e {
    public static final a j = new a(null);

    /* compiled from: ModuleAwareClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d0.e0.p.d.m0.k.a0.i getRefinedMemberScopeIfPossible$descriptors(d0.e0.p.d.m0.c.e eVar, z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(eVar, "<this>");
            d0.z.d.m.checkNotNullParameter(z0Var, "typeSubstitution");
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            u uVar = eVar instanceof u ? (u) eVar : null;
            if (uVar != null) {
                return uVar.getMemberScope(z0Var, gVar);
            }
            d0.e0.p.d.m0.k.a0.i memberScope = eVar.getMemberScope(z0Var);
            d0.z.d.m.checkNotNullExpressionValue(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
            return memberScope;
        }

        public final d0.e0.p.d.m0.k.a0.i getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(eVar, "<this>");
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            u uVar = eVar instanceof u ? (u) eVar : null;
            if (uVar != null) {
                return uVar.getUnsubstitutedMemberScope(gVar);
            }
            d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = eVar.getUnsubstitutedMemberScope();
            d0.z.d.m.checkNotNullExpressionValue(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
            return unsubstitutedMemberScope;
        }
    }

    public abstract d0.e0.p.d.m0.k.a0.i getMemberScope(z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar);

    public abstract d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar);
}
