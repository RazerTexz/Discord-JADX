package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$tierName$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit8 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit8(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.this$0.getMostRecentIntent().getStringExtra("INTENT_EXTRA_TIER_NAME");
    }
}
