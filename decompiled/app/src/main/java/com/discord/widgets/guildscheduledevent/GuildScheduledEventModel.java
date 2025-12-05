package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.time.TimeUtils;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEventModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventModel implements Serializable {
    private final Boolean broadcastToDirectoryChannels;
    private final Long channelId;
    private final Long creatorId;
    private final String description;
    private final GuildScheduledEventPickerDateTime2 endDate;
    private final GuildScheduledEventPickerDateTime3 endTime;
    private final GuildScheduledEventEntityMetadata entityMetadata;
    private final GuildScheduledEventEntityType entityType;
    private final long guildId;
    private final String name;
    private final GuildScheduledEventPickerDateTime2 startDate;
    private final GuildScheduledEventPickerDateTime3 startTime;
    private final Integer userCount;

    public GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime2, "startDate");
        Intrinsics3.checkNotNullParameter(guildScheduledEventPickerDateTime3, "startTime");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        this.guildId = j;
        this.name = str;
        this.channelId = l;
        this.creatorId = l2;
        this.startDate = guildScheduledEventPickerDateTime2;
        this.startTime = guildScheduledEventPickerDateTime3;
        this.endDate = guildScheduledEventPickerDateTime22;
        this.endTime = guildScheduledEventPickerDateTime32;
        this.description = str2;
        this.entityType = guildScheduledEventEntityType;
        this.entityMetadata = guildScheduledEventEntityMetadata;
        this.userCount = num;
        this.broadcastToDirectoryChannels = bool;
    }

    public static /* synthetic */ GuildScheduledEventModel copy$default(GuildScheduledEventModel guildScheduledEventModel, long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, Object obj) {
        return guildScheduledEventModel.copy((i & 1) != 0 ? guildScheduledEventModel.guildId : j, (i & 2) != 0 ? guildScheduledEventModel.name : str, (i & 4) != 0 ? guildScheduledEventModel.channelId : l, (i & 8) != 0 ? guildScheduledEventModel.creatorId : l2, (i & 16) != 0 ? guildScheduledEventModel.startDate : guildScheduledEventPickerDateTime2, (i & 32) != 0 ? guildScheduledEventModel.startTime : guildScheduledEventPickerDateTime3, (i & 64) != 0 ? guildScheduledEventModel.endDate : guildScheduledEventPickerDateTime22, (i & 128) != 0 ? guildScheduledEventModel.endTime : guildScheduledEventPickerDateTime32, (i & 256) != 0 ? guildScheduledEventModel.description : str2, (i & 512) != 0 ? guildScheduledEventModel.entityType : guildScheduledEventEntityType, (i & 1024) != 0 ? guildScheduledEventModel.entityMetadata : guildScheduledEventEntityMetadata, (i & 2048) != 0 ? guildScheduledEventModel.userCount : num, (i & 4096) != 0 ? guildScheduledEventModel.broadcastToDirectoryChannels : bool);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component10, reason: from getter */
    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getUserCount() {
        return this.userCount;
    }

    /* renamed from: component13, reason: from getter */
    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getCreatorId() {
        return this.creatorId;
    }

    /* renamed from: component5, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    /* renamed from: component6, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    /* renamed from: component7, reason: from getter */
    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    /* renamed from: component8, reason: from getter */
    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventModel copy(long guildId, String name, Long channelId, Long creatorId, GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime, GuildScheduledEventPickerDateTime2 endDate, GuildScheduledEventPickerDateTime3 endTime, String description, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Integer userCount, Boolean broadcastToDirectoryChannels) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        Intrinsics3.checkNotNullParameter(entityType, "entityType");
        return new GuildScheduledEventModel(guildId, name, channelId, creatorId, startDate, startTime, endDate, endTime, description, entityType, entityMetadata, userCount, broadcastToDirectoryChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventModel)) {
            return false;
        }
        GuildScheduledEventModel guildScheduledEventModel = (GuildScheduledEventModel) other;
        return this.guildId == guildScheduledEventModel.guildId && Intrinsics3.areEqual(this.name, guildScheduledEventModel.name) && Intrinsics3.areEqual(this.channelId, guildScheduledEventModel.channelId) && Intrinsics3.areEqual(this.creatorId, guildScheduledEventModel.creatorId) && Intrinsics3.areEqual(this.startDate, guildScheduledEventModel.startDate) && Intrinsics3.areEqual(this.startTime, guildScheduledEventModel.startTime) && Intrinsics3.areEqual(this.endDate, guildScheduledEventModel.endDate) && Intrinsics3.areEqual(this.endTime, guildScheduledEventModel.endTime) && Intrinsics3.areEqual(this.description, guildScheduledEventModel.description) && Intrinsics3.areEqual(this.entityType, guildScheduledEventModel.entityType) && Intrinsics3.areEqual(this.entityMetadata, guildScheduledEventModel.entityMetadata) && Intrinsics3.areEqual(this.userCount, guildScheduledEventModel.userCount) && Intrinsics3.areEqual(this.broadcastToDirectoryChannels, guildScheduledEventModel.broadcastToDirectoryChannels);
    }

    public final Boolean getBroadcastToDirectoryChannels() {
        return this.broadcastToDirectoryChannels;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildScheduledEventPickerDateTime2 getEndDate() {
        return this.endDate;
    }

    public final GuildScheduledEventPickerDateTime3 getEndTime() {
        return this.endTime;
    }

    public final GuildScheduledEventEntityMetadata getEntityMetadata() {
        return this.entityMetadata;
    }

    public final GuildScheduledEventEntityType getEntityType() {
        return this.entityType;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final GuildScheduledEventPickerDateTime2 getStartDate() {
        return this.startDate;
    }

    public final GuildScheduledEventPickerDateTime3 getStartTime() {
        return this.startTime;
    }

    public final Integer getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        int iM3a = C0002b.m3a(this.guildId) * 31;
        String str = this.name;
        int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.creatorId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.startDate;
        int iHashCode4 = (iHashCode3 + (guildScheduledEventPickerDateTime2 != null ? guildScheduledEventPickerDateTime2.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3 = this.startTime;
        int iHashCode5 = (iHashCode4 + (guildScheduledEventPickerDateTime3 != null ? guildScheduledEventPickerDateTime3.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22 = this.endDate;
        int iHashCode6 = (iHashCode5 + (guildScheduledEventPickerDateTime22 != null ? guildScheduledEventPickerDateTime22.hashCode() : 0)) * 31;
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32 = this.endTime;
        int iHashCode7 = (iHashCode6 + (guildScheduledEventPickerDateTime32 != null ? guildScheduledEventPickerDateTime32.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode8 = (iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
        int iHashCode9 = (iHashCode8 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        int iHashCode10 = (iHashCode9 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
        Integer num = this.userCount;
        int iHashCode11 = (iHashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.broadcastToDirectoryChannels;
        return iHashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public final RestAPIParams.CreateGuildScheduledEventBody toCreateRequestBody() {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        String str = this.name;
        String utcDateString = null;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        String utcDateString2 = guildScheduledEventPickerDateTime.toUtcDateString(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        if (guildScheduledEventPickerDateTime2 != null && (guildScheduledEventPickerDateTime3 = this.endTime) != null) {
            utcDateString = guildScheduledEventPickerDateTime.toUtcDateString(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3);
        }
        return new RestAPIParams.CreateGuildScheduledEventBody(str, this.description, StageInstancePrivacyLevel.GUILD_ONLY, utcDateString2, utcDateString, this.channelId, this.entityType, this.entityMetadata, this.broadcastToDirectoryChannels);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildScheduledEventModel(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", creatorId=");
        sbM833U.append(this.creatorId);
        sbM833U.append(", startDate=");
        sbM833U.append(this.startDate);
        sbM833U.append(", startTime=");
        sbM833U.append(this.startTime);
        sbM833U.append(", endDate=");
        sbM833U.append(this.endDate);
        sbM833U.append(", endTime=");
        sbM833U.append(this.endTime);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", entityMetadata=");
        sbM833U.append(this.entityMetadata);
        sbM833U.append(", userCount=");
        sbM833U.append(this.userCount);
        sbM833U.append(", broadcastToDirectoryChannels=");
        return outline.m816D(sbM833U, this.broadcastToDirectoryChannels, ")");
    }

    public final RestAPIParams.UpdateGuildScheduledEventBody toUpdateRequestBody(GuildScheduledEvent currentEvent) {
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3;
        Intrinsics3.checkNotNullParameter(currentEvent, "currentEvent");
        String str = this.name;
        if (str == null) {
            return null;
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        long millis = guildScheduledEventPickerDateTime.toMillis(this.startDate, this.startTime);
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = this.endDate;
        Long lValueOf = (guildScheduledEventPickerDateTime2 == null || (guildScheduledEventPickerDateTime3 = this.endTime) == null) ? null : Long.valueOf(guildScheduledEventPickerDateTime.toMillis(guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3));
        Long l = this.channelId;
        NullSerializable c5566b = l != null ? new NullSerializable.C5566b(l) : new NullSerializable.C5565a(null, 1);
        GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
        NullSerializable c5565a = (guildScheduledEventEntityMetadata == null || guildScheduledEventEntityMetadata.m7991b()) ? new NullSerializable.C5565a(null, 1) : new NullSerializable.C5566b(this.entityMetadata);
        String str2 = this.description;
        StageInstancePrivacyLevel stageInstancePrivacyLevel = StageInstancePrivacyLevel.GUILD_ONLY;
        String uTCDateTime$default = currentEvent.getScheduledStartTime().getDateTimeMillis() == millis ? null : TimeUtils.toUTCDateTime$default(Long.valueOf(millis), null, 2, null);
        UtcDateTime scheduledEndTime = currentEvent.getScheduledEndTime();
        return new RestAPIParams.UpdateGuildScheduledEventBody(str, str2, stageInstancePrivacyLevel, uTCDateTime$default, Intrinsics3.areEqual(scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null, lValueOf) ? null : TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null), c5566b, this.entityType, c5565a, null, this.broadcastToDirectoryChannels, 256, null);
    }

    public /* synthetic */ GuildScheduledEventModel(long j, String str, Long l, Long l2, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime22, GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime32, String str2, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, l, l2, guildScheduledEventPickerDateTime2, guildScheduledEventPickerDateTime3, guildScheduledEventPickerDateTime22, guildScheduledEventPickerDateTime32, str2, guildScheduledEventEntityType, guildScheduledEventEntityMetadata, num, (i & 4096) != 0 ? null : bool);
    }
}
