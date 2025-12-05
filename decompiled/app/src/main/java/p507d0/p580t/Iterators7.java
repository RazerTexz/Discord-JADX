package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Iterators.kt */
/* renamed from: d0.t.p, reason: use source file name */
/* loaded from: classes3.dex */
public class Iterators7 extends Iterables2 {
    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it) {
        Intrinsics3.checkNotNullParameter(it, "$this$withIndex");
        return new Iterators3(it);
    }
}
