package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackLfgBrowserViewed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLfgBrowserViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long gameId = null;
    private final CharSequence gameName = null;
    private final Boolean isRefresh = null;
    private final Long numGroups = null;
    private final transient String analyticsSchemaTypeName = "lfg_browser_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgBrowserViewed)) {
            return false;
        }
        TrackLfgBrowserViewed trackLfgBrowserViewed = (TrackLfgBrowserViewed) other;
        return Intrinsics3.areEqual(this.gameId, trackLfgBrowserViewed.gameId) && Intrinsics3.areEqual(this.gameName, trackLfgBrowserViewed.gameName) && Intrinsics3.areEqual(this.isRefresh, trackLfgBrowserViewed.isRefresh) && Intrinsics3.areEqual(this.numGroups, trackLfgBrowserViewed.numGroups);
    }

    public int hashCode() {
        Long l = this.gameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isRefresh;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.numGroups;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackLfgBrowserViewed(gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", isRefresh=");
        sbM833U.append(this.isRefresh);
        sbM833U.append(", numGroups=");
        return outline.m819G(sbM833U, this.numGroups, ")");
    }
}
