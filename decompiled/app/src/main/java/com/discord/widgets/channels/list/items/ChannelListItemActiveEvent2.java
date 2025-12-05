package com.discord.widgets.channels.list.items;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChannelListItemActiveEvent.kt */
/* renamed from: com.discord.widgets.channels.list.items.ChannelListItemActiveEventData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemActiveEvent2 {
    private final int audienceSize;
    private final boolean connected;
    private final Long eventId;
    private final boolean isSpeaker;
    private final GuildScheduledEventLocationInfo locationInfo;
    private final List<UserGuildMember> speakers;
    private final String topic;

    public ChannelListItemActiveEvent2(String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List<UserGuildMember> list, boolean z2, boolean z3, Long l) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
        Intrinsics3.checkNotNullParameter(list, "speakers");
        this.topic = str;
        this.locationInfo = guildScheduledEventLocationInfo;
        this.audienceSize = i;
        this.speakers = list;
        this.connected = z2;
        this.isSpeaker = z3;
        this.eventId = l;
    }

    public static /* synthetic */ ChannelListItemActiveEvent2 copy$default(ChannelListItemActiveEvent2 channelListItemActiveEvent2, String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List list, boolean z2, boolean z3, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelListItemActiveEvent2.topic;
        }
        if ((i2 & 2) != 0) {
            guildScheduledEventLocationInfo = channelListItemActiveEvent2.locationInfo;
        }
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
        if ((i2 & 4) != 0) {
            i = channelListItemActiveEvent2.audienceSize;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = channelListItemActiveEvent2.speakers;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            z2 = channelListItemActiveEvent2.connected;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            z3 = channelListItemActiveEvent2.isSpeaker;
        }
        boolean z5 = z3;
        if ((i2 & 64) != 0) {
            l = channelListItemActiveEvent2.eventId;
        }
        return channelListItemActiveEvent2.copy(str, guildScheduledEventLocationInfo2, i3, list2, z4, z5, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final List<UserGuildMember> component4() {
        return this.speakers;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsSpeaker() {
        return this.isSpeaker;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getEventId() {
        return this.eventId;
    }

    public final ChannelListItemActiveEvent2 copy(String topic, GuildScheduledEventLocationInfo locationInfo, int audienceSize, List<UserGuildMember> speakers, boolean connected, boolean isSpeaker, Long eventId) {
        Intrinsics3.checkNotNullParameter(locationInfo, "locationInfo");
        Intrinsics3.checkNotNullParameter(speakers, "speakers");
        return new ChannelListItemActiveEvent2(topic, locationInfo, audienceSize, speakers, connected, isSpeaker, eventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemActiveEvent2)) {
            return false;
        }
        ChannelListItemActiveEvent2 channelListItemActiveEvent2 = (ChannelListItemActiveEvent2) other;
        return Intrinsics3.areEqual(this.topic, channelListItemActiveEvent2.topic) && Intrinsics3.areEqual(this.locationInfo, channelListItemActiveEvent2.locationInfo) && this.audienceSize == channelListItemActiveEvent2.audienceSize && Intrinsics3.areEqual(this.speakers, channelListItemActiveEvent2.speakers) && this.connected == channelListItemActiveEvent2.connected && this.isSpeaker == channelListItemActiveEvent2.isSpeaker && Intrinsics3.areEqual(this.eventId, channelListItemActiveEvent2.eventId);
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final String getTopic() {
        return this.topic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.topic;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
        int iHashCode2 = (((iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        List<UserGuildMember> list = this.speakers;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.connected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.isSpeaker;
        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        Long l = this.eventId;
        return i3 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isSpeaker() {
        return this.isSpeaker;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChannelListItemActiveEventData(topic=");
        sbM833U.append(this.topic);
        sbM833U.append(", locationInfo=");
        sbM833U.append(this.locationInfo);
        sbM833U.append(", audienceSize=");
        sbM833U.append(this.audienceSize);
        sbM833U.append(", speakers=");
        sbM833U.append(this.speakers);
        sbM833U.append(", connected=");
        sbM833U.append(this.connected);
        sbM833U.append(", isSpeaker=");
        sbM833U.append(this.isSpeaker);
        sbM833U.append(", eventId=");
        return outline.m819G(sbM833U, this.eventId, ")");
    }
}
