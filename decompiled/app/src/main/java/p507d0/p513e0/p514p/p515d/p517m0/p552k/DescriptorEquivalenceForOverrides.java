package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import kotlin.jvm.functions.Function2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.b, reason: use source file name */
/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {

    /* JADX INFO: renamed from: a */
    public static final DescriptorEquivalenceForOverrides f24391a = new DescriptorEquivalenceForOverrides();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$a */
    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    public static final class a extends Lambda implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f24392j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            return Boolean.valueOf(invoke2(declarationDescriptor, declarationDescriptor2));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$b */
    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    public static final class b implements KotlinTypeChecker.a {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ boolean f24394b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ CallableDescriptor f24395c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ CallableDescriptor f24396d;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$b$a */
        /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
        public static final class a extends Lambda implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean> {

            /* JADX INFO: renamed from: $a */
            public final /* synthetic */ CallableDescriptor f24397$a;

            /* JADX INFO: renamed from: $b */
            public final /* synthetic */ CallableDescriptor f24398$b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                super(2);
                this.f24397$a = callableDescriptor;
                this.f24398$b = callableDescriptor2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                return Boolean.valueOf(invoke2(declarationDescriptor, declarationDescriptor2));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                return Intrinsics3.areEqual(declarationDescriptor, this.f24397$a) && Intrinsics3.areEqual(declarationDescriptor2, this.f24398$b);
            }
        }

        public b(boolean z2, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            this.f24394b = z2;
            this.f24395c = callableDescriptor;
            this.f24396d = callableDescriptor2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker.a
        public final boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "c1");
            Intrinsics3.checkNotNullParameter(typeConstructor2, "c2");
            if (Intrinsics3.areEqual(typeConstructor, typeConstructor2)) {
                return true;
            }
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
            if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
                return DescriptorEquivalenceForOverrides.access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides.this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, this.f24394b, new a(this.f24395c, this.f24396d));
            }
            return false;
        }
    }

    public static final /* synthetic */ boolean access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z2, Function2 function2) {
        return descriptorEquivalenceForOverrides.m9917a(typeParameterDescriptor, typeParameterDescriptor2, z2, function2);
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? false : z4, kotlinTypeRefiner);
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z2, z3);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9917a(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        if (Intrinsics3.areEqual(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        return !Intrinsics3.areEqual(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) && m9918b(typeParameterDescriptor, typeParameterDescriptor2, function2, z2) && typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex();
    }

    public final boolean areCallableDescriptorsEquivalent(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "a");
        Intrinsics3.checkNotNullParameter(callableDescriptor2, "b");
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (Intrinsics3.areEqual(callableDescriptor, callableDescriptor2)) {
            return true;
        }
        if (!Intrinsics3.areEqual(callableDescriptor.getName(), callableDescriptor2.getName())) {
            return false;
        }
        if (z3 && (callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
            return false;
        }
        if ((Intrinsics3.areEqual(callableDescriptor.getContainingDeclaration(), callableDescriptor2.getContainingDeclaration()) && (!z2 || !Intrinsics3.areEqual(m9919c(callableDescriptor), m9919c(callableDescriptor2)))) || DescriptorUtils.isLocal(callableDescriptor) || DescriptorUtils.isLocal(callableDescriptor2) || !m9918b(callableDescriptor, callableDescriptor2, a.f24392j, z2)) {
            return false;
        }
        OverridingUtil overridingUtilCreate = OverridingUtil.create(kotlinTypeRefiner, new b(z2, callableDescriptor, callableDescriptor2));
        Intrinsics3.checkNotNullExpressionValue(overridingUtilCreate, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
        OverridingUtil.d.a result = overridingUtilCreate.isOverridableBy(callableDescriptor, callableDescriptor2, null, !z4).getResult();
        OverridingUtil.d.a aVar = OverridingUtil.d.a.OVERRIDABLE;
        return result == aVar && overridingUtilCreate.isOverridableBy(callableDescriptor2, callableDescriptor, null, z4 ^ true).getResult() == aVar;
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z2, boolean z3) {
        return ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) ? Intrinsics3.areEqual(((ClassDescriptor) declarationDescriptor).getTypeConstructor(), ((ClassDescriptor) declarationDescriptor2).getTypeConstructor()) : ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) ? m9917a((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z2, DescriptorEquivalenceForOverrides2.f24399j) : ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) ? areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z2, z3, false, KotlinTypeRefiner.a.f24807a, 16, null) : ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? Intrinsics3.areEqual(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : Intrinsics3.areEqual(declarationDescriptor, declarationDescriptor2);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9918b(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z2) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        return ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) ? function2.invoke(containingDeclaration, containingDeclaration2).booleanValue() : areEquivalent$default(this, containingDeclaration, containingDeclaration2, z2, false, 8, null);
    }

    /* JADX INFO: renamed from: c */
    public final SourceElement m9919c(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) _Collections.singleOrNull(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }
}
