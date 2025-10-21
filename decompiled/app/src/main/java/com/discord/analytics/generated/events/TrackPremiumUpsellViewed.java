package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumUpsellViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumUpsellViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence type = null;
    private final Boolean isAnimated = null;
    private final Boolean isExternal = null;
    private final Boolean hasSearchQuery = null;
    private final Boolean hasPremiumStreamFps = null;
    private final Boolean hasPremiumStreamResolution = null;
    private final Float duration = null;
    private final transient String analyticsSchemaTypeName = "premium_upsell_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumUpsellViewed)) {
            return false;
        }
        TrackPremiumUpsellViewed trackPremiumUpsellViewed = (TrackPremiumUpsellViewed) other;
        return Intrinsics3.areEqual(this.type, trackPremiumUpsellViewed.type) && Intrinsics3.areEqual(this.isAnimated, trackPremiumUpsellViewed.isAnimated) && Intrinsics3.areEqual(this.isExternal, trackPremiumUpsellViewed.isExternal) && Intrinsics3.areEqual(this.hasSearchQuery, trackPremiumUpsellViewed.hasSearchQuery) && Intrinsics3.areEqual(this.hasPremiumStreamFps, trackPremiumUpsellViewed.hasPremiumStreamFps) && Intrinsics3.areEqual(this.hasPremiumStreamResolution, trackPremiumUpsellViewed.hasPremiumStreamResolution) && Intrinsics3.areEqual(this.duration, trackPremiumUpsellViewed.duration);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isAnimated;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isExternal;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasSearchQuery;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasPremiumStreamFps;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hasPremiumStreamResolution;
        int iHashCode6 = (iHashCode5 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Float f = this.duration;
        return iHashCode6 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumUpsellViewed(type=");
        sbU.append(this.type);
        sbU.append(", isAnimated=");
        sbU.append(this.isAnimated);
        sbU.append(", isExternal=");
        sbU.append(this.isExternal);
        sbU.append(", hasSearchQuery=");
        sbU.append(this.hasSearchQuery);
        sbU.append(", hasPremiumStreamFps=");
        sbU.append(this.hasPremiumStreamFps);
        sbU.append(", hasPremiumStreamResolution=");
        sbU.append(this.hasPremiumStreamResolution);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(")");
        return sbU.toString();
    }
}
