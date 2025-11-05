package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox;
import d0.z.d.m;

/* compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd.PlatformItem $data;
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd.Adapter.ViewHolder this$0;

    public WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1(WidgetSettingsUserConnectionsAdd.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnectionsAdd.PlatformItem platformItem) {
        this.this$0 = viewHolder;
        this.$data = platformItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.getDialogDismissCallback().invoke();
        if (this.$data.getPlatform().ordinal() == 12) {
            WidgetSettingsUserConnectionsAddXbox.Companion companion = WidgetSettingsUserConnectionsAddXbox.INSTANCE;
            m.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "v.context");
            companion.launch(context);
            return;
        }
        StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
        String platformId = this.$data.getPlatform().getPlatformId();
        m.checkNotNullExpressionValue(view, "v");
        Context context2 = view.getContext();
        m.checkNotNullExpressionValue(context2, "v.context");
        userConnections.authorizeConnection(platformId, context2, Traits.Location.Page.USER_SETTINGS);
    }
}
