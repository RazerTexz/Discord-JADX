package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetStageAudienceNoticeBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceNoticeBottomSheet3(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceNoticeBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetStageAudienceNoticeBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
