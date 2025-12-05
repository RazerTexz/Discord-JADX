package p507d0.p580t;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MutableCollectionsJVM.kt */
/* renamed from: d0.t.q, reason: use source file name */
/* loaded from: classes3.dex */
public class MutableCollectionsJVM extends Iterators7 {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
