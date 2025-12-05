package com.discord.widgets.chat.input.sticker;

import android.view.View;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$lambda$1 */
/* loaded from: classes2.dex */
public final class ViewOnLayoutChangeListenerC7930x51b4a0b1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ long $packId$inlined;
    public final /* synthetic */ String $searchText$inlined;
    public final /* synthetic */ WidgetStickerPicker this$0;

    public ViewOnLayoutChangeListenerC7930x51b4a0b1(WidgetStickerPicker widgetStickerPicker, String str, long j) {
        this.this$0 = widgetStickerPicker;
        this.$searchText$inlined = str;
        this.$packId$inlined = j;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.this$0.scrollToPack(Long.valueOf(this.$packId$inlined));
    }
}
