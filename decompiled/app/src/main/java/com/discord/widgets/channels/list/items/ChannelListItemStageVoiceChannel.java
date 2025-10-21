package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import d0.z.d.Intrinsics3;

/* compiled from: ChannelListItemStageVoiceChannel.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemStageVoiceChannel implements ChannelListItem, ChannelListVocalItem {
    private final Channel channel;
    private final boolean hasSpeakers;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final String key;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean selected;
    private final StageInstance stageInstance;
    private final int type;

    public ChannelListItemStageVoiceChannel(Channel channel, boolean z2, Long l, boolean z3, int i, StageInstance stageInstance, boolean z4, boolean z5, boolean z6) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.permission = l;
        this.isLocked = z3;
        this.numUsersConnected = i;
        this.stageInstance = stageInstance;
        this.hasSpeakers = z4;
        this.isGuildRoleSubscriptionLockedChannel = z5;
        this.isGuildRoleSubscriptionChannel = z6;
        this.type = 13;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getChannel().getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemStageVoiceChannel copy$default(ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel, Channel channel, boolean z2, Long l, boolean z3, int i, StageInstance stageInstance, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
        return channelListItemStageVoiceChannel.copy((i2 & 1) != 0 ? channelListItemStageVoiceChannel.getChannel() : channel, (i2 & 2) != 0 ? channelListItemStageVoiceChannel.selected : z2, (i2 & 4) != 0 ? channelListItemStageVoiceChannel.permission : l, (i2 & 8) != 0 ? channelListItemStageVoiceChannel.isLocked : z3, (i2 & 16) != 0 ? channelListItemStageVoiceChannel.getNumUsersConnected() : i, (i2 & 32) != 0 ? channelListItemStageVoiceChannel.stageInstance : stageInstance, (i2 & 64) != 0 ? channelListItemStageVoiceChannel.hasSpeakers : z4, (i2 & 128) != 0 ? channelListItemStageVoiceChannel.isGuildRoleSubscriptionLockedChannel : z5, (i2 & 256) != 0 ? channelListItemStageVoiceChannel.isGuildRoleSubscriptionChannel : z6);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final int component5() {
        return getNumUsersConnected();
    }

    /* renamed from: component6, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final ChannelListItemStageVoiceChannel copy(Channel channel, boolean selected, Long permission, boolean isLocked, int numUsersConnected, StageInstance stageInstance, boolean hasSpeakers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemStageVoiceChannel(channel, selected, permission, isLocked, numUsersConnected, stageInstance, hasSpeakers, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemStageVoiceChannel)) {
            return false;
        }
        ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel = (ChannelListItemStageVoiceChannel) other;
        return Intrinsics3.areEqual(getChannel(), channelListItemStageVoiceChannel.getChannel()) && this.selected == channelListItemStageVoiceChannel.selected && Intrinsics3.areEqual(this.permission, channelListItemStageVoiceChannel.permission) && this.isLocked == channelListItemStageVoiceChannel.isLocked && getNumUsersConnected() == channelListItemStageVoiceChannel.getNumUsersConnected() && Intrinsics3.areEqual(this.stageInstance, channelListItemStageVoiceChannel.stageInstance) && this.hasSpeakers == channelListItemStageVoiceChannel.hasSpeakers && this.isGuildRoleSubscriptionLockedChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionChannel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasActiveEvent() {
        return this.stageInstance != null;
    }

    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        Long l = this.permission;
        int iHashCode2 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z3 = this.isLocked;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((iHashCode2 + i3) * 31)) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode3 = (numUsersConnected + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z4 = this.hasSpeakers;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode3 + i4) * 31;
        boolean z5 = this.isGuildRoleSubscriptionLockedChannel;
        int i6 = z5;
        if (z5 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z6 = this.isGuildRoleSubscriptionChannel;
        return i7 + (z6 ? 1 : z6 ? 1 : 0);
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

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemStageVoiceChannel(channel=");
        sbU.append(getChannel());
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", numUsersConnected=");
        sbU.append(getNumUsersConnected());
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", hasSpeakers=");
        sbU.append(this.hasSpeakers);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
