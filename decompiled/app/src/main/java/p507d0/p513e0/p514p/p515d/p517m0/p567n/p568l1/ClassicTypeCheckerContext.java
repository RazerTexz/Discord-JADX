package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.IntegerLiteralTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a, reason: use source file name */
/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ClassicTypeCheckerContext extends AbstractTypeChecker3 implements ClassicTypeSystemContext {

    /* JADX INFO: renamed from: e */
    public static final a f24799e = new a(null);

    /* JADX INFO: renamed from: f */
    public final boolean f24800f;

    /* JADX INFO: renamed from: g */
    public final boolean f24801g;

    /* JADX INFO: renamed from: h */
    public final boolean f24802h;

    /* JADX INFO: renamed from: i */
    public final KotlinTypeRefiner f24803i;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a */
    /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
        public static final class C13337a extends AbstractTypeChecker3.b.a {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ ClassicTypeSystemContext f24804a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TypeSubstitutor2 f24805b;

            public C13337a(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor2 typeSubstitutor2) {
                this.f24804a = classicTypeSystemContext;
                this.f24805b = typeSubstitutor2;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3.b
            public InterfaceC11980i transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
                ClassicTypeSystemContext classicTypeSystemContext = this.f24804a;
                KotlinType kotlinTypeSafeSubstitute = this.f24805b.safeSubstitute((KotlinType) classicTypeSystemContext.lowerBoundIfFlexible(interfaceC11979h), Variance.INVARIANT);
                Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                InterfaceC11980i interfaceC11980iAsSimpleType = classicTypeSystemContext.asSimpleType(kotlinTypeSafeSubstitute);
                Intrinsics3.checkNotNull(interfaceC11980iAsSimpleType);
                return interfaceC11980iAsSimpleType;
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AbstractTypeChecker3.b.a classicSubstitutionSupertypePolicy(ClassicTypeSystemContext classicTypeSystemContext, InterfaceC11980i interfaceC11980i) {
            Intrinsics3.checkNotNullParameter(classicTypeSystemContext, "<this>");
            Intrinsics3.checkNotNullParameter(interfaceC11980i, "type");
            if (interfaceC11980i instanceof KotlinType4) {
                return new C13337a(classicTypeSystemContext, TypeSubstitution3.f24889b.create((KotlinType) interfaceC11980i).buildSubstitutor());
            }
            throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(interfaceC11980i).toString());
        }
    }

    public /* synthetic */ ClassicTypeCheckerContext(boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i & 2) != 0 ? true : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? KotlinTypeRefiner.a.f24807a : kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean areEqualTypeConstructors(InterfaceC11983l interfaceC11983l, InterfaceC11983l interfaceC11983l2) {
        Intrinsics3.checkNotNullParameter(interfaceC11983l, "c1");
        Intrinsics3.checkNotNullParameter(interfaceC11983l2, "c2");
        if (!(interfaceC11983l instanceof TypeConstructor)) {
            throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(interfaceC11983l).toString());
        }
        if (interfaceC11983l2 instanceof TypeConstructor) {
            return areEqualTypeConstructors((TypeConstructor) interfaceC11983l, (TypeConstructor) interfaceC11983l2);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(interfaceC11983l2).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public int argumentsCount(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.argumentsCount(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11981j asArgumentList(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.asArgumentList(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11974c asCapturedType(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.asCapturedType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11975d asDefinitelyNotNullType(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.asDefinitelyNotNullType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11976e asDynamicType(InterfaceC11977f interfaceC11977f) {
        return ClassicTypeSystemContext.a.asDynamicType(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11977f asFlexibleType(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.asFlexibleType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i asSimpleType(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.asSimpleType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11982k asTypeArgument(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.asTypeArgument(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i captureFromArguments(InterfaceC11980i interfaceC11980i, EnumC11973b enumC11973b) {
        return ClassicTypeSystemContext.a.captureFromArguments(this, interfaceC11980i, enumC11973b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11979h createFlexibleType(InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        return ClassicTypeSystemContext.a.createFlexibleType(this, interfaceC11980i, interfaceC11980i2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11982k getArgument(InterfaceC11979h interfaceC11979h, int i) {
        return ClassicTypeSystemContext.a.getArgument(this, interfaceC11979h, i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.getClassFqNameUnsafe(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11984m getParameter(InterfaceC11983l interfaceC11983l, int i) {
        return ClassicTypeSystemContext.a.getParameter(this, interfaceC11983l, i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.getPrimitiveArrayType(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.getPrimitiveType(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public InterfaceC11979h getRepresentativeUpperBound(InterfaceC11984m interfaceC11984m) {
        return ClassicTypeSystemContext.a.getRepresentativeUpperBound(this, interfaceC11984m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public InterfaceC11979h getSubstitutedUnderlyingType(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.getSubstitutedUnderlyingType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h getType(InterfaceC11982k interfaceC11982k) {
        return ClassicTypeSystemContext.a.getType(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public InterfaceC11984m getTypeParameterClassifier(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.getTypeParameterClassifier(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public EnumC11989r getVariance(InterfaceC11982k interfaceC11982k) {
        return ClassicTypeSystemContext.a.getVariance(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public boolean hasAnnotation(InterfaceC11979h interfaceC11979h, FqName fqName) {
        return ClassicTypeSystemContext.a.hasAnnotation(this, interfaceC11979h, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11988q
    public boolean identicalArguments(InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        return ClassicTypeSystemContext.a.identicalArguments(this, interfaceC11980i, interfaceC11980i2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h intersectTypes(List<? extends InterfaceC11979h> list) {
        return ClassicTypeSystemContext.a.intersectTypes(this, list);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isAnyConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isAnyConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isClassTypeConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isClassTypeConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isCommonFinalClassConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isCommonFinalClassConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isDenotable(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isDenotable(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isError(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.isError(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public boolean isErrorTypeEqualsToAnything() {
        return this.f24800f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public boolean isInlineClass(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isInlineClass(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isIntegerLiteralTypeConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isIntegerLiteralTypeConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isIntersection(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isIntersection(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isMarkedNullable(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.isMarkedNullable((ClassicTypeSystemContext) this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isNothingConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isNothingConstructor(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isNullableType(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.isNullableType(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isPrimitiveType(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.isPrimitiveType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isProjectionNotNull(InterfaceC11974c interfaceC11974c) {
        return ClassicTypeSystemContext.a.isProjectionNotNull(this, interfaceC11974c);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isStarProjection(InterfaceC11982k interfaceC11982k) {
        return ClassicTypeSystemContext.a.isStarProjection(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isStubType(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.isStubType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public boolean isStubTypeEqualsToAnything() {
        return this.f24801g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isUnderKotlinPackage(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i lowerBound(InterfaceC11977f interfaceC11977f) {
        return ClassicTypeSystemContext.a.lowerBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h lowerType(InterfaceC11974c interfaceC11974c) {
        return ClassicTypeSystemContext.a.lowerType(this, interfaceC11974c);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h makeDefinitelyNotNullOrNotNull(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.makeDefinitelyNotNullOrNotNull(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public InterfaceC11979h makeNullable(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.makeNullable(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i original(InterfaceC11975d interfaceC11975d) {
        return ClassicTypeSystemContext.a.original(this, interfaceC11975d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public int parametersCount(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.parametersCount(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public Collection<InterfaceC11979h> possibleIntegerTypes(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.possibleIntegerTypes(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public InterfaceC11979h prepareType(InterfaceC11979h interfaceC11979h) {
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
        if (interfaceC11979h instanceof KotlinType) {
            return NewKotlinTypeChecker.f24820b.getDefault().transformToNewType(((KotlinType) interfaceC11979h).unwrap());
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(interfaceC11979h).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public InterfaceC11979h refineType(InterfaceC11979h interfaceC11979h) {
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
        if (interfaceC11979h instanceof KotlinType) {
            return this.f24803i.refineType((KotlinType) interfaceC11979h);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContext2.access$errorMessage(interfaceC11979h).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public /* bridge */ /* synthetic */ AbstractTypeChecker3.b substitutionSupertypePolicy(InterfaceC11980i interfaceC11980i) {
        return substitutionSupertypePolicy(interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public Collection<InterfaceC11979h> supertypes(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.supertypes(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11983l typeConstructor(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.typeConstructor((ClassicTypeSystemContext) this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i upperBound(InterfaceC11977f interfaceC11977f) {
        return ClassicTypeSystemContext.a.upperBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11979h withNullability(InterfaceC11979h interfaceC11979h, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability(this, interfaceC11979h, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public EnumC11989r getVariance(InterfaceC11984m interfaceC11984m) {
        return ClassicTypeSystemContext.a.getVariance(this, interfaceC11984m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3
    public AbstractTypeChecker3.b.a substitutionSupertypePolicy(InterfaceC11980i interfaceC11980i) {
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "type");
        return f24799e.classicSubstitutionSupertypePolicy(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n, p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i withNullability(InterfaceC11980i interfaceC11980i, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability((ClassicTypeSystemContext) this, interfaceC11980i, z2);
    }

    public ClassicTypeCheckerContext(boolean z2, boolean z3, boolean z4, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f24800f = z2;
        this.f24801g = z3;
        this.f24802h = z4;
        this.f24803i = kotlinTypeRefiner;
    }

    public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "a");
        Intrinsics3.checkNotNullParameter(typeConstructor2, "b");
        return typeConstructor instanceof IntegerLiteralTypeConstructor ? ((IntegerLiteralTypeConstructor) typeConstructor).checkConstructor(typeConstructor2) : typeConstructor2 instanceof IntegerLiteralTypeConstructor ? ((IntegerLiteralTypeConstructor) typeConstructor2).checkConstructor(typeConstructor) : Intrinsics3.areEqual(typeConstructor, typeConstructor2);
    }
}
