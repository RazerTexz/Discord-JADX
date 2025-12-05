package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemInvite$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemInvite this$0;

    public WidgetChannelsListAdapter$ItemInvite$onConfigure$1(WidgetChannelsListAdapter.ItemInvite itemInvite, ChannelListItem channelListItem) {
        this.this$0 = itemInvite;
        this.$data = channelListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion.launch$default(WidgetGuildInviteShare.INSTANCE, outline.m885x(view, "it", "it.context"), WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter.ItemInvite.access$getAdapter$p(this.this$0)), ((ChannelListItemInvite) this.$data).getGuildId(), null, false, null, null, "Directory", 120, null);
    }
}
