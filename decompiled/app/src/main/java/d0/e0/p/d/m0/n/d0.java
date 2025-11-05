package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.s0;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public final class d0 {
    public static final d0 a = new d0();

    /* compiled from: KotlinTypeFactory.kt */
    public static final class a extends d0.z.d.o implements Function1 {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((d0.e0.p.d.m0.n.l1.g) obj);
        }

        public final Void invoke(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "$noName_0");
            return null;
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    public static final class b {
        public final j0 a;

        /* renamed from: b, reason: collision with root package name */
        public final u0 f3521b;

        public b(j0 j0Var, u0 u0Var) {
            this.a = j0Var;
            this.f3521b = u0Var;
        }

        public final j0 getExpandedType() {
            return this.a;
        }

        public final u0 getRefinedConstructor() {
            return this.f3521b;
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    public static final class c extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, j0> {
        public final /* synthetic */ d0.e0.p.d.m0.c.g1.g $annotations;
        public final /* synthetic */ List<w0> $arguments;
        public final /* synthetic */ u0 $constructor;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(u0 u0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar, boolean z2) {
            super(1);
            this.$constructor = u0Var;
            this.$arguments = list;
            this.$annotations = gVar;
            this.$nullable = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
            return invoke2(gVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "refiner");
            b bVarAccess$refineConstructor = d0.access$refineConstructor(d0.this, this.$constructor, gVar, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            j0 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            d0.e0.p.d.m0.c.g1.g gVar2 = this.$annotations;
            u0 refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            d0.z.d.m.checkNotNull(refinedConstructor);
            return d0.simpleType(gVar2, refinedConstructor, this.$arguments, this.$nullable, gVar);
        }
    }

    /* compiled from: KotlinTypeFactory.kt */
    public static final class d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, j0> {
        public final /* synthetic */ d0.e0.p.d.m0.c.g1.g $annotations;
        public final /* synthetic */ List<w0> $arguments;
        public final /* synthetic */ u0 $constructor;
        public final /* synthetic */ d0.e0.p.d.m0.k.a0.i $memberScope;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(u0 u0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, d0.e0.p.d.m0.k.a0.i iVar) {
            super(1);
            this.$constructor = u0Var;
            this.$arguments = list;
            this.$annotations = gVar;
            this.$nullable = z2;
            this.$memberScope = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
            return invoke2(gVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            b bVarAccess$refineConstructor = d0.access$refineConstructor(d0.this, this.$constructor, gVar, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            j0 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            d0.e0.p.d.m0.c.g1.g gVar2 = this.$annotations;
            u0 refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            d0.z.d.m.checkNotNull(refinedConstructor);
            return d0.simpleTypeWithNonTrivialMemberScope(gVar2, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    static {
        a aVar = a.j;
    }

    public static final b access$refineConstructor(d0 d0Var, u0 u0Var, d0.e0.p.d.m0.n.l1.g gVar, List list) {
        b bVar;
        Objects.requireNonNull(d0Var);
        d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
        d0.e0.p.d.m0.c.h hVarRefineDescriptor = declarationDescriptor == null ? null : gVar.refineDescriptor(declarationDescriptor);
        if (hVarRefineDescriptor == null) {
            return null;
        }
        if (hVarRefineDescriptor instanceof d0.e0.p.d.m0.c.y0) {
            bVar = new b(computeExpandedType((d0.e0.p.d.m0.c.y0) hVarRefineDescriptor, list), null);
        } else {
            u0 u0VarRefine = hVarRefineDescriptor.getTypeConstructor().refine(gVar);
            d0.z.d.m.checkNotNullExpressionValue(u0VarRefine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
            bVar = new b(null, u0VarRefine);
        }
        return bVar;
    }

    public static final j0 computeExpandedType(d0.e0.p.d.m0.c.y0 y0Var, List<? extends w0> list) {
        d0.z.d.m.checkNotNullParameter(y0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        return new q0(s0.a.a, false).expand(r0.a.create(null, y0Var, list), d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
    }

    public static final i1 flexibleType(j0 j0Var, j0 j0Var2) {
        d0.z.d.m.checkNotNullParameter(j0Var, "lowerBound");
        d0.z.d.m.checkNotNullParameter(j0Var2, "upperBound");
        return d0.z.d.m.areEqual(j0Var, j0Var2) ? j0Var : new w(j0Var, j0Var2);
    }

    public static final j0 integerLiteralType(d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.k.v.n nVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(nVar, "constructor");
        List listEmptyList = d0.t.n.emptyList();
        d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = t.createErrorScope("Scope for integer literal type", true);
        d0.z.d.m.checkNotNullExpressionValue(iVarCreateErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(gVar, nVar, listEmptyList, z2, iVarCreateErrorScope);
    }

    public static final j0 simpleNotNullType(d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.e eVar, List<? extends w0> list) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        u0 typeConstructor = eVar.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(gVar, typeConstructor, list, false, null, 16, null);
    }

    public static final j0 simpleType(d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var, List<? extends w0> list, boolean z2, d0.e0.p.d.m0.n.l1.g gVar2) {
        d0.e0.p.d.m0.k.a0.i iVarCreateScopeForKotlinType;
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        if (gVar.isEmpty() && list.isEmpty() && !z2 && u0Var.getDeclarationDescriptor() != null) {
            d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
            d0.z.d.m.checkNotNull(declarationDescriptor);
            j0 defaultType = declarationDescriptor.getDefaultType();
            d0.z.d.m.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        d0 d0Var = a;
        d0.e0.p.d.m0.c.h declarationDescriptor2 = u0Var.getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof d0.e0.p.d.m0.c.z0) {
            iVarCreateScopeForKotlinType = declarationDescriptor2.getDefaultType().getMemberScope();
        } else if (declarationDescriptor2 instanceof d0.e0.p.d.m0.c.e) {
            if (gVar2 == null) {
                gVar2 = d0.e0.p.d.m0.k.x.a.getKotlinTypeRefiner(d0.e0.p.d.m0.k.x.a.getModule(declarationDescriptor2));
            }
            iVarCreateScopeForKotlinType = list.isEmpty() ? d0.e0.p.d.m0.c.i1.v.getRefinedUnsubstitutedMemberScopeIfPossible((d0.e0.p.d.m0.c.e) declarationDescriptor2, gVar2) : d0.e0.p.d.m0.c.i1.v.getRefinedMemberScopeIfPossible((d0.e0.p.d.m0.c.e) declarationDescriptor2, v0.f3542b.create(u0Var, list), gVar2);
        } else if (declarationDescriptor2 instanceof d0.e0.p.d.m0.c.y0) {
            iVarCreateScopeForKotlinType = t.createErrorScope(d0.z.d.m.stringPlus("Scope for abbreviation: ", ((d0.e0.p.d.m0.c.y0) declarationDescriptor2).getName()), true);
            d0.z.d.m.checkNotNullExpressionValue(iVarCreateScopeForKotlinType, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
        } else {
            if (!(u0Var instanceof a0)) {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor2 + " for constructor: " + u0Var);
            }
            iVarCreateScopeForKotlinType = ((a0) u0Var).createScopeForKotlinType();
        }
        return simpleTypeWithNonTrivialMemberScope(gVar, u0Var, list, z2, iVarCreateScopeForKotlinType, d0Var.new c(u0Var, list, gVar, z2));
    }

    public static /* synthetic */ j0 simpleType$default(d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var, List list, boolean z2, d0.e0.p.d.m0.n.l1.g gVar2, int i, Object obj) {
        if ((i & 16) != 0) {
            gVar2 = null;
        }
        return simpleType(gVar, u0Var, list, z2, gVar2);
    }

    public static final j0 simpleTypeWithNonTrivialMemberScope(d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var, List<? extends w0> list, boolean z2, d0.e0.p.d.m0.k.a0.i iVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        k0 k0Var = new k0(u0Var, list, z2, iVar, a.new d(u0Var, list, gVar, z2, iVar));
        return gVar.isEmpty() ? k0Var : new h(k0Var, gVar);
    }

    public static final j0 simpleTypeWithNonTrivialMemberScope(d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var, List<? extends w0> list, boolean z2, d0.e0.p.d.m0.k.a0.i iVar, Function1<? super d0.e0.p.d.m0.n.l1.g, ? extends j0> function1) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        d0.z.d.m.checkNotNullParameter(function1, "refinedTypeFactory");
        k0 k0Var = new k0(u0Var, list, z2, iVar, function1);
        return gVar.isEmpty() ? k0Var : new h(k0Var, gVar);
    }
}
