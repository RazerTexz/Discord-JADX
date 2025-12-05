package p507d0;

import p507d0.p588x.PlatformImplementations2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Exceptions.kt */
/* renamed from: d0.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Exceptions {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics3.checkNotNullParameter(th, "$this$addSuppressed");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            PlatformImplementations2.f25252a.addSuppressed(th, th2);
        }
    }
}
