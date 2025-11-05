package b.o.a.v;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import b.o.a.l;
import b.o.a.u.a;
import d0.z.d.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: SnapshotGlPictureRecorder.java */
/* loaded from: classes3.dex */
public class h implements Runnable {
    public final /* synthetic */ SurfaceTexture j;
    public final /* synthetic */ int k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float m;
    public final /* synthetic */ EGLContext n;
    public final /* synthetic */ g o;

    public h(g gVar, SurfaceTexture surfaceTexture, int i, float f, float f2, EGLContext eGLContext) {
        this.o = gVar;
        this.j = surfaceTexture;
        this.k = i;
        this.l = f;
        this.m = f2;
        this.n = eGLContext;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        g gVar = this.o;
        SurfaceTexture surfaceTexture = this.j;
        int i = this.k;
        float f = this.l;
        float f2 = this.m;
        EGLContext eGLContext = this.n;
        Objects.requireNonNull(gVar);
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        b.o.a.x.b bVar = gVar.j.d;
        surfaceTexture2.setDefaultBufferSize(bVar.j, bVar.k);
        b.o.b.a.a aVar = new b.o.b.a.a(eGLContext, 1);
        b.o.b.e.b bVar2 = new b.o.b.e.b(aVar, surfaceTexture2);
        b.o.b.a.a aVar2 = bVar2.a;
        b.o.b.c.e eVar = bVar2.f1967b;
        Objects.requireNonNull(aVar2);
        m.checkNotNullParameter(eVar, "eglSurface");
        if (aVar2.a == b.o.b.c.d.f1961b) {
            Log.v("EglCore", "NOTE: makeSurfaceCurrent w/o display");
        }
        b.o.b.c.c cVar = aVar2.a;
        b.o.b.c.b bVar3 = aVar2.f1959b;
        EGLDisplay eGLDisplay = cVar.a;
        EGLSurface eGLSurface = eVar.a;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar3.a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
        float[] fArr = gVar.f1956s.f1950b;
        surfaceTexture.getTransformMatrix(fArr);
        Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, i + gVar.j.c, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (gVar.q) {
            b.o.a.u.b bVar4 = gVar.r;
            a.EnumC0177a enumC0177a = a.EnumC0177a.PICTURE_SNAPSHOT;
            Objects.requireNonNull(bVar4);
            try {
                Canvas canvasLockCanvas = (Build.VERSION.SDK_INT < 23 || !((b.o.a.u.c) bVar4.f1953b).getHardwareCanvasEnabled()) ? bVar4.d.lockCanvas(null) : bVar4.d.lockHardwareCanvas();
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                ((b.o.a.u.c) bVar4.f1953b).a(enumC0177a, canvasLockCanvas);
                bVar4.d.unlockCanvasAndPost(canvasLockCanvas);
            } catch (Surface.OutOfResourcesException e) {
                b.o.a.u.b.a.a(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
            }
            synchronized (bVar4.g) {
                GLES20.glBindTexture(36197, bVar4.f.a);
                bVar4.c.updateTexImage();
            }
            bVar4.c.getTransformMatrix(bVar4.e.f1950b);
            Matrix.translateM(gVar.r.e.f1950b, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(gVar.r.e.f1950b, 0, gVar.j.c, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(gVar.r.e.f1950b, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(gVar.r.e.f1950b, 0, -0.5f, -0.5f, 0.0f);
        }
        gVar.j.c = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        i.m.a(1, "takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        gVar.f1956s.a(timestamp);
        if (gVar.q) {
            b.o.a.u.b bVar5 = gVar.r;
            Objects.requireNonNull(bVar5);
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            synchronized (bVar5.g) {
                bVar5.e.a(timestamp);
            }
        }
        l.a aVar3 = gVar.j;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        m.checkNotNullParameter(compressFormat, "format");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bVar2.a(byteArrayOutputStream, compressFormat);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            m.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            d0.y.b.closeFinally(byteArrayOutputStream, null);
            aVar3.f = byteArray;
            b.o.b.a.a aVar4 = bVar2.a;
            b.o.b.c.e eVar2 = bVar2.f1967b;
            Objects.requireNonNull(aVar4);
            m.checkNotNullParameter(eVar2, "eglSurface");
            EGL14.eglDestroySurface(aVar4.a.a, eVar2.a);
            bVar2.f1967b = b.o.b.c.d.c;
            bVar2.d = -1;
            bVar2.c = -1;
            gVar.f1956s.b();
            surfaceTexture2.release();
            if (gVar.q) {
                b.o.a.u.b bVar6 = gVar.r;
                if (bVar6.f != null) {
                    GLES20.glBindTexture(36197, 0);
                    bVar6.f = null;
                }
                SurfaceTexture surfaceTexture3 = bVar6.c;
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                    bVar6.c = null;
                }
                Surface surface = bVar6.d;
                if (surface != null) {
                    surface.release();
                    bVar6.d = null;
                }
                b.o.a.r.c cVar2 = bVar6.e;
                if (cVar2 != null) {
                    cVar2.b();
                    bVar6.e = null;
                }
            }
            aVar.b();
            gVar.b();
        } finally {
        }
    }
}
