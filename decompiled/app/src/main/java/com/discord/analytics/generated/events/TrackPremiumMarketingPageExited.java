package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackPremiumMarketingPageExited.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumMarketingPageExited implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final List<Long> applicationIdsViewed = null;
    private final List<Long> skuIdsViewed = null;
    private final Long durationMs = null;
    private final transient String analyticsSchemaTypeName = "premium_marketing_page_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumMarketingPageExited)) {
            return false;
        }
        TrackPremiumMarketingPageExited trackPremiumMarketingPageExited = (TrackPremiumMarketingPageExited) other;
        return Intrinsics3.areEqual(this.loadId, trackPremiumMarketingPageExited.loadId) && Intrinsics3.areEqual(this.applicationIdsViewed, trackPremiumMarketingPageExited.applicationIdsViewed) && Intrinsics3.areEqual(this.skuIdsViewed, trackPremiumMarketingPageExited.skuIdsViewed) && Intrinsics3.areEqual(this.durationMs, trackPremiumMarketingPageExited.durationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.applicationIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.skuIdsViewed;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackPremiumMarketingPageExited(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", applicationIdsViewed=");
        sbM833U.append(this.applicationIdsViewed);
        sbM833U.append(", skuIdsViewed=");
        sbM833U.append(this.skuIdsViewed);
        sbM833U.append(", durationMs=");
        return outline.m819G(sbM833U, this.durationMs, ")");
    }
}
