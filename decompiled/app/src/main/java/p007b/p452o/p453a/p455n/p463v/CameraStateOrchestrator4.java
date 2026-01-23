package p007b.p452o.p453a.p455n.p463v;

/* JADX INFO: renamed from: b.o.a.n.v.i, reason: use source file name */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraStateOrchestrator4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CameraState2 f14043j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f14044k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ CameraStateOrchestrator f14045l;

    public CameraStateOrchestrator4(CameraStateOrchestrator cameraStateOrchestrator, CameraState2 cameraState2, Runnable runnable) {
        this.f14045l = cameraStateOrchestrator;
        this.f14043j = cameraState2;
        this.f14044k = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14045l.f14028f.m7367f(this.f14043j)) {
            this.f14044k.run();
        }
    }
}
