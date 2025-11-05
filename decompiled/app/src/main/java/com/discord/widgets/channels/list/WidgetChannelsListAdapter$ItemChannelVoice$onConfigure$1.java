package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ boolean $isGuildRoleSubscriptionLockedChannel;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelVoice this$0;

    public WidgetChannelsListAdapter$ItemChannelVoice$onConfigure$1(WidgetChannelsListAdapter.ItemChannelVoice itemChannelVoice, boolean z2, ChannelListItem channelListItem) {
        this.this$0 = itemChannelVoice;
        this.$isGuildRoleSubscriptionLockedChannel = z2;
        this.$data = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$isGuildRoleSubscriptionLockedChannel) {
            WidgetChannelsListAdapter.ItemChannelVoice.access$getAdapter$p(this.this$0).getOnSelectGuildRoleSubscriptionLockedChannel().invoke(((ChannelListItemVoiceChannel) this.$data).getChannel());
        } else {
            WidgetChannelsListAdapter.ItemChannelVoice.access$getAdapter$p(this.this$0).getOnCallChannel().invoke(((ChannelListItemVoiceChannel) this.$data).getChannel());
        }
    }
}
