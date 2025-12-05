package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackEnableNotifications.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackEnableNotifications implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "enable_notifications";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEnableNotifications)) {
            return false;
        }
        TrackEnableNotifications trackEnableNotifications = (TrackEnableNotifications) other;
        return Intrinsics3.areEqual(this.enabled, trackEnableNotifications.enabled) && Intrinsics3.areEqual(this.source, trackEnableNotifications.source);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.source;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackEnableNotifications(enabled=");
        sbM833U.append(this.enabled);
        sbM833U.append(", source=");
        return outline.m817E(sbM833U, this.source, ")");
    }
}
