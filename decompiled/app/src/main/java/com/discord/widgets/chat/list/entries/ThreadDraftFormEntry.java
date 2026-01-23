package com.discord.widgets.chat.list.entries;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ThreadDraftFormEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
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
        Intrinsics3.checkNotNullParameter(channel, "parentChannel");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
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
        StringBuilder sbM833U = outline.m833U("37");
        sbM833U.append(channel.getId());
        sbM833U.append(l);
        this.key = sbM833U.toString();
    }

    public static /* synthetic */ ThreadDraftFormEntry copy$default(ThreadDraftFormEntry threadDraftFormEntry, Channel channel, Long l, long j, Guild guild, Integer num, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return threadDraftFormEntry.copy((i & 1) != 0 ? threadDraftFormEntry.parentChannel : channel, (i & 2) != 0 ? threadDraftFormEntry.parentMessageId : l, (i & 4) != 0 ? threadDraftFormEntry.guildId : j, (i & 8) != 0 ? threadDraftFormEntry.guild : guild, (i & 16) != 0 ? threadDraftFormEntry.defaultAutoArchiveDuration : num, (i & 32) != 0 ? threadDraftFormEntry.threadDraftState : threadDraftState, (i & 64) != 0 ? threadDraftFormEntry.canCreatePrivateThread : z2, (i & 128) != 0 ? threadDraftFormEntry.canSeePrivateThreadOption : z3, (i & 256) != 0 ? threadDraftFormEntry.canCreatePublicThread : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanCreatePrivateThread() {
        return this.canCreatePrivateThread;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanSeePrivateThreadOption() {
        return this.canSeePrivateThreadOption;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanCreatePublicThread() {
        return this.canCreatePublicThread;
    }

    public final ThreadDraftFormEntry copy(Channel parentChannel, Long parentMessageId, long guildId, Guild guild, Integer defaultAutoArchiveDuration, StoreThreadDraft.ThreadDraftState threadDraftState, boolean canCreatePrivateThread, boolean canSeePrivateThreadOption, boolean canCreatePublicThread) {
        Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
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
        return Intrinsics3.areEqual(this.parentChannel, threadDraftFormEntry.parentChannel) && Intrinsics3.areEqual(this.parentMessageId, threadDraftFormEntry.parentMessageId) && this.guildId == threadDraftFormEntry.guildId && Intrinsics3.areEqual(this.guild, threadDraftFormEntry.guild) && Intrinsics3.areEqual(this.defaultAutoArchiveDuration, threadDraftFormEntry.defaultAutoArchiveDuration) && Intrinsics3.areEqual(this.threadDraftState, threadDraftFormEntry.threadDraftState) && this.canCreatePrivateThread == threadDraftFormEntry.canCreatePrivateThread && this.canSeePrivateThreadOption == threadDraftFormEntry.canSeePrivateThreadOption && this.canCreatePublicThread == threadDraftFormEntry.canCreatePublicThread;
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
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        Channel channel = this.parentChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Long l = this.parentMessageId;
        int iM3a = (C0002b.m3a(this.guildId) + ((iHashCode + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iM3a + (guild != null ? guild.hashCode() : 0)) * 31;
        Integer num = this.defaultAutoArchiveDuration;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
        int iHashCode4 = (iHashCode3 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
        boolean z2 = this.canCreatePrivateThread;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode4 + r0) * 31;
        boolean z3 = this.canSeePrivateThreadOption;
        ?? r02 = z3;
        if (z3) {
            r02 = 1;
        }
        int i2 = (i + r02) * 31;
        boolean z4 = this.canCreatePublicThread;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ThreadDraftFormEntry(parentChannel=");
        sbM833U.append(this.parentChannel);
        sbM833U.append(", parentMessageId=");
        sbM833U.append(this.parentMessageId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", defaultAutoArchiveDuration=");
        sbM833U.append(this.defaultAutoArchiveDuration);
        sbM833U.append(", threadDraftState=");
        sbM833U.append(this.threadDraftState);
        sbM833U.append(", canCreatePrivateThread=");
        sbM833U.append(this.canCreatePrivateThread);
        sbM833U.append(", canSeePrivateThreadOption=");
        sbM833U.append(this.canSeePrivateThreadOption);
        sbM833U.append(", canCreatePublicThread=");
        return outline.m827O(sbM833U, this.canCreatePublicThread, ")");
    }
}
