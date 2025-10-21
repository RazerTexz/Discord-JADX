package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;

/* compiled from: GuildScheduledEventListAdapter.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter3 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEventListItem.Event $item;
    public final /* synthetic */ GuildScheduledEventListAdapter.EventViewHolder this$0;

    public GuildScheduledEventListAdapter3(GuildScheduledEventListAdapter.EventViewHolder eventViewHolder, GuildScheduledEventListItem.Event event) {
        this.this$0 = eventViewHolder;
        this.$item = event;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnRsvpClicked().invoke(this.$item);
    }
}
