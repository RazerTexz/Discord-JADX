package p007b.p225i.p226a.p242c.p243a3;

import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.i */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2545i implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ProgressiveMediaPeriod f5627j;

    public /* synthetic */ RunnableC2545i(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.f5627j = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.f5627j;
        if (progressiveMediaPeriod.f5522W) {
            return;
        }
        MediaPeriod.a aVar = progressiveMediaPeriod.f5501B;
        Objects.requireNonNull(aVar);
        aVar.mo2542a(progressiveMediaPeriod);
    }
}
