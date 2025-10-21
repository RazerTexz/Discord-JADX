package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackVideoBackgroundDeleted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVideoBackgroundDeleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isAnimated = null;
    private final transient String analyticsSchemaTypeName = "video_background_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackVideoBackgroundDeleted) && Intrinsics3.areEqual(this.isAnimated, ((TrackVideoBackgroundDeleted) other).isAnimated);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.isAnimated;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackVideoBackgroundDeleted(isAnimated="), this.isAnimated, ")");
    }
}
