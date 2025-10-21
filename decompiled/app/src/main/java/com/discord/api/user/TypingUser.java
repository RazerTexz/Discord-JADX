package com.discord.api.user;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.Intrinsics3;

/* compiled from: TypingUser.kt */
/* loaded from: classes.dex */
public final /* data */ class TypingUser {
    private final long channelId;
    private final long guildId;
    private final GuildMember member;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* renamed from: d, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypingUser)) {
            return false;
        }
        TypingUser typingUser = (TypingUser) other;
        return this.userId == typingUser.userId && this.guildId == typingUser.guildId && this.channelId == typingUser.channelId && Intrinsics3.areEqual(this.member, typingUser.member);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.channelId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        GuildMember guildMember = this.member;
        return i2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TypingUser(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }
}
