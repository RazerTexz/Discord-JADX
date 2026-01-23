package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackChangeLogClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChangeLogClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence changeLogId = null;
    private final Float secondsOpen = null;
    private final Float maxScrolledPercentage = null;
    private final transient String analyticsSchemaTypeName = "change_log_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChangeLogClosed)) {
            return false;
        }
        TrackChangeLogClosed trackChangeLogClosed = (TrackChangeLogClosed) other;
        return Intrinsics3.areEqual(this.changeLogId, trackChangeLogClosed.changeLogId) && Intrinsics3.areEqual(this.secondsOpen, trackChangeLogClosed.secondsOpen) && Intrinsics3.areEqual(this.maxScrolledPercentage, trackChangeLogClosed.maxScrolledPercentage);
    }

    public int hashCode() {
        CharSequence charSequence = this.changeLogId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Float f = this.secondsOpen;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.maxScrolledPercentage;
        return iHashCode2 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackChangeLogClosed(changeLogId=");
        sbM833U.append(this.changeLogId);
        sbM833U.append(", secondsOpen=");
        sbM833U.append(this.secondsOpen);
        sbM833U.append(", maxScrolledPercentage=");
        sbM833U.append(this.maxScrolledPercentage);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
