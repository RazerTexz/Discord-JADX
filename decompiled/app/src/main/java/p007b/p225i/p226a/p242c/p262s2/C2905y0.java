package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* JADX INFO: renamed from: b.i.a.c.s2.y0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2905y0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7649a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Format2 f7650b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DecoderReuseEvaluation f7651c;

    public /* synthetic */ C2905y0(AnalyticsListener.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f7649a = aVar;
        this.f7650b = format2;
        this.f7651c = decoderReuseEvaluation;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3433h0();
        analyticsListener.m3393B();
        analyticsListener.m3457x();
    }
}
