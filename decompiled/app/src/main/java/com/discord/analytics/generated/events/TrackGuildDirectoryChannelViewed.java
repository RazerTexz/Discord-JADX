package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildDirectoryChannelViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildDirectoryChannelViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long directoryChannelId = null;
    private final Long directoryGuildId = null;
    private final Long primaryCategoryId = null;
    private final transient String analyticsSchemaTypeName = "guild_directory_channel_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDirectoryChannelViewed)) {
            return false;
        }
        TrackGuildDirectoryChannelViewed trackGuildDirectoryChannelViewed = (TrackGuildDirectoryChannelViewed) other;
        return Intrinsics3.areEqual(this.directoryChannelId, trackGuildDirectoryChannelViewed.directoryChannelId) && Intrinsics3.areEqual(this.directoryGuildId, trackGuildDirectoryChannelViewed.directoryGuildId) && Intrinsics3.areEqual(this.primaryCategoryId, trackGuildDirectoryChannelViewed.primaryCategoryId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.directoryGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.primaryCategoryId;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildDirectoryChannelViewed(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", directoryGuildId=");
        sbU.append(this.directoryGuildId);
        sbU.append(", primaryCategoryId=");
        return outline.G(sbU, this.primaryCategoryId, ")");
    }
}
