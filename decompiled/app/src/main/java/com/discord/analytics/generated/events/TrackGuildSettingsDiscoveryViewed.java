package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackGuildSettingsDiscoveryViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsDiscoveryViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final List<CharSequence> failedReasons = null;
    private final transient String analyticsSchemaTypeName = "guild_settings_discovery_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildSettingsDiscoveryViewed)) {
            return false;
        }
        TrackGuildSettingsDiscoveryViewed trackGuildSettingsDiscoveryViewed = (TrackGuildSettingsDiscoveryViewed) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildSettingsDiscoveryViewed.guildId) && Intrinsics3.areEqual(this.failedReasons, trackGuildSettingsDiscoveryViewed.failedReasons);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<CharSequence> list = this.failedReasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildSettingsDiscoveryViewed(guildId=");
        sbU.append(this.guildId);
        sbU.append(", failedReasons=");
        return outline.L(sbU, this.failedReasons, ")");
    }
}
