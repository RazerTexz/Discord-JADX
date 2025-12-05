package p007b.p452o.p453a.p455n.p463v;

/* compiled from: CameraStateOrchestrator.java */
/* renamed from: b.o.a.n.v.i, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraStateOrchestrator4 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CameraState2 f14043j;

    /* renamed from: k */
    public final /* synthetic */ Runnable f14044k;

    /* renamed from: l */
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
