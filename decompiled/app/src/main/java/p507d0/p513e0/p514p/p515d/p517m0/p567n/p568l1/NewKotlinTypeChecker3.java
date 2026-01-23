package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.n, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewKotlinTypeChecker3 {

    /* JADX INFO: renamed from: a */
    public static final NewKotlinTypeChecker3 f24825a = new NewKotlinTypeChecker3();

    public final boolean isSubtypeOfAny(KotlinType3 kotlinType3) {
        Intrinsics3.checkNotNullParameter(kotlinType3, "type");
        return AbstractTypeChecker.f24743a.hasNotNullSupertype(NewKotlinTypeChecker4.f24827a.newBaseTypeCheckerContext(false, true), flexibleTypes2.lowerIfFlexible(kotlinType3), AbstractTypeChecker3.b.C13335b.f24766a);
    }
}
