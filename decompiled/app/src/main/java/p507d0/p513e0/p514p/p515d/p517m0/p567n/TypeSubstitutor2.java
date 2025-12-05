package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations6;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations7;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewCapturedType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1.CapturedTypeApproximation2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.exceptionUtils;

/* compiled from: TypeSubstitutor.java */
/* renamed from: d0.e0.p.d.m0.n.c1, reason: use source file name */
/* loaded from: classes3.dex */
public class TypeSubstitutor2 {

    /* renamed from: a */
    public static final TypeSubstitutor2 f24745a = create(TypeSubstitution5.f24899a);

    /* renamed from: b */
    public final TypeSubstitution5 f24746b;

    /* compiled from: TypeSubstitutor.java */
    /* renamed from: d0.e0.p.d.m0.n.c1$a */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public TypeSubstitutor2(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            this.f24746b = typeSubstitution5;
        } else {
            m9998a(6);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9998a(int i) {
        String str;
        int i2;
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "substitutionContext";
                break;
            case 5:
                objArr[0] = "context";
                break;
            case 6:
            default:
                objArr[0] = "substitution";
                break;
            case 8:
            case 13:
                objArr[0] = "type";
                break;
            case 9:
            case 14:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 15:
            case 16:
            case 34:
                objArr[0] = "typeProjection";
                break;
            case 17:
            case 26:
                objArr[0] = "originalProjection";
                break;
            case 24:
                objArr[0] = "originalType";
                break;
            case 25:
                objArr[0] = "substituted";
                break;
            case 31:
                objArr[0] = "annotations";
                break;
            case 33:
            case 36:
                objArr[0] = "typeParameterVariance";
                break;
            case 37:
                objArr[0] = "projectionKind";
                break;
        }
        if (i == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i == 7) {
            objArr[1] = "getSubstitution";
        } else if (i == 32) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                break;
            case 2:
            case 3:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 4:
            case 5:
            default:
                objArr[2] = "create";
                break;
            case 6:
                objArr[2] = "<init>";
                break;
            case 8:
            case 9:
                objArr[2] = "safeSubstitute";
                break;
            case 13:
            case 14:
            case 15:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 17:
                objArr[2] = "unsafeSubstitute";
                break;
            case 24:
            case 25:
            case 26:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 31:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    /* renamed from: b */
    public static int m9999b(Variance variance, Variance variance2) {
        Variance variance3 = Variance.OUT_VARIANCE;
        Variance variance4 = Variance.IN_VARIANCE;
        if (variance == variance4 && variance2 == variance3) {
            return 3;
        }
        return (variance == variance3 && variance2 == variance4) ? 2 : 1;
    }

    /* renamed from: c */
    public static String m10000c(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (exceptionUtils.isProcessCanceledException(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public static Variance combine(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            m9998a(33);
            throw null;
        }
        if (typeProjection != null) {
            return typeProjection.isStarProjection() ? Variance.OUT_VARIANCE : combine(variance, typeProjection.getProjectionKind());
        }
        m9998a(34);
        throw null;
    }

    public static TypeSubstitutor2 create(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            return new TypeSubstitutor2(typeSubstitution5);
        }
        m9998a(0);
        throw null;
    }

    public static TypeSubstitutor2 createChainedSubstitutor(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution52) {
        if (typeSubstitution5 == null) {
            m9998a(2);
            throw null;
        }
        if (typeSubstitution52 != null) {
            return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution5, typeSubstitution52));
        }
        m9998a(3);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final TypeProjection m10001d(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor, int i) throws a {
        if (typeProjection == null) {
            m9998a(17);
            throw null;
        }
        TypeSubstitution5 typeSubstitution5 = this.f24746b;
        if (i > 100) {
            StringBuilder sbM833U = outline.m833U("Recursion too deep. Most likely infinite loop while substituting ");
            sbM833U.append(m10000c(typeProjection));
            sbM833U.append("; substitution: ");
            sbM833U.append(m10000c(typeSubstitution5));
            throw new IllegalStateException(sbM833U.toString());
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            KotlinType3 origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection typeProjectionM10001d = m10001d(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
            return new TypeProjectionImpl(typeProjectionM10001d.getProjectionKind(), TypeWithEnhancement2.wrapEnhancement(typeProjectionM10001d.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        }
        if (dynamicTypes2.isDynamic(type) || (type.unwrap() instanceof RawType3)) {
            return typeProjection;
        }
        TypeProjection typeProjectionImpl = this.f24746b.get(type);
        if (typeProjectionImpl == null) {
            typeProjectionImpl = null;
        } else if (type.getAnnotations().hasAnnotation(StandardNames.a.f22510G)) {
            TypeConstructor constructor = typeProjectionImpl.getType().getConstructor();
            if (constructor instanceof NewCapturedType2) {
                TypeProjection projection = ((NewCapturedType2) constructor).getProjection();
                Variance projectionKind = projection.getProjectionKind();
                if (m9999b(typeProjection.getProjectionKind(), projectionKind) == 3) {
                    typeProjectionImpl = new TypeProjectionImpl(projection.getType());
                } else if (typeParameterDescriptor != null && m9999b(typeParameterDescriptor.getVariance(), projectionKind) == 3) {
                    typeProjectionImpl = new TypeProjectionImpl(projection.getType());
                }
            }
        }
        Variance projectionKind2 = typeProjection.getProjectionKind();
        if (typeProjectionImpl == null && flexibleTypes2.isFlexible(type) && !TypeCapabilities2.isCustomTypeVariable(type)) {
            KotlinType6 kotlinType6AsFlexibleType = flexibleTypes2.asFlexibleType(type);
            int i2 = i + 1;
            TypeProjection typeProjectionM10001d2 = m10001d(new TypeProjectionImpl(projectionKind2, kotlinType6AsFlexibleType.getLowerBound()), typeParameterDescriptor, i2);
            TypeProjection typeProjectionM10001d3 = m10001d(new TypeProjectionImpl(projectionKind2, kotlinType6AsFlexibleType.getUpperBound()), typeParameterDescriptor, i2);
            return (typeProjectionM10001d2.getType() == kotlinType6AsFlexibleType.getLowerBound() && typeProjectionM10001d3.getType() == kotlinType6AsFlexibleType.getUpperBound()) ? typeProjection : new TypeProjectionImpl(typeProjectionM10001d2.getProjectionKind(), KotlinTypeFactory.flexibleType(TypeSubstitution.asSimpleType(typeProjectionM10001d2.getType()), TypeSubstitution.asSimpleType(typeProjectionM10001d3.getType())));
        }
        if (KotlinBuiltIns.isNothing(type) || KotlinType2.isError(type)) {
            return typeProjection;
        }
        if (typeProjectionImpl != null) {
            int iM9999b = m9999b(projectionKind2, typeProjectionImpl.getProjectionKind());
            if (!CapturedTypeConstructor4.isCaptured(type)) {
                int iM758h = C1563b.m758h(iM9999b);
                if (iM758h == 1) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                }
                if (iM758h == 2) {
                    throw new a("Out-projection in in-position");
                }
            }
            TypeCapabilities customTypeVariable = TypeCapabilities2.getCustomTypeVariable(type);
            if (typeProjectionImpl.isStarProjection()) {
                return typeProjectionImpl;
            }
            KotlinType kotlinTypeSubstitutionResult = customTypeVariable != null ? customTypeVariable.substitutionResult(typeProjectionImpl.getType()) : TypeUtils.makeNullableIfNeeded(typeProjectionImpl.getType(), type.isMarkedNullable());
            if (!type.getAnnotations().isEmpty()) {
                Annotations4 annotations4FilterAnnotations = this.f24746b.filterAnnotations(type.getAnnotations());
                if (annotations4FilterAnnotations == null) {
                    m9998a(31);
                    throw null;
                }
                if (annotations4FilterAnnotations.hasAnnotation(StandardNames.a.f22510G)) {
                    annotations4FilterAnnotations = new Annotations7(annotations4FilterAnnotations, new TypeSubstitutor());
                }
                kotlinTypeSubstitutionResult = TypeUtils2.replaceAnnotations(kotlinTypeSubstitutionResult, new Annotations6(kotlinTypeSubstitutionResult.getAnnotations(), annotations4FilterAnnotations));
            }
            if (iM9999b == 1) {
                projectionKind2 = combine(projectionKind2, typeProjectionImpl.getProjectionKind());
            }
            return new TypeProjectionImpl(projectionKind2, kotlinTypeSubstitutionResult);
        }
        Variance variance = Variance.INVARIANT;
        KotlinType type2 = typeProjection.getType();
        Variance projectionKind3 = typeProjection.getProjectionKind();
        if (type2.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        KotlinType4 abbreviation = SpecialTypes5.getAbbreviation(type2);
        KotlinType kotlinTypeSubstitute = abbreviation != null ? replaceWithNonApproximatingSubstitution().substitute(abbreviation, variance) : null;
        List<TypeParameterDescriptor> parameters = type2.getConstructor().getParameters();
        List<TypeProjection> arguments = type2.getArguments();
        ArrayList arrayList = new ArrayList(parameters.size());
        boolean z2 = false;
        for (int i3 = 0; i3 < parameters.size(); i3++) {
            TypeParameterDescriptor typeParameterDescriptor2 = parameters.get(i3);
            TypeProjection typeProjection2 = arguments.get(i3);
            TypeProjection typeProjectionM10001d4 = m10001d(typeProjection2, typeParameterDescriptor2, i + 1);
            int iM758h2 = C1563b.m758h(m9999b(typeParameterDescriptor2.getVariance(), typeProjectionM10001d4.getProjectionKind()));
            if (iM758h2 != 0) {
                if (iM758h2 == 1 || iM758h2 == 2) {
                    typeProjectionM10001d4 = TypeUtils.makeStarProjection(typeParameterDescriptor2);
                }
            } else if (typeParameterDescriptor2.getVariance() != variance && !typeProjectionM10001d4.isStarProjection()) {
                typeProjectionM10001d4 = new TypeProjectionImpl(variance, typeProjectionM10001d4.getType());
            }
            if (typeProjectionM10001d4 != typeProjection2) {
                z2 = true;
            }
            arrayList.add(typeProjectionM10001d4);
        }
        if (z2) {
            arguments = arrayList;
        }
        KotlinType kotlinTypeReplace = TypeSubstitution.replace(type2, arguments, this.f24746b.filterAnnotations(type2.getAnnotations()));
        if ((kotlinTypeReplace instanceof KotlinType4) && (kotlinTypeSubstitute instanceof KotlinType4)) {
            kotlinTypeReplace = SpecialTypes5.withAbbreviation((KotlinType4) kotlinTypeReplace, (KotlinType4) kotlinTypeSubstitute);
        }
        return new TypeProjectionImpl(projectionKind3, kotlinTypeReplace);
    }

    public TypeSubstitution5 getSubstitution() {
        TypeSubstitution5 typeSubstitution5 = this.f24746b;
        if (typeSubstitution5 != null) {
            return typeSubstitution5;
        }
        m9998a(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.f24746b.isEmpty();
    }

    public TypeSubstitutor2 replaceWithNonApproximatingSubstitution() {
        TypeSubstitution5 typeSubstitution5 = this.f24746b;
        return ((typeSubstitution5 instanceof TypeSubstitution4) && typeSubstitution5.approximateContravariantCapturedTypes()) ? new TypeSubstitutor2(new TypeSubstitution4(((TypeSubstitution4) this.f24746b).getParameters(), ((TypeSubstitution4) this.f24746b).getArguments(), false)) : this;
    }

    public KotlinType safeSubstitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            m9998a(8);
            throw null;
        }
        if (variance == null) {
            m9998a(9);
            throw null;
        }
        if (isEmpty()) {
            if (kotlinType != null) {
                return kotlinType;
            }
            m9998a(10);
            throw null;
        }
        try {
            KotlinType type = m10001d(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
            if (type != null) {
                return type;
            }
            m9998a(11);
            throw null;
        } catch (a e) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(e.getMessage());
            if (kotlinType4CreateErrorType != null) {
                return kotlinType4CreateErrorType;
            }
            m9998a(12);
            throw null;
        }
    }

    public KotlinType substitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            m9998a(13);
            throw null;
        }
        if (variance == null) {
            m9998a(14);
            throw null;
        }
        TypeProjection typeProjectionSubstitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (typeProjectionSubstitute == null) {
            return null;
        }
        return typeProjectionSubstitute.getType();
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            m9998a(16);
            throw null;
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return m10001d(typeProjection, null, 0);
        } catch (a unused) {
            return null;
        }
    }

