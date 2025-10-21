package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackUserPremiumGuildSubscriptionSlotCanceled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserPremiumGuildSubscriptionSlotCanceled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long slotId = null;
    private final Long subscriptionId = null;
    private final transient String analyticsSchemaTypeName = "user_premium_guild_subscription_slot_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserPremiumGuildSubscriptionSlotCanceled)) {
            return false;
        }
        TrackUserPremiumGuildSubscriptionSlotCanceled trackUserPremiumGuildSubscriptionSlotCanceled = (TrackUserPremiumGuildSubscriptionSlotCanceled) other;
        return Intrinsics3.areEqual(this.slotId, trackUserPremiumGuildSubscriptionSlotCanceled.slotId) && Intrinsics3.areEqual(this.subscriptionId, trackUserPremiumGuildSubscriptionSlotCanceled.subscriptionId);
    }

    public int hashCode() {
        Long l = this.slotId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserPremiumGuildSubscriptionSlotCanceled(slotId=");
        sbU.append(this.slotId);
        sbU.append(", subscriptionId=");
        return outline.G(sbU, this.subscriptionId, ")");
    }
}
