package p007b.p225i.p226a.p242c.p260g3.p261z;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.FloatBuffer;
import p007b.p225i.p226a.p242c.p260g3.p261z.Projection;

/* compiled from: ProjectionRenderer.java */
/* renamed from: b.i.a.c.g3.z.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class ProjectionRenderer {

    /* renamed from: a */
    public static final String[] f6988a = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* renamed from: b */
    public static final String[] f6989b = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: c */
    public static final float[] f6990c = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: d */
    public static final float[] f6991d = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: e */
    public static final float[] f6992e = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: f */
    public static final float[] f6993f = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: g */
    public static final float[] f6994g = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: h */
    public int f6995h;

    /* renamed from: i */
    @Nullable
    public a f6996i;

    /* renamed from: j */
    @Nullable
    public a f6997j;

    /* renamed from: k */
    public GlUtil.C10776a f6998k;

    /* renamed from: l */
    public int f6999l;

    /* renamed from: m */
    public int f7000m;

    /* renamed from: n */
    public int f7001n;

    /* renamed from: o */
    public int f7002o;

    /* renamed from: p */
    public int f7003p;

    /* compiled from: ProjectionRenderer.java */
    /* renamed from: b.i.a.c.g3.z.i$a */
    public static class a {

        /* renamed from: a */
        public final int f7004a;

        /* renamed from: b */
        public final FloatBuffer f7005b;

        /* renamed from: c */
        public final FloatBuffer f7006c;

        /* renamed from: d */
        public final int f7007d;

        public a(Projection.b bVar) {
            float[] fArr = bVar.f6986c;
            this.f7004a = fArr.length / 3;
            this.f7005b = GlUtil.m8946b(fArr);
            this.f7006c = GlUtil.m8946b(bVar.f6987d);
            int i = bVar.f6985b;
            if (i == 1) {
                this.f7007d = 5;
            } else if (i != 2) {
                this.f7007d = 4;
            } else {
                this.f7007d = 6;
            }
        }
    }

    /* renamed from: a */
    public static boolean m3200a(Projection projection) {
        Projection.a aVar = projection.f6979a;
        Projection.a aVar2 = projection.f6980b;
        Projection.b[] bVarArr = aVar.f6983a;
        if (bVarArr.length == 1 && bVarArr[0].f6984a == 0) {
            Projection.b[] bVarArr2 = aVar2.f6983a;
            if (bVarArr2.length == 1 && bVarArr2[0].f6984a == 0) {
                return true;
            }
        }
        return false;
    }
}
