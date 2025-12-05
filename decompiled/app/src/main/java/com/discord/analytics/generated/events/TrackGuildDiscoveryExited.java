package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildDiscoveryExited.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryExited implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> guildIdsViewed = null;
    private final CharSequence recommendationsSource = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryExited)) {
            return false;
        }
        TrackGuildDiscoveryExited trackGuildDiscoveryExited = (TrackGuildDiscoveryExited) other;
        return Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryExited.loadId) && Intrinsics3.areEqual(this.guildIdsViewed, trackGuildDiscoveryExited.guildIdsViewed) && Intrinsics3.areEqual(this.recommendationsSource, trackGuildDiscoveryExited.recommendationsSource);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.guildIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.recommendationsSource;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildDiscoveryExited(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", guildIdsViewed=");
        sbM833U.append(this.guildIdsViewed);
        sbM833U.append(", recommendationsSource=");
        return outline.m817E(sbM833U, this.recommendationsSource, ")");
    }
}
