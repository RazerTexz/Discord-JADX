package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* JADX INFO: renamed from: b.i.a.c.s2.l */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2878l implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7593a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DecoderCounters f7594b;

    public /* synthetic */ C2878l(AnalyticsListener.a aVar, DecoderCounters decoderCounters) {
        this.f7593a = aVar;
        this.f7594b = decoderCounters;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3432h();
        analyticsListener.m3397F();
    }
}
