package p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.o */
/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11986o {
    public static final EnumC11989r convertVariance(Variance variance) {
        Intrinsics3.checkNotNullParameter(variance, "<this>");
        int iOrdinal = variance.ordinal();
        if (iOrdinal == 0) {
            return EnumC11989r.INV;
        }
        if (iOrdinal == 1) {
            return EnumC11989r.IN;
        }
        if (iOrdinal == 2) {
            return EnumC11989r.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
