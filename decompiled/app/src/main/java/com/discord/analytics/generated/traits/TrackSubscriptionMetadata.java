package com.discord.analytics.generated.traits;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSubscriptionMetadata.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionMetadata {
    private final CharSequence subscriptionPlanGatewayPlanId = null;
    private final Long subscriptionType = null;
    private final Long subscriptionPlanId = null;
    private final CharSequence code = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionMetadata)) {
            return false;
        }
        TrackSubscriptionMetadata trackSubscriptionMetadata = (TrackSubscriptionMetadata) other;
        return Intrinsics3.areEqual(this.subscriptionPlanGatewayPlanId, trackSubscriptionMetadata.subscriptionPlanGatewayPlanId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionMetadata.subscriptionType) && Intrinsics3.areEqual(this.subscriptionPlanId, trackSubscriptionMetadata.subscriptionPlanId) && Intrinsics3.areEqual(this.code, trackSubscriptionMetadata.code);
    }

    public int hashCode() {
        CharSequence charSequence = this.subscriptionPlanGatewayPlanId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.subscriptionPlanId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.code;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSubscriptionMetadata(subscriptionPlanGatewayPlanId=");
        sbM833U.append(this.subscriptionPlanGatewayPlanId);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", code=");
        return outline.m817E(sbM833U, this.code, ")");
    }
}
