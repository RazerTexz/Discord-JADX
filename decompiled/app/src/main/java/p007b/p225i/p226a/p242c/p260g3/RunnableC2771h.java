package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.g3.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2771h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6822j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f6823k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f6824l;

    public /* synthetic */ RunnableC2771h(VideoRendererEventListener2.a aVar, int i, long j) {
        this.f6822j = aVar;
        this.f6823k = i;
        this.f6824l = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6822j;
        int i = this.f6823k;
        long j = this.f6824l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i2 = Util2.f6708a;
        videoRendererEventListener2.mo3185F(i, j);
    }
}
