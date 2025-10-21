package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackChangeLogCtaClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackChangeLogCtaClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence changeLogId = null;
    private final Float secondsOpen = null;
    private final Float maxScrolledPercentage = null;
    private final CharSequence ctaType = null;
    private final CharSequence target = null;
    private final transient String analyticsSchemaTypeName = "change_log_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChangeLogCtaClicked)) {
            return false;
        }
        TrackChangeLogCtaClicked trackChangeLogCtaClicked = (TrackChangeLogCtaClicked) other;
        return Intrinsics3.areEqual(this.changeLogId, trackChangeLogCtaClicked.changeLogId) && Intrinsics3.areEqual(this.secondsOpen, trackChangeLogCtaClicked.secondsOpen) && Intrinsics3.areEqual(this.maxScrolledPercentage, trackChangeLogCtaClicked.maxScrolledPercentage) && Intrinsics3.areEqual(this.ctaType, trackChangeLogCtaClicked.ctaType) && Intrinsics3.areEqual(this.target, trackChangeLogCtaClicked.target);
    }

    public int hashCode() {
        CharSequence charSequence = this.changeLogId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Float f = this.secondsOpen;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.maxScrolledPercentage;
        int iHashCode3 = (iHashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.ctaType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.target;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChangeLogCtaClicked(changeLogId=");
        sbU.append(this.changeLogId);
        sbU.append(", secondsOpen=");
        sbU.append(this.secondsOpen);
        sbU.append(", maxScrolledPercentage=");
        sbU.append(this.maxScrolledPercentage);
        sbU.append(", ctaType=");
        sbU.append(this.ctaType);
        sbU.append(", target=");
        return outline.E(sbU, this.target, ")");
    }
}
