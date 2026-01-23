package p596e0.p597a.p598a.p599a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: e0.a.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraHandlerThread implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f25316j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CameraHandlerThread2 f25317k;

    /* JADX INFO: renamed from: e0.a.a.a.b$a */
    /* JADX INFO: compiled from: CameraHandlerThread.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Camera f25318j;

        public a(Camera camera) {
            this.f25318j = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraHandlerThread cameraHandlerThread = CameraHandlerThread.this;
            BarcodeScannerView barcodeScannerView = cameraHandlerThread.f25317k.f25320j;
            Camera camera = this.f25318j;
            barcodeScannerView.setupCameraPreview(camera == null ? null : new CameraWrapper(camera, cameraHandlerThread.f25316j));
        }
    }

    public CameraHandlerThread(CameraHandlerThread2 cameraHandlerThread2, int i) {
        this.f25317k = cameraHandlerThread2;
        this.f25316j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera cameraOpen;
        int i = this.f25316j;
        try {
            cameraOpen = i == -1 ? Camera.open() : Camera.open(i);
        } catch (Exception unused) {
            cameraOpen = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(cameraOpen));
    }
}
