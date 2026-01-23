package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$GuildViewHolder$configure$1, reason: use source file name */
/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder5 implements View.OnClickListener {
    public final /* synthetic */ GuildListItem.GuildItem $data;
    public final /* synthetic */ GuildListViewHolder.GuildViewHolder this$0;

    public GuildListViewHolder5(GuildListViewHolder.GuildViewHolder guildViewHolder, GuildListItem.GuildItem guildItem) {
        this.this$0 = guildViewHolder;
        this.$data = guildItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder.GuildViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
