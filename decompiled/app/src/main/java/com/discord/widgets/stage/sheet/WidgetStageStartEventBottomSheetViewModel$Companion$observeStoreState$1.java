package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel;
import d0.z.d.m;
import rx.functions.Func2;

/* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<Channel, StageInstance, WidgetStageStartEventBottomSheetViewModel.StoreState> {
    public static final WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetStageStartEventBottomSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetViewModel.StoreState call(Channel channel, StageInstance stageInstance) {
        return call2(channel, stageInstance);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetStageStartEventBottomSheetViewModel.StoreState call2(Channel channel, StageInstance stageInstance) {
        m.checkNotNullExpressionValue(channel, "channel");
        return new WidgetStageStartEventBottomSheetViewModel.StoreState(channel, stageInstance);
    }
}
