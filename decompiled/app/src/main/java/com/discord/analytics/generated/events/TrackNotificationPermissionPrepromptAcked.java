package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackNotificationPermissionPrepromptAcked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationPermissionPrepromptAcked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence actionType = null;
    private final CharSequence actionLocation = null;
    private final Boolean permissionGranted = null;
    private final transient String analyticsSchemaTypeName = "notification_permission_preprompt_acked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationPermissionPrepromptAcked)) {
            return false;
        }
        TrackNotificationPermissionPrepromptAcked trackNotificationPermissionPrepromptAcked = (TrackNotificationPermissionPrepromptAcked) other;
        return Intrinsics3.areEqual(this.actionType, trackNotificationPermissionPrepromptAcked.actionType) && Intrinsics3.areEqual(this.actionLocation, trackNotificationPermissionPrepromptAcked.actionLocation) && Intrinsics3.areEqual(this.permissionGranted, trackNotificationPermissionPrepromptAcked.permissionGranted);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.actionLocation;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.permissionGranted;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNotificationPermissionPrepromptAcked(actionType=");
        sbM833U.append(this.actionType);
        sbM833U.append(", actionLocation=");
        sbM833U.append(this.actionLocation);
        sbM833U.append(", permissionGranted=");
        return outline.m816D(sbM833U, this.permissionGranted, ")");
    }
}
