package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p243a3.LoadEventInfo;
import p007b.p225i.p226a.p242c.p243a3.MediaLoadData;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.s2.h0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2870h0 implements ListenerSet.a {

    /* renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7564a;

    /* renamed from: b */
    public final /* synthetic */ LoadEventInfo f7565b;

    /* renamed from: c */
    public final /* synthetic */ MediaLoadData f7566c;

    public /* synthetic */ C2870h0(AnalyticsListener.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f7564a = aVar;
        this.f7565b = loadEventInfo;
        this.f7566c = mediaLoadData;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3438k();
    }
}
