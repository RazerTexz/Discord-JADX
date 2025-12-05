package p007b.p452o.p453a.p464o;

import android.graphics.RectF;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.nio.Buffer;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p477b.Gl2dDrawable;
import p007b.p452o.p475b.p477b.GlDrawable;
import p007b.p452o.p475b.p477b.GlRect;
import p007b.p452o.p475b.p478c.gl;
import p007b.p452o.p475b.p479d.GlProgramLocation;
import p007b.p452o.p475b.p479d.GlShader2;
import p007b.p452o.p475b.p479d.GlTextureProgram;
import p007b.p452o.p475b.p482g.buffers;
import p507d0.UInt;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BaseFilter.java */
/* renamed from: b.o.a.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseFilter implements Filter2 {

    /* renamed from: a */
    public static final CameraLogger f14046a = new CameraLogger(BaseFilter.class.getSimpleName());

    /* renamed from: b */
    @VisibleForTesting
    public GlTextureProgram f14047b = null;

    /* renamed from: c */
    public GlDrawable f14048c = null;

    /* renamed from: d */
    @VisibleForTesting
    public Size3 f14049d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p452o.p453a.p464o.Filter2
    @NonNull
    /* renamed from: a */
    public Filter2 mo7369a() {
        try {
            Filter2 filter2 = (BaseFilter) getClass().newInstance();
            Size3 size3 = this.f14049d;
            if (size3 != null) {
                filter2.mo7374k(size3.f14251j, size3.f14252k);
            }
            if (this instanceof OneParameterFilter) {
                ((OneParameterFilter) filter2).m7376d(((OneParameterFilter) this).m7377i());
            }
            if (this instanceof TwoParameterFilter) {
                ((TwoParameterFilter) filter2).m7378b(((TwoParameterFilter) this).m7379g());
            }
            return filter2;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // p007b.p452o.p453a.p464o.Filter2
    @NonNull
    /* renamed from: c */
    public String mo7370c() {
        StringBuilder sb = new StringBuilder();
        sb.append("uniform mat4 ");
        sb.append("uMVPMatrix");
        sb.append(";\nuniform mat4 ");
        sb.append("uTexMatrix");
        sb.append(";\nattribute vec4 ");
        outline.m876s0(sb, "aPosition", ";\nattribute vec4 ", "aTextureCoord", ";\nvarying vec2 ");
        outline.m876s0(sb, "vTextureCoord", ";\nvoid main() {\n    gl_Position = ", "uMVPMatrix", " * ");
        outline.m876s0(sb, "aPosition", ";\n    ", "vTextureCoord", " = (");
        sb.append("uTexMatrix");
        sb.append(" * ");
        sb.append("aTextureCoord");
        sb.append(").xy;\n}\n");
        return sb.toString();
    }

    @Override // p007b.p452o.p453a.p464o.Filter2
    /* renamed from: e */
    public void mo7371e(long j, @NonNull float[] fArr) {
        GlTextureProgram glTextureProgram = this.f14047b;
        if (glTextureProgram == null) {
            f14046a.m7159a(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        Objects.requireNonNull(glTextureProgram);
        Intrinsics3.checkNotNullParameter(fArr, "<set-?>");
        glTextureProgram.f14318e = fArr;
        GlTextureProgram glTextureProgram2 = this.f14047b;
        GlDrawable glDrawable = this.f14048c;
        float[] fArr2 = glDrawable.f14265a;
        Objects.requireNonNull(glTextureProgram2);
        Intrinsics3.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics3.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        Intrinsics3.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics3.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        if (!(glDrawable instanceof Gl2dDrawable)) {
            throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
        }
        GLES20.glUniformMatrix4fv(glTextureProgram2.f14323j.f14311b, 1, false, fArr2, 0);
        Egloo.m7457b("glUniformMatrix4fv");
        GlProgramLocation glProgramLocation = glTextureProgram2.f14319f;
        if (glProgramLocation != null) {
            GLES20.glUniformMatrix4fv(glProgramLocation.f14311b, 1, false, glTextureProgram2.f14318e, 0);
            Egloo.m7457b("glUniformMatrix4fv");
        }
        GlProgramLocation glProgramLocation2 = glTextureProgram2.f14322i;
        GLES20.glEnableVertexAttribArray(glProgramLocation2.f14312c);
        Egloo.m7457b("glEnableVertexAttribArray");
        Gl2dDrawable gl2dDrawable = (Gl2dDrawable) glDrawable;
        GLES20.glVertexAttribPointer(glProgramLocation2.f14312c, 2, gl.f14291a, false, gl2dDrawable.f14264b * 4, (Buffer) glDrawable.mo7459b());
        Egloo.m7457b("glVertexAttribPointer");
        GlProgramLocation glProgramLocation3 = glTextureProgram2.f14321h;
        if (glProgramLocation3 != null) {
            if (!Intrinsics3.areEqual(glDrawable, glTextureProgram2.f14326m) || glTextureProgram2.f14325l != 0) {
                glTextureProgram2.f14326m = gl2dDrawable;
                glTextureProgram2.f14325l = 0;
                RectF rectF = glTextureProgram2.f14324k;
                Intrinsics3.checkNotNullParameter(rectF, "rect");
                float fMax = -3.4028235E38f;
                float fMax2 = -3.4028235E38f;
                float fMin = Float.MAX_VALUE;
                float fMin2 = Float.MAX_VALUE;
                int i = 0;
                while (gl2dDrawable.mo7459b().hasRemaining()) {
                    float f = gl2dDrawable.mo7459b().get();
                    if (i % 2 == 0) {
                        fMin = Math.min(fMin, f);
                        fMax2 = Math.max(fMax2, f);
                    } else {
                        fMax = Math.max(fMax, f);
                        fMin2 = Math.min(fMin2, f);
                    }
                    i++;
                }
                gl2dDrawable.mo7459b().rewind();
                rectF.set(fMin, fMax, fMax2, fMin2);
                int iLimit = (glDrawable.mo7459b().limit() / gl2dDrawable.f14264b) * 2;
                if (glTextureProgram2.f14320g.capacity() < iLimit) {
                    Object obj = glTextureProgram2.f14320g;
                    Intrinsics3.checkNotNullParameter(obj, "<this>");
                    if (obj instanceof buffers) {
                        ((buffers) obj).dispose();
                    }
                    glTextureProgram2.f14320g = C3404f.m4258X(iLimit);
                }
                glTextureProgram2.f14320g.clear();
                glTextureProgram2.f14320g.limit(iLimit);
                if (iLimit > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        boolean z2 = i2 % 2 == 0;
                        float f2 = glDrawable.mo7459b().get(i2);
                        RectF rectF2 = glTextureProgram2.f14324k;
                        float f3 = z2 ? rectF2.left : rectF2.bottom;
                        float f4 = z2 ? rectF2.right : rectF2.top;
                        int i4 = i2 / 2;
                        Intrinsics3.checkNotNullParameter(gl2dDrawable, "drawable");
                        glTextureProgram2.f14320g.put((((f2 - f3) / (f4 - f3)) * 1.0f) + 0.0f);
                        if (i3 >= iLimit) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
            }
            glTextureProgram2.f14320g.rewind();
            GLES20.glEnableVertexAttribArray(glProgramLocation3.f14312c);
            Egloo.m7457b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(glProgramLocation3.f14312c, 2, gl.f14291a, false, gl2dDrawable.f14264b * 4, (Buffer) glTextureProgram2.f14320g);
            Egloo.m7457b("glVertexAttribPointer");
        }
        GlTextureProgram glTextureProgram3 = this.f14047b;
        GlDrawable glDrawable2 = this.f14048c;
        Objects.requireNonNull(glTextureProgram3);
        Intrinsics3.checkNotNullParameter(glDrawable2, "drawable");
        glDrawable2.mo7458a();
        GlTextureProgram glTextureProgram4 = this.f14047b;
        GlDrawable glDrawable3 = this.f14048c;
        Objects.requireNonNull(glTextureProgram4);
        Intrinsics3.checkNotNullParameter(glDrawable3, "drawable");
        Intrinsics3.checkNotNullParameter(glDrawable3, "drawable");
        GLES20.glDisableVertexAttribArray(glTextureProgram4.f14322i.f14312c);
        GlProgramLocation glProgramLocation4 = glTextureProgram4.f14321h;
        if (glProgramLocation4 != null) {
            GLES20.glDisableVertexAttribArray(glProgramLocation4.f14312c);
        }
        Egloo.m7457b("onPostDraw end");
    }

    @Override // p007b.p452o.p453a.p464o.Filter2
    /* renamed from: f */
    public void mo7372f() {
        GlTextureProgram glTextureProgram = this.f14047b;
        if (!glTextureProgram.f14309d) {
            if (glTextureProgram.f14307b) {
                GLES20.glDeleteProgram(UInt.m11482constructorimpl(glTextureProgram.f14306a));
            }
            for (GlShader2 glShader2 : glTextureProgram.f14308c) {
                GLES20.glDeleteShader(UInt.m11482constructorimpl(glShader2.f14317b));
            }
            glTextureProgram.f14309d = true;
        }
        Object obj = glTextureProgram.f14320g;
        Intrinsics3.checkNotNullParameter(obj, "<this>");
        if (obj instanceof buffers) {
            ((buffers) obj).dispose();
        }
        this.f14047b = null;
        this.f14048c = null;
    }

    @Override // p007b.p452o.p453a.p464o.Filter2
    /* renamed from: j */
    public void mo7373j(int i) {
        this.f14047b = new GlTextureProgram(i, "aPosition", "uMVPMatrix", "aTextureCoord", "uTexMatrix");
        this.f14048c = new GlRect();
    }

    @Override // p007b.p452o.p453a.p464o.Filter2
    /* renamed from: k */
    public void mo7374k(int i, int i2) {
        this.f14049d = new Size3(i, i2);
    }
}
