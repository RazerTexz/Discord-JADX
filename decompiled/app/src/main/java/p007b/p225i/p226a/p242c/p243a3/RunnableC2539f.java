package p007b.p225i.p226a.p242c.p243a3;

import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.f */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2539f implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ MediaSourceEventListener.a f5561j;

    /* renamed from: k */
    public final /* synthetic */ MediaSourceEventListener f5562k;

    /* renamed from: l */
    public final /* synthetic */ LoadEventInfo f5563l;

    /* renamed from: m */
    public final /* synthetic */ MediaLoadData f5564m;

    public /* synthetic */ RunnableC2539f(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f5561j = aVar;
        this.f5562k = mediaSourceEventListener;
        this.f5563l = loadEventInfo;
        this.f5564m = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.f5561j;
        this.f5562k.mo2464q(aVar.f5481a, aVar.f5482b, this.f5563l, this.f5564m);
    }
}
