package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2, reason: use source file name */
/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel3<T, R> implements Func1<Throwable, SettingsPremiumViewModel.SubscriptionAndInvoice> {
    public final /* synthetic */ StoreSubscriptions.SubscriptionsState $state;

    public SettingsPremiumViewModel3(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        this.$state = subscriptionsState;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.SubscriptionAndInvoice call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.SubscriptionAndInvoice call2(Throwable th) {
        return new SettingsPremiumViewModel.SubscriptionAndInvoice(this.$state, SettingsPremiumViewModel.InvoicePreviewFetch.Error.INSTANCE);
    }
}
