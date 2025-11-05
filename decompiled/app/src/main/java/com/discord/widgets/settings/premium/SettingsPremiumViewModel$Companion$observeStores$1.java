package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* compiled from: SettingsPremiumViewModel.kt */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel$Companion$observeStores$1<T, R> implements b<StoreSubscriptions.SubscriptionsState, Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice>> {
    public final /* synthetic */ RestAPI $restAPI;

    public SettingsPremiumViewModel$Companion$observeStores$1(RestAPI restAPI) {
        this.$restAPI = restAPI;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        return call2(subscriptionsState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call2(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        SettingsPremiumViewModel.Companion companion = SettingsPremiumViewModel.INSTANCE;
        RestAPI restAPI = this.$restAPI;
        m.checkNotNullExpressionValue(subscriptionsState, "state");
        return SettingsPremiumViewModel.Companion.access$getSubscriptionsAndInvoicePreview(companion, restAPI, subscriptionsState, true);
    }
}
