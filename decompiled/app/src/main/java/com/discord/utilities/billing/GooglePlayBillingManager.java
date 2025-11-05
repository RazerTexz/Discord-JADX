package com.discord.utilities.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import b.d.a.a.b;
import b.d.a.a.d;
import b.d.a.a.e;
import b.d.a.a.f;
import b.d.a.a.g;
import b.d.a.a.h;
import b.d.a.a.i;
import b.d.b.a.a;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.google.gson.JsonIOException;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: GooglePlayBillingManager.kt */
/* loaded from: classes2.dex */
public final class GooglePlayBillingManager implements g, b, i, e {
    private static final long DEFAULT_BACKOFF_TIME_MS = 1000;
    public static final String PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL = "https://play.google.com/store/account/subscriptions?sku=%s&package=%s";
    public static final String PLAY_STORE_SUBSCRIPTION_URL = "https://play.google.com/store/account/subscriptions";
    private static BillingClient billingClient;
    private static boolean isAuthenticated;
    public static final GooglePlayBillingManager INSTANCE = new GooglePlayBillingManager();
    private static AtomicLong backoffTimeMs = new AtomicLong(1000);
    private static Map<String, InAppSkuToConsume> inAppSkusToConsume = new HashMap();

    /* compiled from: GooglePlayBillingManager.kt */
    public static final class GooglePlayBillingManagerLifecycleListener extends ActivityLifecycleCallbacks {
        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreated(activity, savedInstanceState);
            j jVar = j.g;
            if (activity.g(j.f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.onActivityCreated();
                }
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            j jVar = j.g;
            if (activity.g(j.f)) {
                GooglePlayBillingManager.INSTANCE.onActivityDestroyed();
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityResumed(AppActivity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityResumed(activity);
            j jVar = j.g;
            if (activity.g(j.f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.queryPurchases();
                }
            }
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    public static final /* data */ class InAppSkuToConsume {
        private final String paymentGatewaySkuId;
        private final Long skuId;
        private final InAppSkuType type;

        public InAppSkuToConsume(InAppSkuType inAppSkuType, Long l, String str) {
            m.checkNotNullParameter(inAppSkuType, "type");
            m.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.type = inAppSkuType;
            this.skuId = l;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ InAppSkuToConsume copy$default(InAppSkuToConsume inAppSkuToConsume, InAppSkuType inAppSkuType, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inAppSkuType = inAppSkuToConsume.type;
            }
            if ((i & 2) != 0) {
                l = inAppSkuToConsume.skuId;
            }
            if ((i & 4) != 0) {
                str = inAppSkuToConsume.paymentGatewaySkuId;
            }
            return inAppSkuToConsume.copy(inAppSkuType, l, str);
        }

        /* renamed from: component1, reason: from getter */
        public final InAppSkuType getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final InAppSkuToConsume copy(InAppSkuType type, Long skuId, String paymentGatewaySkuId) {
            m.checkNotNullParameter(type, "type");
            m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
            return new InAppSkuToConsume(type, skuId, paymentGatewaySkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InAppSkuToConsume)) {
                return false;
            }
            InAppSkuToConsume inAppSkuToConsume = (InAppSkuToConsume) other;
            return m.areEqual(this.type, inAppSkuToConsume.type) && m.areEqual(this.skuId, inAppSkuToConsume.skuId) && m.areEqual(this.paymentGatewaySkuId, inAppSkuToConsume.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public final InAppSkuType getType() {
            return this.type;
        }

        public int hashCode() {
            InAppSkuType inAppSkuType = this.type;
            int iHashCode = (inAppSkuType != null ? inAppSkuType.hashCode() : 0) * 31;
            Long l = this.skuId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.paymentGatewaySkuId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("InAppSkuToConsume(type=");
            sbU.append(this.type);
            sbU.append(", skuId=");
            sbU.append(this.skuId);
            sbU.append(", paymentGatewaySkuId=");
            return a.J(sbU, this.paymentGatewaySkuId, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            InAppSkuType.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            InAppSkuType inAppSkuType = InAppSkuType.PREMIUM_GIFT;
            iArr[inAppSkuType.ordinal()] = 1;
            InAppSkuType.values();
            int[] iArr2 = new int[1];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[inAppSkuType.ordinal()] = 1;
            InAppSkuType.values();
            $EnumSwitchMapping$2 = new int[1];
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            GooglePlayBillingManager.access$setAuthenticated$p(GooglePlayBillingManager.INSTANCE, z2);
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$onBillingServiceDisconnected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ long $currentBackoffTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$currentBackoffTimeMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).d()) {
                return;
            }
            GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).h(googlePlayBillingManager);
            GooglePlayBillingManager.access$getBackoffTimeMs$p(googlePlayBillingManager).set(this.$currentBackoffTimeMs * 2);
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$queryPurchases$1, reason: invalid class name */
    public static final class AnonymousClass1 implements f {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // b.d.a.a.f
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            m.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
            m.checkNotNullParameter(list, "purchasesList");
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "subs");
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$queryPurchases$2, reason: invalid class name */
    public static final class AnonymousClass2 implements f {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // b.d.a.a.f
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            m.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
            m.checkNotNullParameter(list, "purchasesList");
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "inapp");
        }
    }

    private GooglePlayBillingManager() {
    }

    public static final /* synthetic */ AtomicLong access$getBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager) {
        return backoffTimeMs;
    }

    public static final /* synthetic */ BillingClient access$getBillingClient$p(GooglePlayBillingManager googlePlayBillingManager) {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        return billingClient2;
    }

    public static final /* synthetic */ boolean access$isAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager) {
        return isAuthenticated;
    }

