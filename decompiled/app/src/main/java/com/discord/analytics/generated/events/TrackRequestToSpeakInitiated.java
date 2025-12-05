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

/* compiled from: TrackRequestToSpeakInitiated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRequestToSpeakInitiated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence topic = null;
    private final Long requestToSpeakState = null;
    private final CharSequence mediaSessionId = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "request_to_speak_initiated";

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
        if (!(other instanceof TrackRequestToSpeakInitiated)) {
            return false;
        }
        TrackRequestToSpeakInitiated trackRequestToSpeakInitiated = (TrackRequestToSpeakInitiated) other;
        return Intrinsics3.areEqual(this.topic, trackRequestToSpeakInitiated.topic) && Intrinsics3.areEqual(this.requestToSpeakState, trackRequestToSpeakInitiated.requestToSpeakState) && Intrinsics3.areEqual(this.mediaSessionId, trackRequestToSpeakInitiated.mediaSessionId) && Intrinsics3.areEqual(this.stageInstanceId, trackRequestToSpeakInitiated.stageInstanceId);
    }

    public int hashCode() {
        CharSequence charSequence = this.topic;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.requestToSpeakState;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.stageInstanceId;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackRequestToSpeakInitiated(topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", requestToSpeakState=");
        sbM833U.append(this.requestToSpeakState);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", stageInstanceId=");
        return outline.m819G(sbM833U, this.stageInstanceId, ")");
    }
}
