package com.discord.api.message.reaction;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MessageReactionEmoji.kt */
/* loaded from: classes.dex */
public final /* data */ class MessageReactionEmoji {
    private final boolean animated;
    private final String id;
    private final String name;

    public MessageReactionEmoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.animated = z2;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c */
    public final String m8116c() {
        String str = this.id;
        if (str != null) {
            return str;
        }
        String str2 = this.name;
        Intrinsics3.checkNotNull(str2);
        return str2;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e */
    public final boolean m8118e() {
        return this.id != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageReactionEmoji)) {
            return false;
        }
        MessageReactionEmoji messageReactionEmoji = (MessageReactionEmoji) other;
        return Intrinsics3.areEqual(this.id, messageReactionEmoji.id) && Intrinsics3.areEqual(this.name, messageReactionEmoji.name) && this.animated == messageReactionEmoji.animated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.animated;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("MessageReactionEmoji(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", animated=");
        return outline.m827O(sbM833U, this.animated, ")");
    }
}
