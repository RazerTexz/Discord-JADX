package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder4 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem $data$inlined;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder4(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder, GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem freeTrialItem) {
        this.this$0 = freeTrialViewHolder;
        this.$data$inlined = freeTrialItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0).onTrialIntervalClick();
    }
}
