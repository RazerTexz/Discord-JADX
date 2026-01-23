package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n0, reason: use source file name */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StarProjectionImpl extends TypeProjectionBase {

    /* JADX INFO: renamed from: a */
    public final KotlinType f24839a;

    public StarProjectionImpl(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "kotlinBuiltIns");
        KotlinType4 nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "kotlinBuiltIns.nullableAnyType");
        this.f24839a = nullableAnyType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public KotlinType getType() {
        return this.f24839a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
