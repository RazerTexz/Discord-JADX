package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAuthorizedAppGranted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAuthorizedAppGranted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "authorized_app_granted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAuthorizedAppGranted) && Intrinsics3.areEqual(this.applicationId, ((TrackAuthorizedAppGranted) other).applicationId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.applicationId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackAuthorizedAppGranted(applicationId="), this.applicationId, ")");
    }
}
