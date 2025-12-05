package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildDirectorySearch.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildDirectorySearch implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long directoryChannelId = null;
    private final Long directoryGuildId = null;
    private final transient String analyticsSchemaTypeName = "guild_directory_search";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDirectorySearch)) {
            return false;
        }
        TrackGuildDirectorySearch trackGuildDirectorySearch = (TrackGuildDirectorySearch) other;
        return Intrinsics3.areEqual(this.directoryChannelId, trackGuildDirectorySearch.directoryChannelId) && Intrinsics3.areEqual(this.directoryGuildId, trackGuildDirectorySearch.directoryGuildId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.directoryGuildId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildDirectorySearch(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", directoryGuildId=");
        return outline.m819G(sbM833U, this.directoryGuildId, ")");
    }
}
