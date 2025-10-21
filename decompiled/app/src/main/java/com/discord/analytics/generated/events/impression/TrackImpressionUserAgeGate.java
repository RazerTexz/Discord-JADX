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

/* compiled from: TrackImpressionUserAgeGate.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionUserAgeGate implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2, TrackImpressionMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean existingUser;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionUserAgeGate() {
        this.existingUser = null;
        this.analyticsSchemaTypeName = "impression_user_age_gate";
    }

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
            return (other instanceof TrackImpressionUserAgeGate) && Intrinsics3.areEqual(this.existingUser, ((TrackImpressionUserAgeGate) other).existingUser);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.existingUser;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackImpressionUserAgeGate(existingUser="), this.existingUser, ")");
    }

    public TrackImpressionUserAgeGate(Boolean bool) {
        this.existingUser = bool;
        this.analyticsSchemaTypeName = "impression_user_age_gate";
    }
}
