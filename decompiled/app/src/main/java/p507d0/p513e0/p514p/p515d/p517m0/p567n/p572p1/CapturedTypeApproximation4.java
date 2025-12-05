package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CapturedTypeApproximation.kt */
/* renamed from: d0.e0.p.d.m0.n.p1.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class CapturedTypeApproximation4 {

    /* renamed from: a */
    public final TypeParameterDescriptor f24859a;

    /* renamed from: b */
    public final KotlinType f24860b;

    /* renamed from: c */
    public final KotlinType f24861c;

    public CapturedTypeApproximation4(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics3.checkNotNullParameter(kotlinType, "inProjection");
        Intrinsics3.checkNotNullParameter(kotlinType2, "outProjection");
        this.f24859a = typeParameterDescriptor;
        this.f24860b = kotlinType;
        this.f24861c = kotlinType2;
    }

    public final KotlinType getInProjection() {
        return this.f24860b;
    }

    public final KotlinType getOutProjection() {
        return this.f24861c;
    }

    public final TypeParameterDescriptor getTypeParameter() {
        return this.f24859a;
    }

    public final boolean isConsistent() {
        return KotlinTypeChecker.f24806a.isSubtypeOf(this.f24860b, this.f24861c);
    }
}
