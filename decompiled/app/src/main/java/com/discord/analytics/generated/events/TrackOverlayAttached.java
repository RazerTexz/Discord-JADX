package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackOverlayAttached.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayAttached implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long attachStatus = null;
    private final CharSequence overlaySession = null;
    private final transient String analyticsSchemaTypeName = "overlay_attached";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayAttached)) {
            return false;
        }
        TrackOverlayAttached trackOverlayAttached = (TrackOverlayAttached) other;
        return Intrinsics3.areEqual(this.attachStatus, trackOverlayAttached.attachStatus) && Intrinsics3.areEqual(this.overlaySession, trackOverlayAttached.overlaySession);
    }

    public int hashCode() {
        Long l = this.attachStatus;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.overlaySession;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackOverlayAttached(attachStatus=");
        sbM833U.append(this.attachStatus);
        sbM833U.append(", overlaySession=");
        return outline.m817E(sbM833U, this.overlaySession, ")");
    }
}
