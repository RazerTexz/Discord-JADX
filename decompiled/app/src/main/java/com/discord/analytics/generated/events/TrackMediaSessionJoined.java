package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackMediaSessionJoined.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackMediaSessionJoined implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence context = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence parentMediaSessionId = null;
    private final Long channelType = null;
    private final CharSequence voiceBackendVersion = null;
    private final CharSequence rtcWorkerBackendVersion = null;
    private final transient String analyticsSchemaTypeName = "media_session_joined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMediaSessionJoined)) {
            return false;
        }
        TrackMediaSessionJoined trackMediaSessionJoined = (TrackMediaSessionJoined) other;
        return Intrinsics3.areEqual(this.channelId, trackMediaSessionJoined.channelId) && Intrinsics3.areEqual(this.guildId, trackMediaSessionJoined.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackMediaSessionJoined.rtcConnectionId) && Intrinsics3.areEqual(this.context, trackMediaSessionJoined.context) && Intrinsics3.areEqual(this.mediaSessionId, trackMediaSessionJoined.mediaSessionId) && Intrinsics3.areEqual(this.parentMediaSessionId, trackMediaSessionJoined.parentMediaSessionId) && Intrinsics3.areEqual(this.channelType, trackMediaSessionJoined.channelType) && Intrinsics3.areEqual(this.voiceBackendVersion, trackMediaSessionJoined.voiceBackendVersion) && Intrinsics3.areEqual(this.rtcWorkerBackendVersion, trackMediaSessionJoined.rtcWorkerBackendVersion);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.context;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.parentMediaSessionId;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.voiceBackendVersion;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.rtcWorkerBackendVersion;
        return iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMediaSessionJoined(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", parentMediaSessionId=");
        sbU.append(this.parentMediaSessionId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", voiceBackendVersion=");
        sbU.append(this.voiceBackendVersion);
        sbU.append(", rtcWorkerBackendVersion=");
        return outline.E(sbU, this.rtcWorkerBackendVersion, ")");
    }
}
