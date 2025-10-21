package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;

/* compiled from: GuildScheduledEventMeUser.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventMeUser {
    private final GuildScheduledEvent guildScheduledEvent;
    private final long guildScheduledEventId;
    private final User user;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventMeUser)) {
            return false;
        }
        GuildScheduledEventMeUser guildScheduledEventMeUser = (GuildScheduledEventMeUser) other;
        return this.userId == guildScheduledEventMeUser.userId && this.guildScheduledEventId == guildScheduledEventMeUser.guildScheduledEventId && Intrinsics3.areEqual(this.user, guildScheduledEventMeUser.user) && Intrinsics3.areEqual(this.guildScheduledEvent, guildScheduledEventMeUser.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.guildScheduledEventId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventMeUser(userId=");
        sbU.append(this.userId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
