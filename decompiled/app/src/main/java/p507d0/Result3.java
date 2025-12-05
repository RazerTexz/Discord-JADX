package p507d0;

import p507d0.Result2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Result.kt */
/* renamed from: d0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class Result3 {
    public static final Object createFailure(Throwable th) {
        Intrinsics3.checkNotNullParameter(th, "exception");
        return new Result2.b(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result2.b) {
            throw ((Result2.b) obj).exception;
        }
    }
}
