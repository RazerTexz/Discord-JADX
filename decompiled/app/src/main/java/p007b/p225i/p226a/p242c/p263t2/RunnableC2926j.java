package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* JADX INFO: renamed from: b.i.a.c.t2.j */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2926j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7761j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DecoderCounters f7762k;

    public /* synthetic */ RunnableC2926j(AudioRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.f7761j = aVar;
        this.f7762k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7761j;
        DecoderCounters decoderCounters = this.f7762k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3302m(decoderCounters);
    }
}
