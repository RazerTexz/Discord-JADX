package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.g3.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2767d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6813j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f6814k;

    public /* synthetic */ RunnableC2767d(VideoRendererEventListener2.a aVar, String str) {
        this.f6813j = aVar;
        this.f6814k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6813j;
        String str = this.f6814k;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3194l(str);
    }
}
