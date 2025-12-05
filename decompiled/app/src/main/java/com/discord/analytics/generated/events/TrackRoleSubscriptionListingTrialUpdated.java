package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackRoleSubscriptionListingTrialUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingTrialUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionListingId = null;
    private final Long trialInterval = null;
    private final Long trialIntervalCount = null;
    private final Long activeTrialUserLimit = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_trial_updated";

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
        if (!(other instanceof TrackRoleSubscriptionListingTrialUpdated)) {
            return false;
        }
        TrackRoleSubscriptionListingTrialUpdated trackRoleSubscriptionListingTrialUpdated = (TrackRoleSubscriptionListingTrialUpdated) other;
        return Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingTrialUpdated.roleSubscriptionListingId) && Intrinsics3.areEqual(this.trialInterval, trackRoleSubscriptionListingTrialUpdated.trialInterval) && Intrinsics3.areEqual(this.trialIntervalCount, trackRoleSubscriptionListingTrialUpdated.trialIntervalCount) && Intrinsics3.areEqual(this.activeTrialUserLimit, trackRoleSubscriptionListingTrialUpdated.activeTrialUserLimit);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialInterval;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.trialIntervalCount;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.activeTrialUserLimit;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackRoleSubscriptionListingTrialUpdated(roleSubscriptionListingId=");
        sbM833U.append(this.roleSubscriptionListingId);
        sbM833U.append(", trialInterval=");
        sbM833U.append(this.trialInterval);
        sbM833U.append(", trialIntervalCount=");
        sbM833U.append(this.trialIntervalCount);
        sbM833U.append(", activeTrialUserLimit=");
        return outline.m819G(sbM833U, this.activeTrialUserLimit, ")");
    }
}
