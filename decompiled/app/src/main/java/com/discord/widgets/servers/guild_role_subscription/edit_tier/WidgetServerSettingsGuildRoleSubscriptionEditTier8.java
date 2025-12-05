package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier8 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionEditTierViewModel> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier8(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel invoke() {
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getGuildId$p(this.this$0), WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getGuildRoleSubscriptionTierListingId$p(this.this$0), WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getGuildRoleSubscriptionGroupListingId$p(this.this$0), null, null, null, null, null, null, 504, null);
    }
}
