package com.discord.api.directory;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DirectoryEntryGuild.kt */
/* renamed from: com.discord.api.directory.DirectoryEntryEvent, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class DirectoryEntryGuild2 {
    private final long authorId;
    private final UtcDateTime createdAt;
    private final String description;
    private final long directoryChannelId;
    private final long entityId;
    private final GuildScheduledEvent guildScheduledEvent;
    private final int primaryCategoryId;

    /* renamed from: a, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryGuild2)) {
            return false;
        }
        DirectoryEntryGuild2 directoryEntryGuild2 = (DirectoryEntryGuild2) other;
        return this.directoryChannelId == directoryEntryGuild2.directoryChannelId && this.entityId == directoryEntryGuild2.entityId && this.authorId == directoryEntryGuild2.authorId && Intrinsics3.areEqual(this.description, directoryEntryGuild2.description) && this.primaryCategoryId == directoryEntryGuild2.primaryCategoryId && Intrinsics3.areEqual(this.createdAt, directoryEntryGuild2.createdAt) && Intrinsics3.areEqual(this.guildScheduledEvent, directoryEntryGuild2.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.directoryChannelId;
        long j2 = this.entityId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.authorId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.description;
        int iHashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.primaryCategoryId) * 31;
        UtcDateTime utcDateTime = this.createdAt;
        int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DirectoryEntryEvent(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", entityId=");
        sbM833U.append(this.entityId);
        sbM833U.append(", authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", primaryCategoryId=");
        sbM833U.append(this.primaryCategoryId);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", guildScheduledEvent=");
        sbM833U.append(this.guildScheduledEvent);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
