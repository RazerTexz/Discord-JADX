package p007b.p225i.p226a.p242c.p262s2;

import com.google.android.exoplayer2.PlaybackException;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2848a implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsListener.a f7499a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PlaybackException f7500b;

    public /* synthetic */ C2848a(AnalyticsListener.a aVar, PlaybackException playbackException) {
        this.f7499a = aVar;
        this.f7500b = playbackException;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m3401J();
    }
}