    public static TypeSubstitutor2 create(KotlinType kotlinType) {
        if (kotlinType != null) {
            return create(TypeSubstitution3.create(kotlinType.getConstructor(), kotlinType.getArguments()));
        }
        m9998a(5);
        throw null;
    }

    public static Variance combine(Variance variance, Variance variance2) {
        if (variance == null) {
            m9998a(36);
            throw null;
        }
        if (variance2 != null) {
            Variance variance3 = Variance.INVARIANT;
            if (variance == variance3) {
                if (variance2 != null) {
                    return variance2;
                }
                m9998a(38);
                throw null;
            }
            if (variance2 == variance3) {
                if (variance != null) {
                    return variance;
                }
                m9998a(39);
                throw null;
            }
            if (variance == variance2) {
                if (variance2 != null) {
                    return variance2;
                }
                m9998a(40);
                throw null;
            }
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
        m9998a(37);
        throw null;
    }

    public TypeProjection substitute(TypeProjection typeProjection) {
        if (typeProjection != null) {
            TypeProjection typeProjectionSubstituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
            return (this.f24746b.approximateCapturedTypes() || this.f24746b.approximateContravariantCapturedTypes()) ? CapturedTypeApproximation2.approximateCapturedTypesIfNecessary(typeProjectionSubstituteWithoutApproximation, this.f24746b.approximateContravariantCapturedTypes()) : typeProjectionSubstituteWithoutApproximation;
        }
        m9998a(15);
        throw null;
    }
}
