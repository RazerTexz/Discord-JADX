package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackOverlayToggled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final CharSequence settingType = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "overlay_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayToggled)) {
            return false;
        }
        TrackOverlayToggled trackOverlayToggled = (TrackOverlayToggled) other;
        return Intrinsics3.areEqual(this.enabled, trackOverlayToggled.enabled) && Intrinsics3.areEqual(this.settingType, trackOverlayToggled.settingType) && Intrinsics3.areEqual(this.applicationId, trackOverlayToggled.applicationId) && Intrinsics3.areEqual(this.applicationName, trackOverlayToggled.applicationName);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.settingType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.applicationName;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayToggled(enabled=");
        sbU.append(this.enabled);
        sbU.append(", settingType=");
        sbU.append(this.settingType);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        return outline.E(sbU, this.applicationName, ")");
    }
}
