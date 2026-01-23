package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.Iterator;
import p007b.p225i.p226a.p242c.p260g3.p261z.SphericalGLSurfaceView;

/* JADX INFO: renamed from: b.i.a.c.g3.z.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2791c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SphericalGLSurfaceView f6962j;

    public /* synthetic */ RunnableC2791c(SphericalGLSurfaceView sphericalGLSurfaceView) {
        this.f6962j = sphericalGLSurfaceView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f6962j;
        Surface surface = sphericalGLSurfaceView.f7029r;
        if (surface != null) {
            Iterator<SphericalGLSurfaceView.b> it = sphericalGLSurfaceView.f7021j.iterator();
            while (it.hasNext()) {
                it.next().mo3204q(surface);
            }
        }
        SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f7028q;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
        sphericalGLSurfaceView.f7028q = null;
        sphericalGLSurfaceView.f7029r = null;
    }
}
