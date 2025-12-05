package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeWithEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.n.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeWithEnhancement4 extends KotlinType6 implements TypeWithEnhancement {

    /* renamed from: m */
    public final KotlinType6 f24892m;

    /* renamed from: n */
    public final KotlinType f24893n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeWithEnhancement4(KotlinType6 kotlinType6, KotlinType kotlinType) {
        super(kotlinType6.getLowerBound(), kotlinType6.getUpperBound());
        Intrinsics3.checkNotNullParameter(kotlinType6, "origin");
        Intrinsics3.checkNotNullParameter(kotlinType, "enhancement");
        this.f24892m = kotlinType6;
        this.f24893n = kotlinType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public KotlinType4 getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.f24893n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement
    public /* bridge */ /* synthetic */ KotlinType3 getOrigin() {
        return getOrigin();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType3 makeNullableAsSpecified(boolean z2) {
        return TypeWithEnhancement2.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        return descriptorRenderer4.getEnhancedTypes() ? descriptorRenderer2.renderType(getEnhancement()) : getOrigin().render(descriptorRenderer2, descriptorRenderer4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return TypeWithEnhancement2.wrapEnhancement(getOrigin().replaceAnnotations(annotations4), getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement
    public KotlinType6 getOrigin() {
        return this.f24892m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeWithEnhancement4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeWithEnhancement4((KotlinType6) kotlinTypeRefiner.refineType(getOrigin()), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
