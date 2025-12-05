package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.s */
/* loaded from: classes3.dex */
public final class C11827s extends AbstractC11824p<Long> {
    public C11827s(long j) {
        super(Long.valueOf(j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        return getType(moduleDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().longValue() + ".toLong()";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 longType = moduleDescriptor2.getBuiltIns().getLongType();
        Intrinsics3.checkNotNullExpressionValue(longType, "module.builtIns.longType");
        return longType;
    }
}
