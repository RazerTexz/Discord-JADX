package p007b.p452o.p475b.p478c;

import android.opengl.EGLContext;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: egl.kt */
/* renamed from: b.o.b.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class egl2 {

    /* renamed from: a */
    public final EGLContext f14269a;

    public egl2(EGLContext eGLContext) {
        this.f14269a = eGLContext;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl2) && Intrinsics3.areEqual(this.f14269a, ((egl2) obj).f14269a);
    }

    public int hashCode() {
        EGLContext eGLContext = this.f14269a;
        if (eGLContext == null) {
            return 0;
        }
        return eGLContext.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EglContext(native=");
        sbM833U.append(this.f14269a);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
