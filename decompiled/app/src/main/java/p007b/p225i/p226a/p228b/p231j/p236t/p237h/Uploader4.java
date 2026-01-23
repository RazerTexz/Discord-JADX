package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.j, reason: use source file name */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Uploader4 implements SynchronizationGuard.a {

    /* JADX INFO: renamed from: a */
    public final EventStore f5381a;

    public Uploader4(EventStore eventStore) {
        this.f5381a = eventStore;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard.a
    public Object execute() {
        return Integer.valueOf(this.f5381a.mo2396l());
    }
}
