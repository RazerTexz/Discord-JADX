package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2857d implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7519a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7520b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f7521c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f7522d;

    public /* synthetic */ C2857d(AnalyticsListener.a aVar, String str, long j, long j2) {
        this.f7519a = aVar;
        this.f7520b = str;
        this.f7521c = j;
        this.f7522d = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3435i0();
        analyticsListener.m3404M();
        analyticsListener.m3411T();
    }
}
