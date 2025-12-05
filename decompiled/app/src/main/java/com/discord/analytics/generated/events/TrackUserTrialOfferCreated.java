package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUserTrialOfferCreated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserTrialOfferCreated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long trialOfferId = null;
    private final Long trialId = null;
    private final Long expiresAt = null;
    private final transient String analyticsSchemaTypeName = "user_trial_offer_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserTrialOfferCreated)) {
            return false;
        }
        TrackUserTrialOfferCreated trackUserTrialOfferCreated = (TrackUserTrialOfferCreated) other;
        return Intrinsics3.areEqual(this.trialOfferId, trackUserTrialOfferCreated.trialOfferId) && Intrinsics3.areEqual(this.trialId, trackUserTrialOfferCreated.trialId) && Intrinsics3.areEqual(this.expiresAt, trackUserTrialOfferCreated.expiresAt);
    }

    public int hashCode() {
        Long l = this.trialOfferId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.expiresAt;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUserTrialOfferCreated(trialOfferId=");
        sbM833U.append(this.trialOfferId);
        sbM833U.append(", trialId=");
        sbM833U.append(this.trialId);
        sbM833U.append(", expiresAt=");
        return outline.m819G(sbM833U, this.expiresAt, ")");
    }
}
