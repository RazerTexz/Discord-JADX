package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.widgets.channels.list.items.ChannelListItem;

/* compiled from: ChannelListItemInvite.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemInvite implements ChannelListItem {
    private final long guildId;
    private final boolean isHub;
    private final int type;

    public ChannelListItemInvite(long j, boolean z2) {
        this.guildId = j;
        this.isHub = z2;
        this.type = z2 ? 20 : 9;
    }

    public static /* synthetic */ ChannelListItemInvite copy$default(ChannelListItemInvite channelListItemInvite, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = channelListItemInvite.guildId;
        }
        if ((i & 2) != 0) {
            z2 = channelListItemInvite.isHub;
        }
        return channelListItemInvite.copy(j, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsHub() {
        return this.isHub;
    }

    public final ChannelListItemInvite copy(long guildId, boolean isHub) {
        return new ChannelListItemInvite(guildId, isHub);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemInvite)) {
            return false;
        }
        ChannelListItemInvite channelListItemInvite = (ChannelListItemInvite) other;
        return this.guildId == channelListItemInvite.guildId && this.isHub == channelListItemInvite.isHub;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return ChannelListItem.DefaultImpls.getKey(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.isHub;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iA + i;
    }

    public final boolean isHub() {
        return this.isHub;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemInvite(guildId=");
        sbU.append(this.guildId);
        sbU.append(", isHub=");
        return outline.O(sbU, this.isHub, ")");
    }
}
