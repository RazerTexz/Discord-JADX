package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionGracePeriodScheduled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionGracePeriodScheduled implements AnalyticsSchema, TrackBase2, TrackSubscriptionMetadata2 {
    private TrackBase trackBase;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final Long paymentGateway = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Long invoiceId = null;
    private final Long invoiceDueAt = null;
    private final Long gracePeriodDays = null;
    private final transient String analyticsSchemaTypeName = "subscription_grace_period_scheduled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionGracePeriodScheduled)) {
            return false;
        }
        TrackSubscriptionGracePeriodScheduled trackSubscriptionGracePeriodScheduled = (TrackSubscriptionGracePeriodScheduled) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionGracePeriodScheduled.subscriptionId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionGracePeriodScheduled.paymentGateway) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionGracePeriodScheduled.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionGracePeriodScheduled.currentPeriodEnd) && Intrinsics3.areEqual(this.invoiceId, trackSubscriptionGracePeriodScheduled.invoiceId) && Intrinsics3.areEqual(this.invoiceDueAt, trackSubscriptionGracePeriodScheduled.invoiceDueAt) && Intrinsics3.areEqual(this.gracePeriodDays, trackSubscriptionGracePeriodScheduled.gracePeriodDays);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentGateway;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentPeriodStart;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.currentPeriodEnd;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.invoiceId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.invoiceDueAt;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.gracePeriodDays;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSubscriptionGracePeriodScheduled(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", currentPeriodStart=");
        sbM833U.append(this.currentPeriodStart);
        sbM833U.append(", currentPeriodEnd=");
        sbM833U.append(this.currentPeriodEnd);
        sbM833U.append(", invoiceId=");
        sbM833U.append(this.invoiceId);
        sbM833U.append(", invoiceDueAt=");
        sbM833U.append(this.invoiceDueAt);
        sbM833U.append(", gracePeriodDays=");
        return outline.m819G(sbM833U, this.gracePeriodDays, ")");
    }
}
