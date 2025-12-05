package p007b.p452o.p475b.p477b;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.gl;

/* compiled from: GlRect.kt */
/* renamed from: b.o.b.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public class GlRect extends Gl2dDrawable {

    /* renamed from: c */
    @Deprecated
    public static final float[] f14266c = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: d */
    public FloatBuffer f14267d;

    public GlRect() {
        float[] fArr = f14266c;
        FloatBuffer floatBufferM4258X = C3404f.m4258X(fArr.length);
        floatBufferM4258X.put(fArr);
        floatBufferM4258X.clear();
        this.f14267d = floatBufferM4258X;
    }

    @Override // p007b.p452o.p475b.p477b.GlDrawable
    /* renamed from: a */
    public void mo7458a() {
        Egloo.m7457b("glDrawArrays start");
        GLES20.glDrawArrays(gl.f14292b, 0, this.f14267d.limit() / this.f14264b);
        Egloo.m7457b("glDrawArrays end");
    }

    @Override // p007b.p452o.p475b.p477b.GlDrawable
    /* renamed from: b */
    public FloatBuffer mo7459b() {
        return this.f14267d;
    }
}
