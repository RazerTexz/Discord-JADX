package p007b.p100d.p101a.p102a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.x */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1639x implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ InterfaceC1620e f3003j;

    /* renamed from: k */
    public final /* synthetic */ C1619d f3004k;

    public /* synthetic */ RunnableC1639x(InterfaceC1620e interfaceC1620e, C1619d c1619d) {
        this.f3003j = interfaceC1620e;
        this.f3004k = c1619d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3003j.onConsumeResponse(C1631p.f2982k, this.f3004k.f2958a);
    }
}
