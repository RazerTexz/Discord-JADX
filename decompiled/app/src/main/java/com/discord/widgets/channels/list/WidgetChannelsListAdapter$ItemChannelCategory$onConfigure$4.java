package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemCategory $item;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelCategory this$0;

    public WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$4(WidgetChannelsListAdapter.ItemChannelCategory itemChannelCategory, ChannelListItemCategory channelListItemCategory) {
        this.this$0 = itemChannelCategory;
        this.$item = channelListItemCategory;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.INSTANCE.show(outline.x(this.this$0.itemView, "itemView", "itemView.context"), this.$item.getChannel().getGuildId(), 0, Long.valueOf(this.$item.getChannel().getId()));
    }
}
