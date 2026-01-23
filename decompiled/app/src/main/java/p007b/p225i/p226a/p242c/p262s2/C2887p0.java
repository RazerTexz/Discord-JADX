package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.p0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2887p0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7611a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7612b;

    public /* synthetic */ C2887p0(AnalyticsListener.a aVar, int i) {
        this.f7611a = aVar;
        this.f7612b = i;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3449p0();
        analyticsListener.m3415X();
    }
}
