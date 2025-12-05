package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackVoiceAudioOutputModeEnabled.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackVoiceAudioOutputModeEnabled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence fromAudioOutputMode = null;
    private final CharSequence toAudioOutputMode = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "voice_audio_output_mode_enabled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceAudioOutputModeEnabled)) {
            return false;
        }
        TrackVoiceAudioOutputModeEnabled trackVoiceAudioOutputModeEnabled = (TrackVoiceAudioOutputModeEnabled) other;
        return Intrinsics3.areEqual(this.channelId, trackVoiceAudioOutputModeEnabled.channelId) && Intrinsics3.areEqual(this.channelType, trackVoiceAudioOutputModeEnabled.channelType) && Intrinsics3.areEqual(this.guildId, trackVoiceAudioOutputModeEnabled.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVoiceAudioOutputModeEnabled.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVoiceAudioOutputModeEnabled.mediaSessionId) && Intrinsics3.areEqual(this.fromAudioOutputMode, trackVoiceAudioOutputModeEnabled.fromAudioOutputMode) && Intrinsics3.areEqual(this.toAudioOutputMode, trackVoiceAudioOutputModeEnabled.toAudioOutputMode) && Intrinsics3.areEqual(this.videoStreamCount, trackVoiceAudioOutputModeEnabled.videoStreamCount) && Intrinsics3.areEqual(this.voiceStateCount, trackVoiceAudioOutputModeEnabled.voiceStateCount);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.fromAudioOutputMode;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.toAudioOutputMode;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.videoStreamCount;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        return iHashCode8 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackVoiceAudioOutputModeEnabled(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", fromAudioOutputMode=");
        sbM833U.append(this.fromAudioOutputMode);
        sbM833U.append(", toAudioOutputMode=");
        sbM833U.append(this.toAudioOutputMode);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", voiceStateCount=");
        return outline.m819G(sbM833U, this.voiceStateCount, ")");
    }
}
