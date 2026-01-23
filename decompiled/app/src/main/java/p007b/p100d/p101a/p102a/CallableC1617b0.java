package p007b.p100d.p101a.p102a;

import android.os.Bundle;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.d.a.a.b0 */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1617b0 implements Callable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1614a f2950j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f2951k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ SkuDetails f2952l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ String f2953m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ BillingFlowParams f2954n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ Bundle f2955o;

    public /* synthetic */ CallableC1617b0(C1614a c1614a, int i, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.f2950j = c1614a;
        this.f2951k = i;
        this.f2952l = skuDetails;
        this.f2953m = str;
        this.f2954n = billingFlowParams;
        this.f2955o = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        C1614a c1614a = this.f2950j;
        int i = this.f2951k;
        SkuDetails skuDetails = this.f2952l;
        return c1614a.f2936f.mo5421c0(i, c1614a.f2935e.getPackageName(), skuDetails.m7503d(), this.f2953m, null, this.f2955o);
    }
}
