package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAppExternalViewClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppExternalViewClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final Long durationOpenMs = null;
    private final transient String analyticsSchemaTypeName = "app_external_view_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppExternalViewClosed)) {
            return false;
        }
        TrackAppExternalViewClosed trackAppExternalViewClosed = (TrackAppExternalViewClosed) other;
        return Intrinsics3.areEqual(this.type, trackAppExternalViewClosed.type) && Intrinsics3.areEqual(this.durationOpenMs, trackAppExternalViewClosed.durationOpenMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationOpenMs;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAppExternalViewClosed(type=");
        sbM833U.append(this.type);
        sbM833U.append(", durationOpenMs=");
        return outline.m819G(sbM833U, this.durationOpenMs, ")");
    }
}
