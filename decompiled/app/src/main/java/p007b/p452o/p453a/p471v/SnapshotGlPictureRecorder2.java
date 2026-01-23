package p007b.p452o.p453a.p471v;

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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p467r.GlTextureDrawer;
import p007b.p452o.p453a.p470u.Overlay;
import p007b.p452o.p453a.p470u.OverlayDrawer;
import p007b.p452o.p453a.p470u.OverlayLayout;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p475b.p476a.EglCore;
import p007b.p452o.p475b.p478c.egl2;
import p007b.p452o.p475b.p478c.egl3;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.egl5;
import p007b.p452o.p475b.p480e.EglWindowSurface;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.a.v.h, reason: use source file name */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SnapshotGlPictureRecorder2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SurfaceTexture f14199j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f14200k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ float f14201l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ float f14202m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ EGLContext f14203n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ SnapshotGlPictureRecorder f14204o;

    public SnapshotGlPictureRecorder2(SnapshotGlPictureRecorder snapshotGlPictureRecorder, SurfaceTexture surfaceTexture, int i, float f, float f2, EGLContext eGLContext) {
        this.f14204o = snapshotGlPictureRecorder;
        this.f14199j = surfaceTexture;
        this.f14200k = i;
        this.f14201l = f;
        this.f14202m = f2;
        this.f14203n = eGLContext;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        SnapshotGlPictureRecorder snapshotGlPictureRecorder = this.f14204o;
        SurfaceTexture surfaceTexture = this.f14199j;
        int i = this.f14200k;
        float f = this.f14201l;
        float f2 = this.f14202m;
        EGLContext eGLContext = this.f14203n;
        Objects.requireNonNull(snapshotGlPictureRecorder);
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(9999);
        Size3 size3 = snapshotGlPictureRecorder.f14172j.f13718d;
        surfaceTexture2.setDefaultBufferSize(size3.f14251j, size3.f14252k);
        EglCore eglCore = new EglCore(eGLContext, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(eglCore, surfaceTexture2);
        EglCore eglCore2 = eglWindowSurface.f14327a;
        egl5 egl5Var = eglWindowSurface.f14328b;
        Objects.requireNonNull(eglCore2);
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        if (eglCore2.f14260a == egl4.f14272b) {
            Log.v("EglCore", "NOTE: makeSurfaceCurrent w/o display");
        }
        egl3 egl3Var = eglCore2.f14260a;
        egl2 egl2Var = eglCore2.f14261b;
        EGLDisplay eGLDisplay = egl3Var.f14270a;
        EGLSurface eGLSurface = egl5Var.f14290a;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, egl2Var.f14269a)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
        float[] fArr = snapshotGlPictureRecorder.f14197s.f14106b;
        surfaceTexture.getTransformMatrix(fArr);
        Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, i + snapshotGlPictureRecorder.f14172j.f13717c, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
        if (snapshotGlPictureRecorder.f14195q) {
            OverlayDrawer overlayDrawer = snapshotGlPictureRecorder.f14196r;
            Overlay.a aVar = Overlay.a.PICTURE_SNAPSHOT;
            Objects.requireNonNull(overlayDrawer);
            try {
                Canvas canvasLockCanvas = (Build.VERSION.SDK_INT < 23 || !((OverlayLayout) overlayDrawer.f14148b).getHardwareCanvasEnabled()) ? overlayDrawer.f14150d.lockCanvas(null) : overlayDrawer.f14150d.lockHardwareCanvas();
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                ((OverlayLayout) overlayDrawer.f14148b).m7412a(aVar, canvasLockCanvas);
                overlayDrawer.f14150d.unlockCanvasAndPost(canvasLockCanvas);
            } catch (Surface.OutOfResourcesException e) {
                OverlayDrawer.f14147a.m7159a(2, "Got Surface.OutOfResourcesException while drawing video overlays", e);
            }
            synchronized (overlayDrawer.f14153g) {
                GLES20.glBindTexture(36197, overlayDrawer.f14152f.f14116a);
                overlayDrawer.f14149c.updateTexImage();
            }
            overlayDrawer.f14149c.getTransformMatrix(overlayDrawer.f14151e.f14106b);
            Matrix.translateM(snapshotGlPictureRecorder.f14196r.f14151e.f14106b, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(snapshotGlPictureRecorder.f14196r.f14151e.f14106b, 0, snapshotGlPictureRecorder.f14172j.f13717c, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(snapshotGlPictureRecorder.f14196r.f14151e.f14106b, 0, 1.0f, -1.0f, 1.0f);
            Matrix.translateM(snapshotGlPictureRecorder.f14196r.f14151e.f14106b, 0, -0.5f, -0.5f, 0.0f);
        }
        snapshotGlPictureRecorder.f14172j.f13717c = 0;
        long timestamp = surfaceTexture.getTimestamp() / 1000;
        SnapshotPictureRecorder.f14205m.m7159a(1, "takeFrame:", "timestampUs:", Long.valueOf(timestamp));
        snapshotGlPictureRecorder.f14197s.m7399a(timestamp);
        if (snapshotGlPictureRecorder.f14195q) {
            OverlayDrawer overlayDrawer2 = snapshotGlPictureRecorder.f14196r;
            Objects.requireNonNull(overlayDrawer2);
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            synchronized (overlayDrawer2.f14153g) {
                overlayDrawer2.f14151e.m7399a(timestamp);
            }
        }
        PictureResult.a aVar2 = snapshotGlPictureRecorder.f14172j;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        Intrinsics3.checkNotNullParameter(compressFormat, "format");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            eglWindowSurface.m7460a(byteArrayOutputStream, compressFormat);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics3.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            Closeable.closeFinally(byteArrayOutputStream, null);
            aVar2.f13720f = byteArray;
            EglCore eglCore3 = eglWindowSurface.f14327a;
            egl5 egl5Var2 = eglWindowSurface.f14328b;
            Objects.requireNonNull(eglCore3);
            Intrinsics3.checkNotNullParameter(egl5Var2, "eglSurface");
            EGL14.eglDestroySurface(eglCore3.f14260a.f14270a, egl5Var2.f14290a);
            eglWindowSurface.f14328b = egl4.f14273c;
            eglWindowSurface.f14330d = -1;
            eglWindowSurface.f14329c = -1;
            snapshotGlPictureRecorder.f14197s.m7400b();
            surfaceTexture2.release();
            if (snapshotGlPictureRecorder.f14195q) {
                OverlayDrawer overlayDrawer3 = snapshotGlPictureRecorder.f14196r;
                if (overlayDrawer3.f14152f != null) {
                    GLES20.glBindTexture(36197, 0);
                    overlayDrawer3.f14152f = null;
                }
                SurfaceTexture surfaceTexture3 = overlayDrawer3.f14149c;
                if (surfaceTexture3 != null) {
                    surfaceTexture3.release();
                    overlayDrawer3.f14149c = null;
                }
                Surface surface = overlayDrawer3.f14150d;
                if (surface != null) {
                    surface.release();
                    overlayDrawer3.f14150d = null;
                }
                GlTextureDrawer glTextureDrawer = overlayDrawer3.f14151e;
                if (glTextureDrawer != null) {
                    glTextureDrawer.m7400b();
                    overlayDrawer3.f14151e = null;
                }
            }
            eglCore.m7453b();
            snapshotGlPictureRecorder.mo7416b();
        } finally {
        }
    }
}
