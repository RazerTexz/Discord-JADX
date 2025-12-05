package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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
        StringBuilder sbM833U = outline.m833U("TrackGuildSettingsDiscoveryViewed(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", failedReasons=");
        return outline.m824L(sbM833U, this.failedReasons, ")");
    }
}
