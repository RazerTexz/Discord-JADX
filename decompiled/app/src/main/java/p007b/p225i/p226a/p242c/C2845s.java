package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* JADX INFO: renamed from: b.i.a.c.s */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2845s implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PlaybackInfo f7478a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7479b;

    public /* synthetic */ C2845s(PlaybackInfo playbackInfo, int i) {
        this.f7478a = playbackInfo;
        this.f7479b = i;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.f7478a;
        ((Player2.c) obj).mo242W(playbackInfo.f7958m, this.f7479b);
    }
}
