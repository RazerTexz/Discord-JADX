package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$launchStageFullScreen$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet4 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceBlockedBottomSheet4(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return WidgetStageAudienceBlockedBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean("LAUNCH_FULL_SCREEN");
    }
}
