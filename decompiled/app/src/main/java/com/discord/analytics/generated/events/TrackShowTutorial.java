package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackShowTutorial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackShowTutorial implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tutorial = null;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "show_tutorial";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackShowTutorial)) {
            return false;
        }
        TrackShowTutorial trackShowTutorial = (TrackShowTutorial) other;
        return Intrinsics3.areEqual(this.tutorial, trackShowTutorial.tutorial) && Intrinsics3.areEqual(this.applicationId, trackShowTutorial.applicationId);
    }

    public int hashCode() {
        CharSequence charSequence = this.tutorial;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackShowTutorial(tutorial=");
        sbM833U.append(this.tutorial);
        sbM833U.append(", applicationId=");
        return outline.m819G(sbM833U, this.applicationId, ")");
    }
}
