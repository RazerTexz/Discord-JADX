package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackNudgeOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNudgeOpened implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long stickerId = null;
    private final transient String analyticsSchemaTypeName = "nudge_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNudgeOpened) && Intrinsics3.areEqual(this.stickerId, ((TrackNudgeOpened) other).stickerId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.stickerId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackNudgeOpened(stickerId="), this.stickerId, ")");
    }
}
