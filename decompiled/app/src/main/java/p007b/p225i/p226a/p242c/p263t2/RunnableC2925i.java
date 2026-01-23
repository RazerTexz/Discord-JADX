package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.t2.i */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2925i implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7757j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f7758k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f7759l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f7760m;

    public /* synthetic */ RunnableC2925i(AudioRendererEventListener2.a aVar, int i, long j, long j2) {
        this.f7757j = aVar;
        this.f7758k = i;
        this.f7759l = j;
        this.f7760m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7757j;
        int i = this.f7758k;
        long j = this.f7759l;
        long j2 = this.f7760m;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i2 = Util2.f6708a;
        audioRendererEventListener2.mo3300e0(i, j, j2);
    }
}
