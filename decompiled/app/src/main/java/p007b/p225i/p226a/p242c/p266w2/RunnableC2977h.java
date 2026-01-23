package p007b.p225i.p226a.p242c.p266w2;

import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.w2.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2977h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DrmSessionEventListener.a f7991j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DrmSessionEventListener f7992k;

    public /* synthetic */ RunnableC2977h(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener) {
        this.f7991j = aVar;
        this.f7992k = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.f7991j;
        this.f7992k.mo2567J(aVar.f8012a, aVar.f8013b);
    }
}
