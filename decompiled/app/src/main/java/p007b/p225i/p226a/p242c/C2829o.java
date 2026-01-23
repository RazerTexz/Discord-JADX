package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* JADX INFO: renamed from: b.i.a.c.o */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2829o implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PlaybackInfo f7259a;

    public /* synthetic */ C2829o(PlaybackInfo playbackInfo) {
        this.f7259a = playbackInfo;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.f7259a;
        Player2.c cVar = (Player2.c) obj;
        cVar.mo255i(playbackInfo.f7953h);
        cVar.mo259r(playbackInfo.f7953h);
    }
}
