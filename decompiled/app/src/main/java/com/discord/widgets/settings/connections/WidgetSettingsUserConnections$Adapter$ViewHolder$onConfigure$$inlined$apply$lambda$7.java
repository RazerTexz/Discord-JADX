package com.discord.widgets.settings.connections;

import android.view.View;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;

/* compiled from: WidgetSettingsUserConnections.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ ConnectedAccountIntegration $integration$inlined;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7(ConnectedAccountIntegration connectedAccountIntegration, WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.$integration$inlined = connectedAccountIntegration;
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnJoinIntegration().invoke(this.$integration$inlined.getId());
    }
}
