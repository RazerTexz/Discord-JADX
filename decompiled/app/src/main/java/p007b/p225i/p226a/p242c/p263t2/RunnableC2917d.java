package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.d */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2917d implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7700j;

    /* renamed from: k */
    public final /* synthetic */ Exception f7701k;

    public /* synthetic */ RunnableC2917d(AudioRendererEventListener2.a aVar, Exception exc) {
        this.f7700j = aVar;
        this.f7701k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7700j;
        Exception exc = this.f7701k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3294N(exc);
    }
}
