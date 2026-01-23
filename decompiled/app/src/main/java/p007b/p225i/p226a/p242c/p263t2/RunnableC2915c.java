package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.t2.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2915c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7686j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Exception f7687k;

    public /* synthetic */ RunnableC2915c(AudioRendererEventListener2.a aVar, Exception exc) {
        this.f7686j = aVar;
        this.f7687k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7686j;
        Exception exc = this.f7687k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3296T(exc);
    }
}
