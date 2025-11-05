package com.discord.widgets.chat.input.sticker;

import android.view.View;
import d0.z.d.Intrinsics3;

/* compiled from: View.kt */
/* loaded from: classes2.dex */
public final class WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 this$0;

    public WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1(WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1) {
        this.this$0 = widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 = this.this$0;
        widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1.this$0.scrollToPack(Long.valueOf(widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1.$packId$inlined));
    }
}
