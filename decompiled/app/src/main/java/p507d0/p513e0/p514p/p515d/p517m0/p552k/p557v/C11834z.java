package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.z */
/* loaded from: classes3.dex */
public final class C11834z extends AbstractC11810b0<Long> {
    public C11834z(long j) {
        super(Long.valueOf(j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, StandardNames.a.f22545h0);
        KotlinType4 defaultType = classDescriptorFindClassAcrossModuleDependencies == null ? null : classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unsigned type ULong not found");
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unsigned type ULong not found\")");
        return kotlinType4CreateErrorType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().longValue() + ".toULong()";
    }
}
