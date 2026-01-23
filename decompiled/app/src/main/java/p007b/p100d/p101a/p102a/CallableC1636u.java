package p007b.p100d.p101a.p102a;

import com.android.billingclient.api.SkuDetails;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.d.a.a.u */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1636u implements Callable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1614a f2994j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ SkuDetails f2995k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f2996l;

    public /* synthetic */ CallableC1636u(C1614a c1614a, SkuDetails skuDetails, String str) {
        this.f2994j = c1614a;
        this.f2995k = skuDetails;
        this.f2996l = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        C1614a c1614a = this.f2994j;
        SkuDetails skuDetails = this.f2995k;
        return c1614a.f2936f.mo5419F(3, c1614a.f2935e.getPackageName(), skuDetails.m7503d(), this.f2996l, null);
    }
}
