package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackGuildScheduledEvent;
import com.discord.analytics.generated.traits.TrackGuildScheduledEvent2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackGuildScheduledEventEnded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventEnded implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackGuildScheduledEvent2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackGuildScheduledEvent trackGuildScheduledEvent;
    private final Long guildScheduledEventId = null;
    private final CharSequence name = null;
    private final Long startTime = null;
    private final Long endTime = null;
    private final List<Long> skuIds = null;
    private final Long guildScheduledEventStatus = null;
    private final Long privacyLevel = null;
    private final Long guildScheduledEventEntityType = null;
    private final CharSequence guildScheduledEventExternalLocation = null;
    private final Long guildScheduledEventInterestedCount = null;
    private final CharSequence description = null;
    private final Long updaterId = null;
    private final Long numParticipants = null;
    private final Long totalUniqueListeners = null;
    private final Long maxConcurrentListeners = null;
    private final Long totalUniqueSpeakers = null;
    private final Long maxConcurrentSpeakers = null;
    private final Long totalUniqueParticipants = null;
    private final Long maxConcurrentParticipants = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_ended";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEventEnded)) {
            return false;
        }
        TrackGuildScheduledEventEnded trackGuildScheduledEventEnded = (TrackGuildScheduledEventEnded) other;
        return Intrinsics3.areEqual(this.guildScheduledEventId, trackGuildScheduledEventEnded.guildScheduledEventId) && Intrinsics3.areEqual(this.name, trackGuildScheduledEventEnded.name) && Intrinsics3.areEqual(this.startTime, trackGuildScheduledEventEnded.startTime) && Intrinsics3.areEqual(this.endTime, trackGuildScheduledEventEnded.endTime) && Intrinsics3.areEqual(this.skuIds, trackGuildScheduledEventEnded.skuIds) && Intrinsics3.areEqual(this.guildScheduledEventStatus, trackGuildScheduledEventEnded.guildScheduledEventStatus) && Intrinsics3.areEqual(this.privacyLevel, trackGuildScheduledEventEnded.privacyLevel) && Intrinsics3.areEqual(this.guildScheduledEventEntityType, trackGuildScheduledEventEnded.guildScheduledEventEntityType) && Intrinsics3.areEqual(this.guildScheduledEventExternalLocation, trackGuildScheduledEventEnded.guildScheduledEventExternalLocation) && Intrinsics3.areEqual(this.guildScheduledEventInterestedCount, trackGuildScheduledEventEnded.guildScheduledEventInterestedCount) && Intrinsics3.areEqual(this.description, trackGuildScheduledEventEnded.description) && Intrinsics3.areEqual(this.updaterId, trackGuildScheduledEventEnded.updaterId) && Intrinsics3.areEqual(this.numParticipants, trackGuildScheduledEventEnded.numParticipants) && Intrinsics3.areEqual(this.totalUniqueListeners, trackGuildScheduledEventEnded.totalUniqueListeners) && Intrinsics3.areEqual(this.maxConcurrentListeners, trackGuildScheduledEventEnded.maxConcurrentListeners) && Intrinsics3.areEqual(this.totalUniqueSpeakers, trackGuildScheduledEventEnded.totalUniqueSpeakers) && Intrinsics3.areEqual(this.maxConcurrentSpeakers, trackGuildScheduledEventEnded.maxConcurrentSpeakers) && Intrinsics3.areEqual(this.totalUniqueParticipants, trackGuildScheduledEventEnded.totalUniqueParticipants) && Intrinsics3.areEqual(this.maxConcurrentParticipants, trackGuildScheduledEventEnded.maxConcurrentParticipants);
    }

    public int hashCode() {
        Long l = this.guildScheduledEventId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.name;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.startTime;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.endTime;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.skuIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.guildScheduledEventStatus;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.privacyLevel;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildScheduledEventEntityType;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildScheduledEventExternalLocation;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.guildScheduledEventInterestedCount;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.description;
        int iHashCode11 = (iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.updaterId;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numParticipants;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.totalUniqueListeners;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.maxConcurrentListeners;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.totalUniqueSpeakers;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.maxConcurrentSpeakers;
        int iHashCode17 = (iHashCode16 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.totalUniqueParticipants;
        int iHashCode18 = (iHashCode17 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.maxConcurrentParticipants;
        return iHashCode18 + (l15 != null ? l15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildScheduledEventEnded(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", startTime=");
        sbU.append(this.startTime);
        sbU.append(", endTime=");
        sbU.append(this.endTime);
        sbU.append(", skuIds=");
        sbU.append(this.skuIds);
        sbU.append(", guildScheduledEventStatus=");
        sbU.append(this.guildScheduledEventStatus);
        sbU.append(", privacyLevel=");
        sbU.append(this.privacyLevel);
        sbU.append(", guildScheduledEventEntityType=");
        sbU.append(this.guildScheduledEventEntityType);
        sbU.append(", guildScheduledEventExternalLocation=");
        sbU.append(this.guildScheduledEventExternalLocation);
        sbU.append(", guildScheduledEventInterestedCount=");
        sbU.append(this.guildScheduledEventInterestedCount);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", updaterId=");
        sbU.append(this.updaterId);
        sbU.append(", numParticipants=");
        sbU.append(this.numParticipants);
        sbU.append(", totalUniqueListeners=");
        sbU.append(this.totalUniqueListeners);
        sbU.append(", maxConcurrentListeners=");
        sbU.append(this.maxConcurrentListeners);
        sbU.append(", totalUniqueSpeakers=");
        sbU.append(this.totalUniqueSpeakers);
        sbU.append(", maxConcurrentSpeakers=");
        sbU.append(this.maxConcurrentSpeakers);
        sbU.append(", totalUniqueParticipants=");
        sbU.append(this.totalUniqueParticipants);
        sbU.append(", maxConcurrentParticipants=");
        return outline.G(sbU, this.maxConcurrentParticipants, ")");
    }
}
