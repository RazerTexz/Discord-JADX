package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11976e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: dynamicTypes.kt */
/* renamed from: d0.e0.p.d.m0.n.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class dynamicTypes extends KotlinType6 implements InterfaceC11976e {

    /* renamed from: m */
    public final Annotations4 f24862m;

    /* JADX WARN: Illegal instructions before constructor call */
    public dynamicTypes(KotlinBuiltIns kotlinBuiltIns, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        KotlinType4 nothingType = kotlinBuiltIns.getNothingType();
        Intrinsics3.checkNotNullExpressionValue(nothingType, "builtIns.nothingType");
        KotlinType4 nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "builtIns.nullableAnyType");
        super(nothingType, nullableAnyType);
        this.f24862m = annotations4;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f24862m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public KotlinType4 getDelegate() {
        return getUpperBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public dynamicTypes makeNullableAsSpecified(boolean z2) {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public dynamicTypes refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        return "dynamic";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public dynamicTypes replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new dynamicTypes(TypeUtils2.getBuiltIns(getDelegate()), annotations4);
    }
}
