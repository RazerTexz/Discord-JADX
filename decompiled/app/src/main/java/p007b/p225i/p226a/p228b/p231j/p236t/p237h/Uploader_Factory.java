package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.content.Context;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendRegistry;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.m, reason: use source file name */
/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Uploader_Factory implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final Provider3<Context> f5392a;

    /* JADX INFO: renamed from: b */
    public final Provider3<BackendRegistry> f5393b;

    /* JADX INFO: renamed from: c */
    public final Provider3<EventStore> f5394c;

    /* JADX INFO: renamed from: d */
    public final Provider3<WorkScheduler> f5395d;

    /* JADX INFO: renamed from: e */
    public final Provider3<Executor> f5396e;

    /* JADX INFO: renamed from: f */
    public final Provider3<SynchronizationGuard> f5397f;

    /* JADX INFO: renamed from: g */
    public final Provider3<Clock3> f5398g;

    public Uploader_Factory(Provider3<Context> provider3, Provider3<BackendRegistry> provider32, Provider3<EventStore> provider33, Provider3<WorkScheduler> provider34, Provider3<Executor> provider35, Provider3<SynchronizationGuard> provider36, Provider3<Clock3> provider37) {
        this.f5392a = provider3;
        this.f5393b = provider32;
        this.f5394c = provider33;
        this.f5395d = provider34;
        this.f5396e = provider35;
        this.f5397f = provider36;
        this.f5398g = provider37;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new Uploader6(this.f5392a.get(), this.f5393b.get(), this.f5394c.get(), this.f5395d.get(), this.f5396e.get(), this.f5397f.get(), this.f5398g.get());
    }
}
