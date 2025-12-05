package p507d0.p580t;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CollectionsJVM.kt */
/* renamed from: d0.t.m, reason: use source file name */
/* loaded from: classes3.dex */
public class CollectionsJVM {
    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z2 && Intrinsics3.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics3.checkNotNullExpressionValue(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$shuffled");
        List<T> mutableList = _Collections.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }
}
