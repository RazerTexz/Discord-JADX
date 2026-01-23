package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.l */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11820l extends AbstractC11815g<Float> {
    public C11820l(float f) {
        super(Float.valueOf(f));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        return getType(moduleDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().floatValue() + ".toFloat()";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 floatType = moduleDescriptor2.getBuiltIns().getFloatType();
        Intrinsics3.checkNotNullExpressionValue(floatType, "module.builtIns.floatType");
        return floatType;
    }
}
