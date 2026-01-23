package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* JADX INFO: renamed from: b.i.a.c.s2.d0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2858d0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7523a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DecoderCounters f7524b;

    public /* synthetic */ C2858d0(AnalyticsListener.a aVar, DecoderCounters decoderCounters) {
        this.f7523a = aVar;
        this.f7524b = decoderCounters;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3417Z();
        analyticsListener.m3397F();
    }
}
