package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackStageDiscoveryReloaded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStageDiscoveryReloaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence stageInstanceRecommendations = null;
    private final Long lastVisibleIndexAtLoad = null;
    private final Long lastVisibleIndex = null;
    private final Boolean hasScrolled = null;
    private final transient String analyticsSchemaTypeName = "stage_discovery_reloaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStageDiscoveryReloaded)) {
            return false;
        }
        TrackStageDiscoveryReloaded trackStageDiscoveryReloaded = (TrackStageDiscoveryReloaded) other;
        return Intrinsics3.areEqual(this.loadId, trackStageDiscoveryReloaded.loadId) && Intrinsics3.areEqual(this.stageInstanceRecommendations, trackStageDiscoveryReloaded.stageInstanceRecommendations) && Intrinsics3.areEqual(this.lastVisibleIndexAtLoad, trackStageDiscoveryReloaded.lastVisibleIndexAtLoad) && Intrinsics3.areEqual(this.lastVisibleIndex, trackStageDiscoveryReloaded.lastVisibleIndex) && Intrinsics3.areEqual(this.hasScrolled, trackStageDiscoveryReloaded.hasScrolled);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.stageInstanceRecommendations;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.lastVisibleIndexAtLoad;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.lastVisibleIndex;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.hasScrolled;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStageDiscoveryReloaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", stageInstanceRecommendations=");
        sbU.append(this.stageInstanceRecommendations);
        sbU.append(", lastVisibleIndexAtLoad=");
        sbU.append(this.lastVisibleIndexAtLoad);
        sbU.append(", lastVisibleIndex=");
        sbU.append(this.lastVisibleIndex);
        sbU.append(", hasScrolled=");
        return outline.D(sbU, this.hasScrolled, ")");
    }
}
