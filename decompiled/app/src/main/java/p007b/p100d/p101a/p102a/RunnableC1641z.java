package p007b.p100d.p101a.p102a;

/* JADX INFO: renamed from: b.d.a.a.z */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1641z implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC1624i f3006j;

    public /* synthetic */ RunnableC1641z(InterfaceC1624i interfaceC1624i) {
        this.f3006j = interfaceC1624i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3006j.onSkuDetailsResponse(C1631p.f2982k, null);
    }
}
