package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.RawType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.RawType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: typeEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class typeEnhancement4 {

    /* renamed from: a */
    public final context3 f23445a;

    /* compiled from: typeEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.d$a */
    public static class a {

        /* renamed from: a */
        public final KotlinType f23446a;

        /* renamed from: b */
        public final int f23447b;

        /* renamed from: c */
        public final boolean f23448c;

        public a(KotlinType kotlinType, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.f23446a = kotlinType;
            this.f23447b = i;
            this.f23448c = z2;
        }

        public final int getSubtreeSize() {
            return this.f23447b;
        }

        public KotlinType getType() {
            return this.f23446a;
        }

        public final KotlinType getTypeIfChanged() {
            KotlinType type = getType();
            if (getWereChanges()) {
                return type;
            }
            return null;
        }

        public final boolean getWereChanges() {
            return this.f23448c;
        }
    }

    /* compiled from: typeEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.d$b */
    public static final class b extends a {

        /* renamed from: d */
        public final KotlinType4 f23449d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(KotlinType4 kotlinType4, int i, boolean z2) {
            super(kotlinType4, i, z2);
            Intrinsics3.checkNotNullParameter(kotlinType4, "type");
            this.f23449d = kotlinType4;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeEnhancement4.a
        public /* bridge */ /* synthetic */ KotlinType getType() {
            return getType();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeEnhancement4.a
        public KotlinType4 getType() {
            return this.f23449d;
        }
    }

    public typeEnhancement4(context3 context3Var) {
        Intrinsics3.checkNotNullParameter(context3Var, "javaResolverSettings");
        this.f23445a = context3Var;
    }

    /* renamed from: a */
    public final b m9506a(KotlinType4 kotlinType4, Function1<? super Integer, typeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z2) {
        int subtreeSize;
        TypeProjection typeProjectionCreateProjection;
        if (!TypeComponentPosition2.shouldEnhance(typeComponentPosition) && kotlinType4.getArguments().isEmpty()) {
            return new b(kotlinType4, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = kotlinType4.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(kotlinType4, 1, false);
        }
        typeQualifiers typequalifiersInvoke = function1.invoke(Integer.valueOf(i));
        typeEnhancement3 typeenhancement3Access$enhanceMutability = typeEnhancement6.access$enhanceMutability(declarationDescriptor, typequalifiersInvoke, typeComponentPosition);
        ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) typeenhancement3Access$enhanceMutability.component1();
        Annotations4 annotations4Component2 = typeenhancement3Access$enhanceMutability.component2();
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z3 = annotations4Component2 != null;
        List<TypeProjection> arguments = kotlinType4.getArguments();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                Collections2.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                subtreeSize = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).getNullability() != typeQualifiers3.NOT_NULL || z2) {
                    typeProjectionCreateProjection = TypeUtils.makeStarProjection(classifierDescriptor.getTypeConstructor().getParameters().get(i3));
                    Intrinsics3.checkNotNullExpressionValue(typeProjectionCreateProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    KotlinType kotlinTypeMakeNotNullable = TypeUtils2.makeNotNullable(typeProjection.getType().unwrap());
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics3.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    typeProjectionCreateProjection = TypeUtils2.createProjection(kotlinTypeMakeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
            } else {
                a aVarM9507b = m9507b(typeProjection.getType().unwrap(), function1, i2);
                z3 = z3 || aVarM9507b.getWereChanges();
                subtreeSize = aVarM9507b.getSubtreeSize() + i2;
                KotlinType type = aVarM9507b.getType();
                Variance projectionKind2 = typeProjection.getProjectionKind();
                Intrinsics3.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjectionCreateProjection = TypeUtils2.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            i2 = subtreeSize;
            arrayList.add(typeProjectionCreateProjection);
            i3 = i4;
        }
        typeEnhancement3 typeenhancement3Access$getEnhancedNullability = typeEnhancement6.access$getEnhancedNullability(kotlinType4, typequalifiersInvoke, typeComponentPosition);
        boolean zBooleanValue = ((Boolean) typeenhancement3Access$getEnhancedNullability.component1()).booleanValue();
        Annotations4 annotations4Component22 = typeenhancement3Access$getEnhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z3 || annotations4Component22 != null)) {
            return new b(kotlinType4, i5, false);
        }
        boolean z4 = false;
        Annotations4 annotations4Access$compositeAnnotationsOrSingle = typeEnhancement6.access$compositeAnnotationsOrSingle(Collections2.listOfNotNull((Object[]) new Annotations4[]{kotlinType4.getAnnotations(), annotations4Component2, annotations4Component22}));
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        KotlinType4 kotlinType4SimpleType$default = KotlinTypeFactory.simpleType$default(annotations4Access$compositeAnnotationsOrSingle, typeConstructor, arrayList, zBooleanValue, null, 16, null);
        KotlinType3 kotlinType3WrapEnhancement = kotlinType4SimpleType$default;
        if (typequalifiersInvoke.isNotNullTypeParameter()) {
            kotlinType3WrapEnhancement = this.f23445a.getCorrectNullabilityForNotNullTypeParameter() ? SpecialTypes5.makeSimpleTypeDefinitelyNotNullOrNotNull(kotlinType4SimpleType$default, true) : new typeEnhancement5(kotlinType4SimpleType$default);
        }
        if (annotations4Component22 != null && typequalifiersInvoke.isNullabilityQualifierForWarning()) {
            z4 = true;
        }
        if (z4) {
            kotlinType3WrapEnhancement = TypeWithEnhancement2.wrapEnhancement(kotlinType4, kotlinType3WrapEnhancement);
        }
        return new b((KotlinType4) kotlinType3WrapEnhancement, i5, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a m9507b(KotlinType3 kotlinType3, Function1<? super Integer, typeQualifiers> function1, int i) {
        KotlinType3 kotlinType3FlexibleType;
        if (KotlinType2.isError(kotlinType3)) {
            return new a(kotlinType3, 1, false);
        }
        if (!(kotlinType3 instanceof KotlinType6)) {
            if (kotlinType3 instanceof KotlinType4) {
                return m9506a((KotlinType4) kotlinType3, function1, i, TypeComponentPosition.INFLEXIBLE, false);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = kotlinType3 instanceof RawType3;
        KotlinType6 kotlinType6 = (KotlinType6) kotlinType3;
        b bVarM9506a = m9506a(kotlinType6.getLowerBound(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER, z2);
        b bVarM9506a2 = m9506a(kotlinType6.getUpperBound(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER, z2);
        bVarM9506a.getSubtreeSize();
        bVarM9506a2.getSubtreeSize();
        boolean z3 = bVarM9506a.getWereChanges() || bVarM9506a2.getWereChanges();
        KotlinType4 type = bVarM9506a.getType();
        KotlinType enhancement = TypeWithEnhancement2.getEnhancement(bVarM9506a2.getType());
        KotlinType enhancement2 = TypeWithEnhancement2.getEnhancement(type);
        if (enhancement2 != null) {
            if (enhancement != null) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                enhancement2 = KotlinTypeFactory.flexibleType(flexibleTypes2.lowerIfFlexible(enhancement2), flexibleTypes2.upperIfFlexible(enhancement));
            }
        } else if (enhancement == null) {
            enhancement2 = null;
        } else {
            enhancement2 = enhancement;
            if (enhancement != null) {
            }
        }
        if (z3) {
            if (kotlinType3 instanceof RawType2) {
                kotlinType3FlexibleType = new RawType2(bVarM9506a.getType(), bVarM9506a2.getType());
            } else {
                KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.f24748a;
                kotlinType3FlexibleType = KotlinTypeFactory.flexibleType(bVarM9506a.getType(), bVarM9506a2.getType());
            }
            kotlinType3 = TypeWithEnhancement2.wrapEnhancement(kotlinType3FlexibleType, enhancement2);
        }
        return new a(kotlinType3, bVarM9506a.getSubtreeSize(), z3);
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, typeQualifiers> function1) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "qualifiers");
        return m9507b(kotlinType.unwrap(), function1, 0).getTypeIfChanged();
    }
}
