package p007b.p452o.p475b.p480e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import p007b.p452o.p475b.p476a.EglCore;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.egl;
import p007b.p452o.p475b.p478c.egl3;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.egl5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.e.b, reason: use source file name */
/* JADX INFO: compiled from: EglWindowSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EglWindowSurface extends EglSurface {
    public EglWindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        Intrinsics3.checkNotNullParameter(surfaceTexture, "surface");
        int[] iArr = {egl4.f14275e};
        egl3 egl3Var = eglCore.f14260a;
        egl eglVar = eglCore.f14262c;
        Intrinsics3.checkNotNull(eglVar);
        egl5 egl5Var = new egl5(EGL14.eglCreateWindowSurface(egl3Var.f14270a, eglVar.f14268a, surfaceTexture, iArr, 0));
        Egloo.m7456a("eglCreateWindowSurface");
        if (egl5Var == egl4.f14273c) {
            throw new RuntimeException("surface was null");
        }
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        super(eglCore, egl5Var);
    }
}
