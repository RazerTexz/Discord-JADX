package e0.a.a.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;

/* compiled from: CameraHandlerThread.java */
/* loaded from: classes3.dex */
public class b implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ c k;

    /* compiled from: CameraHandlerThread.java */
    public class a implements Runnable {
        public final /* synthetic */ Camera j;

        public a(Camera camera) {
            this.j = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            e0.a.a.a.a aVar = bVar.k.j;
            Camera camera = this.j;
            aVar.setupCameraPreview(camera == null ? null : new e(camera, bVar.j));
        }
    }

    public b(c cVar, int i) {
        this.k = cVar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera cameraOpen;
        int i = this.j;
        try {
            cameraOpen = i == -1 ? Camera.open() : Camera.open(i);
        } catch (Exception unused) {
            cameraOpen = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(cameraOpen));
    }
}
