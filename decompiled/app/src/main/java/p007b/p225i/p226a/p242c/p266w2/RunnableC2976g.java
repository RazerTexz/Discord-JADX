package p007b.p225i.p226a.p242c.p266w2;

import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.w2.g */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2976g implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DrmSessionEventListener.a f7989j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DrmSessionEventListener f7990k;

    public /* synthetic */ RunnableC2976g(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener) {
        this.f7989j = aVar;
        this.f7990k = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.f7989j;
        this.f7990k.mo2572d0(aVar.f8012a, aVar.f8013b);
    }
}
