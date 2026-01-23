package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.google.android.material.button.MaterialButton;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium4 implements View.OnClickListener {
    public final /* synthetic */ MaterialButton $button;
    public final /* synthetic */ ModelSubscription $premiumSubscription$inlined;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium4(MaterialButton materialButton, WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        this.$button = materialButton;
        this.this$0 = widgetSettingsPremium;
        this.$premiumSubscription$inlined = modelSubscription;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlan.Companion companion = WidgetChoosePlan.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        WidgetChoosePlan.ViewType viewType = Intrinsics3.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).f18048t.f667b) ? WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_1 : WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_2;
        ModelSubscription modelSubscription = this.$premiumSubscription$inlined;
        WidgetChoosePlan.Companion.launch$default(companion, contextRequireContext, null, viewType, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null, new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(this.this$0), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), Traits.Subscription.INSTANCE.withGatewayPlanId(Intrinsics3.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).f18048t.f667b) ? GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName() : GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()), 2, null);
    }
}
