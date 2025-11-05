package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder$configure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem $benefitAdapterItem;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder$configure$1(GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder itemViewHolder, GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem) {
        this.this$0 = itemViewHolder;
        this.$benefitAdapterItem = guildRoleSubscriptionBenefitAdapterItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder.access$getListener$p(this.this$0).onBenefitItemClick(this.$benefitAdapterItem);
    }
}
