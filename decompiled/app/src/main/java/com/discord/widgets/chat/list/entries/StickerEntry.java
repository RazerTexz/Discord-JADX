package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.sticker.BaseSticker;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;

/* compiled from: StickerEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class StickerEntry extends ChatListEntry {
    private final String key;
    private final Message message;
    private final BaseSticker sticker;
    private final int type;

    public StickerEntry(Message message, BaseSticker baseSticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
        this.message = message;
        this.sticker = baseSticker;
        this.type = 31;
        this.key = getType() + " -- " + message.getId() + " -- " + baseSticker.getId();
    }

    public static /* synthetic */ StickerEntry copy$default(StickerEntry stickerEntry, Message message, BaseSticker baseSticker, int i, Object obj) {
        if ((i & 1) != 0) {
            message = stickerEntry.message;
        }
        if ((i & 2) != 0) {
            baseSticker = stickerEntry.sticker;
        }
        return stickerEntry.copy(message, baseSticker);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final BaseSticker getSticker() {
        return this.sticker;
    }

    public final StickerEntry copy(Message message, BaseSticker sticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        return new StickerEntry(message, sticker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerEntry)) {
            return false;
        }
        StickerEntry stickerEntry = (StickerEntry) other;
        return Intrinsics3.areEqual(this.message, stickerEntry.message) && Intrinsics3.areEqual(this.sticker, stickerEntry.sticker);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final BaseSticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        BaseSticker baseSticker = this.sticker;
        return iHashCode + (baseSticker != null ? baseSticker.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerEntry(message=");
        sbU.append(this.message);
        sbU.append(", sticker=");
        sbU.append(this.sticker);
        sbU.append(")");
        return sbU.toString();
    }
}
