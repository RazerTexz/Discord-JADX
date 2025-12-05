package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackActivityReportDontShow.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackActivityReportDontShow implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final CharSequence rating = null;
    private final transient String analyticsSchemaTypeName = "activity_report_dont_show";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityReportDontShow)) {
            return false;
        }
        TrackActivityReportDontShow trackActivityReportDontShow = (TrackActivityReportDontShow) other;
        return Intrinsics3.areEqual(this.applicationId, trackActivityReportDontShow.applicationId) && Intrinsics3.areEqual(this.rating, trackActivityReportDontShow.rating);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.rating;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActivityReportDontShow(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", rating=");
        return outline.m817E(sbM833U, this.rating, ")");
    }
}
