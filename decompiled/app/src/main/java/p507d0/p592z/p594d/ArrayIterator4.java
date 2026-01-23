package p507d0.p592z.p594d;

import java.util.Iterator;

/* JADX INFO: renamed from: d0.z.d.c, reason: use source file name */
/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ArrayIterator4 {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "array");
        return new ArrayIterator3(tArr);
    }
}
