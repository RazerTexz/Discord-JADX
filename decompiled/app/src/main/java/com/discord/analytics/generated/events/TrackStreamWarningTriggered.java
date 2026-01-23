package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackStreamWarningTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamWarningTriggered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence noticeType = null;
    private final Long streamerUserId = null;
    private final Long streamChannelId = null;
    private final CharSequence streamRegion = null;
    private final CharSequence guildRegion = null;
    private final Boolean videoEnabled = null;
    private final CharSequence applicationName = null;
    private final Long applicationId = null;
    private final CharSequence videoLayout = null;
    private final CharSequence mediaSessionId = null;
    private final transient String analyticsSchemaTypeName = "stream_warning_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamWarningTriggered)) {
            return false;
        }
        TrackStreamWarningTriggered trackStreamWarningTriggered = (TrackStreamWarningTriggered) other;
        return Intrinsics3.areEqual(this.noticeType, trackStreamWarningTriggered.noticeType) && Intrinsics3.areEqual(this.streamerUserId, trackStreamWarningTriggered.streamerUserId) && Intrinsics3.areEqual(this.streamChannelId, trackStreamWarningTriggered.streamChannelId) && Intrinsics3.areEqual(this.streamRegion, trackStreamWarningTriggered.streamRegion) && Intrinsics3.areEqual(this.guildRegion, trackStreamWarningTriggered.guildRegion) && Intrinsics3.areEqual(this.videoEnabled, trackStreamWarningTriggered.videoEnabled) && Intrinsics3.areEqual(this.applicationName, trackStreamWarningTriggered.applicationName) && Intrinsics3.areEqual(this.applicationId, trackStreamWarningTriggered.applicationId) && Intrinsics3.areEqual(this.videoLayout, trackStreamWarningTriggered.videoLayout) && Intrinsics3.areEqual(this.mediaSessionId, trackStreamWarningTriggered.mediaSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.streamerUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.streamChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.streamRegion;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.guildRegion;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.applicationName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.videoLayout;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.mediaSessionId;
        return iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackStreamWarningTriggered(noticeType=");
        sbM833U.append(this.noticeType);
        sbM833U.append(", streamerUserId=");
        sbM833U.append(this.streamerUserId);
        sbM833U.append(", streamChannelId=");
        sbM833U.append(this.streamChannelId);
        sbM833U.append(", streamRegion=");
        sbM833U.append(this.streamRegion);
        sbM833U.append(", guildRegion=");
        sbM833U.append(this.guildRegion);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", videoLayout=");
        sbM833U.append(this.videoLayout);
        sbM833U.append(", mediaSessionId=");
        return outline.m817E(sbM833U, this.mediaSessionId, ")");
    }
}
