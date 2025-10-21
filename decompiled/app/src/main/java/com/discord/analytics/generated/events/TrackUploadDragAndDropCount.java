package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackUploadDragAndDropCount.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUploadDragAndDropCount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long count = null;
    private final transient String analyticsSchemaTypeName = "upload_drag_and_drop_count";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackUploadDragAndDropCount) && Intrinsics3.areEqual(this.count, ((TrackUploadDragAndDropCount) other).count);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.count;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackUploadDragAndDropCount(count="), this.count, ")");
    }
}
