package com.discord.utilities;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;

/* compiled from: ShareUtils.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelShortcutInfo {
    private final Channel channel;
    private final boolean isPinnedOnly;
    private final int rank;

    public ChannelShortcutInfo(Channel channel, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.rank = i;
        this.isPinnedOnly = z2;
    }

    public static /* synthetic */ ChannelShortcutInfo copy$default(ChannelShortcutInfo channelShortcutInfo, Channel channel, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelShortcutInfo.channel;
        }
        if ((i2 & 2) != 0) {
            i = channelShortcutInfo.rank;
        }
        if ((i2 & 4) != 0) {
            z2 = channelShortcutInfo.isPinnedOnly;
        }
        return channelShortcutInfo.copy(channel, i, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPinnedOnly() {
        return this.isPinnedOnly;
    }

    public final ChannelShortcutInfo copy(Channel channel, int rank, boolean isPinnedOnly) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelShortcutInfo(channel, rank, isPinnedOnly);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelShortcutInfo)) {
            return false;
        }
        ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) other;
        return Intrinsics3.areEqual(this.channel, channelShortcutInfo.channel) && this.rank == channelShortcutInfo.rank && this.isPinnedOnly == channelShortcutInfo.isPinnedOnly;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final int getRank() {
        return this.rank;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (((channel != null ? channel.hashCode() : 0) * 31) + this.rank) * 31;
        boolean z2 = this.isPinnedOnly;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isPinnedOnly() {
        return this.isPinnedOnly;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelShortcutInfo(channel=");
        sbU.append(this.channel);
        sbU.append(", rank=");
        sbU.append(this.rank);
        sbU.append(", isPinnedOnly=");
        return outline.O(sbU, this.isPinnedOnly, ")");
    }
}
