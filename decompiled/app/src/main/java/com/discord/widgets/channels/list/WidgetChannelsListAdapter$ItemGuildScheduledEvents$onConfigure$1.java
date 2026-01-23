package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemGuildScheduledEvents $item;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildScheduledEvents this$0;

    public WidgetChannelsListAdapter$ItemGuildScheduledEvents$onConfigure$1(WidgetChannelsListAdapter.ItemGuildScheduledEvents itemGuildScheduledEvents, ChannelListItemGuildScheduledEvents channelListItemGuildScheduledEvents) {
        this.this$0 = itemGuildScheduledEvents;
        this.$item = channelListItemGuildScheduledEvents;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemGuildScheduledEvents.access$getAdapter$p(this.this$0).getOnViewGuildScheduledEvents().invoke(this.$item.getGuild());
    }
}
