package com.discord.widgets.servers.guild_role_subscription.upsell;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet$guildId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet3(WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
    }
}
