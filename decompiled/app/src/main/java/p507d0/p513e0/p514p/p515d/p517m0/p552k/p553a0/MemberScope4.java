package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberScope4 {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope3> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends MemberScope3> it = iterable.iterator();
        while (it.hasNext()) {
            Set<Name> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            MutableCollections.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
