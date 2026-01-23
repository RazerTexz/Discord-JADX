package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem $data;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder2(GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder addItemViewHolder, GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem addBenefitItem) {
        this.this$0 = addItemViewHolder;
        this.$data = addBenefitItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder.access$getListener$p(this.this$0).onAddBenefitItemClick(this.$data);
    }
}
