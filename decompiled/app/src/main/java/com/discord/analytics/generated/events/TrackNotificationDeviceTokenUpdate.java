package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackNotificationDeviceTokenUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationDeviceTokenUpdate implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence provider = null;
    private final CharSequence token = null;
    private final CharSequence type = null;
    private final CharSequence pushToken = null;
    private final transient String analyticsSchemaTypeName = "notification_device_token_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationDeviceTokenUpdate)) {
            return false;
        }
        TrackNotificationDeviceTokenUpdate trackNotificationDeviceTokenUpdate = (TrackNotificationDeviceTokenUpdate) other;
        return Intrinsics3.areEqual(this.provider, trackNotificationDeviceTokenUpdate.provider) && Intrinsics3.areEqual(this.token, trackNotificationDeviceTokenUpdate.token) && Intrinsics3.areEqual(this.type, trackNotificationDeviceTokenUpdate.type) && Intrinsics3.areEqual(this.pushToken, trackNotificationDeviceTokenUpdate.pushToken);
    }

    public int hashCode() {
        CharSequence charSequence = this.provider;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.token;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.type;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.pushToken;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNotificationDeviceTokenUpdate(provider=");
        sbM833U.append(this.provider);
        sbM833U.append(", token=");
        sbM833U.append(this.token);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", pushToken=");
        return outline.m817E(sbM833U, this.pushToken, ")");
    }
}
