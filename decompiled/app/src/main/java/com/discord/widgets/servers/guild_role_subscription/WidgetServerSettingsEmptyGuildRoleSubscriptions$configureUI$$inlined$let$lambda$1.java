package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    public WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildRoleSubscriptionPlanSetup.INSTANCE.launch(this.this$0.requireContext(), WidgetServerSettingsEmptyGuildRoleSubscriptions.access$getGuildId$p(this.this$0));
        this.this$0.requireActivity().finish();
    }
}
