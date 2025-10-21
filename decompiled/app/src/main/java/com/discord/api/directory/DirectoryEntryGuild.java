package com.discord.api.directory;

import b.d.b.a.outline;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: DirectoryEntryGuild.kt */
/* loaded from: classes.dex */
public final /* data */ class DirectoryEntryGuild {
    private final long authorId;
    private final UtcDateTime createdAt;
    private final String description;
    private final long directoryChannelId;
    private final long entityId;
    private final GuildPreview guild;
    private final int primaryCategoryId;

    /* renamed from: a, reason: from getter */
    public final UtcDateTime getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* renamed from: d, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: e, reason: from getter */
    public final GuildPreview getGuild() {
        return this.guild;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryGuild)) {
            return false;
        }
        DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) other;
        return this.directoryChannelId == directoryEntryGuild.directoryChannelId && this.entityId == directoryEntryGuild.entityId && this.authorId == directoryEntryGuild.authorId && Intrinsics3.areEqual(this.description, directoryEntryGuild.description) && this.primaryCategoryId == directoryEntryGuild.primaryCategoryId && Intrinsics3.areEqual(this.guild, directoryEntryGuild.guild) && Intrinsics3.areEqual(this.createdAt, directoryEntryGuild.createdAt);
    }

    /* renamed from: f, reason: from getter */
    public final int getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public int hashCode() {
        long j = this.directoryChannelId;
        long j2 = this.entityId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.authorId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.description;
        int iHashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.primaryCategoryId) * 31;
        GuildPreview guildPreview = this.guild;
        int iHashCode2 = (iHashCode + (guildPreview != null ? guildPreview.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.createdAt;
        return iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DirectoryEntryGuild(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(")");
        return sbU.toString();
    }
}
