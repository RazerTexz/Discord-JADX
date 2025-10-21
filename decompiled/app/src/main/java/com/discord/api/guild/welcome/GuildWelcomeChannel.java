package com.discord.api.guild.welcome;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: GuildWelcomeChannel.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildWelcomeChannel {
    private final long channelId;
    private final String description;
    private final Long emojiId;
    private final String emojiName;

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: d, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeChannel)) {
            return false;
        }
        GuildWelcomeChannel guildWelcomeChannel = (GuildWelcomeChannel) other;
        return this.channelId == guildWelcomeChannel.channelId && Intrinsics3.areEqual(this.description, guildWelcomeChannel.description) && Intrinsics3.areEqual(this.emojiId, guildWelcomeChannel.emojiId) && Intrinsics3.areEqual(this.emojiName, guildWelcomeChannel.emojiName);
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.description;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildWelcomeChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        return outline.J(sbU, this.emojiName, ")");
    }
}
