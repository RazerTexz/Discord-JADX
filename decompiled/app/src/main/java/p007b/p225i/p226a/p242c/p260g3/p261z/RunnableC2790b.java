package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.Iterator;
import p007b.p225i.p226a.p242c.p260g3.p261z.SphericalGLSurfaceView;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.z.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2790b implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ SphericalGLSurfaceView f6960j;

    /* renamed from: k */
    public final /* synthetic */ SurfaceTexture f6961k;

    public /* synthetic */ RunnableC2790b(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.f6960j = sphericalGLSurfaceView;
        this.f6961k = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f6960j;
        SurfaceTexture surfaceTexture = this.f6961k;
        SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView.f7028q;
        Surface surface = sphericalGLSurfaceView.f7029r;
        Surface surface2 = new Surface(surfaceTexture);
        sphericalGLSurfaceView.f7028q = surfaceTexture;
        sphericalGLSurfaceView.f7029r = surface2;
        Iterator<SphericalGLSurfaceView.b> it = sphericalGLSurfaceView.f7021j.iterator();
        while (it.hasNext()) {
            it.next().mo3205u(surface2);
        }
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
