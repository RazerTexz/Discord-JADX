package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.m */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2880m implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7599a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PlaybackParameters f7600b;

    public /* synthetic */ C2880m(AnalyticsListener.a aVar, PlaybackParameters playbackParameters) {
        this.f7599a = aVar;
        this.f7600b = playbackParameters;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3400I();
    }
}
