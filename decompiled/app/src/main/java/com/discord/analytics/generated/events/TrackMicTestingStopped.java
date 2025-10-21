package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackMicTestingStopped.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMicTestingStopped implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long testingDuration = null;
    private final transient String analyticsSchemaTypeName = "mic_testing_stopped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMicTestingStopped) && Intrinsics3.areEqual(this.testingDuration, ((TrackMicTestingStopped) other).testingDuration);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.testingDuration;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackMicTestingStopped(testingDuration="), this.testingDuration, ")");
    }
}
