package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackFeedItemSeenBatch.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackFeedItemSeenBatch implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final List<CharSequence> feedItemIds = null;
    private final List<Long> additionalSeenTimeMillis = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "feed_item_seen_batch";

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
        if (!(other instanceof TrackFeedItemSeenBatch)) {
            return false;
        }
        TrackFeedItemSeenBatch trackFeedItemSeenBatch = (TrackFeedItemSeenBatch) other;
        return Intrinsics3.areEqual(this.loadId, trackFeedItemSeenBatch.loadId) && Intrinsics3.areEqual(this.feedItemIds, trackFeedItemSeenBatch.feedItemIds) && Intrinsics3.areEqual(this.additionalSeenTimeMillis, trackFeedItemSeenBatch.additionalSeenTimeMillis) && Intrinsics3.areEqual(this.homeSessionId, trackFeedItemSeenBatch.homeSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<CharSequence> list = this.feedItemIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.additionalSeenTimeMillis;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.homeSessionId;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackFeedItemSeenBatch(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", feedItemIds=");
        sbM833U.append(this.feedItemIds);
        sbM833U.append(", additionalSeenTimeMillis=");
        sbM833U.append(this.additionalSeenTimeMillis);
        sbM833U.append(", homeSessionId=");
        return outline.m817E(sbM833U, this.homeSessionId, ")");
    }
}
