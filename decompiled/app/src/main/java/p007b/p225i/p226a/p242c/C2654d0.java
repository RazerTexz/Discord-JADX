package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* JADX INFO: renamed from: b.i.a.c.d0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2654d0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PlaybackInfo f6332a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f6333b;

    public /* synthetic */ C2654d0(PlaybackInfo playbackInfo, int i) {
        this.f6332a = playbackInfo;
        this.f6333b = i;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.f6332a;
        ((Player2.c) obj).mo262v(playbackInfo.f7947b, this.f6333b);
    }
}
