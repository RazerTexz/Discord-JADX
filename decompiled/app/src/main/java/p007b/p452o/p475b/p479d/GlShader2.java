package p007b.p452o.p475b.p479d;

import android.opengl.GLES20;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.gl;
import p507d0.UInt;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.d.c, reason: use source file name */
/* JADX INFO: compiled from: GlShader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlShader2 {

    /* JADX INFO: renamed from: a */
    public static final a f14316a = new a(null);

    /* JADX INFO: renamed from: b */
    public final int f14317b;

    /* JADX INFO: renamed from: b.o.b.d.c$a */
    /* JADX INFO: compiled from: GlShader.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public GlShader2(int i, String str) {
        Intrinsics3.checkNotNullParameter(str, "source");
        int iM11482constructorimpl = UInt.m11482constructorimpl(GLES20.glCreateShader(UInt.m11482constructorimpl(i)));
        Egloo.m7457b(Intrinsics3.stringPlus("glCreateShader type=", Integer.valueOf(i)));
        GLES20.glShaderSource(iM11482constructorimpl, str);
        GLES20.glCompileShader(iM11482constructorimpl);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iM11482constructorimpl, gl.f14302l, iArr, 0);
        if (iArr[0] != 0) {
            this.f14317b = iM11482constructorimpl;
            return;
        }
        StringBuilder sbM834V = outline.m834V("Could not compile shader ", i, ": '");
        sbM834V.append((Object) GLES20.glGetShaderInfoLog(iM11482constructorimpl));
        sbM834V.append("' source: ");
        sbM834V.append(str);
        String string = sbM834V.toString();
        GLES20.glDeleteShader(iM11482constructorimpl);
        throw new RuntimeException(string);
    }
}
