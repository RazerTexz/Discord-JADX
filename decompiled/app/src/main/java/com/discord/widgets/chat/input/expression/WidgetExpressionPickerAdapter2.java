package com.discord.widgets.chat.input.expression;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetExpressionPickerAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$onScrollPositionListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter2 extends Lambda implements Function1<Integer, Unit> {
    public static final WidgetExpressionPickerAdapter2 INSTANCE = new WidgetExpressionPickerAdapter2();

    public WidgetExpressionPickerAdapter2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
    }
}
