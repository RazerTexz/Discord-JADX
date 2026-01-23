package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$5, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter6 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEventListItem.Event $item;
    public final /* synthetic */ GuildScheduledEventListAdapter.EventViewHolder this$0;

    public GuildScheduledEventListAdapter6(GuildScheduledEventListAdapter.EventViewHolder eventViewHolder, GuildScheduledEventListItem.Event event) {
        this.this$0 = eventViewHolder;
        this.$item = event;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnJoinClicked().invoke(this.$item);
    }
}
