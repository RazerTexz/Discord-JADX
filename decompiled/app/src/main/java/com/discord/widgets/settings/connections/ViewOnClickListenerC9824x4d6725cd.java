package com.discord.widgets.settings.connections;

import android.view.View;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: WidgetSettingsUserConnections.kt */
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC9824x4d6725cd implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public ViewOnClickListenerC9824x4d6725cd(Platform platform, WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.$platform = platform;
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "view", "view.context"), this.$platform.getProfileUrl(this.$data$inlined.getConnectedAccount().getConnection()), false, false, null, 28, null);
    }
}
