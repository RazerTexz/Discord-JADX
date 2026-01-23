package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.EntitlementListItem this$0;

    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5(WidgetSettingsGiftingAdapter.EntitlementListItem entitlementListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem) {
        this.this$0 = entitlementListItem;
        this.$data = giftItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getOnGenerateClickListener$p = WidgetSettingsGiftingAdapter.access$getOnGenerateClickListener$p(WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0));
        Long lValueOf = Long.valueOf(this.$data.getEntitlement().getSkuId());
        SubscriptionPlan subscriptionPlan = this.$data.getEntitlement().getSubscriptionPlan();
        function2Access$getOnGenerateClickListener$p.invoke(lValueOf, subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null);
    }
}
