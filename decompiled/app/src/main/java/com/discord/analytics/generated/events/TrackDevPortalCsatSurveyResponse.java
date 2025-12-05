package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDevPortalCsatSurveyResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDevPortalCsatSurveyResponse implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence ctaName = null;
    private final Long csatResponse = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_csat_survey_response";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalCsatSurveyResponse)) {
            return false;
        }
        TrackDevPortalCsatSurveyResponse trackDevPortalCsatSurveyResponse = (TrackDevPortalCsatSurveyResponse) other;
        return Intrinsics3.areEqual(this.ctaName, trackDevPortalCsatSurveyResponse.ctaName) && Intrinsics3.areEqual(this.csatResponse, trackDevPortalCsatSurveyResponse.csatResponse);
    }

    public int hashCode() {
        CharSequence charSequence = this.ctaName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.csatResponse;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackDevPortalCsatSurveyResponse(ctaName=");
        sbM833U.append(this.ctaName);
        sbM833U.append(", csatResponse=");
        return outline.m819G(sbM833U, this.csatResponse, ")");
    }
}
