package com.discord.api.guildscheduledevent;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEventBroadcast.kt */
/* renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventBroadcastBody, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventBroadcast2 {
    private final Long entityId;
    private final int type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventBroadcast2)) {
            return false;
        }
        GuildScheduledEventBroadcast2 guildScheduledEventBroadcast2 = (GuildScheduledEventBroadcast2) other;
        return this.type == guildScheduledEventBroadcast2.type && Intrinsics3.areEqual(this.entityId, guildScheduledEventBroadcast2.entityId);
    }

    public int hashCode() {
        int i = this.type * 31;
        Long l = this.entityId;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildScheduledEventBroadcastBody(type=");
        sbM833U.append(this.type);
        sbM833U.append(", entityId=");
        return outline.m819G(sbM833U, this.entityId, ")");
    }
}
