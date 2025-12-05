package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;

/* compiled from: WidgetChannelsListAdapter.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemGuildRoleSubscriptionsOverview$onConfigure$1 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC7447xa37c6430 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildRoleSubscriptionsOverview this$0;

    public ViewOnClickListenerC7447xa37c6430(WidgetChannelsListAdapter.ItemGuildRoleSubscriptionsOverview itemGuildRoleSubscriptionsOverview) {
        this.this$0 = itemGuildRoleSubscriptionsOverview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemGuildRoleSubscriptionsOverview.access$getAdapter$p(this.this$0).getOnViewGuildRoleSubscriptions().invoke();
    }
}
