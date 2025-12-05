package p007b.p452o.p475b.p478c;

import android.opengl.EGLSurface;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: egl.kt */
/* renamed from: b.o.b.c.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class egl5 {

    /* renamed from: a */
    public final EGLSurface f14290a;

    public egl5(EGLSurface eGLSurface) {
        this.f14290a = eGLSurface;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl5) && Intrinsics3.areEqual(this.f14290a, ((egl5) obj).f14290a);
    }

    public int hashCode() {
        EGLSurface eGLSurface = this.f14290a;
        if (eGLSurface == null) {
            return 0;
        }
        return eGLSurface.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EglSurface(native=");
        sbM833U.append(this.f14290a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
