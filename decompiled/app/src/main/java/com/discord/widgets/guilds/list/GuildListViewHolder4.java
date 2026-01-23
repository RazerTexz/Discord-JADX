package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$FriendsViewHolder$configure$1, reason: use source file name */
/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder4 implements View.OnClickListener {
    public final /* synthetic */ GuildListItem.FriendsItem $data;
    public final /* synthetic */ GuildListViewHolder.FriendsViewHolder this$0;

    public GuildListViewHolder4(GuildListViewHolder.FriendsViewHolder friendsViewHolder, GuildListItem.FriendsItem friendsItem) {
        this.this$0 = friendsViewHolder;
        this.$data = friendsItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder.FriendsViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
