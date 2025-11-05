package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import rx.Observable;

/* compiled from: SettingsGiftingViewModel.kt */
/* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGiftingViewModel2<T, R> implements Func1<Long, Observable<? extends List<? extends ModelGift>>> {
    public static final SettingsGiftingViewModel2 INSTANCE = new SettingsGiftingViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends ModelGift>> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<ModelGift>> call2(Long l) {
        StoreGifting gifting = StoreStream.INSTANCE.getGifting();
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        return gifting.getMyResolvedGifts(l.longValue());
    }
}
