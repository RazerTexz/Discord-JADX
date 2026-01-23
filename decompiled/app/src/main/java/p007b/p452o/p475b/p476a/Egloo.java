package p007b.p452o.p475b.p476a;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.gl;
import p507d0.UInt;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.a.d, reason: use source file name */
/* JADX INFO: compiled from: Egloo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Egloo {

    /* JADX INFO: renamed from: a */
    public static final float[] f14263a;

    static {
        float[] fArr = new float[16];
        Intrinsics3.checkNotNullParameter(fArr, "<this>");
        Intrinsics3.checkNotNullParameter(fArr, "matrix");
        Matrix.setIdentityM(fArr, 0);
        f14263a = fArr;
    }

    /* JADX INFO: renamed from: a */
    public static final void m7456a(String str) {
        Intrinsics3.checkNotNullParameter(str, "opName");
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == egl4.f14274d) {
            return;
        }
        StringBuilder sbM837Y = outline.m837Y("Error during ", str, ": EGL error 0x");
        String hexString = Integer.toHexString(iEglGetError);
        Intrinsics3.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbM837Y.append(hexString);
        String string = sbM837Y.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }

    /* JADX INFO: renamed from: b */
    public static final void m7457b(String str) {
        Intrinsics3.checkNotNullParameter(str, "opName");
        int iM11482constructorimpl = UInt.m11482constructorimpl(GLES20.glGetError());
        int i = gl.f14291a;
        if (iM11482constructorimpl == 0) {
            return;
        }
        StringBuilder sbM837Y = outline.m837Y("Error during ", str, ": glError 0x");
        String hexString = Integer.toHexString(iM11482constructorimpl);
        Intrinsics3.checkNotNullExpressionValue(hexString, "toHexString(value)");
        sbM837Y.append(hexString);
        sbM837Y.append(": ");
        String strGluErrorString = GLU.gluErrorString(iM11482constructorimpl);
        Intrinsics3.checkNotNullExpressionValue(strGluErrorString, "gluErrorString(value)");
        sbM837Y.append(strGluErrorString);
        String string = sbM837Y.toString();
        Log.e("Egloo", string);
        throw new RuntimeException(string);
    }
}
