package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceProcessing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceProcessing implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Boolean noiseCancellerCpuOveruse = null;
    private final Long noiseCancellerError = null;
    private final Boolean noiseCancellation = null;
    private final Boolean echoCancellation = null;
    private final Boolean noiseSuppression = null;
    private final Boolean automaticGainControl = null;
    private final transient String analyticsSchemaTypeName = "voice_processing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceProcessing)) {
            return false;
        }
        TrackVoiceProcessing trackVoiceProcessing = (TrackVoiceProcessing) other;
        return Intrinsics3.areEqual(this.noiseCancellerCpuOveruse, trackVoiceProcessing.noiseCancellerCpuOveruse) && Intrinsics3.areEqual(this.noiseCancellerError, trackVoiceProcessing.noiseCancellerError) && Intrinsics3.areEqual(this.noiseCancellation, trackVoiceProcessing.noiseCancellation) && Intrinsics3.areEqual(this.echoCancellation, trackVoiceProcessing.echoCancellation) && Intrinsics3.areEqual(this.noiseSuppression, trackVoiceProcessing.noiseSuppression) && Intrinsics3.areEqual(this.automaticGainControl, trackVoiceProcessing.automaticGainControl);
    }

    public int hashCode() {
        Boolean bool = this.noiseCancellerCpuOveruse;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.noiseCancellerError;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.noiseCancellation;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.echoCancellation;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.noiseSuppression;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.automaticGainControl;
        return iHashCode5 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackVoiceProcessing(noiseCancellerCpuOveruse=");
        sbM833U.append(this.noiseCancellerCpuOveruse);
        sbM833U.append(", noiseCancellerError=");
        sbM833U.append(this.noiseCancellerError);
        sbM833U.append(", noiseCancellation=");
        sbM833U.append(this.noiseCancellation);
        sbM833U.append(", echoCancellation=");
        sbM833U.append(this.echoCancellation);
        sbM833U.append(", noiseSuppression=");
        sbM833U.append(this.noiseSuppression);
        sbM833U.append(", automaticGainControl=");
        return outline.m816D(sbM833U, this.automaticGainControl, ")");
    }
}
