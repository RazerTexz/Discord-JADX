package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackPremiumMarketingPageViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPremiumMarketingPageViewed implements AnalyticsSchema, TrackBase2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence loadId = null;
    private final transient String analyticsSchemaTypeName = "premium_marketing_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPremiumMarketingPageViewed) && Intrinsics3.areEqual(this.loadId, ((TrackPremiumMarketingPageViewed) other).loadId);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackPremiumMarketingPageViewed(loadId="), this.loadId, ")");
    }
}
