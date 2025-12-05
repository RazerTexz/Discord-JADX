package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackOverlayHooked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayHooked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence nonce = null;
    private final CharSequence graphicsApi = null;
    private final transient String analyticsSchemaTypeName = "overlay_hooked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayHooked)) {
            return false;
        }
        TrackOverlayHooked trackOverlayHooked = (TrackOverlayHooked) other;
        return Intrinsics3.areEqual(this.nonce, trackOverlayHooked.nonce) && Intrinsics3.areEqual(this.graphicsApi, trackOverlayHooked.graphicsApi);
    }

    public int hashCode() {
        CharSequence charSequence = this.nonce;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.graphicsApi;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackOverlayHooked(nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", graphicsApi=");
        return outline.m817E(sbM833U, this.graphicsApi, ")");
    }
}
