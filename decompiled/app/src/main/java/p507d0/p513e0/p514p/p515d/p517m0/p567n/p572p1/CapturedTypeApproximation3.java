package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.c, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeApproximation3 extends TypeSubstitution3 {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3
    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "key");
        CapturedTypeConstructor2 capturedTypeConstructor2 = typeConstructor instanceof CapturedTypeConstructor2 ? (CapturedTypeConstructor2) typeConstructor : null;
        if (capturedTypeConstructor2 == null) {
            return null;
        }
        return capturedTypeConstructor2.getProjection().isStarProjection() ? new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor2.getProjection().getType()) : capturedTypeConstructor2.getProjection();
    }
}
