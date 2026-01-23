package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* JADX INFO: renamed from: b.i.a.c.e0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2676e0 implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PlaybackInfo f6411a;

    public /* synthetic */ C2676e0(PlaybackInfo playbackInfo) {
        this.f6411a = playbackInfo;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.f6411a;
        ((Player2.c) obj).mo239H(playbackInfo.f7958m, playbackInfo.f7951f);
    }
}
