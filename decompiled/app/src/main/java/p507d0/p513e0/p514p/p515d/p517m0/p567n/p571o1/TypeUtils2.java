package p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.StarProjectionImpl2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a, reason: use source file name */
/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeUtils2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a$a */
    /* JADX INFO: compiled from: TypeUtils.kt */
    public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f24850j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
            return Boolean.valueOf(invoke2(kotlinType3));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "it");
            ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return false;
            }
            return TypeUtils2.isTypeAliasParameter(declarationDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a$b */
    /* JADX INFO: compiled from: TypeUtils.kt */
    public static final class b extends Lambda implements Function1<KotlinType3, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f24851j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
            return Boolean.valueOf(invoke2(kotlinType3));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "it");
            ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return false;
            }
            return (declarationDescriptor instanceof TypeAliasDescriptor) || (declarationDescriptor instanceof TypeParameterDescriptor);
        }
    }

    public static final TypeProjection asTypeProjection(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(KotlinType kotlinType, Function1<? super KotlinType3, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return TypeUtils.contains(kotlinType, function1);
    }

    public static final boolean containsTypeAliasParameters(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, a.f24850j);
    }

    public static final TypeProjection createProjection(KotlinType kotlinType, Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        Intrinsics3.checkNotNullParameter(variance, "projectionKind");
        if ((typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance()) == variance) {
            variance = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics3.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ClassifierDescriptor declarationDescriptor = ((KotlinType) next).getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            boolean z2 = false;
            if (classDescriptor != null && classDescriptor.getKind() != ClassKind.INTERFACE && classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
                z2 = true;
            }
            if (z2) {
                obj = next;
                break;
            }
        }
        KotlinType kotlinType = (KotlinType) obj;
        if (kotlinType != null) {
            return kotlinType;
        }
        List<KotlinType> upperBounds3 = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds3, "upperBounds");
        Object objFirst = _Collections.first((List<? extends Object>) upperBounds3);
        Intrinsics3.checkNotNullExpressionValue(objFirst, "upperBounds.first()");
        return (KotlinType) objFirst;
    }

    public static final boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinType2, "superType");
        return KotlinTypeChecker.f24806a.isSubtypeOf(kotlinType, kotlinType2);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor classifierDescriptor) {
        Intrinsics3.checkNotNullParameter(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean isTypeParameter(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final KotlinType makeNotNullable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType kotlinTypeMakeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(this)");
        return kotlinTypeMakeNotNullable;
    }

    public static final KotlinType makeNullable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType kotlinTypeMakeNullable = TypeUtils.makeNullable(kotlinType);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNullable, "makeNullable(this)");
        return kotlinTypeMakeNullable;
    }

    public static final KotlinType replaceAnnotations(KotlinType kotlinType, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return (kotlinType.getAnnotations().isEmpty() && annotations4.isEmpty()) ? kotlinType : kotlinType.unwrap().replaceAnnotations(annotations4);
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType kotlinType) {
        KotlinType3 kotlinType3Replace$default;
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            KotlinType6 kotlinType6 = (KotlinType6) kotlinType3Unwrap;
            KotlinType4 lowerBound = kotlinType6.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new StarProjectionImpl2((TypeParameterDescriptor) it.next()));
                }
                lowerBound = TypeSubstitution.replace$default(lowerBound, arrayList, null, 2, null);
            }
            KotlinType4 upperBound = kotlinType6.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters2, 10));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new StarProjectionImpl2((TypeParameterDescriptor) it2.next()));
                }
                upperBound = TypeSubstitution.replace$default(upperBound, arrayList2, null, 2, null);
            }
            kotlinType3Replace$default = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else {
            if (!(kotlinType3Unwrap instanceof KotlinType4)) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinType4 kotlinType4 = (KotlinType4) kotlinType3Unwrap;
            boolean zIsEmpty = kotlinType4.getConstructor().getParameters().isEmpty();
            kotlinType3Replace$default = kotlinType4;
            if (!zIsEmpty) {
                ClassifierDescriptor declarationDescriptor = kotlinType4.getConstructor().getDeclarationDescriptor();
                kotlinType3Replace$default = kotlinType4;
                if (declarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = kotlinType4.getConstructor().getParameters();
                    Intrinsics3.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters3, 10));
                    Iterator<T> it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new StarProjectionImpl2((TypeParameterDescriptor) it3.next()));
                    }
                    kotlinType3Replace$default = TypeSubstitution.replace$default(kotlinType4, arrayList3, null, 2, null);
                }
            }
        }
        return TypeWithEnhancement2.inheritEnhancement(kotlinType3Replace$default, kotlinType3Unwrap);
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, b.f24851j);
    }
}
