package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func7;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$3, reason: use source file name */
/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel6<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<StorePaymentSources.PaymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice, StoreEntitlements.State, StoreGuildBoost.State, StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, SettingsPremiumViewModel.StoreState> {
    public static final SettingsPremiumViewModel6 INSTANCE = new SettingsPremiumViewModel6();

    @Override // p658rx.functions.Func7
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice2, StoreEntitlements.State state, StoreGuildBoost.State state2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
        return call2(paymentSourcesState, subscriptionAndInvoice, subscriptionAndInvoice2, state, state2, state3, state4);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.StoreState call2(StorePaymentSources.PaymentSourcesState paymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice2, StoreEntitlements.State state, StoreGuildBoost.State state2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
        Intrinsics3.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
        StoreSubscriptions.SubscriptionsState subscriptionsState = subscriptionAndInvoice.getSubscriptionsState();
        Intrinsics3.checkNotNullExpressionValue(state, "entitlementsState");
        Intrinsics3.checkNotNullExpressionValue(state2, "guildSubscriptionState");
        SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch = subscriptionAndInvoice.getInvoicePreviewFetch();
        SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch2 = subscriptionAndInvoice2.getInvoicePreviewFetch();
        Intrinsics3.checkNotNullExpressionValue(state3, "skuDetailsState");
        Intrinsics3.checkNotNullExpressionValue(state4, "purchaseState");
        return new SettingsPremiumViewModel.StoreState(paymentSourcesState, subscriptionsState, state, state2, invoicePreviewFetch, invoicePreviewFetch2, state3, state4);
    }
}
