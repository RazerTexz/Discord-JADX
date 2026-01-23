package p007b.p225i.p226a.p242c.p243a3;

import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;

/* JADX INFO: renamed from: b.i.a.c.a3.e */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2537e implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ MediaSourceEventListener.a f5494j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ MediaSourceEventListener f5495k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ LoadEventInfo f5496l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ MediaLoadData f5497m;

    public /* synthetic */ RunnableC2537e(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f5494j = aVar;
        this.f5495k = mediaSourceEventListener;
        this.f5496l = loadEventInfo;
        this.f5497m = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.f5494j;
        this.f5495k.mo2465x(aVar.f5481a, aVar.f5482b, this.f5496l, this.f5497m);
    }
}
