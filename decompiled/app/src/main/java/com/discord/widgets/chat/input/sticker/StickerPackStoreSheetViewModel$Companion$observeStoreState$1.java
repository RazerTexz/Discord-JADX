package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import d0.z.d.m;
import rx.functions.Func3;

/* compiled from: StickerPackStoreSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, R> implements Func3<StoreStickers.StickerPackState, Integer, MeUser, StickerPackStoreSheetViewModel.StoreState> {
    public static final StickerPackStoreSheetViewModel$Companion$observeStoreState$1 INSTANCE = new StickerPackStoreSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, Integer num, MeUser meUser) {
        return call(stickerPackState, num.intValue(), meUser);
    }

    public final StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, int i, MeUser meUser) {
        m.checkNotNullParameter(stickerPackState, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerPackStoreSheetViewModel.StoreState(stickerPackState, i, meUser);
    }
}
