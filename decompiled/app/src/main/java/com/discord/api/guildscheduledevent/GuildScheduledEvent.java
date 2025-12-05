package com.discord.api.guildscheduledevent;

import com.discord.api.guild.Guild;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEvent.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEvent {
    private final Long channelId;
    private final Long creatorId;
    private final String description;
    private final Long entityId;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final Guild guild;
    private final long guildId;
    private final long id;
    private final String image;
    private final String name;
    private final StageInstancePrivacyLevel privacyLevel;
    private final UtcDateTime scheduledEndTime;
    private final UtcDateTime scheduledStartTime;
    private final List<Long> skuIds;
    private final GuildScheduledEventStatus status;
    private final Integer userCount;
    private final GuildScheduledEventMeUser userRsvp;

    public GuildScheduledEvent(long j, long j2, Long l, Long l2, String str, String str2, String str3, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, StageInstancePrivacyLevel stageInstancePrivacyLevel, GuildScheduledEventStatus guildScheduledEventStatus, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l3, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, List<Long> list, Integer num, GuildScheduledEventMeUser guildScheduledEventMeUser, Guild guild) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(utcDateTime, "scheduledStartTime");
        Intrinsics3.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
        Intrinsics3.checkNotNullParameter(guildScheduledEventStatus, "status");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        Intrinsics3.checkNotNullParameter(list, "skuIds");
        this.id = j;
        this.guildId = j2;
        this.channelId = l;
        this.creatorId = l2;
        this.name = str;
        this.description = str2;
        this.image = str3;
        this.scheduledStartTime = utcDateTime;
        this.scheduledEndTime = utcDateTime2;
        this.privacyLevel = stageInstancePrivacyLevel;
        this.status = guildScheduledEventStatus;
        this.entityType = guildScheduledEventEntityType;
        this.entityId = l3;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.skuIds = list;
        this.userCount = num;
        this.userRsvp = guildScheduledEventMeUser;
        this.guild = guild;
    }

    /* renamed from: a */
    public static GuildScheduledEvent m7972a(GuildScheduledEvent guildScheduledEvent, long j, long j2, Long l, Long l2, String str, String str2, String str3, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, StageInstancePrivacyLevel stageInstancePrivacyLevel, GuildScheduledEventStatus guildScheduledEventStatus, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l3, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, List list, Integer num, GuildScheduledEventMeUser guildScheduledEventMeUser, Guild guild, int i) {
        long j3 = (i & 1) != 0 ? guildScheduledEvent.id : j;
        long j4 = (i & 2) != 0 ? guildScheduledEvent.guildId : j2;
        Long l4 = (i & 4) != 0 ? guildScheduledEvent.channelId : null;
        Long l5 = (i & 8) != 0 ? guildScheduledEvent.creatorId : null;
        String str4 = (i & 16) != 0 ? guildScheduledEvent.name : null;
        String str5 = (i & 32) != 0 ? guildScheduledEvent.description : null;
        String str6 = (i & 64) != 0 ? guildScheduledEvent.image : null;
        UtcDateTime utcDateTime3 = (i & 128) != 0 ? guildScheduledEvent.scheduledStartTime : null;
        UtcDateTime utcDateTime4 = (i & 256) != 0 ? guildScheduledEvent.scheduledEndTime : null;
        StageInstancePrivacyLevel stageInstancePrivacyLevel2 = (i & 512) != 0 ? guildScheduledEvent.privacyLevel : null;
        GuildScheduledEventStatus guildScheduledEventStatus2 = (i & 1024) != 0 ? guildScheduledEvent.status : null;
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = (i & 2048) != 0 ? guildScheduledEvent.entityType : null;
        UtcDateTime utcDateTime5 = utcDateTime4;
        Long l6 = (i & 4096) != 0 ? guildScheduledEvent.entityId : null;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata2 = (i & 8192) != 0 ? guildScheduledEvent.entityMetadata : null;
        List<Long> list2 = (i & 16384) != 0 ? guildScheduledEvent.skuIds : null;
        String str7 = str6;
        Integer num2 = (i & 32768) != 0 ? guildScheduledEvent.userCount : num;
        GuildScheduledEventMeUser guildScheduledEventMeUser2 = (i & 65536) != 0 ? guildScheduledEvent.userRsvp : null;
        Guild guild2 = (i & 131072) != 0 ? guildScheduledEvent.guild : null;
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(utcDateTime3, "scheduledStartTime");
        Intrinsics3.checkNotNullParameter(stageInstancePrivacyLevel2, "privacyLevel");
        Intrinsics3.checkNotNullParameter(guildScheduledEventStatus2, "status");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType2, "entityType");
        Intrinsics3.checkNotNullParameter(list2, "skuIds");
        return new GuildScheduledEvent(j3, j4, l4, l5, str4, str5, str7, utcDateTime3, utcDateTime5, stageInstancePrivacyLevel2, guildScheduledEventStatus2, guildScheduledEventEntityType2, l6, guildScheduledEventEntityMetadata2, list2, num2, guildScheduledEventMeUser2, guild2);
    }

    /* renamed from: b, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: c, reason: from getter */
    public final Long getCreatorId() {
        return this.creatorId;
    }

    /* renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: e, reason: from getter */
    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEvent)) {
            return false;
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) other;
        return this.id == guildScheduledEvent.id && this.guildId == guildScheduledEvent.guildId && Intrinsics3.areEqual(this.channelId, guildScheduledEvent.channelId) && Intrinsics3.areEqual(this.creatorId, guildScheduledEvent.creatorId) && Intrinsics3.areEqual(this.name, guildScheduledEvent.name) && Intrinsics3.areEqual(this.description, guildScheduledEvent.description) && Intrinsics3.areEqual(this.image, guildScheduledEvent.image) && Intrinsics3.areEqual(this.scheduledStartTime, guildScheduledEvent.scheduledStartTime) && Intrinsics3.areEqual(this.scheduledEndTime, guildScheduledEvent.scheduledEndTime) && Intrinsics3.areEqual(this.privacyLevel, guildScheduledEvent.privacyLevel) && Intrinsics3.areEqual(this.status, guildScheduledEvent.status) && Intrinsics3.areEqual(this.entityType, guildScheduledEvent.entityType) && Intrinsics3.areEqual(this.entityId, guildScheduledEvent.entityId) && Intrinsics3.areEqual(this.entityMetadata, guildScheduledEvent.entityMetadata) && Intrinsics3.areEqual(this.skuIds, guildScheduledEvent.skuIds) && Intrinsics3.areEqual(this.userCount, guildScheduledEvent.userCount) && Intrinsics3.areEqual(this.userRsvp, guildScheduledEvent.userRsvp) && Intrinsics3.areEqual(this.guild, guildScheduledEvent.guild);
    }

    /* renamed from: f, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    /* renamed from: g, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: h, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.channelId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.creatorId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.scheduledStartTime;
        int iHashCode6 = (iHashCode5 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.scheduledEndTime;
        int iHashCode7 = (iHashCode6 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
        int iHashCode8 = (iHashCode7 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
        GuildScheduledEventStatus guildScheduledEventStatus = this.status;
        int iHashCode9 = (iHashCode8 + (guildScheduledEventStatus != null ? guildScheduledEventStatus.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode10 = (iHashCode9 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        Long l3 = this.entityId;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        int iHashCode12 = (iHashCode11 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
        List<Long> list = this.skuIds;
        int iHashCode13 = (iHashCode12 + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.userCount;
        int iHashCode14 = (iHashCode13 + (num != null ? num.hashCode() : 0)) * 31;
        GuildScheduledEventMeUser guildScheduledEventMeUser = this.userRsvp;
        int iHashCode15 = (iHashCode14 + (guildScheduledEventMeUser != null ? guildScheduledEventMeUser.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        return iHashCode15 + (guild != null ? guild.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: j, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: k, reason: from getter */
    public final UtcDateTime getScheduledEndTime() {
        return this.scheduledEndTime;
    }

    /* renamed from: l, reason: from getter */
    public final UtcDateTime getScheduledStartTime() {
        return this.scheduledStartTime;
    }

    /* renamed from: m, reason: from getter */
    public final GuildScheduledEventStatus getStatus() {
        return this.status;
    }

    /* renamed from: n, reason: from getter */
    public final Integer getUserCount() {
        return this.userCount;
    }

    /* renamed from: o, reason: from getter */
    public final GuildScheduledEventMeUser getUserRsvp() {
        return this.userRsvp;
    }

    /* renamed from: p */
    public final boolean m7987p(long channelId) {
        Long l = this.channelId;
        if (l == null) {
            return true;
        }
        return l != null && l.longValue() == channelId;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildScheduledEvent(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", creatorId=");
        sbM833U.append(this.creatorId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", image=");
        sbM833U.append(this.image);
        sbM833U.append(", scheduledStartTime=");
        sbM833U.append(this.scheduledStartTime);
        sbM833U.append(", scheduledEndTime=");
        sbM833U.append(this.scheduledEndTime);
        sbM833U.append(", privacyLevel=");
        sbM833U.append(this.privacyLevel);
        sbM833U.append(", status=");
        sbM833U.append(this.status);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", entityId=");
        sbM833U.append(this.entityId);
        sbM833U.append(", entityMetadata=");
        sbM833U.append(this.entityMetadata);
        sbM833U.append(", skuIds=");
        sbM833U.append(this.skuIds);
        sbM833U.append(", userCount=");
        sbM833U.append(this.userCount);
        sbM833U.append(", userRsvp=");
        sbM833U.append(this.userRsvp);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
