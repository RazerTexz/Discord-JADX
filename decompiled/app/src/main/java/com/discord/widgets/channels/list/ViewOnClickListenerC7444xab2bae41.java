package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemChannelAddServer$onConfigure$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC7444xab2bae41 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelAddServer this$0;

    public ViewOnClickListenerC7444xab2bae41(WidgetChannelsListAdapter.ItemChannelAddServer itemChannelAddServer) {
        this.this$0 = itemChannelAddServer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemChannelAddServer.access$getAdapter$p(this.this$0).getOnAddServer().invoke();
    }
}
