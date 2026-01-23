package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.o.a.n.v.g, reason: use source file name */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraStateOrchestrator2<T> implements InterfaceC4353a<T, Task<T>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CameraStateOrchestrator.b f14039a;

    public CameraStateOrchestrator2(CameraStateOrchestrator.b bVar) {
        this.f14039a = bVar;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public Object mo4012a(@NonNull Task task) throws Exception {
        if (task.mo6021p() || this.f14039a.f14037n) {
            CameraStateOrchestrator.b bVar = this.f14039a;
            CameraStateOrchestrator.this.f14028f = bVar.f14035l;
        }
        return task;
    }
}
