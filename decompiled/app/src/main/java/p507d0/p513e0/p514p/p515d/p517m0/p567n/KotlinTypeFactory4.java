package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h0, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory4 extends KotlinTypeFactory6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinTypeFactory4(KotlinType4 kotlinType4) {
        super(kotlinType4);
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinTypeFactory4 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new KotlinTypeFactory4(kotlinType4);
    }
}
