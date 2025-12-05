package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackOutboundPromotionCodeClaimed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOutboundPromotionCodeClaimed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long promotionId = null;
    private final transient String analyticsSchemaTypeName = "outbound_promotion_code_claimed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackOutboundPromotionCodeClaimed) && Intrinsics3.areEqual(this.promotionId, ((TrackOutboundPromotionCodeClaimed) other).promotionId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.promotionId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m819G(outline.m833U("TrackOutboundPromotionCodeClaimed(promotionId="), this.promotionId, ")");
    }
}
