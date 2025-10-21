package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;

/* compiled from: GuildScheduledEventUserUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventUserUpdate {
    private final long guildId;
    private final long guildScheduledEventId;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* renamed from: b, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventUserUpdate)) {
            return false;
        }
        GuildScheduledEventUserUpdate guildScheduledEventUserUpdate = (GuildScheduledEventUserUpdate) other;
        return this.guildScheduledEventId == guildScheduledEventUserUpdate.guildScheduledEventId && this.guildId == guildScheduledEventUserUpdate.guildId && this.userId == guildScheduledEventUserUpdate.userId;
    }

    public int hashCode() {
        long j = this.guildScheduledEventId;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        return i + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventUserUpdate(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return outline.C(sbU, this.userId, ")");
    }
}
