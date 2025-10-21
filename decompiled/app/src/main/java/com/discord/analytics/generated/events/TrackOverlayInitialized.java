package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackOverlayInitialized.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayInitialized implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean voiceWidgetConnected = null;
    private final Boolean textWidgetConnected = null;
    private final transient String analyticsSchemaTypeName = "overlay_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayInitialized)) {
            return false;
        }
        TrackOverlayInitialized trackOverlayInitialized = (TrackOverlayInitialized) other;
        return Intrinsics3.areEqual(this.voiceWidgetConnected, trackOverlayInitialized.voiceWidgetConnected) && Intrinsics3.areEqual(this.textWidgetConnected, trackOverlayInitialized.textWidgetConnected);
    }

    public int hashCode() {
        Boolean bool = this.voiceWidgetConnected;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.textWidgetConnected;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayInitialized(voiceWidgetConnected=");
        sbU.append(this.voiceWidgetConnected);
        sbU.append(", textWidgetConnected=");
        return outline.D(sbU, this.textWidgetConnected, ")");
    }
}
