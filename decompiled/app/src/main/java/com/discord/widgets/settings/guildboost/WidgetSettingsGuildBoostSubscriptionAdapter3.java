package com.discord.widgets.settings.guildboost;

import android.view.MenuItem;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter3 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem $data;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter3(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem guildBoostItem) {
        this.this$0 = guildBoostListItem;
        this.$data = guildBoostItem;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ModelAppliedGuildBoost premiumGuildSubscription = this.$data.getBoostSlot().getPremiumGuildSubscription();
        if (premiumGuildSubscription == null) {
            return true;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter.access$getTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(this.$data.getBoostSlot(), Long.valueOf(premiumGuildSubscription.getGuildId()));
        return true;
    }
}
