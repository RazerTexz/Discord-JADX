package p507d0.p588x.p589d;

import p507d0.p588x.PlatformImplementations;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JDK7PlatformImplementations.kt */
/* renamed from: d0.x.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {
    @Override // p507d0.p588x.PlatformImplementations
    public void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics3.checkNotNullParameter(th, "cause");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        th.addSuppressed(th2);
    }
}
