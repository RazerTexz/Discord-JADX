package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAnalyticsOttEventTracked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAnalyticsOttEventTracked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence kpi = null;
    private final CharSequence fpc = null;
    private final CharSequence pip = null;
    private final transient String analyticsSchemaTypeName = "analytics_ott_event_tracked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAnalyticsOttEventTracked)) {
            return false;
        }
        TrackAnalyticsOttEventTracked trackAnalyticsOttEventTracked = (TrackAnalyticsOttEventTracked) other;
        return Intrinsics3.areEqual(this.kpi, trackAnalyticsOttEventTracked.kpi) && Intrinsics3.areEqual(this.fpc, trackAnalyticsOttEventTracked.fpc) && Intrinsics3.areEqual(this.pip, trackAnalyticsOttEventTracked.pip);
    }

    public int hashCode() {
        CharSequence charSequence = this.kpi;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fpc;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.pip;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAnalyticsOttEventTracked(kpi=");
        sbM833U.append(this.kpi);
        sbM833U.append(", fpc=");
        sbM833U.append(this.fpc);
        sbM833U.append(", pip=");
        return outline.m817E(sbM833U, this.pip, ")");
    }
}
