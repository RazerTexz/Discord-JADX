package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;

/* compiled from: WidgetChannelsListAdapter.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemChannelDirectory$onConfigure$$inlined$apply$lambda$1 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC7445xe91b54ea implements View.OnClickListener {
    public final /* synthetic */ ChannelListItemDirectory $item$inlined;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemChannelDirectory this$0;

    public ViewOnClickListenerC7445xe91b54ea(WidgetChannelsListAdapter.ItemChannelDirectory itemChannelDirectory, ChannelListItemDirectory channelListItemDirectory) {
        this.this$0 = itemChannelDirectory;
        this.$item$inlined = channelListItemDirectory;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelsListAdapter.ItemChannelDirectory.access$getAdapter$p(this.this$0).getOnSelectChannel().invoke(this.$item$inlined.getChannel());
    }
}
