package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackVideoInputInitialized.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVideoInputInitialized implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceName = null;
    private final Long timeToFirstFrameMs = null;
    private final Boolean timedOut = null;
    private final Float activity = null;
    private final transient String analyticsSchemaTypeName = "video_input_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoInputInitialized)) {
            return false;
        }
        TrackVideoInputInitialized trackVideoInputInitialized = (TrackVideoInputInitialized) other;
        return Intrinsics3.areEqual(this.deviceName, trackVideoInputInitialized.deviceName) && Intrinsics3.areEqual(this.timeToFirstFrameMs, trackVideoInputInitialized.timeToFirstFrameMs) && Intrinsics3.areEqual(this.timedOut, trackVideoInputInitialized.timedOut) && Intrinsics3.areEqual(this.activity, trackVideoInputInitialized.activity);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.timeToFirstFrameMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.timedOut;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Float f = this.activity;
        return iHashCode3 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoInputInitialized(deviceName=");
        sbU.append(this.deviceName);
        sbU.append(", timeToFirstFrameMs=");
        sbU.append(this.timeToFirstFrameMs);
        sbU.append(", timedOut=");
        sbU.append(this.timedOut);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
