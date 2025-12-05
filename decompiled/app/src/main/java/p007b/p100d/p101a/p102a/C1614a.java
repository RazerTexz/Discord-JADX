package p007b.p100d.p101a.p102a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProxyBillingActivity;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3953m;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3952l;
import p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.a */
/* loaded from: classes.dex */
public class C1614a extends BillingClient {

    /* renamed from: a */
    public volatile int f2931a;

    /* renamed from: b */
    public final String f2932b;

    /* renamed from: c */
    public final Handler f2933c;

    /* renamed from: d */
    public volatile C1634s f2934d;

    /* renamed from: e */
    public Context f2935e;

    /* renamed from: f */
    public volatile InterfaceC3944d f2936f;

    /* renamed from: g */
    public volatile ServiceConnectionC1629n f2937g;

    /* renamed from: h */
    public boolean f2938h;

    /* renamed from: i */
    public int f2939i;

    /* renamed from: j */
    public boolean f2940j;

    /* renamed from: k */
    public boolean f2941k;

    /* renamed from: l */
    public boolean f2942l;

    /* renamed from: m */
    public boolean f2943m;

    /* renamed from: n */
    public boolean f2944n;

    /* renamed from: o */
    public boolean f2945o;

    /* renamed from: p */
    public boolean f2946p;

    /* renamed from: q */
    public ExecutorService f2947q;

