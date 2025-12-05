package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDevPortalPageViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDevPortalPageViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence pageName = null;
    private final CharSequence previousPageName = null;
    private final CharSequence previousLinkLocation = null;
    private final Boolean hasSession = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalPageViewed)) {
            return false;
        }
        TrackDevPortalPageViewed trackDevPortalPageViewed = (TrackDevPortalPageViewed) other;
        return Intrinsics3.areEqual(this.pageName, trackDevPortalPageViewed.pageName) && Intrinsics3.areEqual(this.previousPageName, trackDevPortalPageViewed.previousPageName) && Intrinsics3.areEqual(this.previousLinkLocation, trackDevPortalPageViewed.previousLinkLocation) && Intrinsics3.areEqual(this.hasSession, trackDevPortalPageViewed.hasSession) && Intrinsics3.areEqual(this.applicationId, trackDevPortalPageViewed.applicationId) && Intrinsics3.areEqual(this.botId, trackDevPortalPageViewed.botId) && Intrinsics3.areEqual(this.applicationName, trackDevPortalPageViewed.applicationName) && Intrinsics3.areEqual(this.hasBot, trackDevPortalPageViewed.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackDevPortalPageViewed.hasRedirectUri) && Intrinsics3.areEqual(this.guildId, trackDevPortalPageViewed.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousPageName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousLinkLocation;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.hasSession;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.botId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.applicationName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasBot;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasRedirectUri;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode9 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackDevPortalPageViewed(pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", previousPageName=");
        sbM833U.append(this.previousPageName);
        sbM833U.append(", previousLinkLocation=");
        sbM833U.append(this.previousLinkLocation);
        sbM833U.append(", hasSession=");
        sbM833U.append(this.hasSession);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", guildId=");
        return outline.m819G(sbM833U, this.guildId, ")");
    }
}
