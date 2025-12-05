package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p243a3.LoadEventInfo;
import p007b.p225i.p226a.p242c.p243a3.MediaLoadData;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.s2.y */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2904y implements ListenerSet.a {

    /* renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7646a;

    /* renamed from: b */
    public final /* synthetic */ LoadEventInfo f7647b;

    /* renamed from: c */
    public final /* synthetic */ MediaLoadData f7648c;

    public /* synthetic */ C2904y(AnalyticsListener.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7646a = aVar;
        this.f7647b = loadEventInfo;
        this.f7648c = mediaLoadData;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3448p();
    }
}
