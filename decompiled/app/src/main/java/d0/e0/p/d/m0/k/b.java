package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.y;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.k;
import d0.e0.p.d.m0.n.l1.f;
import d0.e0.p.d.m0.n.l1.g;
import d0.e0.p.d.m0.n.u0;
import d0.t.u;
import java.util.Collection;
import kotlin.jvm.functions.Function2;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final b a = new b();

    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    public static final class a extends d0.z.d.o implements Function2<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m, Boolean> {
        public static final a j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
            return Boolean.valueOf(invoke2(mVar, mVar2));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
            return false;
        }
    }

    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* renamed from: d0.e0.p.d.m0.k.b$b, reason: collision with other inner class name */
    public static final class C0565b implements f.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3467b;
        public final /* synthetic */ d0.e0.p.d.m0.c.a c;
        public final /* synthetic */ d0.e0.p.d.m0.c.a d;

        /* compiled from: DescriptorEquivalenceForOverrides.kt */
        /* renamed from: d0.e0.p.d.m0.k.b$b$a */
        public static final class a extends d0.z.d.o implements Function2<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m, Boolean> {
            public final /* synthetic */ d0.e0.p.d.m0.c.a $a;
            public final /* synthetic */ d0.e0.p.d.m0.c.a $b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
                super(2);
                this.$a = aVar;
                this.$b = aVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
                return Boolean.valueOf(invoke2(mVar, mVar2));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
                return d0.z.d.m.areEqual(mVar, this.$a) && d0.z.d.m.areEqual(mVar2, this.$b);
            }
        }

        public C0565b(boolean z2, d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
            this.f3467b = z2;
            this.c = aVar;
            this.d = aVar2;
        }

        @Override // d0.e0.p.d.m0.n.l1.f.a
        public final boolean equals(u0 u0Var, u0 u0Var2) {
            d0.z.d.m.checkNotNullParameter(u0Var, "c1");
            d0.z.d.m.checkNotNullParameter(u0Var2, "c2");
            if (d0.z.d.m.areEqual(u0Var, u0Var2)) {
                return true;
            }
            d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
            d0.e0.p.d.m0.c.h declarationDescriptor2 = u0Var2.getDeclarationDescriptor();
            if ((declarationDescriptor instanceof z0) && (declarationDescriptor2 instanceof z0)) {
                return b.access$areTypeParametersEquivalent(b.this, (z0) declarationDescriptor, (z0) declarationDescriptor2, this.f3467b, new a(this.c, this.d));
            }
            return false;
        }
    }

    public static final /* synthetic */ boolean access$areTypeParametersEquivalent(b bVar, z0 z0Var, z0 z0Var2, boolean z2, Function2 function2) {
        return bVar.a(z0Var, z0Var2, z2, function2);
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(b bVar, d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.l1.g gVar, int i, Object obj) {
        return bVar.areCallableDescriptorsEquivalent(aVar, aVar2, z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? false : z4, gVar);
    }

    public static /* synthetic */ boolean areEquivalent$default(b bVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = true;
        }
        return bVar.areEquivalent(mVar, mVar2, z2, z3);
    }

    public final boolean a(z0 z0Var, z0 z0Var2, boolean z2, Function2<? super d0.e0.p.d.m0.c.m, ? super d0.e0.p.d.m0.c.m, Boolean> function2) {
        if (d0.z.d.m.areEqual(z0Var, z0Var2)) {
            return true;
        }
        return !d0.z.d.m.areEqual(z0Var.getContainingDeclaration(), z0Var2.getContainingDeclaration()) && b(z0Var, z0Var2, function2, z2) && z0Var.getIndex() == z0Var2.getIndex();
    }

    public final boolean areCallableDescriptorsEquivalent(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "a");
        d0.z.d.m.checkNotNullParameter(aVar2, "b");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        if (d0.z.d.m.areEqual(aVar, aVar2)) {
            return true;
        }
        if (!d0.z.d.m.areEqual(aVar.getName(), aVar2.getName())) {
            return false;
        }
        if (z3 && (aVar instanceof y) && (aVar2 instanceof y) && ((y) aVar).isExpect() != ((y) aVar2).isExpect()) {
            return false;
        }
        if ((d0.z.d.m.areEqual(aVar.getContainingDeclaration(), aVar2.getContainingDeclaration()) && (!z2 || !d0.z.d.m.areEqual(c(aVar), c(aVar2)))) || e.isLocal(aVar) || e.isLocal(aVar2) || !b(aVar, aVar2, a.j, z2)) {
            return false;
        }
        k kVarCreate = k.create(gVar, new C0565b(z2, aVar, aVar2));
        d0.z.d.m.checkNotNullExpressionValue(kVarCreate, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
        k.d.a result = kVarCreate.isOverridableBy(aVar, aVar2, null, !z4).getResult();
        k.d.a aVar3 = k.d.a.OVERRIDABLE;
        return result == aVar3 && kVarCreate.isOverridableBy(aVar2, aVar, null, z4 ^ true).getResult() == aVar3;
    }

    public final boolean areEquivalent(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2, boolean z2, boolean z3) {
        return ((mVar instanceof d0.e0.p.d.m0.c.e) && (mVar2 instanceof d0.e0.p.d.m0.c.e)) ? d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.e) mVar).getTypeConstructor(), ((d0.e0.p.d.m0.c.e) mVar2).getTypeConstructor()) : ((mVar instanceof z0) && (mVar2 instanceof z0)) ? a((z0) mVar, (z0) mVar2, z2, c.j) : ((mVar instanceof d0.e0.p.d.m0.c.a) && (mVar2 instanceof d0.e0.p.d.m0.c.a)) ? areCallableDescriptorsEquivalent$default(this, (d0.e0.p.d.m0.c.a) mVar, (d0.e0.p.d.m0.c.a) mVar2, z2, z3, false, g.a.a, 16, null) : ((mVar instanceof e0) && (mVar2 instanceof e0)) ? d0.z.d.m.areEqual(((e0) mVar).getFqName(), ((e0) mVar2).getFqName()) : d0.z.d.m.areEqual(mVar, mVar2);
    }

    public final boolean b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2, Function2<? super d0.e0.p.d.m0.c.m, ? super d0.e0.p.d.m0.c.m, Boolean> function2, boolean z2) {
        d0.e0.p.d.m0.c.m containingDeclaration = mVar.getContainingDeclaration();
        d0.e0.p.d.m0.c.m containingDeclaration2 = mVar2.getContainingDeclaration();
        return ((containingDeclaration instanceof d0.e0.p.d.m0.c.b) || (containingDeclaration2 instanceof d0.e0.p.d.m0.c.b)) ? function2.invoke(containingDeclaration, containingDeclaration2).booleanValue() : areEquivalent$default(this, containingDeclaration, containingDeclaration2, z2, false, 8, null);
    }

    public final d0.e0.p.d.m0.c.u0 c(d0.e0.p.d.m0.c.a aVar) {
        while (aVar instanceof d0.e0.p.d.m0.c.b) {
            d0.e0.p.d.m0.c.b bVar = (d0.e0.p.d.m0.c.b) aVar;
            if (bVar.getKind() != b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
            d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            aVar = (d0.e0.p.d.m0.c.b) u.singleOrNull(overriddenDescriptors);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }
}
