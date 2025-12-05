package p007b.p452o.p453a.p455n;

import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.CameraLogger;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.j, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine2 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Throwable f13930j;

    /* renamed from: k */
    public final /* synthetic */ CameraEngine f13931k;

    public CameraEngine2(CameraEngine cameraEngine, Throwable th) {
        this.f13931k = cameraEngine;
        this.f13930j = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.f13930j;
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (cameraException.m9303a()) {
                CameraEngine.f13918j.m7159a(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                this.f13931k.m7329d(false, 0);
            }
            CameraEngine.f13918j.m7159a(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
            ((CameraView.C11195b) this.f13931k.f13921m).m9311a(cameraException);
            return;
        }
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
        this.f13931k.m7329d(true, 0);
        cameraLogger.m7159a(3, "EXCEPTION:", "Unexpected error! Throwing.");
        Throwable th2 = this.f13930j;
        if (!(th2 instanceof RuntimeException)) {
            throw new RuntimeException(this.f13930j);
        }
        throw ((RuntimeException) th2);
    }
}
