package p007b.p100d.p101a.p102a;

import com.android.billingclient.api.BillingResult;

/* JADX INFO: renamed from: b.d.a.a.w */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1638w implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1614a f3001j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BillingResult f3002k;

    public /* synthetic */ RunnableC1638w(C1614a c1614a, BillingResult billingResult) {
        this.f3001j = c1614a;
        this.f3002k = billingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1614a c1614a = this.f3001j;
        c1614a.f2934d.f2990b.f2986a.onPurchasesUpdated(this.f3002k, null);
    }
}
