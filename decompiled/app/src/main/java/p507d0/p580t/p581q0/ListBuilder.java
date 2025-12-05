package p507d0.p580t.p581q0;

import java.util.Arrays;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ListBuilder.kt */
/* renamed from: d0.t.q0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ListBuilder {
    public static final <E> E[] arrayOfUninitializedElements(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$copyOfUninitializedElements");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        Intrinsics3.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOf(this, newSize)");
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i) {
        Intrinsics3.checkNotNullParameter(eArr, "$this$resetAt");
        eArr[i] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i, int i2) {
        Intrinsics3.checkNotNullParameter(eArr, "$this$resetRange");
        while (i < i2) {
            resetAt(eArr, i);
            i++;
        }
    }
}
