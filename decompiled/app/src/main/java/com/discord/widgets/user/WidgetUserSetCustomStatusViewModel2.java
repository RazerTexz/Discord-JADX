package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import d0.z.d.Intrinsics3;
import rx.functions.Func2;

/* compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel2<T1, T2, R> implements Func2<ModelCustomStatusSetting, EmojiSet, WidgetUserSetCustomStatusViewModel.StoreState> {
    public static final WidgetUserSetCustomStatusViewModel2 INSTANCE = new WidgetUserSetCustomStatusViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetUserSetCustomStatusViewModel.StoreState call(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        return call2(modelCustomStatusSetting, emojiSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserSetCustomStatusViewModel.StoreState call2(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        Intrinsics3.checkNotNullExpressionValue(modelCustomStatusSetting, "customStatusSetting");
        Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new WidgetUserSetCustomStatusViewModel.StoreState(modelCustomStatusSetting, emojiSet);
    }
}
