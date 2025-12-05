package com.discord.api.guildscheduledevent;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApiGuildScheduledEventUser.kt */
/* renamed from: com.discord.api.guildscheduledevent.ApiGuildScheduledEventUserGuildMember, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUser2 {
    private final String avatar;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;

    /* renamed from: a */
    public final GuildMember m7970a(User user, long guildId) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new GuildMember(guildId, user, this.roles, this.nick, this.premiumSince, this.joinedAt, this.pending, null, Long.valueOf(user.getId()), this.avatar, null, null, null, 4096);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiGuildScheduledEventUser2)) {
            return false;
        }
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2 = (ApiGuildScheduledEventUser2) other;
        return Intrinsics3.areEqual(this.roles, apiGuildScheduledEventUser2.roles) && Intrinsics3.areEqual(this.nick, apiGuildScheduledEventUser2.nick) && Intrinsics3.areEqual(this.premiumSince, apiGuildScheduledEventUser2.premiumSince) && Intrinsics3.areEqual(this.joinedAt, apiGuildScheduledEventUser2.joinedAt) && this.pending == apiGuildScheduledEventUser2.pending && Intrinsics3.areEqual(this.avatar, apiGuildScheduledEventUser2.avatar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iHashCode4 = (iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        String str3 = this.avatar;
        return i2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApiGuildScheduledEventUserGuildMember(roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", nick=");
        sbM833U.append(this.nick);
        sbM833U.append(", premiumSince=");
        sbM833U.append(this.premiumSince);
        sbM833U.append(", joinedAt=");
        sbM833U.append(this.joinedAt);
        sbM833U.append(", pending=");
        sbM833U.append(this.pending);
        sbM833U.append(", avatar=");
        return outline.m822J(sbM833U, this.avatar, ")");
    }
}
