package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions4 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    public WidgetServerSettingsEmptyGuildRoleSubscriptions4(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEnableMonetizationUnavailable.INSTANCE.launch(this.this$0.requireContext());
    }
}
