package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackPaymentSourceUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentSourceUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long paymentSourceId = null;
    private final Long cardExpirationDate = null;
    private final Boolean isDefault = null;
    private final transient String analyticsSchemaTypeName = "payment_source_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentSourceUpdated)) {
            return false;
        }
        TrackPaymentSourceUpdated trackPaymentSourceUpdated = (TrackPaymentSourceUpdated) other;
        return Intrinsics3.areEqual(this.paymentSourceId, trackPaymentSourceUpdated.paymentSourceId) && Intrinsics3.areEqual(this.cardExpirationDate, trackPaymentSourceUpdated.cardExpirationDate) && Intrinsics3.areEqual(this.isDefault, trackPaymentSourceUpdated.isDefault);
    }

    public int hashCode() {
        Long l = this.paymentSourceId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.cardExpirationDate;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.isDefault;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackPaymentSourceUpdated(paymentSourceId=");
        sbM833U.append(this.paymentSourceId);
        sbM833U.append(", cardExpirationDate=");
        sbM833U.append(this.cardExpirationDate);
        sbM833U.append(", isDefault=");
        return outline.m816D(sbM833U, this.isDefault, ")");
    }
}
