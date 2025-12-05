package p007b.p100d.p101a.p102a;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.v */
/* loaded from: classes.dex */
public final /* synthetic */ class CallableC1637v implements Callable {

    /* renamed from: j */
    public final /* synthetic */ C1614a f2997j;

    /* renamed from: k */
    public final /* synthetic */ String f2998k;

    /* renamed from: l */
    public final /* synthetic */ List f2999l;

    /* renamed from: m */
    public final /* synthetic */ InterfaceC1624i f3000m;

    public /* synthetic */ CallableC1637v(C1614a c1614a, String str, List list, InterfaceC1624i interfaceC1624i) {
        this.f2997j = c1614a;
        this.f2998k = str;
        this.f2999l = list;
        this.f3000m = interfaceC1624i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String strM5414d;
        int iM5411a;
        int i;
        Bundle bundleMo5422e0;
        C1614a c1614a = this.f2997j;
        String str = this.f2998k;
        List list = this.f2999l;
        InterfaceC1624i interfaceC1624i = this.f3000m;
        Objects.requireNonNull(c1614a);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                strM5414d = "";
                iM5411a = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList arrayList2 = new ArrayList(list.subList(i2, i3 > size ? size : i3));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList3.add(((C1632q) arrayList2.get(i4)).f2985a);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", c1614a.f2932b);
            try {
                if (c1614a.f2942l) {
                    i = i3;
                    bundleMo5422e0 = c1614a.f2936f.mo5423o(10, c1614a.f2935e.getPackageName(), str, bundle, C3941a.m5412b(c1614a.f2939i, c1614a.f2946p, c1614a.f2932b, null, arrayList2));
                } else {
                    i = i3;
                    bundleMo5422e0 = c1614a.f2936f.mo5422e0(3, c1614a.f2935e.getPackageName(), str, bundle);
                }
                if (bundleMo5422e0 == null) {
                    C3941a.m5416f("BillingClient", "querySkuDetailsAsync got null sku details list");
                    break;
                }
                if (bundleMo5422e0.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = bundleMo5422e0.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        C3941a.m5416f("BillingClient", "querySkuDetailsAsync got null response list");
                        break;
                    }
                    for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                            String strValueOf = String.valueOf(skuDetails);
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
                            sb.append("Got sku details: ");
                            sb.append(strValueOf);
                            C3941a.m5415e("BillingClient", sb.toString());
                            arrayList.add(skuDetails);
                        } catch (JSONException unused) {
                            C3941a.m5416f("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                            strM5414d = "Error trying to decode SkuDetails.";
                            arrayList = null;
                            iM5411a = 6;
                            BillingResult billingResult = new BillingResult();
                            billingResult.f14557a = iM5411a;
                            billingResult.f14558b = strM5414d;
                            interfaceC1624i.onSkuDetailsResponse(billingResult, arrayList);
                            return null;
                        }
                    }
                    i2 = i;
                } else {
                    iM5411a = C3941a.m5411a(bundleMo5422e0, "BillingClient");
                    strM5414d = C3941a.m5414d(bundleMo5422e0, "BillingClient");
                    if (iM5411a != 0) {
                        StringBuilder sb2 = new StringBuilder(50);
                        sb2.append("getSkuDetails() failed. Response code: ");
                        sb2.append(iM5411a);
                        C3941a.m5416f("BillingClient", sb2.toString());
                    } else {
                        C3941a.m5416f("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    }
                }
            } catch (Exception e) {
                String strValueOf2 = String.valueOf(e);
                StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 63);
                sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                sb3.append(strValueOf2);
                C3941a.m5416f("BillingClient", sb3.toString());
                iM5411a = -1;
                strM5414d = "Service connection is disconnected.";
            }
        }
        iM5411a = 4;
        strM5414d = "Item is unavailable for purchase.";
        arrayList = null;
        BillingResult billingResult2 = new BillingResult();
        billingResult2.f14557a = iM5411a;
        billingResult2.f14558b = strM5414d;
        interfaceC1624i.onSkuDetailsResponse(billingResult2, arrayList);
        return null;
    }
}
