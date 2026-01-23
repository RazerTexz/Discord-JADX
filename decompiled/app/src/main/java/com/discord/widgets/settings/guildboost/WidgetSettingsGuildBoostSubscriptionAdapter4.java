package com.discord.widgets.settings.guildboost;

import android.view.MenuItem;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter4 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem $data;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter4(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem guildBoostItem) {
        this.this$0 = guildBoostListItem;
        this.$data = guildBoostItem;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        WidgetSettingsGuildBoostSubscriptionAdapter.access$getCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$data.getBoostSlot().getId()), Boolean.TRUE);
        return true;
    }
}
