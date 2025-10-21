package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;

/* compiled from: GuildListViewHolder.kt */
/* renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$PrivateChannelViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildListViewHolder7 implements View.OnClickListener {
    public final /* synthetic */ GuildListItem.PrivateChannelItem $data;
    public final /* synthetic */ GuildListViewHolder.PrivateChannelViewHolder this$0;

    public GuildListViewHolder7(GuildListViewHolder.PrivateChannelViewHolder privateChannelViewHolder, GuildListItem.PrivateChannelItem privateChannelItem) {
        this.this$0 = privateChannelViewHolder;
        this.$data = privateChannelItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder.PrivateChannelViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
