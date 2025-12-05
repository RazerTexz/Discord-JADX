package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2768e implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6815j;

    /* renamed from: k */
    public final /* synthetic */ Exception f6816k;

    public /* synthetic */ RunnableC2768e(VideoRendererEventListener2.a aVar, Exception exc) {
        this.f6815j = aVar;
        this.f6816k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6815j;
        Exception exc = this.f6816k;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3190V(exc);
    }
}
