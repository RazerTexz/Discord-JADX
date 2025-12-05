package com.discord.widgets.channels.list.items;

import com.discord.api.channel.Channel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChannelListItemDirectory.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemDirectory implements ChannelListItem {
    private final Channel channel;
    private final String key;
    private final boolean selected;
    private final int type;
    private final int unreadCount;

    public ChannelListItemDirectory(Channel channel, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.unreadCount = i;
        this.type = 17;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemDirectory copy$default(ChannelListItemDirectory channelListItemDirectory, Channel channel, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemDirectory.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = channelListItemDirectory.selected;
        }
        if ((i2 & 4) != 0) {
            i = channelListItemDirectory.unreadCount;
        }
        return channelListItemDirectory.copy(channel, z2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final ChannelListItemDirectory copy(Channel channel, boolean selected, int unreadCount) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemDirectory(channel, selected, unreadCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemDirectory)) {
            return false;
        }
        ChannelListItemDirectory channelListItemDirectory = (ChannelListItemDirectory) other;
        return Intrinsics3.areEqual(this.channel, channelListItemDirectory.channel) && this.selected == channelListItemDirectory.selected && this.unreadCount == channelListItemDirectory.unreadCount;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((iHashCode + i) * 31) + this.unreadCount;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChannelListItemDirectory(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", selected=");
        sbM833U.append(this.selected);
        sbM833U.append(", unreadCount=");
        return outline.m814B(sbM833U, this.unreadCount, ")");
    }
}
