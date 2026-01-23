package p007b.p100d.p101a.p102a;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d;

/* JADX INFO: renamed from: b.d.a.a.t */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1635t implements Callable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1614a f2991j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C1619d f2992k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ InterfaceC1620e f2993l;

    public /* synthetic */ CallableC1635t(C1614a c1614a, C1619d c1619d, InterfaceC1620e interfaceC1620e) {
        this.f2991j = c1614a;
        this.f2992k = c1619d;
        this.f2993l = interfaceC1620e;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int iMo5425q;
        String strM5414d;
        C1614a c1614a = this.f2991j;
        C1619d c1619d = this.f2992k;
        InterfaceC1620e interfaceC1620e = this.f2993l;
        Objects.requireNonNull(c1614a);
        String str = c1619d.f2958a;
        try {
            String strValueOf = String.valueOf(str);
            C3941a.m5415e("BillingClient", strValueOf.length() != 0 ? "Consuming purchase with token: ".concat(strValueOf) : new String("Consuming purchase with token: "));
            if (c1614a.f2941k) {
                InterfaceC3944d interfaceC3944d = c1614a.f2936f;
                String packageName = c1614a.f2935e.getPackageName();
                boolean z2 = c1614a.f2941k;
                String str2 = c1614a.f2932b;
                Bundle bundle = new Bundle();
                if (z2) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle bundleMo5426r = interfaceC3944d.mo5426r(9, packageName, str, bundle);
                iMo5425q = bundleMo5426r.getInt("RESPONSE_CODE");
                strM5414d = C3941a.m5414d(bundleMo5426r, "BillingClient");
            } else {
                iMo5425q = c1614a.f2936f.mo5425q(3, c1614a.f2935e.getPackageName(), str);
                strM5414d = "";
            }
            BillingResult billingResult = new BillingResult();
            billingResult.f14557a = iMo5425q;
            billingResult.f14558b = strM5414d;
            if (iMo5425q == 0) {
                C3941a.m5415e("BillingClient", "Successfully consumed purchase.");
                interfaceC1620e.onConsumeResponse(billingResult, str);
                return null;
            }
            StringBuilder sb = new StringBuilder(63);
            sb.append("Error consuming purchase with token. Response code: ");
            sb.append(iMo5425q);
            C3941a.m5416f("BillingClient", sb.toString());
            interfaceC1620e.onConsumeResponse(billingResult, str);
            return null;
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 30);
            sb2.append("Error consuming purchase; ex: ");
            sb2.append(strValueOf2);
            C3941a.m5416f("BillingClient", sb2.toString());
            interfaceC1620e.onConsumeResponse(C1631p.f2981j, str);
            return null;
        }
    }
}
