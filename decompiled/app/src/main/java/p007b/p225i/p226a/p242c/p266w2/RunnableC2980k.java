package p007b.p225i.p226a.p242c.p266w2;

import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.w2.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2980k implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ DrmSessionEventListener.a f7997j;

    /* renamed from: k */
    public final /* synthetic */ DrmSessionEventListener f7998k;

    /* renamed from: l */
    public final /* synthetic */ Exception f7999l;

    public /* synthetic */ RunnableC2980k(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f7997j = aVar;
        this.f7998k = drmSessionEventListener;
        this.f7999l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.f7997j;
        this.f7998k.mo2574u(aVar.f8012a, aVar.f8013b, this.f7999l);
    }
}
