package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackGuildMembershipGateMetadata;
import com.discord.analytics.generated.traits.TrackGuildMembershipGateMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildMembershipGateSettingsUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildMembershipGateSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackGuildMembershipGateMetadata2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildMembershipGateMetadata trackGuildMembershipGateMetadata;
    private final Boolean isEnabled = null;
    private final transient String analyticsSchemaTypeName = "guild_membership_gate_settings_updated";

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
        if (this != other) {
            return (other instanceof TrackGuildMembershipGateSettingsUpdated) && Intrinsics3.areEqual(this.isEnabled, ((TrackGuildMembershipGateSettingsUpdated) other).isEnabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.isEnabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackGuildMembershipGateSettingsUpdated(isEnabled="), this.isEnabled, ")");
    }
}
