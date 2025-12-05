package p007b.p225i.p226a.p288f.p313h.p323j;

/* renamed from: b.i.a.f.h.j.u0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3545u0 implements Runnable {

    /* renamed from: j */
    public final C3543t0 f9804j;

    /* renamed from: k */
    public final int f9805k;

    /* renamed from: l */
    public final C3529m0 f9806l;

    public RunnableC3545u0(C3543t0 c3543t0, int i, C3529m0 c3529m0) {
        this.f9804j = c3543t0;
        this.f9805k = i;
        this.f9806l = c3529m0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3543t0 c3543t0 = this.f9804j;
        int i = this.f9805k;
        C3529m0 c3529m0 = this.f9806l;
        if (c3543t0.f9802c.mo4504b(i)) {
            c3529m0.m4427C("Local AnalyticsService processed last dispatch request");
        }
    }
}
