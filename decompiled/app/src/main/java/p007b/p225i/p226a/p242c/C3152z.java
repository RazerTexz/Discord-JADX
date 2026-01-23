package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* JADX INFO: renamed from: b.i.a.c.z */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3152z implements ListenerSet.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ MediaItem2 f9123a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f9124b;

    public /* synthetic */ C3152z(MediaItem2 mediaItem2, int i) {
        this.f9123a = mediaItem2;
        this.f9124b = i;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).mo241M(this.f9123a, this.f9124b);
    }
}
