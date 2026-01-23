package p007b.p225i.p226a.p242c.p243a3;

import p007b.p225i.p226a.p242c.p267x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.a3.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2543h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ProgressiveMediaPeriod f5590j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ SeekMap f5591k;

    public /* synthetic */ RunnableC2543h(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.f5590j = progressiveMediaPeriod;
        this.f5591k = seekMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.f5590j;
        SeekMap seekMap = this.f5591k;
        progressiveMediaPeriod.f5509J = progressiveMediaPeriod.f5502C == null ? seekMap : new SeekMap.b(-9223372036854775807L, 0L);
        progressiveMediaPeriod.f5510K = seekMap.mo3621i();
        boolean z2 = progressiveMediaPeriod.f5516Q == -1 && seekMap.mo3621i() == -9223372036854775807L;
        progressiveMediaPeriod.f5511L = z2;
        progressiveMediaPeriod.f5512M = z2 ? 7 : 1;
        ((ProgressiveMediaSource) progressiveMediaPeriod.f5529r).m2512u(progressiveMediaPeriod.f5510K, seekMap.mo3619c(), progressiveMediaPeriod.f5511L);
        if (progressiveMediaPeriod.f5506G) {
            return;
        }
        progressiveMediaPeriod.m2500x();
    }
}
