package p007b.p225i.p226a.p228b.p231j.p236t;

import android.content.Context;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.JobInfoScheduler;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* renamed from: b.i.a.b.j.t.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Provider3 {

    /* renamed from: a */
    public final Provider3<Context> f5348a;

    /* renamed from: b */
    public final Provider3<EventStore> f5349b;

    /* renamed from: c */
    public final Provider3<SchedulerConfig> f5350c;

    /* renamed from: d */
    public final Provider3<Clock3> f5351d;

    public SchedulingModule_WorkSchedulerFactory(Provider3<Context> provider3, Provider3<EventStore> provider32, Provider3<SchedulerConfig> provider33, Provider3<Clock3> provider34) {
        this.f5348a = provider3;
        this.f5349b = provider32;
        this.f5350c = provider33;
        this.f5351d = provider34;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        Context context = this.f5348a.get();
        EventStore eventStore = this.f5349b.get();
        SchedulerConfig schedulerConfig = this.f5350c.get();
        this.f5351d.get();
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
