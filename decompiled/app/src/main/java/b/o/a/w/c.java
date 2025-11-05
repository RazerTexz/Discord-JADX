package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import b.o.a.w.d;

/* compiled from: GlCameraPreview.java */
/* loaded from: classes3.dex */
public class c implements SurfaceHolder.Callback {
    public final /* synthetic */ GLSurfaceView j;
    public final /* synthetic */ d.c k;
    public final /* synthetic */ d l;

    /* compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.c cVar = c.this.k;
            SurfaceTexture surfaceTexture = d.this.k;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                d.this.k.release();
                d.this.k = null;
            }
            b.o.a.r.c cVar2 = d.this.l;
            if (cVar2 != null) {
                cVar2.b();
                d.this.l = null;
            }
        }
    }

    public c(d dVar, GLSurfaceView gLSurfaceView, d.c cVar) {
        this.l = dVar;
        this.j = gLSurfaceView;
        this.k = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.l.g();
        this.j.queueEvent(new a());
        this.l.j = false;
    }
}
