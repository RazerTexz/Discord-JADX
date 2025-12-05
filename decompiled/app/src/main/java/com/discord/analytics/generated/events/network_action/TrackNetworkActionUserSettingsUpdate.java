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

/* compiled from: TrackNetworkActionUserSettingsUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserSettingsUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final CharSequence key = null;
    private final CharSequence value = null;
    private final transient String analyticsSchemaTypeName = "network_action_user_settings_update";

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
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionUserSettingsUpdate)) {
            return false;
        }
        TrackNetworkActionUserSettingsUpdate trackNetworkActionUserSettingsUpdate = (TrackNetworkActionUserSettingsUpdate) other;
        return Intrinsics3.areEqual(this.key, trackNetworkActionUserSettingsUpdate.key) && Intrinsics3.areEqual(this.value, trackNetworkActionUserSettingsUpdate.value);
    }

    public int hashCode() {
        CharSequence charSequence = this.key;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.value;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionUserSettingsUpdate(key=");
        sbM833U.append(this.key);
        sbM833U.append(", value=");
        return outline.m817E(sbM833U, this.value, ")");
    }
}
