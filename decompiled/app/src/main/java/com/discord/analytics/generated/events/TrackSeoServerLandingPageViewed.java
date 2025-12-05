package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSeoServerLandingPageViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSeoServerLandingPageViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence slug = null;
    private final transient String analyticsSchemaTypeName = "seo_server_landing_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSeoServerLandingPageViewed)) {
            return false;
        }
        TrackSeoServerLandingPageViewed trackSeoServerLandingPageViewed = (TrackSeoServerLandingPageViewed) other;
        return Intrinsics3.areEqual(this.guildId, trackSeoServerLandingPageViewed.guildId) && Intrinsics3.areEqual(this.guildName, trackSeoServerLandingPageViewed.guildName) && Intrinsics3.areEqual(this.slug, trackSeoServerLandingPageViewed.slug);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.slug;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSeoServerLandingPageViewed(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", slug=");
        return outline.m817E(sbM833U, this.slug, ")");
    }
}
