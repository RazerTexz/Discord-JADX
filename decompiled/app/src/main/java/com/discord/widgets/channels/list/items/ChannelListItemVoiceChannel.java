package com.discord.widgets.channels.list.items;

import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemVoiceChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
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
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
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

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getTextSelected() {
        return this.textSelected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getVoiceSelected() {
        return this.voiceSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
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

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsNsfw() {
        return this.isNsfw;
    }

    public final ChannelListItemVoiceChannel copy(Channel channel, boolean textSelected, boolean voiceSelected, Long permission, int mentionCount, boolean isUnread, int numUsersConnected, boolean isLocked, boolean isNsfw, boolean isAnyoneUsingVideo, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
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
        return Intrinsics3.areEqual(getChannel(), channelListItemVoiceChannel.getChannel()) && this.textSelected == channelListItemVoiceChannel.textSelected && this.voiceSelected == channelListItemVoiceChannel.voiceSelected && Intrinsics3.areEqual(this.permission, channelListItemVoiceChannel.permission) && getMentionCount() == channelListItemVoiceChannel.getMentionCount() && getIsUnread() == channelListItemVoiceChannel.getIsUnread() && getNumUsersConnected() == channelListItemVoiceChannel.getNumUsersConnected() && this.isLocked == channelListItemVoiceChannel.isLocked && this.isNsfw == channelListItemVoiceChannel.isNsfw && this.isAnyoneUsingVideo == channelListItemVoiceChannel.isAnyoneUsingVideo && Intrinsics3.areEqual(this.guildMaxVideoChannelUsers, channelListItemVoiceChannel.guildMaxVideoChannelUsers) && this.isGuildRoleSubscriptionLockedChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionChannel && Intrinsics3.areEqual(this.guildScheduledEvent, channelListItemVoiceChannel.guildScheduledEvent);
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
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.textSelected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.voiceSelected;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i2 = (i + r22) * 31;
        Long l = this.permission;
        int mentionCount = (getMentionCount() + ((i2 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        boolean isUnread = getIsUnread();
        ?? r0 = isUnread;
        if (isUnread) {
            r0 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((mentionCount + r0) * 31)) * 31;
        boolean z4 = this.isLocked;
        ?? r23 = z4;
        if (z4) {
            r23 = 1;
        }
        int i3 = (numUsersConnected + r23) * 31;
        boolean z5 = this.isNsfw;
        ?? r24 = z5;
        if (z5) {
            r24 = 1;
        }
        int i4 = (i3 + r24) * 31;
        boolean z6 = this.isAnyoneUsingVideo;
        ?? r25 = z6;
        if (z6) {
            r25 = 1;
        }
        int i5 = (i4 + r25) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelUsers;
        int iHashCode2 = (i5 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        boolean z7 = this.isGuildRoleSubscriptionLockedChannel;
        ?? r26 = z7;
        if (z7) {
            r26 = 1;
        }
        int i6 = (iHashCode2 + r26) * 31;
        boolean z8 = this.isGuildRoleSubscriptionChannel;
        int i7 = (i6 + (z8 ? 1 : z8)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return i7 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
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
    /* JADX INFO: renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChannelListItemVoiceChannel(channel=");
        sbM833U.append(getChannel());
        sbM833U.append(", textSelected=");
        sbM833U.append(this.textSelected);
        sbM833U.append(", voiceSelected=");
        sbM833U.append(this.voiceSelected);
        sbM833U.append(", permission=");
        sbM833U.append(this.permission);
        sbM833U.append(", mentionCount=");
        sbM833U.append(getMentionCount());
        sbM833U.append(", isUnread=");
        sbM833U.append(getIsUnread());
        sbM833U.append(", numUsersConnected=");
        sbM833U.append(getNumUsersConnected());
        sbM833U.append(", isLocked=");
        sbM833U.append(this.isLocked);
        sbM833U.append(", isNsfw=");
        sbM833U.append(this.isNsfw);
        sbM833U.append(", isAnyoneUsingVideo=");
        sbM833U.append(this.isAnyoneUsingVideo);
        sbM833U.append(", guildMaxVideoChannelUsers=");
        sbM833U.append(this.guildMaxVideoChannelUsers);
        sbM833U.append(", isGuildRoleSubscriptionLockedChannel=");
        sbM833U.append(this.isGuildRoleSubscriptionLockedChannel);
        sbM833U.append(", isGuildRoleSubscriptionChannel=");
        sbM833U.append(this.isGuildRoleSubscriptionChannel);
        sbM833U.append(", guildScheduledEvent=");
        sbM833U.append(this.guildScheduledEvent);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
