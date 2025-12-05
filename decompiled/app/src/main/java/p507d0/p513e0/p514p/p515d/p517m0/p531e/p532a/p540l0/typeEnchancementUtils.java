package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import com.adjust.sdk.Constants;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSystemCommonBackendContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: typeEnchancementUtils.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class typeEnchancementUtils {
    public static final typeQualifiers createJavaTypeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3) {
        return (z3 && typequalifiers3 == typeQualifiers3.NOT_NULL) ? new typeQualifiers(typequalifiers3, typequalifiers2, true, z2) : new typeQualifiers(typequalifiers3, typequalifiers2, false, z2);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, InterfaceC11979h interfaceC11979h) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
        FqName fqName = JvmAnnotationNames.f23161o;
        Intrinsics3.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(interfaceC11979h, fqName);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z2) {
        Set<? extends T> set2;
        Intrinsics3.checkNotNullParameter(set, "<this>");
        Intrinsics3.checkNotNullParameter(t, Constants.LOW);
        Intrinsics3.checkNotNullParameter(t2, Constants.HIGH);
        if (!z2) {
            if (t3 != null && (set2 = _Collections.toSet(_Sets.plus(set, t3))) != null) {
                set = set2;
            }
            return (T) _Collections.singleOrNull(set);
        }
        T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
        if (Intrinsics3.areEqual(t4, t) && Intrinsics3.areEqual(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    public static final typeQualifiers3 select(Set<? extends typeQualifiers3> set, typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(set, "<this>");
        typeQualifiers3 typequalifiers32 = typeQualifiers3.FORCE_FLEXIBILITY;
        return typequalifiers3 == typequalifiers32 ? typequalifiers32 : (typeQualifiers3) select(set, typeQualifiers3.NOT_NULL, typeQualifiers3.NULLABLE, typequalifiers3, z2);
    }
}
