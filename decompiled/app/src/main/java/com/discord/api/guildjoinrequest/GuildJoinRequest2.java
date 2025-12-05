package com.discord.api.guildjoinrequest;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildJoinRequest.kt */
/* renamed from: com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class GuildJoinRequest2 {
    private final long guildId;
    private final GuildJoinRequest request;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final GuildJoinRequest getRequest() {
        return this.request;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequest2)) {
            return false;
        }
        GuildJoinRequest2 guildJoinRequest2 = (GuildJoinRequest2) other;
        return this.guildId == guildJoinRequest2.guildId && Intrinsics3.areEqual(this.request, guildJoinRequest2.request);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildJoinRequest guildJoinRequest = this.request;
        return i + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildJoinRequestCreateOrUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", request=");
        sbM833U.append(this.request);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
