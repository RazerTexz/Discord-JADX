package com.discord.widgets.channels.list.items;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.m;

/* compiled from: ChannelListItemThread.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemThread implements ChannelListItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final boolean isLocked;
    private final boolean isUnread;
    private final int mentionCount;
    private final boolean muted;
    private final boolean selected;
    private WidgetChannelListModel.ThreadSpineType spineType;
    private final int type;

    public ChannelListItemThread(Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.mentionCount = i;
        this.isUnread = z3;
        this.isLocked = z4;
        this.muted = z5;
        this.spineType = WidgetChannelListModel.ThreadSpineType.Single.INSTANCE;
        this.type = 12;
    }

    public static /* synthetic */ ChannelListItemThread copy$default(ChannelListItemThread channelListItemThread, Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemThread.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = channelListItemThread.selected;
        }
        boolean z6 = z2;
        if ((i2 & 4) != 0) {
            i = channelListItemThread.getMentionCount();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z3 = channelListItemThread.getIsUnread();
        }
        boolean z7 = z3;
        if ((i2 & 16) != 0) {
            z4 = channelListItemThread.isLocked;
        }
        boolean z8 = z4;
        if ((i2 & 32) != 0) {
            z5 = channelListItemThread.muted;
        }
        return channelListItemThread.copy(channel, z6, i3, z7, z8, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final int component3() {
        return getMentionCount();
    }

    public final boolean component4() {
        return getIsUnread();
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    public final ChannelListItemThread copy(Channel channel, boolean selected, int mentionCount, boolean isUnread, boolean isLocked, boolean muted) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelListItemThread(channel, selected, mentionCount, isUnread, isLocked, muted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemThread)) {
            return false;
        }
        ChannelListItemThread channelListItemThread = (ChannelListItemThread) other;
        return m.areEqual(this.channel, channelListItemThread.channel) && this.selected == channelListItemThread.selected && getMentionCount() == channelListItemThread.getMentionCount() && getIsUnread() == channelListItemThread.getIsUnread() && this.isLocked == channelListItemThread.isLocked && this.muted == channelListItemThread.muted;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(this.channel.getId());
        sb.append(this.spineType);
        sb.append(this.muted);
        return sb.toString();
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final WidgetChannelListModel.ThreadSpineType getSpineType() {
        return this.spineType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
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
        int mentionCount = (getMentionCount() + ((iHashCode + i) * 31)) * 31;
        boolean isUnread = getIsUnread();
        int i2 = isUnread;
        if (isUnread) {
            i2 = 1;
        }
        int i3 = (mentionCount + i2) * 31;
        boolean z3 = this.isLocked;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.muted;
        return i5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public final void setSpineType(WidgetChannelListModel.ThreadSpineType threadSpineType) {
        m.checkNotNullParameter(threadSpineType, "<set-?>");
        this.spineType = threadSpineType;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelListItemThread(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", muted=");
        return a.O(sbU, this.muted, ")");
    }
}
