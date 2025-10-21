package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAppLaunchCompleted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAppLaunchCompleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence screenName = null;
    private final Long durationMsSinceAppOpened = null;
    private final Boolean hasCachedData = null;
    private final CharSequence manifest = null;
    private final transient String analyticsSchemaTypeName = "app_launch_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppLaunchCompleted)) {
            return false;
        }
        TrackAppLaunchCompleted trackAppLaunchCompleted = (TrackAppLaunchCompleted) other;
        return Intrinsics3.areEqual(this.loadId, trackAppLaunchCompleted.loadId) && Intrinsics3.areEqual(this.screenName, trackAppLaunchCompleted.screenName) && Intrinsics3.areEqual(this.durationMsSinceAppOpened, trackAppLaunchCompleted.durationMsSinceAppOpened) && Intrinsics3.areEqual(this.hasCachedData, trackAppLaunchCompleted.hasCachedData) && Intrinsics3.areEqual(this.manifest, trackAppLaunchCompleted.manifest);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.screenName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationMsSinceAppOpened;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.hasCachedData;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.manifest;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAppLaunchCompleted(loadId=");
        sbU.append(this.loadId);
        sbU.append(", screenName=");
        sbU.append(this.screenName);
        sbU.append(", durationMsSinceAppOpened=");
        sbU.append(this.durationMsSinceAppOpened);
        sbU.append(", hasCachedData=");
        sbU.append(this.hasCachedData);
        sbU.append(", manifest=");
        return outline.E(sbU, this.manifest, ")");
    }
}
