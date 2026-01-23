package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.p, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker4 implements ClassicTypeSystemContext {

    /* JADX INFO: renamed from: a */
    public static final NewKotlinTypeChecker4 f24827a = new NewKotlinTypeChecker4();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean areEqualTypeConstructors(InterfaceC11983l interfaceC11983l, InterfaceC11983l interfaceC11983l2) {
        return ClassicTypeSystemContext.a.areEqualTypeConstructors(this, interfaceC11983l, interfaceC11983l2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public int argumentsCount(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.argumentsCount(this, interfaceC11979h);
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i asSimpleType(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.asSimpleType(this, interfaceC11979h);
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
    public boolean isClassTypeConstructor(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isClassTypeConstructor(this, interfaceC11983l);
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
    public boolean isMarkedNullable(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.isMarkedNullable(this, interfaceC11979h);
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
    public boolean isStarProjection(InterfaceC11982k interfaceC11982k) {
        return ClassicTypeSystemContext.a.isStarProjection(this, interfaceC11982k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(InterfaceC11983l interfaceC11983l) {
        return ClassicTypeSystemContext.a.isUnderKotlinPackage(this, interfaceC11983l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i lowerBound(InterfaceC11977f interfaceC11977f) {
        return ClassicTypeSystemContext.a.lowerBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i lowerBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.lowerBoundIfFlexible(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext
    public InterfaceC11979h makeNullable(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.makeNullable(this, interfaceC11979h);
    }

    public AbstractTypeChecker3 newBaseTypeCheckerContext(boolean z2, boolean z3) {
        return ClassicTypeSystemContext.a.newBaseTypeCheckerContext(this, z2, z3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11983l typeConstructor(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.typeConstructor(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i upperBound(InterfaceC11977f interfaceC11977f) {
        return ClassicTypeSystemContext.a.upperBound(this, interfaceC11977f);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i upperBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return ClassicTypeSystemContext.a.upperBoundIfFlexible(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11980i withNullability(InterfaceC11980i interfaceC11980i, boolean z2) {
        return ClassicTypeSystemContext.a.withNullability((ClassicTypeSystemContext) this, interfaceC11980i, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isMarkedNullable(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.isMarkedNullable((ClassicTypeSystemContext) this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeSystemContext
    public InterfaceC11983l typeConstructor(InterfaceC11980i interfaceC11980i) {
        return ClassicTypeSystemContext.a.typeConstructor((ClassicTypeSystemContext) this, interfaceC11980i);
    }
}
