package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackActivityInternalClientStatus.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalClientStatus implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Long activityWidth = null;
    private final Long activityHeight = null;
    private final Long networkLatencyMs = null;
    private final Long networkAttempts = null;
    private final Long intervalRateMs = null;
    private final Float fpsAvg = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_client_status";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalClientStatus)) {
            return false;
        }
        TrackActivityInternalClientStatus trackActivityInternalClientStatus = (TrackActivityInternalClientStatus) other;
        return Intrinsics3.areEqual(this.activityWidth, trackActivityInternalClientStatus.activityWidth) && Intrinsics3.areEqual(this.activityHeight, trackActivityInternalClientStatus.activityHeight) && Intrinsics3.areEqual(this.networkLatencyMs, trackActivityInternalClientStatus.networkLatencyMs) && Intrinsics3.areEqual(this.networkAttempts, trackActivityInternalClientStatus.networkAttempts) && Intrinsics3.areEqual(this.intervalRateMs, trackActivityInternalClientStatus.intervalRateMs) && Intrinsics3.areEqual(this.fpsAvg, trackActivityInternalClientStatus.fpsAvg);
    }

    public int hashCode() {
        Long l = this.activityWidth;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.activityHeight;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.networkLatencyMs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.networkAttempts;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.intervalRateMs;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Float f = this.fpsAvg;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActivityInternalClientStatus(activityWidth=");
        sbM833U.append(this.activityWidth);
        sbM833U.append(", activityHeight=");
        sbM833U.append(this.activityHeight);
        sbM833U.append(", networkLatencyMs=");
        sbM833U.append(this.networkLatencyMs);
        sbM833U.append(", networkAttempts=");
        sbM833U.append(this.networkAttempts);
        sbM833U.append(", intervalRateMs=");
        sbM833U.append(this.intervalRateMs);
        sbM833U.append(", fpsAvg=");
        sbM833U.append(this.fpsAvg);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
