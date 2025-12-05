package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2919e implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7724j;

    /* renamed from: k */
    public final /* synthetic */ Format2 f7725k;

    /* renamed from: l */
    public final /* synthetic */ DecoderReuseEvaluation f7726l;

    public /* synthetic */ RunnableC2919e(AudioRendererEventListener2.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f7724j = aVar;
        this.f7725k = format2;
        this.f7726l = decoderReuseEvaluation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7724j;
        Format2 format2 = this.f7725k;
        DecoderReuseEvaluation decoderReuseEvaluation = this.f7726l;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3297U(format2);
        aVar.f7791b.mo3293I(format2, decoderReuseEvaluation);
    }
}
