package com.discord.widgets.guild_role_subscriptions.tier.create;

import p007b.p440k.p441a.p442a.ColorPickerDialogListener;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign5 implements ColorPickerDialogListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    public WidgetGuildRoleSubscriptionTierDesign5(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
    public void onColorReset(int dialogId) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(null);
    }

    @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
    public void onColorSelected(int dialogId, int selectedColor) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(Integer.valueOf(selectedColor));
    }

    @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
    public void onDialogDismissed(int dialogId) {
    }
}
