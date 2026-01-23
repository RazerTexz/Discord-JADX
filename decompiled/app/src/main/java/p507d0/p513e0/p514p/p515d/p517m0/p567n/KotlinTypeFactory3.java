package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory3 extends KotlinTypeFactory6 {

    /* JADX INFO: renamed from: l */
    public final Annotations4 f24779l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinTypeFactory3(KotlinType4 kotlinType4, Annotations4 annotations4) {
        super(kotlinType4);
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        this.f24779l = annotations4;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f24779l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinTypeFactory3 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new KotlinTypeFactory3(kotlinType4, getAnnotations());
    }
}
