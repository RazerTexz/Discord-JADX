package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackUserPremiumGuildSubscriptionSlotRemoved.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUserPremiumGuildSubscriptionSlotRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long slotId = null;
    private final Long subscriptionId = null;
    private final CharSequence removalType = null;
    private final transient String analyticsSchemaTypeName = "user_premium_guild_subscription_slot_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserPremiumGuildSubscriptionSlotRemoved)) {
            return false;
        }
        TrackUserPremiumGuildSubscriptionSlotRemoved trackUserPremiumGuildSubscriptionSlotRemoved = (TrackUserPremiumGuildSubscriptionSlotRemoved) other;
        return Intrinsics3.areEqual(this.slotId, trackUserPremiumGuildSubscriptionSlotRemoved.slotId) && Intrinsics3.areEqual(this.subscriptionId, trackUserPremiumGuildSubscriptionSlotRemoved.subscriptionId) && Intrinsics3.areEqual(this.removalType, trackUserPremiumGuildSubscriptionSlotRemoved.removalType);
    }

    public int hashCode() {
        Long l = this.slotId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.removalType;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackUserPremiumGuildSubscriptionSlotRemoved(slotId=");
        sbM833U.append(this.slotId);
        sbM833U.append(", subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", removalType=");
        return outline.m817E(sbM833U, this.removalType, ")");
    }
}
