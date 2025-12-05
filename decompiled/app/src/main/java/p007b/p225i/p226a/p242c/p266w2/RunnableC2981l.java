package p007b.p225i.p226a.p242c.p266w2;

import java.util.Objects;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* compiled from: lambda */
/* renamed from: b.i.a.c.w2.l */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2981l implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ DrmSessionEventListener.a f8000j;

    /* renamed from: k */
    public final /* synthetic */ DrmSessionEventListener f8001k;

    /* renamed from: l */
    public final /* synthetic */ int f8002l;

    public /* synthetic */ RunnableC2981l(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener, int i) {
        this.f8000j = aVar;
        this.f8001k = drmSessionEventListener;
        this.f8002l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.f8000j;
        DrmSessionEventListener drmSessionEventListener = this.f8001k;
        int i = this.f8002l;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(drmSessionEventListener);
        drmSessionEventListener.mo2571c0(aVar.f8012a, aVar.f8013b, i);
    }
}
