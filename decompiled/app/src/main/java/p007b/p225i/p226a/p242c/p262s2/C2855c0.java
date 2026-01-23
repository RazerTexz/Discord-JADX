package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.c0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2855c0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7512a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7513b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f7514c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f7515d;

    public /* synthetic */ C2855c0(AnalyticsListener.a aVar, int i, long j, long j2) {
        this.f7512a = aVar;
        this.f7513b = i;
        this.f7514c = j;
        this.f7515d = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3394C();
    }
}
