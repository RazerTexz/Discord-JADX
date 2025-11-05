package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft;
import d0.z.d.m;

/* compiled from: ThreadDraftFormEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class ThreadDraftFormEntry extends ChatListEntry {
    private final boolean canCreatePrivateThread;
    private final boolean canCreatePublicThread;
    private final boolean canSeePrivateThreadOption;
    private final Integer defaultAutoArchiveDuration;
    private final Guild guild;
    private final long guildId;
    private final String key;
    private final Channel parentChannel;
    private final Long parentMessageId;
    private final StoreThreadDraft.ThreadDraftState threadDraftState;
    private final int type;

    public ThreadDraftFormEntry(Channel channel, Long l, long j, Guild guild, Integer num, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z2, boolean z3, boolean z4) {
        m.checkNotNullParameter(channel, "parentChannel");
        m.checkNotNullParameter(threadDraftState, "threadDraftState");
        this.parentChannel = channel;
        this.parentMessageId = l;
        this.guildId = j;
        this.guild = guild;
        this.defaultAutoArchiveDuration = num;
        this.threadDraftState = threadDraftState;
        this.canCreatePrivateThread = z2;
        this.canSeePrivateThreadOption = z3;
        this.canCreatePublicThread = z4;
        this.type = 37;
        StringBuilder sbU = a.U("37");
        sbU.append(channel.getId());
        sbU.append(l);
        this.key = sbU.toString();
    }

    public static /* synthetic */ ThreadDraftFormEntry copy$default(ThreadDraftFormEntry threadDraftFormEntry, Channel channel, Long l, long j, Guild guild, Integer num, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return threadDraftFormEntry.copy((i & 1) != 0 ? threadDraftFormEntry.parentChannel : channel, (i & 2) != 0 ? threadDraftFormEntry.parentMessageId : l, (i & 4) != 0 ? threadDraftFormEntry.guildId : j, (i & 8) != 0 ? threadDraftFormEntry.guild : guild, (i & 16) != 0 ? threadDraftFormEntry.defaultAutoArchiveDuration : num, (i & 32) != 0 ? threadDraftFormEntry.threadDraftState : threadDraftState, (i & 64) != 0 ? threadDraftFormEntry.canCreatePrivateThread : z2, (i & 128) != 0 ? threadDraftFormEntry.canSeePrivateThreadOption : z3, (i & 256) != 0 ? threadDraftFormEntry.canCreatePublicThread : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanCreatePrivateThread() {
        return this.canCreatePrivateThread;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanSeePrivateThreadOption() {
        return this.canSeePrivateThreadOption;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCanCreatePublicThread() {
        return this.canCreatePublicThread;
    }

    public final ThreadDraftFormEntry copy(Channel parentChannel, Long parentMessageId, long guildId, Guild guild, Integer defaultAutoArchiveDuration, StoreThreadDraft.ThreadDraftState threadDraftState, boolean canCreatePrivateThread, boolean canSeePrivateThreadOption, boolean canCreatePublicThread) {
        m.checkNotNullParameter(parentChannel, "parentChannel");
        m.checkNotNullParameter(threadDraftState, "threadDraftState");
        return new ThreadDraftFormEntry(parentChannel, parentMessageId, guildId, guild, defaultAutoArchiveDuration, threadDraftState, canCreatePrivateThread, canSeePrivateThreadOption, canCreatePublicThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadDraftFormEntry)) {
            return false;
        }
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) other;
        return m.areEqual(this.parentChannel, threadDraftFormEntry.parentChannel) && m.areEqual(this.parentMessageId, threadDraftFormEntry.parentMessageId) && this.guildId == threadDraftFormEntry.guildId && m.areEqual(this.guild, threadDraftFormEntry.guild) && m.areEqual(this.defaultAutoArchiveDuration, threadDraftFormEntry.defaultAutoArchiveDuration) && m.areEqual(this.threadDraftState, threadDraftFormEntry.threadDraftState) && this.canCreatePrivateThread == threadDraftFormEntry.canCreatePrivateThread && this.canSeePrivateThreadOption == threadDraftFormEntry.canSeePrivateThreadOption && this.canCreatePublicThread == threadDraftFormEntry.canCreatePublicThread;
    }

    public final boolean getCanCreatePrivateThread() {
        return this.canCreatePrivateThread;
    }

    public final boolean getCanCreatePublicThread() {
        return this.canCreatePublicThread;
    }

    public final boolean getCanSeePrivateThreadOption() {
        return this.canSeePrivateThreadOption;
    }

    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.parentChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Long l = this.parentMessageId;
        int iA = (b.a(this.guildId) + ((iHashCode + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
        Integer num = this.defaultAutoArchiveDuration;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
        int iHashCode4 = (iHashCode3 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
        boolean z2 = this.canCreatePrivateThread;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.canSeePrivateThreadOption;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canCreatePublicThread;
        return i4 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadDraftFormEntry(parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", parentMessageId=");
        sbU.append(this.parentMessageId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", defaultAutoArchiveDuration=");
        sbU.append(this.defaultAutoArchiveDuration);
        sbU.append(", threadDraftState=");
        sbU.append(this.threadDraftState);
        sbU.append(", canCreatePrivateThread=");
        sbU.append(this.canCreatePrivateThread);
        sbU.append(", canSeePrivateThreadOption=");
        sbU.append(this.canSeePrivateThreadOption);
        sbU.append(", canCreatePublicThread=");
        return a.O(sbU, this.canCreatePublicThread, ")");
    }
}
