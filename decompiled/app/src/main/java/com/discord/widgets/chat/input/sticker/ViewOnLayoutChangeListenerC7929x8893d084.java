package com.discord.widgets.chat.input.sticker;

import android.view.View;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1 */
/* loaded from: classes2.dex */
public final class ViewOnLayoutChangeListenerC7929x8893d084 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ViewOnLayoutChangeListenerC7928xcd11d8b4 this$0;

    public ViewOnLayoutChangeListenerC7929x8893d084(ViewOnLayoutChangeListenerC7928xcd11d8b4 viewOnLayoutChangeListenerC7928xcd11d8b4) {
        this.this$0 = viewOnLayoutChangeListenerC7928xcd11d8b4;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        ViewOnLayoutChangeListenerC7928xcd11d8b4 viewOnLayoutChangeListenerC7928xcd11d8b4 = this.this$0;
        viewOnLayoutChangeListenerC7928xcd11d8b4.this$0.scrollToPack(Long.valueOf(viewOnLayoutChangeListenerC7928xcd11d8b4.$packId$inlined));
    }
}
