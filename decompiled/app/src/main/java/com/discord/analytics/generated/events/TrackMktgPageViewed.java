package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackMktgPageViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMktgPageViewed implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence pageName = null;
    private final CharSequence previousPageName = null;
    private final CharSequence previousLinkLocation = null;
    private final CharSequence queryReferrer = null;
    private final Boolean hasSession = null;
    private final CharSequence staticExperimentUuid = null;
    private final transient String analyticsSchemaTypeName = "mktg_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMktgPageViewed)) {
            return false;
        }
        TrackMktgPageViewed trackMktgPageViewed = (TrackMktgPageViewed) other;
        return Intrinsics3.areEqual(this.pageName, trackMktgPageViewed.pageName) && Intrinsics3.areEqual(this.previousPageName, trackMktgPageViewed.previousPageName) && Intrinsics3.areEqual(this.previousLinkLocation, trackMktgPageViewed.previousLinkLocation) && Intrinsics3.areEqual(this.queryReferrer, trackMktgPageViewed.queryReferrer) && Intrinsics3.areEqual(this.hasSession, trackMktgPageViewed.hasSession) && Intrinsics3.areEqual(this.staticExperimentUuid, trackMktgPageViewed.staticExperimentUuid);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousPageName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousLinkLocation;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.queryReferrer;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.hasSession;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.staticExperimentUuid;
        return iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMktgPageViewed(pageName=");
        sbU.append(this.pageName);
        sbU.append(", previousPageName=");
        sbU.append(this.previousPageName);
        sbU.append(", previousLinkLocation=");
        sbU.append(this.previousLinkLocation);
        sbU.append(", queryReferrer=");
        sbU.append(this.queryReferrer);
        sbU.append(", hasSession=");
        sbU.append(this.hasSession);
        sbU.append(", staticExperimentUuid=");
        return outline.E(sbU, this.staticExperimentUuid, ")");
    }
}
