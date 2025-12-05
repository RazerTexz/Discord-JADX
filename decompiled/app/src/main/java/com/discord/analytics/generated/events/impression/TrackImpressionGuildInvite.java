package com.discord.analytics.generated.events.impression;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackImpressionGuildInvite.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionGuildInvite implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2, TrackImpressionMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long inviteChannelId;
    private final Long inviteGuildId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionGuildInvite(Long l, Long l2) {
        this.inviteGuildId = l;
        this.inviteChannelId = l2;
        this.analyticsSchemaTypeName = "impression_guild_invite";
    }

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
        if (!(other instanceof TrackImpressionGuildInvite)) {
            return false;
        }
        TrackImpressionGuildInvite trackImpressionGuildInvite = (TrackImpressionGuildInvite) other;
        return Intrinsics3.areEqual(this.inviteGuildId, trackImpressionGuildInvite.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackImpressionGuildInvite.inviteChannelId);
    }

    public int hashCode() {
        Long l = this.inviteGuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.inviteChannelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackImpressionGuildInvite(inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        return outline.m819G(sbM833U, this.inviteChannelId, ")");
    }

    public TrackImpressionGuildInvite() {
        this(null, null);
    }
}
