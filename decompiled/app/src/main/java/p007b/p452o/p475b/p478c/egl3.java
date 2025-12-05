package p007b.p452o.p475b.p478c;

import android.opengl.EGLDisplay;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: egl.kt */
/* renamed from: b.o.b.c.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class egl3 {

    /* renamed from: a */
    public final EGLDisplay f14270a;

    public egl3(EGLDisplay eGLDisplay) {
        this.f14270a = eGLDisplay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl3) && Intrinsics3.areEqual(this.f14270a, ((egl3) obj).f14270a);
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.f14270a;
        if (eGLDisplay == null) {
            return 0;
        }
        return eGLDisplay.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EglDisplay(native=");
        sbM833U.append(this.f14270a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
