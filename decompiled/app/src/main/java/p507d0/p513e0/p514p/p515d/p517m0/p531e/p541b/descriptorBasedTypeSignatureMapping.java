package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.functionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.suspendFunctionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.inlineClassesUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.IntersectionTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.expandedTypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.functions;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.d, reason: use source file name */
/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class descriptorBasedTypeSignatureMapping {
    public static final String computeInternalName(ClassDescriptor classDescriptor, descriptorBasedTypeSignatureMapping2<?> descriptorbasedtypesignaturemapping2) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "klass");
        Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = descriptorbasedtypesignaturemapping2.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = SpecialNames.safeIdentifier(classDescriptor.getName()).getIdentifier();
        Intrinsics3.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String strAsString = fqName.asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            sb.append(StringsJVM.replace$default(strAsString, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null));
            sb.append(MentionUtils.SLASH_CHAR);
            sb.append(identifier);
            return sb.toString();
        }
        ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
        }
        String predefinedInternalNameForClass = descriptorbasedtypesignaturemapping2.getPredefinedInternalNameForClass(classDescriptor2);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(classDescriptor2, descriptorbasedtypesignaturemapping2);
        }
        return predefinedInternalNameForClass + '$' + identifier;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, descriptorBasedTypeSignatureMapping2 descriptorbasedtypesignaturemapping2, int i, Object obj) {
        if ((i & 2) != 0) {
            descriptorbasedtypesignaturemapping2 = methodSignatureMapping4.f23637a;
        }
        return computeInternalName(classDescriptor, descriptorbasedtypesignaturemapping2);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            Intrinsics3.checkNotNull(returnType2);
            if (!TypeUtils.isNullableType(returnType2) && !(callableDescriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, typeSignatureMapping3<T> typesignaturemapping3, TypeMappingMode typeMappingMode, descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2, typeSignatureMapping2<T> typesignaturemapping2, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> function3) {
        T t;
        KotlinType kotlinType2;
        Object objMapType;
        Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics3.checkNotNullParameter(typesignaturemapping3, "factory");
        Intrinsics3.checkNotNullParameter(typeMappingMode, "mode");
        Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "typeMappingConfiguration");
        Intrinsics3.checkNotNullParameter(function3, "writeGenericType");
        KotlinType kotlinTypePreprocessType = descriptorbasedtypesignaturemapping2.preprocessType(kotlinType);
        if (kotlinTypePreprocessType != null) {
            return (T) mapType(kotlinTypePreprocessType, typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
        }
        if (functionTypes.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(suspendFunctionTypes.transformSuspendFunctionToRuntimeFunctionType(kotlinType, descriptorbasedtypesignaturemapping2.releaseCoroutines()), typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
        }
        NewKotlinTypeChecker4 newKotlinTypeChecker4 = NewKotlinTypeChecker4.f24827a;
        Object objMapBuiltInType = typeSignatureMapping.mapBuiltInType(newKotlinTypeChecker4, kotlinType, typesignaturemapping3, typeMappingMode);
        if (objMapBuiltInType != null) {
            ?? r11 = (Object) typeSignatureMapping.boxTypeIfNeeded(typesignaturemapping3, objMapBuiltInType, typeMappingMode.getNeedPrimitiveBoxing());
            function3.invoke(kotlinType, r11, typeMappingMode);
            return r11;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = descriptorbasedtypesignaturemapping2.commonSupertype(intersectionTypeConstructor.getSupertypes());
            }
            return (T) mapType(TypeUtils2.replaceArgumentsWithStarProjections(alternativeType), typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
        }
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            throw new UnsupportedOperationException(Intrinsics3.stringPlus("no descriptor for type constructor of ", kotlinType));
        }
        if (ErrorUtils.isError(declarationDescriptor)) {
            T t2 = (T) typesignaturemapping3.createObjectType("error/NonExistentClass");
            descriptorbasedtypesignaturemapping2.processErrorType(kotlinType, (ClassDescriptor) declarationDescriptor);
            if (typesignaturemapping2 == null) {
                return t2;
            }
            throw null;
        }
        boolean z2 = declarationDescriptor instanceof ClassDescriptor;
        if (z2 && KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection typeProjection = kotlinType.getArguments().get(0);
            KotlinType type = typeProjection.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "memberProjection.type");
            if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                objMapType = typesignaturemapping3.createObjectType("java/lang/Object");
                if (typesignaturemapping2 != null) {
                    throw null;
                }
            } else {
                if (typesignaturemapping2 != null) {
                    throw null;
                }
                Variance projectionKind = typeProjection.getProjectionKind();
                Intrinsics3.checkNotNullExpressionValue(projectionKind, "memberProjection.projectionKind");
                objMapType = mapType(type, typesignaturemapping3, typeMappingMode.toGenericArgumentMode(projectionKind, true), descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
                if (typesignaturemapping2 != null) {
                    throw null;
                }
            }
            return (T) typesignaturemapping3.createFromString(Intrinsics3.stringPlus("[", typesignaturemapping3.toString(objMapType)));
        }
        if (!z2) {
            if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                if ((declarationDescriptor instanceof TypeAliasDescriptor) && typeMappingMode.getMapTypeAliases()) {
                    return (T) mapType(((TypeAliasDescriptor) declarationDescriptor).getExpandedType(), typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
                }
                throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unknown type ", kotlinType));
            }
            T t3 = (T) mapType(TypeUtils2.getRepresentativeUpperBound((TypeParameterDescriptor) declarationDescriptor), typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, null, functions.getDO_NOTHING_3());
            if (typesignaturemapping2 == null) {
                return t3;
            }
            Intrinsics3.checkNotNullExpressionValue(declarationDescriptor.getName(), "descriptor.getName()");
            throw null;
        }
        if (inlineClassesUtils.isInlineClass(declarationDescriptor) && !typeMappingMode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) expandedTypeUtils.computeExpandedTypeForInlineClass(newKotlinTypeChecker4, kotlinType)) != null) {
            return (T) mapType(kotlinType2, typesignaturemapping3, typeMappingMode.wrapInlineClassesMode(), descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
        }
        if (typeMappingMode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) declarationDescriptor)) {
            t = (Object) typesignaturemapping3.getJavaLangClassType();
        } else {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            ClassDescriptor original = classDescriptor.getOriginal();
            Intrinsics3.checkNotNullExpressionValue(original, "descriptor.original");
            T predefinedTypeForClass = descriptorbasedtypesignaturemapping2.getPredefinedTypeForClass(original);
            if (predefinedTypeForClass == null) {
                if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                    classDescriptor = (ClassDescriptor) classDescriptor.getContainingDeclaration();
                }
                ClassDescriptor original2 = classDescriptor.getOriginal();
                Intrinsics3.checkNotNullExpressionValue(original2, "enumClassIfEnumEntry.original");
                t = (Object) typesignaturemapping3.createObjectType(computeInternalName(original2, descriptorbasedtypesignaturemapping2));
            } else {
                t = (Object) predefinedTypeForClass;
            }
        }
        function3.invoke(kotlinType, t, typeMappingMode);
        return t;
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, typeSignatureMapping3 typesignaturemapping3, TypeMappingMode typeMappingMode, descriptorBasedTypeSignatureMapping2 descriptorbasedtypesignaturemapping2, typeSignatureMapping2 typesignaturemapping2, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = functions.getDO_NOTHING_3();
        }
        return mapType(kotlinType, typesignaturemapping3, typeMappingMode, descriptorbasedtypesignaturemapping2, typesignaturemapping2, function3);
    }
}
