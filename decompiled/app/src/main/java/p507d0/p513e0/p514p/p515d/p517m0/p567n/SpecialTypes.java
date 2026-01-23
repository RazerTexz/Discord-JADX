package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a, reason: use source file name */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypes extends SpecialTypes4 {

    /* JADX INFO: renamed from: k */
    public final KotlinType4 f24737k;

    /* JADX INFO: renamed from: l */
    public final KotlinType4 f24738l;

    public SpecialTypes(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        Intrinsics3.checkNotNullParameter(kotlinType42, "abbreviation");
        this.f24737k = kotlinType4;
        this.f24738l = kotlinType42;
    }

    public final KotlinType4 getAbbreviation() {
        return this.f24738l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.f24737k;
    }

    public final KotlinType4 getExpandedType() {
        return this.f24737k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public SpecialTypes replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new SpecialTypes(kotlinType4, this.f24738l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public SpecialTypes makeNullableAsSpecified(boolean z2) {
        return new SpecialTypes(this.f24737k.makeNullableAsSpecified(z2), this.f24738l.makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public SpecialTypes replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new SpecialTypes(this.f24737k.replaceAnnotations(annotations4), this.f24738l);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public SpecialTypes refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new SpecialTypes((KotlinType4) kotlinTypeRefiner.refineType(this.f24737k), (KotlinType4) kotlinTypeRefiner.refineType(this.f24738l));
    }
}
