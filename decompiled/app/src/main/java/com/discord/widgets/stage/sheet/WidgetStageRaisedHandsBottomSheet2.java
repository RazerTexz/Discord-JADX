package com.discord.widgets.stage.sheet;

import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$adapter$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet2 extends Lambda implements Function0<WidgetStageRaisedHandsBottomSheetAdapter> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(0);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageRaisedHandsBottomSheetAdapter invoke() {
        MaxHeightRecyclerView maxHeightRecyclerView = WidgetStageRaisedHandsBottomSheet.access$getBinding$p(this.this$0).f18169e;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.stageRaisedHandsRecycler");
        return new WidgetStageRaisedHandsBottomSheetAdapter(maxHeightRecyclerView);
    }
}
