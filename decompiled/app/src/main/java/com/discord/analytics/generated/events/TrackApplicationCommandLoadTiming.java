package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackApplicationCommandLoadTiming.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandLoadTiming implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long durationMs = null;
    private final CharSequence method = null;
    private final CharSequence area = null;
    private final transient String analyticsSchemaTypeName = "application_command_load_timing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationCommandLoadTiming)) {
            return false;
        }
        TrackApplicationCommandLoadTiming trackApplicationCommandLoadTiming = (TrackApplicationCommandLoadTiming) other;
        return Intrinsics3.areEqual(this.durationMs, trackApplicationCommandLoadTiming.durationMs) && Intrinsics3.areEqual(this.method, trackApplicationCommandLoadTiming.method) && Intrinsics3.areEqual(this.area, trackApplicationCommandLoadTiming.area);
    }

    public int hashCode() {
        Long l = this.durationMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.method;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.area;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationCommandLoadTiming(durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", method=");
        sbU.append(this.method);
        sbU.append(", area=");
        return outline.E(sbU, this.area, ")");
    }
}
