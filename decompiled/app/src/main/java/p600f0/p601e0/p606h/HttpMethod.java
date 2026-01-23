package p600f0.p601e0.p606h;

import androidx.browser.trusted.sharing.ShareTarget;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.h.f, reason: use source file name */
/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpMethod {
    /* JADX INFO: renamed from: a */
    public static final boolean m10226a(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "method");
        return (Intrinsics3.areEqual(str, ShareTarget.METHOD_GET) || Intrinsics3.areEqual(str, "HEAD")) ? false : true;
    }
}
