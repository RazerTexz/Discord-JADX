package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* compiled from: lambda */
/* renamed from: b.i.a.c.q */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2837q implements ListenerSet.a {

    /* renamed from: a */
    public final /* synthetic */ PlaybackInfo f7439a;

    /* renamed from: b */
    public final /* synthetic */ TrackSelectionArray f7440b;

    public /* synthetic */ C2837q(PlaybackInfo playbackInfo, TrackSelectionArray trackSelectionArray) {
        this.f7439a = playbackInfo;
        this.f7440b = trackSelectionArray;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.f7439a;
        ((Player2.c) obj).mo243Y(playbackInfo.f7954i, this.f7440b);
    }
}
