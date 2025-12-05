package p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n;

import java.util.Collection;
import java.util.LinkedHashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: scopeUtils.kt */
/* renamed from: d0.e0.p.d.m0.o.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class scopeUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics3.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final SmartList<MemberScope3> listOfNonEmptyScopes(Iterable<? extends MemberScope3> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "scopes");
        SmartList<MemberScope3> smartList = new SmartList<>();
        for (MemberScope3 memberScope3 : iterable) {
            MemberScope3 memberScope32 = memberScope3;
            if ((memberScope32 == null || memberScope32 == MemberScope3.b.f24373b) ? false : true) {
                smartList.add(memberScope3);
            }
        }
        return smartList;
    }
}
