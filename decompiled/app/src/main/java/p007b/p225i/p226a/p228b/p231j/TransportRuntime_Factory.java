package p007b.p225i.p226a.p228b.p231j;

import p007b.p225i.p226a.p228b.p231j.p236t.Scheduler2;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader6;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkInitializer3;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* compiled from: TransportRuntime_Factory.java */
/* renamed from: b.i.a.b.j.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class TransportRuntime_Factory implements Provider3 {

    /* renamed from: a */
    public final Provider3<Clock3> f5295a;

    /* renamed from: b */
    public final Provider3<Clock3> f5296b;

    /* renamed from: c */
    public final Provider3<Scheduler2> f5297c;

    /* renamed from: d */
    public final Provider3<Uploader6> f5298d;

    /* renamed from: e */
    public final Provider3<WorkInitializer3> f5299e;

    public TransportRuntime_Factory(Provider3<Clock3> provider3, Provider3<Clock3> provider32, Provider3<Scheduler2> provider33, Provider3<Uploader6> provider34, Provider3<WorkInitializer3> provider35) {
        this.f5295a = provider3;
        this.f5296b = provider32;
        this.f5297c = provider33;
        this.f5298d = provider34;
        this.f5299e = provider35;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new TransportRuntime(this.f5295a.get(), this.f5296b.get(), this.f5297c.get(), this.f5298d.get(), this.f5299e.get());
    }
}
