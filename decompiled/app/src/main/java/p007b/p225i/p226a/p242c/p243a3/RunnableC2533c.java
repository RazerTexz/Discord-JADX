package p007b.p225i.p226a.p242c.p243a3;

import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.c */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2533c implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ MediaSourceEventListener.a f5487j;

    /* renamed from: k */
    public final /* synthetic */ MediaSourceEventListener f5488k;

    /* renamed from: l */
    public final /* synthetic */ LoadEventInfo f5489l;

    /* renamed from: m */
    public final /* synthetic */ MediaLoadData f5490m;

    public /* synthetic */ RunnableC2533c(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f5487j = aVar;
        this.f5488k = mediaSourceEventListener;
        this.f5489l = loadEventInfo;
        this.f5490m = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.f5487j;
        this.f5488k.mo2461X(aVar.f5481a, aVar.f5482b, this.f5489l, this.f5490m);
    }
}
