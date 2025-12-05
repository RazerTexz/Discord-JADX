package p007b.p225i.p226a.p242c.p263t2;

import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2913b implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7684j;

    /* renamed from: k */
    public final /* synthetic */ DecoderCounters f7685k;

    public /* synthetic */ RunnableC2913b(AudioRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.f7684j = aVar;
        this.f7685k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7684j;
        DecoderCounters decoderCounters = this.f7685k;
        Objects.requireNonNull(aVar);
        synchronized (decoderCounters) {
        }
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3301k(decoderCounters);
    }
}
