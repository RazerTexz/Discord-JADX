package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: GifCategoryViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifCategoryViewModel2<T, R> implements Func1<List<? extends ModelGif>, GifCategoryViewModel.StoreState> {
    public static final GifCategoryViewModel2 INSTANCE = new GifCategoryViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ GifCategoryViewModel.StoreState call(List<? extends ModelGif> list) {
        return call2((List<ModelGif>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GifCategoryViewModel.StoreState call2(List<ModelGif> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "gifs");
        return new GifCategoryViewModel.StoreState(list);
    }
}
