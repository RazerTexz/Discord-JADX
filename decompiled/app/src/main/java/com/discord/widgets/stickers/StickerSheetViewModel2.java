package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.widgets.stickers.StickerSheetViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: StickerSheetViewModel.kt */
/* renamed from: com.discord.widgets.stickers.StickerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StickerSheetViewModel2<T1, T2, R> implements Func2<StoreStickers.StickerPackState, MeUser, StickerSheetViewModel.StoreState> {
    public static final StickerSheetViewModel2 INSTANCE = new StickerSheetViewModel2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ StickerSheetViewModel.StoreState call(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
        return call2(stickerPackState, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StickerSheetViewModel.StoreState call2(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
        Intrinsics3.checkNotNullParameter(stickerPackState, "stickerPack");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new StickerSheetViewModel.StoreState(stickerPackState, meUser);
    }
}
