package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.r */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2890r implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7618a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7619b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Player2.f f7620c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Player2.f f7621d;

    public /* synthetic */ C2890r(AnalyticsListener.a aVar, int i, Player2.f fVar, Player2.f fVar2) {
        this.f7618a = aVar;
        this.f7619b = i;
        this.f7620c = fVar;
        this.f7621d = fVar2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3410S();
        analyticsListener.m3458y();
    }
}
