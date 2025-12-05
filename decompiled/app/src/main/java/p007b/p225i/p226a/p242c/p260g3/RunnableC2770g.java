package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.g */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2770g implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6819j;

    /* renamed from: k */
    public final /* synthetic */ Object f6820k;

    /* renamed from: l */
    public final /* synthetic */ long f6821l;

    public /* synthetic */ RunnableC2770g(VideoRendererEventListener2.a aVar, Object obj, long j) {
        this.f6819j = aVar;
        this.f6820k = obj;
        this.f6821l = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6819j;
        Object obj = this.f6820k;
        long j = this.f6821l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3186K(obj, j);
    }
}
