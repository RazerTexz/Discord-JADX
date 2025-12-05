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

/* compiled from: TrackImpressionHubEmailSignup.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackImpressionHubEmailSignup implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2, TrackImpressionMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean hasInvite;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionHubEmailSignup() {
        this.hasInvite = null;
        this.analyticsSchemaTypeName = "impression_hub_email_signup";
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
        if (this != other) {
            return (other instanceof TrackImpressionHubEmailSignup) && Intrinsics3.areEqual(this.hasInvite, ((TrackImpressionHubEmailSignup) other).hasInvite);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.hasInvite;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m816D(outline.m833U("TrackImpressionHubEmailSignup(hasInvite="), this.hasInvite, ")");
    }

    public TrackImpressionHubEmailSignup(Boolean bool) {
        this.hasInvite = bool;
        this.analyticsSchemaTypeName = "impression_hub_email_signup";
    }
}