    public static final /* synthetic */ void access$setAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager, boolean z2) {
        isAuthenticated = z2;
    }

    public static final /* synthetic */ void access$setBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager, AtomicLong atomicLong) {
        backoffTimeMs = atomicLong;
    }

    public static final /* synthetic */ void access$setBillingClient$p(GooglePlayBillingManager googlePlayBillingManager, BillingClient billingClient2) {
        billingClient = billingClient2;
    }

    private final void handleConsumeEnd(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            inAppSkuToConsume.getType();
        }
    }

    private final void handleConsumeFailure(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowFailed(inAppSkuToConsume.getPaymentGatewaySkuId());
        }
    }

    private final void handleConsumeStart(Purchase purchase, InAppSkuToConsume inAppSkuToConsume) {
        Map<String, InAppSkuToConsume> map = inAppSkusToConsume;
        String strA = purchase.a();
        m.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        map.put(strA, inAppSkuToConsume);
        if (inAppSkuToConsume.getType().ordinal() != 0) {
            throw new NoWhenBranchMatchedException();
        }
        KotlinExtensionsKt.getExhaustive(Unit.a);
    }

    private final void handleConsumeSuccess(String purchaseToken) throws JsonIOException {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowCompleted(inAppSkuToConsume.getPaymentGatewaySkuId());
            if (inAppSkuToConsume.getType().ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinExtensionsKt.getExhaustive(Unit.a);
        }
    }

    private final void queryInAppSkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            List<GooglePlayInAppSku> skus = GooglePlayInAppSkus.INSTANCE.getSkus();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(skus, 10));
            Iterator<T> it = skus.iterator();
            while (it.hasNext()) {
                arrayList.add(((GooglePlayInAppSku) it.next()).getPaymentGatewaySkuId());
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            h hVar = new h();
            hVar.a = "inapp";
            hVar.f450b = arrayList2;
            m.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…kuNames)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }

    public final void consumePurchase(Purchase purchase, InAppSkuType inAppSkuType, Long skuId) {
        m.checkNotNullParameter(purchase, "purchase");
        m.checkNotNullParameter(inAppSkuType, "inAppSkuType");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            String strA = purchase.a();
            if (strA == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            d dVar = new d();
            dVar.a = strA;
            m.checkNotNullExpressionValue(dVar, "ConsumeParams.newBuilder…se.purchaseToken).build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.a(dVar, this);
            ArrayList<String> arrayListB = purchase.b();
            m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
            for (String str : arrayListB) {
                GooglePlayBillingManager googlePlayBillingManager = INSTANCE;
                m.checkNotNullExpressionValue(str, "sku");
                googlePlayBillingManager.handleConsumeStart(purchase, new InAppSkuToConsume(inAppSkuType, skuId, str));
            }
        }
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        b.d.a.a.a aVar = new b.d.a.a.a(null, true, applicationContext, this);
        m.checkNotNullExpressionValue(aVar, "BillingClient.newBuilder…chases()\n        .build()");
        billingClient = aVar;
        application.registerActivityLifecycleCallbacks(new GooglePlayBillingManagerLifecycleListener());
        ObservableExtensionsKt.appSubscribe$default(StoreStream.INSTANCE.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams params) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(params, "params");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.d()) {
            return -1;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult billingResultE = billingClient3.e(activity, params);
        m.checkNotNullExpressionValue(billingResultE, "billingClient.launchBillingFlow(activity, params)");
        return billingResultE.a;
    }

    public final void onActivityCreated() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            return;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient3.h(this);
    }

    public final void onActivityDestroyed() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.b();
        }
    }

    @Override // b.d.a.a.b
    public void onBillingServiceDisconnected() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.c() != 0) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient3.c() != 3) {
                return;
            }
        }
        long j = backoffTimeMs.get();
        Observable<Long> observableD0 = Observable.d0(j, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(j), 62, (Object) null);
    }

    @Override // b.d.a.a.b
    public void onBillingSetupFinished(BillingResult billingResult) {
        m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a == 0) {
            querySkuDetails();
            queryInAppSkuDetails();
            queryPurchases();
            backoffTimeMs.set(1000L);
        }
    }

    @Override // b.d.a.a.e
    public void onConsumeResponse(BillingResult billingResult, String purchaseToken) throws JsonIOException {
        m.checkNotNullParameter(billingResult, "billingResult");
        m.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.a == 0) {
            handleConsumeSuccess(purchaseToken);
        } else {
            handleConsumeFailure(purchaseToken);
            AppLog appLog = AppLog.g;
            StringBuilder sbX = a.X("Failed to consume purchase. ", "Billing Response Code: ");
            sbX.append(billingResult.a);
            sbX.append(", ");
            sbX.append("Purchase Token: ");
            sbX.append(purchaseToken);
            Logger.e$default(appLog, sbX.toString(), null, null, 6, null);
        }
        handleConsumeEnd(purchaseToken);
    }

    @Override // b.d.a.a.g
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        boolean z2;
        m.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a != 0) {
            StoreStream.INSTANCE.getGooglePlayPurchases().updatePendingDowngrade(null);
        }
        int i = billingResult.a;
        if (i != 0) {
            if (i == 1) {
                AppLog.i("onPurchasesUpdated: User canceled the purchase");
                return;
            } else if (i == 5) {
                Logger.e$default(AppLog.g, "onPurchasesUpdated: Google Play doesn't recognize this app config. Verify the SKU product ID and the signed APK you are using.", null, null, 6, null);
                return;
            } else {
                if (i != 7) {
                    return;
                }
                AppLog.i("onPurchasesUpdated: The user already owns this item");
                return;
            }
        }
        if (purchases == null || purchases.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().downgradePurchase();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                ArrayList<String> arrayListB = purchase.b();
                m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                if (arrayListB.isEmpty()) {
                    z2 = false;
                } else {
                    for (String str : arrayListB) {
                        GooglePlayInAppSkus googlePlayInAppSkus = GooglePlayInAppSkus.INSTANCE;
                        m.checkNotNullExpressionValue(str, "sku");
                        if (googlePlayInAppSkus.isInAppSku(str)) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                }
                if (z2) {
                    arrayList2.add(purchase);
                } else {
                    arrayList.add(purchase);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList2, "inapp");
        }
        if (!arrayList.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList, "subs");
        }
    }

    @Override // b.d.a.a.i
    public void onSkuDetailsResponse(BillingResult billingResult, List<? extends SkuDetails> skuDetails) {
        m.checkNotNullParameter(billingResult, "billingResult");
        int i = billingResult.a;
        String str = billingResult.f2003b;
        m.checkNotNullExpressionValue(str, "billingResult.debugMessage");
        switch (i) {
            case -2:
            case 1:
            case 7:
            case 8:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                Logger.e$default(AppLog.g, "onSkuDetailsResponse: " + i + ' ' + str, null, null, 6, null);
                break;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                break;
            case 0:
                StoreGooglePlaySkuDetails googlePlaySkuDetails = StoreStream.INSTANCE.getGooglePlaySkuDetails();
                if (skuDetails == null) {
                    skuDetails = n.emptyList();
                }
                googlePlaySkuDetails.updateSkuDetails(skuDetails);
                break;
        }
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.f("subs", AnonymousClass1.INSTANCE);
            BillingClient billingClient4 = billingClient;
            if (billingClient4 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient4.f("inapp", AnonymousClass2.INSTANCE);
        }
    }

    public final void querySkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            m.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            ArrayList arrayList = new ArrayList(GooglePlaySku.INSTANCE.getALL_SKU_NAMES());
            h hVar = new h();
            hVar.a = "subs";
            hVar.f450b = arrayList;
            m.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…U_NAMES)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                m.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }
}
