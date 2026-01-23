package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import p007b.p452o.p475b.p478c.egl;
import p007b.p452o.p475b.p478c.egl2;
import p007b.p452o.p475b.p478c.egl3;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.egl5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: EglNativeCore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EglNativeCore {

    /* JADX INFO: renamed from: a */
    public egl3 f14260a;

    /* JADX INFO: renamed from: b */
    public egl2 f14261b;

    /* JADX INFO: renamed from: c */
    public egl f14262c;

    public EglNativeCore(egl2 egl2Var, int i) {
        egl eglVarM7454a;
        Intrinsics3.checkNotNullParameter(egl2Var, "sharedContext");
        egl3 egl3Var = egl4.f14272b;
        this.f14260a = egl3Var;
        this.f14261b = egl4.f14271a;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        egl3 egl3Var2 = new egl3(eGLDisplayEglGetDisplay);
        this.f14260a = egl3Var2;
        if (egl3Var2 == egl3Var) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        EglNativeConfigChooser eglNativeConfigChooser = new EglNativeConfigChooser();
        boolean z2 = (i & 1) != 0;
        if (((i & 2) != 0) && (eglVarM7454a = eglNativeConfigChooser.m7454a(this.f14260a, 3, z2)) != null) {
            egl2 egl2Var2 = new egl2(EGL14.eglCreateContext(this.f14260a.f14270a, eglVarM7454a.f14268a, egl2Var.f14269a, new int[]{egl4.f14279i, 3, egl4.f14275e}, 0));
            try {
                Egloo.m7456a("eglCreateContext (3)");
                this.f14262c = eglVarM7454a;
                this.f14261b = egl2Var2;
            } catch (Exception unused) {
            }
        }
        if (this.f14261b == egl4.f14271a) {
            egl eglVarM7454a2 = eglNativeConfigChooser.m7454a(this.f14260a, 2, z2);
            if (eglVarM7454a2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            egl2 egl2Var3 = new egl2(EGL14.eglCreateContext(this.f14260a.f14270a, eglVarM7454a2.f14268a, egl2Var.f14269a, new int[]{egl4.f14279i, 2, egl4.f14275e}, 0));
            Egloo.m7456a("eglCreateContext (2)");
            this.f14262c = eglVarM7454a2;
            this.f14261b = egl2Var3;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m7455a(egl5 egl5Var, int i) {
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f14260a.f14270a, egl5Var.f14290a, i, iArr, 0);
        return iArr[0];
    }
}
