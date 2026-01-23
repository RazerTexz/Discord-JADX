package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.p */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2886p implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AnalyticsCollector f7610j;

    public /* synthetic */ RunnableC2886p(AnalyticsCollector analyticsCollector) {
        this.f7610j = analyticsCollector;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnalyticsCollector analyticsCollector = this.f7610j;
        AnalyticsListener.a aVarM3382k0 = analyticsCollector.m3382k0();
        C2903x0 c2903x0 = new C2903x0(aVarM3382k0);
        analyticsCollector.f7551n.put(1036, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.f7552o;
        listenerSet.m3035b(1036, c2903x0);
        listenerSet.m3034a();
        analyticsCollector.f7552o.m3036c();
    }
}
