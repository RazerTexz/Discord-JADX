package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;

/* compiled from: GuildListViewHolder.kt */
/* renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$FolderViewHolder$configure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildListViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ GuildListItem.FolderItem $data;
    public final /* synthetic */ GuildListViewHolder.FolderViewHolder this$0;

    public GuildListViewHolder2(GuildListViewHolder.FolderViewHolder folderViewHolder, GuildListItem.FolderItem folderItem) {
        this.this$0 = folderViewHolder;
        this.$data = folderItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildListViewHolder.FolderViewHolder.access$getOnClicked$p(this.this$0).invoke(this.$data);
    }
}
