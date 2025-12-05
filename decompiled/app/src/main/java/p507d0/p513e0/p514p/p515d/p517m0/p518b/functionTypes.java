package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.FunctionClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.BuiltInAnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: functionTypes.kt */
/* renamed from: d0.e0.p.d.m0.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class functionTypes {
    public static final KotlinType4 createFunctionType(KotlinBuiltIns kotlinBuiltIns, Annotations4 annotations4, KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(list, "parameterTypes");
        Intrinsics3.checkNotNullParameter(kotlinType2, "returnType");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, list, list2, kotlinType2, kotlinBuiltIns);
        int size = list.size();
        if (kotlinType != null) {
            size++;
        }
        ClassDescriptor functionDescriptor = getFunctionDescriptor(kotlinBuiltIns, size, z2);
        if (kotlinType != null) {
            annotations4 = withExtensionFunctionAnnotation(annotations4, kotlinBuiltIns);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.simpleNotNullType(annotations4, functionDescriptor, functionTypeArgumentProjections);
    }

    public static /* synthetic */ KotlinType4 createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations4 annotations4, KotlinType kotlinType, List list, List list2, KotlinType kotlinType2, boolean z2, int i, Object obj) {
        return createFunctionType(kotlinBuiltIns, annotations4, kotlinType, list, list2, kotlinType2, (i & 64) != 0 ? false : z2);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType kotlinType) {
        String value;
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        AnnotationDescriptor annotationDescriptorFindAnnotation = kotlinType.getAnnotations().findAnnotation(StandardNames.a.f22570y);
        if (annotationDescriptorFindAnnotation == null) {
            return null;
        }
        Object objSingleOrNull = _Collections.singleOrNull(annotationDescriptorFindAnnotation.getAllValueArguments().values());
        C11831w c11831w = objSingleOrNull instanceof C11831w ? (C11831w) objSingleOrNull : null;
        if (c11831w == null || (value = c11831w.getValue()) == null || !Name.isValidIdentifier(value)) {
            value = null;
        }
        if (value == null) {
            return null;
        }
        return Name.identifier(value);
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns kotlinBuiltIns, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        ClassDescriptor suspendFunction = z2 ? kotlinBuiltIns.getSuspendFunction(i) : kotlinBuiltIns.getFunction(i);
        Intrinsics3.checkNotNullExpressionValue(suspendFunction, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return suspendFunction;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, KotlinBuiltIns kotlinBuiltIns) {
        Name name;
        Intrinsics3.checkNotNullParameter(list, "parameterTypes");
        Intrinsics3.checkNotNullParameter(kotlinType2, "returnType");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (kotlinType != null ? 1 : 0) + 1);
        collections.addIfNotNull(arrayList, kotlinType == null ? null : TypeUtils2.asTypeProjection(kotlinType));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            KotlinType kotlinTypeReplaceAnnotations = (KotlinType) obj;
            if (list2 == null || (name = list2.get(i)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                FqName fqName = StandardNames.a.f22570y;
                Name nameIdentifier = Name.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME);
                String strAsString = name.asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
                kotlinTypeReplaceAnnotations = TypeUtils2.replaceAnnotations(kotlinTypeReplaceAnnotations, Annotations4.f22735f.create(_Collections.plus(kotlinTypeReplaceAnnotations.getAnnotations(), new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsJVM.mapOf(Tuples.m10073to(nameIdentifier, new C11831w(strAsString)))))));
            }
            arrayList.add(TypeUtils2.asTypeProjection(kotlinTypeReplaceAnnotations));
            i = i2;
        }
        arrayList.add(TypeUtils2.asTypeProjection(kotlinType2));
        return arrayList;
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        if (!(declarationDescriptor instanceof ClassDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtils2.getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        FunctionClassKind.a aVar = FunctionClassKind.f22601j;
        String strAsString = fqNameUnsafe.shortName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "shortName().asString()");
        FqName fqNameParent = fqNameUnsafe.toSafe().parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "toSafe().parent()");
        return aVar.getFunctionalClassKind(strAsString, fqNameParent);
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        if (kotlinType.getAnnotations().findAnnotation(StandardNames.a.f22569x) != null) {
            return ((TypeProjection) _Collections.first((List) kotlinType.getArguments())).getType();
        }
        return null;
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        KotlinType type = ((TypeProjection) _Collections.last((List) kotlinType.getArguments())).getType();
        Intrinsics3.checkNotNullExpressionValue(type, "arguments.last().type");
        return type;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        return kotlinType.getArguments().subList(isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0, r0.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        if (isBuiltinFunctionalType(kotlinType)) {
            return kotlinType.getAnnotations().findAnnotation(StandardNames.a.f22569x) != null;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
        return functionalClassKind == FunctionClassKind.f22602k || functionalClassKind == FunctionClassKind.f22603l;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return Intrinsics3.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isBuiltinFunctionalClassDescriptor(declarationDescriptor)), Boolean.TRUE);
    }

    public static final boolean isFunctionType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == FunctionClassKind.f22602k;
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == FunctionClassKind.f22603l;
    }

    public static final Annotations4 withExtensionFunctionAnnotation(Annotations4 annotations4, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(annotations4, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        FqName fqName = StandardNames.a.f22569x;
        return annotations4.hasAnnotation(fqName) ? annotations4 : Annotations4.f22735f.create(_Collections.plus(annotations4, new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, Maps6.emptyMap())));
    }
}
