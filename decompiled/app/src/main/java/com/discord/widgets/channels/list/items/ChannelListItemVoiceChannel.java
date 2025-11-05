package com.discord.widgets.channels.list.items;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.m;

/* compiled from: ChannelListItemVoiceChannel.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemVoiceChannel implements ChannelListItem, ChannelListVocalItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final GuildMaxVideoChannelUsers guildMaxVideoChannelUsers;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyoneUsingVideo;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final boolean isNsfw;
    private final boolean isUnread;
    private final String key;
    private final int mentionCount;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean textSelected;
    private final int type;
    private final boolean voiceSelected;

    public ChannelListItemVoiceChannel(Channel channel, boolean z2, boolean z3, Long l, int i, boolean z4, int i2, boolean z5, boolean z6, boolean z7, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean z8, boolean z9, GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        this.channel = channel;
        this.textSelected = z2;
        this.voiceSelected = z3;
        this.permission = l;
        this.mentionCount = i;
        this.isUnread = z4;
        this.numUsersConnected = i2;
        this.isLocked = z5;
        this.isNsfw = z6;
        this.isAnyoneUsingVideo = z7;
        this.guildMaxVideoChannelUsers = guildMaxVideoChannelUsers;
        this.isGuildRoleSubscriptionLockedChannel = z8;
        this.isGuildRoleSubscriptionChannel = z9;
        this.guildScheduledEvent = guildScheduledEvent;
        this.type = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getChannel().getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemVoiceChannel copy$default(ChannelListItemVoiceChannel channelListItemVoiceChannel, Channel channel, boolean z2, boolean z3, Long l, int i, boolean z4, int i2, boolean z5, boolean z6, boolean z7, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean z8, boolean z9, GuildScheduledEvent guildScheduledEvent, int i3, Object obj) {
        return channelListItemVoiceChannel.copy((i3 & 1) != 0 ? channelListItemVoiceChannel.getChannel() : channel, (i3 & 2) != 0 ? channelListItemVoiceChannel.textSelected : z2, (i3 & 4) != 0 ? channelListItemVoiceChannel.voiceSelected : z3, (i3 & 8) != 0 ? channelListItemVoiceChannel.permission : l, (i3 & 16) != 0 ? channelListItemVoiceChannel.getMentionCount() : i, (i3 & 32) != 0 ? channelListItemVoiceChannel.getIsUnread() : z4, (i3 & 64) != 0 ? channelListItemVoiceChannel.getNumUsersConnected() : i2, (i3 & 128) != 0 ? channelListItemVoiceChannel.isLocked : z5, (i3 & 256) != 0 ? channelListItemVoiceChannel.isNsfw : z6, (i3 & 512) != 0 ? channelListItemVoiceChannel.isAnyoneUsingVideo : z7, (i3 & 1024) != 0 ? channelListItemVoiceChannel.guildMaxVideoChannelUsers : guildMaxVideoChannelUsers, (i3 & 2048) != 0 ? channelListItemVoiceChannel.isGuildRoleSubscriptionLockedChannel : z8, (i3 & 4096) != 0 ? channelListItemVoiceChannel.isGuildRoleSubscriptionChannel : z9, (i3 & 8192) != 0 ? channelListItemVoiceChannel.guildScheduledEvent : guildScheduledEvent);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    /* renamed from: component14, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getTextSelected() {
        return this.textSelected;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getVoiceSelected() {
        return this.voiceSelected;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    public final int component5() {
        return getMentionCount();
    }

    public final boolean component6() {
        return getIsUnread();
    }

    public final int component7() {
        return getNumUsersConnected();
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsNsfw() {
        return this.isNsfw;
    }

    public final ChannelListItemVoiceChannel copy(Channel channel, boolean textSelected, boolean voiceSelected, Long permission, int mentionCount, boolean isUnread, int numUsersConnected, boolean isLocked, boolean isNsfw, boolean isAnyoneUsingVideo, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel, GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        return new ChannelListItemVoiceChannel(channel, textSelected, voiceSelected, permission, mentionCount, isUnread, numUsersConnected, isLocked, isNsfw, isAnyoneUsingVideo, guildMaxVideoChannelUsers, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel, guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemVoiceChannel)) {
            return false;
        }
        ChannelListItemVoiceChannel channelListItemVoiceChannel = (ChannelListItemVoiceChannel) other;
        return m.areEqual(getChannel(), channelListItemVoiceChannel.getChannel()) && this.textSelected == channelListItemVoiceChannel.textSelected && this.voiceSelected == channelListItemVoiceChannel.voiceSelected && m.areEqual(this.permission, channelListItemVoiceChannel.permission) && getMentionCount() == channelListItemVoiceChannel.getMentionCount() && getIsUnread() == channelListItemVoiceChannel.getIsUnread() && getNumUsersConnected() == channelListItemVoiceChannel.getNumUsersConnected() && this.isLocked == channelListItemVoiceChannel.isLocked && this.isNsfw == channelListItemVoiceChannel.isNsfw && this.isAnyoneUsingVideo == channelListItemVoiceChannel.isAnyoneUsingVideo && m.areEqual(this.guildMaxVideoChannelUsers, channelListItemVoiceChannel.guildMaxVideoChannelUsers) && this.isGuildRoleSubscriptionLockedChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionChannel && m.areEqual(this.guildScheduledEvent, channelListItemVoiceChannel.guildScheduledEvent);
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public Channel getChannel() {
        return this.channel;
    }

    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getTextSelected() {
        return this.textSelected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final boolean getVoiceSelected() {
        return this.voiceSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.textSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.voiceSelected;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        Long l = this.permission;
        int mentionCount = (getMentionCount() + ((i4 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        boolean isUnread = getIsUnread();
        int i5 = isUnread;
        if (isUnread) {
            i5 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((mentionCount + i5) * 31)) * 31;
        boolean z4 = this.isLocked;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (numUsersConnected + i6) * 31;
        boolean z5 = this.isNsfw;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.isAnyoneUsingVideo;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelUsers;
        int iHashCode2 = (i11 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        boolean z7 = this.isGuildRoleSubscriptionLockedChannel;
        int i12 = z7;
        if (z7 != 0) {
            i12 = 1;
        }
        int i13 = (iHashCode2 + i12) * 31;
        boolean z8 = this.isGuildRoleSubscriptionChannel;
        int i14 = (i13 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return i14 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public final boolean isAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    public final boolean isGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final boolean isGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isNsfw() {
        return this.isNsfw;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelListItemVoiceChannel(channel=");
        sbU.append(getChannel());
        sbU.append(", textSelected=");
        sbU.append(this.textSelected);
        sbU.append(", voiceSelected=");
        sbU.append(this.voiceSelected);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", numUsersConnected=");
        sbU.append(getNumUsersConnected());
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", isNsfw=");
        sbU.append(this.isNsfw);
        sbU.append(", isAnyoneUsingVideo=");
        sbU.append(this.isAnyoneUsingVideo);
        sbU.append(", guildMaxVideoChannelUsers=");
        sbU.append(this.guildMaxVideoChannelUsers);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        sbU.append(this.isGuildRoleSubscriptionChannel);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
