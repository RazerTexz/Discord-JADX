package p007b.p452o.p453a.p467r;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.p464o.Filter2;
import p007b.p452o.p453a.p464o.NoFilter;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.gl;
import p007b.p452o.p475b.p479d.GlShader2;
import p007b.p452o.p475b.p481f.GlTexture2;
import p507d0.UInt;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.a.r.c, reason: use source file name */
/* JADX INFO: compiled from: GlTextureDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlTextureDrawer {

    /* JADX INFO: renamed from: a */
    public final GlTexture2 f14105a;

    /* JADX INFO: renamed from: b */
    public float[] f14106b = (float[]) Egloo.f14263a.clone();

    /* JADX INFO: renamed from: c */
    @NonNull
    public Filter2 f14107c = new NoFilter();

    /* JADX INFO: renamed from: d */
    public Filter2 f14108d = null;

    /* JADX INFO: renamed from: e */
    public int f14109e = -1;

    public GlTextureDrawer(@NonNull GlTexture2 glTexture2) {
        this.f14105a = glTexture2;
    }

    /* JADX INFO: renamed from: a */
    public void m7399a(long j) {
        if (this.f14108d != null) {
            m7400b();
            this.f14107c = this.f14108d;
            this.f14108d = null;
        }
        if (this.f14109e == -1) {
            String strMo7370c = this.f14107c.mo7370c();
            String strMo7375h = this.f14107c.mo7375h();
            Intrinsics3.checkNotNullParameter(strMo7370c, "vertexShaderSource");
            Intrinsics3.checkNotNullParameter(strMo7375h, "fragmentShaderSource");
            GlShader2[] glShader2Arr = {new GlShader2(gl.f14304n, strMo7370c), new GlShader2(gl.f14305o, strMo7375h)};
            Intrinsics3.checkNotNullParameter(glShader2Arr, "shaders");
            int iM11482constructorimpl = UInt.m11482constructorimpl(GLES20.glCreateProgram());
            Egloo.m7457b("glCreateProgram");
            if (iM11482constructorimpl == 0) {
                throw new RuntimeException("Could not create program");
            }
            for (int i = 0; i < 2; i++) {
                GLES20.glAttachShader(iM11482constructorimpl, UInt.m11482constructorimpl(glShader2Arr[i].f14317b));
                Egloo.m7457b("glAttachShader");
            }
            GLES20.glLinkProgram(iM11482constructorimpl);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iM11482constructorimpl, gl.f14303m, iArr, 0);
            int i2 = iArr[0];
            int i3 = gl.f14291a;
            if (i2 != 1) {
                String strStringPlus = Intrinsics3.stringPlus("Could not link program: ", GLES20.glGetProgramInfoLog(iM11482constructorimpl));
                GLES20.glDeleteProgram(iM11482constructorimpl);
                throw new RuntimeException(strStringPlus);
            }
            this.f14109e = iM11482constructorimpl;
            this.f14107c.mo7373j(iM11482constructorimpl);
            Egloo.m7457b("program creation");
        }
        GLES20.glUseProgram(this.f14109e);
        Egloo.m7457b("glUseProgram(handle)");
        this.f14105a.m7461a();
        this.f14107c.mo7371e(j, this.f14106b);
        this.f14105a.m7462b();
        GLES20.glUseProgram(0);
        Egloo.m7457b("glUseProgram(0)");
    }

    /* JADX INFO: renamed from: b */
    public void m7400b() {
        if (this.f14109e == -1) {
            return;
        }
        this.f14107c.mo7372f();
        GLES20.glDeleteProgram(this.f14109e);
        this.f14109e = -1;
    }
}
