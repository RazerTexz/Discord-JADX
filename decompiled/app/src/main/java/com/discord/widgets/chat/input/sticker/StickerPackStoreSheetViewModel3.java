package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel3<T1, T2, T3, R> implements Func3<StoreStickers.StickerPackState, Integer, MeUser, StickerPackStoreSheetViewModel.StoreState> {
    public static final StickerPackStoreSheetViewModel3 INSTANCE = new StickerPackStoreSheetViewModel3();

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, Integer num, MeUser meUser) {
        return call(stickerPackState, num.intValue(), meUser);
    }

    public final StickerPackStoreSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, int i, MeUser meUser) {
        Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new StickerPackStoreSheetViewModel.StoreState(stickerPackState, i, meUser);
    }
}
