package p007b.p452o.p453a.p472w;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import p007b.p452o.p453a.p467r.GlTextureDrawer;
import p007b.p452o.p453a.p472w.GlCameraPreview2;

/* JADX INFO: renamed from: b.o.a.w.c, reason: use source file name */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlCameraPreview implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ GLSurfaceView f14217j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ GlCameraPreview2.c f14218k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ GlCameraPreview2 f14219l;

    /* JADX INFO: renamed from: b.o.a.w.c$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2.c cVar = GlCameraPreview.this.f14218k;
            SurfaceTexture surfaceTexture = GlCameraPreview2.this.f14222k;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                GlCameraPreview2.this.f14222k.release();
                GlCameraPreview2.this.f14222k = null;
            }
            GlTextureDrawer glTextureDrawer = GlCameraPreview2.this.f14223l;
            if (glTextureDrawer != null) {
                glTextureDrawer.m7400b();
                GlCameraPreview2.this.f14223l = null;
            }
        }
    }

    public GlCameraPreview(GlCameraPreview2 glCameraPreview2, GLSurfaceView gLSurfaceView, GlCameraPreview2.c cVar) {
        this.f14219l = glCameraPreview2;
        this.f14217j = gLSurfaceView;
        this.f14218k = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f14219l.m7427g();
        this.f14217j.queueEvent(new a());
        this.f14219l.f14221j = false;
    }
}
