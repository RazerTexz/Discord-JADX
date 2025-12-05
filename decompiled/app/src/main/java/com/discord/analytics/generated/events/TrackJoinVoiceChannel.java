package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformation2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackJoinVoiceChannel.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackJoinVoiceChannel implements AnalyticsSchema, TrackBase2, TrackNetworkInformation2 {
    private TrackBase trackBase;
    private TrackNetworkInformation trackNetworkInformation;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long channelBitrate = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final CharSequence rtcConnectionId = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long gameId = null;
    private final Long customStatusCount = null;
    private final Long stageInstanceId = null;
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "join_voice_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinVoiceChannel)) {
            return false;
        }
        TrackJoinVoiceChannel trackJoinVoiceChannel = (TrackJoinVoiceChannel) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinVoiceChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackJoinVoiceChannel.channelType) && Intrinsics3.areEqual(this.channelBitrate, trackJoinVoiceChannel.channelBitrate) && Intrinsics3.areEqual(this.guildId, trackJoinVoiceChannel.guildId) && Intrinsics3.areEqual(this.nonce, trackJoinVoiceChannel.nonce) && Intrinsics3.areEqual(this.rtcConnectionId, trackJoinVoiceChannel.rtcConnectionId) && Intrinsics3.areEqual(this.voiceStateCount, trackJoinVoiceChannel.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackJoinVoiceChannel.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackJoinVoiceChannel.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackJoinVoiceChannel.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackJoinVoiceChannel.gamePlatform) && Intrinsics3.areEqual(this.gameId, trackJoinVoiceChannel.gameId) && Intrinsics3.areEqual(this.customStatusCount, trackJoinVoiceChannel.customStatusCount) && Intrinsics3.areEqual(this.stageInstanceId, trackJoinVoiceChannel.stageInstanceId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackJoinVoiceChannel.guildScheduledEventId);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelBitrate;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoStreamCount;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gamePlatform;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.gameId;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.customStatusCount;
        int iHashCode13 = (iHashCode12 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.stageInstanceId;
        int iHashCode14 = (iHashCode13 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.guildScheduledEventId;
        return iHashCode14 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackJoinVoiceChannel(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelBitrate=");
        sbM833U.append(this.channelBitrate);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", customStatusCount=");
        sbM833U.append(this.customStatusCount);
        sbM833U.append(", stageInstanceId=");
        sbM833U.append(this.stageInstanceId);
        sbM833U.append(", guildScheduledEventId=");
        return outline.m819G(sbM833U, this.guildScheduledEventId, ")");
    }
}
