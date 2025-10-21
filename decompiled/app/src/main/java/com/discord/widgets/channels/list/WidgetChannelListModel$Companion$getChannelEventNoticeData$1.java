package com.discord.widgets.channels.list;

import com.discord.widgets.stage.model.StageChannel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelListModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getChannelEventNoticeData$1 extends Lambda implements Function1<StageChannel, Boolean> {
    public static final WidgetChannelListModel$Companion$getChannelEventNoticeData$1 INSTANCE = new WidgetChannelListModel$Companion$getChannelEventNoticeData$1();

    public WidgetChannelListModel$Companion$getChannelEventNoticeData$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageChannel stageChannel) {
        return Boolean.valueOf(invoke2(stageChannel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageChannel stageChannel) {
        Intrinsics3.checkNotNullParameter(stageChannel, "it");
        return stageChannel.getCanAccess() && stageChannel.getHasActiveStageInstance() && !stageChannel.getContainsMe();
    }
}
