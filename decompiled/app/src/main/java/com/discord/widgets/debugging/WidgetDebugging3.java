package com.discord.widgets.debugging;

import android.view.View;
import android.widget.TextView;
import com.discord.widgets.debugging.WidgetDebugging;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetDebugging.kt */
/* renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$Item$onConfigure$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDebugging3 implements View.OnClickListener {
    public final /* synthetic */ WidgetDebugging.Adapter.Item this$0;

    public WidgetDebugging3(WidgetDebugging.Adapter.Item item) {
        this.this$0 = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = WidgetDebugging.Adapter.Item.access$getBinding$p(this.this$0).f2361b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.logMessage");
        TextView textView2 = WidgetDebugging.Adapter.Item.access$getBinding$p(this.this$0).f2361b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.logMessage");
        textView.setMaxLines(textView2.getMaxLines() == Integer.MAX_VALUE ? 2 : Integer.MAX_VALUE);
        this.this$0.itemView.requestLayout();
    }
}
