package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildInsightsGuildGridViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildInsightsGuildGridViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final List<Long> guildIds = null;
    private final transient String analyticsSchemaTypeName = "guild_insights_guild_grid_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGuildInsightsGuildGridViewed) && Intrinsics3.areEqual(this.guildIds, ((TrackGuildInsightsGuildGridViewed) other).guildIds);
        }
        return true;
    }

    public int hashCode() {
        List<Long> list = this.guildIds;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m824L(outline.m833U("TrackGuildInsightsGuildGridViewed(guildIds="), this.guildIds, ")");
    }
}
