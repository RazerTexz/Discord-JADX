package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import d0.z.d.Intrinsics3;

/* compiled from: StickerGreetEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class StickerGreetEntry extends ChatListEntry {
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public StickerGreetEntry(Sticker sticker, long j, String str, int i) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(str, "channelName");
        this.sticker = sticker;
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.type = 41;
        this.key = getType() + " -- " + sticker.getId();
    }

    public static /* synthetic */ StickerGreetEntry copy$default(StickerGreetEntry stickerGreetEntry, Sticker sticker, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerGreetEntry.sticker;
        }
        if ((i2 & 2) != 0) {
            j = stickerGreetEntry.channelId;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = stickerGreetEntry.channelName;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = stickerGreetEntry.channelType;
        }
        return stickerGreetEntry.copy(sticker, j2, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    public final StickerGreetEntry copy(Sticker sticker, long channelId, String channelName, int channelType) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new StickerGreetEntry(sticker, channelId, channelName, channelType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerGreetEntry)) {
            return false;
        }
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) other;
        return Intrinsics3.areEqual(this.sticker, stickerGreetEntry.sticker) && this.channelId == stickerGreetEntry.channelId && Intrinsics3.areEqual(this.channelName, stickerGreetEntry.channelName) && this.channelType == stickerGreetEntry.channelType;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iA = (b.a(this.channelId) + ((sticker != null ? sticker.hashCode() : 0) * 31)) * 31;
        String str = this.channelName;
        return ((iA + (str != null ? str.hashCode() : 0)) * 31) + this.channelType;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerGreetEntry(sticker=");
        sbU.append(this.sticker);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelType=");
        return outline.B(sbU, this.channelType, ")");
    }
}
