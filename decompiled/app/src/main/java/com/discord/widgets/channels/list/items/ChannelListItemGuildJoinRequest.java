package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;

/* compiled from: ChannelListItemGuildJoinRequest.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemGuildJoinRequest implements ChannelListItem {
    private final GuildJoinRequest guildJoinRequest;
    private final String key;
    private final GuildMember member;
    private final int type;

    public ChannelListItemGuildJoinRequest(GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildJoinRequest, "guildJoinRequest");
        Intrinsics3.checkNotNullParameter(guildMember, "member");
        this.guildJoinRequest = guildJoinRequest;
        this.member = guildMember;
        this.type = 22;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ ChannelListItemGuildJoinRequest copy$default(ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest, GuildJoinRequest guildJoinRequest, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            guildJoinRequest = channelListItemGuildJoinRequest.guildJoinRequest;
        }
        if ((i & 2) != 0) {
            guildMember = channelListItemGuildJoinRequest.member;
        }
        return channelListItemGuildJoinRequest.copy(guildJoinRequest, guildMember);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    public final ChannelListItemGuildJoinRequest copy(GuildJoinRequest guildJoinRequest, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildJoinRequest, "guildJoinRequest");
        Intrinsics3.checkNotNullParameter(member, "member");
        return new ChannelListItemGuildJoinRequest(guildJoinRequest, member);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemGuildJoinRequest)) {
            return false;
        }
        ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest = (ChannelListItemGuildJoinRequest) other;
        return Intrinsics3.areEqual(this.guildJoinRequest, channelListItemGuildJoinRequest.guildJoinRequest) && Intrinsics3.areEqual(this.member, channelListItemGuildJoinRequest.member);
    }

    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        GuildJoinRequest guildJoinRequest = this.guildJoinRequest;
        int iHashCode = (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0) * 31;
        GuildMember guildMember = this.member;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemGuildJoinRequest(guildJoinRequest=");
        sbU.append(this.guildJoinRequest);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }
}
