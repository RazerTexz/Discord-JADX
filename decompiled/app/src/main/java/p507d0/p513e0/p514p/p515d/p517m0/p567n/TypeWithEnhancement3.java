package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeWithEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.n.l0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeWithEnhancement3 extends SpecialTypes4 implements TypeWithEnhancement {

    /* renamed from: k */
    public final KotlinType4 f24797k;

    /* renamed from: l */
    public final KotlinType f24798l;

    public TypeWithEnhancement3(KotlinType4 kotlinType4, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        Intrinsics3.checkNotNullParameter(kotlinType, "enhancement");
        this.f24797k = kotlinType4;
        this.f24798l = kotlinType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.f24797k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.f24798l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement
    public KotlinType3 getOrigin() {
        return this.f24797k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return (KotlinType4) TypeWithEnhancement2.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return (KotlinType4) TypeWithEnhancement2.wrapEnhancement(getOrigin().replaceAnnotations(annotations4), getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public TypeWithEnhancement3 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new TypeWithEnhancement3(kotlinType4, getEnhancement());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeWithEnhancement3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeWithEnhancement3((KotlinType4) kotlinTypeRefiner.refineType(this.f24797k), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
