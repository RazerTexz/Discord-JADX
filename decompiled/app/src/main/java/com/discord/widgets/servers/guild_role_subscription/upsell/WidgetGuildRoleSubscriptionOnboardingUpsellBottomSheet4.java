package com.discord.widgets.servers.guild_role_subscription.upsell;

import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet4 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet4(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell trackImpressionEnableCreatorMonetizationGuildHeaderUpsell = new TrackImpressionEnableCreatorMonetizationGuildHeaderUpsell();
        trackImpressionEnableCreatorMonetizationGuildHeaderUpsell.c(new TrackGuild(Long.valueOf(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.access$getGuildId$p(this.this$0)), null, null, null, null, null, null, null, null, null, null, null, 4094));
        return trackImpressionEnableCreatorMonetizationGuildHeaderUpsell;
    }
}
