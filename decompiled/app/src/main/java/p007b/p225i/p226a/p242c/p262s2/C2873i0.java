package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* JADX INFO: renamed from: b.i.a.c.s2.i0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2873i0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7580a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Format2 f7581b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DecoderReuseEvaluation f7582c;

    public /* synthetic */ C2873i0(AnalyticsListener.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f7580a = aVar;
        this.f7581b = format2;
        this.f7582c = decoderReuseEvaluation;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3425d0();
        analyticsListener.m3455v();
        analyticsListener.m3457x();
    }
}
