package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPremiumUpgradeCompleted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumUpgradeCompleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final CharSequence errorCode = null;
    private final CharSequence plan = null;
    private final transient String analyticsSchemaTypeName = "premium_upgrade_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumUpgradeCompleted)) {
            return false;
        }
        TrackPremiumUpgradeCompleted trackPremiumUpgradeCompleted = (TrackPremiumUpgradeCompleted) other;
        return Intrinsics3.areEqual(this.success, trackPremiumUpgradeCompleted.success) && Intrinsics3.areEqual(this.errorCode, trackPremiumUpgradeCompleted.errorCode) && Intrinsics3.areEqual(this.plan, trackPremiumUpgradeCompleted.plan);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.errorCode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.plan;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumUpgradeCompleted(success=");
        sbU.append(this.success);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", plan=");
        return outline.E(sbU, this.plan, ")");
    }
}
