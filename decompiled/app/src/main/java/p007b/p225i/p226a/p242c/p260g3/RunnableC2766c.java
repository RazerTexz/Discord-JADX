package p007b.p225i.p226a.p242c.p260g3;

import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;

/* JADX INFO: renamed from: b.i.a.c.g3.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2766c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6811j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DecoderCounters f6812k;

    public /* synthetic */ RunnableC2766c(VideoRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.f6811j = aVar;
        this.f6812k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6811j;
        DecoderCounters decoderCounters = this.f6812k;
        Objects.requireNonNull(aVar);
        synchronized (decoderCounters) {
        }
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3191Z(decoderCounters);
    }
}
