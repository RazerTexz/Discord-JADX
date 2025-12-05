package p007b.p225i.p226a.p242c.p243a3;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2531b implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ MediaSourceEventListener.a f5475j;

    /* renamed from: k */
    public final /* synthetic */ MediaSourceEventListener f5476k;

    /* renamed from: l */
    public final /* synthetic */ LoadEventInfo f5477l;

    /* renamed from: m */
    public final /* synthetic */ MediaLoadData f5478m;

    /* renamed from: n */
    public final /* synthetic */ IOException f5479n;

    /* renamed from: o */
    public final /* synthetic */ boolean f5480o;

    public /* synthetic */ RunnableC2531b(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f5475j = aVar;
        this.f5476k = mediaSourceEventListener;
        this.f5477l = loadEventInfo;
        this.f5478m = mediaLoadData;
        this.f5479n = iOException;
        this.f5480o = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.f5475j;
        this.f5476k.mo2462g0(aVar.f5481a, aVar.f5482b, this.f5477l, this.f5478m, this.f5479n, this.f5480o);
    }
}
