package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.AutocompleteStickerItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatInputAutocompleteStickerAdapter2 implements MGRecyclerDataPayload {
    public static final int TYPE = 0;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public WidgetChatInputAutocompleteStickerAdapter2(Sticker sticker, String str, int i) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(str, "key");
        this.sticker = sticker;
        this.key = str;
        this.type = i;
    }

    public static /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2 copy$default(WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2, Sticker sticker, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = widgetChatInputAutocompleteStickerAdapter2.sticker;
        }
        if ((i2 & 2) != 0) {
            str = widgetChatInputAutocompleteStickerAdapter2.getKey();
        }
        if ((i2 & 4) != 0) {
            i = widgetChatInputAutocompleteStickerAdapter2.getType();
        }
        return widgetChatInputAutocompleteStickerAdapter2.copy(sticker, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    public final String component2() {
        return getKey();
    }

    public final int component3() {
        return getType();
    }

    public final WidgetChatInputAutocompleteStickerAdapter2 copy(Sticker sticker, String key, int type) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(key, "key");
        return new WidgetChatInputAutocompleteStickerAdapter2(sticker, key, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputAutocompleteStickerAdapter2)) {
            return false;
        }
        WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2 = (WidgetChatInputAutocompleteStickerAdapter2) other;
        return Intrinsics3.areEqual(this.sticker, widgetChatInputAutocompleteStickerAdapter2.sticker) && Intrinsics3.areEqual(getKey(), widgetChatInputAutocompleteStickerAdapter2.getKey()) && getType() == widgetChatInputAutocompleteStickerAdapter2.getType();
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
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        String key = getKey();
        return getType() + ((iHashCode + (key != null ? key.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AutocompleteStickerItem(sticker=");
        sbM833U.append(this.sticker);
        sbM833U.append(", key=");
        sbM833U.append(getKey());
        sbM833U.append(", type=");
        sbM833U.append(getType());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2(Sticker sticker, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sticker, (i2 & 2) != 0 ? String.valueOf(sticker.getId()) : str, (i2 & 4) != 0 ? 0 : i);
    }
}
