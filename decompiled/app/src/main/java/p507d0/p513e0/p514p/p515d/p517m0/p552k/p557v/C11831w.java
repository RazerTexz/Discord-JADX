package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.w */
/* loaded from: classes3.dex */
public final class C11831w extends AbstractC11815g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11831w(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, "value");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        return getType(moduleDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return outline.m820H(outline.m829Q('\"'), getValue(), '\"');
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType4 stringType = moduleDescriptor2.getBuiltIns().getStringType();
        Intrinsics3.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }
}
