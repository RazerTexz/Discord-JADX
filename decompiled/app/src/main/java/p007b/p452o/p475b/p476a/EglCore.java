package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import p007b.p452o.p475b.p478c.egl2;
import p007b.p452o.p475b.p478c.egl3;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.egl5;

/* compiled from: EglCore.kt */
/* renamed from: b.o.b.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class EglCore extends EglNativeCore {
    public EglCore(EGLContext eGLContext, int i) {
        super(new egl2(eGLContext), i);
    }

    /* renamed from: b */
    public void m7453b() {
        egl3 egl3Var = this.f14260a;
        egl3 egl3Var2 = egl4.f14272b;
        if (egl3Var != egl3Var2) {
            egl5 egl5Var = egl4.f14273c;
            egl2 egl2Var = egl4.f14271a;
            EGLDisplay eGLDisplay = egl3Var.f14270a;
            EGLSurface eGLSurface = egl5Var.f14290a;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, egl2Var.f14269a);
            EGL14.eglDestroyContext(this.f14260a.f14270a, this.f14261b.f14269a);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f14260a.f14270a);
        }
        this.f14260a = egl3Var2;
        this.f14261b = egl4.f14271a;
        this.f14262c = null;
    }

    public final void finalize() {
        m7453b();
    }
}
