package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackDataRequestInitiated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDataRequestInitiated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long harvestId = null;
    private final transient String analyticsSchemaTypeName = "data_request_initiated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDataRequestInitiated) && Intrinsics3.areEqual(this.harvestId, ((TrackDataRequestInitiated) other).harvestId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.harvestId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackDataRequestInitiated(harvestId="), this.harvestId, ")");
    }
}
