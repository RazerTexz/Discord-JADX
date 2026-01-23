package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.t2.g */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2923g implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7753j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f7754k;

    public /* synthetic */ RunnableC2923g(AudioRendererEventListener2.a aVar, String str) {
        this.f7753j = aVar;
        this.f7754k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7753j;
        String str = this.f7754k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3291B(str);
    }
}
