package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: TrackStarredChannelsUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackStarredChannelsUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence actionType = null;
    private final List<Long> channelIds = null;
    private final transient String analyticsSchemaTypeName = "starred_channels_updated";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackStarredChannelsUpdated)) {
            return false;
        }
        TrackStarredChannelsUpdated trackStarredChannelsUpdated = (TrackStarredChannelsUpdated) other;
        return Intrinsics3.areEqual(this.actionType, trackStarredChannelsUpdated.actionType) && Intrinsics3.areEqual(this.channelIds, trackStarredChannelsUpdated.channelIds);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.channelIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStarredChannelsUpdated(actionType=");
        sbU.append(this.actionType);
        sbU.append(", channelIds=");
        return outline.L(sbU, this.channelIds, ")");
    }
}
