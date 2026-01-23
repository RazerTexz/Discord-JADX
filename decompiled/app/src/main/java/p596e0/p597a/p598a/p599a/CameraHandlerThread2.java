package p596e0.p597a.p598a.p599a;

import android.os.HandlerThread;

/* JADX INFO: renamed from: e0.a.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraHandlerThread2 extends HandlerThread {

    /* JADX INFO: renamed from: j */
    public BarcodeScannerView f25320j;

    public CameraHandlerThread2(BarcodeScannerView barcodeScannerView) {
        super("CameraHandlerThread");
        this.f25320j = barcodeScannerView;
        start();
    }
}
