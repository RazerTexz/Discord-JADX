package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.d */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11812d extends AbstractC11824p<Byte> {
    public C11812d(byte b2) {
        super(Byte.valueOf(b2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        return getType(moduleDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().intValue() + ".toByte()";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 byteType = moduleDescriptor2.getBuiltIns().getByteType();
        Intrinsics3.checkNotNullExpressionValue(byteType, "module.builtIns.byteType");
        return byteType;
    }
}
