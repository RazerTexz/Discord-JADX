package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackStageDiscoveryStageJoined.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryStageJoined implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final Long index = null;
    private final Long stageInstanceId = null;
    private final List<Long> recommendationSource = null;
    private final Float recommendationScore = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_stage_joined";

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
        if (!(other instanceof TrackStageDiscoveryStageJoined)) {
            return false;
        }
        TrackStageDiscoveryStageJoined trackStageDiscoveryStageJoined = (TrackStageDiscoveryStageJoined) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryStageJoined.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryStageJoined.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryStageJoined.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.index, trackStageDiscoveryStageJoined.index) && Intrinsics3.areEqual(this.stageInstanceId, trackStageDiscoveryStageJoined.stageInstanceId) && Intrinsics3.areEqual(this.recommendationSource, trackStageDiscoveryStageJoined.recommendationSource) && Intrinsics3.areEqual(this.recommendationScore, trackStageDiscoveryStageJoined.recommendationScore);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.index;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.stageInstanceId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recommendationSource;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Float f = this.recommendationScore;
        return iHashCode6 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryStageJoined(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", index=");
        sbU.append(this.index);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", recommendationSource=");
        sbU.append(this.recommendationSource);
        sbU.append(", recommendationScore=");
        sbU.append(this.recommendationScore);
        sbU.append(")");
        return sbU.toString();
    }
}
