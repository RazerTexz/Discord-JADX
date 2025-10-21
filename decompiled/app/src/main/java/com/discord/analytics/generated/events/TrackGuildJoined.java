package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackGuildJoined.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildJoined implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence joinMethod = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long guildOwnerId = null;
    private final Long userGuilds = null;
    private final CharSequence joinType = null;
    private final CharSequence source = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final Long inviteGuildScheduledEventId = null;
    private final Long postableChannels = null;
    private final CharSequence recommendationLoadId = null;
    private final Long accessibleTextChannels = null;
    private final Long accessibleVoiceChannels = null;
    private final Long accessibleStageChannels = null;
    private final transient String analyticsSchemaTypeName = "guild_joined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildJoined)) {
            return false;
        }
        TrackGuildJoined trackGuildJoined = (TrackGuildJoined) other;
        return Intrinsics3.areEqual(this.joinMethod, trackGuildJoined.joinMethod) && Intrinsics3.areEqual(this.applicationId, trackGuildJoined.applicationId) && Intrinsics3.areEqual(this.botId, trackGuildJoined.botId) && Intrinsics3.areEqual(this.guildId, trackGuildJoined.guildId) && Intrinsics3.areEqual(this.guildName, trackGuildJoined.guildName) && Intrinsics3.areEqual(this.guildOwnerId, trackGuildJoined.guildOwnerId) && Intrinsics3.areEqual(this.userGuilds, trackGuildJoined.userGuilds) && Intrinsics3.areEqual(this.joinType, trackGuildJoined.joinType) && Intrinsics3.areEqual(this.source, trackGuildJoined.source) && Intrinsics3.areEqual(this.locationGuildId, trackGuildJoined.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackGuildJoined.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackGuildJoined.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackGuildJoined.locationMessageId) && Intrinsics3.areEqual(this.inviteGuildScheduledEventId, trackGuildJoined.inviteGuildScheduledEventId) && Intrinsics3.areEqual(this.postableChannels, trackGuildJoined.postableChannels) && Intrinsics3.areEqual(this.recommendationLoadId, trackGuildJoined.recommendationLoadId) && Intrinsics3.areEqual(this.accessibleTextChannels, trackGuildJoined.accessibleTextChannels) && Intrinsics3.areEqual(this.accessibleVoiceChannels, trackGuildJoined.accessibleVoiceChannels) && Intrinsics3.areEqual(this.accessibleStageChannels, trackGuildJoined.accessibleStageChannels);
    }

    public int hashCode() {
        CharSequence charSequence = this.joinMethod;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.botId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.guildOwnerId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.userGuilds;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.joinType;
        int iHashCode8 = (iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.source;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l6 = this.locationGuildId;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.locationChannelId;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.locationChannelType;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.locationMessageId;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.inviteGuildScheduledEventId;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.postableChannels;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.recommendationLoadId;
        int iHashCode16 = (iHashCode15 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l12 = this.accessibleTextChannels;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.accessibleVoiceChannels;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.accessibleStageChannels;
        return iHashCode18 + (l14 != null ? l14.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildJoined(joinMethod=");
        sbU.append(this.joinMethod);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildOwnerId=");
        sbU.append(this.guildOwnerId);
        sbU.append(", userGuilds=");
        sbU.append(this.userGuilds);
        sbU.append(", joinType=");
        sbU.append(this.joinType);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        sbU.append(this.locationMessageId);
        sbU.append(", inviteGuildScheduledEventId=");
        sbU.append(this.inviteGuildScheduledEventId);
        sbU.append(", postableChannels=");
        sbU.append(this.postableChannels);
        sbU.append(", recommendationLoadId=");
        sbU.append(this.recommendationLoadId);
        sbU.append(", accessibleTextChannels=");
        sbU.append(this.accessibleTextChannels);
        sbU.append(", accessibleVoiceChannels=");
        sbU.append(this.accessibleVoiceChannels);
        sbU.append(", accessibleStageChannels=");
        return outline.G(sbU, this.accessibleStageChannels, ")");
    }
}
