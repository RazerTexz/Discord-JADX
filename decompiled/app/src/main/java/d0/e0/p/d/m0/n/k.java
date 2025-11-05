package d0.e0.p.d.m0.n;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public final class k extends m implements j, d0.e0.p.d.m0.n.n1.d {
    public static final a k = new a(null);
    public final j0 l;
    public final boolean m;

    /* compiled from: SpecialTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final k makeDefinitelyNotNull$descriptors(i1 i1Var, boolean z2) {
            d0.z.d.m.checkNotNullParameter(i1Var, "type");
            if (i1Var instanceof k) {
                return (k) i1Var;
            }
            i1Var.getConstructor();
            if (!((i1Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0) || (i1Var instanceof d0.e0.p.d.m0.n.l1.i) ? (z2 && (i1Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0)) ? e1.isNullableType(i1Var) : !d0.e0.p.d.m0.n.l1.n.a.isSubtypeOfAny(i1Var) : false)) {
                return null;
            }
            if (i1Var instanceof v) {
                v vVar = (v) i1Var;
                d0.z.d.m.areEqual(vVar.getLowerBound().getConstructor(), vVar.getUpperBound().getConstructor());
            }
            return new k(y.lowerIfFlexible(i1Var), z2, null);
        }
    }

    public k(j0 j0Var, boolean z2) {
        this.l = j0Var;
        this.m = z2;
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        return this.l;
    }

    public final j0 getOriginal() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.j
    public boolean isTypeVariable() {
        this.l.getConstructor();
        return this.l.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.j
    public c0 substitutionResult(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "replacement");
        return m0.makeDefinitelyNotNullOrNotNull(c0Var.unwrap(), this.m);
    }

    @Override // d0.e0.p.d.m0.n.j0
    public String toString() {
        return this.l + "!!";
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.l.makeNullableAsSpecified(z2) : this;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public k replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new k(j0Var, this.m);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public k replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return new k(this.l.replaceAnnotations(gVar), this.m);
    }

    public k(j0 j0Var, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.l = j0Var;
        this.m = z2;
    }
}
