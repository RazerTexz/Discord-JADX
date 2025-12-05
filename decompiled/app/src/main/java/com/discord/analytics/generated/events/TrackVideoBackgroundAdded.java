package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackVideoBackgroundAdded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVideoBackgroundAdded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isAnimated = null;
    private final Boolean isVideo = null;
    private final Boolean isFromTenor = null;
    private final transient String analyticsSchemaTypeName = "video_background_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoBackgroundAdded)) {
            return false;
        }
        TrackVideoBackgroundAdded trackVideoBackgroundAdded = (TrackVideoBackgroundAdded) other;
        return Intrinsics3.areEqual(this.isAnimated, trackVideoBackgroundAdded.isAnimated) && Intrinsics3.areEqual(this.isVideo, trackVideoBackgroundAdded.isVideo) && Intrinsics3.areEqual(this.isFromTenor, trackVideoBackgroundAdded.isFromTenor);
    }

    public int hashCode() {
        Boolean bool = this.isAnimated;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isVideo;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isFromTenor;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackVideoBackgroundAdded(isAnimated=");
        sbM833U.append(this.isAnimated);
        sbM833U.append(", isVideo=");
        sbM833U.append(this.isVideo);
        sbM833U.append(", isFromTenor=");
        return outline.m816D(sbM833U, this.isFromTenor, ")");
    }
}
