package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumPurchaseCompleted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumPurchaseCompleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final CharSequence errorCode = null;
    private final CharSequence plan = null;
    private final CharSequence paymentGateway = null;
    private final transient String analyticsSchemaTypeName = "premium_purchase_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumPurchaseCompleted)) {
            return false;
        }
        TrackPremiumPurchaseCompleted trackPremiumPurchaseCompleted = (TrackPremiumPurchaseCompleted) other;
        return Intrinsics3.areEqual(this.success, trackPremiumPurchaseCompleted.success) && Intrinsics3.areEqual(this.errorCode, trackPremiumPurchaseCompleted.errorCode) && Intrinsics3.areEqual(this.plan, trackPremiumPurchaseCompleted.plan) && Intrinsics3.areEqual(this.paymentGateway, trackPremiumPurchaseCompleted.paymentGateway);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.errorCode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.plan;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.paymentGateway;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumPurchaseCompleted(success=");
        sbU.append(this.success);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", plan=");
        sbU.append(this.plan);
        sbU.append(", paymentGateway=");
        return outline.E(sbU, this.paymentGateway, ")");
    }
}
