package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.t2.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2924h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7755j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f7756k;

    public /* synthetic */ RunnableC2924h(AudioRendererEventListener2.a aVar, long j) {
        this.f7755j = aVar;
        this.f7756k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7755j;
        long j = this.f7756k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3295R(j);
    }
}
