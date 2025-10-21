package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackActivityInternalWatchTogetherSearched.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherSearched implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final CharSequence searchType = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_searched";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherSearched)) {
            return false;
        }
        TrackActivityInternalWatchTogetherSearched trackActivityInternalWatchTogetherSearched = (TrackActivityInternalWatchTogetherSearched) other;
        return Intrinsics3.areEqual(this.isHost, trackActivityInternalWatchTogetherSearched.isHost) && Intrinsics3.areEqual(this.searchType, trackActivityInternalWatchTogetherSearched.searchType);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.searchType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherSearched(isHost=");
        sbU.append(this.isHost);
        sbU.append(", searchType=");
        return outline.E(sbU, this.searchType, ")");
    }
}
