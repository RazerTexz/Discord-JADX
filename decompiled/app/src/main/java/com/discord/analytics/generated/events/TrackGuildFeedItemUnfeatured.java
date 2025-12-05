package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildFeedItemUnfeatured.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildFeedItemUnfeatured implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence entityType = null;
    private final Long entityId = null;
    private final transient String analyticsSchemaTypeName = "guild_feed_item_unfeatured";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildFeedItemUnfeatured)) {
            return false;
        }
        TrackGuildFeedItemUnfeatured trackGuildFeedItemUnfeatured = (TrackGuildFeedItemUnfeatured) other;
        return Intrinsics3.areEqual(this.entityType, trackGuildFeedItemUnfeatured.entityType) && Intrinsics3.areEqual(this.entityId, trackGuildFeedItemUnfeatured.entityId);
    }

    public int hashCode() {
        CharSequence charSequence = this.entityType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.entityId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGuildFeedItemUnfeatured(entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", entityId=");
        return outline.m819G(sbM833U, this.entityId, ")");
    }
}
