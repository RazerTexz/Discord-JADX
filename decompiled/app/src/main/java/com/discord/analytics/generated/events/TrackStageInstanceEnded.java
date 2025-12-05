package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackStageInstanceEnded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStageInstanceEnded implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long stageInstanceId = null;
    private final CharSequence topic = null;
    private final Long privacyLevel = null;
    private final Long updaterId = null;
    private final Long guildScheduledEventId = null;
    private final Long totalUniqueListeners = null;
    private final Long maxConcurrentListeners = null;
    private final Long totalUniqueSpeakers = null;
    private final Long maxConcurrentSpeakers = null;
    private final Long numParticipants = null;
    private final transient String analyticsSchemaTypeName = "stage_instance_ended";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackStageInstanceEnded)) {
            return false;
        }
        TrackStageInstanceEnded trackStageInstanceEnded = (TrackStageInstanceEnded) other;
        return Intrinsics3.areEqual(this.stageInstanceId, trackStageInstanceEnded.stageInstanceId) && Intrinsics3.areEqual(this.topic, trackStageInstanceEnded.topic) && Intrinsics3.areEqual(this.privacyLevel, trackStageInstanceEnded.privacyLevel) && Intrinsics3.areEqual(this.updaterId, trackStageInstanceEnded.updaterId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackStageInstanceEnded.guildScheduledEventId) && Intrinsics3.areEqual(this.totalUniqueListeners, trackStageInstanceEnded.totalUniqueListeners) && Intrinsics3.areEqual(this.maxConcurrentListeners, trackStageInstanceEnded.maxConcurrentListeners) && Intrinsics3.areEqual(this.totalUniqueSpeakers, trackStageInstanceEnded.totalUniqueSpeakers) && Intrinsics3.areEqual(this.maxConcurrentSpeakers, trackStageInstanceEnded.maxConcurrentSpeakers) && Intrinsics3.areEqual(this.numParticipants, trackStageInstanceEnded.numParticipants);
    }

    public int hashCode() {
        Long l = this.stageInstanceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.topic;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.privacyLevel;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.updaterId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildScheduledEventId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalUniqueListeners;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.maxConcurrentListeners;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.totalUniqueSpeakers;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.maxConcurrentSpeakers;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numParticipants;
        return iHashCode9 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStageInstanceEnded(stageInstanceId=");
        sbM833U.append(this.stageInstanceId);
        sbM833U.append(", topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", privacyLevel=");
        sbM833U.append(this.privacyLevel);
        sbM833U.append(", updaterId=");
        sbM833U.append(this.updaterId);
        sbM833U.append(", guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", totalUniqueListeners=");
        sbM833U.append(this.totalUniqueListeners);
        sbM833U.append(", maxConcurrentListeners=");
        sbM833U.append(this.maxConcurrentListeners);
        sbM833U.append(", totalUniqueSpeakers=");
        sbM833U.append(this.totalUniqueSpeakers);
        sbM833U.append(", maxConcurrentSpeakers=");
        sbM833U.append(this.maxConcurrentSpeakers);
        sbM833U.append(", numParticipants=");
        return outline.m819G(sbM833U, this.numParticipants, ")");
    }
}
