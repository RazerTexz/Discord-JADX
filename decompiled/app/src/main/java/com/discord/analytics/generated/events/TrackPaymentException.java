package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPaymentException.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentException implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence errorMessage = null;
    private final Long requestStatus = null;
    private final transient String analyticsSchemaTypeName = "payment_exception";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentException)) {
            return false;
        }
        TrackPaymentException trackPaymentException = (TrackPaymentException) other;
        return Intrinsics3.areEqual(this.errorMessage, trackPaymentException.errorMessage) && Intrinsics3.areEqual(this.requestStatus, trackPaymentException.requestStatus);
    }

    public int hashCode() {
        CharSequence charSequence = this.errorMessage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.requestStatus;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentException(errorMessage=");
        sbU.append(this.errorMessage);
        sbU.append(", requestStatus=");
        return outline.G(sbU, this.requestStatus, ")");
    }
}
