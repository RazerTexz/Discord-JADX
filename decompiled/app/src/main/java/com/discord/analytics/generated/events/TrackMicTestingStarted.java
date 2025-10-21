package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackMicTestingStarted.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMicTestingStarted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence inputDeviceName = null;
    private final Long inputDeviceVolume = null;
    private final CharSequence outputDeviceName = null;
    private final Long outputDeviceVolume = null;
    private final CharSequence inputMode = null;
    private final Boolean inputSensitivityIsAutomatic = null;
    private final Long inputSensitivityThreshold = null;
    private final transient String analyticsSchemaTypeName = "mic_testing_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMicTestingStarted)) {
            return false;
        }
        TrackMicTestingStarted trackMicTestingStarted = (TrackMicTestingStarted) other;
        return Intrinsics3.areEqual(this.inputDeviceName, trackMicTestingStarted.inputDeviceName) && Intrinsics3.areEqual(this.inputDeviceVolume, trackMicTestingStarted.inputDeviceVolume) && Intrinsics3.areEqual(this.outputDeviceName, trackMicTestingStarted.outputDeviceName) && Intrinsics3.areEqual(this.outputDeviceVolume, trackMicTestingStarted.outputDeviceVolume) && Intrinsics3.areEqual(this.inputMode, trackMicTestingStarted.inputMode) && Intrinsics3.areEqual(this.inputSensitivityIsAutomatic, trackMicTestingStarted.inputSensitivityIsAutomatic) && Intrinsics3.areEqual(this.inputSensitivityThreshold, trackMicTestingStarted.inputSensitivityThreshold);
    }

    public int hashCode() {
        CharSequence charSequence = this.inputDeviceName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.inputDeviceVolume;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.outputDeviceName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.outputDeviceVolume;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.inputMode;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.inputSensitivityIsAutomatic;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.inputSensitivityThreshold;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMicTestingStarted(inputDeviceName=");
        sbU.append(this.inputDeviceName);
        sbU.append(", inputDeviceVolume=");
        sbU.append(this.inputDeviceVolume);
        sbU.append(", outputDeviceName=");
        sbU.append(this.outputDeviceName);
        sbU.append(", outputDeviceVolume=");
        sbU.append(this.outputDeviceVolume);
        sbU.append(", inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", inputSensitivityIsAutomatic=");
        sbU.append(this.inputSensitivityIsAutomatic);
        sbU.append(", inputSensitivityThreshold=");
        return outline.G(sbU, this.inputSensitivityThreshold, ")");
    }
}
