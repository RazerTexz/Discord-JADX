package kotlin.reflect.full;

import d0.z.d.m;

/* compiled from: exceptions.kt */
/* loaded from: classes3.dex */
public final class IllegalCallableAccessException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalCallableAccessException(IllegalAccessException illegalAccessException) {
        super(illegalAccessException);
        m.checkNotNullParameter(illegalAccessException, "cause");
    }
}
