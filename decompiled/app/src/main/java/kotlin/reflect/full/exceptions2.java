package kotlin.reflect.full;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: exceptions.kt */
/* renamed from: kotlin.reflect.full.IllegalPropertyDelegateAccessException, reason: use source file name */
/* loaded from: classes3.dex */
public final class exceptions2 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public exceptions2(IllegalAccessException illegalAccessException) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException);
        Intrinsics3.checkNotNullParameter(illegalAccessException, "cause");
    }
}
