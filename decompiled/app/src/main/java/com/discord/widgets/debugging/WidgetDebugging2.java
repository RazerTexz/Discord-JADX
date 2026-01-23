package com.discord.widgets.debugging;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.debugging.WidgetDebugging;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$Item$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetDebugging.Adapter.Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging2(WidgetDebugging.Adapter.Item item) {
        super(1);
        this.this$0 = item;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        Context contextM885x = outline.m885x(this.this$0.itemView, "itemView", "itemView.context");
        TextView textView = WidgetDebugging.Adapter.Item.access$getBinding$p(this.this$0).f16448b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.logMessage");
        CharSequence text = textView.getText();
        Intrinsics3.checkNotNullExpressionValue(text, "binding.logMessage.text");
        AppToast.m165c(contextM885x, text, 0, 4);
    }
}
