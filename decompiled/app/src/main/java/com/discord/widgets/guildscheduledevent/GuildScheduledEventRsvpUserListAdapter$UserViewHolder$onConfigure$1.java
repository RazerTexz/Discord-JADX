package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;

/* compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEventRsvpUserListItem.RsvpUser $item;
    public final /* synthetic */ GuildScheduledEventRsvpUserListAdapter.UserViewHolder this$0;

    public GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1(GuildScheduledEventRsvpUserListAdapter.UserViewHolder userViewHolder, GuildScheduledEventRsvpUserListItem.RsvpUser rsvpUser) {
        this.this$0 = userViewHolder;
        this.$item = rsvpUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventRsvpUserListAdapter.access$getOnItemClick$p(GuildScheduledEventRsvpUserListAdapter.this).invoke(Long.valueOf(this.$item.getUserId()));
    }
}
