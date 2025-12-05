package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.util.Log;
import java.util.Iterator;
import org.webrtc.EglBase;
import p007b.p452o.p475b.p478c.egl;
import p007b.p452o.p475b.p478c.egl3;
import p007b.p452o.p475b.p478c.egl4;
import p507d0.p580t.Iterators4;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EglNativeConfigChooser.kt */
/* renamed from: b.o.b.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public class EglNativeConfigChooser {
    /* renamed from: a */
    public final egl m7454a(egl3 egl3Var, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(egl3Var, "display");
        int i2 = i >= 3 ? egl4.f14280j | egl4.f14281k : egl4.f14280j;
        int[] iArr = new int[15];
        iArr[0] = egl4.f14282l;
        iArr[1] = 8;
        iArr[2] = egl4.f14283m;
        iArr[3] = 8;
        iArr[4] = egl4.f14284n;
        iArr[5] = 8;
        iArr[6] = egl4.f14285o;
        iArr[7] = 8;
        iArr[8] = egl4.f14286p;
        iArr[9] = egl4.f14287q | egl4.f14288r;
        iArr[10] = egl4.f14289s;
        iArr[11] = i2;
        iArr[12] = z2 ? EglBase.EGL_RECORDABLE_ANDROID : egl4.f14275e;
        iArr[13] = z2 ? 1 : 0;
        iArr[14] = egl4.f14275e;
        egl[] eglVarArr = new egl[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(egl3Var.f14270a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (zEglChooseConfig) {
            Iterator<Integer> it = _Arrays.getIndices(eglVarArr).iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[iNextInt];
                eglVarArr[iNextInt] = eGLConfig == null ? null : new egl(eGLConfig);
            }
        }
        if (zEglChooseConfig) {
            return eglVarArr[0];
        }
        Log.w("EglConfigChooser", "Unable to find RGB8888 / " + i + " EGLConfig");
        return null;
    }
}
