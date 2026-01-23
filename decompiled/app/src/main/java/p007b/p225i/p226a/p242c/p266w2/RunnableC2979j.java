package p007b.p225i.p226a.p242c.p266w2;

import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.w2.j */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2979j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DrmSessionEventListener.a f7995j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DrmSessionEventListener f7996k;

    public /* synthetic */ RunnableC2979j(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener) {
        this.f7995j = aVar;
        this.f7996k = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.f7995j;
        this.f7996k.mo2573i0(aVar.f8012a, aVar.f8013b);
    }
}
