package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackInfraApiHttpRequest.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackInfraApiHttpRequest implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long statusCode = null;
    private final Long count = null;
    private final transient String analyticsSchemaTypeName = "infra_api_http_request";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInfraApiHttpRequest)) {
            return false;
        }
        TrackInfraApiHttpRequest trackInfraApiHttpRequest = (TrackInfraApiHttpRequest) other;
        return Intrinsics3.areEqual(this.statusCode, trackInfraApiHttpRequest.statusCode) && Intrinsics3.areEqual(this.count, trackInfraApiHttpRequest.count);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.count;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackInfraApiHttpRequest(statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", count=");
        return outline.m819G(sbM833U, this.count, ")");
    }
}
