package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackLfgBrowserExited.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLfgBrowserExited implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long duration = null;
    private final Long numGroups = null;
    private final transient String analyticsSchemaTypeName = "lfg_browser_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgBrowserExited)) {
            return false;
        }
        TrackLfgBrowserExited trackLfgBrowserExited = (TrackLfgBrowserExited) other;
        return Intrinsics3.areEqual(this.duration, trackLfgBrowserExited.duration) && Intrinsics3.areEqual(this.numGroups, trackLfgBrowserExited.numGroups);
    }

    public int hashCode() {
        Long l = this.duration;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numGroups;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackLfgBrowserExited(duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", numGroups=");
        return outline.m819G(sbM833U, this.numGroups, ")");
    }
}
