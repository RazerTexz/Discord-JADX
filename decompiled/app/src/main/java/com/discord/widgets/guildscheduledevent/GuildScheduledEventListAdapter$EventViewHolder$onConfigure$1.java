package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;

/* compiled from: GuildScheduledEventListAdapter.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter$EventViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEventListItem.Event $item;
    public final /* synthetic */ GuildScheduledEventListAdapter.EventViewHolder this$0;

    public GuildScheduledEventListAdapter$EventViewHolder$onConfigure$1(GuildScheduledEventListAdapter.EventViewHolder eventViewHolder, GuildScheduledEventListItem.Event event) {
        this.this$0 = eventViewHolder;
        this.$item = event;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnCardClicked().invoke(this.$item);
    }
}
