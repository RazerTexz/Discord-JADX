package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet5 extends Lambda implements Function0<StageAudienceBlockedBottomSheetViewModel> {
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceBlockedBottomSheet5(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StageAudienceBlockedBottomSheetViewModel invoke() {
        return new StageAudienceBlockedBottomSheetViewModel(WidgetStageAudienceBlockedBottomSheet.access$getChannelId$p(this.this$0), null, 2, null);
    }
}
