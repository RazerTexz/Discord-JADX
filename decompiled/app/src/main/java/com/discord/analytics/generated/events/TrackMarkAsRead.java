package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackMarkAsRead.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMarkAsRead implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence type = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "mark_as_read";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMarkAsRead)) {
            return false;
        }
        TrackMarkAsRead trackMarkAsRead = (TrackMarkAsRead) other;
        return Intrinsics3.areEqual(this.type, trackMarkAsRead.type) && Intrinsics3.areEqual(this.source, trackMarkAsRead.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMarkAsRead(type=");
        sbU.append(this.type);
        sbU.append(", source=");
        return outline.E(sbU, this.source, ")");
    }
}
