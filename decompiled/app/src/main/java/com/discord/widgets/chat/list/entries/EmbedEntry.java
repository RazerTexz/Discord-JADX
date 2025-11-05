package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import d0.z.d.m;

/* compiled from: EmbedEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class EmbedEntry extends ChatListEntry {
    private final boolean allowAnimatedEmojis;
    private final boolean autoPlayGifs;
    private final MessageEmbed embed;
    private final int embedIndex;
    private final long guildId;
    private final boolean isBlockedExpanded;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final int type;

    public EmbedEntry(int i, long j, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, boolean z2, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(messageEmbed, "embed");
        this.embedIndex = i;
        this.guildId = j;
        this.message = message;
        this.messageState = state;
        this.embed = messageEmbed;
        this.isBlockedExpanded = z2;
        this.allowAnimatedEmojis = z3;
        this.autoPlayGifs = z4;
        this.isThreadStarterMessage = z5;
        this.type = 21;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ EmbedEntry copy$default(EmbedEntry embedEntry, int i, long j, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        return embedEntry.copy((i2 & 1) != 0 ? embedEntry.embedIndex : i, (i2 & 2) != 0 ? embedEntry.guildId : j, (i2 & 4) != 0 ? embedEntry.message : message, (i2 & 8) != 0 ? embedEntry.messageState : state, (i2 & 16) != 0 ? embedEntry.embed : messageEmbed, (i2 & 32) != 0 ? embedEntry.isBlockedExpanded : z2, (i2 & 64) != 0 ? embedEntry.allowAnimatedEmojis : z3, (i2 & 128) != 0 ? embedEntry.autoPlayGifs : z4, (i2 & 256) != 0 ? embedEntry.isThreadStarterMessage : z5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    /* renamed from: component5, reason: from getter */
    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public final EmbedEntry copy(int embedIndex, long guildId, Message message, StoreMessageState.State messageState, MessageEmbed embed, boolean isBlockedExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(embed, "embed");
        return new EmbedEntry(embedIndex, guildId, message, messageState, embed, isBlockedExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedEntry)) {
            return false;
        }
        EmbedEntry embedEntry = (EmbedEntry) other;
        return this.embedIndex == embedEntry.embedIndex && this.guildId == embedEntry.guildId && m.areEqual(this.message, embedEntry.message) && m.areEqual(this.messageState, embedEntry.messageState) && m.areEqual(this.embed, embedEntry.embed) && this.isBlockedExpanded == embedEntry.isBlockedExpanded && this.allowAnimatedEmojis == embedEntry.allowAnimatedEmojis && this.autoPlayGifs == embedEntry.autoPlayGifs && this.isThreadStarterMessage == embedEntry.isThreadStarterMessage;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.guildId) + (this.embedIndex * 31)) * 31;
        Message message = this.message;
        int iHashCode = (iA + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        MessageEmbed messageEmbed = this.embed;
        int iHashCode3 = (iHashCode2 + (messageEmbed != null ? messageEmbed.hashCode() : 0)) * 31;
        boolean z2 = this.isBlockedExpanded;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.allowAnimatedEmojis;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.autoPlayGifs;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.isThreadStarterMessage;
        return i6 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public final boolean isBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isBlockedExpanded;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmbedEntry(embedIndex=");
        sbU.append(this.embedIndex);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", embed=");
        sbU.append(this.embed);
        sbU.append(", isBlockedExpanded=");
        sbU.append(this.isBlockedExpanded);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", autoPlayGifs=");
        sbU.append(this.autoPlayGifs);
        sbU.append(", isThreadStarterMessage=");
        return a.O(sbU, this.isThreadStarterMessage, ")");
    }
}
