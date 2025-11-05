package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* loaded from: classes2.dex */
public final class TierViewHolder$TierItemViewHolder$configureUI$1 implements View.OnClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier $tierAdapterItem;

    public TierViewHolder$TierItemViewHolder$configureUI$1(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener, ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier tier) {
        this.$itemClickListener = itemClickListener;
        this.$tierAdapterItem = tier;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$itemClickListener.onTierItemClick(this.$tierAdapterItem.getTierListingId());
    }
}
