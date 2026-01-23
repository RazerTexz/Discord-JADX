package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.g3.j */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2773j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6829j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ VideoSize f6830k;

    public /* synthetic */ RunnableC2773j(VideoRendererEventListener2.a aVar, VideoSize videoSize) {
        this.f6829j = aVar;
        this.f6830k = videoSize;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6829j;
        VideoSize videoSize = this.f6830k;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3192f(videoSize);
    }
}
