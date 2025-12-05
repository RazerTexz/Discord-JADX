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

/* compiled from: TrackNetworkActionHubEmailVerifySend.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionHubEmailVerifySend implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean hasMatchingGuild;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionHubEmailVerifySend(Boolean bool) {
        this.hasMatchingGuild = bool;
        this.analyticsSchemaTypeName = "network_action_hub_email_verify_send";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    /* renamed from: b */
    public void mo7529b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNetworkActionHubEmailVerifySend) && Intrinsics3.areEqual(this.hasMatchingGuild, ((TrackNetworkActionHubEmailVerifySend) other).hasMatchingGuild);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.hasMatchingGuild;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m816D(outline.m833U("TrackNetworkActionHubEmailVerifySend(hasMatchingGuild="), this.hasMatchingGuild, ")");
    }

    public TrackNetworkActionHubEmailVerifySend() {
        this(null);
    }
}
