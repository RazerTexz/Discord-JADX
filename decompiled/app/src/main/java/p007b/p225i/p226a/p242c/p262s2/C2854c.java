package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2854c implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7510a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Exception f7511b;

    public /* synthetic */ C2854c(AnalyticsListener.a aVar, Exception exc) {
        this.f7510a = aVar;
        this.f7511b = exc;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3444n();
    }
}
