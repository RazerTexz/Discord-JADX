package p007b.p452o.p453a.p455n;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.n, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine6 implements Callable<Task<Void>> {

    /* renamed from: j */
    public final /* synthetic */ CameraEngine f13935j;

    public CameraEngine6(CameraEngine cameraEngine) {
        this.f13935j = cameraEngine;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.f13935j.mo7197T();
    }
}
