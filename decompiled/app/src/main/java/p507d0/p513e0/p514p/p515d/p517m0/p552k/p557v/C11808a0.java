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
/* renamed from: d0.e0.p.d.m0.k.v.a0 */
/* loaded from: classes3.dex */
public final class C11808a0 extends AbstractC11810b0<Short> {
    public C11808a0(short s2) {
        super(Short.valueOf(s2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, StandardNames.a.f22541f0);
        KotlinType4 defaultType = classDescriptorFindClassAcrossModuleDependencies == null ? null : classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unsigned type UShort not found");
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unsigned type UShort not found\")");
        return kotlinType4CreateErrorType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().intValue() + ".toUShort()";
    }
}
