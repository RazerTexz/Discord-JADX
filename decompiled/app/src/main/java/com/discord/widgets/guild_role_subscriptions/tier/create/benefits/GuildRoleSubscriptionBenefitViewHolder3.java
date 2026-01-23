package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem $data$inlined;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder3(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder, GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem freeTrialItem) {
        this.this$0 = freeTrialViewHolder;
        this.$data$inlined = freeTrialItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$data$inlined.isFreeTrialEnabled()) {
            GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0).onActiveTrialUserLimitClick();
        }
    }
}
