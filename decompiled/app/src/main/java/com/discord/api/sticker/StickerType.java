package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerType {
    UNKNOWN(-1),
    STANDARD(1),
    GUILD(2);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: StickerType.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX INFO: renamed from: a */
        public final StickerType m8244a(int i) {
            StickerType stickerType;
            StickerType[] stickerTypeArrValues = StickerType.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    stickerType = null;
                    break;
                }
                stickerType = stickerTypeArrValues[i2];
                if (stickerType.getApiValue() == i) {
                    break;
                }
                i2++;
            }
            return stickerType != null ? stickerType : StickerType.UNKNOWN;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
