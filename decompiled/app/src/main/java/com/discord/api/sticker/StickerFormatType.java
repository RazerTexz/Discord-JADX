package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerFormatType.kt */
/* loaded from: classes.dex */
public enum StickerFormatType {
    UNKNOWN(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: StickerFormatType.kt */
    public static final class Companion {
        public Companion() {
        }

        public final StickerFormatType a(int i) {
            StickerFormatType stickerFormatType;
            StickerFormatType[] stickerFormatTypeArrValues = StickerFormatType.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    stickerFormatType = null;
                    break;
                }
                stickerFormatType = stickerFormatTypeArrValues[i2];
                if (stickerFormatType.getApiValue() == i) {
                    break;
                }
                i2++;
            }
            return stickerFormatType != null ? stickerFormatType : StickerFormatType.UNKNOWN;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerFormatType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
