package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMap;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeEnchancementUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a0, reason: use source file name */
/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeSignatureMapping {
    public static final <T> T boxTypeIfNeeded(typeSignatureMapping3<T> typesignaturemapping3, T t, boolean z2) {
        Intrinsics3.checkNotNullParameter(typesignaturemapping3, "<this>");
        Intrinsics3.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z2 ? typesignaturemapping3.boxType(t) : t;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, InterfaceC11979h interfaceC11979h, typeSignatureMapping3<T> typesignaturemapping3, TypeMappingMode typeMappingMode) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
        Intrinsics3.checkNotNullParameter(typesignaturemapping3, "typeFactory");
        Intrinsics3.checkNotNullParameter(typeMappingMode, "mode");
        InterfaceC11983l interfaceC11983lTypeConstructor = typeSystemCommonBackendContext.typeConstructor(interfaceC11979h);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(interfaceC11983lTypeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(interfaceC11983lTypeConstructor);
        boolean z2 = true;
        if (primitiveType != null) {
            T tCreatePrimitiveType = typesignaturemapping3.createPrimitiveType(primitiveType);
            if (!typeSystemCommonBackendContext.isNullableType(interfaceC11979h) && !typeEnchancementUtils.hasEnhancedNullability(typeSystemCommonBackendContext, interfaceC11979h)) {
                z2 = false;
            }
            return (T) boxTypeIfNeeded(typesignaturemapping3, tCreatePrimitiveType, z2);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(interfaceC11983lTypeConstructor);
        if (primitiveArrayType != null) {
            return typesignaturemapping3.createFromString(Intrinsics3.stringPlus("[", JvmPrimitiveType.get(primitiveArrayType).getDesc()));
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(interfaceC11983lTypeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(interfaceC11983lTypeConstructor);
            ClassId classIdMapKotlinToJava = classFqNameUnsafe == null ? null : JavaToKotlinClassMap.f22614a.mapKotlinToJava(classFqNameUnsafe);
            if (classIdMapKotlinToJava != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    List<JavaToKotlinClassMap.a> mutabilityMappings = JavaToKotlinClassMap.f22614a.getMutabilityMappings();
                    if ((mutabilityMappings instanceof Collection) && mutabilityMappings.isEmpty()) {
                        z2 = false;
                        if (z2) {
                        }
                    } else {
                        Iterator<T> it = mutabilityMappings.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics3.areEqual(((JavaToKotlinClassMap.a) it.next()).getJavaClass(), classIdMapKotlinToJava)) {
                                break;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            return null;
                        }
                    }
                }
                String internalName = JvmClassName.byClassId(classIdMapKotlinToJava).getInternalName();
                Intrinsics3.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return typesignaturemapping3.createObjectType(internalName);
            }
        }
        return null;
    }
}
