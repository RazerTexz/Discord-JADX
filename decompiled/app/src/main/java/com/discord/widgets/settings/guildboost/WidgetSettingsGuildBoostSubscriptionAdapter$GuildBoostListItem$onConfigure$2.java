package com.discord.widgets.settings.guildboost;

import android.view.View;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import d0.z.d.m;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item $data;
    public final /* synthetic */ boolean $hasCooldown;
    public final /* synthetic */ boolean $isActiveGuildBoost;
    public final /* synthetic */ ModelGuildBoostSlot $slot;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, boolean z2, boolean z3, WidgetSettingsGuildBoostSubscriptionAdapter.Item item, ModelGuildBoostSlot modelGuildBoostSlot) {
        this.this$0 = guildBoostListItem;
        this.$isActiveGuildBoost = z2;
        this.$hasCooldown = z3;
        this.$data = item;
        this.$slot = modelGuildBoostSlot;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.$isActiveGuildBoost && !this.$hasCooldown) {
            WidgetSettingsGuildBoostSubscriptionAdapter.access$getSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$slot.getId()));
            return;
        }
        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem = this.this$0;
        m.checkNotNullExpressionValue(view, "view");
        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$showGuildBoostPopup(guildBoostListItem, view, this.$hasCooldown, WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), (WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem) this.$data);
    }
}
