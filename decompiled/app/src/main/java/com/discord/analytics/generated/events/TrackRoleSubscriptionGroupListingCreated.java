package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackRoleSubscriptionGroupListingCreated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionGroupListingCreated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionGroupListingId = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_group_listing_created";

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
            return (other instanceof TrackRoleSubscriptionGroupListingCreated) && Intrinsics3.areEqual(this.roleSubscriptionGroupListingId, ((TrackRoleSubscriptionGroupListingCreated) other).roleSubscriptionGroupListingId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.roleSubscriptionGroupListingId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackRoleSubscriptionGroupListingCreated(roleSubscriptionGroupListingId="), this.roleSubscriptionGroupListingId, ")");
    }
}
