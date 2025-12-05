package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDevPortalSurveyNoticeClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDevPortalSurveyNoticeClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence noticeName = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_survey_notice_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDevPortalSurveyNoticeClicked) && Intrinsics3.areEqual(this.noticeName, ((TrackDevPortalSurveyNoticeClicked) other).noticeName);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeName;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackDevPortalSurveyNoticeClicked(noticeName="), this.noticeName, ")");
    }
}
