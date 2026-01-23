package p007b.p452o.p453a.p472w;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: b.o.a.w.g, reason: use source file name */
/* JADX INFO: compiled from: SurfaceCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class SurfaceCameraPreview implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SurfaceCameraPreview2 f14237j;

    public SurfaceCameraPreview(SurfaceCameraPreview2 surfaceCameraPreview2) {
        this.f14237j = surfaceCameraPreview2;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SurfaceCameraPreview2.f14238j.m7159a(1, "callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(this.f14237j.f14239k));
        SurfaceCameraPreview2 surfaceCameraPreview2 = this.f14237j;
        if (surfaceCameraPreview2.f14239k) {
            surfaceCameraPreview2.m7428h(i2, i3);
        } else {
            surfaceCameraPreview2.m7426f(i2, i3);
            this.f14237j.f14239k = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceCameraPreview2.f14238j.m7159a(1, "callback: surfaceCreated.");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceCameraPreview2.f14238j.m7159a(1, "callback: surfaceDestroyed");
        this.f14237j.m7427g();
        this.f14237j.f14239k = false;
    }
}
