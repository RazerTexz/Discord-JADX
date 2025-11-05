package com.discord.utilities.billing;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: BillingUtils.kt */
/* loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Unit, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RestAPIParams.VerifyPurchaseResponse, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            invoke2(verifyPurchaseResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            StoreStream.INSTANCE.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, verifyPurchaseResponse));
            GooglePlayInAppSku inAppSku = GooglePlayInAppSkus.INSTANCE.getInAppSku(this.$sku);
            if (inAppSku != null) {
                GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), verifyPurchaseResponse != null ? Long.valueOf(verifyPurchaseResponse.getVerifiedSkuId()) : null);
            }
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getGooglePlayPurchases().onVerificationFailure(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, null));
            companion.getGooglePlayPurchases().trackPaymentFlowFailed(this.$sku);
        }
    }

    private BillingUtils() {
    }

    private final void verifyPurchase(Purchase purchase, String sku) {
        String str;
        String str2;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        if (GooglePlayInAppSkus.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strA = purchase.a();
        m.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        String strOptString = purchase.c.optString("packageName");
        m.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseTokenBody = new RestAPIParams.VerifyPurchaseTokenBody(strA, id2, strOptString, str, str2);
        companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().verifyPurchaseToken(verifyPurchaseTokenBody), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new AnonymousClass2(purchase, sku), (Function0) null, (Function0) null, new AnonymousClass1(purchase, sku), 54, (Object) null);
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createPurchaseMetadata(new RestAPIParams.PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new AnonymousClass2(onFailure), (Function0) null, (Function0) null, new AnonymousClass1(onSuccess), 54, (Object) null);
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.c()) {
                    ArrayList<String> arrayListB = purchase.b();
                    m.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                    for (String str : arrayListB) {
                        BillingUtils billingUtils = INSTANCE;
                        m.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
