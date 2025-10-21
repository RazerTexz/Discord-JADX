package com.discord.analytics.generated.events.impression;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadata2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackImpressionGuildInviteSearch.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionGuildInviteSearch implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2, TrackImpressionMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final transient String analyticsSchemaTypeName = "impression_guild_invite_search";

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
        if (!(other instanceof TrackImpressionGuildInviteSearch)) {
            return false;
        }
        TrackImpressionGuildInviteSearch trackImpressionGuildInviteSearch = (TrackImpressionGuildInviteSearch) other;
        return Intrinsics3.areEqual(this.inviteGuildId, trackImpressionGuildInviteSearch.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackImpressionGuildInviteSearch.inviteChannelId);
    }

    public int hashCode() {
        Long l = this.inviteGuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.inviteChannelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackImpressionGuildInviteSearch(inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        return outline.G(sbU, this.inviteChannelId, ")");
    }
}
