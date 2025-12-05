package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.HashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: expandedTypeUtils.kt */
/* renamed from: d0.e0.p.d.m0.n.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class expandedTypeUtils {
    /* renamed from: a */
    public static final InterfaceC11979h m10038a(TypeSystemCommonBackendContext typeSystemCommonBackendContext, InterfaceC11979h interfaceC11979h, HashSet<InterfaceC11983l> hashSet) {
        InterfaceC11979h interfaceC11979hM10038a;
        InterfaceC11983l interfaceC11983lTypeConstructor = typeSystemCommonBackendContext.typeConstructor(interfaceC11979h);
        if (!hashSet.add(interfaceC11983lTypeConstructor)) {
            return null;
        }
        InterfaceC11984m typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(interfaceC11983lTypeConstructor);
        if (typeParameterClassifier != null) {
            interfaceC11979hM10038a = m10038a(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (interfaceC11979hM10038a == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isNullableType(interfaceC11979hM10038a) && typeSystemCommonBackendContext.isMarkedNullable(interfaceC11979h)) {
                return typeSystemCommonBackendContext.makeNullable(interfaceC11979hM10038a);
            }
        } else {
            if (!typeSystemCommonBackendContext.isInlineClass(interfaceC11983lTypeConstructor)) {
                return interfaceC11979h;
            }
            InterfaceC11979h substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(interfaceC11979h);
            if (substitutedUnderlyingType == null || (interfaceC11979hM10038a = m10038a(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(interfaceC11979h)) {
                return typeSystemCommonBackendContext.isNullableType(interfaceC11979hM10038a) ? interfaceC11979h : ((interfaceC11979hM10038a instanceof InterfaceC11980i) && typeSystemCommonBackendContext.isPrimitiveType((InterfaceC11980i) interfaceC11979hM10038a)) ? interfaceC11979h : typeSystemCommonBackendContext.makeNullable(interfaceC11979hM10038a);
            }
        }
        return interfaceC11979hM10038a;
    }

    public static final InterfaceC11979h computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext typeSystemCommonBackendContext, InterfaceC11979h interfaceC11979h) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "inlineClassType");
        return m10038a(typeSystemCommonBackendContext, interfaceC11979h, new HashSet());
    }
}
