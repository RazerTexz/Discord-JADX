package com.discord.api.message.reaction;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: MessageReaction.kt */
/* loaded from: classes.dex */
public final /* data */ class MessageReaction {
    private final int count;
    private final MessageReactionEmoji emoji;
    private final boolean me;

    public MessageReaction(int i, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.count = i;
        this.emoji = messageReactionEmoji;
        this.me = z2;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMe() {
        return this.me;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReaction)) {
            return false;
        }
        MessageReaction messageReaction = (MessageReaction) other;
        return this.count == messageReaction.count && Intrinsics3.areEqual(this.emoji, messageReaction.emoji) && this.me == messageReaction.me;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.count * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        int iHashCode = (i + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
        boolean z2 = this.me;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageReaction(count=");
        sbU.append(this.count);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", me=");
        return outline.O(sbU, this.me, ")");
    }
}
