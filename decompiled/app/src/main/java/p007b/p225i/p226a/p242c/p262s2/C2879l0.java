package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.l0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2879l0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7595a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7596b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f7597c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f7598d;

    public /* synthetic */ C2879l0(AnalyticsListener.a aVar, String str, long j, long j2) {
        this.f7595a = aVar;
        this.f7596b = str;
        this.f7597c = j;
        this.f7598d = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3439k0();
        analyticsListener.m3412U();
        analyticsListener.m3411T();
    }
}
