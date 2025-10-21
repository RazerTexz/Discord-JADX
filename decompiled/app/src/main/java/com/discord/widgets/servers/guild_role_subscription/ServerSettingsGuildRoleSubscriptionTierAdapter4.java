package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$TierItemViewHolder$configureUI$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter4 implements View.OnClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier $tierAdapterItem;

    public ServerSettingsGuildRoleSubscriptionTierAdapter4(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener, ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tier) {
        this.$itemClickListener = itemClickListener;
        this.$tierAdapterItem = tier;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$itemClickListener.onTierItemClick(this.$tierAdapterItem.getTierListingId());
    }
}
