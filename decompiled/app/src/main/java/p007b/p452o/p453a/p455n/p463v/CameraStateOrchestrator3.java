package p007b.p452o.p453a.p455n.p463v;

/* compiled from: CameraStateOrchestrator.java */
/* renamed from: b.o.a.n.v.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraStateOrchestrator3 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CameraState2 f14040j;

    /* renamed from: k */
    public final /* synthetic */ Runnable f14041k;

    /* renamed from: l */
    public final /* synthetic */ CameraStateOrchestrator f14042l;

    public CameraStateOrchestrator3(CameraStateOrchestrator cameraStateOrchestrator, CameraState2 cameraState2, Runnable runnable) {
        this.f14042l = cameraStateOrchestrator;
        this.f14040j = cameraState2;
        this.f14041k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14042l.f14028f.m7367f(this.f14040j)) {
            this.f14041k.run();
        }
    }
}
