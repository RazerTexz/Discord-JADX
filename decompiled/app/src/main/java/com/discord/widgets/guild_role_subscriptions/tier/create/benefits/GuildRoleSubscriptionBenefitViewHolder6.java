package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder$configure$1, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder6 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem $benefitAdapterItem;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder6(GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder itemViewHolder, GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem) {
        this.this$0 = itemViewHolder;
        this.$benefitAdapterItem = guildRoleSubscriptionBenefitAdapterItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder.access$getListener$p(this.this$0).onBenefitItemClick(this.$benefitAdapterItem);
    }
}
