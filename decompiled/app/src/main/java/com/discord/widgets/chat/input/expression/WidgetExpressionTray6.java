package com.discord.widgets.chat.input.expression;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetExpressionTray.kt */
/* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$pickerSheet$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetExpressionTray6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray6(WidgetExpressionTray widgetExpressionTray) {
        super(0);
        this.this$0 = widgetExpressionTray;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetExpressionTray.access$getFlexInputViewModel$p(this.this$0).hideKeyboard();
    }
}
