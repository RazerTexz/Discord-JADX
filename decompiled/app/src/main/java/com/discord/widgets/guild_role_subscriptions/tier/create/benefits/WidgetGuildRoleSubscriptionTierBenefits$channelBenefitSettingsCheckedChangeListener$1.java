package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        MaterialRadioButton materialRadioButton = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).f2439b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
        if (i == materialRadioButton.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(true);
            return;
        }
        MaterialRadioButton materialRadioButton2 = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
        if (i == materialRadioButton2.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(false);
        }
    }
}
