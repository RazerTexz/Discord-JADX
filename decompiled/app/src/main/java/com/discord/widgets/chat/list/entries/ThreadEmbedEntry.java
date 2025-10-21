package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* compiled from: ThreadEmbedEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class ThreadEmbedEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final String key;
    private final long messageId;
    private final Message mostRecentMessage;
    private final GuildMember mostRecentMessageGuildMember;
    private final Map<Long, String> nickOrUsernames;
    private final Message parentMessage;
    private final Map<Long, GuildRole> roleMentions;
    private final Channel thread;
    private final int threadMessageCount;
    private final int type;

    public ThreadEmbedEntry(long j, Channel channel, int i, Message message, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, GuildMember guildMember, Message message2) {
        Intrinsics3.checkNotNullParameter(channel, "thread");
        Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
        Intrinsics3.checkNotNullParameter(message2, "parentMessage");
        this.messageId = j;
        this.thread = channel;
        this.threadMessageCount = i;
        this.mostRecentMessage = message;
        this.roleMentions = map;
        this.nickOrUsernames = map2;
        this.animateEmojis = z2;
        this.mostRecentMessageGuildMember = guildMember;
        this.parentMessage = message2;
        this.type = 35;
        this.key = outline.t("35 -- ", j);
    }

    public static /* synthetic */ ThreadEmbedEntry copy$default(ThreadEmbedEntry threadEmbedEntry, long j, Channel channel, int i, Message message, Map map, Map map2, boolean z2, GuildMember guildMember, Message message2, int i2, Object obj) {
        return threadEmbedEntry.copy((i2 & 1) != 0 ? threadEmbedEntry.messageId : j, (i2 & 2) != 0 ? threadEmbedEntry.thread : channel, (i2 & 4) != 0 ? threadEmbedEntry.threadMessageCount : i, (i2 & 8) != 0 ? threadEmbedEntry.mostRecentMessage : message, (i2 & 16) != 0 ? threadEmbedEntry.roleMentions : map, (i2 & 32) != 0 ? threadEmbedEntry.nickOrUsernames : map2, (i2 & 64) != 0 ? threadEmbedEntry.animateEmojis : z2, (i2 & 128) != 0 ? threadEmbedEntry.mostRecentMessageGuildMember : guildMember, (i2 & 256) != 0 ? threadEmbedEntry.parentMessage : message2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component2, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    /* renamed from: component3, reason: from getter */
    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roleMentions;
    }

    public final Map<Long, String> component6() {
        return this.nickOrUsernames;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    /* renamed from: component8, reason: from getter */
    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    /* renamed from: component9, reason: from getter */
    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final ThreadEmbedEntry copy(long messageId, Channel thread, int threadMessageCount, Message mostRecentMessage, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, GuildMember mostRecentMessageGuildMember, Message parentMessage) {
        Intrinsics3.checkNotNullParameter(thread, "thread");
        Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        Intrinsics3.checkNotNullParameter(parentMessage, "parentMessage");
        return new ThreadEmbedEntry(messageId, thread, threadMessageCount, mostRecentMessage, roleMentions, nickOrUsernames, animateEmojis, mostRecentMessageGuildMember, parentMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadEmbedEntry)) {
            return false;
        }
        ThreadEmbedEntry threadEmbedEntry = (ThreadEmbedEntry) other;
        return this.messageId == threadEmbedEntry.messageId && Intrinsics3.areEqual(this.thread, threadEmbedEntry.thread) && this.threadMessageCount == threadEmbedEntry.threadMessageCount && Intrinsics3.areEqual(this.mostRecentMessage, threadEmbedEntry.mostRecentMessage) && Intrinsics3.areEqual(this.roleMentions, threadEmbedEntry.roleMentions) && Intrinsics3.areEqual(this.nickOrUsernames, threadEmbedEntry.nickOrUsernames) && this.animateEmojis == threadEmbedEntry.animateEmojis && Intrinsics3.areEqual(this.mostRecentMessageGuildMember, threadEmbedEntry.mostRecentMessageGuildMember) && Intrinsics3.areEqual(this.parentMessage, threadEmbedEntry.parentMessage);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final Map<Long, GuildRole> getRoleMentions() {
        return this.roleMentions;
    }

    public final Channel getThread() {
        return this.thread;
    }

    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.messageId) * 31;
        Channel channel = this.thread;
        int iHashCode = (((iA + (channel != null ? channel.hashCode() : 0)) * 31) + this.threadMessageCount) * 31;
        Message message = this.mostRecentMessage;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roleMentions;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        GuildMember guildMember = this.mostRecentMessageGuildMember;
        int iHashCode5 = (i2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Message message2 = this.parentMessage;
        return iHashCode5 + (message2 != null ? message2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadEmbedEntry(messageId=");
        sbU.append(this.messageId);
        sbU.append(", thread=");
        sbU.append(this.thread);
        sbU.append(", threadMessageCount=");
        sbU.append(this.threadMessageCount);
        sbU.append(", mostRecentMessage=");
        sbU.append(this.mostRecentMessage);
        sbU.append(", roleMentions=");
        sbU.append(this.roleMentions);
        sbU.append(", nickOrUsernames=");
        sbU.append(this.nickOrUsernames);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", mostRecentMessageGuildMember=");
        sbU.append(this.mostRecentMessageGuildMember);
        sbU.append(", parentMessage=");
        sbU.append(this.parentMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
