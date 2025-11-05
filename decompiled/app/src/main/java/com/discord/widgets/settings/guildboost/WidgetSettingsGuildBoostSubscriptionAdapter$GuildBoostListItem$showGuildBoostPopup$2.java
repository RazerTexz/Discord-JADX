package com.discord.widgets.settings.guildboost;

import android.view.MenuItem;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$2 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem $data;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$2(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem guildBoostItem) {
        this.this$0 = guildBoostListItem;
        this.$data = guildBoostItem;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetSettingsGuildBoostSubscriptionAdapter.access$getCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$data.getBoostSlot().getId()), Boolean.TRUE);
        return true;
    }
}
