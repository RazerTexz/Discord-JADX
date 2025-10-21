package com.discord.widgets.stage.sheet;

import android.widget.CompoundButton;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;

/* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet5 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    public WidgetStageRaisedHandsBottomSheet5(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        this.this$0 = widgetStageRaisedHandsBottomSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(this.this$0).setRequestToSpeakEnabled(z2);
    }
}
