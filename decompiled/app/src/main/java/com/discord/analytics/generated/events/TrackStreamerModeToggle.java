package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackStreamerModeToggle.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStreamerModeToggle implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean automatic = null;
    private final Boolean enabled = null;
    private final transient String analyticsSchemaTypeName = "streamer_mode_toggle";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamerModeToggle)) {
            return false;
        }
        TrackStreamerModeToggle trackStreamerModeToggle = (TrackStreamerModeToggle) other;
        return Intrinsics3.areEqual(this.automatic, trackStreamerModeToggle.automatic) && Intrinsics3.areEqual(this.enabled, trackStreamerModeToggle.enabled);
    }

    public int hashCode() {
        Boolean bool = this.automatic;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.enabled;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStreamerModeToggle(automatic=");
        sbU.append(this.automatic);
        sbU.append(", enabled=");
        return outline.D(sbU, this.enabled, ")");
    }
}
