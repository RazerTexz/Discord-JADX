package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.f;
import d0.e0.p.d.m0.n.i1;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: classes3.dex */
public final class n {
    public static final n a = new n();

    public final boolean isSubtypeOfAny(i1 i1Var) {
        d0.z.d.m.checkNotNullParameter(i1Var, "type");
        return d0.e0.p.d.m0.n.c.a.hasNotNullSupertype(p.a.newBaseTypeCheckerContext(false, true), d0.e0.p.d.m0.n.y.lowerIfFlexible(i1Var), f.b.C0579b.a);
    }
}
