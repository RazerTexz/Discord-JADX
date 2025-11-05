package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import d0.z.d.m;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder) {
        this.this$0 = freeTrialViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitAdapter.Listener listenerAccess$getListener$p = GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0);
        m.checkNotNullExpressionValue(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getBinding$p(this.this$0).e, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
        listenerAccess$getListener$p.onFreeTrialToggle(!r0.isChecked());
    }
}
