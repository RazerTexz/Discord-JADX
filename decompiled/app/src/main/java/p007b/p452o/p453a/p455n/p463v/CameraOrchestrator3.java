package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p463v.CameraOrchestrator;
import p007b.p452o.p453a.p467r.WorkerHandler;

/* JADX INFO: renamed from: b.o.a.n.v.c, reason: use source file name */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraOrchestrator3 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CameraOrchestrator.c f14017j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ WorkerHandler f14018k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ CameraOrchestrator f14019l;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.c$a */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public class a<T> implements InterfaceC4357c<T> {
        public a() {
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<T> task) {
            Exception excMo6016k = task.mo6016k();
            if (excMo6016k != null) {
                CameraOrchestrator.f14005a.m7159a(2, CameraOrchestrator3.this.f14017j.f14011a.toUpperCase(), "- Finished with ERROR.", excMo6016k);
                CameraOrchestrator3 cameraOrchestrator3 = CameraOrchestrator3.this;
                if (cameraOrchestrator3.f14017j.f14014d) {
                    CameraEngine.m7317b(CameraEngine.this, excMo6016k, false);
                }
                CameraOrchestrator3.this.f14017j.f14012b.m9125a(excMo6016k);
            } else if (task.mo6019n()) {
                CameraOrchestrator.f14005a.m7159a(1, CameraOrchestrator3.this.f14017j.f14011a.toUpperCase(), "- Finished because ABORTED.");
                CameraOrchestrator3.this.f14017j.f14012b.m9125a(new CancellationException());
            } else {
                CameraOrchestrator.f14005a.m7159a(1, CameraOrchestrator3.this.f14017j.f14011a.toUpperCase(), "- Finished.");
                CameraOrchestrator3.this.f14017j.f14012b.m9126b(task.mo6017l());
            }
            synchronized (CameraOrchestrator3.this.f14019l.f14009e) {
                CameraOrchestrator3 cameraOrchestrator32 = CameraOrchestrator3.this;
                CameraOrchestrator.m7362a(cameraOrchestrator32.f14019l, cameraOrchestrator32.f14017j);
            }
        }
    }

    public CameraOrchestrator3(CameraOrchestrator cameraOrchestrator, CameraOrchestrator.c cVar, WorkerHandler workerHandler) {
        this.f14019l = cameraOrchestrator;
        this.f14017j = cVar;
        this.f14018k = workerHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CameraOrchestrator.f14005a.m7159a(1, this.f14017j.f14011a.toUpperCase(), "- Executing.");
            Task task = (Task) this.f14017j.f14013c.call();
            WorkerHandler workerHandler = this.f14018k;
            a aVar = new a();
            if (task.mo6020o()) {
                workerHandler.m7404c(new CameraOrchestrator4(aVar, task));
            } else {
                task.mo6008c(workerHandler.f14133g, aVar);
            }
        } catch (Exception e) {
            CameraOrchestrator.f14005a.m7159a(1, this.f14017j.f14011a.toUpperCase(), "- Finished with ERROR.", e);
            if (this.f14017j.f14014d) {
                CameraEngine.m7317b(CameraEngine.this, e, false);
            }
            this.f14017j.f14012b.m9125a(e);
            synchronized (this.f14019l.f14009e) {
                CameraOrchestrator.m7362a(this.f14019l, this.f14017j);
            }
        }
    }
}
