package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2911a implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7668j;

    /* renamed from: k */
    public final /* synthetic */ boolean f7669k;

    public /* synthetic */ RunnableC2911a(AudioRendererEventListener2.a aVar, boolean z2) {
        this.f7668j = aVar;
        this.f7669k = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7668j;
        boolean z2 = this.f7669k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3299d(z2);
    }
}
