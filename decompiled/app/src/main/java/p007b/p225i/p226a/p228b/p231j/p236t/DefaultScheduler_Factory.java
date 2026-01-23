package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendRegistry;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkScheduler;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.d, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultScheduler_Factory implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final Provider3<Executor> f5342a;

    /* JADX INFO: renamed from: b */
    public final Provider3<BackendRegistry> f5343b;

    /* JADX INFO: renamed from: c */
    public final Provider3<WorkScheduler> f5344c;

    /* JADX INFO: renamed from: d */
    public final Provider3<EventStore> f5345d;

    /* JADX INFO: renamed from: e */
    public final Provider3<SynchronizationGuard> f5346e;

    public DefaultScheduler_Factory(Provider3<Executor> provider3, Provider3<BackendRegistry> provider32, Provider3<WorkScheduler> provider33, Provider3<EventStore> provider34, Provider3<SynchronizationGuard> provider35) {
        this.f5342a = provider3;
        this.f5343b = provider32;
        this.f5344c = provider33;
        this.f5345d = provider34;
        this.f5346e = provider35;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new DefaultScheduler3(this.f5342a.get(), this.f5343b.get(), this.f5344c.get(), this.f5345d.get(), this.f5346e.get());
    }
}
