package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackNotifyStreamSettingUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNotifyStreamSettingUpdate implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean value = null;
    private final Boolean prechecked = null;
    private final transient String analyticsSchemaTypeName = "notify_stream_setting_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotifyStreamSettingUpdate)) {
            return false;
        }
        TrackNotifyStreamSettingUpdate trackNotifyStreamSettingUpdate = (TrackNotifyStreamSettingUpdate) other;
        return Intrinsics3.areEqual(this.value, trackNotifyStreamSettingUpdate.value) && Intrinsics3.areEqual(this.prechecked, trackNotifyStreamSettingUpdate.prechecked);
    }

    public int hashCode() {
        Boolean bool = this.value;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.prechecked;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotifyStreamSettingUpdate(value=");
        sbU.append(this.value);
        sbU.append(", prechecked=");
        return outline.D(sbU, this.prechecked, ")");
    }
}
