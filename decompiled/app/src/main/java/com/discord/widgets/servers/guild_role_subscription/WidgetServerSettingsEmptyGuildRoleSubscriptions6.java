package com.discord.widgets.servers.guild_role_subscription;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions6 extends Lambda implements Function0<ServerSettingsEmptyGuildRoleSubscriptionsViewModel> {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmptyGuildRoleSubscriptions6(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        super(0);
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsEmptyGuildRoleSubscriptionsViewModel invoke() {
        return new ServerSettingsEmptyGuildRoleSubscriptionsViewModel(WidgetServerSettingsEmptyGuildRoleSubscriptions.access$getGuildId$p(this.this$0), null, 2, null);
    }
}
