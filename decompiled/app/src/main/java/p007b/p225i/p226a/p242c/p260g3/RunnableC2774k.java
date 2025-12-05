package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2774k implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6831j;

    /* renamed from: k */
    public final /* synthetic */ Format2 f6832k;

    /* renamed from: l */
    public final /* synthetic */ DecoderReuseEvaluation f6833l;

    public /* synthetic */ RunnableC2774k(VideoRendererEventListener2.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f6831j = aVar;
        this.f6832k = format2;
        this.f6833l = decoderReuseEvaluation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6831j;
        Format2 format2 = this.f6832k;
        DecoderReuseEvaluation decoderReuseEvaluation = this.f6833l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3187O(format2);
        aVar.f6953b.mo3189Q(format2, decoderReuseEvaluation);
    }
}
