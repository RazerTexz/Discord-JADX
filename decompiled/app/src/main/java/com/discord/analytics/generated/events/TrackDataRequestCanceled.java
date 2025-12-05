package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackDataRequestCanceled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDataRequestCanceled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long harvestId = null;
    private final transient String analyticsSchemaTypeName = "data_request_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDataRequestCanceled) && Intrinsics3.areEqual(this.harvestId, ((TrackDataRequestCanceled) other).harvestId);
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
        return outline.m819G(outline.m833U("TrackDataRequestCanceled(harvestId="), this.harvestId, ")");
    }
}
