package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.IntegerLiteralTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeAliasExpansionReportStrategy;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory {

    /* JADX INFO: renamed from: a */
    public static final KotlinTypeFactory f24748a = new KotlinTypeFactory();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$a */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final a f24749j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((KotlinTypeRefiner) obj);
        }

        public final Void invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "$noName_0");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$b */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final KotlinType4 f24750a;

        /* JADX INFO: renamed from: b */
        public final TypeConstructor f24751b;

        public b(KotlinType4 kotlinType4, TypeConstructor typeConstructor) {
            this.f24750a = kotlinType4;
            this.f24751b = typeConstructor;
        }

        public final KotlinType4 getExpandedType() {
            return this.f24750a;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.f24751b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$c */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class c extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public final /* synthetic */ Annotations4 $annotations;
        public final /* synthetic */ List<TypeProjection> $arguments;
        public final /* synthetic */ TypeConstructor $constructor;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations4 annotations4, boolean z2) {
            super(1);
            this.$constructor = typeConstructor;
            this.$arguments = list;
            this.$annotations = annotations4;
            this.$nullable = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType4 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "refiner");
            b bVarAccess$refineConstructor = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.this, this.$constructor, kotlinTypeRefiner, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            KotlinType4 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            Annotations4 annotations4 = this.$annotations;
            TypeConstructor refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            Intrinsics3.checkNotNull(refinedConstructor);
            return KotlinTypeFactory.simpleType(annotations4, refinedConstructor, this.$arguments, this.$nullable, kotlinTypeRefiner);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$d */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class d extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public final /* synthetic */ Annotations4 $annotations;
        public final /* synthetic */ List<TypeProjection> $arguments;
        public final /* synthetic */ TypeConstructor $constructor;
        public final /* synthetic */ MemberScope3 $memberScope;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations4 annotations4, boolean z2, MemberScope3 memberScope3) {
            super(1);
            this.$constructor = typeConstructor;
            this.$arguments = list;
            this.$annotations = annotations4;
            this.$nullable = z2;
            this.$memberScope = memberScope3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType4 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            b bVarAccess$refineConstructor = KotlinTypeFactory.access$refineConstructor(KotlinTypeFactory.this, this.$constructor, kotlinTypeRefiner, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            KotlinType4 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            Annotations4 annotations4 = this.$annotations;
            TypeConstructor refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            Intrinsics3.checkNotNull(refinedConstructor);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations4, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    static {
        a aVar = a.f24749j;
    }

    public static final b access$refineConstructor(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List list) {
        b bVar;
        Objects.requireNonNull(kotlinTypeFactory);
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptorRefineDescriptor = declarationDescriptor == null ? null : kotlinTypeRefiner.refineDescriptor(declarationDescriptor);
        if (classifierDescriptorRefineDescriptor == null) {
            return null;
        }
        if (classifierDescriptorRefineDescriptor instanceof TypeAliasDescriptor) {
            bVar = new b(computeExpandedType((TypeAliasDescriptor) classifierDescriptorRefineDescriptor, list), null);
        } else {
            TypeConstructor typeConstructorRefine = classifierDescriptorRefineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
            Intrinsics3.checkNotNullExpressionValue(typeConstructorRefine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
            bVar = new b(null, typeConstructorRefine);
        }
        return bVar;
    }

    public static final KotlinType4 computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
        Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.a.f24876a, false).expand(TypeAliasExpansion.f24866a.create(null, typeAliasDescriptor, list), Annotations4.f22735f.getEMPTY());
    }

    public static final KotlinType3 flexibleType(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
        return Intrinsics3.areEqual(kotlinType4, kotlinType42) ? kotlinType4 : new flexibleTypes(kotlinType4, kotlinType42);
    }

    public static final KotlinType4 integerLiteralType(Annotations4 annotations4, IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z2) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        List listEmptyList = Collections2.emptyList();
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(annotations4, integerLiteralTypeConstructor, listEmptyList, z2, memberScope3CreateErrorScope);
    }

    public static final KotlinType4 simpleNotNullType(Annotations4 annotations4, ClassDescriptor classDescriptor, List<? extends TypeProjection> list) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(annotations4, typeConstructor, list, false, null, 16, null);
    }

    public static final KotlinType4 simpleType(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, KotlinTypeRefiner kotlinTypeRefiner) {
        MemberScope3 memberScope3CreateScopeForKotlinType;
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        if (annotations4.isEmpty() && list.isEmpty() && !z2 && typeConstructor.getDeclarationDescriptor() != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            Intrinsics3.checkNotNull(declarationDescriptor);
            KotlinType4 defaultType = declarationDescriptor.getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        KotlinTypeFactory kotlinTypeFactory = f24748a;
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof TypeParameterDescriptor) {
            memberScope3CreateScopeForKotlinType = declarationDescriptor2.getDefaultType().getMemberScope();
        } else if (declarationDescriptor2 instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils2.getModule(declarationDescriptor2));
            }
            memberScope3CreateScopeForKotlinType = list.isEmpty() ? ModuleAwareClassDescriptor2.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor2, kotlinTypeRefiner) : ModuleAwareClassDescriptor2.getRefinedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor2, TypeSubstitution3.f24889b.create(typeConstructor, list), kotlinTypeRefiner);
        } else if (declarationDescriptor2 instanceof TypeAliasDescriptor) {
            memberScope3CreateScopeForKotlinType = ErrorUtils.createErrorScope(Intrinsics3.stringPlus("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor2).getName()), true);
            Intrinsics3.checkNotNullExpressionValue(memberScope3CreateScopeForKotlinType, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
        } else {
            if (!(typeConstructor instanceof IntersectionTypeConstructor)) {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor2 + " for constructor: " + typeConstructor);
            }
            memberScope3CreateScopeForKotlinType = ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        }
        return simpleTypeWithNonTrivialMemberScope(annotations4, typeConstructor, list, z2, memberScope3CreateScopeForKotlinType, kotlinTypeFactory.new c(typeConstructor, list, annotations4, z2));
    }

    public static /* synthetic */ KotlinType4 simpleType$default(Annotations4 annotations4, TypeConstructor typeConstructor, List list, boolean z2, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(annotations4, typeConstructor, list, z2, kotlinTypeRefiner);
    }

    public static final KotlinType4 simpleTypeWithNonTrivialMemberScope(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        KotlinTypeFactory5 kotlinTypeFactory5 = new KotlinTypeFactory5(typeConstructor, list, z2, memberScope3, f24748a.new d(typeConstructor, list, annotations4, z2, memberScope3));
        return annotations4.isEmpty() ? kotlinTypeFactory5 : new KotlinTypeFactory3(kotlinTypeFactory5, annotations4);
    }

    public static final KotlinType4 simpleTypeWithNonTrivialMemberScope(Annotations4 annotations4, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3, Function1<? super KotlinTypeRefiner, ? extends KotlinType4> function1) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(function1, "refinedTypeFactory");
        KotlinTypeFactory5 kotlinTypeFactory5 = new KotlinTypeFactory5(typeConstructor, list, z2, memberScope3, function1);
        return annotations4.isEmpty() ? kotlinTypeFactory5 : new KotlinTypeFactory3(kotlinTypeFactory5, annotations4);
    }
}
