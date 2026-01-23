package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackCreateChannel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateChannel implements AnalyticsSchema, TrackBase2, TrackLfgGroup2, TrackGuildLfgGroup2, TrackThread2 {
    private TrackBase trackBase;
    private TrackGuildLfgGroup trackGuildLfgGroup;
    private TrackLfgGroup trackLfgGroup;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long channelType = null;
    private final List<Long> recipientIds = null;
    private final Long originChannelId = null;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence channelName = null;
    private final Boolean isNsfw = null;
    private final Long parentId = null;
    private final Long starterMessageAgeMinutes = null;
    private final Long activeThreadCount = null;
    private final Long activeAnnouncementThreadCount = null;
    private final transient String analyticsSchemaTypeName = "create_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateChannel)) {
            return false;
        }
        TrackCreateChannel trackCreateChannel = (TrackCreateChannel) other;
        return Intrinsics3.areEqual(this.channelId, trackCreateChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackCreateChannel.channelType) && Intrinsics3.areEqual(this.recipientIds, trackCreateChannel.recipientIds) && Intrinsics3.areEqual(this.originChannelId, trackCreateChannel.originChannelId) && Intrinsics3.areEqual(this.guildId, trackCreateChannel.guildId) && Intrinsics3.areEqual(this.guildName, trackCreateChannel.guildName) && Intrinsics3.areEqual(this.channelName, trackCreateChannel.channelName) && Intrinsics3.areEqual(this.isNsfw, trackCreateChannel.isNsfw) && Intrinsics3.areEqual(this.parentId, trackCreateChannel.parentId) && Intrinsics3.areEqual(this.starterMessageAgeMinutes, trackCreateChannel.starterMessageAgeMinutes) && Intrinsics3.areEqual(this.activeThreadCount, trackCreateChannel.activeThreadCount) && Intrinsics3.areEqual(this.activeAnnouncementThreadCount, trackCreateChannel.activeAnnouncementThreadCount);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l3 = this.originChannelId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.channelName;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isNsfw;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l5 = this.parentId;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.starterMessageAgeMinutes;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.activeThreadCount;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.activeAnnouncementThreadCount;
        return iHashCode11 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackCreateChannel(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", recipientIds=");
        sbM833U.append(this.recipientIds);
        sbM833U.append(", originChannelId=");
        sbM833U.append(this.originChannelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", channelName=");
        sbM833U.append(this.channelName);
        sbM833U.append(", isNsfw=");
        sbM833U.append(this.isNsfw);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", starterMessageAgeMinutes=");
        sbM833U.append(this.starterMessageAgeMinutes);
        sbM833U.append(", activeThreadCount=");
        sbM833U.append(this.activeThreadCount);
        sbM833U.append(", activeAnnouncementThreadCount=");
        return outline.m819G(sbM833U, this.activeAnnouncementThreadCount, ")");
    }
}
