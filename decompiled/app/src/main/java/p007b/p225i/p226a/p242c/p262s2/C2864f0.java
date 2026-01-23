package p007b.p225i.p226a.p242c.p262s2;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p243a3.LoadEventInfo;
import p007b.p225i.p226a.p242c.p243a3.MediaLoadData;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.f0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2864f0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7535a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LoadEventInfo f7536b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ MediaLoadData f7537c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ IOException f7538d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f7539e;

    public /* synthetic */ C2864f0(AnalyticsListener.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f7535a = aVar;
        this.f7536b = loadEventInfo;
        this.f7537c = mediaLoadData;
        this.f7538d = iOException;
        this.f7539e = z2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3454u();
    }
}
