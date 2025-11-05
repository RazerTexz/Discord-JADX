package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel5 extends Lambda implements Function1<GuildScheduledEventUser, GuildScheduledEventRsvpUserListItem.RsvpUser> {
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel5(GuildScheduledEvent guildScheduledEvent) {
        super(1);
        this.$guildScheduledEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildScheduledEventRsvpUserListItem.RsvpUser invoke(GuildScheduledEventUser guildScheduledEventUser) {
        return invoke2(guildScheduledEventUser);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventRsvpUserListItem.RsvpUser invoke2(GuildScheduledEventUser guildScheduledEventUser) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
        return GuildScheduledEventRsvpUserListItem.RsvpUser.INSTANCE.from(guildScheduledEventUser, this.$guildScheduledEvent.getGuildId());
    }
}
