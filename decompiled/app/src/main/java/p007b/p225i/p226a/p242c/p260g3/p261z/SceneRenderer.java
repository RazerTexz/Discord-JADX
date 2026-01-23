package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import androidx.work.Data;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimedValueQueue;
import p007b.p225i.p226a.p242c.p260g3.VideoFrameMetadataListener;
import p007b.p225i.p226a.p242c.p260g3.p261z.Projection;

/* JADX INFO: renamed from: b.i.a.c.g3.z.j, reason: use source file name */
/* JADX INFO: compiled from: SceneRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {

    /* JADX INFO: renamed from: r */
    public int f7016r;

    /* JADX INFO: renamed from: s */
    public SurfaceTexture f7017s;

    /* JADX INFO: renamed from: v */
    @Nullable
    public byte[] f7020v;

    /* JADX INFO: renamed from: j */
    public final AtomicBoolean f7008j = new AtomicBoolean();

    /* JADX INFO: renamed from: k */
    public final AtomicBoolean f7009k = new AtomicBoolean(true);

    /* JADX INFO: renamed from: l */
    public final ProjectionRenderer f7010l = new ProjectionRenderer();

    /* JADX INFO: renamed from: m */
    public final FrameRotationQueue f7011m = new FrameRotationQueue();

    /* JADX INFO: renamed from: n */
    public final TimedValueQueue<Long> f7012n = new TimedValueQueue<>();

    /* JADX INFO: renamed from: o */
    public final TimedValueQueue<Projection> f7013o = new TimedValueQueue<>();

    /* JADX INFO: renamed from: p */
    public final float[] f7014p = new float[16];

    /* JADX INFO: renamed from: q */
    public final float[] f7015q = new float[16];

    /* JADX INFO: renamed from: t */
    public volatile int f7018t = 0;

    /* JADX INFO: renamed from: u */
    public int f7019u = -1;

    @Override // p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionListener
    /* JADX INFO: renamed from: a */
    public void mo3196a(long j, float[] fArr) {
        this.f7011m.f6970c.m2966a(j, fArr);
    }

    /* JADX INFO: renamed from: b */
    public SurfaceTexture m3201b() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.m8945a();
        ProjectionRenderer projectionRenderer = this.f7010l;
        Objects.requireNonNull(projectionRenderer);
        GlUtil.C10776a c10776a = new GlUtil.C10776a(ProjectionRenderer.f6988a, ProjectionRenderer.f6989b);
        projectionRenderer.f6998k = c10776a;
        projectionRenderer.f6999l = GLES20.glGetUniformLocation(c10776a.f20280a, "uMvpMatrix");
        projectionRenderer.f7000m = GLES20.glGetUniformLocation(projectionRenderer.f6998k.f20280a, "uTexMatrix");
        projectionRenderer.f7001n = GLES20.glGetAttribLocation(projectionRenderer.f6998k.f20280a, "aPosition");
        projectionRenderer.f7002o = GLES20.glGetAttribLocation(projectionRenderer.f6998k.f20280a, "aTexCoords");
        projectionRenderer.f7003p = GLES20.glGetUniformLocation(projectionRenderer.f6998k.f20280a, "uTexture");
        GlUtil.m8945a();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.m8945a();
        this.f7016r = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f7016r);
        this.f7017s = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new C2789a(this));
        return this.f7017s;
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionListener
    /* JADX INFO: renamed from: c */
    public void mo3197c() {
        this.f7012n.m2967b();
        FrameRotationQueue frameRotationQueue = this.f7011m;
        frameRotationQueue.f6970c.m2967b();
        frameRotationQueue.f6971d = false;
        this.f7009k.set(true);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoFrameMetadataListener
    /* JADX INFO: renamed from: e */
    public void mo3177e(long j, long j2, Format2 format2, @Nullable MediaFormat mediaFormat) {
        float f;
        float f2;
        int i;
        int i2;
        ArrayList<Projection.a> arrayListM573t1;
        int iM3086f;
        this.f7012n.m2966a(j2, Long.valueOf(j));
        byte[] bArr = format2.f7133G;
        int i3 = format2.f7134H;
        byte[] bArr2 = this.f7020v;
        int i4 = this.f7019u;
        this.f7020v = bArr;
        if (i3 == -1) {
            i3 = this.f7018t;
        }
        this.f7019u = i3;
        if (i4 == i3 && Arrays.equals(bArr2, this.f7020v)) {
            return;
        }
        byte[] bArr3 = this.f7020v;
        Projection projection = null;
        if (bArr3 != null) {
            int i5 = this.f7019u;
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr3);
            try {
                parsableByteArray.m3080F(4);
                iM3086f = parsableByteArray.m3086f();
                parsableByteArray.m3079E(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (iM3086f == 1886547818) {
                parsableByteArray.m3080F(8);
                int i6 = parsableByteArray.f6794b;
                int i7 = parsableByteArray.f6795c;
                while (i6 < i7) {
                    int iM3086f2 = parsableByteArray.m3086f() + i6;
                    if (iM3086f2 > i6 && iM3086f2 <= i7) {
                        int iM3086f3 = parsableByteArray.m3086f();
                        if (iM3086f3 != 2037673328 && iM3086f3 != 1836279920) {
                            parsableByteArray.m3079E(iM3086f2);
                            i6 = iM3086f2;
                        }
                        parsableByteArray.m3078D(iM3086f2);
                        arrayListM573t1 = AnimatableValueParser.m573t1(parsableByteArray);
                        break;
                    }
                    break;
                }
                arrayListM573t1 = null;
            } else {
                arrayListM573t1 = AnimatableValueParser.m573t1(parsableByteArray);
            }
            if (arrayListM573t1 != null) {
                int size = arrayListM573t1.size();
                if (size == 1) {
                    projection = new Projection(arrayListM573t1.get(0), i5);
                } else if (size == 2) {
                    projection = new Projection(arrayListM573t1.get(0), arrayListM573t1.get(1), i5);
                }
            }
        }
        if (projection == null || !ProjectionRenderer.m3200a(projection)) {
            int i8 = this.f7019u;
            AnimatableValueParser.m531j(true);
            AnimatableValueParser.m531j(true);
            AnimatableValueParser.m531j(true);
            AnimatableValueParser.m531j(true);
            AnimatableValueParser.m531j(true);
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f3 = radians / 36;
            float f4 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 36; i9 < i12; i12 = 36) {
                float f5 = radians / 2.0f;
                float f6 = (i9 * f3) - f5;
                int i13 = i9 + 1;
                float f7 = (i13 * f3) - f5;
                int i14 = 0;
                while (i14 < 73) {
                    int i15 = i13;
                    int i16 = 0;
                    for (int i17 = 2; i16 < i17; i17 = 2) {
                        if (i16 == 0) {
                            f2 = f7;
                            f = f6;
                        } else {
                            f = f7;
                            f2 = f;
                        }
                        float f8 = i14 * f4;
                        float f9 = f6;
                        int i18 = i10 + 1;
                        float f10 = f4;
                        double d = 50.0f;
                        int i19 = i14;
                        double d2 = (f8 + 3.1415927f) - (radians2 / 2.0f);
                        int i20 = i8;
                        float f11 = radians;
                        double d3 = f;
                        float f12 = f3;
                        fArr[i10] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                        int i21 = i18 + 1;
                        int i22 = i16;
                        fArr[i18] = (float) (Math.sin(d3) * d);
                        int i23 = i21 + 1;
                        fArr[i21] = (float) (Math.cos(d3) * Math.cos(d2) * d);
                        int i24 = i11 + 1;
                        fArr2[i11] = f8 / radians2;
                        int i25 = i24 + 1;
                        fArr2[i24] = ((i9 + i22) * f12) / f11;
                        if (i19 == 0 && i22 == 0) {
                            i2 = i22;
                            i = i19;
                        } else {
                            i = i19;
                            i2 = i22;
                            if (i != 72 || i2 != 1) {
                            }
                            i11 = i25;
                            i10 = i23;
                            i16 = i2 + 1;
                            i14 = i;
                            f7 = f2;
                            f4 = f10;
                            f6 = f9;
                            radians = f11;
                            f3 = f12;
                            i8 = i20;
                        }
                        System.arraycopy(fArr, i23 - 3, fArr, i23, 3);
                        i23 += 3;
                        System.arraycopy(fArr2, i25 - 2, fArr2, i25, 2);
                        i25 += 2;
                        i11 = i25;
                        i10 = i23;
                        i16 = i2 + 1;
                        i14 = i;
                        f7 = f2;
                        f4 = f10;
                        f6 = f9;
                        radians = f11;
                        f3 = f12;
                        i8 = i20;
                    }
                    i14++;
                    i13 = i15;
                    f7 = f7;
                    i8 = i8;
                }
                i9 = i13;
            }
            projection = new Projection(new Projection.a(new Projection.b(0, fArr, fArr2, 1)), i8);
        }
        this.f7013o.m2966a(j2, projection);
    }
}
