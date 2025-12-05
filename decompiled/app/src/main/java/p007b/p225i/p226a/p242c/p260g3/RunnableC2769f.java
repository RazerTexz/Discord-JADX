package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.f */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2769f implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6817j;

    /* renamed from: k */
    public final /* synthetic */ DecoderCounters f6818k;

    public /* synthetic */ RunnableC2769f(VideoRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.f6817j = aVar;
        this.f6818k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6817j;
        DecoderCounters decoderCounters = this.f6818k;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3188P(decoderCounters);
    }
}
