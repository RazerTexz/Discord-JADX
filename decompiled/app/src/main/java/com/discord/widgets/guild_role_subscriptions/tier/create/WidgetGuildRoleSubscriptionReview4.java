package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$planSetupViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview4 extends Lambda implements Function0<GuildRoleSubscriptionPlanSetupViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview4(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionPlanSetupViewModel invoke() {
        return new GuildRoleSubscriptionPlanSetupViewModel(WidgetGuildRoleSubscriptionReview.access$getGuildId$p(this.this$0), null, null, 6, null);
    }
}
