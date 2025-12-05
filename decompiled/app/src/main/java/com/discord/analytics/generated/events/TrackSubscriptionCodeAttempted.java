package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSubscriptionCodeAttempted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCodeAttempted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence code = null;
    private final Boolean isEligible = null;
    private final transient String analyticsSchemaTypeName = "subscription_code_attempted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionCodeAttempted)) {
            return false;
        }
        TrackSubscriptionCodeAttempted trackSubscriptionCodeAttempted = (TrackSubscriptionCodeAttempted) other;
        return Intrinsics3.areEqual(this.code, trackSubscriptionCodeAttempted.code) && Intrinsics3.areEqual(this.isEligible, trackSubscriptionCodeAttempted.isEligible);
    }

    public int hashCode() {
        CharSequence charSequence = this.code;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isEligible;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSubscriptionCodeAttempted(code=");
        sbM833U.append(this.code);
        sbM833U.append(", isEligible=");
        return outline.m816D(sbM833U, this.isEligible, ")");
    }
}
