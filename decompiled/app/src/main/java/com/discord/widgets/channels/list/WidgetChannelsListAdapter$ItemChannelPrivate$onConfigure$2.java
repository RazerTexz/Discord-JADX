package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelPrivate this$0;

    public WidgetChannelsListAdapter$ItemChannelPrivate$onConfigure$2(WidgetChannelsListAdapter.ItemChannelPrivate itemChannelPrivate, ChannelListItem channelListItem) {
        this.this$0 = itemChannelPrivate;
        this.$data = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemChannelPrivate.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(((ChannelListItemPrivate) this.$data).getChannel());
    }
}
