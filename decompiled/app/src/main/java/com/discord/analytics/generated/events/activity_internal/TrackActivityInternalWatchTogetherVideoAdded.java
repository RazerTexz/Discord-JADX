package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackActivityInternalWatchTogetherVideoAdded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherVideoAdded implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final CharSequence via = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_video_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherVideoAdded)) {
            return false;
        }
        TrackActivityInternalWatchTogetherVideoAdded trackActivityInternalWatchTogetherVideoAdded = (TrackActivityInternalWatchTogetherVideoAdded) other;
        return Intrinsics3.areEqual(this.isHost, trackActivityInternalWatchTogetherVideoAdded.isHost) && Intrinsics3.areEqual(this.via, trackActivityInternalWatchTogetherVideoAdded.via);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.via;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherVideoAdded(isHost=");
        sbU.append(this.isHost);
        sbU.append(", via=");
        return outline.E(sbU, this.via, ")");
    }
}
