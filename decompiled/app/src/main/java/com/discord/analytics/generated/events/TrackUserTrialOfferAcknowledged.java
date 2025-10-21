package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackUserTrialOfferAcknowledged.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserTrialOfferAcknowledged implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long trialOfferId = null;
    private final Long trialId = null;
    private final Long expiresAt = null;
    private final transient String analyticsSchemaTypeName = "user_trial_offer_acknowledged";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserTrialOfferAcknowledged)) {
            return false;
        }
        TrackUserTrialOfferAcknowledged trackUserTrialOfferAcknowledged = (TrackUserTrialOfferAcknowledged) other;
        return Intrinsics3.areEqual(this.trialOfferId, trackUserTrialOfferAcknowledged.trialOfferId) && Intrinsics3.areEqual(this.trialId, trackUserTrialOfferAcknowledged.trialId) && Intrinsics3.areEqual(this.expiresAt, trackUserTrialOfferAcknowledged.expiresAt);
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
        StringBuilder sbU = outline.U("TrackUserTrialOfferAcknowledged(trialOfferId=");
        sbU.append(this.trialOfferId);
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", expiresAt=");
        return outline.G(sbU, this.expiresAt, ")");
    }
}
