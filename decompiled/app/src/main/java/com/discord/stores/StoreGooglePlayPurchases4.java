package com.discord.stores;

import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationSuccess$$inlined$forEach$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String $sku;
    public final /* synthetic */ StoreGooglePlayPurchases.VerificationResult $verificationResult$inlined;
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases4(String str, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases.VerificationResult verificationResult) {
        super(0);
        this.$sku = str;
        this.this$0 = storeGooglePlayPurchases;
        this.$verificationResult$inlined = verificationResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PublishSubject publishSubjectAccess$getEventSubject$p = StoreGooglePlayPurchases.access$getEventSubject$p(this.this$0);
        String str = this.$sku;
        Intrinsics3.checkNotNullExpressionValue(str, "sku");
        RestAPIParams.VerifyPurchaseResponse apiResponse = this.$verificationResult$inlined.getApiResponse();
        Long lValueOf = apiResponse != null ? Long.valueOf(apiResponse.getVerifiedSkuId()) : null;
        RestAPIParams.VerifyPurchaseResponse apiResponse2 = this.$verificationResult$inlined.getApiResponse();
        Long subscriptionPlanId = apiResponse2 != null ? apiResponse2.getSubscriptionPlanId() : null;
        RestAPIParams.VerifyPurchaseResponse apiResponse3 = this.$verificationResult$inlined.getApiResponse();
        publishSubjectAccess$getEventSubject$p.f27650k.onNext(new StoreGooglePlayPurchases.Event.PurchaseQuerySuccess(str, lValueOf, subscriptionPlanId, apiResponse3 != null ? apiResponse3.getGiftCode() : null));
        StoreGooglePlayPurchases.access$setQueryState$p(this.this$0, StoreGooglePlayPurchases.QueryState.NotInProgress.INSTANCE);
        this.this$0.markChanged();
    }
}
