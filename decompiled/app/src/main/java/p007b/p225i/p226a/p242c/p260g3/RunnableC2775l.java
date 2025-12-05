package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.l */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2775l implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6834j;

    /* renamed from: k */
    public final /* synthetic */ long f6835k;

    /* renamed from: l */
    public final /* synthetic */ int f6836l;

    public /* synthetic */ RunnableC2775l(VideoRendererEventListener2.a aVar, long j, int i) {
        this.f6834j = aVar;
        this.f6835k = j;
        this.f6836l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6834j;
        long j = this.f6835k;
        int i = this.f6836l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i2 = Util2.f6708a;
        videoRendererEventListener2.mo3193h0(j, i);
    }
}
