package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackEmailDownloadAppsHit.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackEmailDownloadAppsHit implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long trackingPixelUuid = null;
    private final CharSequence platform = null;
    private final transient String analyticsSchemaTypeName = "email_download_apps_hit";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmailDownloadAppsHit)) {
            return false;
        }
        TrackEmailDownloadAppsHit trackEmailDownloadAppsHit = (TrackEmailDownloadAppsHit) other;
        return Intrinsics3.areEqual(this.trackingPixelUuid, trackEmailDownloadAppsHit.trackingPixelUuid) && Intrinsics3.areEqual(this.platform, trackEmailDownloadAppsHit.platform);
    }

    public int hashCode() {
        Long l = this.trackingPixelUuid;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.platform;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmailDownloadAppsHit(trackingPixelUuid=");
        sbU.append(this.trackingPixelUuid);
        sbU.append(", platform=");
        return outline.E(sbU, this.platform, ")");
    }
}
