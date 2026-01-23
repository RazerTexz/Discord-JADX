package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.Iterator;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.o, reason: use source file name */
/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WorkInitializer2 implements SynchronizationGuard.a {

    /* JADX INFO: renamed from: a */
    public final WorkInitializer3 f5400a;

    public WorkInitializer2(WorkInitializer3 workInitializer3) {
        this.f5400a = workInitializer3;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard.a
    public Object execute() {
        WorkInitializer3 workInitializer3 = this.f5400a;
        Iterator<TransportContext> it = workInitializer3.f5402b.mo2402z().iterator();
        while (it.hasNext()) {
            workInitializer3.f5403c.mo2382a(it.next(), 1);
        }
        return null;
    }
}
