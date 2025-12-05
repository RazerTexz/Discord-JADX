package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildDiscoveryGuildJoinClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryGuildJoinClicked implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long guildId = null;
    private final CharSequence loadId = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_guild_join_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryGuildJoinClicked)) {
            return false;
        }
        TrackGuildDiscoveryGuildJoinClicked trackGuildDiscoveryGuildJoinClicked = (TrackGuildDiscoveryGuildJoinClicked) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildDiscoveryGuildJoinClicked.guildId) && Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryGuildJoinClicked.loadId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.loadId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildDiscoveryGuildJoinClicked(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", loadId=");
        return outline.m817E(sbM833U, this.loadId, ")");
    }
}
