package com.discord.widgets.chat.input;

import com.discord.databinding.WidgetChatInputBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInput.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInput$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput3 extends FunctionReferenceImpl implements Function1<WidgetChatInputBinding, Unit> {
    public WidgetChatInput3(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChatInputBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatInputBinding widgetChatInputBinding) {
        invoke2(widgetChatInputBinding);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatInputBinding widgetChatInputBinding) {
        Intrinsics3.checkNotNullParameter(widgetChatInputBinding, "p1");
        WidgetChatInput.access$onViewBindingDestroy((WidgetChatInput) this.receiver, widgetChatInputBinding);
    }
}
