package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackAppCrashed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAppCrashed implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence path = null;
    private final CharSequence extra = null;
    private final transient String analyticsSchemaTypeName = "app_crashed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppCrashed)) {
            return false;
        }
        TrackAppCrashed trackAppCrashed = (TrackAppCrashed) other;
        return Intrinsics3.areEqual(this.path, trackAppCrashed.path) && Intrinsics3.areEqual(this.extra, trackAppCrashed.extra);
    }

    public int hashCode() {
        CharSequence charSequence = this.path;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.extra;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAppCrashed(path=");
        sbM833U.append(this.path);
        sbM833U.append(", extra=");
        return outline.m817E(sbM833U, this.extra, ")");
    }
}
