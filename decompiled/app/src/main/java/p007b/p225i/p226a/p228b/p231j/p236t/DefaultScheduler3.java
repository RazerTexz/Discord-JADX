package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p007b.p225i.p226a.p228b.TransportScheduleCallback;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportRuntime;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendRegistry;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkScheduler;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* JADX INFO: renamed from: b.i.a.b.j.t.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultScheduler3 implements Scheduler2 {

    /* JADX INFO: renamed from: a */
    public static final Logger f5336a = Logger.getLogger(TransportRuntime.class.getName());

    /* JADX INFO: renamed from: b */
    public final WorkScheduler f5337b;

    /* JADX INFO: renamed from: c */
    public final Executor f5338c;

    /* JADX INFO: renamed from: d */
    public final BackendRegistry f5339d;

    /* JADX INFO: renamed from: e */
    public final EventStore f5340e;

    /* JADX INFO: renamed from: f */
    public final SynchronizationGuard f5341f;

    public DefaultScheduler3(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f5338c = executor;
        this.f5339d = backendRegistry;
        this.f5337b = workScheduler;
        this.f5340e = eventStore;
        this.f5341f = synchronizationGuard;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.Scheduler2
    /* JADX INFO: renamed from: a */
    public void mo2373a(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f5338c.execute(new DefaultScheduler(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
