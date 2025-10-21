package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;

/* compiled from: GuildMemberRemove.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildMemberRemove {
    private final long guildId;
    private final User user;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberRemove)) {
            return false;
        }
        GuildMemberRemove guildMemberRemove = (GuildMemberRemove) other;
        return this.guildId == guildMemberRemove.guildId && Intrinsics3.areEqual(this.user, guildMemberRemove.user);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMemberRemove(guildId=");
        sbU.append(this.guildId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
