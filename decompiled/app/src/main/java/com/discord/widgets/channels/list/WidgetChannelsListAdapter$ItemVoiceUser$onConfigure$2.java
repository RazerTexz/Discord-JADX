package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemVoiceUser this$0;

    public WidgetChannelsListAdapter$ItemVoiceUser$onConfigure$2(WidgetChannelsListAdapter.ItemVoiceUser itemVoiceUser, ChannelListItem channelListItem) {
        this.this$0 = itemVoiceUser;
        this.$data = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemVoiceUser.access$getAdapter$p(this.this$0).getOnCallChannel().invoke(((ChannelListItemVoiceUser) this.$data).getChannel());
    }
}
