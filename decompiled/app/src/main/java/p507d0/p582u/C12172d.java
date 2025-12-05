package p507d0.p582u;

import java.util.Comparator;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Comparisons.kt */
/* renamed from: d0.u.d */
/* loaded from: classes3.dex */
public final class C12172d implements Comparator<Comparable<? super Object>> {

    /* renamed from: j */
    public static final C12172d f25230j = new C12172d();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return C12171c.f25229j;
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        Intrinsics3.checkNotNullParameter(comparable, "a");
        Intrinsics3.checkNotNullParameter(comparable2, "b");
        return comparable2.compareTo(comparable);
    }
}
