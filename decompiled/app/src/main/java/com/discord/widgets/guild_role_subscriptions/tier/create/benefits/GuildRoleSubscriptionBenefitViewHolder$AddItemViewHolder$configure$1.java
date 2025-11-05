package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem $data;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1(GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder addItemViewHolder, GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem addBenefitItem) {
        this.this$0 = addItemViewHolder;
        this.$data = addBenefitItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder.access$getListener$p(this.this$0).onAddBenefitItemClick(this.$data);
    }
}
