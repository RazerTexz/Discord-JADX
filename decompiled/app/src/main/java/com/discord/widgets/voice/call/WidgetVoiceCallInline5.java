package com.discord.widgets.voice.call;

import com.discord.databinding.WidgetVoiceCallInlineBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetVoiceCallInline.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$binding$3, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline5 extends FunctionReferenceImpl implements Function1<WidgetVoiceCallInlineBinding, Unit> {
    public WidgetVoiceCallInline5(WidgetVoiceCallInline widgetVoiceCallInline) {
        super(1, widgetVoiceCallInline, WidgetVoiceCallInline.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetVoiceCallInlineBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        invoke2(widgetVoiceCallInlineBinding);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        Intrinsics3.checkNotNullParameter(widgetVoiceCallInlineBinding, "p1");
        WidgetVoiceCallInline.access$onViewBindingDestroy((WidgetVoiceCallInline) this.receiver, widgetVoiceCallInlineBinding);
    }
}
