package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;
import p496c0.p497a.Provider3;

/* compiled from: WorkInitializer_Factory.java */
/* renamed from: b.i.a.b.j.t.h.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class WorkInitializer_Factory implements Provider3 {

    /* renamed from: a */
    public final Provider3<Executor> f5405a;

    /* renamed from: b */
    public final Provider3<EventStore> f5406b;

    /* renamed from: c */
    public final Provider3<WorkScheduler> f5407c;

    /* renamed from: d */
    public final Provider3<SynchronizationGuard> f5408d;

    public WorkInitializer_Factory(Provider3<Executor> provider3, Provider3<EventStore> provider32, Provider3<WorkScheduler> provider33, Provider3<SynchronizationGuard> provider34) {
        this.f5405a = provider3;
        this.f5406b = provider32;
        this.f5407c = provider33;
        this.f5408d = provider34;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new WorkInitializer3(this.f5405a.get(), this.f5406b.get(), this.f5407c.get(), this.f5408d.get());
    }
}
