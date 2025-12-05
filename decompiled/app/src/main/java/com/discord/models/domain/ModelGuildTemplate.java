package com.discord.models.domain;

import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelGuildTemplate.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelGuildTemplate {
    private final String code;
    private final String createdAt;
    private final User creator;
    private final long creatorId;
    private final String description;
    private final String name;
    private final Guild serializedSourceGuild;
    private final long sourceGuildId;
    private final String updatedAt;
    private final int usageCount;

    public ModelGuildTemplate(long j, User user, long j2, Guild guild, String str, String str2, int i, String str3, String str4, String str5) {
        Intrinsics3.checkNotNullParameter(str, "createdAt");
        Intrinsics3.checkNotNullParameter(str2, "updatedAt");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str5, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.creatorId = j;
        this.creator = user;
        this.sourceGuildId = j2;
        this.serializedSourceGuild = guild;
        this.createdAt = str;
        this.updatedAt = str2;
        this.usageCount = i;
        this.code = str3;
        this.name = str4;
        this.description = str5;
    }

    public static /* synthetic */ ModelGuildTemplate copy$default(ModelGuildTemplate modelGuildTemplate, long j, User user, long j2, Guild guild, String str, String str2, int i, String str3, String str4, String str5, int i2, Object obj) {
        return modelGuildTemplate.copy((i2 & 1) != 0 ? modelGuildTemplate.creatorId : j, (i2 & 2) != 0 ? modelGuildTemplate.creator : user, (i2 & 4) != 0 ? modelGuildTemplate.sourceGuildId : j2, (i2 & 8) != 0 ? modelGuildTemplate.serializedSourceGuild : guild, (i2 & 16) != 0 ? modelGuildTemplate.createdAt : str, (i2 & 32) != 0 ? modelGuildTemplate.updatedAt : str2, (i2 & 64) != 0 ? modelGuildTemplate.usageCount : i, (i2 & 128) != 0 ? modelGuildTemplate.code : str3, (i2 & 256) != 0 ? modelGuildTemplate.name : str4, (i2 & 512) != 0 ? modelGuildTemplate.description : str5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreatorId() {
        return this.creatorId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final User getCreator() {
        return this.creator;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    /* renamed from: component4, reason: from getter */
    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component7, reason: from getter */
    public final int getUsageCount() {
        return this.usageCount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildTemplate copy(long creatorId, User creator, long sourceGuildId, Guild serializedSourceGuild, String createdAt, String updatedAt, int usageCount, String code, String name, String description) {
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics3.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new ModelGuildTemplate(creatorId, creator, sourceGuildId, serializedSourceGuild, createdAt, updatedAt, usageCount, code, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildTemplate)) {
            return false;
        }
        ModelGuildTemplate modelGuildTemplate = (ModelGuildTemplate) other;
        return this.creatorId == modelGuildTemplate.creatorId && Intrinsics3.areEqual(this.creator, modelGuildTemplate.creator) && this.sourceGuildId == modelGuildTemplate.sourceGuildId && Intrinsics3.areEqual(this.serializedSourceGuild, modelGuildTemplate.serializedSourceGuild) && Intrinsics3.areEqual(this.createdAt, modelGuildTemplate.createdAt) && Intrinsics3.areEqual(this.updatedAt, modelGuildTemplate.updatedAt) && this.usageCount == modelGuildTemplate.usageCount && Intrinsics3.areEqual(this.code, modelGuildTemplate.code) && Intrinsics3.areEqual(this.name, modelGuildTemplate.name) && Intrinsics3.areEqual(this.description, modelGuildTemplate.description);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final User getCreator() {
        return this.creator;
    }

    public final long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUsageCount() {
        return this.usageCount;
    }

    public int hashCode() {
        long j = this.creatorId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.creator;
        int iHashCode = user != null ? user.hashCode() : 0;
        long j2 = this.sourceGuildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Guild guild = this.serializedSourceGuild;
        int iHashCode2 = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
        String str = this.createdAt;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.updatedAt;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.usageCount) * 31;
        String str3 = this.code;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelGuildTemplate(creatorId=");
        sbM833U.append(this.creatorId);
        sbM833U.append(", creator=");
        sbM833U.append(this.creator);
        sbM833U.append(", sourceGuildId=");
        sbM833U.append(this.sourceGuildId);
        sbM833U.append(", serializedSourceGuild=");
        sbM833U.append(this.serializedSourceGuild);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", updatedAt=");
        sbM833U.append(this.updatedAt);
        sbM833U.append(", usageCount=");
        sbM833U.append(this.usageCount);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        return outline.m822J(sbM833U, this.description, ")");
    }
}
