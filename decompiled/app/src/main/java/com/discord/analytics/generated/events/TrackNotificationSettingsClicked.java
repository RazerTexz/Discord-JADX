package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackNotificationSettingsClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationSettingsClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence settingType = null;
    private final Long currentStatus = null;
    private final transient String analyticsSchemaTypeName = "notification_settings_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSettingsClicked)) {
            return false;
        }
        TrackNotificationSettingsClicked trackNotificationSettingsClicked = (TrackNotificationSettingsClicked) other;
        return Intrinsics3.areEqual(this.settingType, trackNotificationSettingsClicked.settingType) && Intrinsics3.areEqual(this.currentStatus, trackNotificationSettingsClicked.currentStatus);
    }

    public int hashCode() {
        CharSequence charSequence = this.settingType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.currentStatus;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNotificationSettingsClicked(settingType=");
        sbM833U.append(this.settingType);
        sbM833U.append(", currentStatus=");
        return outline.m819G(sbM833U, this.currentStatus, ")");
    }
}
