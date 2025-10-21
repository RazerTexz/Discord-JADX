package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import j0.k.Func1;

/* compiled from: SettingsPremiumViewModel.kt */
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel2<T, R> implements Func1<ModelInvoicePreview, SettingsPremiumViewModel.SubscriptionAndInvoice> {
    public final /* synthetic */ StoreSubscriptions.SubscriptionsState $state;

    public SettingsPremiumViewModel2(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        this.$state = subscriptionsState;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.SubscriptionAndInvoice call(ModelInvoicePreview modelInvoicePreview) {
        return call2(modelInvoicePreview);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.SubscriptionAndInvoice call2(ModelInvoicePreview modelInvoicePreview) {
        return new SettingsPremiumViewModel.SubscriptionAndInvoice(this.$state, new SettingsPremiumViewModel.InvoicePreviewFetch.Invoice(modelInvoicePreview));
    }
}
