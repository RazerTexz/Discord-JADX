package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsPremium.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsPremium7 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ModelSubscription $premiumSubscription;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium7(WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        super(0);
        this.this$0 = widgetSettingsPremium;
        this.$premiumSubscription = modelSubscription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChoosePlan.Companion.launch$default(WidgetChoosePlan.INSTANCE, this.this$0.requireContext(), null, WidgetChoosePlan.ViewType.SWITCH_PLANS, this.$premiumSubscription.getPaymentGatewayPlanId(), new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(this.this$0), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), null, 34, null);
    }
}
