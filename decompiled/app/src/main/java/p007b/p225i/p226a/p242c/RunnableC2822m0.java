package p007b.p225i.p226a.p242c;

import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* JADX INFO: renamed from: b.i.a.c.m0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2822m0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ MediaPeriodQueue f7243j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ImmutableList2.a f7244k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ MediaSource2.a f7245l;

    public /* synthetic */ RunnableC2822m0(MediaPeriodQueue mediaPeriodQueue, ImmutableList2.a aVar, MediaSource2.a aVar2) {
        this.f7243j = mediaPeriodQueue;
        this.f7244k = aVar;
        this.f7245l = aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        MediaPeriodQueue mediaPeriodQueue = this.f7243j;
        ImmutableList2.a aVar = this.f7244k;
        MediaSource2.a aVar2 = this.f7245l;
        AnalyticsCollector analyticsCollector = mediaPeriodQueue.f7488c;
        ImmutableList2 immutableList2M6272c = aVar.m6272c();
        AnalyticsCollector.a aVar3 = analyticsCollector.f7550m;
        Player2 player2 = analyticsCollector.f7553p;
        Objects.requireNonNull(player2);
        Objects.requireNonNull(aVar3);
        aVar3.f7557b = ImmutableList2.m6264n(immutableList2M6272c);
        if (!immutableList2M6272c.isEmpty()) {
            aVar3.f7560e = (MediaSource2.a) immutableList2M6272c.get(0);
            Objects.requireNonNull(aVar2);
            aVar3.f7561f = aVar2;
        }
        if (aVar3.f7559d == null) {
            aVar3.f7559d = AnalyticsCollector.a.m3388b(player2, aVar3.f7557b, aVar3.f7560e, aVar3.f7556a);
        }
        aVar3.m3391d(player2.mo2888K());
    }
}
