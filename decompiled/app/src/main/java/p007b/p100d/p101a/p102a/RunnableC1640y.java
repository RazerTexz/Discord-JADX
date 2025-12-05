package p007b.p100d.p101a.p102a;

import com.android.billingclient.api.BillingResult;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3953m;
import p007b.p225i.p226a.p288f.p313h.p327n.C3952l;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.y */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1640y implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ InterfaceC1621f f3005j;

    public /* synthetic */ RunnableC1640y(InterfaceC1621f interfaceC1621f) {
        this.f3005j = interfaceC1621f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC1621f interfaceC1621f = this.f3005j;
        BillingResult billingResult = C1631p.f2982k;
        AbstractC3953m<Object> abstractC3953m = AbstractC3951k.f10489k;
        interfaceC1621f.onQueryPurchasesResponse(billingResult, C3952l.f10490l);
    }
}
