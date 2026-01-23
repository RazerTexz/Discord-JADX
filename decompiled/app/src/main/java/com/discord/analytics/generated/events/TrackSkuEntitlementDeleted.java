package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackSkuEntitlementDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementDeleted implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackEntitlementMetadata2 {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence entitlementType = null;
    private final CharSequence deletionType = null;
    private final transient String analyticsSchemaTypeName = "sku_entitlement_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuEntitlementDeleted)) {
            return false;
        }
        TrackSkuEntitlementDeleted trackSkuEntitlementDeleted = (TrackSkuEntitlementDeleted) other;
        return Intrinsics3.areEqual(this.entitlementType, trackSkuEntitlementDeleted.entitlementType) && Intrinsics3.areEqual(this.deletionType, trackSkuEntitlementDeleted.deletionType);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deletionType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSkuEntitlementDeleted(entitlementType=");
        sbM833U.append(this.entitlementType);
        sbM833U.append(", deletionType=");
        return outline.m817E(sbM833U, this.deletionType, ")");
    }
}
