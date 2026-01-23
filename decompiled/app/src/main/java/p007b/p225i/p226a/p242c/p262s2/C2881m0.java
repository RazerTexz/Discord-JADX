package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.m0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2881m0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7601a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VideoSize f7602b;

    public /* synthetic */ C2881m0(AnalyticsListener.a aVar, VideoSize videoSize) {
        this.f7601a = aVar;
        this.f7602b = videoSize;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        VideoSize videoSize = this.f7602b;
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m3445n0();
        int i = videoSize.f6955k;
        analyticsListener.m3451r();
    }
}
