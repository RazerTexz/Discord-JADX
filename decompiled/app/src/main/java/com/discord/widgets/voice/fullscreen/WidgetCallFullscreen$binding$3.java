package com.discord.widgets.voice.fullscreen;

import com.discord.databinding.WidgetCallFullscreenBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$3 extends FunctionReferenceImpl implements Function1<WidgetCallFullscreenBinding, Unit> {
    public WidgetCallFullscreen$binding$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        invoke2(widgetCallFullscreenBinding);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        Intrinsics3.checkNotNullParameter(widgetCallFullscreenBinding, "p1");
        WidgetCallFullscreen.access$onViewBindingDestroy((WidgetCallFullscreen) this.receiver, widgetCallFullscreenBinding);
    }
}
