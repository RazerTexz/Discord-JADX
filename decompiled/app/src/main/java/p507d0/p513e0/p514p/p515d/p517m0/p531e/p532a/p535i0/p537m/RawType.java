package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.f, reason: use source file name */
/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RawType extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b */
    public static final RawType f23432b = new RawType();

    /* JADX INFO: renamed from: c */
    public static final JavaTypeResolver f23433c;

    /* JADX INFO: renamed from: d */
    public static final JavaTypeResolver f23434d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.f$a */
    /* JADX INFO: compiled from: RawType.kt */
    public static final class a extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public final /* synthetic */ JavaTypeResolver $attr;
        public final /* synthetic */ ClassDescriptor $declaration;
        public final /* synthetic */ KotlinType4 $type;
        public final /* synthetic */ RawType this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ClassDescriptor classDescriptor, RawType rawType, KotlinType4 kotlinType4, JavaTypeResolver javaTypeResolver) {
            super(1);
            this.$declaration = classDescriptor;
            this.this$0 = rawType;
            this.$type = kotlinType4;
            this.$attr = javaTypeResolver;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType4 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            ClassDescriptor classDescriptorFindClassAcrossModuleDependencies;
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            ClassDescriptor classDescriptor = this.$declaration;
            if (!(classDescriptor instanceof ClassDescriptor)) {
                classDescriptor = null;
            }
            ClassId classId = classDescriptor == null ? null : DescriptorUtils2.getClassId(classDescriptor);
            if (classId == null || (classDescriptorFindClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics3.areEqual(classDescriptorFindClassAcrossModuleDependencies, this.$declaration)) {
                return null;
            }
            return (KotlinType4) RawType.access$eraseInflexibleBasedOnClassDescriptor(this.this$0, this.$type, classDescriptorFindClassAcrossModuleDependencies, this.$attr).getFirst();
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        f23433c = JavaTypeResolver5.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeResolver2.FLEXIBLE_LOWER_BOUND);
        f23434d = JavaTypeResolver5.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeResolver2.FLEXIBLE_UPPER_BOUND);
    }

    public static final /* synthetic */ Tuples2 access$eraseInflexibleBasedOnClassDescriptor(RawType rawType, KotlinType4 kotlinType4, ClassDescriptor classDescriptor, JavaTypeResolver javaTypeResolver) {
        return rawType.m9501a(kotlinType4, classDescriptor, javaTypeResolver);
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawType rawType, TypeParameterDescriptor typeParameterDescriptor, JavaTypeResolver javaTypeResolver, KotlinType kotlinType, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinType = JavaTypeResolver5.getErasedUpperBound$default(typeParameterDescriptor, null, null, 3, null);
        }
        return rawType.computeProjection(typeParameterDescriptor, javaTypeResolver, kotlinType);
    }

    /* JADX INFO: renamed from: a */
    public final Tuples2<KotlinType4, Boolean> m9501a(KotlinType4 kotlinType4, ClassDescriptor classDescriptor, JavaTypeResolver javaTypeResolver) {
        if (kotlinType4.getConstructor().getParameters().isEmpty()) {
            return Tuples.m10073to(kotlinType4, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(kotlinType4)) {
            TypeProjection typeProjection = kotlinType4.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "componentTypeProjection.type");
            List listListOf = CollectionsJVM.listOf(new TypeProjectionImpl(projectionKind, m9502b(type)));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            return Tuples.m10073to(KotlinTypeFactory.simpleType$default(kotlinType4.getAnnotations(), kotlinType4.getConstructor(), listListOf, kotlinType4.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        }
        if (KotlinType2.isError(kotlinType4)) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(Intrinsics3.stringPlus("Raw error type: ", kotlinType4.getConstructor()));
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return Tuples.m10073to(kotlinType4CreateErrorType, Boolean.FALSE);
        }
        MemberScope3 memberScope = classDescriptor.getMemberScope(this);
        Intrinsics3.checkNotNullExpressionValue(memberScope, "declaration.getMemberScope(RawSubstitution)");
        KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.f24748a;
        Annotations4 annotations = kotlinType4.getAnnotations();
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "declaration.typeConstructor");
        List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
            Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
            arrayList.add(computeProjection$default(this, typeParameterDescriptor, javaTypeResolver, null, 4, null));
        }
        return Tuples.m10073to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, kotlinType4.isMarkedNullable(), memberScope, new a(classDescriptor, this, kotlinType4, javaTypeResolver)), Boolean.TRUE);
    }

    /* JADX INFO: renamed from: b */
    public final KotlinType m9502b(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return m9502b(JavaTypeResolver5.getErasedUpperBound$default((TypeParameterDescriptor) declarationDescriptor, null, null, 3, null));
        }
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Unexpected declaration kind: ", declarationDescriptor).toString());
        }
        ClassifierDescriptor declarationDescriptor2 = flexibleTypes2.upperIfFlexible(kotlinType).getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor2 instanceof ClassDescriptor)) {
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + '\"').toString());
        }
        Tuples2<KotlinType4, Boolean> tuples2M9501a = m9501a(flexibleTypes2.lowerIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor, f23433c);
        KotlinType4 kotlinType4Component1 = tuples2M9501a.component1();
        boolean zBooleanValue = tuples2M9501a.component2().booleanValue();
        Tuples2<KotlinType4, Boolean> tuples2M9501a2 = m9501a(flexibleTypes2.upperIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor2, f23434d);
        KotlinType4 kotlinType4Component12 = tuples2M9501a2.component1();
        boolean zBooleanValue2 = tuples2M9501a2.component2().booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            return new RawType2(kotlinType4Component1, kotlinType4Component12);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.flexibleType(kotlinType4Component1, kotlinType4Component12);
    }

    public final TypeProjection computeProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeResolver javaTypeResolver, KotlinType kotlinType) {
        Variance variance = Variance.INVARIANT;
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "parameter");
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        Intrinsics3.checkNotNullParameter(kotlinType, "erasedUpperBound");
        int iOrdinal = javaTypeResolver.getFlexibility().ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new TypeProjectionImpl(variance, kotlinType);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
            return new TypeProjectionImpl(variance, DescriptorUtils2.getBuiltIns(typeParameterDescriptor).getNothingType());
        }
        List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "erasedUpperBound.constructor.parameters");
        return parameters.isEmpty() ^ true ? new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType) : JavaTypeResolver5.makeStarProjection(typeParameterDescriptor, javaTypeResolver);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public /* bridge */ /* synthetic */ TypeProjection get(KotlinType kotlinType) {
        return get(kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean isEmpty() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public TypeProjectionImpl get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        return new TypeProjectionImpl(m9502b(kotlinType));
    }
}
