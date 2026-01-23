package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.q */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2888q implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7613a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MediaItem2 f7614b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7615c;

    public /* synthetic */ C2888q(AnalyticsListener.a aVar, MediaItem2 mediaItem2, int i) {
        this.f7613a = aVar;
        this.f7614b = mediaItem2;
        this.f7615c = i;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3453t();
    }
}
