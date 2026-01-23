package p007b.p452o.p475b.p478c;

import android.opengl.EGLConfig;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.c.a, reason: use source file name */
/* JADX INFO: compiled from: egl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class egl {

    /* JADX INFO: renamed from: a */
    public final EGLConfig f14268a;

    public egl(EGLConfig eGLConfig) {
        Intrinsics3.checkNotNullParameter(eGLConfig, "native");
        this.f14268a = eGLConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl) && Intrinsics3.areEqual(this.f14268a, ((egl) obj).f14268a);
    }

    public int hashCode() {
        return this.f14268a.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EglConfig(native=");
        sbM833U.append(this.f14268a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
