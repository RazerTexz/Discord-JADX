package com.discord.utilities.billing;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: BillingUtils.kt */
/* loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$1 */
    public static final class C67021 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67021(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$2 */
    public static final class C67032 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67032(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$1 */
    public static final class C67041 extends Lambda implements Function1<RestAPIParams.VerifyPurchaseResponse, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67041(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            invoke2(verifyPurchaseResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            StoreStream.INSTANCE.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, verifyPurchaseResponse));
            GooglePlayInAppSku inAppSku = GooglePlayInAppSku3.INSTANCE.getInAppSku(this.$sku);
            if (inAppSku != null) {
                GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), verifyPurchaseResponse != null ? Long.valueOf(verifyPurchaseResponse.getVerifiedSkuId()) : null);
            }
        }
    }

    /* compiled from: BillingUtils.kt */
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$2 */
    public static final class C67052 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67052(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
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
        if (GooglePlayInAppSku3.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strM7497a = purchase.m7497a();
        Intrinsics3.checkNotNullExpressionValue(strM7497a, "purchase.purchaseToken");
        String strOptString = purchase.f14563c.optString("packageName");
        Intrinsics3.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseTokenBody = new RestAPIParams.VerifyPurchaseTokenBody(strM7497a, id2, strOptString, str, str2);
        companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().verifyPurchaseToken(verifyPurchaseTokenBody), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new C67052(purchase, sku), (Function0) null, (Function0) null, new C67041(purchase, sku), 54, (Object) null);
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createPurchaseMetadata(new RestAPIParams.PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new C67032(onFailure), (Function0) null, (Function0) null, new C67021(onSuccess), 54, (Object) null);
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.f14563c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.m7499c()) {
                    ArrayList<String> arrayListM7498b = purchase.m7498b();
                    Intrinsics3.checkNotNullExpressionValue(arrayListM7498b, "purchase.skus");
                    for (String str : arrayListM7498b) {
                        BillingUtils billingUtils = INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
