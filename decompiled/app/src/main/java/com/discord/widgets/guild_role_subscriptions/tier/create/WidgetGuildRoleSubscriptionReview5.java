package com.discord.widgets.guild_role_subscriptions.tier.create;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$reviewViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview5 extends Lambda implements Function0<GuildRoleSubscriptionReviewViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview5(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionReviewViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionReviewViewModel invoke() {
        return new GuildRoleSubscriptionReviewViewModel(WidgetGuildRoleSubscriptionReview.access$getGuildId$p(this.this$0), null, null, null, 14, null);
    }
}