    @AnyThread
    public C1614a(@Nullable String str, boolean z2, Context context, InterfaceC1622g interfaceC1622g) {
        String str2;
        try {
            str2 = (String) Class.forName("b.d.a.b.a").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            str2 = "4.0.0";
        }
        this.f2931a = 0;
        this.f2933c = new Handler(Looper.getMainLooper());
        this.f2939i = 0;
        this.f2932b = str2;
        Context applicationContext = context.getApplicationContext();
        this.f2935e = applicationContext;
        this.f2934d = new C1634s(applicationContext, interfaceC1622g);
        this.f2946p = z2;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: a */
    public final void mo799a(C1619d c1619d, InterfaceC1620e interfaceC1620e) {
        if (!mo802d()) {
            interfaceC1620e.onConsumeResponse(C1631p.f2981j, c1619d.f2958a);
        } else if (m810l(new CallableC1635t(this, c1619d, interfaceC1620e), 30000L, new RunnableC1639x(interfaceC1620e, c1619d), m807i()) == null) {
            interfaceC1620e.onConsumeResponse(m809k(), c1619d.f2958a);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: b */
    public final void mo800b() {
        try {
            this.f2934d.m812a();
            if (this.f2937g != null) {
                ServiceConnectionC1629n serviceConnectionC1629n = this.f2937g;
                synchronized (serviceConnectionC1629n.f2968j) {
                    serviceConnectionC1629n.f2970l = null;
                    serviceConnectionC1629n.f2969k = true;
                }
            }
            if (this.f2937g != null && this.f2936f != null) {
                C3941a.m5415e("BillingClient", "Unbinding from service.");
                this.f2935e.unbindService(this.f2937g);
                this.f2937g = null;
            }
            this.f2936f = null;
            ExecutorService executorService = this.f2947q;
            if (executorService != null) {
                executorService.shutdownNow();
                this.f2947q = null;
            }
        } catch (Exception e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
            sb.append("There was an exception while ending connection: ");
            sb.append(strValueOf);
            C3941a.m5416f("BillingClient", sb.toString());
        } finally {
            this.f2931a = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: c */
    public final int mo801c() {
        return this.f2931a;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: d */
    public final boolean mo802d() {
        return (this.f2931a != 2 || this.f2936f == null || this.f2937g == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: e */
    public final BillingResult mo803e(Activity activity, BillingFlowParams billingFlowParams) {
        String str;
        String str2;
        String str3;
        String str4;
        Future futureM810l;
        String str5;
        String str6;
        String str7;
        Bundle bundle;
        String str8;
        boolean z2;
        String strOptString;
        if (!mo802d()) {
            BillingResult billingResult = C1631p.f2981j;
            m808j(billingResult);
            return billingResult;
        }
        Objects.requireNonNull(billingFlowParams);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(billingFlowParams.f14551f);
        SkuDetails skuDetails = (SkuDetails) arrayList.get(0);
        String strM7504e = skuDetails.m7504e();
        String str9 = "BillingClient";
        if (strM7504e.equals("subs") && !this.f2938h) {
            C3941a.m5416f("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult2 = C1631p.f2983l;
            m808j(billingResult2);
            return billingResult2;
        }
        if (((!billingFlowParams.f14552g && billingFlowParams.f14547b == null && billingFlowParams.f14549d == null && billingFlowParams.f14550e == 0 && !billingFlowParams.f14546a) ? false : true) && !this.f2940j) {
            C3941a.m5416f("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult3 = C1631p.f2977f;
            m808j(billingResult3);
            return billingResult3;
        }
        if (arrayList.size() > 1 && !this.f2945o) {
            C3941a.m5416f("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult4 = C1631p.f2984m;
            m808j(billingResult4);
            return billingResult4;
        }
        String str10 = "";
        int i = 0;
        String str11 = "";
        while (i < arrayList.size()) {
            String strValueOf = String.valueOf(str11);
            String strValueOf2 = String.valueOf(arrayList.get(i));
            String str12 = str10;
            String strM822J = outline.m822J(new StringBuilder(strValueOf.length() + strValueOf2.length()), strValueOf, strValueOf2);
            if (i < arrayList.size() - 1) {
                strM822J = String.valueOf(strM822J).concat(", ");
            }
            str11 = strM822J;
            i++;
            str10 = str12;
        }
        String str13 = str10;
        StringBuilder sb = new StringBuilder(String.valueOf(str11).length() + 41 + strM7504e.length());
        sb.append("Constructing buy intent for ");
        sb.append(str11);
        sb.append(", item type: ");
        sb.append(strM7504e);
        C3941a.m5415e("BillingClient", sb.toString());
        if (this.f2940j) {
            boolean z3 = this.f2941k;
            boolean z4 = this.f2946p;
            String str14 = this.f2932b;
            Bundle bundle2 = new Bundle();
            bundle2.putString("playBillingLibraryVersion", str14);
            int i2 = billingFlowParams.f14550e;
            if (i2 != 0) {
                bundle2.putInt("prorationMode", i2);
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14547b)) {
                bundle2.putString("accountId", billingFlowParams.f14547b);
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14549d)) {
                bundle2.putString("obfuscatedProfileId", billingFlowParams.f14549d);
            }
            if (billingFlowParams.f14552g) {
                bundle2.putBoolean("vr", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14548c)) {
                bundle2.putString("oldSkuPurchaseToken", billingFlowParams.f14548c);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle2.putString("paymentsPurchaseParams", null);
            }
            if (z3 && z4) {
                bundle2.putBoolean("enablePendingPurchases", true);
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            ArrayList<String> arrayList4 = new ArrayList<>();
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            str2 = "; try to reconnect";
            ArrayList<String> arrayList6 = new ArrayList<>();
            str4 = str11;
            int size = arrayList.size();
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            str = "BUY_INTENT";
            int i3 = 0;
            while (i3 < size) {
                int i4 = size;
                SkuDetails skuDetails2 = (SkuDetails) arrayList.get(i3);
                String str15 = str9;
                if (!skuDetails2.f14567b.optString("skuDetailsToken").isEmpty()) {
                    arrayList2.add(skuDetails2.f14567b.optString("skuDetailsToken"));
                }
                try {
                    strOptString = new JSONObject(skuDetails2.f14566a).optString("offer_id_token");
                } catch (JSONException unused) {
                    strOptString = str13;
                }
                String str16 = strM7504e;
                String strOptString2 = skuDetails2.f14567b.optString("offer_id");
                int iOptInt = skuDetails2.f14567b.optInt("offer_type");
                String strOptString3 = skuDetails2.f14567b.optString("serializedDocid");
                arrayList3.add(strOptString);
                z5 |= !TextUtils.isEmpty(strOptString);
                arrayList4.add(strOptString2);
                z6 |= !TextUtils.isEmpty(strOptString2);
                arrayList5.add(Integer.valueOf(iOptInt));
                z7 |= iOptInt != 0;
                z8 |= !TextUtils.isEmpty(strOptString3);
                arrayList6.add(strOptString3);
                i3++;
                str9 = str15;
                size = i4;
                strM7504e = str16;
            }
            String str17 = strM7504e;
            str3 = str9;
            if (!arrayList2.isEmpty()) {
                bundle2.putStringArrayList("skuDetailsTokens", arrayList2);
            }
            if (z5) {
                if (!this.f2943m) {
                    BillingResult billingResult5 = C1631p.f2978g;
                    m808j(billingResult5);
                    return billingResult5;
                }
                bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
            }
            if (z6) {
                bundle2.putStringArrayList("SKU_OFFER_ID_LIST", arrayList4);
            }
            if (z7) {
                bundle2.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList5);
            }
            if (z8) {
                bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
            }
            if (TextUtils.isEmpty(skuDetails.m7505f())) {
                str8 = null;
                z2 = false;
            } else {
                bundle2.putString("skuPackageName", skuDetails.m7505f());
                str8 = null;
                z2 = true;
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle2.putString("accountName", str8);
            }
            if (arrayList.size() > 1) {
                ArrayList<String> arrayList7 = new ArrayList<>(arrayList.size() - 1);
                ArrayList<String> arrayList8 = new ArrayList<>(arrayList.size() - 1);
                for (int i5 = 1; i5 < arrayList.size(); i5++) {
                    arrayList7.add(((SkuDetails) arrayList.get(i5)).m7503d());
                    arrayList8.add(((SkuDetails) arrayList.get(i5)).m7504e());
                }
                bundle2.putStringArrayList("additionalSkus", arrayList7);
                bundle2.putStringArrayList("additionalSkuTypes", arrayList8);
            }
            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = activity.getIntent().getStringExtra("PROXY_PACKAGE");
                bundle2.putString("proxyPackage", stringExtra);
                try {
                    bundle2.putString("proxyPackageVersion", this.f2935e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused2) {
                    bundle2.putString("proxyPackageVersion", "package not found");
                }
            }
            futureM810l = m810l(new CallableC1617b0(this, (this.f2944n && z2) ? 15 : this.f2941k ? 9 : billingFlowParams.f14552g ? 7 : 6, skuDetails, str17, billingFlowParams, bundle2), 5000L, null, this.f2933c);
        } else {
            str = "BUY_INTENT";
            str2 = "; try to reconnect";
            str3 = "BillingClient";
            str4 = str11;
            futureM810l = m810l(new CallableC1636u(this, skuDetails, strM7504e), 5000L, null, this.f2933c);
        }
        try {
            try {
                try {
                    bundle = (Bundle) futureM810l.get(5000L, TimeUnit.MILLISECONDS);
                    str7 = str3;
                } catch (CancellationException | TimeoutException unused3) {
                    str7 = str3;
                }
            } catch (Exception unused4) {
                str7 = str3;
            }
        } catch (CancellationException | TimeoutException unused5) {
            str5 = str2;
            str6 = str4;
            str7 = str3;
        }
        try {
            int iM5411a = C3941a.m5411a(bundle, str7);
            String strM5414d = C3941a.m5414d(bundle, str7);
            if (iM5411a == 0) {
                Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str18 = str;
                intent.putExtra(str18, (PendingIntent) bundle.getParcelable(str18));
                activity.startActivity(intent);
                return C1631p.f2980i;
            }
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Unable to buy item, Error response code: ");
            sb2.append(iM5411a);
            C3941a.m5416f(str7, sb2.toString());
            BillingResult billingResult6 = new BillingResult();
            billingResult6.f14557a = iM5411a;
            billingResult6.f14558b = strM5414d;
            m808j(billingResult6);
            return billingResult6;
        } catch (CancellationException | TimeoutException unused6) {
            str5 = str2;
            str6 = str4;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str6).length() + 68);
            sb3.append("Time out while launching billing flow: ; for sku: ");
            sb3.append(str6);
            sb3.append(str5);
            C3941a.m5416f(str7, sb3.toString());
            BillingResult billingResult7 = C1631p.f2982k;
            m808j(billingResult7);
            return billingResult7;
        } catch (Exception unused7) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str4).length() + 69);
            sb4.append("Exception while launching billing flow: ; for sku: ");
            sb4.append(str4);
            sb4.append(str2);
            C3941a.m5416f(str7, sb4.toString());
            BillingResult billingResult8 = C1631p.f2981j;
            m808j(billingResult8);
            return billingResult8;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: f */
    public void mo804f(String str, InterfaceC1621f interfaceC1621f) {
        if (!mo802d()) {
            BillingResult billingResult = C1631p.f2981j;
            AbstractC3953m<Object> abstractC3953m = AbstractC3951k.f10489k;
            interfaceC1621f.onQueryPurchasesResponse(billingResult, C3952l.f10490l);
        } else {
            if (TextUtils.isEmpty(str)) {
                C3941a.m5416f("BillingClient", "Please provide a valid SKU type.");
                BillingResult billingResult2 = C1631p.f2976e;
                AbstractC3953m<Object> abstractC3953m2 = AbstractC3951k.f10489k;
                interfaceC1621f.onQueryPurchasesResponse(billingResult2, C3952l.f10490l);
                return;
            }
            if (m810l(new CallableC1625j(this, str, interfaceC1621f), 30000L, new RunnableC1640y(interfaceC1621f), m807i()) == null) {
                BillingResult billingResultM809k = m809k();
                AbstractC3953m<Object> abstractC3953m3 = AbstractC3951k.f10489k;
                interfaceC1621f.onQueryPurchasesResponse(billingResultM809k, C3952l.f10490l);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: g */
    public final void mo805g(C1623h c1623h, InterfaceC1624i interfaceC1624i) {
        if (!mo802d()) {
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2981j, null);
            return;
        }
        String str = c1623h.f2959a;
        List<String> list = c1623h.f2960b;
        if (TextUtils.isEmpty(str)) {
            C3941a.m5416f("BillingClient", "Please fix the input params. SKU type can't be empty.");
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2976e, null);
            return;
        }
        if (list == null) {
            C3941a.m5416f("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2975d, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("SKU must be set.");
            }
            arrayList.add(new C1632q(str2));
        }
        if (m810l(new CallableC1637v(this, str, arrayList, interfaceC1624i), 30000L, new RunnableC1641z(interfaceC1624i), m807i()) == null) {
            interfaceC1624i.onSkuDetailsResponse(m809k(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* renamed from: h */
    public final void mo806h(InterfaceC1616b interfaceC1616b) {
        ServiceInfo serviceInfo;
        if (mo802d()) {
            C3941a.m5415e("BillingClient", "Service connection is valid. No need to re-initialize.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2980i);
            return;
        }
        if (this.f2931a == 1) {
            C3941a.m5416f("BillingClient", "Client is already in the process of connecting to billing service.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2974c);
            return;
        }
        if (this.f2931a == 3) {
            C3941a.m5416f("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2981j);
            return;
        }
        this.f2931a = 1;
        C1634s c1634s = this.f2934d;
        C1633r c1633r = c1634s.f2990b;
        Context context = c1634s.f2989a;
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        if (!c1633r.f2987b) {
            context.registerReceiver(c1633r.f2988c.f2990b, intentFilter);
            c1633r.f2987b = true;
        }
        C3941a.m5415e("BillingClient", "Starting in-app billing setup.");
        this.f2937g = new ServiceConnectionC1629n(this, interfaceC1616b);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.f2935e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty() && (serviceInfo = listQueryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null) {
                C3941a.m5416f("BillingClient", "The device doesn't have valid Play Store.");
            } else {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                intent2.putExtra("playBillingLibraryVersion", this.f2932b);
                if (this.f2935e.bindService(intent2, this.f2937g, 1)) {
                    C3941a.m5415e("BillingClient", "Service was bonded successfully.");
                    return;
                }
                C3941a.m5416f("BillingClient", "Connection to Billing service is blocked.");
            }
        }
        this.f2931a = 0;
        C3941a.m5415e("BillingClient", "Billing service unavailable on device.");
        interfaceC1616b.onBillingSetupFinished(C1631p.f2973b);
    }

    /* renamed from: i */
    public final Handler m807i() {
        return Looper.myLooper() == null ? this.f2933c : new Handler(Looper.myLooper());
    }

    /* renamed from: j */
    public final BillingResult m808j(BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.f2933c.post(new RunnableC1638w(this, billingResult));
        return billingResult;
    }

    /* renamed from: k */
    public final BillingResult m809k() {
        return (this.f2931a == 0 || this.f2931a == 3) ? C1631p.f2981j : C1631p.f2979h;
    }

    @Nullable
    /* renamed from: l */
    public final <T> Future<T> m810l(Callable<T> callable, long j, @Nullable Runnable runnable, Handler handler) {
        long j2 = (long) (j * 0.95d);
        if (this.f2947q == null) {
            this.f2947q = Executors.newFixedThreadPool(C3941a.f10479a, new ThreadFactoryC1626k(this));
        }
        try {
            Future<T> futureSubmit = this.f2947q.submit(callable);
            handler.postDelayed(new RunnableC1615a0(futureSubmit, runnable), j2);
            return futureSubmit;
        } catch (Exception e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Async task throws exception ");
            sb.append(strValueOf);
            C3941a.m5416f("BillingClient", sb.toString());
            return null;
        }
    }
}
