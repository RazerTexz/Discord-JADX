package p507d0.p580t;

import java.util.List;
import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReversedViews.kt */
/* renamed from: d0.t.s, reason: use source file name */
/* loaded from: classes3.dex */
public class ReversedViews3 extends MutableCollections {
    public static final int access$reverseElementIndex(List list, int i) {
        int lastIndex = Collections2.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return Collections2.getLastIndex(list) - i;
        }
        StringBuilder sbM834V = outline.m834V("Element index ", i, " must be in range [");
        sbM834V.append(new Ranges2(0, Collections2.getLastIndex(list)));
        sbM834V.append("].");
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sbM834V = outline.m834V("Position index ", i, " must be in range [");
        sbM834V.append(new Ranges2(0, list.size()));
        sbM834V.append("].");
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public static final <T> List<T> asReversed(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$asReversed");
        return new ReversedViews2(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$asReversed");
        return new ReversedViews(list);
    }
}
