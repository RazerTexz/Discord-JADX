package com.discord.widgets.settings.connections;

import android.view.View;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import com.discord.utilities.platform.Platform;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Maps6;

/* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2 */
/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC9825x4d6725ce implements View.OnClickListener {
    public final /* synthetic */ ConnectedAccount $connectedAccount;
    public final /* synthetic */ String $connectionId;
    public final /* synthetic */ WidgetSettingsUserConnections.UserConnectionItem $data$inlined;
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ WidgetSettingsUserConnections.Adapter.ViewHolder this$0;

    public ViewOnClickListenerC9825x4d6725ce(ConnectedAccount connectedAccount, Platform platform, String str, WidgetSettingsUserConnections.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnections.UserConnectionItem userConnectionItem) {
        this.$connectedAccount = connectedAccount;
        this.$platform = platform;
        this.$connectionId = str;
        this.this$0 = viewHolder;
        this.$data$inlined = userConnectionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NoticeBuilders.INSTANCE.showNotice(outline.m885x(view, "v", "v.context"), this.this$0.this$0.getFragmentManager(), new StoreNotices.Dialog(StoreNotices.Dialog.Type.DELETE_CONNECTION_MODAL, Maps6.mapOf(Tuples.m10073to(WidgetSettingsUserConnections.PLATFORM_NAME, this.$connectedAccount.getType()), Tuples.m10073to(WidgetSettingsUserConnections.PLATFORM_TITLE, this.$platform.getProperName()), Tuples.m10073to(WidgetSettingsUserConnections.CONNECTION_ID, this.$connectionId))));
    }
}
