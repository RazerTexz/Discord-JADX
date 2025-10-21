package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import rx.Observable;

/* compiled from: SettingsPremiumViewModel.kt */
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel5<T, R> implements Func1<StoreSubscriptions.SubscriptionsState, Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice>> {
    public final /* synthetic */ RestAPI $restAPI;

    public SettingsPremiumViewModel5(RestAPI restAPI) {
        this.$restAPI = restAPI;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        return call2(subscriptionsState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call2(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        SettingsPremiumViewModel.Companion companion = SettingsPremiumViewModel.INSTANCE;
        RestAPI restAPI = this.$restAPI;
        Intrinsics3.checkNotNullExpressionValue(subscriptionsState, "state");
        return SettingsPremiumViewModel.Companion.access$getSubscriptionsAndInvoicePreview(companion, restAPI, subscriptionsState, false);
    }
}
