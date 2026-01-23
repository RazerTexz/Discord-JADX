package com.discord.widgets.settings.guildboost;

import android.view.View;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.Item $data;
    public final /* synthetic */ boolean $hasCooldown;
    public final /* synthetic */ boolean $isActiveGuildBoost;
    public final /* synthetic */ ModelGuildBoostSlot $slot;
    public final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem this$0;

    public WidgetSettingsGuildBoostSubscriptionAdapter2(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem guildBoostListItem, boolean z2, boolean z3, WidgetSettingsGuildBoostSubscriptionAdapter.Item item, ModelGuildBoostSlot modelGuildBoostSlot) {
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
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$showGuildBoostPopup(guildBoostListItem, view, this.$hasCooldown, WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter.GuildBoostListItem.access$getAdapter$p(this.this$0)), (WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem) this.$data);
    }
}
