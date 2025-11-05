package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;

/* compiled from: ReactionsEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class ReactionsEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final boolean canAddReactions;
    private final boolean canCreateReactions;
    private final String key;
    private final Message message;
    private final int type;

    public ReactionsEntry(Message message, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.canAddReactions = z2;
        this.canCreateReactions = z3;
        this.animateEmojis = z4;
        this.type = 4;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }

    public static /* synthetic */ ReactionsEntry copy$default(ReactionsEntry reactionsEntry, Message message, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            message = reactionsEntry.message;
        }
        if ((i & 2) != 0) {
            z2 = reactionsEntry.canAddReactions;
        }
        if ((i & 4) != 0) {
            z3 = reactionsEntry.canCreateReactions;
        }
        if ((i & 8) != 0) {
            z4 = reactionsEntry.animateEmojis;
        }
        return reactionsEntry.copy(message, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanCreateReactions() {
        return this.canCreateReactions;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final ReactionsEntry copy(Message message, boolean canAddReactions, boolean canCreateReactions, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return new ReactionsEntry(message, canAddReactions, canCreateReactions, animateEmojis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReactionsEntry)) {
            return false;
        }
        ReactionsEntry reactionsEntry = (ReactionsEntry) other;
        return Intrinsics3.areEqual(this.message, reactionsEntry.message) && this.canAddReactions == reactionsEntry.canAddReactions && this.canCreateReactions == reactionsEntry.canCreateReactions && this.animateEmojis == reactionsEntry.animateEmojis;
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    public final boolean getCanCreateReactions() {
        return this.canCreateReactions;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        boolean z2 = this.canAddReactions;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.canCreateReactions;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.animateEmojis;
        return i4 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReactionsEntry(message=");
        sbU.append(this.message);
        sbU.append(", canAddReactions=");
        sbU.append(this.canAddReactions);
        sbU.append(", canCreateReactions=");
        sbU.append(this.canCreateReactions);
        sbU.append(", animateEmojis=");
        return outline.O(sbU, this.animateEmojis, ")");
    }
}
