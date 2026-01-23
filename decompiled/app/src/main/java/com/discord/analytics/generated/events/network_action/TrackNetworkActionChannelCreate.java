package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackNetworkActionChannelCreate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionChannelCreate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long channelId;
    private final Long channelType;
    private final Long guildId;
    private final Boolean isPrivate;
    private final Long parentId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionChannelCreate(Boolean bool, Long l, Long l2, Long l3, Long l4) {
        this.isPrivate = bool;
        this.channelType = l;
        this.channelId = l2;
        this.parentId = l3;
        this.guildId = l4;
        this.analyticsSchemaTypeName = "network_action_channel_create";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    /* JADX INFO: renamed from: b */
    public void mo7529b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionChannelCreate)) {
            return false;
        }
        TrackNetworkActionChannelCreate trackNetworkActionChannelCreate = (TrackNetworkActionChannelCreate) other;
        return Intrinsics3.areEqual(this.isPrivate, trackNetworkActionChannelCreate.isPrivate) && Intrinsics3.areEqual(this.channelType, trackNetworkActionChannelCreate.channelType) && Intrinsics3.areEqual(this.channelId, trackNetworkActionChannelCreate.channelId) && Intrinsics3.areEqual(this.parentId, trackNetworkActionChannelCreate.parentId) && Intrinsics3.areEqual(this.guildId, trackNetworkActionChannelCreate.guildId);
    }

    public int hashCode() {
        Boolean bool = this.isPrivate;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.channelType;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.parentId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionChannelCreate(isPrivate=");
        sbM833U.append(this.isPrivate);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", guildId=");
        return outline.m819G(sbM833U, this.guildId, ")");
    }

    public TrackNetworkActionChannelCreate() {
        this(null, null, null, null, null);
    }
}
