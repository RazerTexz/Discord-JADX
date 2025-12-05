package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KotlinTypeFactory.kt */
/* renamed from: d0.e0.p.d.m0.n.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KotlinTypeFactory6 extends SpecialTypes4 {

    /* renamed from: k */
    public final KotlinType4 f24838k;

    public KotlinTypeFactory6(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        this.f24838k = kotlinType4;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.f24838k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : this.f24838k.makeNullableAsSpecified(z2).replaceAnnotations(getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinTypeFactory6 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return annotations4 != getAnnotations() ? new KotlinTypeFactory3(this, annotations4) : this;
    }
}
