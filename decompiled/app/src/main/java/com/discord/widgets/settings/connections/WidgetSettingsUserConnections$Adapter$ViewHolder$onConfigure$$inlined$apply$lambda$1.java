package com.discord.widgets.settings.connections;

import android.view.View;
import b.d.b.a.a;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;

/* compiled from: WidgetSettingsUserConnections.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1(Platform platform, WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.$platform = platform;
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "view", "view.context"), this.$platform.getProfileUrl(this.$data$inlined.getConnectedAccount().getConnection()), false, false, null, 28, null);
    }
}
