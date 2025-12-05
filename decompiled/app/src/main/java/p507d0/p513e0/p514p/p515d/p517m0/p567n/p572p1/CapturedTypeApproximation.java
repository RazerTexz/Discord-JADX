package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CapturedTypeApproximation.kt */
/* renamed from: d0.e0.p.d.m0.n.p1.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class CapturedTypeApproximation<T> {

    /* renamed from: a */
    public final T f24856a;

    /* renamed from: b */
    public final T f24857b;

    public CapturedTypeApproximation(T t, T t2) {
        this.f24856a = t;
        this.f24857b = t2;
    }

    public final T component1() {
        return this.f24856a;
    }

    public final T component2() {
        return this.f24857b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CapturedTypeApproximation)) {
            return false;
        }
        CapturedTypeApproximation capturedTypeApproximation = (CapturedTypeApproximation) obj;
        return Intrinsics3.areEqual(this.f24856a, capturedTypeApproximation.f24856a) && Intrinsics3.areEqual(this.f24857b, capturedTypeApproximation.f24857b);
    }

    public final T getLower() {
        return this.f24856a;
    }

    public final T getUpper() {
        return this.f24857b;
    }

    public int hashCode() {
        T t = this.f24856a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24857b;
        return iHashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApproximationBounds(lower=");
        sbM833U.append(this.f24856a);
        sbM833U.append(", upper=");
        sbM833U.append(this.f24857b);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
