package p007b.p225i.p226a.p242c.p262s2;

import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.i */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2872i implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7577a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TrackGroupArray f7578b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ TrackSelectionArray f7579c;

    public /* synthetic */ C2872i(AnalyticsListener.a aVar, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.f7577a = aVar;
        this.f7578b = trackGroupArray;
        this.f7579c = trackSelectionArray;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3443m0();
    }
}
