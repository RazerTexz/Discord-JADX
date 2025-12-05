package p007b.p452o.p453a.p455n;

import p007b.p452o.p453a.p473x.Size3;

/* compiled from: CameraBaseEngine.java */
/* renamed from: b.o.a.n.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraBaseEngine2 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CameraBaseEngine f13917j;

    public CameraBaseEngine2(CameraBaseEngine cameraBaseEngine) {
        this.f13917j = cameraBaseEngine;
    }

    @Override // java.lang.Runnable
    public void run() {
        Size3 size3M7272R0 = this.f13917j.m7272R0();
        if (size3M7272R0.equals(this.f13917j.f13899s)) {
            CameraEngine.f13918j.m7159a(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
            return;
        }
        CameraEngine.f13918j.m7159a(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
        CameraBaseEngine cameraBaseEngine = this.f13917j;
        cameraBaseEngine.f13899s = size3M7272R0;
        cameraBaseEngine.mo7201X0();
    }
}
