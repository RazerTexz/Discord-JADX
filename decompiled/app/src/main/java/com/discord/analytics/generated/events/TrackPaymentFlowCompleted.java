package com.discord.analytics.generated.events;

import b.d.b.a.outline;
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
import d0.z.d.Intrinsics3;

/* compiled from: TrackPaymentFlowCompleted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowCompleted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackSubscriptionMetadata2, TrackPaymentMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence loadId = null;
    private final Long durationMs = null;
    private final Long trialPeriodLengthDays = null;
    private final Boolean eligibleForTrial = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowCompleted)) {
            return false;
        }
        TrackPaymentFlowCompleted trackPaymentFlowCompleted = (TrackPaymentFlowCompleted) other;
        return Intrinsics3.areEqual(this.loadId, trackPaymentFlowCompleted.loadId) && Intrinsics3.areEqual(this.durationMs, trackPaymentFlowCompleted.durationMs) && Intrinsics3.areEqual(this.trialPeriodLengthDays, trackPaymentFlowCompleted.trialPeriodLengthDays) && Intrinsics3.areEqual(this.eligibleForTrial, trackPaymentFlowCompleted.eligibleForTrial) && Intrinsics3.areEqual(this.guildId, trackPaymentFlowCompleted.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.trialPeriodLengthDays;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentFlowCompleted(loadId=");
        sbU.append(this.loadId);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", trialPeriodLengthDays=");
        sbU.append(this.trialPeriodLengthDays);
        sbU.append(", eligibleForTrial=");
        sbU.append(this.eligibleForTrial);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
