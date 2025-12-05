package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceBlockedBottomSheet3(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetStageAudienceBlockedBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
