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

/* JADX INFO: compiled from: TrackNetworkActionDirectoryGuildEntryDelete.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionDirectoryGuildEntryDelete implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long directoryChannelId;
    private final Long guildId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionDirectoryGuildEntryDelete() {
        this.directoryChannelId = null;
        this.guildId = null;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_delete";
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
        if (!(other instanceof TrackNetworkActionDirectoryGuildEntryDelete)) {
            return false;
        }
        TrackNetworkActionDirectoryGuildEntryDelete trackNetworkActionDirectoryGuildEntryDelete = (TrackNetworkActionDirectoryGuildEntryDelete) other;
        return Intrinsics3.areEqual(this.directoryChannelId, trackNetworkActionDirectoryGuildEntryDelete.directoryChannelId) && Intrinsics3.areEqual(this.guildId, trackNetworkActionDirectoryGuildEntryDelete.guildId);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionDirectoryGuildEntryDelete(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", guildId=");
        return outline.m819G(sbM833U, this.guildId, ")");
    }

    public TrackNetworkActionDirectoryGuildEntryDelete(Long l, Long l2) {
        this.directoryChannelId = l;
        this.guildId = l2;
        this.analyticsSchemaTypeName = "network_action_directory_guild_entry_delete";
    }
}
