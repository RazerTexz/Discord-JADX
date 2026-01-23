package p007b.p225i.p226a.p242c.p243a3;

import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;

/* JADX INFO: renamed from: b.i.a.c.a3.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2535d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ MediaSourceEventListener.a f5491j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ MediaSourceEventListener f5492k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ MediaLoadData f5493l;

    public /* synthetic */ RunnableC2535d(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f5491j = aVar;
        this.f5492k = mediaSourceEventListener;
        this.f5493l = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.f5491j;
        this.f5492k.mo2463o(aVar.f5481a, aVar.f5482b, this.f5493l);
    }
}
