package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8542xe408467d implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public C8542xe408467d(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        MaterialRadioButton materialRadioButton = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).f16956b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
        if (i == materialRadioButton.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(true);
            return;
        }
        MaterialRadioButton materialRadioButton2 = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).f16961g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
        if (i == materialRadioButton2.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(false);
        }
    }
}
