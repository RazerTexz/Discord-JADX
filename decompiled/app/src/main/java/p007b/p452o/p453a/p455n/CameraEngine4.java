package p007b.p452o.p453a.p455n;

import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Callable;
import p007b.p452o.p453a.CameraOptions;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.l, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine4 implements Callable<Task<CameraOptions>> {

    /* renamed from: j */
    public final /* synthetic */ CameraEngine f13933j;

    public CameraEngine4(CameraEngine cameraEngine) {
        this.f13933j = cameraEngine;
    }

    @Override // java.util.concurrent.Callable
    public Task<CameraOptions> call() throws Exception {
        CameraEngine cameraEngine = this.f13933j;
        if (cameraEngine.mo7205c(cameraEngine.mo7292l())) {
            return this.f13933j.mo7194Q();
        }
        CameraEngine.f13918j.m7159a(3, "onStartEngine:", "No camera available for facing", this.f13933j.mo7292l());
        throw new CameraException(6);
    }
}
