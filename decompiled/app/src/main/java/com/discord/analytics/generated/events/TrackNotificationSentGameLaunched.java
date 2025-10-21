package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackNotificationSentGameLaunched.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationSentGameLaunched implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long launchingUserId = null;
    private final CharSequence gameName = null;
    private final Boolean desktop = null;
    private final Boolean mobile = null;
    private final transient String analyticsSchemaTypeName = "notification_sent_game_launched";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSentGameLaunched)) {
            return false;
        }
        TrackNotificationSentGameLaunched trackNotificationSentGameLaunched = (TrackNotificationSentGameLaunched) other;
        return Intrinsics3.areEqual(this.launchingUserId, trackNotificationSentGameLaunched.launchingUserId) && Intrinsics3.areEqual(this.gameName, trackNotificationSentGameLaunched.gameName) && Intrinsics3.areEqual(this.desktop, trackNotificationSentGameLaunched.desktop) && Intrinsics3.areEqual(this.mobile, trackNotificationSentGameLaunched.mobile);
    }

    public int hashCode() {
        Long l = this.launchingUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.desktop;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.mobile;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationSentGameLaunched(launchingUserId=");
        sbU.append(this.launchingUserId);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", desktop=");
        sbU.append(this.desktop);
        sbU.append(", mobile=");
        return outline.D(sbU, this.mobile, ")");
    }
}
