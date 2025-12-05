package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackPaymentFlowFailed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowFailed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackSubscriptionMetadata2, TrackPaymentMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence loadId = null;
    private final Long durationMs = null;
    private final Long paymentErrorCode = null;
    private final Long paymentSourceId = null;
    private final Long paymentGateway = null;
    private final Boolean eligibleForTrial = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowFailed)) {
            return false;
        }
        TrackPaymentFlowFailed trackPaymentFlowFailed = (TrackPaymentFlowFailed) other;
        return Intrinsics3.areEqual(this.loadId, trackPaymentFlowFailed.loadId) && Intrinsics3.areEqual(this.durationMs, trackPaymentFlowFailed.durationMs) && Intrinsics3.areEqual(this.paymentErrorCode, trackPaymentFlowFailed.paymentErrorCode) && Intrinsics3.areEqual(this.paymentSourceId, trackPaymentFlowFailed.paymentSourceId) && Intrinsics3.areEqual(this.paymentGateway, trackPaymentFlowFailed.paymentGateway) && Intrinsics3.areEqual(this.eligibleForTrial, trackPaymentFlowFailed.eligibleForTrial);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.paymentErrorCode;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentSourceId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackPaymentFlowFailed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", durationMs=");
        sbM833U.append(this.durationMs);
        sbM833U.append(", paymentErrorCode=");
        sbM833U.append(this.paymentErrorCode);
        sbM833U.append(", paymentSourceId=");
        sbM833U.append(this.paymentSourceId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", eligibleForTrial=");
        return outline.m816D(sbM833U, this.eligibleForTrial, ")");
    }
}
