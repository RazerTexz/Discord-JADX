package com.discord.widgets.voice.fullscreen;

import android.view.View;
import com.discord.widgets.voice.controls.VoiceControlsSheetSwipeTooltip;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$bottomSheetCallback$1 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$bottomSheetCallback$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        WidgetCallFullscreen.access$getBinding$p(this.this$0).f15782y.handleSheetState(newState);
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).handleBottomSheetState(newState);
        if (newState == 3) {
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).stopIdle();
            WidgetCallFullscreen.access$getTooltipManager$p(this.this$0).m8512a(VoiceControlsSheetSwipeTooltip.INSTANCE);
        } else {
            if (newState != 4) {
                return;
            }
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).startIdle();
        }
    }
}
