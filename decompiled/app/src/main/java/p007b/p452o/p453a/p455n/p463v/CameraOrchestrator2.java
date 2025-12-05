package p007b.p452o.p453a.p455n.p463v;

import java.util.Iterator;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p463v.CameraOrchestrator;
import p007b.p452o.p453a.p467r.WorkerHandler;

/* compiled from: CameraOrchestrator.java */
/* renamed from: b.o.a.n.v.b, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraOrchestrator2 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CameraOrchestrator f14016j;

    public CameraOrchestrator2(CameraOrchestrator cameraOrchestrator) {
        this.f14016j = cameraOrchestrator;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraOrchestrator.c<?> cVar;
        synchronized (this.f14016j.f14009e) {
            cVar = null;
            if (!this.f14016j.f14008d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<CameraOrchestrator.c<?>> it = this.f14016j.f14007c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CameraOrchestrator.c<?> next = it.next();
                    if (next.f14015e <= jCurrentTimeMillis) {
                        cVar = next;
                        break;
                    }
                }
                if (cVar != null) {
                    this.f14016j.f14008d = true;
                }
            }
        }
        if (cVar != null) {
            CameraOrchestrator cameraOrchestrator = this.f14016j;
            WorkerHandler workerHandler = CameraEngine.this.f13919k;
            workerHandler.m7404c(new CameraOrchestrator3(cameraOrchestrator, cVar, workerHandler));
        }
    }
}
