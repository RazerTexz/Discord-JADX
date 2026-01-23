package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivitySessionJoined.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivitySessionJoined implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence activitySessionId = null;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "activity_session_joined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivitySessionJoined)) {
            return false;
        }
        TrackActivitySessionJoined trackActivitySessionJoined = (TrackActivitySessionJoined) other;
        return Intrinsics3.areEqual(this.channelId, trackActivitySessionJoined.channelId) && Intrinsics3.areEqual(this.guildId, trackActivitySessionJoined.guildId) && Intrinsics3.areEqual(this.mediaSessionId, trackActivitySessionJoined.mediaSessionId) && Intrinsics3.areEqual(this.activitySessionId, trackActivitySessionJoined.activitySessionId) && Intrinsics3.areEqual(this.applicationId, trackActivitySessionJoined.applicationId);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.activitySessionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackActivitySessionJoined(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", activitySessionId=");
        sbM833U.append(this.activitySessionId);
        sbM833U.append(", applicationId=");
        return outline.m819G(sbM833U, this.applicationId, ")");
    }
}
