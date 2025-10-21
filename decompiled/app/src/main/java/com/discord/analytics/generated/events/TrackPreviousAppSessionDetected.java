package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackPreviousAppSessionDetected.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackPreviousAppSessionDetected implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence deviceMemoryState = null;
    private final Boolean wasConnectedToVoice = null;
    private final Boolean wasAppBackgrounded = null;
    private final transient String analyticsSchemaTypeName = "previous_app_session_detected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPreviousAppSessionDetected)) {
            return false;
        }
        TrackPreviousAppSessionDetected trackPreviousAppSessionDetected = (TrackPreviousAppSessionDetected) other;
        return Intrinsics3.areEqual(this.deviceMemoryState, trackPreviousAppSessionDetected.deviceMemoryState) && Intrinsics3.areEqual(this.wasConnectedToVoice, trackPreviousAppSessionDetected.wasConnectedToVoice) && Intrinsics3.areEqual(this.wasAppBackgrounded, trackPreviousAppSessionDetected.wasAppBackgrounded);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceMemoryState;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.wasConnectedToVoice;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.wasAppBackgrounded;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPreviousAppSessionDetected(deviceMemoryState=");
        sbU.append(this.deviceMemoryState);
        sbU.append(", wasConnectedToVoice=");
        sbU.append(this.wasConnectedToVoice);
        sbU.append(", wasAppBackgrounded=");
        return outline.D(sbU, this.wasAppBackgrounded, ")");
    }
}
