package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumGuildSubscriptionRemoved.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long premiumGuildSubscriptionId = null;
    private final Long currentTier = null;
    private final Long previousTier = null;
    private final Long premiumSubscriptionCount = null;
    private final Long tierLost = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionRemoved)) {
            return false;
        }
        TrackPremiumGuildSubscriptionRemoved trackPremiumGuildSubscriptionRemoved = (TrackPremiumGuildSubscriptionRemoved) other;
        return Intrinsics3.areEqual(this.guildId, trackPremiumGuildSubscriptionRemoved.guildId) && Intrinsics3.areEqual(this.premiumGuildSubscriptionId, trackPremiumGuildSubscriptionRemoved.premiumGuildSubscriptionId) && Intrinsics3.areEqual(this.currentTier, trackPremiumGuildSubscriptionRemoved.currentTier) && Intrinsics3.areEqual(this.previousTier, trackPremiumGuildSubscriptionRemoved.previousTier) && Intrinsics3.areEqual(this.premiumSubscriptionCount, trackPremiumGuildSubscriptionRemoved.premiumSubscriptionCount) && Intrinsics3.areEqual(this.tierLost, trackPremiumGuildSubscriptionRemoved.tierLost);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.premiumGuildSubscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.previousTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.premiumSubscriptionCount;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.tierLost;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumGuildSubscriptionRemoved(guildId=");
        sbU.append(this.guildId);
        sbU.append(", premiumGuildSubscriptionId=");
        sbU.append(this.premiumGuildSubscriptionId);
        sbU.append(", currentTier=");
        sbU.append(this.currentTier);
        sbU.append(", previousTier=");
        sbU.append(this.previousTier);
        sbU.append(", premiumSubscriptionCount=");
        sbU.append(this.premiumSubscriptionCount);
        sbU.append(", tierLost=");
        return outline.G(sbU, this.tierLost, ")");
    }
}
