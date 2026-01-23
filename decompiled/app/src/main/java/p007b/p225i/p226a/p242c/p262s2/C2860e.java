package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.e */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2860e implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7528a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f7529b;

    public /* synthetic */ C2860e(AnalyticsListener.a aVar, boolean z2) {
        this.f7528a = aVar;
        this.f7529b = z2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3403L();
        analyticsListener.m3408Q();
    }
}
