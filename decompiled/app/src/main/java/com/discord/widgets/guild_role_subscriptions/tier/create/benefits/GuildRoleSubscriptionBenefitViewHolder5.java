package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder5 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder5(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder) {
        this.this$0 = freeTrialViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitAdapter.Listener listenerAccess$getListener$p = GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getBinding$p(this.this$0).f15472e, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
        listenerAccess$getListener$p.onFreeTrialToggle(!r0.isChecked());
    }
}
