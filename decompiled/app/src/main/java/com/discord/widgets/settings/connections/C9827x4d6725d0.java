package com.discord.widgets.settings.connections;

import android.widget.CompoundButton;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;

/* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$4 */
/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9827x4d6725d0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ConnectedAccount $connectedAccount;
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public C9827x4d6725d0(ConnectedAccount connectedAccount, WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.$connectedAccount = connectedAccount;
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetSettingsUserConnections.Adapter.ViewHolder.access$updateUserConnection(this.this$0, this.$connectedAccount);
    }
}
