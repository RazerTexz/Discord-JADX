package com.discord.widgets.chat.list.entries;

import com.discord.api.message.attachment.MessageAttachment;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AttachmentEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class AttachmentEntry extends ChatListEntry {
    private final boolean allowAnimatedEmojis;
    private final MessageAttachment attachment;
    private final boolean autoPlayGifs;
    private final int embedIndex;
    private final long guildId;
    private final boolean isBlockedExpanded;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final int type;

    public AttachmentEntry(int i, long j, Message message, StoreMessageState.State state, MessageAttachment messageAttachment, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(messageAttachment, "attachment");
        this.embedIndex = i;
        this.guildId = j;
        this.message = message;
        this.messageState = state;
        this.attachment = messageAttachment;
        this.isBlockedExpanded = z2;
        this.allowAnimatedEmojis = z3;
        this.autoPlayGifs = z4;
        this.isThreadStarterMessage = z5;
        this.type = 28;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ AttachmentEntry copy$default(AttachmentEntry attachmentEntry, int i, long j, Message message, StoreMessageState.State state, MessageAttachment messageAttachment, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        return attachmentEntry.copy((i2 & 1) != 0 ? attachmentEntry.embedIndex : i, (i2 & 2) != 0 ? attachmentEntry.guildId : j, (i2 & 4) != 0 ? attachmentEntry.message : message, (i2 & 8) != 0 ? attachmentEntry.messageState : state, (i2 & 16) != 0 ? attachmentEntry.attachment : messageAttachment, (i2 & 32) != 0 ? attachmentEntry.isBlockedExpanded : z2, (i2 & 64) != 0 ? attachmentEntry.allowAnimatedEmojis : z3, (i2 & 128) != 0 ? attachmentEntry.autoPlayGifs : z4, (i2 & 256) != 0 ? attachmentEntry.isThreadStarterMessage : z5);
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
    public final MessageAttachment getAttachment() {
        return this.attachment;
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

    public final AttachmentEntry copy(int embedIndex, long guildId, Message message, StoreMessageState.State messageState, MessageAttachment attachment, boolean isBlockedExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean isThreadStarterMessage) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        return new AttachmentEntry(embedIndex, guildId, message, messageState, attachment, isBlockedExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentEntry)) {
            return false;
        }
        AttachmentEntry attachmentEntry = (AttachmentEntry) other;
        return this.embedIndex == attachmentEntry.embedIndex && this.guildId == attachmentEntry.guildId && Intrinsics3.areEqual(this.message, attachmentEntry.message) && Intrinsics3.areEqual(this.messageState, attachmentEntry.messageState) && Intrinsics3.areEqual(this.attachment, attachmentEntry.attachment) && this.isBlockedExpanded == attachmentEntry.isBlockedExpanded && this.allowAnimatedEmojis == attachmentEntry.allowAnimatedEmojis && this.autoPlayGifs == attachmentEntry.autoPlayGifs && this.isThreadStarterMessage == attachmentEntry.isThreadStarterMessage;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final MessageAttachment getAttachment() {
        return this.attachment;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
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
        int iM3a = (C0002b.m3a(this.guildId) + (this.embedIndex * 31)) * 31;
        Message message = this.message;
        int iHashCode = (iM3a + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        MessageAttachment messageAttachment = this.attachment;
        int iHashCode3 = (iHashCode2 + (messageAttachment != null ? messageAttachment.hashCode() : 0)) * 31;
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
        StringBuilder sbM833U = outline.m833U("AttachmentEntry(embedIndex=");
        sbM833U.append(this.embedIndex);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", messageState=");
        sbM833U.append(this.messageState);
        sbM833U.append(", attachment=");
        sbM833U.append(this.attachment);
        sbM833U.append(", isBlockedExpanded=");
        sbM833U.append(this.isBlockedExpanded);
        sbM833U.append(", allowAnimatedEmojis=");
        sbM833U.append(this.allowAnimatedEmojis);
        sbM833U.append(", autoPlayGifs=");
        sbM833U.append(this.autoPlayGifs);
        sbM833U.append(", isThreadStarterMessage=");
        return outline.m827O(sbM833U, this.isThreadStarterMessage, ")");
    }
}
