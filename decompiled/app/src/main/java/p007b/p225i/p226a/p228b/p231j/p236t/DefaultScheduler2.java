package p007b.p225i.p226a.p228b.p231j.p236t;

import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* JADX INFO: renamed from: b.i.a.b.j.t.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DefaultScheduler2 implements SynchronizationGuard.a {

    /* JADX INFO: renamed from: a */
    public final DefaultScheduler3 f5333a;

    /* JADX INFO: renamed from: b */
    public final TransportContext f5334b;

    /* JADX INFO: renamed from: c */
    public final EventInternal f5335c;

    public DefaultScheduler2(DefaultScheduler3 defaultScheduler3, TransportContext transportContext, EventInternal eventInternal) {
        this.f5333a = defaultScheduler3;
        this.f5334b = transportContext;
        this.f5335c = eventInternal;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard.a
    public Object execute() {
        DefaultScheduler3 defaultScheduler3 = this.f5333a;
        TransportContext transportContext = this.f5334b;
        defaultScheduler3.f5340e.mo2394a0(transportContext, this.f5335c);
        defaultScheduler3.f5337b.mo2382a(transportContext, 1);
        return null;
    }
}
