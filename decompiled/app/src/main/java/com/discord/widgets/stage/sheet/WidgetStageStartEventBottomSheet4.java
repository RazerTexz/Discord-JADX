package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet4 extends Lambda implements Function0<WidgetStageStartEventBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet4(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        super(0);
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageStartEventBottomSheetViewModel invoke() {
        return new WidgetStageStartEventBottomSheetViewModel(WidgetStageStartEventBottomSheet.access$getChannelId$p(this.this$0), null, null, null, 14, null);
    }
}
