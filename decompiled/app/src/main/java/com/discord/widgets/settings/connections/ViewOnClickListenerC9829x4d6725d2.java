package com.discord.widgets.settings.connections;

import android.view.View;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;

/* compiled from: WidgetSettingsUserConnections.kt */
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$6 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC9829x4d6725d2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public ViewOnClickListenerC9829x4d6725d2(WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SpotifyHelper.INSTANCE.openSpotifyApp(this.this$0.this$0.getContext());
    }
}
